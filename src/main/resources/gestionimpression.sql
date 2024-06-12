-- Insert into Administrateurs
INSERT INTO administrateurs(nom, email, motDePasse, role) VALUES
                                                              ('Admin1', 'admin1@email.com', 'password1', 'ADMINISTRATEUR'),
                                                              ('Admin2', 'admin2@email.com', 'password2', 'ADMINISTRATEUR'),
                                                              ('Admin3', 'admin3@email.com', 'password3', 'ADMINISTRATEUR');

-- Insert into Enseignants
INSERT INTO enseignants(nom, email, motDePasse, role, active, administrateur_id) VALUES
                                                                                     ('Enseignant1', 'enseignant1@email.com', 'password1', 'ENSEIGNANT', true, 1),
                                                                                     ('Enseignant2', 'enseignant2@email.com', 'password2', 'ENSEIGNANT', true, 2),
                                                                                     ('Enseignant3', 'enseignant3@email.com', 'password3', 'ENSEIGNANT', true, 3);

-- Insert into Agents_Tirage
INSERT INTO agents_tirage(nom, email, motDePasse, role, active, administrateur_id) VALUES
                                                                                       ('Agent1', 'agent1@email.com', 'password1', 'AGENT_TIRAGE', true, 1),
                                                                                       ('Agent2', 'agent2@email.com', 'password2', 'AGENT_TIRAGE', true, 2),
                                                                                       ('Agent3', 'agent3@email.com', 'password3', 'AGENT_TIRAGE', true, 3);

-- Insert into Groupes
INSERT INTO groupes(name, numberOfStudents, enseignant_id) VALUES
                                                               ('Group1', 30, 1),
                                                               ('Group2', 25, 2),
                                                               ('Group3', 35, 3);

-- Insert into Matieres
INSERT INTO matieres(nom, nombreEtudiants, enseignant_id, group_id) VALUES
                                                                        ('Matiere1', 30, 1, 1),
                                                                        ('Matiere2', 25, 2, 2),
                                                                        ('Matiere3', 35, 3, 3);

-- Insert into Demandes_Tirage
INSERT INTO demandes_tirage(enseignant_id, matiere_id, agentTirage_id, document, nombreCopies, dateHeureRetrait) VALUES
                                                                                                                     (1, 1, 1, 'Document1', 100, '2024-06-07 10:00:00'),
                                                                                                                     (2, 2, 2, 'Document2', 200, '2024-06-07 11:00:00'),
                                                                                                                     (3, 3, 3, 'Document3', 300, '2024-06-07 12:00:00');