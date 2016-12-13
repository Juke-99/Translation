/**
 * '''
 * オリジナルのみの説明：
 * 
 * テスト用JavaScript
 * Pythonと連携させるための.jsファイル
 * {{}}で囲まれた変数をPythonで使用し、Pythonが読み込まれたときに変数に入れられる。
 * '''
 * 
 */

var list={{data_list}};
var svgwidth=320;
var svgheight=240;
var svg=d3.select("#myGraph").append("svg").attr("width",svgwidth).attr("height",svgheight);
var line=d3.svg.line().x(function(d,l){return l*svgwidth/(list.length-1);}).y(function(d){return svgheight-d;});

svg.append("path").attr("d",line(list)).attr("stroke","blue").attr("fill","none");