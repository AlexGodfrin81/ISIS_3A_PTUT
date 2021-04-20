// Permet d'ajouter la date du jour sur l'élément de classe datedujour

var aujourdhui = new Date();
var annee = aujourdhui.getFullYear();
var mois = aujourdhui.getMonth() + 1;
if (mois < 10) {
    mois = "0" + mois;
}

var jour = aujourdhui.getDate();
if (jour < 10) {
    jour = "0" + jour;
}
var date = annee + '-' + mois + '-' + jour;
document.getElementsByClassName("datedujour")[0].value = date;