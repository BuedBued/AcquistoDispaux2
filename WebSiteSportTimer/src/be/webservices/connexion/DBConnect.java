package be.webservices.connexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	/**** Attributs ****/
	private static Connection instance = null;

	/**** Constructeurs ****/
	public DBConnect() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			instance = DriverManager.getConnection(url, "adjee", "azerty"); //A modifier quand la DB sera faite
		} catch (ClassNotFoundException ex) {
			System.out.println("Classe de driver introuvable" + ex.getMessage());
			System.exit(0);
		} catch (SQLException ex) {
			System.out.println("Erreur JDBC : " + ex.getMessage());
		}

		if (instance == null) {
			System.out.println("La base de données est inaccessible, fermeture du programme.");
			System.exit(0);
		}
	}

	/**** Méthodes ****/
	public static Connection getInstance() {
		if (instance == null) {
			new DBConnect();
		}
		return instance;
	}
}
