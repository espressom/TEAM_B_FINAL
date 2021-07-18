<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
 
<head>
<meta charset="utf-8">
<meta name="viewport" content="user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0, width=device-width">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="x-ua-compatible" content="ie=edge">
<link rel="stylesheet" type="text/css" href="css/common.css" />
<title>경제 지표 </title>
<link href="css/egovframework/com/com.css" rel="stylesheet" type="text/css" />

<script src='https://cdn.plot.ly/plotly-2.2.0.min.js'></script>
</head>

<body>
	<div class="container" style="margin-top: 150px;">
		<div>
			<div>
			<h1>기준금리 확인!</h1>
				<div id="myDiv"></div>
			</div>
		</div>
	</div>
</body>
<script>
	var trace1 = {
	  x: [1, 2, 3, 4],
	  y: [10, 15, 13, 17],
	  type: 'line'
	};
	

	
	var data = [trace1];
	
	Plotly.newPlot('myDiv', data);
</script>
</html>