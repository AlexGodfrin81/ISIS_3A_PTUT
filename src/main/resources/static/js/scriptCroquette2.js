//Pour rechercher les croquette
document.getElementById("inputrecherche").addEventListener('input', afficheRecherche);
            function afficheRecherche() {
                if (document.getElementById("inputrecherche").value == "") {
                    document.getElementById("listecroq").removeAttribute("style");
                    document.getElementById("resultatrecherche").setAttribute("style","display:none");
                }
                else {
                    document.getElementById("listecroq").setAttribute("style","display:none");
                    document.getElementById("resultatrecherche").removeAttribute("style");
                    document.getElementById("contenurech").textContent = document.getElementById("inputrecherche").value;
                }
                doAjax();
            }
            afficheRecherche();
            
             // Appel AJAX : recherche
            function doAjax() {
                let texterech = document.getElementById("inputrecherche").value;
                console.log("textrech");
                $.ajax({
                    // On appelle le service qui renvoie le résultat comme un tableau de valeurs
                    url: "/api/search/rechercheCroquettes",
                    // On passe comme paramètre les données saisies dans le formulaire
                    data: { "recherche" : texterech },
                    // On demande du JSON comme résultat
                    dataType: "json",
                    success: rech, // La fonction qui traite les résultats
                    error: showError
                });
            } 

            //  Fonction recherche
            function rech(result) {
                let textetransmis = "<ul>";
                for (var i in result) {
                    textetransmis += "<li><a href='getCroquette?idcroq=" + result[i].idcroq + "&idanimal=0'>" + result[i].marque + " " + result[i].nom + "</a></li>";
                }
                textetransmis += "</ul>";
                
                document.getElementById("listeresultatrecherche").innerHTML = textetransmis;
            }
            
            // Fonction qui traite les erreurs de la requête
            function showError(xhr, status, message) {
                alert("Erreur : " + status + " : " + message);
            }