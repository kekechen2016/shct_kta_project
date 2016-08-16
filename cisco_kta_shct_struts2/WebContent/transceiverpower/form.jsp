<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />


<div style="position:relative;left:10%;width:800px">
<form action="result" method="post">
<label>device list:</label>
<p>please select the device you expected to check transceiver</p>
<div>
<ul>
<s:iterator value="inventories">
<s:if test="#this.Devicename.contains('CR') or #this.Devicename.contains('BR') or #this.Devicename.contains('9010') or true">
<li style="display:inline;"><div class="radio" style="float:left;width:250px"><input type="radio" name="device" value=<s:property value="#this.Devicename" /> /><s:property value="#this.Devicename" /></div></li>
</s:if>
</s:iterator>
</ul>
</div>
<div style="clear:both">
<label >port type:</label>
<select name="porttype" class="form-control">
  <option value="tenge">TenGE</option>
  <option value="hunge">HundredGE</option>
  <option value="ge">GE</option>
  <option value="pos">POS</option>  
</select>
</div>
<label>port number:</label>
<input type="text" name="portnumber" class="form-control" placeholder="port number example: 0/0/0/1">

<button style="position:relative" type="submit">submit</button>
</form>
</div>




<s:include value="../foot.jsp" />