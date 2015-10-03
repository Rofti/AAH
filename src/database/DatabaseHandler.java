package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import utils.Party;
import utils.Player;

public class DatabaseHandler {

	private final String DATABASE_NAME = "aah-database";
	private final String DATABASE_USER = "UserAAH";
	private final String DATABASE_USERPW = "1234aah";

	/**
	 * Opens a Database connection to the Database defined in DATABASE_NAME with
	 * the DATABASE_USER.
	 * 
	 * @return returns open Connection.
	 */
	private Connection openDataBase() {
		Connection connect = null;
		try {
			// This will load the MySQL driver, each DB has its own driver
			Class.forName("com.mysql.jdbc.Driver");
			// Setup the connection with the DB

			connect = DriverManager.getConnection("jdbc:mysql://localhost/"
					+ DATABASE_NAME + "?" + "user=" + DATABASE_USER
					+ "&password=" + DATABASE_USERPW);

		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();

			System.err.println("Message: " + e.getMessage());
		}
		return connect;
	}

	/**
	 * Closes Connection, Statement and ResultSet
	 * 
	 * @param connect
	 *            Connection to close.
	 * @param stmt
	 *            Statement to close.
	 * @param resSet
	 *            ResultSet to close.
	 */
	private void closeDatabase(Connection connect, Statement stmt,
			ResultSet resSet) {
		try {
			if (resSet != null) {
				resSet.close();
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		}
		try {
			if (stmt != null) {
				stmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		}
		try {
			if (connect != null) {
				connect.close();
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		}
	}

	// <<<<<<<<<<<<<<<<<CRUD PLAYER>>>>>>>>>>>>>>>>>>>>>>>>

	public void createPlayer(Player player, String password) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "INSERT INTO Player " + "VALUES ( '"
					+ player.getPlayerName() + "' , '" + player.getNickname()
					+ "' , '" + password + "' , '"
					+ player.getPartiesJSON().toString() + "' );";

			stmt.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}

	}

	public Player readPlayer(String nickname) {

		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		Player player = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "SELECT Name, Nickname, PartySlots FROM Player WHERE Nickname=\""
					+ nickname + "\"";

			resSet = stmt.executeQuery(sqlQuery);
			if (resSet.next()) {
				JSONArray partySlots = new JSONArray();
				try {
					partySlots = new JSONArray(resSet.getString("PartySlots"));
				} catch (JSONException e) {
					e.printStackTrace(System.err);
					System.err.println("Message: " + e.getMessage());
					System.err.println("Error when reading player "
							+ resSet.getString("Nickname")
							+ ". PartySlots could not be parsed.");
				}
				player = new Player(resSet.getString("Name"),
						resSet.getString("Nickname"), partySlots);
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
		return player;
	}

	public String readPlayerPassword(String nickname) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		String password = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "SELECT Password FROM Player WHERE Nickname=\""
					+ nickname + "\"";

			resSet = stmt.executeQuery(sqlQuery);
			if (resSet.next()) {
				password = resSet.getString("Password");
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
		return password;

	}

	public List<Player> readAllPlayerOfParty(int partyID) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		Player player = null;
		ArrayList<Player> playerList = new ArrayList<Player>();
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "SELECT Name, Nickname, PartySlots FROM Player";

			resSet = stmt.executeQuery(sqlQuery);
			while (resSet.next()) {
				JSONArray partySlots = new JSONArray();
				try {
					partySlots = new JSONArray(resSet.getString("PartySlots"));
				} catch (JSONException e) {
					e.printStackTrace(System.err);
					System.err.println("Message: " + e.getMessage());
					System.err.println("Error when reading player "
							+ resSet.getString("Nickname")
							+ ". PartySlots could not be parsed.");
				}
				player = new Player(resSet.getString("Name"),
						resSet.getString("Nickname"), partySlots);
				for (int i = 0; i < partySlots.length(); ++i) {
					if (partySlots.getInt(i) == partyID) {
						playerList.add(player);
					}
				}
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
		return playerList;
	}

	public void updatePlayer(Player player) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "UPDATE Player " + "SET Name='" + player.getPlayerName()
					+ "' ," + "PartySlots='" + player.getPartiesJSON() + "' "
					+ " WHERE Nickname='" + player.getNickname() + "';";

			stmt.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
	}

	public void updatePlayerPassword(String nickname, String password) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "UPDATE Player " + "SET Password='" + password + "' "
					+ " WHERE Nickname='" + nickname + "';";

			stmt.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
	}

