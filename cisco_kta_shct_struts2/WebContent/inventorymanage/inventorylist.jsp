<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />

<div style="position:relative;">
<table class="table table-hover">
<tr>
<td>DeviceName</td>
<td>IP Address</td>
<td>Login Username</td>
<td>Login Password</td>
</tr>
<s:iterator value="inventories">
<tr>
<td><s:property value="#this.Devicename" /></td>
<td><s:property value="#this.IP_Address" /></td>
<td><s:property value="#this.Login_Username" /></td>
<td><s:property value="#this.Login_Password" /></td>
</tr>
</s:iterator>

</table>
</div>

<s:include value="../foot.jsp" />
