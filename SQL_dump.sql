CREATE TABLE CharacterProfile (
CharacterProfileID int NOT NULL PRIMARY KEY UNIQUE,
PlayerName varchar(256) NOT NULL,
	FOREIGN KEY (PlayerName) REFERENCES Player(Nickname) ON DELETE CASCADE,
Name varchar(256) NOT NULL,
Age int NOT NULL,
Gender varchar(256) NOT NULL,
Job varchar(256),
DateOfBirth varchar(256) NOT NULL,
Appearance varchar(256)
);

CREATE TABLE CharacterStats (
CharacterID int NOT NULL PRIMARY KEY UNIQUE,
BodyStatsID int NOT NULL UNIQUE, 
	FOREIGN KEY (BodyStatsID) REFERENCES BodyStats(BodyStatsID) ON DELETE CASCADE,
SocialStatsID int NOT NULL UNIQUE,
	FOREIGN KEY (SocialStatsID) REFERENCES SocialStats(SocialStatsID),
IntellectualStatsID int NOT NULL UNIQUE,
	FOREIGN KEY (IntellectualStatsID) REFERENCES IntellectualStats(IntellectualStatsID) ON DELETE CASCADE,
SkillsID int NOT NULL UNIQUE,
	FOREIGN KEY (SkillsID) REFERENCES Skills(SkillsID) ON DELETE CASCADE,
WeaponSkillsID int NOT NULL UNIQUE,
	FOREIGN KEY (WeaponSkillsID) REFERENCES WeaponSkills(WeaponSkillsID) ON DELETE CASCADE,
InventoryID int NOT NULL UNIQUE,
	FOREIGN KEY (InventoryID) REFERENCES Inventory(InventoryID) ON DELETE CASCADE,
CurrentHealth int NOT NULL,
CurrentThirst int NOT NULL,
CurrentHunger int NOT NULL,
CurrentSanity int NOT NULL
);

CREATE TABLE BodyStats (
BodyStatsID int NOT NULL PRIMARY KEY UNIQUE,
Dexterity int NOT NULL,
Agility int NOT NULL,
Strength int NOT NULL,
Endurance int NOT NULL
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
DungeonMasterName varchar(256) NOT NULL,
	FOREIGN KEY (DungeonMasterName) REFERENCES Player(Name) ON DELETE CASCADE,
PartyID int NOT NULL PRIMARY KEY UNIQUE,
NumberPlayer int NOT NULL,
ThirstModifier int NOT NULL,
HungerModifier int NOT NULL,
SanityModifier int NOT NULL,
CharacterSlot varchar(256)
);

CREATE TABLE Player (
Name varchar(256),
Nickname varchar(256) NOT NULL PRIMARY KEY,
Password varchar(256) NOT NULL,
PartySlot int,
	FOREIGN KEY (PartySlot) REFERENCES Party(PartyID) ON DELETE CASCADE
);

CREATE TABLE Inventory (
InventoryID int NOT NULL PRIMARY KEY,
Slot varchar(256),
Head varchar(256),
Torso varchar(256),
LeftHand varchar(256),
RightHand varchar(256),
Legs varchar(256),
Feet varchar(256)
);