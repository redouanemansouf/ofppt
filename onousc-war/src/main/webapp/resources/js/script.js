PrimeFaces.locales['fr'] = {
	closeText : 'Fermer',
	prevText : 'Précédent',
	nextText : 'Suivant',
	monthNames : [ 'Janvier', 'F\u00E9vrier', 'Mars', 'Avril', 'Mai', 'Juin',
			'Juillet', 'Ao&#251t ', 'Septembre', 'Octobre', 'Novembre',
			'D\u00E9cembre' ],
	monthNamesShort : [ 'Jan', 'F\u00E9v', 'Mar', 'Avr', 'Mai', 'Jun', 'Jul',
			'Ao&#251 ', 'Sep', 'Oct', 'Nov', 'D\u00E9c' ],
	dayNames : [ 'Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi',
			'Samedi' ],
	dayNamesShort : [ 'Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam' ],
	dayNamesMin : [ 'D', 'L', 'M', 'M', 'J', 'V', 'S' ],
	weekHeader : 'Semaine',
	firstDay : 1,
	isRTL : false,
	showMonthAfterYear : false,
	yearSuffix : '',
	timeOnlyTitle : 'Choisir l\'heure',
	timeText : 'Heure',
	hourText : 'Heures',
	minuteText : 'Minutes',
	secondText : 'Secondes',
	currentText : 'Maintenant',
	ampm : false,
	month : 'Mois',
	week : 'Semaine',
	day : 'Jour',
	allDayText : 'Toute la journée'
};
PrimeFaces.info("info message");
PrimeFaces.warn("info message");
PrimeFaces.error("info message");

/**
 * 
 * @param id
 *            toggle element width id = id
 */
function toggle_visibility(id) {
	var e = document.getElementById(id);
	$(e).stop().animate({
		height : 'toggle',
	}, 500);

}/**
	 * 
	 * @param id
	 *            show element width id=id
	 */
function show(id) {
	var e = document.getElementById(id);
	$(e).stop().animate({
		width : 'show',
	}, 500);

	$(e).delay(5000).animate({
		width : 'hide',
	}, 500);

};

/**
 * 
 * @param id
 *            hide element with id = id
 */
function hide(id) {
	var e = document.getElementById(id);
	$(e).stop().animate({
		width : 'hide',
	}, 500);
};

/**
 * Ref main menu animation
 */
