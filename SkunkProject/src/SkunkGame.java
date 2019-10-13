import java.util.ArrayList;

public class SkunkGame
{
	public static final int NUM_CHIPS_TO_START = 50;
	public static final int POINT_LIMIT = 100;
	
	private ArrayList<Player> Players;
	private int currentPlayer;
	private boolean hundredScored;
	
	Dice dice;
	
	Player winner;
	
	public SkunkGame()
	{
		this.Players = new ArrayList<>();
		this.currentPlayer = -1;
		this.hundredScored = false;
		
		dice = new Dice();
	}
	
	public boolean addPlayer(String name)
	{
		boolean duplicateName = false;
		
		for (Player player: Players)
		{
			if (player.getName().compareTo(name) == 0)
			{
				duplicateName = true;
				break;
			}
		}
		
		if (!duplicateName)
		{
			this.Players.add(new Player(name, NUM_CHIPS_TO_START));
		}
		
		return (!duplicateName);
	} /* addPlayer */
	
	public boolean hasEnoughPlayers()
	{
		return (this.Players.size() > 1);
	}
	
	public int numberOfPlayers()
	{
		return this.Players.size();
	}
	
	public boolean nextPlayer()
	{
		boolean gameOver = false;
		
		currentPlayer++;
		
		if (currentPlayer >= Players.size())
			currentPlayer = 0;
		
		if (Players.get(currentPlayer).hadLastTurn())
		{
			currentPlayer = -1;
			gameOver = true;
		}
		
		return (!gameOver);
	} /* getNextPlayer */
	
	public boolean roolTheDice()
	{
		boolean canRollAgain = false;
		
		Player player = Players.get(currentPlayer);
		
		dice.roll();
		
		int diceRoll = dice.getLastRoll();
		
		if (diceRoll == 2)
		{
			player.loseAllPoints();
			// draw 4 chips
		}
		else if (diceRoll == 3)
		{
			player.loseTurnPoints();
			// draw 2 chips
		}
		else if (dice.toString().contains("skunk"))
		{
			player.loseTurnPoints();
			// draw 1 chip
		}
		else
		{
			player.addPoints(diceRoll);
			canRollAgain = true;
		}
		
		return canRollAgain;		
	} /* roolTheDice */
	
	public void endTurn()
	{
		Player player = Players.get(currentPlayer);
		
		player.updateScore();
		
		if (player.getScore() >= POINT_LIMIT)
		{
			if (!hundredScored)
			{
				// first player to reach 100 points
				winner = player;
				hundredScored = true;
			}
			else
			{
				// another player reached 100 points, determine winner
				if (player.getScore() > winner.getScore())
				{
					winner = player;
				}
			}
		}
		
		if (hundredScored)
		{
			player.onLastTurn();
		}
	}
	
	public String getPlayerName()
	{
		return Players.get(currentPlayer).getName();
	}
	
	public String getPlayerStats()
	{
		return ("Points: " + Players.get(currentPlayer).getScore());
	}
	
	public String getLastRoll()
	{
		return dice.toString();
	}
	
	public String getWinnerName()
	{
		return winner.getName();
	}
}
