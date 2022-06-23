var loader = document.getElementById('ajaxLoader');

var ongoingJS = false;

window.onmousemove = function(e) {
	var x = e.clientX, y = e.clientY;
	loader.style.top = (y + 20) + 'px';
	loader.style.left = (x + 20) + 'px';
};

$(window).load(function() {
	addCustomScrollBars();
});

function addCustomScrollBars() {
	try {
		$(
				".Scrollable,.ui-selectlistbox-listcontainer, .ui-selectmanymenu .ui-selectlistbox-listcontainer,.ui-multiselectlistbox-listcontaine")
				.mCustomScrollbar({
					scrollInertia : 0,
					theme : "dark-3",
					mouseWheel : {
						preventDefault : false
					},
					scrollButtons : {
						enable : true
					}
				});
	} catch (e) {
		// ignore
	}
}
jQuery(document)
		.ready(
				function($) {
					var offset = 300, offset_opacity = 1200, scroll_top_duration = 700, $back_to_top = $('.cd-top');

					$(window)
							.scroll(
									function() {
										($(this).scrollTop() > offset) ? $back_to_top
												.addClass('cd-is-visible')
												: $back_to_top
														.removeClass('cd-is-visible cd-fade-out');
										if ($(this).scrollTop() > offset_opacity) {
											$back_to_top
													.addClass('cd-fade-out');
										}
									});

					$back_to_top.on('click', function(event) {
						event.preventDefault();
						$('body,html').animate({
							scrollTop : 0,
						}, scroll_top_duration);
					});

				});

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
	addCustomScrollBars();
}
function show(id) {
	var e = document.getElementById(id);
	if (!$(e).is(':visible')) {
		$(e).fadeIn(300);
	}
}
function toggle_SearchMode(id) {
	var e = document.getElementById(id);

	if ($(e).hasClass('is-onSearchMode')) {
		$(e).find('.row>div:nth-child(1)').stop().toggle(function() {
			$(e).removeClass('is-onSearchMode');
			$(e).addClass('is-offSearchMode');
		});
	} else {
		$(e).addClass('is-onSearchMode');
		$(e).removeClass('is-offSearchMode', function() {
			$(e).find('.row>div:nth-child(1)').stop().toggle(function() {

			});
		});
	}
	addCustomScrollBars();
}
function toggleAdvancedSearch(id) {

	var e = document.getElementById(id);
	$(e).stop().animate({
		height : 'toggle',
	}, 500);

	if ($('.AdvancedSearchButton').hasClass('is-active')) {
		$('.AdvancedSearchButton').removeClass('is-active');
	} else {
		$('.AdvancedSearchButton').addClass('is-active');
	}
	addCustomScrollBars();
}

$.fn.scrollView = function() {
	return this.each(function() {
		$('html, body').animate({
			scrollTop : $(this).offset().top
		}, 1000);
	});
}

function swapStyleSheet(sheet) {
	document.getElementById('idCommunStyle').setAttribute('href', sheet);
}

