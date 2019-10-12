import edu.princeton.cs.introcs.StdOut;
import edu.princeton.cs.introcs.StdIn;

public class SkunkApp
{	
	private static final int STATE_REQUEST_PLAYER = 0;
	private static final int STATE_ADD_PLAYER = 1;
	private static final int STATE_NEED_MORE_PLAYERS = 2;
	private static final int STATE_ENTER_PLAYER_NAME = 3;
	private static final int STATE_GAME_OVER = -1;
	
	private int gameState;
	
	private boolean messageReady;
	private String currentMessage;
	
	private SkunkGame gameEngine;
	
	public SkunkApp()
	{
		this.gameEngine = new SkunkGame();
		this.gameState = STATE_REQUEST_PLAYER;
		this.messageReady = false;
		this.updateGameState();
	}
	
	private void updateCurrentMessage(String newMessage)
	{
		assert (!messageReady);
		
		this.currentMessage = newMessage;
		
		// indicate that new message is ready
		messageReady = true;
	} /* updateCurrentMessage */
	
	public String nextMessage()
	{
		assert (messageReady);
		return this.currentMessage;
	}
	
	public void submitResponse(String response)
	{
		// reset message ready flag
		messageReady = false;
		// call state machine
		updateGameState(response);
	}
	
	public boolean isGameOver()
	{
		return (this.gameState == STATE_GAME_OVER);
	}
	
	private void updateGameState(String userInput)
	{
		while (!messageReady)
		{
			//StdOut.println("Processing state: " + gameState);
			switch (this.gameState)
			{
				case STATE_REQUEST_PLAYER :
					if (gameEngine.hasEnoughPlayers())
					{
						updateCurrentMessage("Add more players? (y/n)\n");
						gameState = STATE_NEED_MORE_PLAYERS;
					}
					else
					{
						gameState = STATE_ENTER_PLAYER_NAME;
					}
					
					break;
				
				case STATE_ENTER_PLAYER_NAME :
					
					updateCurrentMessage("Enter name of player " + (gameEngine.numberOfPlayers() + 1) + "\n");
					gameState = STATE_ADD_PLAYER;
										
					break;
				
				case STATE_ADD_PLAYER :
					// Expected player name from user
					if (userInput.length() > 0)
					{
						gameEngine.addPlayer(userInput);
						gameState = STATE_REQUEST_PLAYER;
					}
					else
					{
						updateCurrentMessage("Invalid answer, please re-enter\n");
					}

					break;
				
				case STATE_NEED_MORE_PLAYERS :
					// Expected y/n from user
					if (userInput.toLowerCase().compareTo("y") == 0)
					{
						gameState = STATE_ENTER_PLAYER_NAME;
					}
					else if (userInput.toLowerCase().compareTo("n") == 0)
					{
						updateCurrentMessage("Game over!\n");
						gameState = STATE_GAME_OVER;
					}
					else
					{
						updateCurrentMessage("Invalid answer, please re-enter\n");
					}
					
					break;
			   
				case STATE_GAME_OVER :
					// should never get here
					assert false;
			
				default :
					// should never get here
					assert false;
			} /* switch gameState */
		} /* while message is not ready */
	} /* gameEngine */
	
	private void updateGameState()
	{
		this.updateGameState("");
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
