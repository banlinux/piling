/**
 * 
 */

(function($){$.fn.hoverIntent=function(f,g){var cfg={sensitivity:7,interval:100,timeout:0};cfg=$.extend(cfg,g?{over:f,out:g}:f);var cX,cY,pX,pY;var track=function(ev){cX=ev.pageX;cY=ev.pageY;};var compare=function(ev,ob){ob.hoverIntent_t=clearTimeout(ob.hoverIntent_t);if((Math.abs(pX-cX)+Math.abs(pY-cY))<cfg.sensitivity){$(ob).unbind("mousemove",track);ob.hoverIntent_s=1;return cfg.over.apply(ob,[ev]);}else{pX=cX;pY=cY;ob.hoverIntent_t=setTimeout(function(){compare(ev,ob);},cfg.interval);}};var delay=function(ev,ob){ob.hoverIntent_t=clearTimeout(ob.hoverIntent_t);ob.hoverIntent_s=0;return cfg.out.apply(ob,[ev]);};var handleHover=function(e){var p=(e.type=="mouseover"?e.fromElement:e.toElement)||e.relatedTarget;while(p&&p!=this){try{p=p.parentNode;}catch(e){p=this;}}if(p==this){return false;}var ev=jQuery.extend({},e);var ob=this;if(ob.hoverIntent_t){ob.hoverIntent_t=clearTimeout(ob.hoverIntent_t);}if(e.type=="mouseover"){pX=ev.pageX;pY=ev.pageY;$(ob).bind("mousemove",track);if(ob.hoverIntent_s!=1){ob.hoverIntent_t=setTimeout(function(){compare(ev,ob);},cfg.interval);}}else{$(ob).unbind("mousemove",track);if(ob.hoverIntent_s==1){ob.hoverIntent_t=setTimeout(function(){delay(ev,ob);},cfg.timeout);}}};return this.mouseover(handleHover).mouseout(handleHover);};})(jQuery);

$(function () {
	
	$('.dropdown').each(function () {
		$(this).parent().eq(0).hoverIntent({
			timeout: 100,
			over: function () {
				var current = $('.dropdown:eq(0)', this);
				current.slideDown(100);
			},
			out: function () {
				var current = $('.dropdown:eq(0)', this);
				current.fadeOut(200);
			}
		});
	});
	
	$('.dropdown a').hover(function () {
		$(this).stop(true).animate({paddingLeft: '35px'}, {speed: 100, easing: 'easeOutBack'});
	}, function () {
		$(this).stop(true).animate({paddingLeft: '0'}, {speed: 100, easing: 'easeOutBounce'});
	});
	
	pic1 = new Image(310, 672);
	pic1.src = "images/dropdown.png"; 
	
	pic2 = new Image(4, 40);
	pic2.src = "images/dropselectionleft.png"; 
	
	pic3 = new Image(394, 40);
	pic3.src = "images/dropselectionright.png";
});