-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

-- -----------------------------------------------------
-- Schema SSW_Lab5
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema SSW_Lab5
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `SSW_Lab5` DEFAULT CHARACTER SET utf8 ;
USE `SSW_Lab5` ;

-- -----------------------------------------------------
-- Table `SSW_Lab5`.`Candy`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSW_Lab5`.`Candy` ;

CREATE TABLE IF NOT EXISTS `SSW_Lab5`.`Candy` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Weight` INT NOT NULL,
  `Sugar` INT NOT NULL,
  `Manufacturer` VARCHAR(45) NOT NULL,
  `Color` VARCHAR(45) NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `SSW_Lab5`.`Cookie`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `SSW_Lab5`.`Cookie` ;

CREATE TABLE IF NOT EXISTS `SSW_Lab5`.`Cookie` (
  `Id` INT NOT NULL AUTO_INCREMENT,
  `Weight` INT NOT NULL,
  `Sugar` INT NOT NULL,
  `Manufacturer` VARCHAR(45) NOT NULL,
  `FlourAmount` INT NOT NULL,
  PRIMARY KEY (`Id`),
  UNIQUE INDEX `Id_UNIQUE` (`Id` ASC))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;

-- Insert new data to Candy
INSERT INTO ssw_lab5.candy (Id, Weight, Sugar, Manufacturer, Color) VALUES (1, 2, 3, 'Roshen', 'Red');
INSERT INTO ssw_lab5.candy (Id, Weight, Sugar, Manufacturer, Color) VALUES (2, 2, 3, 'Roshen', 'Blue');
INSERT INTO ssw_lab5.candy (Id, Weight, Sugar, Manufacturer, Color) VALUES (3, 5, 7, 'Roshen', 'Black');
INSERT INTO ssw_lab5.candy (Id, Weight, Sugar, Manufacturer, Color) VALUES (4, 6, 14, 'Roshen', 'White');
INSERT INTO ssw_lab5.candy (Id, Weight, Sugar, Manufacturer, Color) VALUES (5, 1, 3, 'Roshen', 'Yellow');

-- Insert new data to Cookie
INSERT INTO ssw_lab5.cookie (Id, Weight, Sugar, Manufacturer, FlourAmount) VALUES (1, 1, 14, 'Roshen', 5);
INSERT INTO ssw_lab5.cookie (Id, Weight, Sugar, Manufacturer, FlourAmount) VALUES (2, 4, 232, 'Roshen', 242);
INSERT INTO ssw_lab5.cookie (Id, Weight, Sugar, Manufacturer, FlourAmount) VALUES (3, 2332, 232, 'Roshen', 434);


-- Test values
SELECT *
FROM candy;

SELECT *
FROM cookie;