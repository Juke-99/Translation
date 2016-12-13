<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<title>英語翻訳ホーム</title>
		<link rel="stylesheet" type="text/css" href="./css/layout.css">
		<link rel="stylesheet" type="text/css" media="all" href="chrome://global/skin/">
		<link rel="stylesheet" type="text/css" media="all" href="chrome://browser/content/newtab/newTab.css">
		<link rel="stylesheet" type="text/css" media="all" href="chrome://browser/skin/newtab/newTab.css">
	</head>
	
	<body>
		
		<header><h2><span class="bar">英単語データベース</span></h2></header>
		
		<!-- <p><a href="./GrafDis.java">グラフを見る</a></p>-->
		
		<div id="newtab-vertical-margin">
			<div id="newtab-search-container">
				<div id="newtab-search-form" class="forms">
					<form action="EnglishSearch" method="POST">
						<p>単語を検索する：</p>
						<input id="newtab-search-text" type="text" name="spell" value="" aria-label="検索クエリ" maxlength="80" dir="auto" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
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
						<tr><td class="tango">調べた単語：<br>${p.spell}</td><td>意味：<br>${p.meaning}</td><td class="hinshi">品詞：<br>${p.pertOfSpeech}</td></tr>
					</c:forEach>
					
					<c:forEach var="p" items="${search_result_ph}">
						<tr><td>調べた熟語：<br>${p.spell}</td><td>意味：<br>${p.meaning}</td></tr>
					</c:forEach>
				</table>
			</div>
			
			<div id="newtab-search-container">
				<div id="newtab-search-form" class="forms">
					<form action="EnglishInsert" method="POST">
						<p>単語を追加する：</p>
						<input id="newtab-search-text" type="text" name="spell" aria-label="検索クエリ" maxlength="80" dir="auto" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
						<input id="newtab-search-text" type="text" name="imi" aria-label="検索クエリ" maxlength="256" dir="auto" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="意味">
						<select id="newtab-search-text" name="pert_of">
							<option value="1">名詞</option>
							<option value="2">動詞</option>
							<option value="3">前置詞</option>
							<option value="4">形容詞</option>
							<option value="5">代名詞</option>
							<option value="6">接続詞</option>
							<option value="7">間投詞</option>
							<option value="8">副詞</option>
							<option value="9">助動詞</option>
							<option value="10">冠詞</option>
							<option value="11">熟語</option>
						</select>
						<input id="newtab-search-submit" type="submit" value="" aria-label="検索を実行">
						<p class="err">${insertError}</p>
					</form>
				</div>
			</div>
			
			<div id="newtab-search-container">
				<div id="newtab-search-form" class="forms">
					<form action="EnglishDelete" method="POST">
						<p>単語を削除する：</p>
						<input id="newtab-search-text" type="text" name="spell" aria-label="検索クエリ" maxlength="80" dir="auto" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
						<input id="newtab-search-submit" type="submit" value="" aria-label="検索を実行">
					</form>
				</div>
			</div>
			
			<div id="newtab-search-container">
				<div id="newtab-search-form" class="forms">
					<form action="EnglishUpdateMean" method="POST">
						<p>単語を更新もしくは変更する：</p>
						<input id="newtab-search-text" type="text" name="spell" value="" aria-label="検索クエリ" maxlength="80" dir="auto" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
						<input id="newtab-search-text" type="text" name="imi" value="" aria-label="検索クエリ" maxlength="256" dir="auto" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="意味">
						<select id="newtab-search-text" name="pert_of">
							<option value="1">名詞</option>
							<option value="2">動詞</option>
							<option value="3">前置詞</option>
							<option value="4">形容詞</option>
							<option value="5">代名詞</option>
							<option value="6">接続詞</option>
							<option value="7">間投詞</option>
							<option value="8">副詞</option>
							<option value="9">助動詞</option>
							<option value="10">冠詞</option>
						</select>
						<input id="newtab-search-submit" type="submit" value="" aria-label="検索を実行">
					</form>
				</div>
			</div>
		</div>
	</body>
</html>