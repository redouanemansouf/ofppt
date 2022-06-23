function fabrication_carte() {

				try {
					var version = "null";
					//alert("Début fabrication.........................");

					//app.getVersion();

					if (document.getElementById("num_carte").value == "") {
						app.numeroCarte = " ";
					} else {
						app.numeroCarte = document.getElementById("num_carte").value;
					}

					//app.numeroCarte ="1258741";

					if (document.getElementById("id_person").value == "") {
						app.idEtudiant = " ";
					} else {
						app.idEtudiant = document.getElementById("id_person").value;
					}

					//app.idEtudiant = "1258741";

					if (document.getElementById("nom_person").value == "") {
						app.nomNaissEtudiant = " ";
					} else {
						app.nomNaissEtudiant = document
								.getElementById("nom_person").value;
					}

					//app.nomNaissEtudiant = "SADIK";

					if (document.getElementById("prenom_person").value == "") {
						app.prenomEtudiant = " ";
					} else {
						app.prenomEtudiant = document
								.getElementById("prenom_person").value;
					}

					//app.prenomEtudiant = "Mohamed";

					app.soldeCarte = "0";

					if (document.getElementById("email_person").value == "") {
						app.adreEmailEtudiant = " ";
					} else {
						app.adreEmailEtudiant = document
								.getElementById("email_person").value;
					}

					//app.adreEmailEtudiant = "msadik01@gmail.com";

					if (document.getElementById("NCIN_person").value == "") {
						app.cniEtudiant = " ";
					} else {
						app.cniEtudiant = document
								.getElementById("NCIN_person").value;
					}

					//app.cniEtudiant = "JA94458";

					app.plafondMaxSolde = "";

					app.nbrMaxTransOffline = "";

					if (document.getElementById("rest_code").value == "") {
						app.codeRestaurant = " ";
					} else {
						app.codeRestaurant = document
								.getElementById("rest_code").value;
					}

					if (document.getElementById("libCit_person").value == "") {
						app.libCite = " ";
					} else {
						app.libCite = document.getElementById("libCit_person").value;
					}

					//app.libCite ="JA94436";

					if (document.getElementById("rest_person").value == "") {
						app.restaurant = " ";
					} else {
						app.restaurant = document.getElementById("rest_person").value;
					}

					//app.restaurant = "SOUISSI";

					if (document.getElementById("codCit_person").value == "") {
						app.codeCite = " ";
					} else {
						app.codeCite = document.getElementById("codCit_person").value;
					}

					if (document.getElementById("dat_naissance").value == "") {
						app.annAcademiqueEtudiant = " ";
					} else {
						app.annAcademiqueEtudiant = document
								.getElementById("dat_naissance").value;
					}
					if (document.getElementById("date_exp").value == "") {
						app.dateexpirationcarteEtudiant = " ";
					} else {
						app.dateexpirationcarteEtudiant = document
								.getElementById("date_exp").value;
					}
					
					
					

					app.cheminexeimpression = "C:/Carte_UCAD/Exe_Impression";

					app.chemincarteverso = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

					app.chemincarterecto = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

				//	alert("debut impression Veuillez attendre ....");

					version = app.LancerExe("cmd /c C:/Carte_UCAD/Exe_Impression"
						+ "\\IMPRESSION_CARTE.exe " + "1");

					version = app.EcritureElectriqueCrazy(1);
				//	alert("fin impression");
					_personnalise();

					//alert("resultat normal " + app.resultat);
				} catch (err) {
					

					alert("Error JS ETUDIANT : " + err + "\nresultat catch : "
							+ app.resultat);

				}

			}

			function visualisationcarte() {

				try {

					var version = "null";

					if (document.getElementById("id_person").value == "") {
						app.numeroCarte = " ";
					} else {
						app.numeroCarte = document.getElementById("id_person").value;
					}

					//app.numeroCarte ="1258741";

					if (document.getElementById("id_person").value == "") {
						app.idEtudiant = " ";
					} else {
						app.idEtudiant = document.getElementById("id_person").value;
					}

					app.chemincarteverso = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

					app.chemincarterecto = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

					alert("Debut visualisation")

					//			 			   version = appid.GetVersion();
					version = app.appercuCarte(1);

				} catch (err) {

					alert("Error de l'aperçue de Carte Etudiant  : " + err);

				}
			}

			function fabrication_Lot_carte() {
				 
				try {
					
					var selectedIds = [];
					var impression=null;

					$(":checked").each(function() {
					    selectedIds.push($(this).parent().parent().parent().parent().attr('data-ri'));
					});
					for(var i in selectedIds )
					{
						if(selectedIds[i]!=undefined){
					//	alert(selectedIds[i])
						//
						

						if ($("#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_num_carte")
								.val() == "") {
							app.numeroCarte = " ";
						} else {
							app.numeroCarte = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_num_carte").val();
						}
						if ($("#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_id_person")
								.text() == "") {
							app.idEtudiant = " ";
						} else {
							app.idEtudiant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_id_person").text();
						}

						if ($("#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_idnom")
								.text() == "") {
							app.nomNaissEtudiant = " ";
						} else {
							app.nomNaissEtudiant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_idnom").text();
						}

						//app.nomNaissEtudiant = "SADIK";

						if ($("#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_idprenom")
								.text() == "") {
							app.prenomEtudiant = " ";
						} else {
							app.prenomEtudiant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_idprenom").text();
						}
						app.soldeCarte = "0";

						if ($("#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_email_etud")
								.val() == "") {
							app.adreEmailEtudiant = " ";
						} else {
							app.adreEmailEtudiant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_email_etud").val();
						}
						if ($("#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_ncin")
								.text() == "") {
							app.cniEtudiant = " ";
						} else {
							app.cniEtudiant = $(
									"#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_ncin")
									.text();
						}
						app.plafondMaxSolde = "";
						app.nbrMaxTransOffline = "";

						if ($("#nationalite-dtbl\\:" + selectedIds[i] + "\\:tabl_rest_code")
								.val() == "") {
							app.codeRestaurant = " ";
						} else {
							app.codeRestaurant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_rest_code").val();
						}

						if ($(
								"#nationalite-dtbl\\:" + selectedIds[i]
										+ "\\:tab_libCit_person").val() == "") {
							app.libCite = " ";
						} else {
							app.libCite = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tab_libCit_person").val();
						}

						if ($(
								"#nationalite-dtbl\\:" + selectedIds[i]
										+ "\\:tabl_rest_person").val() == "") {
							app.restaurant = " ";
						} else {
							app.restaurant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_rest_person").val();
						}

						//app.restaurant = "SOUISSI";

						if ($(
								"#nationalite-dtbl\\:" + selectedIds[i]
										+ "\\:tabl_codCit_person").val() == "") {
							app.codeCite = " ";
						} else {
							app.codeCite = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_codCit_person").val();
						}

						if ($(
								"#nationalite-dtbl\\:" + selectedIds[i]
										+ "\\:tabl_date").text() == "") {
							app.annAcademiqueEtudiant = " ";
						} else {
							app.annAcademiqueEtudiant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_date").text();
						}
						if ($(
								"#nationalite-dtbl\\:" + selectedIds[i]
										+ "\\:tabl_dat_exp").text() == "") {
							app.dateexpirationcarteEtudiant = " ";
						} else {
							app.dateexpirationcarteEtudiant = $(
									"#nationalite-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_dat_exp").text();
						}
						
						
						

						app.cheminexeimpression = "C:/Carte_UCAD/Exe_Impression";

						app.chemincarteverso = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

						app.chemincarterecto = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

					version = app.LancerExe("cmd /c C:/Carte_UCAD/Exe_Impression"
								+ "\\IMPRESSION_CARTE.exe " + "1");
						
					version = app.EcritureElectriqueCrazy(1);
					
				
					
					  sleepWait(60);
//					
//						  setTimeout(function(){
//							  app.LancerExe("cmd /c C:/Carte_UCAD/Exe_Impression"
//											+ "\\IMPRESSION_CARTE.exe " + "1");
//							}, 90000);
//							  
							  
							  // impression = app.LancerExe("cmd /c C:/Carte_UCAD/Exe_Impression"
										//+ "\\IMPRESSION_CARTE.exe " + "1");
						//alert("fin impression");
						//	_personnalise();

						//alert("resultat normal " + app.resultat);
					}
					}
					_personnaliseCollection();
				} catch (err) {
   
					
					
					alert("Error JS ETUDIANT : " + err + "\nresultat catch : "
							+ app.resultat);

				}

			}
			
			function sleep(milliseconds) {
				  var start = new Date().getTime();
				  for (var i = 0; i < 1e7; i++) {
				    if ((new Date().getTime() - start) > milliseconds){
				      break;
				    }
				  }
				}
			
			function fabrication_lot_caissier() {
				 
				try {
               
					var selectedIds = [];
					var impression=null;

					$(":checked").each(function() {
					    selectedIds.push($(this).parent().parent().parent().parent().attr('data-ri'));
					});
					for(var i in selectedIds )
					{
						if(selectedIds[i]!=undefined){

						if ($("#caissier-dtbl\\:" + selectedIds[i] + "\\:caissier-dtbl-code")
								.val() == "") {
							app.codeCaissier = " ";
						} else {
							app.codeCaissier = $(
									"#caissier-dtbl\\:" + selectedIds[i]
											+ "\\:tabl_num_carte").val();
						}
						if ($("#caissier-dtbl\\:" + selectedIds[i] + "\\:caissier-dtbl-codeReest")
								.text() == "") {
							app.codeRestCaissier = " ";
						} else {
							app.codeRestCaissier = $(
									"#caissier-dtbl\\:" + selectedIds[i]
											+ "\\:caissier-dtbl-codeReest").text();
						}

						

						app.cheminexeimpression = "C:/Carte_UCAD/Exe_Impression";

						app.chemincarteverso = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

						app.chemincarterecto = "C:/Carte_UCAD/Cartes_PreImprimees/Etudiants";

					version = app.LancerExe("cmd /c C:/Carte_UCAD/Exe_Impression"
								+ "\\IMPRESSION_CARTE.exe " + "1");
						

							  impression = app.EcritureElectriqueCrazy(1);
						//  setTimeout(function(){
							//	  app.LancerExe("cmd /c C:/Carte_UCAD/Exe_Impression"
											//	+ "\\IMPRESSION_CARTE.exe " + "1");
						//	}, 30000);
//							  
							   // sleep(30000);
							  // impression = app.LancerExe("cmd /c C:/Carte_UCAD/Exe_Impression"
										//+ "\\IMPRESSION_CARTE.exe " + "1");
						//alert("fin impression");
						//	_personnalise();

						//alert("Veuillez attendre le carte N° :"+i);
							  
							
					}
					}
					_personnaliseCollection();
				} catch (err) {

					alert("Error JS ETUDIANT : " + err + "\nresultat catch : "
							+ app.resultat);

				}

			}
			
			function sleepWait(seconds){
			    var waitUntil = new Date().getTime() + seconds*1000;
			    while(new Date().getTime() < waitUntil) true;
			}