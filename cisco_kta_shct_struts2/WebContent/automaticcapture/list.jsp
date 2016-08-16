<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />

<table class="table table-hover">
<tr>
<td>No</td><td>monitor item</td><td>设置</td>
</tr>
<tr>
<td>1</td><td><a href="/cisco_kta_shct_struts2/asr9kcefusage/list">ASR9K CEF自动监控</a></td><td><a href="#">设置</a></td>
</tr>
<tr>
<td>2</td><td><a href="/cisco_kta_shct_struts2/aclcommandoutput/listtoday?device=SH-SH-MS-CR-1.MAN">安吉星 ACL 自动监控</a></td><td><a href="#">设置</a></td>
</tr>
<tr>
<td>3</td><td><a href="/cisco_kta_shct_struts2/asr9kunicastflooding/listtoday">ASR9K 单播泛洪自动监控</a></td><td><a href="#">设置</a></td>
</tr>
</table>

<s:include value="../foot.jsp" />