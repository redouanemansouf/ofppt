PrimeFacesExt.locales.TimePicker['fr'] = {
	hourText : 'Heures',
	minuteText : 'Minutes',
	amPmText : [ 'AM', 'PM' ],
	closeButtonText : 'Fermer',
	nowButtonText : 'Maintenant',
	deselectButtonText : 'Désélectionner'
};

var lastRowCount = 0;

/**
 * Listener sur la datatable de l'entité afain de lancer la method
 * _updateCrudMenu()
 * 
 * _updateCrdMenu(): remoteCommand qui lance un ajax update sur la bar du menu,
 * permet d'activer/désactiver les bouttons selon la séléction
 * 
 * @author amtarji
 * 
 */
$(document).on(
		'click',
		'.RefCenter',
		function() {
			try {
				var _entityTable = PF('entity-dtbl-wdg');

				var rowCount = _entityTable.getSelectedRowsCount();

				if (rowCount > 0 && lastRowCount == 0) {
					_updateCrudMenu();
				}
				if (rowCount == 0 && lastRowCount > 0) {
					_updateCrudMenu();
				}
				var pageRecords = $(PrimeFaces.escapeClientId(_entityTable.id))
						.find('tr').length - 1;
				if (pageRecords == 1 && rowCount == 1 && lastRowCount == 0) {
					_updateCrudMenu();
				}
				lastRowCount = rowCount;
			} catch (e) {
				// ignore
			}

		});

function activateFilter() {
	$('.SearchButton').addClass('activeFilter');
};
function disableFilter() {
	$('.SearchButton').removeClass('activeFilter');
};
/**
 * Method d'init du rowcount lancer aprés UC de suppression
 * 
 * @author amtarji
 */
function initCrudMenu() {
	try {
		lastRowCount = 0;
		_updateCrudMenu();
	} catch (e) {
		// ignore
	}
};
/**
 * vider la selection aprés pagination
 * 
 * @author amtarji
 */
function clearSelectionAfterPagination() {
	try {
		if (lastRowCount != 0) {
			initCrudMenu();
			PF('entity-dtbl-wdg').clearSelection();
		}
	} catch (e) {
		// ignore
	}
}
/**
 * revenir à la premiére page (cas de la recherche)
 * 
 * @author amtarji
 */
function backToFirstPage() {
	try {
		var _entityTable = PF('entity-dtbl-wdg');
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		if (currentPage != 0) {
			_entityTable.getPaginator().setPage(0);
		}
	} catch (e) {
		// ignore
	}
}

/**
 * block entity-dtbl-wdg durant le traitement
 * 
 * @author amtarji
 */
function block(wdg) {
	if (typeof wdg === 'undefined') {
		wdg = 'block-dtbl-wdg';
	}
	try {
		PF(wdg).block();
	} catch (e) {
		// ignor
	}
}
/**
 * deblock entity-dtbl-wdg durant le traitement
 * 
 * @author amtarji
 */
function unblock(wdg) {
	if (typeof wdg === 'undefined') {
		wdg = 'block-dtbl-wdg';
	}
	try {
		PF(wdg).unblock();
	} catch (e) {
		// ignor
	}
};
/**
 * cocher tout pour selectcheckboxmenu
 * 
 * @author amtarji
 * @param wdg
 */
function selectAllCheckBoxes(wdg) {
	try {
		PF(wdg).inputs.each(function() {
			// if (PF(wdg).isChecked()) {
			$(this).prop('checked', false)
			// PF(wdg).jq.find('.ui-chkbox-box').text('Uncheck all')
			// } else {
			// $(this).prop('checked', true)
			// PF(wdg).jq.find('.ui-chkbox-label').text('Check all')
			// }
			$(this).trigger('click');
		})
	} catch (e) {
		// ignor
	}
};

function unSelectAllCheckBoxes(wdg) {
	try {
		PF(wdg).inputs.each(function() {
			$(this).prop('checked', true)
			$(this).trigger('click');
		})
	} catch (e) {
		// ignor
	}
};

/**
 * Fix JS Permettant de fixer le problème de pagination lors de la suppression
 * de tous les enregistrements d’une page en détectant préalablement s’il faut
 * revenir d’une page ou non. (avant l’update, important d’appeler cette méthode
 * par onStart)
 * 
 * fixPaginatorAfCollectionDelete() : Lancer par le boutton
 * supprimerCollection()
 * 
 * fixPaginatorAfSingleDelete() : Lancer par le boutton supprimer()
 * 
 * @author amtarji
 */
function fixPaginatorAfCollectionDelete() {
	try {
		var _entityTable = PF('entity-dtbl-wdg');
		var rowCount = _entityTable.getSelectedRowsCount();
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		if (currentPage != 0) {
			var pageRecords = $(PrimeFaces.escapeClientId(_entityTable.id))
					.find('tr').length - 1;
			if (pageRecords == rowCount) {
				_entityTable.getPaginator().setPage(currentPage - 1);
			}
		}
	} catch (e) {
		// ignore
	}
}
function fixPaginatorAfSingleDelete() {
	try {
		var _entityTable = PF('entity-dtbl-wdg');
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		if (currentPage != 0) {
			var pageRecords = $(PrimeFaces.escapeClientId(_entityTable.id))
					.find('tr').length - 1;
			if (pageRecords == 1) {
				_entityTable.getPaginator().setPage(currentPage - 1);
			}
		}
	} catch (e) {
		// ignore
	}
}

/**
 * Hot key functions
 * 
 * @author amtarji
 */
// Suppression
function deleteHK() {
	if (lastRowCount != 0) {
		try {
			PF('delete-wdg').jq.click();
		} catch (e) {
			// ignore
		}
	}
}
// Page suivante
function nextPageHK() {
	try {
		var _entityTable = PF('entity-dtbl-wdg');
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		_entityTable.getPaginator().setPage(currentPage + 1);
	} catch (e) {
		// ignore
	}
}
// Page précédente
function previousPageHK() {
	try {
		var _entityTable = PF('entity-dtbl-wdg');
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		_entityTable.getPaginator().setPage(currentPage - 1);
	} catch (e) {
		// ignore
	}
}