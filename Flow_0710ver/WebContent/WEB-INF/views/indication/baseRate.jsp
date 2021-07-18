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

<script src="https://cdn.plot.ly/plotly-latest.min.js"></script>
</head>

<body>
	<div class="container" style="margin-top: 150px;">
		<div>
			<div>
			<h1>기준금리 확인!</h1>
				<div id=graph></div>
			</div>
		</div>
	</div>
</body>
<script>
$(function(){

        $.ajax({
            url:'http://192.168.0.25:8099/shop/baseRate?callback',
            type:'GET',
            dataType:'jsonp',
            success:function(data){
                console.log(data);
                Plotly.plot('graph', data, {});
            }
        });
});



	
</script>
</html>