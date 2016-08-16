<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />



<form action="result" method="post">
<div style="position:relative;left:10%;width:800px">
<label>device list:</label>
<p>please select the device you expected to check CPU utilization</p>
<ul>
<s:iterator value="inventories">
<s:if test="#this.Devicename.contains('7609') or #this.Devicename.contains('M2N.C76')">
<li style="display:inline;"><div class="radio" style="float:left;width:250px"><input type="radio" name="device" value=<s:property value="#this.Devicename" /> /><s:property value="#this.Devicename" /></div></li>
</s:if>
</s:iterator>
</ul>
</div>
<div  style="clear:both;position:relative;left:10%">
<button type="submit">submit</button>
</div>
</form>





<s:include value="../foot.jsp" />