package tests;

import static org.junit.Assert.*;

import java.util.List;

import org.json.JSONArray;
import org.junit.Before;
import org.junit.Test;

import utils.Player;
import database.DatabaseHandler;

public class DatabaseTest {

	DatabaseHandler dbHandler;
	Player testPlayer;

	@Before
	public void before() {
		dbHandler = new DatabaseHandler();
	}

	@Test
	public void crudPlayerTest() {
		String testPW ="testPW";
		Player testPlayer = new Player("testName", "testNick", new JSONArray(
				"[1,2,3]"));
		//test if player already exists in database
		Player readPlayer = dbHandler.readPlayer(testPlayer.getNickname());
		assertNull(readPlayer);

		//test player equals method
		assertNotEquals(testPlayer, readPlayer);
		assertEquals(testPlayer, testPlayer);
		
		Player equalsTestPlayer = new Player(testPlayer.getPlayerName(),
				testPlayer.getNickname(), new JSONArray("[1,2,3]"));
		assertEquals(testPlayer, equalsTestPlayer);
		
		equalsTestPlayer.setParties(new JSONArray("[1,2,4]"));
		assertNotEquals(testPlayer, equalsTestPlayer);

		//test createPlayer, readPlayer and readPlayerPassword
		dbHandler.createPlayer(testPlayer, testPW);
		
		readPlayer = dbHandler.readPlayer(testPlayer.getNickname());
		assertEquals(readPlayer, testPlayer);

		String readPassword = dbHandler.readPlayerPassword(testPlayer.getNickname());
		assertEquals(readPassword, testPW);
		
		// test updatePlayer
		dbHandler.updatePlayer(equalsTestPlayer);
		readPlayer=dbHandler.readPlayer(testPlayer.getNickname());
		assertNotEquals(readPlayer, testPlayer);
		assertEquals(readPlayer, equalsTestPlayer);
		
		//test updatePlayerPassword
		dbHandler.updatePlayerPassword(testPlayer.getNickname(),"1234");
		readPassword=dbHandler.readPlayerPassword(testPlayer.getNickname());
		assertNotEquals(readPassword,testPW);
		
		//test readAllPlayerofParty
		Player playerParty1 = new Player("pp1","pp1",new JSONArray("[1]"));
		dbHandler.createPlayer(playerParty1, "pp1");
		List<Player> playerList = dbHandler.readAllPlayerOfParty(1);
		assertEquals(2, playerList.size());
		playerList = dbHandler.readAllPlayerOfParty(2);
		assertEquals(1, playerList.size());
		assertEquals(readPlayer, playerList.get(0));
		dbHandler.deletePlayer(playerParty1.getNickname());
		playerList = dbHandler.readAllPlayerOfParty(1);
		assertEquals(1, playerList.size());
		
		//test deletePlayer and clean test data from database
		dbHandler.deletePlayer(testPlayer.getNickname());
		readPlayer = dbHandler.readPlayer(testPlayer.getNickname());
		assertNull(readPlayer);

	}

}
