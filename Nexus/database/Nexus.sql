CREATE SCHEMA IF NOT EXISTS `Nexus` DEFAULT CHARACTER SET utf8 ;
USE `Nexus` ;

-- -----------------------------------------------------
-- Table `Nexus`.`Gênero`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Gênero` (
  `idGênero` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idGênero`));



-- -----------------------------------------------------
-- Table `Nexus`.`Jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Jogo` (
  `idJogos` INT NOT NULL,
  `Gênero_idGênero` INT NOT NULL,
  `Nome` VARCHAR(45) NOT NULL,
  `Preco` DOUBLE NOT NULL,
  `ano_de_lancamento` INT NOT NULL,
  `qtd_jogadores` INT NOT NULL,
  PRIMARY KEY (`idJogos`, `Gênero_idGênero`),
  CONSTRAINT `fk_Jogo_Gênero1`
    FOREIGN KEY (`Gênero_idGênero`)
    REFERENCES `Nexus`.`Gênero` (`idGênero`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Nexus`.`Plataforma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Plataforma` (
  `idPlataforma` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPlataforma`));


-- -----------------------------------------------------
-- Table `Nexus`.`Comprador`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Comprador` (
  `cpf` INT NOT NULL,
  `nome` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `saldo` DOUBLE NOT NULL,
  PRIMARY KEY (`cpf`));


-- -----------------------------------------------------
-- Table `Nexus`.`Carrinho`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Carrinho` (
  `idCarrinho` INT NOT NULL,
  `Comprador_cpf` INT NOT NULL,
  `Valor` DOUBLE NOT NULL,
  PRIMARY KEY (`idCarrinho`),
  CONSTRAINT `fk_Carrinho_Comprador1`
    FOREIGN KEY (`Comprador_cpf`)
    REFERENCES `Nexus`.`Comprador` (`cpf`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Nexus`.`Jogo_has_Plataforma`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Jogo_has_Plataforma` (
  `Jogo_idJogos` INT NOT NULL,
  `Plataforma_idPlataforma` INT NOT NULL,
  PRIMARY KEY (`Jogo_idJogos`, `Plataforma_idPlataforma`),
  CONSTRAINT `fk_Jogo_has_Plataforma_Jogo`
    FOREIGN KEY (`Jogo_idJogos`)
    REFERENCES `Nexus`.`Jogo` (`idJogos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Jogo_has_Plataforma_Plataforma1`
    FOREIGN KEY (`Plataforma_idPlataforma`)
    REFERENCES `Nexus`.`Plataforma` (`idPlataforma`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);


-- -----------------------------------------------------
-- Table `Nexus`.`Carrinho_has_Jogo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Nexus`.`Carrinho_has_Jogo` (
  `Carrinho_idCarrinho` INT NOT NULL,
  `Jogo_idJogos` INT NOT NULL,
  PRIMARY KEY (`Carrinho_idCarrinho`, `Jogo_idJogos`),
  CONSTRAINT `fk_Carrinho_has_Jogo_Carrinho1`
    FOREIGN KEY (`Carrinho_idCarrinho`)
    REFERENCES `Nexus`.`Carrinho` (`idCarrinho`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Carrinho_has_Jogo_Jogo1`
    FOREIGN KEY (`Jogo_idJogos`)
    REFERENCES `Nexus`.`Jogo` (`idJogos`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION);

