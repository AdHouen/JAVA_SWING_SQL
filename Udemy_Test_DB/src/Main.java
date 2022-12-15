import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {

	public static void main(String[] args) {
		
//		try (Connection connection = DriverManager.getConnection("jdbc:sqlite:I:/GitHub/JAVA_SWING_SQL/Udemy_Test_DB/databases/testjava.db");
//				Statement statement = connection.createStatement()) {
//		statement.execute("CREATE TABLE contact (name TEXT, phone INTEGER, email TEXT)");

		try {
			Connection connection = DriverManager.getConnection("jdbc:sqlite:I:/GitHub/JAVA_SWING_SQL/Udemy_Test_DB/databases/testjava.db");
			
//			connection.setAutoCommit(false);
			
			Statement statement = connection.createStatement();
			
			statement.execute("CREATE TABLE IF NOT EXISTS contact " +
								"(name TEXT, phone INTEGER, email TEXT)");
			
//			statement.execute("INSERT INTO contact (name, phone, email)" +
//					"VALUES ('Jane',24242424,'jane@email.com')");
//			statement.execute("INSERT INTO contact (name, phone, email)" +
//					"VALUES ('Joe',9026548,'joe@email.com')");
//			statement.execute("INSERT INTO contact (name, phone, email)" +
//					"VALUES ('Fido',986541528,'fido@email.com')");
			
			
			
			statement.execute("SELECT * FROM contact");
			ResultSet results = statement.getResultSet();
			while (results.next()) {
				System.out.println(results.getString("name") + " " +
						results.getInt("phone") + " " +
						results.getString("email"));
				
			}
			
			
			statement.close();
			connection.close();
			
			
			
			
			
		} catch (SQLException e) {
			System.out.println("Something went wrong : " + e.getMessage());
		}
	}

}
