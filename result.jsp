<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ja">
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="styles/style.css">
    <script src="scripts/script.js"></script> 
    <title>天気情報</title>
</head>
<body>
    <h1>天気情報</h1>

	<div class="weather_container">
	    <c:if test="${not empty weatherDescription}">
	        <p>天気: ${weatherDescription}</p>
	        <p><img src="${iconUrl}" alt="天気アイコン"></p>
	        <p>現在の気温: ${temperature} °C</p>
	        <p>現在の路面温度: ${surfaceTemperature}℃</p>
	        <p>3時間後の気温: ${afterThreeHoursTem} °C &emsp;&emsp; 6時間後の気温: ${afterSixHoursTem} °C</p>
		</c:if>
	</div>
 
     
    <c:if test="${not empty message}">
        <p>${message}</p>
    </c:if>
    
    <h2>現在の散歩に行く場合の状態</h2>
    <p>犬にとって快適に過ごせる気温は22℃されています。<br>
       気温が25℃を超える場合には熱中症に気をつけましょう。</p>
   	<p><img src="${dogIcon}" alt="犬の状態"></p> <!-- 犬のアイコンを表示 -->
	<a href="index.jsp">戻る</a>

</body>
</html>
