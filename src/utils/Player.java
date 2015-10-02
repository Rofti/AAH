package utils;

import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;

public class Player {
	
	private String playerName;
	private final String nickname;
	/**
	 * JSONArray that contains all the IDs of parties this player is part of.
	 */
	private JSONArray parties;
	
	public Player(String playerName, String nickname, JSONArray parties) {
		super();
		this.playerName = playerName;
		this.nickname = nickname;
		this.parties = parties;
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}

	public JSONArray getPartiesJSON() {
		return parties;
	}

	public List<Integer> getPartiesList() {
		ArrayList<Integer> partyList= new ArrayList<Integer>();
		for(int i= 0; i< parties.length(); ++i){
			partyList.add(parties.getInt(i));
		}
		return partyList;
	}
	
	public void setParties(JSONArray parties) {
		this.parties = parties;
	}

	public String getNickname() {
		return nickname;
	}
	
	
}
