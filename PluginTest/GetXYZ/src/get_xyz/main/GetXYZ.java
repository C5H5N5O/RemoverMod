package get_xyz.main;


//import java.sql.SQLException;
//import java.util.logging.Logger;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitScheduler;

import java.sql.SQLException;

import org.bukkit.Bukkit;

import org.bukkit.entity.Player;


public class GetXYZ extends JavaPlugin{
	
	
	DataBase DB = new DataBase();
	
	@Override
	public void onEnable() {
		
		BukkitScheduler scheduler = getServer().getScheduler();

		try {
			
			DB.Connect();
			
		} catch (ClassNotFoundException | SQLException e1) {e1.printStackTrace();}
		
        scheduler.scheduleSyncRepeatingTask(this, new Runnable() {
            @Override
            public void run() {
	            for (Player p : Bukkit.getOnlinePlayers()) {
	            	
	            	try {	
	            	
	            	DB.WritePlayerLocation(p.getName(), p.getLocation().getBlockX(), p.getLocation().getBlockZ());
	            		
					} catch (SQLException e) { }
	            	
	            }
            }
        }, 0L, 100L);

	}

}
