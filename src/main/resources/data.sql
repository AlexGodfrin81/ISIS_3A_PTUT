-- Les données qui seront initialisées automatiquement quand on lance l'application
-- cf. application.properties
INSERT INTO Activite(id_activite, nom, k2) VALUES
    (1, 'Léthargique', 0.7),
    (2, 'Sédentaire', 0.8),
    (3, 'Calme', 0.9),
    (4, 'Standard', 1),
    (5, 'Actif', 1.1),
    (6, 'Agility', 1.2),
    (7, 'Field trial', 1.4),
    (8, 'Garde de troupeau', 2),
    (9, 'Chasse', 2.5);

INSERT INTO Croquette(id_croq, nom, marque, espece, humidite, proteines_brutes, matieres_grasses, cellulose, matieres_minerales, calcium, phosphore) VALUES
    (1, 'ProPlan', 'Purina', 'CHIEN', 8, 15, 12, 5, 5, 1.2, 1.1),
    (2, 'Pour chat', 'Purina', 'CHAT', 8, 15, 12, 5, 5, 1.2, 1.1);

INSERT INTO Proprietaire(id_proprio, username, password, nom, prenom, tel, email) VALUES 
    (4, 'xXDarkSasuke34Xx', 'helloworld', 'Garriga',  'Léandre', '0600000000', 'leandre.garriga@etud.univ-jfc.fr'),
    (2, 'Kachoul', 'helloworld', 'Sutarik', 'Agathe', '0660606060', 'agathe.sutarik@etud.univ-jfc.fr'),
    (3, 'Joffrey', 'helloworld', 'Viémon-Desplanque', 'Joffrey', '0667930794', 'joffrey.viemon-desplanque@etud.univ-jfc.fr');

INSERT INTO Race(id_race, nom, k1, espece) VALUES
    (1, 'Berger Blanc Suisse', 1, 'CHIEN'),
    (2, 'Caniche nain', 1, 'CHIEN'),
    (3, 'Européen', 1, 'CHAT'),
    (4, 'British Longhair', 1, 'CHAT'),
    (5, 'Retriever', 0.8, 'CHIEN'),
    (6, 'Terre Neuve', 0.8, 'CHIEN'),
    (7, 'Beagle', 0.9, 'CHIEN'),
    (8, 'Cocker', 0.9, 'CHIEN'),
    (9, 'Lévrier', 1.1, 'CHIEN'),
    (10, 'Dogue argentin', 1.1, 'CHIEN');

INSERT INTO Stade_Physiologique(id_stade, nom, k3) VALUES
    (1, 'Entier', 1),
    (2, 'Stérilisé', 0.8),
    (3, 'Agé', 0.9);

INSERT INTO Animal(id_animal, nom, espece, est_Male, date_naiss, taille_cm, nec, id_proprio, id_race, id_activite, id_stade) VALUES
    (1, 'Hilda', 'CHIEN', false, '2012-03-01', 100, 6, 1, 1, 1, 2),
    (2, 'Papouille', 'CHIEN', true, '2005-06-05', 45, 7, 4, 2, 2, 1),
    (3, 'Fidji', 'CHAT', true, '2010-02-28', 20, 3, 1, 4, 2, 2);

INSERT INTO Suivi_Poids(id_suivi, date_suivi, poids_kg, id_animal) VALUES
    (1, '2021-03-01', 42, 1),
    (2, '2021-03-08', 41.5, 1),
    (3, '2021-04-03', 41, 1);

INSERT INTO Ration(id_ration, quantite, date_debut, date_fin, id_animal, id_croq) VALUES
    (1, 200, '2012-03-01', '2012-03-03', 1, 1),
    (2, 180, '2012-03-03', '2012-03-05', 3, 2),
    (3, 400, '2012-03-03', null, 1, 1),
    (4, 50, '2012-03-03', null, 3, 2);
