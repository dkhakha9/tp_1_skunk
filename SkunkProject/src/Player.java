
public class Player
{
	private String name;
	private int chips;
	private int score;
	private int turnScore;
	private boolean lastTurn;
	
	public Player(String name, int startingChips)
	{
		this.name = name;
		assert startingChips >= 0;
		this.chips = startingChips;
		this.score = 0;
		this.turnScore = 0;
		this.lastTurn = false;
	}
	
	public int drawPenalty(int penalty)
	{
		int chipsBeforePenalty = this.chips;
		
		assert penalty >= 0;
		
		if (this.chips >= penalty)
		{
			this.chips -= penalty;
		}
		else
		{
			this.chips = 0;
		}
		
		// Return actual amount of chips taken from the player
		return (chipsBeforePenalty - this.chips);
	} /* drawPenalty */
	
	public void addChips(int receivedChips)
	{
		assert receivedChips >= 0;
		this.chips += receivedChips;
	}
	
	public void addPoints(int earnedPoints)
	{
		assert earnedPoints >= 0;
		this.turnScore += earnedPoints;
	}
	
	// Successful end of turn, save the score
	public void updateScore()
	{
		score += turnScore;
		turnScore = 0;
	}
	
	public void loseAllPoints()
	{
		this.score = 0;
		this.turnScore = 0;
	}
	
	public void loseTurnPoints()
	{
		turnScore = 0;
	}
	
	public int getScore()
	{
		return this.score;
	}
	
	public String getName()
	{
		return this.name;
	}
	
	public boolean hasChips()
	{
		return (this.chips > 0);
	}
	
	public boolean hadLastTurn()
	{
		return lastTurn;
	}
	
	public void onLastTurn()
	{
		lastTurn = true;
	}
}
