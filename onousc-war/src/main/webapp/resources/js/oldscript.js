//PrimeFaces.locales['fr'] = {
//	closeText : 'Fermer',
//	prevText : 'Précédent',
//	nextText : 'Suivant',
//	monthNames : [ 'Janvier', 'Février', 'Mars', 'Avril', 'Mai', 'Juin',
//			'Juillet', 'Ao\u00FBt', 'Septembre', 'Octobre', 'Novembre',
//			'Décembre' ],
//	monthNamesShort : [ 'Jan', 'Fév', 'Mar', 'Avr', 'Mai', 'Jun', 'Jul', 'Aou',
//			'Sep', 'Oct', 'Nov', 'Déc' ],
//	dayNames : [ 'Dimanche', 'Lundi', 'Mardi', 'Mercredi', 'Jeudi', 'Vendredi',
//			'Samedi' ],
//	dayNamesShort : [ 'Dim', 'Lun', 'Mar', 'Mer', 'Jeu', 'Ven', 'Sam' ],
//	dayNamesMin : [ 'D', 'L', 'M', 'M', 'J', 'V', 'S' ],
//	weekHeader : 'Semaine',
//	firstDay : 1,
//	isRTL : false,
//	showMonthAfterYear : false,
//	yearSuffix : '',
//	timeOnlyTitle : 'Choisir l\'heure',
//	timeText : 'Heure',
//	hourText : 'Heures',
//	minuteText : 'Minutes',
//	secondText : 'Secondes',
//	currentText : 'Maintenant',
//	ampm : false,
//	month : 'Mois',
//	week : 'Semaine',
//	day : 'Jour',
//	allDayText : 'Toute la journée'
//};
//
//PrimeFaces.info("info message");
//PrimeFaces.warn("info message");
//PrimeFaces.error("info message");

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
function js_show(id) {
	var e = document.getElementById(id);
	$('.MiniAjax').stop().animate({
		width : 'show',
	}, 500);
};

/**
 * 
 * @param id
 *            hide element with id = id
 */
function js_hide(id) {
	var e = document.getElementById(id);
	$('.MiniAjax').stop().animate({
		width : 'hide',
	}, 500);
};
function js_toggleMiniAjax(styleClass) {
	if (typeof styleClass === 'undefined') {
		styleClass = '.MiniAjax';
	}
	try {
		PF(wdg).block();
	} catch (e) {
		// ignor
	}
	if ($(styleClass).hasClass('is-hidden')) {
		$(styleClass).removeClass('is-hidden');
	} else {
		$(styleClass).addClass('is-hidden');
	}
};

/*
 * function js_TransitionDA() { $('.js_DepartAller').stop().animate({ width :
 * 'hide', }, 500); $('.js_PlanAller').stop().animate({ width : 'show', }, 500); };
 */
/**
 * Ref main menu animation
 */
$(document).ready(function() {
	var ti = 1;
	$('*').each(function(e) {
		if (/input|select|button/i.test(this.tagName)) {
			$(this).attr("tabindex", ti++);
		}
	});
});

$(document).ready(function() {

	$('.MenuItem').hover(function() {
		$(this).find('.Curtain').stop().animate({
			height : '100%',
		}, 200);

		$(this).find('.MenuImg').stop().animate({
			top : '60%',
		}, 200);

		$(this).find('.MenuLabel').stop().animate({
			top : '10%',
		}, 200);

	}, function() {
		$(this).find('.Curtain').stop().animate({
			height : '4px',
		}, 200);

		$(this).find('.MenuImg').stop().animate({
			top : '10%',
		}, 200);

		$(this).find('.MenuLabel').stop().animate({
			top : '60%',
		}, 200);
	});

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

	$('.Aller_header').on('click', function() {
		var element = $(this).parent();
		if ($(this).hasClass('active')) {
			$(this).removeClass('active');
			element.find('.aller_container').slideUp();
		} else {
			$(this).addClass('active');
			element.find('.aller_container').slideDown();
			$('.Retour_header').removeClass('active');
			$('.retour_container').slideUp();
		}
	});

	$('.Retour_header').on('click', function() {
		var element = $(this).parent();
		if ($(this).hasClass('active')) {
			$(this).removeClass('active');
			element.find('.retour_container').slideUp();
		} else {
			$(this).addClass('active');
			element.find('.retour_container').slideDown();
			$('.Aller_header').removeClass('active');
			$('.aller_container').slideUp();
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

	$('.NotificationBar_button').click(function() {
		if ($('.NotificationBar_container').hasClass('openNotification')) {
			$('.NotificationBar_container').removeClass('openNotification');
		} else {
			$('.NotificationBar_container').addClass('openNotification');
		}
		if ($('.NotificationHandle').hasClass('NotifHandle_w')) {
			$('.NotificationHandle').removeClass('NotifHandle_w');
			$('.NotificationHandle').addClass('NotifHandle_n');
		} else {
			$('.NotificationHandle').addClass('NotifHandle_w');
			$('.NotificationHandle').removeClass('NotifHandle_n');
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
	/** caisse flag * */

	$('.CaisseFlagOperator').click(function() {
		var caisseFlag = $(this).parent().parent();
		if (caisseFlag.hasClass('show')) {
			caisseFlag.removeClass('show');
			caisseFlag.addClass('hide');
			// sessvars.sideMenuState['state'] = 'open';
			caisseFlag.stop().animate({
				right : '-730px'
			}, 500);
		} else {
			caisseFlag.removeClass('hide');
			caisseFlag.addClass('show');
			caisseFlag.stop().animate({
				right : '-5px'
			}, 500);
		}
	});
	/** error tooltip BG color ** */
	$('.ui-inputfield').hover(function() {
		$('.ui-tooltip-content').addClass('BackgrounRed');
	}, function() {
	});
});
