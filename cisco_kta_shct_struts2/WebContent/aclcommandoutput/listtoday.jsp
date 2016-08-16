<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />
<div class="jumbotron col-md-7 col-md-offset-1">
  <h1></h1>
  <p>安吉星ACL统计，云莲和民生节点</p>
  <a href="/cisco_kta_shct_struts2/aclcommandoutput/listtoday?device=SH-SH-MS-CR-1.MAN"><button type="button" class="btn btn-default">今天民生CR抓包统计</button></a>
  <a href="/cisco_kta_shct_struts2/aclcommandoutput/listtoday?device=SH-SH-YL-CR-1.MAN"><button type="button" class="btn btn-default">今天云莲CR抓包统计</button></a>
  <p style="padding-top:10px">按设备和日期搜索</p>
 <form action="/cisco_kta_shct_struts2/aclcommandoutput/listbydate">
 <label>节点</label>
 <select name="device" class="form-control" style="width:150px;display:inline">
 <option value="SH-SH-MS-CR-1.MAN">民生CR</option> 
 <option value="SH-SH-YL-CR-1.MAN">云莲CR</option>
 </select>
  <label>时间</label>
 <input id="datetimepicker" name="date" type="text" data-date-format="yyyy-mm-dd">
 <button type="submit" class="btn btn-default">搜索</button>
  </form>
</div>
<table class="table table-hover">
<tr>
<td>No</td><td>device name</td><td>command</td><td>output</td><td>datetime</td><td>`</td>
</tr>
<s:iterator value="aclCommandOutputDtoList">
<tr>
<td><s:property value="#this.id" /></td><td><s:property value="#this.device" /></td><td><s:property value="#this.command" /></td><td><textarea rows="5" cols="70"><s:property value="#this.ouput" /></textarea></td><td><s:property value="#this.datetime" /></td>
<td><a href="/cisco_kta_shct_struts2/aclcommandoutpu/listhistory?device=<s:property value="#this.device" />&slot=<s:property value="#this.slot" />">历史记录</a></td>
</tr>
</s:iterator>
</table>

<s:debug></s:debug>
<script src="../jquery-1.12.2.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script> 
<script src="../bootstrap/js/bootstrap-datetimepicker.min.js"></script>   
<script>
   $('#datetimepicker').datetimepicker({lang:'ch',minView: 2});
</script>
<s:include value="../foot.jsp" />