CREATE SCHEMA IF NOT EXISTS `Nexus` DEFAULT CHARACTER SET utf8;
USE `Nexus`;

-- -----------------------------------------------------
-- Table `Nexus`.`Genero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Genero`
(
    `nome` VARCHAR(45) NOT NULL,
    PRIMARY KEY (`nome`)
);


-- -----------------------------------------------------
-- Table `Nexus`.`Jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Jogo`
(
    `idjogo`            INT         NOT NULL,
    `Genero_nome`       VARCHAR(45) NOT NULL,
    `Nome`              VARCHAR(45) NOT NULL,
    `Preco`             DOUBLE      NOT NULL,
    `ano_de_lancamento` INT         NOT NULL,
    `qtd_jogadores`     INT         NOT NULL,
    PRIMARY KEY (`idjogo`, `Genero_nome`),
    CONSTRAINT `fk_Jogo_Genero1`
        FOREIGN KEY (`Genero_nome`)
            REFERENCES `Nexus`.`Genero` (`nome`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table `Nexus`.`Plataforma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Plataforma`
(
    `idPlataforma` INT         NOT NULL,
    `nome`         VARCHAR(45) NOT NULL,
    PRIMARY KEY (`idPlataforma`)
);


-- -----------------------------------------------------
-- Table `Nexus`.`Comprador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Comprador`
(
    `cpf`   VARCHAR(45) NOT NULL,
    `nome`  VARCHAR(45) NOT NULL,
    `email` VARCHAR(45) NOT NULL,
    `saldo` DOUBLE      NOT NULL,
    PRIMARY KEY (`cpf`)
);


-- -----------------------------------------------------
-- Table `Nexus`.`Carrinho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Carrinho`
(
    `idCarrinho`    INT         NOT NULL,
    `Comprador_cpf` VARCHAR(45) NOT NULL,
    `Valor`         DOUBLE      NOT NULL,
    PRIMARY KEY (`idCarrinho`),
    CONSTRAINT `fk_Carrinho_Comprador1`
        FOREIGN KEY (`Comprador_cpf`)
            REFERENCES `Nexus`.`Comprador` (`cpf`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS `Nexus` . `Compra`
(
    `idCompra` INT NOT NULL,
    `Comprador_cpf` VARCHAR(45) NOT NULL,
    `Valor` DOUBLE NOT NULL,
    PRIMARY KEY (`idCompra`),
    CONSTRAINT `fk_Compra_Comprador1`
        FOREIGN KEY (`Comprador_cpf`)
            REFERENCES `Nexus`.`Comprador` (`cpf`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

-- -----------------------------------------------------
-- Table `Nexus`.`Jogo_has_Plataforma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Jogo_has_Plataforma`
(
    `Jogo_idJogo`             INT NOT NULL,
    `Plataforma_idPlataforma` INT NOT NULL,
    PRIMARY KEY (`Jogo_idjogo`, `Plataforma_idPlataforma`),
    CONSTRAINT `fk_Jogo_has_Plataforma_Jogo`
        FOREIGN KEY (`Jogo_idJogo`)
            REFERENCES `Nexus`.`Jogo` (`idJogo`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_Jogo_has_Plataforma_Plataforma1`
        FOREIGN KEY (`Plataforma_idPlataforma`)
            REFERENCES `Nexus`.`Plataforma` (`idPlataforma`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);


-- -----------------------------------------------------
-- Table `Nexus`.`Carrinho_has_Jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Carrinho_has_Jogo`
(
    `Carrinho_idCarrinho` INT NOT NULL,
    `Jogo_idjogo`         INT NOT NULL,
    PRIMARY KEY (`Carrinho_idCarrinho`, `Jogo_idjogo`),
    CONSTRAINT `fk_Carrinho_has_Jogo_Carrinho1`
        FOREIGN KEY (`Carrinho_idCarrinho`)
            REFERENCES `Nexus`.`Carrinho` (`idCarrinho`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION,
    CONSTRAINT `fk_Carrinho_has_Jogo_Jogo1`
        FOREIGN KEY (`Jogo_idjogo`)
            REFERENCES `Nexus`.`Jogo` (`idjogo`)
            ON DELETE NO ACTION
            ON UPDATE NO ACTION
);

