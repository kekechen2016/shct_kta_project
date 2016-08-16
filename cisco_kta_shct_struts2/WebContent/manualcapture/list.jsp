<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />

<table class="table table-hover">
<tr>
<td>No</td><td>monitor item</td><td>设置</td>
</tr>
<tr>
<td>1</td><td><a href="/cisco_kta_shct_struts2/transceiverpower/form">ASR9K/CRS 光功率查询</a></td><td><a href="#">设置</a></td>
</tr>
<tr>
<td>2</td><td><a href="/cisco_kta_shct_struts2/netdr/form">7609 CPU 抓包</a></td><td><a href="#">设置</a></td>
</tr>
</tr>
<tr>
<td>3</td><td><a href="/cisco_kta_shct_struts2/infocapture/form">device 信息抓取</a></td><td><a href="#">设置</a></td>
</tr>
</table>

<s:include value="../foot.jsp" />