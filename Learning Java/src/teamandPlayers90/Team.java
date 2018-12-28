package teamandPlayers90;
import java.util.ArrayList;

public class Team {
	private String name;
	private ArrayList<Player> players;
	private int maxSize;
	private int goals;
	
	public Team(String name) {
		this.name = name;
		this.players = new ArrayList<Player>();
		this.maxSize = 16;
		this.goals = 0;
	}
	public String getName() {
		return this.name;
	}
	
	public void addPlayer(Player player) {
		if (this.size() < this.maxSize) {
			this.players.add(player);
		}
		
	}
	
	public void printPlayers() {

		for (Player player : this.players) {
			System.out.println(player);
			
		}
	}
	public void setMaxSize(int num) {
		this.maxSize = num;
		
	}
	public int size() {
		return this.players.size();
	}
	
	public int goals() {
		for (Player player : players) {
			this.goals += player.goals();
		}
		return this.goals;
	}
}
