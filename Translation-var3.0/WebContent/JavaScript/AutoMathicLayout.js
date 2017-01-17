var width=window.parent.screen.width;
var $footer=$('footer');
var $nav=$('nav');
var $libnav=$('.navige');
var $subnav=$('.subnavige p');
var $td=$('td');

$(function(){
	
	$footer.css({
		width:width
	});
	
	$subnav.each(function(index){
		$('.subnavige').css({
			height:((index+1)*60)+'px'
		});
	});
	
	$libnav
	.on('mouseover',function(){
		$libnav.css({
			background:'rgba(200,200,200,0.87)'
		});
	})
	.on('mouseout',function(){
		$libnav.css({
			background:'rgba(33,33,33,0.21)'
		});
	});
	
	$subnav
	.on('mouseover',function(){
		$(this).css({
			background:'rgba(200,200,200,0.87)'
		});
	})
	.on('mouseout',function(){
		$(this).css({
			background:'rgba(33,33,33,0.21)'
		});
	});
	
	$td
	.on('mouseover',function(){
		$(this).css({
			background:'rgba(120,230,200,0.87)'
		});
	})
	.on('mouseout',function(){
		$(this).css({
			background:'rgba(255,255,255,0)'
		});
	});
	
	$nav
	.on('mouseover',function(){
		$('.subnavige').css({
			display:'block'
		});
	})
	.on('mouseout',function(){
		$('.subnavige').css({
			display:'none'
		});
	});
});