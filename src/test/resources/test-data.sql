-- Les données qui seront préchargées dans la base, avant les tests
-- On peut rajouter des données spécifiques pour un test par l'annotation @Sql( ))
-- cf. application-test.properties

INSERT INTO Croquette(id,nom,marque,espece,humidite,proteines_brutes,matieres_grasses,cellulose,matieres_minerales,calcium,phosphore) VALUES (1,'Babydog Milk','Royal Canin',CHIEN,9.5,30,22,1.3,7.8,0,0);