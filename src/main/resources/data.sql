-- Les données qui seront initialisées automatiquement quand on lance l'application
-- cf. application.properties
INSERT INTO Proprietaire(id_proprio, nom, prenom, tel) VALUES 
    (1, 'Garriga', 'Léandre', '0600000000'),
    (2, 'Sutarik', 'Agathe', '0660606060');

INSERT INTO Activite(id_activite, nom, k2) VALUES
    (1, 'Peu actif', 0.8),
    (2, 'Actif', 1);

INSERT INTO Animal(id_animal, nom, espece, est_Male, date_naiss, taille_cm) VALUES
    (1, 'Hilda', 'Chien', 'Berger Blanc Suisse', false, '01/01/2012', 100);