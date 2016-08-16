<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />
<script>

function selectplane(s1)
{	var aplane = new Array('cr','br','7609','9010');  
	var bplane = new Array('cr','7609','9010'); 
	var plane = s1.value;
	document.getElementById("s2").options.length = 1;
	if (plane == "a") {
		for (i = 0; i < aplane.length; i++){
			var _option = document.createElement("option");
			_option.text = aplane[i];
			_option.value = "A" + aplane[i];
			document.getElementById("s2").appendChild(_option);
		}
	}else{
		for (i = 0; i < bplane.length; i++){
			var _option = document.createElement("option");
			_option.text = bplane[i];
			_option.value = "B" + bplane[i];
			document.getElementById("s2").appendChild(_option);
		}
	}
}
	
function selectdevicetype(s2){
	var Acr = [<s:iterator value="inventories"><s:if test = "#this.Devicename.contains('CR') and #this.Devicename.contains('MAN') or #this.Devicename.contains('crs')">"<s:property value="#this.Devicename" />",</s:if></s:iterator>];
	var Abr = [<s:iterator value="inventories"><s:if test = "#this.Devicename.contains('BR') and #this.Devicename.contains('MAN')">"<s:property value="#this.Devicename" />",</s:if></s:iterator>];
	var A7609 = [<s:iterator value="inventories"><s:if test = "#this.Devicename.contains('7609') and #this.Devicename.contains('ip-a') or #this.Devicename.contains('7609')">"<s:property value="#this.Devicename" />",</s:if></s:iterator>];
	var A9010 = [<s:iterator value="inventories"><s:if test = "#this.Devicename.contains('9010') and #this.Devicename.contains('MAN')">"<s:property value="#this.Devicename" />",</s:if></s:iterator>];
	var Bcr = [<s:iterator value="inventories"><s:if test = "#this.Devicename.contains('CR') and #this.Devicename.contains('M2N')">"<s:property value="#this.Devicename" />",</s:if></s:iterator>];
	var B7609 = [<s:iterator value="inventories"><s:if test = "(#this.Devicename.contains('7609') and #this.Devicename.contains('ipb')) or #this.Devicename.contains('M2N.C76')">"<s:property value="#this.Devicename" />",</s:if></s:iterator>];
	var B9010 = [<s:iterator value="inventories"><s:if test = "#this.Devicename.contains('9010') and #this.Devicename.contains('M2N')">"<s:property value="#this.Devicename" />",</s:if></s:iterator>];
	var type = s2.value;
	document.getElementById("s3").options.length = 1;
	if (type == "Acr"){
		for (i = 0; i < Acr.length; i++){
			var _option = document.createElement("option");
			_option.text = Acr[i];
			_option.value = Acr[i];
			document.getElementById("s3").appendChild(_option);
		}
	}
	if (type == "Abr"){
		for (i = 0; i < Abr.length; i++){
			var _option = document.createElement("option");
			_option.text = Abr[i];
			_option.value = Abr[i];
			document.getElementById("s3").appendChild(_option);
		}
	}
	if (type == "A7609"){
		for (i = 0; i < A7609.length; i++){
			var _option = document.createElement("option");
			_option.text = A7609[i];
			_option.value = A7609[i];
			document.getElementById("s3").appendChild(_option);
		}
	}
	if (type == "A9010"){
		for (i = 0; i < A9010.length; i++){
			var _option = document.createElement("option");
			_option.text = A9010[i];
			_option.value = A9010[i];
			document.getElementById("s3").appendChild(_option);
		}
	}
	if (type == "Bcr"){
		for (i = 0; i < Bcr.length; i++){
			var _option = document.createElement("option");
			_option.text = Bcr[i];
			_option.value = Bcr[i];
			document.getElementById("s3").appendChild(_option);
		}
	}
	if (type == "B7609"){
		for (i = 0; i < B7609.length; i++){
			var _option = document.createElement("option");
			_option.text = B7609[i];
			_option.value = B7609[i];
			document.getElementById("s3").appendChild(_option);
		}
	}
	if (type == "B9010"){
		for (i = 0; i < B9010.length; i++){
			var _option = document.createElement("option");
			_option.text = B9010[i];
			_option.value = B9010[i];
			document.getElementById("s3").appendChild(_option);
		}
	}
}
function selectdevice(device){
	if (device.value.indexOf('CR') != -1 || device.value.indexOf('BR') !=-1|| device.value.indexOf('9010') != -1){
		document.getElementById("defaultcli").innerHTML="admin show install active summary\nadmin show platform\nshow logging";
	}else{
		document.getElementById("defaultcli").innerHTML="show version\nshow module\nshow logging";
	}
}
</script>



<div class="jumbotron col-md-7 col-md-offset-1">
  <h1></h1>
  <p>设备运行信息抓取，可以抓取A／B平面的CRS，ASR9K和7609设备的相关信息</p>
</div>


<div class="col-md-6 col-md-offset-1">
<label>选择平面</label>
<select id="sl" class="form-control " onchange="selectplane(this)">
<option>----select----</option>
<option value="a">a plane</option>
<option value="b">b plane</option>
</select>


<label>选择设备类型</label>
<select id="s2" class="form-control" onchange="selectdevicetype(this)">
<option>----select----</option>
</select>

<form method="post" action="result">
<label>选择具体设备</label>
<select name="device" class="form-control" id="s3" onchange="selectdevice(this)">
<option>----select----</option>
</select>

<label>default命令</label>
<textarea id="defaultcli" name="defaultcli" class="form-control" rows="5"></textarea>
<label>查询命令</label>
<label>每条命令都需要换行</label>
<textarea name="cli" class="form-control" rows="5"></textarea>

<button class="btn btn-primary" type="submit">submit</button>
</form>
</div>


<s:include value="../foot.jsp" />