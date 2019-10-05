import edu.princeton.cs.introcs.StdOut;

public class SkunkApp
{
	public static final int NUM_CHIPS_TO_START = 50;

	public static void main(String[] args)
	{
		StdOut.println("Welcome to Skunk game!");

		Dice dice = new Dice();
		
		dice.roll();
		
		StdOut.println("Your roll: " + dice.getLastRoll());
	} /* main */

} /* SkunkApp */
