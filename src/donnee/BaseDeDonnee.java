package donnee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseDeDonnee {
	
	
	private Connection connection = null;
	
	private BaseDeDonnee() {
		
		try {
			Class.forName(Acces.BASEDEDONNEES_DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			connection = DriverManager.getConnection(Acces.BASEDEDONNEES_URL, Acces.BASEDEDONNEES_USAGER, Acces.BASEDEDONNEES_MOTDEPASSE);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	private static BaseDeDonnee instance = null;
	public static BaseDeDonnee getInstance()
	{
		if(null == instance) instance = new BaseDeDonnee();
		return instance;
	}
	// SINGLETON - FIN
 	public Connection getConnection()
	{
		return this.connection;
	}

}


