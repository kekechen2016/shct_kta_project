<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />
<div class="jumbotron col-md-7 col-md-offset-1">
  <h1></h1>
  <p>asr9k 单播泛洪监控</p>
  <p style="padding-top:10px">按设备和日期搜索</p>
 <form action="/cisco_kta_shct_struts2/asr9kunicastflooding/listbydate">
 <label>节点</label>
 <select name="device" class="form-control" style="width:150px;display:inline">
 <option value="all">all</option> 
<s:iterator value="inventories">
<s:if test="#this.Devicename.contains('M2N.9010')">
 <option value="<s:property value="#this.Devicename" />"><s:property value="#this.Devicename" /></option> 
</s:if>
</s:iterator>
 </select>
  <label>时间</label>
 <input id="datetimepicker" name="date" type="text" data-date-format="yyyy-mm-dd">
 <button type="submit" class="btn btn-default">搜索</button>
  </form>
</div>
<table class="table table-hover">
<tr>
<td>No</td><td>device name</td><td>port</td><td>bytes</td><td>packets</td><td>avg bytes</td><td>datetime</td>
</tr>
<s:iterator value="asr9kUnicastFloodingDtoList">
<tr <s:if test="#this.avg > 500"> style="background:red" </s:if>>
<td><s:property value="#this.id" /></td><td><s:property value="#this.device" /></td><td><s:property value="#this.port" /></td><td><s:property value="#this.bytes" /></td>
<td><s:property value="#this.packets" /></td>
<td><s:property value="#this.avg" /></td>
<td><s:property value="#this.datetime" /></td>
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