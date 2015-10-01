package utils;

public class Skillcalculation {

	public int calculateLockpicking(int dexterity, int technicalSkill, int generalKnowledge, int lockpicking) {
		double calc = 0.4 * dexterity + 0.6 * technicalSkill + 0.2 * generalKnowledge + lockpicking;
		return (int) calc;
	}

	public int calculateSneaking(int dexterity, int mobility, int stamina, int sneaking) {
		double calc = 0.4 * dexterity + 0.2 * mobility + 0.2 * stamina + sneaking;
		return (int) calc;
	}

	public int calculateFireMaking(int dexterity, int chemistrySkill, int generalKnowledge, int natureKnowledge,
			int fireMaking) {
		double calc = 0.4 * dexterity + 0.2 * chemistrySkill + 0.2 * generalKnowledge + 0.2 * natureKnowledge
				+ fireMaking;
		return (int) calc;
	}

	public int calculateMedicine(int medicineSkill, int biologySkill, int generalKnowledge, int natureKnowledge,
			int medicine) {
		double calc = 0.4 * medicineSkill + 0.4 * biologySkill + 0.2 * generalKnowledge + 0.2 * natureKnowledge
				+ medicine;
		return (int) calc;
	}

	public int calculateCulinaryArts(int generalKnowledge, int dexterity, int natureKnowledge, int culinaryArts) {
		double calc = 0.2 * generalKnowledge + 0.4 * dexterity + 0.2 * natureKnowledge + culinaryArts;
		return (int) calc;
	}

	public int calculateWeaponry(int dexterity, int technicalSkill, int generalKnowledge, int weaponry) {
		double calc = 0.4 * dexterity + 0.4 * technicalSkill + 0.2 * generalKnowledge + weaponry;
		return (int) calc;
	}

	public int calculateWillToSurvive(int morallyBlunted, int stamina, int willToSurvive) {
		double calc = 0.4 * morallyBlunted + 0.2 * stamina + willToSurvive;
		return (int) calc;
	}

	public int calculateLying(int generalKnowledge, int charisma, int eloquence, int lying) {
		double calc = 0.2 * generalKnowledge + 0.4 * charisma + 0.6 * eloquence + lying;
		return (int) calc;
	}

	public int calculatePersuasion(int intelligence, int charisma, int eloquence, int persuasion) {
		double calc = 0.2 * intelligence + 0.4 * charisma + 0.6 * eloquence + persuasion;
		return (int) calc;
	}

	public int calculateHumaninsight(int generalKnowledge, int charisma, int humaninsight) {
		double calc = 0.4 * generalKnowledge + 0.6 * charisma + humaninsight;
		return (int) calc;
	}

	public int calculateMakingAntiserum(int biologySkill, int medicineSkill, int chemicalSkill, int makingAntiserum) {
		double calc = 0.2 * biologySkill + 0.4 * medicineSkill + 0.6 * chemicalSkill;
		return (int) calc;
	}

	public int calculateSpotting(int natureKnowledge, int intelligence, int spotting) {
		double calc = 0.6 * natureKnowledge + 0.4 * intelligence + spotting;
		return (int) calc;
	}

	public int calculateDodging(int dexterity, int mobility, int dodging) {
		double calc = 0.6 * dexterity + 0.4 * mobility + dodging;
		return (int) calc;
	}

	public int calculateBlocking(int strength, int stamina, int blocking) {
		double calc = 0.6 * strength + 0.4 * stamina + blocking;
		return (int) calc;
	}

	public int calculateVersion(int intelligence, int morallyBlunted, int strength, int weaponry, int medicineSkill) {
		double calc = 0.2 * intelligence + 0.4 * morallyBlunted + 0.3 * strength + 0.3 * weaponry + 0.2 * medicineSkill;
		return (int) calc;
	}
	
	public int calculateRobustness(){
		
	}
	
	public int calculateCharm(){
		
	}
	
	public int calculateResourcefulness(){
		
	}
	
	public int calculateThreatening(){
		
	}
	
	public int calculateValor(){
		
	}
}
