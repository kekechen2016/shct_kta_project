<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />





<h3>TransceiverPower</h3>
<span class="label label-default">result:</span>

<table class="table table-hover" style="position:relative;top:20px">
<tr>
<td>模块类型</td><td>序列号</td><td>发光功率</td><td>收光功率</td><td>最小收光功率</td><td>最大收光功率</td>
</tr>
<tr><td><s:property value="Transceiverpower.pid" /></td>
<td><s:property value="Transceiverpower.sn" /></td>
<td><s:iterator value="Transceiverpower.txpower"><s:property /><br></s:iterator></td>
<td><s:iterator value="Transceiverpower.rxpower"><s:property /><br></s:iterator></td>
<td><s:property value="Transceiverpower.minrxpower" /></td>
<td><s:property value="Transceiverpower.maxrxpower" /></td></tr>
</table>




<s:debug></s:debug>


<s:include value="../foot.jsp" />