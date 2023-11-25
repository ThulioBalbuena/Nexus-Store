use Nexus;
INSERT INTO Plataforma (nome) VALUES
                                  ('PC'),
                                  ('Xbox'),
                                  ('Playstation'),
                                  ('Nintendo Switch');

INSERT INTO Genero (nome) VALUES
                              ('RPG'),
                              ('Corrida'),
                              ('Luta'),
                              ('Ação e Aventura'),
                              ('ARCADE');

INSERT INTO Jogo (idjogo, Genero_nome, Nome, Preco, ano_de_lancamento, qtd_jogadores) VALUES
(1, 'RPG', 'The Witcher 3: Wild Hunt', 100, 2015, 1),
(2, 'Corrida', 'Forza Horizon 4', 200, 2018, 2),
(3, 'Luta', 'Mortal Kombat 11', 150, 2019, 2),
(4, 'Ação e Aventura', 'Grand Theft Auto V', 100, 2013, 1),
(5, 'ARCADE', 'Minecraft', 50, 2011, 4),
(6, 'RPG', 'The Legend of Zelda: Breath of the Wild', 250, 2017, 1);

INSERT INTO Jogo_has_Plataforma (Jogo_idjogo, Plataforma_nome) VALUES
(1, 'PC'),
(1, 'Xbox'),
(1, 'Playstation'),
(2, 'Xbox'),
(2, 'PC'),
(3, 'Xbox'),
(3, 'Playstation'),
(4, 'PC'),
(4, 'Xbox'),
(4, 'Playstation'),
(5, 'PC'),
(5, 'Xbox'),
(5, 'Playstation'),
(5, 'Nintendo Switch'),
(6, 'Nintendo Switch'),
(6, 'PC');




