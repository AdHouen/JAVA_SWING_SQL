import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {

	public static final String DB_NAME = "testjava.db";
	public static final String CONNECTION_STRING = "jdbc:sqlite:I:/GitHub/JAVA_SWING_SQL/Udemy_Test_DB/databases/" + DB_NAME;

	public static final String TABLE_CONTACTS = "contacts";

	public static final String COLUMN_NAME = "name";
	public static final String COLUMN_PHONE = "phone";
	public static final String COLUMN_EMAIL = "email";

	public static void main(String[] args) {

		try {
			Connection connection = DriverManager.getConnection(CONNECTION_STRING);

			Statement statement = connection.createStatement();

			statement.execute("DROP TABLE IF EXISTS " + TABLE_CONTACTS);

			statement.execute("CREATE TABLE IF NOT EXISTS " + TABLE_CONTACTS + " (" + COLUMN_NAME + " text, "
					+ COLUMN_PHONE + " text, " + COLUMN_EMAIL + "  text" + ")");
			
			//VALUES
			
			insertContact(statement, "Adrien", "0123456789", "ad@email.com");
			insertContact(statement, "Maryline", "0169696969", "mary@email.com");
			insertContact(statement, "Philippe", "0246824682", "phif@email.com");
			insertContact(statement, "Franco", "0135791357", "franco@email.com");

			// UPDATE
			statement.execute("UPDATE " + TABLE_CONTACTS + " SET " + COLUMN_PHONE + "='99999'" + " WHERE "
					+ COLUMN_NAME + "='Maryline'");

			// DELETE
			statement.execute("DELETE FROM " + TABLE_CONTACTS + " WHERE " + COLUMN_NAME + "='Franco'");

			// Methode 1 AFFICHAGE
//			statement.execute("SELECT * FROM contact");
//			ResultSet results = statement.getResultSet();

			// Methode 2 AFFICHAGE
			ResultSet results = statement.executeQuery("SELECT * FROM " + TABLE_CONTACTS);

			// Boucle

			while (results.next()) {
				System.out.println(results.getString(COLUMN_NAME) + " " + results.getString(COLUMN_PHONE) + " "
						+ results.getString(COLUMN_EMAIL));

			}

			results.close();

			statement.close();
			connection.close();

		} catch (SQLException e) {
			System.out.println("Something went wrong : " + e.getMessage());
			e.printStackTrace();
			}
	}

	private static void insertContact(Statement statement, String name, String phone, String email) throws SQLException {
		statement.execute("INSERT INTO " + TABLE_CONTACTS + " (" + COLUMN_NAME + ", " + COLUMN_PHONE + ", "
				+ COLUMN_EMAIL + " ) " + "VALUES ('" + name + "', " + phone + ", '" + email + "')");
		
		
		
	}
}
