/**
 * 
 */
function capturer() {

				try {

					var version = "null";

					//N� EMPLOI PERSONNEL   
					if (document.getElementById("j_code").value == "") {
						appid.numEmploiPersonnel = " ";
					} else {
						appid.numEmploiPersonnel = document
								.getElementById("j_code").value;
					}

					// 		    alert("appid.numEmploiPersonnel  : " + appid.numEmploiPersonnel); 

					//CHEMIN ENREGISTREMENT PHOTO  
					if (document.getElementById("j_cheminEnregPho").value == "") {
						appid.cheminenregphoto = " ";
					} else {
						appid.cheminenregphoto = document
								.getElementById("j_cheminEnregPho").value;
					}

					//        	 alert("appid.cheminenregphoto  : " + appid.cheminenregphoto); 

					//CHEMIN EXE ACQUISITION   
					if (document.getElementById("j_cheminExePho").value == "") {
						appid.cheminexeacquisition = " ";
					} else {
						appid.cheminexeacquisition = document
								.getElementById("j_cheminExePho").value;
					}

					// 			 alert("appid.cheminexeacquisition  : " + appid.cheminexeacquisition); 

					//        	       version = appid.GetVersion();
					version = appid.LancerExe("cmd /c "
							+ appid.cheminexeacquisition
							+ "\\CAPTURE_PHOTO.exe " + " "
							+ appid.numEmploiPersonnel + " "
							+ appid.cheminenregphoto + "\\");

				} catch (err) {

					alert("Error de Capture Photo Personnel  : " + err);

				}
			}

			function visualisationcarte() {

				try {

					var version = "null";

					//N� ETUDIANT   
					if (document.getElementById("j_code").value == "") {
						appid.numEmploiPersonnel = " ";
					} else {
						appid.numEmploiPersonnel = document
								.getElementById("j_code").value;
					}

					// 		    alert("appid.numEmploiPersonnel  : " + appid.numEmploiPersonnel);

					//CHEMIN CARTE RECTO  
					if (document.getElementById("j_cheminCarteRecto").value == "") {
						appid.chemincarterecto = " ";
					} else {
						appid.chemincarterecto = document
								.getElementById("j_cheminCarteRecto").value;
					}
					// 		 	alert("appid.chemincarterecto  : " + appid.chemincarterecto);

					//CHEMIN CARTE VERSO  
					if (document.getElementById("j_cheminCarteVerso").value == "") {
						appid.chemincarteverso = " ";
					} else {
						appid.chemincarteverso = document
								.getElementById("j_cheminCarteVerso").value;
					}

					// 		 	alert("appid.chemincarteverso  : " + appid.chemincarteverso);

					// 			   version = appid.GetVersion();
					version = appid.appercuCarte(2);

				} catch (err) {

					alert("Error d'aper�ue de Carte Personnel : " + err);

				}
			}

			function impressioncarte() {

				try {

					var version = "null";

					//N� EMPLOI  
					if (document.getElementById("j_code").value == "") {
						appid.numEmploiPersonnel = " ";
					} else {
						appid.numEmploiPersonnel = document
								.getElementById("j_code").value;
					}

					// 			alert("appid.numEmploiPersonnel  : " + appid.numEmploiPersonnel); 

					//MATR  
					if (document.getElementById("matr1").value == "") {
						appid.matrPersonnel = " ";
					} else {
						appid.matrPersonnel = document.getElementById("matr1").value;
					}

					// 				alert("appid.matrPersonnel  : " + appid.matrPersonnel);

					//NOM  
					if (document.getElementById("j_nom").value == "") {
						appid.nomNaissancePersonnel = " ";
					} else {
						appid.nomNaissancePersonnel = document
								.getElementById("j_nom").value;
					}

					// 					alert("appid.nomNaissancePersonnel  : " + appid.nomNaissancePersonnel);

					//PRENOM  
					if (document.getElementById("j_prenom").value == "") {
						appid.prenomPersonnel = " ";
					} else {
						appid.prenomPersonnel = document
								.getElementById("j_prenom").value;
					}

					// 				alert("appid.prenomPersonnel  : " + appid.prenomPersonnel);

					//NOM_MARITAL  
					if (document.getElementById("j_nom_mar").value == "") {
						appid.nomMaritalPersonnel = " ";
					} else {
						appid.nomMaritalPersonnel = document
								.getElementById("j_nom_mar").value;
					}

					//   				alert("appid.nomMaritalPersonnel  : " + appid.nomMaritalPersonnel);

					//DATE EMBAUCHE  
					if (document.getElementById("date_embauche").value == "") {
						appid.dateEmbauchePersonnel = " ";
					} else {
						appid.dateEmbauchePersonnel = document
								.getElementById("date_embauche").value;
					}

					// 				alert("appid.dateEmbauchePersonnel  : " + appid.dateEmbauchePersonnel);

					//SEXE  
					if (document.getElementById("Sexe:0").checked) {
						appid.sexePersonnel = "M";
					} else if (document.getElementById("Sexe:1").checked) {
						appid.sexePersonnel = "F";
					} else {
						appid.sexePersonnel = " ";
					}

					// 				alert("appid.sexePersonnel  : " + appid.sexePersonnel);

					//DATE NAISSANCE 
					if (document.getElementById("datenaissancePerso").value == "") {
						appid.dateNaissancePersonnel = " ";
					} else {
						appid.dateNaissancePersonnel = document
								.getElementById("datenaissancePerso").value;
					}

					//   				alert("appid.dateNaissancePersonnel  : " + appid.dateNaissancePersonnel);

					//LIEU NAISSANCE 
					if (document.getElementById("j_lieu").value == "") {
						appid.lieuNaissancePersonnel = " ";
					} else {
						appid.lieuNaissancePersonnel = document
								.getElementById("j_lieu").value;
					}

					//   				alert("appid.lieuNaissancePersonnel  : " + appid.lieuNaissancePersonnel);

					//CNI  
					if (document.getElementById("cni").value == "") {
						appid.cniPersonnel = " ";
					} else {
						appid.cniPersonnel = document.getElementById("cni").value;
					}

					// 				alert("appid.cniPersonnel  : " + appid.cniPersonnel);

					//NATIONALITE  
					if (document.getElementById("j_nationalite").value == "") {
						appid.nationalitePersonnel = " ";
					} else {
						appid.nationalitePersonnel = document
								.getElementById("j_nationalite").value;
					}

					//   				alert("appid.nationalitePersonnel  : " + appid.nationalitePersonnel);

					//EMAIL  
					if (document.getElementById("j_email").value == "") {
						appid.emailPersonnel = " ";
					} else {
						appid.emailPersonnel = document
								.getElementById("j_email").value;
					}

					// 				alert("appid.emailPersonnel  : " + appid.emailPersonnel);

					//AFFECTATION  
					if (document.getElementById("affect").value == "") {
						appid.structAffectPersonnel = " ";
					} else {
						appid.structAffectPersonnel = document
								.getElementById("affect").value;
					}

					//  				alert("appid.structAffectPersonnel  : " + appid.structAffectPersonnel);

					//CLASSIFICATION  
					if (document.getElementById("classif").value == "") {
						appid.classificationPersonnel = " ";
					} else {
						appid.classificationPersonnel = document
								.getElementById("classif").value;
					}

					// 				alert("appid.classificationPersonnel  : " + appid.classificationPersonnel);

					//GRADE  
					if (document.getElementById("grade").value == "") {
						appid.gradePersonnel = " ";
					} else {
						appid.gradePersonnel = document.getElementById("grade").value;
					}

					//  				alert("appid.gradePersonnel  : " + appid.gradePersonnel);

					//SERVICES  
					if (document.getElementById("j_servicesP").value == "") {
						appid.infoservicesPersonnel = " ";
					} else {
						appid.infoservicesPersonnel = document
								.getElementById("j_servicesP").value;
					}

					//   				alert("appid.infoservicesPersonnel  : " + appid.infoservicesPersonnel);

					//CHEMIN CARTE RECTO  
					if (document.getElementById("j_cheminCarteRecto").value == "") {
						appid.chemincarterecto = " ";
					} else {
						appid.chemincarterecto = document
								.getElementById("j_cheminCarteRecto").value;
					}
					//   				alert("appid.chemincarterecto  : " + appid.chemincarterecto);

					//CHEMIN CARTE VERSO 
					if (document.getElementById("j_cheminCarteVerso").value == "") {
						appid.chemincarteverso = " ";
					} else {
						appid.chemincarteverso = document
								.getElementById("j_cheminCarteVerso").value;
					}
					//    				alert("appid.chemincarteverso  : " + appid.chemincarteverso);

					//CHEMIN EXE IMPRESSION  
					if (document.getElementById("j_cheminExeImpression").value == "") {
						appid.cheminexeimpression = " ";
					} else {
						appid.cheminexeimpression = document
								.getElementById("j_cheminExeImpression").value;
					}
					//   				alert("appid.cheminexeimpression  : " + appid.cheminexeimpression);

					//      		    version = appid.GetVersion(); 
					version = appid.LancerExe("cmd /c "
							+ appid.cheminexeimpression
							+ "\\IMPRESSION_CARTE.exe " + "1");
					version = appid.EcritureElectriqueCrazy(2);
					// //                 version = appid.LancerExe("cmd /c " + appid.cheminexeimpression + "\\IMPRESSION_CARTE.exe " + "2" + " "  
					// //  			    		                            + appid.chemincarterecto+"\\Carte_Etudiant_Recto_" + appid.idEtudiant + ".bmp"+ " " 
					// //  			    		                            + appid.chemincarteverso+"\\Carte_Etudiant_Verso_" + appid.idEtudiant + ".bmp"); 

				} catch (err) {

					alert("Error d'impression de Carte Personnel  : " + err);

				}
			}