	public void deletePlayer(String nickname) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "DELETE FROM Player WHERE Nickname='" + nickname + "'";

			stmt.executeUpdate(sqlQuery);

			// TODO: DELETE ALL CHARACTER OF THIS PLAYER (database consistency)
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}

	}

	// <<<<<<<<<<<<<<<<<CRUD PLAYER>>>>>>>>>>>>>>>>>>>>>>>>

	public int createParty(Party party) {
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		int generatedID = -1;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "INSERT INTO Party(DungeonMasterName , ThirstModifier,"
					+ " HungerModifier, SanityModifier, CharacterSlots)"
					+ "VALUES ( '" + party.getNicknameDM() + "' , '"
					+ party.getThirstMod() + "' , '" + party.getHungerMod()
					+ "' , '" + party.getSanityMod() + "' , '"
					+ party.getCharactersJSON().toString() + "' );";

			stmt.executeUpdate(sqlQuery,Statement.RETURN_GENERATED_KEYS);
			resSet = stmt.getGeneratedKeys();

			if (resSet.next()) {
				generatedID = resSet.getInt(1);
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
		return generatedID;
	}

	public Party readParty(int partyID) {

		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		Party party = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "SELECT DungeonMasterName , ThirstModifier, HungerModifier, SanityModifier, CharacterSlots FROM Party WHERE PartyID="
					+ partyID;

			resSet = stmt.executeQuery(sqlQuery);
			if (resSet.next()) {
				JSONArray characterSlots = new JSONArray();
				try {
					characterSlots = new JSONArray(
							resSet.getString("CharacterSlots"));
				} catch (JSONException e) {
					e.printStackTrace(System.err);
					System.err.println("Message: " + e.getMessage());
					System.err.println("Error when reading player "
							+ resSet.getString("Nickname")
							+ ". PartySlots could not be parsed.");
				}
				party = new Party(resSet.getString("DungeonMasterName"),
						resSet.getInt("ThirstModifier"),
						resSet.getInt("HungerModifier"),
						resSet.getInt("SanityModifier"), characterSlots);
			}
		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
		return party;
	}

	public void updateParty(int partyID, Party party){
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "UPDATE Party " + "SET DungeonMasterName='" + party.getNicknameDM()
					+ "' ," + "ThirstModifier=" + party.getThirstMod()
					+ "," + "HungerModifier=" + party.getHungerMod()
					+ "," + "SanityModifier=" + party.getSanityMod()
					+ "," + "CharacterSlots='" + party.getCharactersJSON()+ "'"
					+ " WHERE PartyID="+partyID +";";

			stmt.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
	}

	public void deleteParty(int partyID){
		Connection connect = null;
		Statement stmt = null;
		ResultSet resSet = null;
		try {
			connect = openDataBase();
			stmt = connect.createStatement();

			String sqlQuery;
			sqlQuery = "DELETE FROM Party WHERE PartyID=" + partyID;

			stmt.executeUpdate(sqlQuery);

		} catch (SQLException e) {
			e.printStackTrace(System.err);

			System.err.println("SQLState: " + ((SQLException) e).getSQLState());

			System.err.println("Error Code: "
					+ ((SQLException) e).getErrorCode());

			System.err.println("Message: " + e.getMessage());
		} finally {
			closeDatabase(connect, stmt, resSet);
		}
	}
}