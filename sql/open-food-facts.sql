-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le : lun. 30 oct. 2023 à 15:11
-- Version du serveur : 10.4.28-MariaDB
-- Version de PHP : 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `open-food-facts`
--

-- --------------------------------------------------------

--
-- Structure de la table `additif`
--

CREATE TABLE `additif` (
  `id` int(11) NOT NULL,
  `CODE` varchar(50) DEFAULT NULL,
  `NOM` varchar(250) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `allergene`
--

CREATE TABLE `allergene` (
  `id` int(11) NOT NULL,
  `NOM` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE `categorie` (
  `id` int(11) NOT NULL,
  `NOM` varchar(250) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `ingredient`
--

CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL,
  `NOM` varchar(250) NOT NULL,
  `POURCENTAGE` float DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `marque`
--

CREATE TABLE `marque` (
  `id` int(11) NOT NULL,
  `NOM` varchar(150) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `poduit_additif`
--

CREATE TABLE `poduit_additif` (
  `ID_ADDITIF` int(11) NOT NULL,
  `ID_PRODUIT` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `poduit_allergene`
--

CREATE TABLE `poduit_allergene` (
  `ID_ALLERGENE` int(11) NOT NULL,
  `ID_PRODUIT` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `poduit_ingredient`
--

CREATE TABLE `poduit_ingredient` (
  `ID_INGREDIENT` int(11) NOT NULL,
  `ID_PRODUIT` int(11) NOT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE `produit` (
  `id` int(11) NOT NULL,
  `NAME` varchar(250) NOT NULL,
  `NUTRITION_GRADE` varchar(10) NOT NULL,
  `PRESENCE_HUILE_DE_PALME` bit(1) NOT NULL,
  `ID_CATEGORIE` int(11) DEFAULT NULL,
  `ID_MARQUE` int(11) DEFAULT NULL,
  `ID_VALEUR_NUTRITIONNELLE` int(11) DEFAULT NULL,
  `ID_VITAMINE` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `valeur_nutritionnelle`
--

CREATE TABLE `valeur_nutritionnelle` (
  `id` int(11) NOT NULL,
  `ENERGIE_100G` float DEFAULT NULL,
  `FIBRE_100G` float DEFAULT NULL,
  `GRAISSE_100G` float DEFAULT NULL,
  `PROTEINE_100G` float DEFAULT NULL,
  `SEL_100G` float DEFAULT NULL,
  `SUCRE_100G` float DEFAULT NULL,
  `ID_PRODUIT` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Structure de la table `vitamine`
--

CREATE TABLE `vitamine` (
  `id` int(11) NOT NULL,
  `BETA_CAROTENE_100G` float DEFAULT NULL,
  `CALCIUM_100G` float DEFAULT NULL,
  `FER_100G` float DEFAULT NULL,
  `IRON_100G` float DEFAULT NULL,
  `MAGNESIUM_100G` float DEFAULT NULL,
  `VIT_A_100G` float DEFAULT NULL,
  `VIT_B1_100G` float DEFAULT NULL,
  `VIT_B12_100G` float DEFAULT NULL,
  `VIT_B2_100G` float DEFAULT NULL,
  `VIT_B6_100G` float DEFAULT NULL,
  `VIT_B9_100G` float DEFAULT NULL,
  `VIT_C_100G` float DEFAULT NULL,
  `VIT_D_100G` float DEFAULT NULL,
  `VIT_E_100G` float DEFAULT NULL,
  `VIT_K_100G` float DEFAULT NULL,
  `VIT_PP_100G` float DEFAULT NULL,
  `ID_PRODUIT` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `additif`
--
ALTER TABLE `additif`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_5wty4edekct3c7f9kbce9fmlv` (`CODE`),
  ADD UNIQUE KEY `UK_jr24gkfneajika81roqvx1img` (`NOM`);

--
-- Index pour la table `allergene`
--
ALTER TABLE `allergene`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_m2137vrpwobpdaekwl383qnpd` (`NOM`);

--
-- Index pour la table `categorie`
--
ALTER TABLE `categorie`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_fkeg15mfoo53hskak4k2oj0wx` (`NOM`);

--
-- Index pour la table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `marque`
--
ALTER TABLE `marque`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_4heduwamwbj4i2yqwnweqkvmx` (`NOM`);

--
-- Index pour la table `poduit_additif`
--
ALTER TABLE `poduit_additif`
  ADD KEY `FKl4u4efcky39jlmjk8v11u7msd` (`ID_PRODUIT`),
  ADD KEY `FK7joth45j1t2bbgue1vhfxaswx` (`ID_ADDITIF`);

--
-- Index pour la table `poduit_allergene`
--
ALTER TABLE `poduit_allergene`
  ADD KEY `FKpvoo66ow460s7c7hdl17e5khe` (`ID_PRODUIT`),
  ADD KEY `FKmxcukaj8q3xvmgcrqtdndnli1` (`ID_ALLERGENE`);

--
-- Index pour la table `poduit_ingredient`
--
ALTER TABLE `poduit_ingredient`
  ADD KEY `FKcm5dkc1mb7e6loxndgrvt8igs` (`ID_PRODUIT`),
  ADD KEY `FKt21te19fxdtg5enhv3tlwbcdt` (`ID_INGREDIENT`);

--
-- Index pour la table `produit`
--
ALTER TABLE `produit`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_ftawslar7i3gjqsus1skv8700` (`NAME`),
  ADD KEY `FKhnvg7t8elseaajrpvp047wd76` (`ID_CATEGORIE`),
  ADD KEY `FKm830ens9udobrjneh056dngdu` (`ID_MARQUE`),
  ADD KEY `FKdxnr64qhpwnnydel3b8o3ldsh` (`ID_VALEUR_NUTRITIONNELLE`),
  ADD KEY `FKlb70dj19fr0h2yj3c1iwy27xw` (`ID_VITAMINE`);

--
-- Index pour la table `valeur_nutritionnelle`
--
ALTER TABLE `valeur_nutritionnelle`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FK6ssfs0i38sl5knqe0gylxbq2m` (`ID_PRODUIT`);

--
-- Index pour la table `vitamine`
--
ALTER TABLE `vitamine`
  ADD PRIMARY KEY (`id`),
  ADD KEY `FKdaxhk8ch7ao9seeycgx5ghj3i` (`ID_PRODUIT`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `additif`
--
ALTER TABLE `additif`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `allergene`
--
ALTER TABLE `allergene`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `categorie`
--
ALTER TABLE `categorie`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `marque`
--
ALTER TABLE `marque`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `produit`
--
ALTER TABLE `produit`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `valeur_nutritionnelle`
--
ALTER TABLE `valeur_nutritionnelle`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `vitamine`
--
ALTER TABLE `vitamine`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
