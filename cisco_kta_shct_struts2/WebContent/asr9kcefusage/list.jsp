<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />



<table class="table table-hover">
<tr>
<td>No</td><td>device name</td><td>slot</td><td>used</td><td>max</td><td>percent</td><td>datetime</td><td>trend diagram</td>
</tr>
<s:iterator value="asr9kCefUsageDtoList">
<tr>
<td><s:property value="#this.id" /></td><td><s:property value="#this.device" /></td><td><s:property value="#this.slot" /></td><td><s:property value="#this.used" /></td>
<td><s:property value="#this.max" /></td><td><s:property value="#this.percent" /></td><td><s:property value="#this.datetime" /></td>
<td><a href="/cisco_kta_shct_struts2/asr9kcefusage/linediagram?device=<s:property value="#this.device" />&slot=<s:property value="#this.slot" />">线型图</a></td>
</tr>
</s:iterator>
</table>


<s:include value="../foot.jsp" />