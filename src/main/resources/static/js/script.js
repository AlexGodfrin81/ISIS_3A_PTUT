// Pour selectionner Race en fonction de l'Espèce
function adapt_race(){
                    let esp = document.getElementById('espece').value;
                    let race = document.getElementById('maRace');
                    for (let options of race){
                        if (options.getAttribute('data-esp') !== esp){
                            options.style.display = "none";
                        }else{
                            options.style.display = "inline";
                        }
                    }
                    let opt = race.options;
                    let i = 0;
                    while (opt[i].getAttribute('data-esp') !== esp){
                        i++;
                    }
                    race.selectedIndex = i;
                }
                
                function adapt_espece(){
                    let esp = document.getElementById('select_espece');
                    let race = document.getElementById('select_race');
                    let selected = race.options[race.selectedIndex];
                    console.log(selected);
                    if (selected.getAttribute('data-esp') === "CHIEN"){
                        esp.selectedIndex = 0;
                    }else{
                        esp.selectedIndex = 1;
                    }
                    adapt_race();
                }
 
 
 // Pour Gerer le choix de NEC
                 majnec();
                            document.getElementById("nec").addEventListener("input", majnec);
                                function majnec() {
                                    let valeurNEC = document.getElementById("nec").value;
                                    let commentaireNEC = "";
                                    switch (valeurNEC) {
                                        case "1":
                                            commentaireNEC = "Extrêmement maigre";
                                            break;
                                        case "2":
                                            commentaireNEC = "Maigre";
                                            break;
                                        case "3":
                                            commentaireNEC = "Mince";
                                            break;
                                        case "4":
                                            commentaireNEC = "Poids idéal";
                                            break;
                                        case "5":
                                            commentaireNEC = "Poids idéal";
                                            break;
                                        case "6":
                                            commentaireNEC = "Un peu épais";
                                            break;
                                        case "7":
                                            commentaireNEC = "Gras";
                                            break;
                                        case "8":
                                            commentaireNEC = "Gros";
                                            break;
                                        case "9":
                                            commentaireNEC = "Obèse";
                                            break;
                                        }   
                                    document.getElementById("valeur_nec").textContent = valeurNEC + "/9 - " + commentaireNEC;
                                    }