<!DOCTYPE html>
<html lang="zh">
<head>
<meta charset="UTF-8">
<title>Document</title>
<link href="/css/index.css" rel="stylesheet" />
</head>
<body>
	<#list list as user>
		<li> ${user.bannerName} ==== ${user.bannerPicture}</li>
	</#list>
</body>
</html>
