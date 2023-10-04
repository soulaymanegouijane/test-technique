INSERT INTO particular_client (reference, civility, first_name, last_name) VALUES ('EKW00000000', 0, 'Soulaymane', 'Gouijane');
INSERT INTO particular_client (reference, civility, first_name, last_name) VALUES ('EKW00000001', 1, 'toto', 'Tati');

INSERT INTO professional_client (company_turnover, company_name, reference, siret_number) VALUES (2010020102, 'EKWATEUR', 'EKW00000002', '012052215422151');
INSERT INTO professional_client (company_turnover, company_name, reference, siret_number) VALUES (1022010, 'SG', 'EKW00000003', '1225211254558');

INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (1002010, 0, 1, 'EKW00000000');
INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (200, 1, 2, 'EKW00000000');
INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (12040, 0, 3, 'EKW00000001');
INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (12400, 1, 4, 'EKW00000001');
INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (51100, 0, 5, 'EKW00000002');
INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (20540, 1, 6, 'EKW00000002');
INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (18070, 0, 7, 'EKW00000003');
INSERT INTO energy_consumption (consumption, energy_type, id, client_reference) VALUES (1070, 1, 8, 'EKW00000003');