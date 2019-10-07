import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

public class SkunkApp
{
	public static final int NUM_CHIPS_TO_START = 50;
	
	private static final int STATE_START = 0;
	private static final int STATE_ADD_PLAYER = 1;
	private static final int STATE_GAME_OVER = -1;
	
	private int gameState;
	
	private String currentMessage;
	
	public SkunkApp()
	{
		this.gameState = STATE_START;
		this.currentMessage = this.gameEngine();
	}
	
	public String nextMessage()
	{
		return this.currentMessage;
	}
	
	public void submitResponse(String response)
	{
		// call state machine
		this.currentMessage = this.gameEngine(response);
	}
	
	public boolean isGameOver()
	{
		return (this.gameState == STATE_GAME_OVER);
	}
	
	private String gameEngine(String userInput)
	{
		String messageToSend = "Error\n";
		
		switch (this.gameState)
		{
			case STATE_START :
				messageToSend = "Enter name of the 1st player\n";
				this.gameState = STATE_ADD_PLAYER;
				break;
			
			case STATE_ADD_PLAYER :
				messageToSend = "Game over!\n";
				this.gameState = STATE_GAME_OVER;
				break;
		   
			case STATE_GAME_OVER :
				// should never get here
				assert false;
		
			default :
				// should never get here
				assert false;
		} /* switch gameState */
		
		return messageToSend;
	} /* gameEngine */
	
	private String gameEngine()
	{
		return gameEngine("");
	}

	public static void main(String[] args)
	{
		StdOut.println("Welcome to Skunk game!\nThis is next line yo!");

		Dice dice = new Dice();
		
		dice.roll();
		
		StdOut.println("Your roll: " + dice.getLastRoll());
		
		SkunkApp skunkGame = new SkunkApp();
		
		String response;
		
		while (!skunkGame.isGameOver())
		{
			StdOut.println(skunkGame.nextMessage());
			response = StdIn.readLine();
			skunkGame.submitResponse(response);
		}
		
		// Show final message in case the game is over
		StdOut.println(skunkGame.nextMessage());
		
	} /* main */

} /* SkunkApp */
