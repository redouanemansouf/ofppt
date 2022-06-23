// transform login and menu panel to center


var lastRowCount_depart = 0;

/**
 * Listener sur la datatable de l'entité afain de lancer la method
 * _updateCrudMenuDepart()
 * 
 * _updateCrdMenu(): remoteCommand qui lance un ajax update sur la bar du menu,
 * permet d'activer/désactiver les bouttons selon la séléction
 * 
 * @author amtarji
 * 
 */
$(document).on(
		'click',
		'.RefCenter_content',
		function() {
			try {
				var _entityTable = PF('entity-depart-dtbl-wdg');

				var rowCount = _entityTable.getSelectedRowsCount();

				if (rowCount > 0 && lastRowCount_depart == 0) {
					_updateCrudMenuDepart();
				}
				if (rowCount == 0 && lastRowCount_depart > 0) {
					_updateCrudMenuDepart();
				}
				var pageRecords = $(PrimeFaces.escapeClientId(_entityTable.id))
						.find('tr').length - 1;
				if (pageRecords == 1 && rowCount == 1 && lastRowCount_depart == 0) {
					_updateCrudMenuDepart();
				}
				lastRowCount_depart = rowCount;
			} catch (e) {
				// ignore
			}

		});
/**
 * Method d'init du rowcount lancer aprés UC de suppression
 * 
 * @author amtarji
 */
function initCrudMenu() {
	try {
		lastRowCount_depart = 0;
		_updateCrudMenuDepart();
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
		if (lastRowCount_depart != 0) {
			initCrudMenu();
			PF('entity-depart-dtbl-wdg').clearSelection();
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
function backToFirstPage_depart() {
	try {
		var _entityTable = PF('entity-depart-dtbl-wdg');
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		if (currentPage != 0) {
			_entityTable.getPaginator().setPage(0);
		}
	} catch (e) {
		// ignore
	}
}

/**
 * block entity-depart-dtbl-wdg durant le traitement
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
 * deblock entity-depart-dtbl-wdg durant le traitement
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
}

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
		var _entityTable = PF('entity-depart-dtbl-wdg');
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
		var _entityTable = PF('entity-depart-dtbl-wdg');
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
	if (lastRowCount_depart != 0) {
		try {
			PF('delete-depart-wdg').jq.click();
		} catch (e) {
			// ignore
		}
	}
}
// Page suivante
function nextPageHK() {
	try {
		var _entityTable = PF('entity-depart-dtbl-wdg');
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		_entityTable.getPaginator().setPage(currentPage + 1);
	} catch (e) {
		// ignore
	}
}
// Page précédente
function previousPageHK() {
	try {
		var _entityTable = PF('entity-depart-dtbl-wdg');
		var currentPage = _entityTable.getPaginator().getCurrentPage();
		_entityTable.getPaginator().setPage(currentPage - 1);
	} catch (e) {
		// ignore
	}
}