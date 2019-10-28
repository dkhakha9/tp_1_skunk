import static org.junit.Assert.*;

import org.junit.Test;

public class SkunkAppTest
{
	@Test
	public void testTwoPlayers()
	{
		Integer[] testArr1 = {0, 3, 2, 7,  1, 21, 30, 51, 1};
		Integer[] testArr2 = {0, 6, 1, 15, 3, 19, 7,  49, 1};
		
		SkunkApp skunkGame = new SkunkApp(testArr1, testArr2);
		
		assertFalse(skunkGame.isGameOver());
		
		assertEquals("Enter name of player 1\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Dmitry");
		
		assertEquals("Enter name of player 2\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("");
		
		assertEquals("Invalid answer, please re-enter\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Eric");
		
		assertEquals("Add more players? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("What..");
		
		assertEquals("Invalid answer, please re-enter\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("N");
		
		assertEquals("Dmitry, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's roll");
		
		assertEquals("You rolled 3 + 6. Roll again? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("y");
		
		assertEquals("You rolled 2 + skunk. End of turn. Points: 0. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Oh, man..");
		
		assertEquals("Eric, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's do this");
		
		assertEquals("You rolled 7 + 15. Roll again? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 22. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Good start");
		
		assertEquals("Dmitry, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's roll");
		
		assertEquals("You rolled skunk + 3. End of turn. Points: 0. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Son of a..");
		
		assertEquals("Eric, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's do this");
		
		assertEquals("You rolled 21 + 19. Roll again? (y/n)\n", skunkGame.nextMessage()); // 22 | 40
		
		skunkGame.submitResponse("Yes, please");
		
		assertEquals("Invalid answer, please re-enter\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Y");
		
		assertEquals("You rolled 30 + 7. Roll again? (y/n)\n", skunkGame.nextMessage()); // 22 | 40 + 37
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 99. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("That's how I roll");
		
		assertEquals("Dmitry, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's roll");
		
		assertEquals("You rolled 51 + 49. Roll again? (y/n)\n", skunkGame.nextMessage()); // 0 | 100
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 100. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("This is the most epic come back ever");
		
		assertEquals("Eric, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("I just need two points..");
		
		assertEquals("You rolled skunk + skunk. End of turn. Points: 0. Press Enter to continue\n", skunkGame.nextMessage());
		
		assertFalse(skunkGame.isGameOver());
		
		skunkGame.submitResponse("OMG, not THESE two points!");
		
		assertTrue(skunkGame.isGameOver());
		
		assertEquals("Game over! Winner: Dmitry\n", skunkGame.nextMessage());
	}
	
	@Test
	public void testThreePlayers()
	{
		Integer[] testArr1 = {0, 34, 27, 2, 3, 2, 2, 1, 40, 1, 6, 20, 50};
		Integer[] testArr2 = {0, 54, 33, 2, 7, 3, 1, 3, 46, 1, 7, 22, 52};
		
		SkunkApp skunkGame = new SkunkApp(testArr1, testArr2);
		
		assertFalse(skunkGame.isGameOver());
		
		assertEquals("Enter name of player 1\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Dmitry");
		
		assertEquals("Enter name of player 2\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Dmitry");
		
		assertEquals("Player already exists, please re-enter\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Eric");
		
		assertEquals("Add more players? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("y");
		
		assertEquals("Enter name of player 3\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("eric");
		
		assertEquals("Player already exists, please re-enter\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Clarens");
		
		assertEquals("Add more players? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("n");
		
		assertEquals("Dmitry, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's roll");
		
		assertEquals("You rolled 34 + 54. Roll again? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("n");
		
		assertEquals("End of turn. Points: 88. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Here we go..");
		
		assertEquals("Eric, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's do this");
		
		assertEquals("You rolled 27 + 33. Roll again? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 60. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Good start");
		
		assertEquals("Clarens, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Bring it in");
		
		assertEquals("You rolled 2 + 2. Roll again? (y/n)\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Y");
		
		assertEquals("You rolled 3 + 7. Roll again? (y/n)\n", skunkGame.nextMessage()); // 0 | 4 + 10
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 14. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("That's how I roll");
		
		assertEquals("Dmitry, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's roll");
		
		assertEquals("You rolled 2 + 3. Roll again? (y/n)\n", skunkGame.nextMessage()); // 88 | 5
		
		skunkGame.submitResponse("Y");
		
		assertEquals("You rolled 2 + skunk. End of turn. Points: 88. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("You've got to be kidding me..");
		
		assertEquals("Eric, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's do this");
		
		assertEquals("You rolled skunk + 3. End of turn. Points: 60. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Happens..");
		
		assertEquals("Clarens, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Bring it in");
		
		assertEquals("You rolled 40 + 46. Roll again? (y/n)\n", skunkGame.nextMessage()); // 14 | 86
		
		skunkGame.submitResponse("Y");
		
		assertEquals("You rolled skunk + skunk. End of turn. Points: 0. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Are these dice crooked?");
		
		assertEquals("Dmitry, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's roll");
		
		assertEquals("You rolled 6 + 7. Roll again? (y/n)\n", skunkGame.nextMessage()); // 88 | 13
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 101. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Try to get me now");
		
		assertEquals("Eric, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Let's do this");
		
		assertEquals("You rolled 20 + 22. Roll again? (y/n)\n", skunkGame.nextMessage()); // 60 | 42
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 102. Press Enter to continue\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Not so fast");
		
		assertEquals("Clarens, your turn. Press Enter to roll the dice\n", skunkGame.nextMessage());
		
		skunkGame.submitResponse("Bring it in");
		
		assertEquals("You rolled 50 + 52. Roll again? (y/n)\n", skunkGame.nextMessage()); // 0 | 102
		
		skunkGame.submitResponse("N");
		
		assertEquals("End of turn. Points: 102. Press Enter to continue\n", skunkGame.nextMessage());
		
		assertFalse(skunkGame.isGameOver());
		
		skunkGame.submitResponse("I think I win!");
		
		assertTrue(skunkGame.isGameOver());
		
		assertEquals("Game over! Winner: Eric\n", skunkGame.nextMessage());
	}
}
