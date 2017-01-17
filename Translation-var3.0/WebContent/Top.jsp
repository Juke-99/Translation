<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>Top | Englisher</title>
		<link rel="stylesheet" type="text/css" href="./css/layout.css">
		<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
		<script type="text/javascript" src="./JavaScript/jquery-2.1.4.min.js"></script>
	</head>
	
	<body>
		<div class="container">
			<div class="header">
				<h1>英単語データベース</h1>
			</div>
		</div>
		
		<div class="container">
			<form action="EnglishSearch" method="POST">
				<div class="form-group row">
					<label class="control-label col-sm-2">単語を検索する：</label>
					<input class="form-control col-md-6" type="text" name="spell" value="" aria-label="検索クエリ" maxlength="80" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
					<input type="hidden" name="pageValue" value="2">
					<select class="form-control col-md-3" name="pert_of">
						<option value="0">単語</option>
						<option value="11">熟語</option>
					</select>
					<input class="btn btn-outline-primary" type="submit" value="検索" aria-label="検索を実行">
				</div>
			</form>
			
			<p class="err">${search_zero}</p>
			
			<div id="serchresul">
				<table  class="table table-hover">
					<c:forEach var="p" items="${search_result}">
						<tr><td class="tango">調べた単語：<br>${p.spell}</td><td>意味：<br>${p.meaning}</td><td class="hinshi">品詞：<br>${p.pertOfSpeech}</td></tr>
					</c:forEach>
					
					<c:forEach var="p" items="${search_result_ph}">
						<tr><td>調べた熟語：<br>${p.spell}</td><td>意味：<br>${p.meaning}</td></tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<footer class="footer">
			<nav class="navbar navbar-toggleable-md navbar-light bg-faded">
				<div class="container">
					<ul class="bd-footer-links navbar-nav mr-auto">
						<li class="nav-item active"><a class="nav-link">メニュー</a></li>
						<li class="nav-item">
							<a class="nav-link" href="./BubbleChart.jsp">グラフ</a>
						</li>
					</ul>
				</div>
			</nav>
		</footer>
		
		<script type="text/javascript" src="./JavaScript/AutoMathicLayout.js"></script>
	</body>
</html>