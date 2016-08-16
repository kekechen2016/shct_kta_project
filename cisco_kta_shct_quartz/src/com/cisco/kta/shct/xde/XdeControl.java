package com.cisco.kta.shct.xde;

import com.cisco.nm.expression.function.FunctionException;
import com.cisco.nm.util.types.Value;
import com.cisco.nm.util.types.ValueUtils;
import com.cisco.nm.workflow.client.XDEException;
import com.cisco.nm.workflow.client.XDEFactory;

import org.json.*;

import org.apache.log4j.Logger;


public class XdeControl {
	private static Logger logger = Logger.getLogger(XdeControl.class);
	private JSONArray jsonarray;
	private JSONObject JSONObject;
	private boolean isError;
	public static void init(String xdeHome) throws XDEException {
		if(XDEFactory.getFunctionRunner() == null){
		XDEFactory.initialize(xdeHome);
		logger.info("xde is initializing !" );}
}
	public static Value runXDE(String packageID, String functionName, Value... paramValues) 
			throws FunctionException {
			if(XDEFactory.getFunctionRunner() == null) {
				throw new FunctionException("XDE.ERROR", "XDE not initialized");
			}
			// Run an XDE invocation, storing the Value result.
			// runFunction(...) will block until the invocation is complete.
			// This could throw a FunctionException.
			Value resultValue = XDEFactory.getFunctionRunner().runFunction(
					packageID, functionName, paramValues);
			// Transform the result Value to a String 
			return resultValue;
		}
	public static void shutdown() {
		// Shutdown XDE stopping all threads, should be done to once to allow the program to terminate
		XDEFactory.dispose();
	}
	public XdeControl(String packageID, String functionName, String[] paramStrings) {
		// Initialize XDE, only needs to be performed once
		for (int i = 0 ; i < 3 ; i++){
			try {
				// Create an array of Values from the array of parameter Strings.
				// Values are the "native" way to pass data in and out of XDE.
				Value[] paramValues = ValueUtils.asValues(paramStrings);
				
				// Call XDE, can be performed many times
				Value runResult = runXDE(packageID, functionName, paramValues);
				if (runResult.asString().matches("\\[.*")){
					jsonarray = new JSONArray(runResult.asString());
				}else{
					JSONObject = new JSONObject(runResult.asString());
				}
				this.isError = false;
				logger.info("xde capture data successfully");
			    break;
			    
			}catch(Exception e){
				this.isError = true;
				logger.error(e.getMessage(),e);
				continue;
			}
		}
		if (this.isError){
		logger.info("xde can not capture data three times");}
		
	}
	public JSONArray toJSONArray(){
		return this.jsonarray;
	}
	public JSONObject getJSONObject() {
		return JSONObject;
	}
	public boolean isError() {
		return isError;
	}
	public void setError(boolean isError) {
		this.isError = isError;
	}

}
