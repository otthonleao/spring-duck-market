INSERT INTO tb_duck (id, name, status, mother_id) VALUES (1, 'Duck1', 'AVAILABLE', NULL);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (2, 'Duck2', 'SOLD', 1);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (3, 'Duck3', 'AVAILABLE', 1);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (4, 'Duck4', 'AVAILABLE', 3);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (5, 'Duck5', 'AVAILABLE', 3);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (6, 'Duck6', 'SOLD', 3);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (7, 'Duck7', 'AVAILABLE', 2);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (8, 'Duck8', 'AVAILABLE', 6);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (9, 'Duck9', 'AVAILABLE', 5);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (10, 'Duck10', 'AVAILABLE', null);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (11, 'Duck11', 'AVAILABLE', 5);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (12, 'Duck12', 'AVAILABLE', 6);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (13, 'Duck13', 'AVAILABLE', 6);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (14, 'Duck14', 'AVAILABLE', 7);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (15, 'Duck15', 'AVAILABLE', 8);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (16, 'Duck16', 'AVAILABLE', 8);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (17, 'Duck17', 'AVAILABLE', 8);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (18, 'Duck18', 'AVAILABLE', 9);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (19, 'Duck19', 'AVAILABLE', 10);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (20, 'Duck20', 'AVAILABLE', 11);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (21, 'Duck21', 'AVAILABLE', 12);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (22, 'Duck22', 'AVAILABLE', 13);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (23, 'Duck23', 'AVAILABLE', 14);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (24, 'Duck24', 'AVAILABLE', 15);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (25, 'Duck25', 'AVAILABLE', 16);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (26, 'Duck26', 'AVAILABLE', 17);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (27, 'Duck27', 'AVAILABLE', 17);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (28, 'Duck28', 'AVAILABLE', 18);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (29, 'Duck29', 'AVAILABLE', 19);
INSERT INTO tb_duck (id, name, status, mother_id) VALUES (30, 'Duck30', 'AVAILABLE', 20);

ALTER TABLE tb_duck ALTER COLUMN id RESTART WITH 31;

INSERT INTO tb_customer (name, has_discount) VALUES ('Cristiano Ronaldo', false);
INSERT INTO tb_customer (name, has_discount) VALUES ('Neymar Jr.', false);
INSERT INTO tb_customer (name, has_discount) VALUES ('Rodrigo Garro', true);
INSERT INTO tb_customer (name, has_discount) VALUES ('Memphis Depay', true);

ALTER TABLE tb_customer ALTER COLUMN id RESTART WITH 5;

INSERT INTO tb_seller (name, cpf, registration) VALUES ('Otthon Leão', '12345678901', 'A1234567');
INSERT INTO tb_seller (name, cpf, registration) VALUES ('Yuri Alberto', '12345678902', 'A1234568');
INSERT INTO tb_seller (name, cpf, registration) VALUES ('Ronaldo Fenômeno', '12345678903', 'A1234569');

ALTER TABLE tb_seller ALTER COLUMN id RESTART WITH 4;