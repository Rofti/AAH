package utils;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

public class Party {
	/**
	 * Nickname of the DungeonMaster/GameMaster
	 */
	private String nicknameDM;
	private int thirstMod;
	private int hungerMod;
	private int sanityMod;
	private JSONArray characters;

	public Party(String nicknameDM, int thirstMod, int hungerMod,
			int sanityMod, JSONArray characters) {
		super();
		this.nicknameDM = nicknameDM;
		this.thirstMod = thirstMod;
		this.hungerMod = hungerMod;
		this.sanityMod = sanityMod;
		this.characters = characters;
	}

	public String getNicknameDM() {
		return nicknameDM;
	}

	public void setNicknameDM(String nicknameDM) {
		this.nicknameDM = nicknameDM;
	}

	public int getThirstMod() {
		return thirstMod;
	}

	public void setThirstMod(int thirstMod) {
		this.thirstMod = thirstMod;
	}

	public int getHungerMod() {
		return hungerMod;
	}

	public void setHungerMod(int hungerMod) {
		this.hungerMod = hungerMod;
	}

	public int getSanityMod() {
		return sanityMod;
	}

	public void setSanityMod(int sanityMod) {
		this.sanityMod = sanityMod;
	}

	public JSONArray getCharactersJSON() {
		return characters;
	}

	public void setCharacters(JSONArray characters) {
		this.characters = characters;
	}

	public List<Integer> getCharactersList() {
		ArrayList<Integer> charactersList = new ArrayList<Integer>();
		for (int i = 0; i < characters.length(); ++i) {
			charactersList.add(characters.getInt(i));
		}
		return charactersList;
	}

	@Override
	public boolean equals(Object other) {
		boolean result = false;
		if (other == null) {
			return result;
		}
		if (other instanceof Party) {
			Party that = (Party) other;
			result = (this.nicknameDM.equals(that.nicknameDM)
					&& this.hungerMod == that.hungerMod
					&& this.thirstMod == that.thirstMod && this.sanityMod == that.sanityMod);
			if (result
					&& this.getCharactersJSON().length() == that
							.getCharactersJSON().length()) {
				for (int i = 0; i < this.getCharactersJSON().length(); i++) {
					try {
						if (this.getCharactersJSON().getInt(i) != that
								.getCharactersJSON().getInt(i)) {
							result = false;
						}
					} catch (JSONException e) {
						e.printStackTrace(System.err);
						System.err.println("Message: " + e.getMessage());
						result = false;
						break;
					}
				}
			} else {
				result = false;
			}
		}
		return result;
	}

	@Override
	public int hashCode() {
		return this.getNicknameDM().hashCode();
	}

}
