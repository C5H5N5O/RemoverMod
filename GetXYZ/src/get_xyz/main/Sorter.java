package get_xyz.main;

import org.bukkit.entity.Player;

public class Sorter {
	
	BlockFinder blockFinder = new BlockFinder();
	
	private int GetDistanceBetween(int Dot1, int Dot2) {
		if (Dot1 > Dot2) return Dot1 - Dot2;
		return Dot2 - Dot1;
	}
	
	private Player[] AddElementInArray(Player[] array, Player player) {
		
	}
	
	public Player[] GetPlayersCanListen(Player player, Player[] players) {
		
		
		Player[] AlreadyChecked  = {player};
		Player[] PlayersCanListen = {player};

		for (Player p : players) {
			if (GetDistanceBetween(p.getLocation().getBlockX(), player.getLocation().getBlockX()) <= 50 &&
					GetDistanceBetween(p.getLocation().getBlockZ(), player.getLocation().getBlockZ()) <= 50) {
				if (blockFinder.IsWallBetween(p, player)) {
					 GetPlayersCanListen(p, players, AlreadyChecked, PlayersCanListen);
				}
				
			}
		}
		
		return PlayersCanListen;
	}
	
	
	private Player[] GetPlayersCanListen(Player player, Player[] players, Player[] AlreadyChecked, Player[] PlayersCanListen) {

		for (Player p : players) {
			if (GetDistanceBetween(p.getLocation().getBlockX(), player.getLocation().getBlockX()) <= 50 &&
					GetDistanceBetween(p.getLocation().getBlockZ(), player.getLocation().getBlockZ()) <= 50) {
				if (blockFinder.IsWallBetween(p, player)) {
					GetPlayersCanListen(p, players, AlreadyChecked, PlayersCanListen);
				}
				
			}
		}
		
		return PlayersCanListen;
	}
	
	
	public Player[] GetSortedPLayers(Player[] players) {
		Player[] Sortedplayers = {};

		return Sortedplayers;
	}
}
