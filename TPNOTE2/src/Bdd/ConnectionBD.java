package Bdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionBD {
		static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
		static final String urlBD = "jdbc:mysql://webtp.fil.univ-lille1.fr/bamporeye";
		 /**
		  * Nom du user
		 */
		private static String user = "bamporeye";
		/**
		 * Mot de passe du user
		 */
		private static String passwd = "nanette";
		private static Connection connect;

		/**
		 * Methode qui va nous retourner notre instance
		 * et la creer si elle n'existe pas...
		 * @return
		 */
		public static Connection getInstance(){
				try {
					Class.forName(JDBC_DRIVER);
					connect = DriverManager.getConnection(urlBD, user, passwd);
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					e.printStackTrace();
				}		
			return connect;	
		}

		public static Connection getConnect() {
			return connect;
		}

		public static void setConnect(Connection connect) {
			ConnectionBD.connect = connect;
		}	
}
