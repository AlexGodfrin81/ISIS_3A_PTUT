-- Les données qui seront initialisées automatiquement quand on lance l'application
-- cf. application.properties
INSERT INTO Activite(id_activite, nom, k2) VALUES
    (1, 'Peu actif', 0.8),
    (2, 'Actif', 1);

INSERT INTO Animal(id_animal, nom, espece, est_Male, date_naiss, taille_cm, nec) VALUES
    (1, 'Hilda', 'CHIEN', false, '2012-03-01', 100, 3),
    (2, 'Papouille', 'CHIEN', true, '2005-06-05', 45, 7);

INSERT INTO Croquette(id_croq, nom, marque, espece, humidite, proteines_brutes, matieres_grasses, cellulose, matieres_minerales, calcium, phosphore) VALUES
    (1, 'ProPlan', 'Purina', 'CHIEN', 8, 15, 12, 5, 5, 1.2, 1.1);

INSERT INTO Proprietaire(id_proprio, nom, prenom, tel, mail) VALUES 
    (1, 'Garriga', 'Léandre', '0600000000', 'leandre.garriga@etud.univ-jfc.fr'),
    (2, 'Sutarik', 'Agathe', '0660606060', 'agathe.sutarik@etud.univ-jfc.fr');

INSERT INTO Race(id_race, nom, k1, espece) VALUES
    (1, 'Berger Blanc Suisse', 1, 'CHIEN'),
    (2, 'Caniche nain', 1, 'CHIEN');

INSERT INTO Stade_Physiologique(id_stade, nom, k3) VALUES
    (1, 'Entier', 1),
    (2, 'Stérilisé', 0.8);

INSERT INTO Suivi_Poids(id_suivi, date_suivis, poids_kg) VALUES
    (1, '2021-03-01', 42),
    (2, '2021-03-08', 41.5);