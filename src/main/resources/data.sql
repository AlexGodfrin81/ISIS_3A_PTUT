-- Les données qui seront initialisées automatiquement quand on lance l'application
-- cf. application.properties
INSERT INTO Activite(nom, k2) VALUES
    ('Peu actif', 0.8),
    ('Actif', 1);

INSERT INTO Animal(nom, espece, est_Male, date_naiss, taille_cm, nec) VALUES
    ('Hilda', 'CHIEN', false, '2012-03-01', 100, 3),
    ('Papouille', 'CHAT', true, '2005-06-05', 45, 7);

INSERT INTO Croquette(nom, marque, espece, humidite, proteines_brutes, matieres_grasses, cellulose, matieres_minerales, calcium, phosphore) VALUES
    ('ProPlan', 'Purina', 'CHIEN', 8, 15, 12, 5, 5, 1.2, 1.1);

INSERT INTO Proprietaire(nom, prenom, tel) VALUES 
    ('Garriga', 'Léandre', '0600000000'),
    ('Sutarik', 'Agathe', '0660606060');

INSERT INTO Race(nom, k1, espece) VALUES
    ('Berger Blanc Suisse', 1, 'CHIEN'),
    ('Caniche nain', 1, 'CHIEN');

INSERT INTO StadePhysiologique(nom, k3) VALUES
    ('Entier', 1),
    ('Stérilisé', 0.8);

INSERT INTO SuiviPoids(date, poids_kg) VALUES
    ('2021-03-01', 42),
    ('2021-03-08', 41.5);