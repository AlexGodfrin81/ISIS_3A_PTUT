 document.getElementById("enregistrement").disabled=true;
                    
                    document.getElementById("marque").addEventListener("input", deblocagevalidation);
                    document.getElementById("nom").addEventListener("input", deblocagevalidation);
                    
                    function deblocagevalidation() {
                        if (document.getElementById("nom").value != "" && document.getElementById("marque").value != "") {
                            document.getElementById("enregistrement").disabled=false;
                        }
                        else {
                            document.getElementById("enregistrement").disabled=true;
                        }
                    }