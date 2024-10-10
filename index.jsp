<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="./styles/style.css">
    <script src="scripts/script.js"></script> 
    <title>わんちゃんのおさんぽ日和</title>
</head>
<body>
    <h1>わんちゃんのさんぽに適した気温を確認しよう!</h1>
    <h2>私の家では犬を飼っています。犬にも健康な生活を送ってもらうために散歩が必要になってきます。<br>
    	しかし、夏場など気温が高い日が続くと路面温度が気になり散歩のタイミングに迷います。<br>
    	このサイトでは気温から路面温度を計算し、犬にとって散歩に適した路面温度なのかを表示します。</h2>
    <form action="checkTemperature" method="POST">
        <label for="city">地域名:</label>
        <input type="text" id="city" name="city" required>
        <input type="submit" value="確認">
    </form>
    
</body>
</html>
