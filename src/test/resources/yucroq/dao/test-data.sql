-- Les données qui seront préchargées dans la base, avant les tests
-- On peut rajouter des données spécifiques pour un test par l'annotation @Sql( ))
-- cf. application-test.properties
INSERT INTO Animal(id_animal, nom, espece, est_Male, date_naiss, taille_cm, nec, id_proprio, id_race, id_activite, id_stade) VALUES
    (100, 'Hilda', 'CHIEN', false, '2012-03-01', 100, 4, 3, 1, 1, 2);

INSERT INTO Suivi_Poids(id_suivi, date_suivi, poids_kg, id_animal) VALUES
    (100, '2021-03-01', 42, 100),
    (200, '2021-03-08', 41.5, 100),
    (300, '2021-04-03', 41, 100);

INSERT INTO Ration(id_ration, quantite, date_debut, date_fin, id_animal, id_croq) VALUES
    (100, 200, '2012-03-01', '2012-03-03', 100, 1),
    (300, 400, '2012-03-03', null, 100, 1);
