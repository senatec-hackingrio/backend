
INSERT INTO perfil (id, nome) 
	SELECT * FROM (SELECT 1,'Medico') AS tmp 
	WHERE NOT EXISTS (SELECT id FROM perfil WHERE id = 1);

INSERT INTO perfil (id, nome) 
	SELECT * FROM (SELECT  2,'Paciente') AS tmp 
	WHERE NOT EXISTS (SELECT id FROM perfil WHERE id = 2);