function showOverlay(event, id) {
	var e = document.getElementById(id);
	e.style.top = event.pageY + 10 + 'px';
	e.style.left = event.pageX + 15 + 'px';
	$(e).stop().animate({
		height : 'toggle',
	}, 350);

}
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
function toggle_visibility_ht(id, id2) {
	var e = document.getElementById(id);
	$(e).stop().animate({
		height : 'toggle',
	}, 350);
	if (typeof id2 !== 'undefined') {
		var e2 = document.getElementById(id2);
		$(e2).stop().animate({
			height : 'toggle',
		}, 350);

		// var display = $(e).css('display');
		// if (display !== 'none') {
		// $(e).scrollIntoView();
		// } else {
		// $(e2).scrollIntoView();
		// }
	}
	addCustomScrollBars();
}

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
		})
	}
	addCustomScrollBars();
}
$(document).ready(
		function() {

			$('.ui-datatable').click(function() {
				$('.CrudGhostPanel').show();
			});

			// $('.ui-row-toggler').click(function(){
			// $('.ui-expanded-row-content').stop().animate({
			// height:'toggle',},200)
			// })
			// });

			// $('.ui-expanded-row-content').load(function() {
			// $(this).stop().animate({
			// height : 'toggle',
			// }, 350);
			// });

			$('.MenuItem').hover(function() {
				$(this).find('.MenuLabel').addClass('active');

				$(this).find('.Curtain').stop().animate({
					height : '100%',
				}, 200);

				$(this).find('.MenuImg').addClass('active');

				$(this).find('.MenuImg').stop().animate({
					top : '15px',
				}, 200);

				$(this).find('.MenuLabel').stop().animate({
					top : '100px',
				}, 200);

			}, function() {

				if (!$(this).hasClass('clicked')) {
					$(this).find('.MenuImg').removeClass('active');

					$(this).find('.MenuImg').stop().animate({
						top : '55px',
					}, 200);

					$(this).find('.MenuLabel').stop().animate({
						top : '15px',
					}, 200);
					$(this).find('.MenuLabel').removeClass('active');

					$(this).find('.Curtain').stop().animate({
						height : '3px',
					}, 200);
				}

			});

			$('.MenuItem')
					.click(
							function() {

								if ($(this).hasClass('has-dropdown')
										&& !$(this).hasClass('clicked')) {

									$('.droped').parent().find(
											'.DropMenu_container').stop()
											.fadeOut(200);

									$('.droped').removeClass('clicked');
									$('.droped').find('.MenuImg').removeClass(
											'active');
									$('.droped').find('.MenuImg').stop()
											.animate({
												top : '55px',
											}, 200);
									$('.droped').find('.MenuLabel').stop()
											.animate({
												top : '15px',
											}, 200);
									$('.droped').find('.MenuLabel')
											.removeClass('active');

									$('.droped').find('.Curtain').stop()
											.animate({
												height : '3px',
											}, 200);

									$('.droped').removeClass('droped');
									$(this).addClass('clicked');
									if (!$(this).hasClass('droped')) {
										$(this).addClass('droped');

										$(this).parent().find(
												'.DropMenu_container').stop()
												.animate({
													height : 'toggle',
												}, 200);
									}
								} else if ($(this).hasClass('clicked')) {
									$('.droped').removeClass('clicked');
									$('.droped').parent().find(
											'.DropMenu_container').stop()
											.animate({
												height : 'toggle',
											}, 200);
									$('.droped').removeClass('droped');
								}

							});

			$('.Service_container').click(function() {
				$(this).parent().find('.IdForm').stop().animate({
					width : 'toggle',
				}, 200);

				if ($(this).hasClass('clicked')) {
					$(this).removeClass('clicked');
					PF('service-spotlight-wdg').unblock();
				} else {
					$(this).addClass('clicked');

					PF('service-spotlight-wdg').block();

					$(this).find('.Curtain').stop().animate({
						height : '100%',
					}, 200);
					$(this).find('.MenuImg').addClass('active');

					$(this).find('.MenuImg').stop().animate({
						top : '15px',
					}, 200);

					$(this).find('.MenuLabel').stop().animate({
						top : '100px',
					}, 200);
				}

			});

			// $(window).scroll(function() {
			// stickyNav();
			// });

		});

$(document).ready(
		function() {
			$('#datapanel-compte').find('.ui-datatable-data').find(
					'.ui-row-toggler').eq(0).trigger('click');
		});

$(function() {
	$('.ui-datatable-selectable').hover(function() {
		$('.DetailCursor').stop().fadeIn(200);
	}, function() {
		$('.DetailCursor').stop().fadeOut(200);
	});
});

// Fonction d'ajout d'un text par JS
function setUcTitle(id, title) {
	$(id).text(title);
}
function pfChartExtender() {
	this.cfg.grid = {

		// Set default options on all series, turn on smoothing.
		// seriesDefaults : {
		// rendererOptions : {
		// smooth : true
		// }
		//		},

		background : 'transparent',
		drawBorder : false,
		shadow : false,
		legend : {
			show : true,
			showSwatches : false,
		},
	};
}
function switchWidgetStatus(obj, wdg) {
	alert(obj.value);
	if (obj.value == 'on') {
		PF(wdg).enable();
	} else {
		PF(wdg).disable();
	}
}
function disable(elt) {
	$(elt).attr('disabled', 'true');
}
function enable(elt) {
	$(elt).attr('disabled', 'enabled');
}
// we override the default send function of
// primeFaces here, so we can disable a button after a click
// and enable it again after

// var primeFacesOriginalSendFunction = PrimeFaces.ajax.Request.send;
//
// PrimeFaces.ajax.Request.send = function(cfg) {
// var callSource = '';

// if not string, the caller is a process - in this case we do not interfere

// if (typeof (cfg.source) == 'string') {
//
// callSource = $(PrimeFaces.escapeClientId(cfg.source));
// callSource.attr('disabled', 'disabled');
//
// }

// in each case call original send
// primeFacesOriginalSendFunction(cfg);

// if we disabled the button - enable it again
// if (callSource != '') {
//
// callSource.attr('disabled', 'enabled');
//
// }
//
// };

// function handleDisableButton(data) {
// if (data.source.type != "submit") {
// return;
// }
//
// switch (data.status) {
// case "begin":
// data.source.disabled = true;
// break;
// case "complete":
// data.source.disabled = false;
// break;
// }
// }
//
// PrimeFaces.ajax.Request.send.addOnEvent(handleDisableButton);

// var originalPrimeFacesAjaxUtilsSend = PrimeFaces.ajax.Request.send;
//
// PrimeFaces.ajax.Request.send = function(cfg) {
// alert(cfg.status);
// if (typeof (cfg.source) == 'string') {
// callSource = $(PrimeFaces.escapeClientId(cfg.source));
// callSource.attr('disabled', 'disabled');
// }
//
// if (callSource != '')
// callSource.attr('disabled', 'enabled');
//
// originalPrimeFacesAjaxUtilsSend.apply(this, arguments);
// };
