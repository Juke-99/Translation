var list=[12,32,12,42,12,42,53,14,23,12,43];
var svgwidth=320;
var svgheight=240;
var svg=d3.select("#myGraph").append("svg").attr("width",svgwidth).attr("height",svgheight);
var line=d3.svg.line().x(function(d,l){return l*svgwidth/(list.length-1);}).y(function(d){return svgheight-d;});

svg.append("path").attr("d",line(list)).attr("stroke","blue").attr("fill","none");