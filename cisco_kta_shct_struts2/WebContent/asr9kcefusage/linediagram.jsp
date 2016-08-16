<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<s:include value="../head.jsp" />
<div style="position:relative;left:20%;width:50%">
    <div>
    <h3>device : <s:property value="asr9kCefUsageDtoList[0].device" />
        slot :<s:property value="asr9kCefUsageDtoList[0].slot" /></h3>
	 <canvas id="canvas" height="450" width="600"></canvas>
    </div>
</div>


<script>
		var lineChartData = {
			labels : [
			          <s:iterator value="asr9kCefUsageDtoList">
			          "<s:property value="#this.datetime" />",
			          </s:iterator>
			          ],
			datasets : [
				{
					label: "cef usage",
					fillColor : "rgba(220,220,220,0.2)",
					strokeColor : "rgba(220,220,220,1)",
					pointColor : "rgba(220,220,220,1)",
					pointStrokeColor : "#fff",
					pointHighlightFill : "#fff",
					pointHighlightStroke : "rgba(220,220,220,1)",
					data : [
					          <s:iterator value="asr9kCefUsageDtoList">
					          "<s:property value="#this.percent" />",
					          </s:iterator>
					        ]
				}
			]

		}
		window.onload = function(){
			var ctx = document.getElementById("canvas").getContext("2d");
			window.myLine = new Chart(ctx).Line(lineChartData, {
				responsive: true
			});
		}


</script>		



<s:debug></s:debug>
<s:include value="../foot.jsp" />