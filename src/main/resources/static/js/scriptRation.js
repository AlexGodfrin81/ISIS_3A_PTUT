// permet l'affichage des croquettes correspondants à la race de l'animal concerné
window.onload = function(){
                let esp = document.getElementById("cons").getAttribute("data-esp");
                let croqs = document.getElementById("mesCroqs");
                for (c of croqs){
                    if (c.getAttribute("data-esp") !== esp){
                        c.style.display = "none";
                    }
                }
                let opt = croqs.options;
                let i = 0;
                while (opt[i].getAttribute('data-esp') !== esp){
                    i++;
                }
                croqs.selectedIndex = i;
            };


