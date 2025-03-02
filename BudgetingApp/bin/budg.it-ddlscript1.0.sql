-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MOexpensesDE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema budgit
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `budgit` DEFAULT CHARACTER SET utf8 COLLATE utf8_bin;
USE `budgit`;

-- -----------------------------------------------------
-- Table `budgit`.`income`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budgit`.`income` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(45) NOT NULL,
  `AMOUNT` DECIMAL(10,2) NOT NULL,
  `DATE` DATE NOT NULL,
  `NOTES` VARCHAR(255),
  PRIMARY KEY (`ID`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

-- -----------------------------------------------------
-- Table `budgit`.`expenses`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `budgit`.`expenses` (
  `ID` INT NOT NULL AUTO_INCREMENT,
  `DESCRIPTION` VARCHAR(45) NOT NULL,
  `AMOUNT` DECIMAL(10,2) NOT NULL,
  `CATEGORY` VARCHAR(45) NOT NULL,
  `DATE` DATE NOT NULL,
  `NOTES` VARCHAR(255),
  PRIMARY KEY (`ID`)
) ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8
COLLATE = utf8_bin;

SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
