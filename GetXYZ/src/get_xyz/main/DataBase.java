package get_xyz.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.ResultSet;

import java.util.Formatter;

import org.bukkit.Bukkit;







public class DataBase {	
	
	static Connection conn;
	static Statement statmt;
	static ResultSet rs;
	static Formatter f = new Formatter();
	
	
	
	
	// --------œŒƒ Àﬁ◊≈Õ»≈   ¡¿«≈ ƒ¿ÕÕ€’--------
	public void Connect() throws ClassNotFoundException, SQLException {
		
		Class.forName("org.sqlite.JDBC");
		conn = DriverManager.getConnection("jdbc:sqlite:D:\\_projects\\Remover\\db.db");
		   
		statmt = conn.createStatement();
		   
		Bukkit.getLogger().info("database connected");
		   
	   }
	

	private void UpdateField(String ItemName, String Item, String Table, String Line) throws SQLException {
		
		rs = statmt.executeQuery("SELECT * FROM '"+ Table +"'");
		
		statmt.execute("SELECT "+ ItemName +" FROM "+ Table +"' WHERE name = '"+ Line +"'");
		statmt.execute("update '"+ Table +"' set '"+ItemName+"' = "+ Item);
	}
	
	
	public void WritePlayerLocation(String Player, int X, int Z) throws SQLException {
		

			
			UpdateField("X", String.valueOf(X), "players_XZ", Player);
			UpdateField("Z", String.valueOf(Z), "players_XZ", Player);
			
			//statmt.execute("SELECT X FROM 'players_XZ' WHERE name = '"+Player+"'");
				
			//statmt.execute("SELECT X FROM 'players_XZ' WHERE name = '"+Player+"'");
			//statmt.execute("update 'players' set 'X' = "+ X);
				
			//statmt.execute("SELECT Z FROM 'players_XZ' WHERE name = '"+Player+"'");
			//statmt.execute("update 'players' set 'Z' = "+ Z);

		
	}
	
}
