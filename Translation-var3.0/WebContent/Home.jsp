<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>

<html lang="ja">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<title>Home | Englisher</title>
		<link rel="stylesheet" type="text/css" href="./css/layout.css">
		<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css">
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
					<input type="hidden" name="pageValue" value="1">
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
			
			<form action="EnglishInsert" method="POST">
				<div class="form-group row">
					<label class="control-label col-sm-2">単語を追加する：</label>
					<input class="form-control col-md-3" type="text" name="spell" aria-label="追加クエリ" maxlength="80" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
					<input class="form-control col-md-3" type="text" name="imi" aria-label="追加クエリ" maxlength="256" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="意味">
					<select class="form-control col-md-3" name="pert_of">
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
					<input class="btn btn-outline-primary" type="submit" value="追加" aria-label="追加を実行">
					<p class="err">${insertError}</p>
				</div>
			</form>
			
			<form action="EnglishDelete" method="POST">
				<div class="form-group row">
					<label class="control-label col-sm-2">単語を削除する：</label>
					<input class="form-control col-md-6" type="text" name="spell" aria-label="削除クエリ" maxlength="80" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
					<input class="btn btn-outline-primary" type="submit" value="削除" aria-label="削除を実行">
					<p class="err">${insertError}</p>
				</div>
			</form>
					
			<form action="EnglishUpdateMean" method="POST">
				<div class="form-group row">
					<label class="control-label col-sm-2">単語を更新する：</label>
					<input class="form-control col-md-3" type="text" name="spell" value="" aria-label="更新クエリ" maxlength="80" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="スペル">
					<input class="form-control col-md-3" type="text" name="imi" value="" aria-label="更新クエリ" maxlength="256" autocomplete="off" aria-autocomplete="true" aria-controls="searchSuggestionTable" aria-expanded="false" placeholder="意味">
					<select class="form-control col-md-3" name="pert_of">
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
					<input class="btn btn-outline-primary" type="submit" value="更新" aria-label="更新を実行">
					<p class="err">${insertError}</p>
				</div>
			</form>
		</div>
	</body>
</html>