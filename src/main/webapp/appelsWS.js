function charger() {
	let httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				let contenuJSON = JSON.parse(httprequest.responseText);
				let maDiv = document.getElementById("note_holder");
				maDiv.innerHTML = "";
				let br = document.createElement("br");
				let elem = document.createElement("div");
				for (i = 0; i < contenuJSON.length; i++) {
					let iElem = document.createElement("div");
					let date = document.createElement("p");
					date.innerHTML = contenuJSON[i].dateDeCreation;
					let taNote = document.createElement("textarea");
					taNote.innerHTML = contenuJSON[i].note;
					let delButton = document.createElement("button");
					let modifyButton = document.createElement("button");
					modifyButton.innerHTML = "Modify";
					let id = contenuJSON[i].id;
					modifyButton.onclick = function() {
						let nouveauText = this.parentNode.querySelector("textarea").value;
						this.parentNode.querySelector("textarea").innerHTML = nouveauText;
						modifier(id,nouveauText);
					}
					
					delButton.innerHTML = "Delete";
					delButton.onclick = function() {
						this.parentNode.remove();
						supprimer(id);
					}
					iElem.appendChild(date);
					iElem.appendChild(taNote);
					iElem.appendChild(modifyButton);
					iElem.appendChild(delButton);
					iElem.appendChild(br);
					elem.appendChild(iElem);
				}
				maDiv.appendChild(elem);
			} else {
				alert("Une erreur s'est produite : " + httprequest.status);
			}
		}
	};

	httprequest.open("GET", "webapi/notes", true);
	httprequest.send();

}

function envoyer() {
	let httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				charger();
			} else {
				alert("Une erreur s'est produite : "+httprequest.status);
			}
		}
	};

	let saisieUtilisateur = document.getElementById("nom_note").value;
	document.getElementById("nom_note").value = '';
	let dataFormulaire = "contenu_note=" + encodeURIComponent(saisieUtilisateur);
	httprequest.open("POST", "webapi/notes", true);
	httprequest.setRequestHeader("Accept", "application/json");
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send(dataFormulaire);
}

function modifier(id,nouveauText) {
	let httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200 ) {
			} else {
				alert("Une erreur s'est produite : "+httprequest.status);
			}
		}
	};
	let dataFormulaire = "contenu_note_modifie=" + encodeURIComponent(nouveauText);
	httprequest.open("PUT", "webapi/notes/"+id, true);
	httprequest.setRequestHeader("Accept", "application/json");
	httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	httprequest.send(dataFormulaire);
}



function supprimer(id) {
	let httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
			} else {
				alert("Une erreur s'est produite : "+httprequest.status);
			}
		}
	};

	httprequest.open("DELETE", "webapi/notes/"+id, true);
	httprequest.send();
}


/*function executer(expr) {
	let httprequest;
	if (window.XMLHttpRequest) {
		// Tous les navigateurs sauf l'ami Internet Explorer
		httprequest = new XMLHttpRequest();
	} else {
		// Que pour internet explorer
		httprequest = new ActiveXObject("Msxm12.XMLHTTP");
	}

	httprequest.onreadystatechange = function() {
		if (httprequest.readyState == 4) {
			if (httprequest.status == 200) {
				let contenuJSON = JSON.parse(httprequest.responseText);
				let maDiv = document.getElementById("note_holder");
				maDiv.innerHTML = "";
				let br = document.createElement("br");
				let elem = document.createElement("div");
				for (i = 0; i < contenuJSON.length; i++) {
					let date = document.createElement("p");
					date.innerHTML = contenuJSON[i].dateDeCreation;
					let taNote = document.createElement("textarea");
					taNote.innerHTML = contenuJSON[i].note;
					elem.appendChild(date);
					elem.appendChild(taNote);
					elem.appendChild(br);
				}
				maDiv.appendChild(elem);

			} else {
				alert("Une erreur s'est produite : " + httprequest.status);
			}
		}
	};

	switch (expr) {
		case 'envoyer':
			let saisieUtilisateur = document.getElementById("nom_note").value;
			document.getElementById("nom_note").value = '';
			let dataFormulaire = "contenu_note=" + encodeURIComponent(saisieUtilisateur);
			httprequest.open("POST", "webapi/notes", true);
			httprequest.setRequestHeader("Accept", "application/json");
			httprequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
			httprequest.send(dataFormulaire);
			charger();
			break;
		case 'charger':
			httprequest.open("GET", "webapi/notes", true);
			httprequest.send();
			break;

		default:
			alert("Erreur au niveau du switch");
	}

}*/
