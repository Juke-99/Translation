<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>English farm|top</title>
		<link rel="stylesheet" type="text/css" href="./css/layout.css">
		<link rel="stylesheet" type="text/css" media="all" href="chrome://global/skin/">
		<link rel="stylesheet" type="text/css" media="all" href="chrome://browser/content/newtab/newTab.css">
		<link rel="stylesheet" type="text/css" media="all" href="chrome://browser/skin/newtab/newTab.css">
		<script type="text/javascript" src="./JavaScript/jquery-2.1.4.min.js"></script>
	</head>
	
	<body>
		<header><h2><span class="bar">English farm</span></h2></header>
	
		<div id="newtab-vertical-margin">
			<div id="newtab-search-container">
				<div id="newtab-search-form" class="forms">
					<form action="SearchEn" method="POST">
						<p>検索：</p>
							
						<input id="newtab-search-text" type="text" name="spell" value="" aria-label="検索クエリ" maxlength="30" dir="auto" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
						
						<select id="newtab-search-text" name="pert_of">
							<option value="0">単語</option>
							<option value="11">熟語</option>
						</select>
						
						<input id="newtab-search-submit" type="submit" value="" aria-label="検索を実行">
					</form>
				</div>
			</div>
			
			<p class="err">${search_zero}</p>
			
			<div id="serchresul">
				<table>
					<c:forEach var="p" items="${search_result}">
						<tr><td>調べた単語：${p.spell}</td><td>意味：${p.meaning}</td><td>品詞：${p.pertOfSpeech}</td></tr>
					</c:forEach>
					
					<c:forEach var="p" items="${search_result_ph}">
						<tr><td>調べた熟語：${p.spell}</td><td>意味：${p.meaning}</td></tr>
					</c:forEach>
				</table>
			</div>
		</div>
		
		<footer>
			<nav>
				<div class="navige">メニュー</div>
				<div class="subnavige">
					<p>ログアウト</p>
					<p><a href="./BubbleChart.jsp">グラフ</a></p>
				</div>
			</nav>
		</footer>
		
		<script type="text/javascript" src="./JavaScript/AutoMathicLayout.js"></script>
	</body>
</html>