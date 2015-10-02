package utils;

public class Skillcalculation {

	//<<<<<<<<<< HALF CALUCLATED SKILLS >>>>>>>>>>>>>>>
	
	public static int calculateLockpicking(int dexterity, int technicalSkill,
			int generalKnowledge, int lockpicking) {
		double calc = 0.4 * dexterity + 0.6 * technicalSkill + 0.2
				* generalKnowledge + lockpicking;
		return (int) calc;
	}

	public static int calculateSneaking(int dexterity, int agility, int endurance,
			int sneaking) {
		double calc = 0.4 * dexterity + 0.2 * agility + 0.2 * endurance
				+ sneaking;
		return (int) calc;
	}

	public static int calculateFireMaking(int dexterity, int chemistrySkill,
			int generalKnowledge, int natureKnowledge, int fireMaking) {
		double calc = 0.4 * dexterity + 0.2 * chemistrySkill + 0.2
				* generalKnowledge + 0.2 * natureKnowledge + fireMaking;
		return (int) calc;
	}

	public static int calculateMedicine(int medicineSkill, int biologySkill,
			int generalKnowledge, int natureKnowledge, int medicine) {
		double calc = 0.4 * medicineSkill + 0.4 * biologySkill + 0.2
				* generalKnowledge + 0.2 * natureKnowledge + medicine;
		return (int) calc;
	}

	public static int calculateCulinaryArts(int generalKnowledge, int dexterity,
			int natureKnowledge, int culinaryArts) {
		double calc = 0.2 * generalKnowledge + 0.4 * dexterity + 0.2
				* natureKnowledge + culinaryArts;
		return (int) calc;
	}

	public static int calculateWeaponry(int dexterity, int technicalSkill,
			int generalKnowledge, int weaponry) {
		double calc = 0.4 * dexterity + 0.4 * technicalSkill + 0.2
				* generalKnowledge + weaponry;
		return (int) calc;
	}

	public static int calculateWillToSurvive(int morallyBlunted, int endurance,
			int willToSurvive) {
		double calc = 0.4 * morallyBlunted + 0.2 * endurance + willToSurvive;
		return (int) calc;
	}

	public static int calculateLying(int generalKnowledge, int charisma,
			int eloquence, int lying) {
		double calc = 0.2 * generalKnowledge + 0.4 * charisma + 0.6 * eloquence
				+ lying;
		return (int) calc;
	}

	public static int calculatePersuasion(int intelligence, int charisma,
			int eloquence, int persuasion) {
		double calc = 0.2 * intelligence + 0.4 * charisma + 0.6 * eloquence
				+ persuasion;
		return (int) calc;
	}

	public static int calculateHumaninsight(int generalKnowledge, int charisma,
			int humaninsight) {
		double calc = 0.4 * generalKnowledge + 0.6 * charisma + humaninsight;
		return (int) calc;
	}

	public static int calculateMakingAntiserum(int biologySkill, int medicineSkill,
			int chemicalSkill, int makingAntiserum) {
		double calc = 0.2 * biologySkill + 0.4 * medicineSkill + 0.6
				* chemicalSkill;
		return (int) calc;
	}

	public static int calculateSpotting(int natureKnowledge, int intelligence,
			int spotting) {
		double calc = 0.6 * natureKnowledge + 0.4 * intelligence + spotting;
		return (int) calc;
	}

	public static int calculateDodging(int dexterity, int agility, int dodging) {
		double calc = 0.6 * dexterity + 0.4 * agility + dodging;
		return (int) calc;
	}

	public static int calculateBlocking(int strength, int endurance, int blocking) {
		double calc = 0.6 * strength + 0.4 * endurance + blocking;
		return (int) calc;
	}
	
	
	//<<<<<<<<<< FULLY CALCULATED SKILLS >>>>>>>>>>>>>>>
	
	
	public static int calculateMentalConstitution(int intelligence,
			int morallyBlunted, int strength, int weaponry, int medicineSkill) {
		double calc = 0.2 * intelligence + 0.4 * morallyBlunted + 0.3
				* strength + 0.3 * weaponry + 0.2 * medicineSkill;
		return (int) calc;
	}

	public static int calculateRobustness(int strength, int endurance,
			int willToSurvive) {

		double calc = 0.5 * strength + 0.6 * endurance + 0.5 * willToSurvive;
		return (int) calc;
	}

	public static int calculateCharm(int intelligence, int charisma, int humanInsight) {
		double calc = 0.3 * intelligence + 0.5 * charisma + 0.4 * humanInsight;
		return (int) calc;
	}

	public static int calculateResourcefulness(int intelligence, int generalKnowledge,
			int technicalSkill) {
		double calc = 0.4 * intelligence + 0.5 * generalKnowledge + 0.5
				* technicalSkill;
		return (int) calc;
	}

	public static int calculateThreatening(int morallyBlunted, int strength,
			int willToSurvive) {
		double calc = 0.4 * morallyBlunted + 0.6 * strength + 0.3
				* willToSurvive;
		return (int) calc;
	}

	public static int calculateValor(int morallyBlunted, int strength, int endurance,
			int weaponry, int willToSurvive) {
		double calc = 0.3 * morallyBlunted + 0.5 * strength + 0.1 * endurance
				+ 0.2 * weaponry + 0.5 * willToSurvive;
		return (int) calc;
	}
	
	//<<<<<<<<<< WEAPON-SKILLS >>>>>>>>>>>>>>>	

	public static int calculateMachineGun(int weaponry, int dexterity, int machineGun) {
		double calc = 0.2 * weaponry + 0.1 * dexterity + machineGun;
		return (int) calc;
	}

	public static int calculatePistol(int weaponry, int dexterity, int pistol) {
		double calc = 0.2 * weaponry + 0.1 * dexterity + pistol;
		return (int) calc;
	}

	public static int calculateThrowing(int strength, int dexterity, int throwing) {
		double calc = 0.1 * strength + 0.2 * dexterity + throwing;
		return (int) calc;
	}

	public static int calculateBlunt(int strength, int dexterity, int blunt) {
		double calc = 0.2 * strength + 0.1 * dexterity + blunt;
		return (int) calc;
	}

	public static int calculateSharp(int strength, int dexterity, int sharp) {
		double calc = 0.2 * strength + 0.1 * dexterity + sharp;
		return (int) calc;
	}

	public static int calculateUnarmed(int strength, int dexterity, int unarmed) {
		double calc = 0.2 * strength + 0.1 * dexterity + unarmed;
		return (int) calc;
	}

	public static int calculateOtherWeapons(int weaponry, int dexterity, int otherWeapon) {
		double calc = 0.2 * weaponry + 0.1 * dexterity + otherWeapon;
		return (int) calc;
	}
}
