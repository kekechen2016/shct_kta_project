<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="../bootstrap/css/bootstrap-theme.min.css">
<link rel="stylesheet" type="text/css" href="../bootstrap/css/bootstrap-datetimepicker.min.css"/>
<script src="../Chart.js"></script>
<title>SHCT CISCO KTA</title>
</head>
<body>
<nav class="navbar navbar-inverse" role="navigation">
  <!-- Brand and toggle get grouped for better mobile display -->
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="/cisco_kta_shct_struts2/index"><img alt="Brand" src="..."></a>
  </div>
  <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
        <ul class="nav navbar-nav navbar-left">
        <li class="active"><a href="/cisco_kta_shct_struts2/automaticcapture/list">自动监控项目</a></li>
        <li><a href="/cisco_kta_shct_struts2/manualcapture/list.jsp">手动触发项目</a></li>
        </li>
      </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#">Link</a></li>
      <li><a href="#">Link</a></li>
      <li class="dropdown">
        <a href="#" class="dropdown-toggle" data-toggle="dropdown">设备资源列表管理 <b class="caret"></b></a>
        <ul class="dropdown-menu">
          <li><a href="/cisco_kta_shct_struts2/inventorymanage/list">设备资源列表</a></li>
          <li><a href="/cisco_kta_shct_struts2/inventorymanage/inventorypasswordchange.jsp">修改登录信息</a></li>
          <li><a href="#">Something else here</a></li>
          <li class="divider"></li>
          <li><a href="#">Separated link</a></li>
          <li class="divider"></li>
          <li><a href="#">One more separated link</a></li>
        </ul>
      </li>
    </ul>
</nav>  