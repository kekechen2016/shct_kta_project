<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />

<script src="../jquery-1.12.2.min.js"></script>
<script src="../bootstrap/js/bootstrap.min.js"></script>

<table class="table table-hover">
<tr>
<td>interface</td><td>count</td>
</tr>
<s:iterator status="stat" value="ifmap">
<tr>
<td><a id="<s:property value="#stat.count" />"><s:property value="#this.key" /></a></td>
<td><s:property value="#this.value" /> </td>
</tr>
</s:iterator>
</table>


<s:iterator status="stat" value="ifmap">
<s:set var="interfacename" value="#this.key" />
<div id="div<s:property value="#stat.count" />" style="display:none">
<table class="table table-hover">
<tr>
<td>interface</td>
<td>desmac</td>
<td>srcmac</td>
<td>l3protocol</td>
<td>ttl</td>
<td>srcip</td>
<td>dstip</td>
<td>l4protocol</td>
<td>srcport</td>
<td>dstport</td>
</tr>
<s:iterator value="mlist">
<s:if test="#this.ifname == #interfacename">
<tr>
<td><s:property value="#this.ifname" /></td>
<td><s:property value="#this.destmac" /></td>
<td><s:property value="#this.srcmac" /></td>
<td><s:property value="#this.l3protocol" /></td>
<td><s:property value="#this.ttl" /></td>
<td><s:property value="#this.srcip" /></td>
<td><s:property value="#this.dstip" /></td>
<td><s:property value="#this.l4protocol" /></td>
<td><s:property value="#this.srcport" /></td>
<td><s:property value="#this.dstport" /></td>
</tr>
</s:if>
</s:iterator>
</table>

</div>
</s:iterator>

<script>

$(document).ready(function(){
	<s:iterator status="stat" value="ifmap">
  $("#<s:property value="#stat.count" />").click(function(){
	  $("div").css("display","none");
	  $("#div<s:property value="#stat.count" />").css("display","block");
  })
  </s:iterator> 
})

</script>

<s:debug></s:debug>


<s:include value="../foot.jsp" />