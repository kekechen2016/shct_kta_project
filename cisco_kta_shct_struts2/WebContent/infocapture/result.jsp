<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />

<div class="col-md-8 col-md-offset-1">
<div class="jumbotron">
  <p>可以通过邮件将收集信息发送，目前只支持一个收件人信箱</p>
  <p>思科维护团队邮箱:shct-cisco-service@cisco.com</p>
  <h2>result</h2>
</div>
<form class="form-inline" role="form" action="mailsendout">
<input type="hidden" name="filename" value="<s:property value="filename" />">
  <div class="form-group">
    <label class="sr-only" for="exampleInputEmail2">Email address</label>
    <input type="email" class="form-control" style="width:300px;" name="receiver" placeholder="Enter receiver email address">
  </div>
  <button type="submit" class="btn btn-default">邮件发送</button>
</form>
<textarea style="width:100%;" rows="30" name="text">
<s:iterator value="infocapture">
<s:property value="key" />
<s:property value="value" />
</s:iterator>
</textarea>
</div>


<s:include value="../foot.jsp" />