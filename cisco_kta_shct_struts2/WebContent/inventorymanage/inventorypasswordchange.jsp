<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />

<div style="position:relative;left:10%">
<form action="/cisco_kta_shct_struts2/inventorymanage/update">
<label>new login username</label><input type="text" class="form-control" name="username"><br>

<label>new login password</label><input type="text" class="form-control" name="password" required="required">
<button type="submit">submit</button>
</form>
</div>

<s:include value="../foot.jsp" />