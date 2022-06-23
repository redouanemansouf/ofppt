/*en attente de la carte multiservice*/
//$(document).ready(function() {
//	setTimeout(process(), 2000);
//});

//REVENIR VERS LA PAGE D'INACTIVITÉ
function backToHome() {
	toggle_visibility_fd('home', 'reservationForm');
	/* setTimeout(process(), 2000); */
}

// DÉBITER LE SOLDE DE L'USAGER
function debiterSolde() {
	try {
		var montant = document.getElementById("montant-input").value;
		appid.debiterSolde(montant);
	} catch (err) {
		alert("Error JS Etudiant  : " + err + "\nresultat catch : "
				+ appid.resultat);
	}
}

// DÉBITER LE SOLDE DE L'USAGER
function crediterSolde() {
	try {
		var montant = document.getElementById("montant-input").value;
		montant = "-" + montant;
		appid.debiterSolde(montant);
	} catch (err) {
		alert("Error JS Etudiant  : " + err + "\nresultat catch : "
				+ appid.resultat);
	}
}

// ENCODER LA RÉSERVATION DANS LA CARTE
function ecrireReservation() {
	try {
		appid.reservationArrayAsString = document
				.getElementById("reservationAsString-input").value;
		appid.ecrireReservation();
	} catch (err) {
		alert("Error JS Etudiant  : " + err + "\nresultat catch : "
				+ appid.resultat);
	}
}

function process() {
	try {
		var x = getUsager();
		if (x) {
			if (appid.numeroCarte == "") {
				toggle_visibility_fd('home', 'echec');
				setTimeout("toggle_visibility_fd('home', 'echec')", 5000);
			} else {
				firstFunction(function() {
					checkCardValidity;
				});
			}
		}
	} catch (err) {
		alert("Error Process function  : " + err + "\nresultat catch : ");
	}

}

// CHECK THE VALIDITY OF CARD
function checkCardValidity() {
	var validityOfCard = false;
	validityOfCard = document.getElementById("validityOfCard-input").value;
	if (validityOfCard == 'true') {
		toggle_visibility_fd('home', 'reservationForm');
	} else {
		toggle_visibility_fd('home', 'echec');
		setTimeout("toggle_visibility_fd('home', 'echec')", 5000);
	}
}

// WAIT FOR ONE FUNCTION TO FINISH BEFORE CONTINUING
function firstFunction(_callback) {
	processHiddenInputText();
	_callback();
}

function terminerReservation() {
	var error = true;
	error = document.getElementById("error-input").value;
	if (error == 'false') {
		ecrireReservation();
		debiterSolde();
		getUsager();
	}
}

// RÉCUPERER LES INFORMATIONS DE L'USAGER
function getUsager() {
	var x = false;
	try {
		x = appid.getUsager();
		var nomUsager = appid.nomUsager;
		var prenomUsager = appid.prenomUsager;
		var soldeUsager = appid.soldeUsager;
		var dateDerniereConnexion = appid.dateDerniereConnexion;
		var numeroCarte = appid.numeroCarte;
		var codeRestaurant = appid.codeRestaurant;

		// output text
		$("#nomUsager-output").text(nomUsager);
		$("#prenomUsager-output").text(prenomUsager);
		/* $("#soldeUsager-output").text(soldeUsager); */
		$("#dateDerniereConnexion-output").text(dateDerniereConnexion);

		// input text
		document.getElementById("nomUsager-input").value = nomUsager;
		document.getElementById("prenomUsager-input").value = prenomUsager;
		document.getElementById("soldeUsager-input").value = soldeUsager;
		document.getElementById("dateDerniereConnexion-input").value = dateDerniereConnexion;
		document.getElementById("numeroCarte-input").value = numeroCarte;
		document.getElementById("codeRestaurant-input").value = codeRestaurant;

		// processHiddenInputText();

	} catch (err) {
		alert("Error JS Etudiant  : " + err + "\nresultat catch : "
				+ appid.resultat);
	}
	return x;
}

function disablePending(id) {
	var e = document.getElementById(id);
	$(e).append('<div class="bodyOverlay" />');
}


$(function() {
    $('.open').click(function() {
        $('body').fullscreen();
        return false;
    });
    $('.close').click(function() {
        $.fullscreen.exit();
        return false;
    });
});