$(document).ready(function() {
	$('.ItemSlot').click(function() {

		if ($(this).parent().find('.ui-custom-hover').hasClass('toggled')) {
			$('.toggled').stop().animate({
				height : 'toggle',
			}, 200);
			/*
			 * $('.hoverable').find('.squared').stop().delay(100).animate({
			 * borderRadius : '25%', width : '100px' }, 400);
			 */
			$('.hoverable').find('.ItemSlot').removeClass('is-squared');

			$('.hoverable').find('.ui-custom-hover').removeClass('toggled');

		}

		else {

			$('.toggled').stop().animate({
				height : 'toggle',

			}, 200);
			/*
			 * $('.hoverable').find('.squared').stop().delay(100).animate({
			 * borderRadius : '25%', width : '100px' }, 400);
			 * 
			 * $('.hoverable').stop().animate({ top : '0%', left : '0%' });
			 * 
			 * $('.hoverable').find('.circle-div').removeClass('squared');
			 */
			$('.hoverable').find('.ui-custom-hover').removeClass('toggled');

			$(this).parent().find('.ui-custom-hover').stop().animate({
				height : 'toggle',

			}, 400);
			$('.hoverable').find('.ItemSlot').removeClass('is-squared');
			$(this).parent().find('.ItemSlot').addClass('is-squared');
			$(this).parent().find('.ui-custom-hover').addClass('toggled');

		}

	});
	/**
	 * Ref main submenu
	 */
	$('.VerticalMenu li.has-subMenu>a').on('click', function() {
		$(this).removeAttr('href');
		var element = $(this).parent('li');
		if (element.hasClass('open')) {
			element.removeClass('open');
			element.find('li').removeClass('open');
			element.find('ul').slideUp();
		} else {
			element.addClass('open');
			element.children('ul').slideDown();
			element.siblings('li').children('ul').slideUp();
			element.siblings('li').removeClass('open');
			element.siblings('li').find('li').removeClass('open');
			element.siblings('li').find('ul').slideUp();
		}
	});

	/**
	 * side menu Alpha test
	 * 
	 */

	/*
	 * $('.has-subMenu').hover(function(){ $(this).find('a').removeAttr('href');
	 * $(this).addClass('open'); $(this).children('ul').slideDown(); }
	 * ,function(){ $(this).find('a').removeAttr('href');
	 * $(this).removeClass('open'); $(this).find('li').removeClass('open');
	 * $(this).find('ul').slideUp();
	 * 
	 * });
	 */

	$('#side-menu li.has-subMenu>a').on('click', function() {
		$(this).removeAttr('href');
		var element = $(this).parent('li');
		if (element.hasClass('open')) {
			element.removeClass('open');
			element.find('li').removeClass('open');
			element.find('ul').slideUp();
		} else {
			element.addClass('open');
			element.children('ul').slideDown();
			element.siblings('li').children('ul').slideUp();
			element.siblings('li').removeClass('open');
			element.siblings('li').find('li').removeClass('open');
			element.siblings('li').find('ul').slideUp();
		}
	});

	/*
	 * $('#side-menu>ul>li.has-subMenu>a').append('<span class="holder"></span>');
	 * 
	 * (function getColor() { var r, g, b; var textColor =
	 * $('#side-menu').css('color'); textColor = textColor.slice(4); r =
	 * textColor.slice(0, textColor.indexOf(',')); textColor =
	 * textColor.slice(textColor.indexOf(' ') + 1); g = textColor.slice(0,
	 * textColor.indexOf(',')); textColor = textColor.slice(textColor.indexOf(' ') +
	 * 1); b = textColor.slice(0, textColor.indexOf(')')); var l = rgbToHsl(r,
	 * g, b); if (l > 0.7) { $('#side-menu>ul>li>a').css('text-shadow', '0 1px
	 * 1px rgba(0, 0, 0, .35)');
	 * $('#side-menu>ul>li>a>span').css('border-color', 'rgba(0, 0, 0, .35)'); }
	 * else { $('#side-menu>ul>li>a').css('text-shadow', '0 1px 0 rgba(255, 255,
	 * 255, .35)'); $('#side-menu>ul>li>a>span').css('border-color', 'rgba(255,
	 * 255, 255, .35)'); } })();
	 * 
	 * function rgbToHsl(r, g, b) { r /= 255, g /= 255, b /= 255; var max =
	 * Math.max(r, g, b), min = Math.min(r, g, b); var h, s, l = (max + min) /
	 * 2;
	 * 
	 * if(max == min){ h = s = 0; } else { var d = max - min; s = l > 0.5 ? d /
	 * (2 - max - min) : d / (max + min); switch(max){ case r: h = (g - b) / d +
	 * (g < b ? 6 : 0); break; case g: h = (b - r) / d + 2; break; case b: h =
	 * (r - g) / d + 4; break; } h /= 6; } return l; }
	 */

	$('#side-menu').hover(function() {
		$(this).stop().animate({
			left : '-10px'
		}, 500);
	}, function() {
		$(this).stop().animate({
			left : '-203px'
		}, 500);
		// if($(this).find('li').hasClass('open')){
		// $(this).find('li').removeClass('open');
		// $(this).find('ul ul').slideUp()
		// }

	});

	$('#top-menu>ul').prepend('<li id="menu-button"><a>Menu</a></li>');
	$("#menu-button").click(function() {
		if ($(this).parent().hasClass('open')) {
			$(this).parent().removeClass('open');
		} else {
			$(this).parent().addClass('open');
		}
	});
	//	
	// sessvars.sideMenuState = {
	// state : ""
	// };
	//
	// if (sessvars.sideMenuState.state = 'closed') {
	// $('.sideMenuOperator').removeClass('sideMenuOperator_arrow-w');
	// $('.sideMenuOperator').addClass('sideMenuOperator_arrow-e');
	// $('#side-menu').stop().animate({
	// left : '-300px'
	// }, 100);
	// } else {
	// $('.sideMenuOperator').removeClass('sideMenuOperator_arrow-e');
	// $('.sideMenuOperator').addClass('sideMenuOperator_arrow-w');
	// $('#side-menu').stop().animate({
	// left : '-213px'
	// }, 500);
	// }
	$('.sideMenuOperator').click(function() {
		if ($(this).hasClass('sideMenuOperator_arrow-e')) {
			$(this).removeClass('sideMenuOperator_arrow-e');
			$(this).addClass('sideMenuOperator_arrow-w');
			// sessvars.sideMenuState['state'] = 'open';
			$(this).stop().animate({
				left : '-5px'
			}, 500);
			$('#side-menu').stop().animate({
				left : '-203px'
			}, 500);
		} else {
			$(this).removeClass('sideMenuOperator_arrow-w');
			$(this).addClass('sideMenuOperator_arrow-e');
			// sessvars.sideMenuState['state'] = 'closed';
			$(this).stop().animate({
				left : '-40px'
			}, 500);
			$('#side-menu').stop().animate({
				left : '-300px'
			}, 100);
		}
	});
});

function toggle_visibility(id, id2) {

	var e = document.getElementById(id);
	var e2 = document.getElementById(id2);
	if ($(e).is(':visible') && !$(e2).is(':visible')) {
		$(e).filter(':not(:animated)').animate({
			height : 'toggle',
		}, 300).queue(function() {
			$(e2).filter(':not(:animated)').fadeIn(300);
			$(this).dequeue();
		});
	} else {
		$(e2).filter(':not(:animated)').animate({
			height : 'toggle',
		}, 300).queue(function() {
			$(e).filter(':not(:animated)').fadeIn(300);
			$(this).dequeue();
		});
	}
}

function aficher(id) {
	document.getElementById(id).style.display = 'block';
}

function toggle_visibility_fd(id, id2) {
	var e = document.getElementById(id);
	var e2 = document.getElementById(id2);
	if ($(e).is(':visible') && !$(e2).is(':visible')) {
		$(e).filter(':not(:animated)').fadeOut(300).queue(function() {
			$(e2).filter(':not(:animated)').fadeIn(300);
			$(this).dequeue();
		});
	} else {
		$(e2).filter(':not(:animated)').fadeOut(300).queue(function() {
			$(e).filter(':not(:animated)').fadeIn(300);
			$(this).dequeue();
		});
	}
	setTimeout(function() {
		$('.bodyOverlay').remove();
	}, 300);
}
