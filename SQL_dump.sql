CREATE TABLE BodyStats (
BodyStatsID int NOT NULL PRIMARY KEY UNIQUE,
Dexterity int NOT NULL,
Agility int NOT NULL,
Strength int NOT NULL,
Endurance int NOT NULL
);

CREATE TABLE Inventory (
InventoryID int NOT NULL PRIMARY KEY,
Slot varchar(255),
Head varchar(255),
Torso varchar(255),
LeftHand varchar(255),
RightHand varchar(255),
Legs varchar(255),
Feet varchar(255)
);

CREATE TABLE SocialStats (
SocialStatsID int NOT NULL PRIMARY KEY UNIQUE,
Eloquence int NOT NULL,
Charisma int NOT NULL
);

CREATE TABLE IntellectualStats (
IntellectualStatsID int NOT NULL PRIMARY KEY UNIQUE,
MorallyBlunted int NOT NULL,
Intelligence int NOT NULL,
GeneralKnowledge int NOT NULL,
Biology int NOT NULL,
Chemistry int NOT NULL,
Nature int NOT NULL,
MedicalScience int NOT NULL,
Technology int NOT NULL
);

CREATE TABLE Skills (
SkillsID int NOT NULL PRIMARY KEY UNIQUE,
Lockpicking int NOT NULL,
Sneaking int NOT NULL,
FireMaking int NOT NULL,
Medicine int NOT NULL,
CulinaryArts int NOT NULL,
Weaponry int NOT NULL,
WillToSurvive int NOT NULL,
Lying int NOT NULL,
Persuasion int NOT NULL,
HumanInsight int NOT NULL,
MakingAntiserum int NOT NULL,
Spotting int NOT NULL,
Dodging int NOT NULL,
Blocking int NOT NULL
);

CREATE TABLE WeaponSkills (
WeaponSkillsID int NOT NULL PRIMARY KEY UNIQUE,
MachineGuns int NOT NULL,
Handguns int NOT NULL,
Throwing int NOT NULL,
MeleeBlunt int NOT NULL,
MeleeSharp int NOT NULL,
Unarmed int NOT NULL,
Other int NOT NULL
);

CREATE TABLE Party (
DungeonMasterName varchar(255) NOT NULL,
PartyID int NOT NULL PRIMARY KEY UNIQUE AUTO_INCREMENT,
ThirstModifier int NOT NULL,
HungerModifier int NOT NULL,
SanityModifier int NOT NULL,
CharacterSlots varchar(255)
);

CREATE TABLE Player (
Name varchar(255),
Nickname varchar(255) NOT NULL PRIMARY KEY,
Password varchar(255) NOT NULL,
PartySlots varchar(255) NOT NULL
);

CREATE TABLE CharacterProfile (
CharacterProfileID int NOT NULL PRIMARY KEY UNIQUE,
PlayerName varchar(255) NOT NULL,
Name varchar(255) NOT NULL,
Age int NOT NULL,
Gender varchar(255) NOT NULL,
Job varchar(255),
DateOfBirth varchar(255) NOT NULL,
Appearance varchar(255)
);

CREATE TABLE CharacterStats (
CharacterID int NOT NULL PRIMARY KEY UNIQUE,
BodyStatsID int NOT NULL UNIQUE, 
SocialStatsID int NOT NULL UNIQUE,
IntellectualStatsID int NOT NULL UNIQUE,
SkillsID int NOT NULL UNIQUE,
WeaponSkillsID int NOT NULL UNIQUE,
InventoryID int NOT NULL UNIQUE,
CurrentHealth int NOT NULL,
CurrentThirst int NOT NULL,
CurrentHunger int NOT NULL,
CurrentSanity int NOT NULL
);