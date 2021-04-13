function adapt_race(){
                    let esp = document.getElementById('select_espece').value;
                    let race = document.getElementById('select_race');
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