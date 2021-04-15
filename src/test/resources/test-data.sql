-- Les données qui seront préchargées dans la base, avant les tests
-- On peut rajouter des données spécifiques pour un test par l'annotation @Sql( ))
-- cf. application-test.properties

INSERT INTO Croquette(id,nom,marque,espece,humidite,proteines_brutes,matieres_grasses,cellulose,matieres_minerales,calcium,phosphore) VALUES (3,'Babydog Milk','Royal Canin',CHIEN,9.5,30,22,1.3,7.8,0,0);
/*INSERT INTO Animal(id_animal,nom,espece,est_Male,date_naiss,taille_cm,nec) VALUES (1,'Buddy',CHIEN,TRUE,'1999-06-10',61,7)
INSERT INTO SuiviPoids(id_suivi,date_suivi,poids_kg) VALUES (1,'2021-04-13',40)
INSERT INTO Activite(id_activite,nom,k2) VALUES (1,'Rien',0.3)
INSERT INTO Proprietaire(id_proprio,nom,prenom,tel,mail) VALUES (1,'Garriga','Léandre','0666666666','leandre.garriga@etud.univ-jfc.fr')
INSERT INTO Ration(id_ration,quantite,date_debut,date_fin) VALUES (1,100,'2021-04-13','2021-05-13')*/
