import java.util.ArrayList;

public class SkunkGame
{
	public static final int NUM_CHIPS_TO_START = 50;
	
	private ArrayList<Player> Players;
	private int currentPlayer;
	
	public SkunkGame()
	{
		this.Players = new ArrayList<>();
		this.currentPlayer = -1;
	}
	
	public void addPlayer(String name)
	{
		this.Players.add(new Player(name, NUM_CHIPS_TO_START));
	}
	
	public boolean hasEnoughPlayers()
	{
		return (this.Players.size() > 1);
	}
	
	public int numberOfPlayers()
	{
		return this.Players.size();
	}
}
