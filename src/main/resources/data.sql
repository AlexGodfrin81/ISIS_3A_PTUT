-- Les données qui seront initialisées automatiquement quand on lance l'application
-- cf. application.properties
INSERT INTO Activite(id_activite, nom, k2) VALUES
    (1, 'Peu actif', 0.8),
    (2, 'Actif', 1);

INSERT INTO Croquette(id_croq, nom, marque, espece, humidite, proteines_brutes, matieres_grasses, cellulose, matieres_minerales, calcium, phosphore) VALUES
    (1, 'ProPlan', 'Purina', 'CHIEN', 8, 15, 12, 5, 5, 1.2, 1.1),
    (2, 'Pour chat', 'Purina', 'CHAT', 8, 15, 12, 5, 5, 1.2, 1.1);


INSERT INTO Proprietaire(id_proprio, username, password, nom, prenom, tel, email) VALUES 
    (4, 'Atsuhiko', 'helloworld', 'Garriga',  'Léandre', '0600000000', 'leandre.garriga@etud.univ-jfc.fr'),
    (2, 'Kachoul', 'helloworld', 'Sutarik', 'Agathe', '0660606060', 'agathe.sutarik@etud.univ-jfc.fr'),
    (3, 'Joffrey', 'helloworld', 'Viémon-Desplanque', 'Joffrey', '0667930794', 'joffrey.viemon-desplanque@etud.univ-jfc.fr');

INSERT INTO Race(id_race, nom, k1, espece) VALUES
    (1, 'Berger Blanc Suisse', 1, 'CHIEN'),
    (2, 'Caniche nain', 1, 'CHIEN'),
    (3, 'Écaille de tortue', 1, 'CHAT'),
    (4, 'British Longhair', 1, 'CHAT');

INSERT INTO Stade_Physiologique(id_stade, nom, k3) VALUES
    (1, 'Entier', 1),
    (2, 'Stérilisé', 0.8);

INSERT INTO Animal(id_animal, nom, espece, est_Male, date_naiss, taille_cm, nec, id_proprio, id_race, id_activite, id_stade) VALUES
    (1, 'Hilda', 'CHIEN', false, '2012-03-01', 100, 6, 3, 1, 1, 2),
    (2, 'Papouille', 'CHIEN', true, '2005-06-05', 45, 7, 1, 2, 2, 1),
    (3, 'Fidji', 'CHAT', true, '2010-02-28', 20, 3, 3, 4, 2, 2);

INSERT INTO Suivi_Poids(id_suivi, date_suivi, poids_kg, id_animal) VALUES
    (1, '2021-03-01', 42, 1),
    (2, '2021-03-08', 41.5, 1),
    (3, '2021-04-03', 41, 1);

INSERT INTO Ration(id_ration, quantite, date_debut, date_fin, id_animal, id_croq) VALUES
    (1, 200, '2012-03-01', '2012-03-03', 1, 1),
    (3, 400, '2012-03-03', null, 1, 1),
    (2, 180, '2012-03-03', '2012-03-05', 3, 2),
    (4, 50, '2012-03-03', null, 3, 2);