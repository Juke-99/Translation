var list = {{data_list}};
var svgWidth = 640; // SVG領域の横幅
var svgHeight = 480;    // SVG領域の縦幅
var barHeight = 200;    // 棒グラフの基準位置
var xScale=d3.scale.linear().range([0,svgWidth]);
var yScale=d3.scale.linear().range([svgHeight,0]);
var xScalelist={{data_spell}};
var yScalelist={{data_list}};
var yScalemax=d3.max(yScalelist);
var xAxis = d3.svg.axis().scale(xScale).orient("bottom").tickValues([0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30,31]).tickFormat(function(d,i){return xScalelist[i];});
var yAxis = d3.svg.axis().scale(yScale).orient("left");

d3.select("#myGraph").append("svg")
    .attr("width", svgWidth).attr("height", svgHeight)
    .selectAll("rect")  // SVGでの四角形を示す要素を指定
    .data(list) // データを設定
    .enter()
    .append("rect") // SVGでの四角形を示す要素を生成
    .attr("x", function(d,i){   // X座標を配列の順序に応じて計算
        return i * 18;
    }).attr("y", function(d){ // 縦幅を配列の内容に応じて計算
        return barHeight-(d*2) +"px";
    }).attr("height", function(d){    // 縦幅を配列の内容に応じて計算
        return (d*2) +"px";
    }).attr("width", 16)  // 棒グラフの横幅を指定
    .attr("style", "fill:rgb(255,0,0)"); // 棒グラフの色を赤色に設定

xScalelist.splice(0,1);
yScalelist.splice(0,1);

xScale.domain([0,xScalelist.length]);
yScale.domain([0,yScalemax]);

svg.append("g").attr("class","axis")
.attr("transform","translate(" + margin + ", " + (margin + height) + ")")
.call(xAxis);

svg.append("g").attr("class","axis")
.attr("transform","translate(" + margin + ", " + margin + ")")
.call(yAxis);