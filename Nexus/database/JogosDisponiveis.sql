use Nexus;
INSERT INTO Plataforma (idPlataforma, nome) VALUES
                                                (1,'PC'),
                                                (2,'Xbox'),
                                                (3,'Playstation'),
                                                (4,'Nintendo Switch');

INSERT INTO Genero (nome) VALUES
                              ('RPG'),
                              ('Corrida'),
                              ('Luta'),
                              ('Ação e Aventura'),
                              ('ARCADE');

INSERT INTO Jogo (idJogo, Nome,Genero_nome, Preco, ano_de_lancamento, qtd_jogadores) VALUES
                                                                                         ( 1,'The Witcher 3: Wild Hunt','RPG', 100, 2015, 1),
                                                                                         ( 2,'Forza Horizon 4','Corrida', 200, 2018, 2),
                                                                                         ( 3, 'Mortal Kombat 11','Luta', 150, 2019, 2),
                                                                                         ( 4,'Grand Theft Auto V','Ação e Aventura', 100, 2013, 1),
                                                                                         ( 5,'Minecraft','ARCADE', 50, 2011, 4),
                                                                                         ( 6,'The Legend of Zelda: Breath of the Wild','RPG', 250, 2017, 1);


INSERT INTO Jogo_has_Plataforma (Jogo_idJogo, Plataforma_idPlataforma) VALUES
                                                                    (1,1),
                                                                    (2,2),
                                                                    (3,3),
                                                                    (4,4),
                                                                    (5,4),
                                                                    (6,4);



