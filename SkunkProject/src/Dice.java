import edu.princeton.cs.introcs.StdOut;

/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */

public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1;
	private Die die2;

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}

	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}
	
	public Dice(Integer[] die1Sequence, Integer[] die2Sequence) // overloaded constructor
	{
		this.die1 = new Die(die1Sequence);
		this.die2 = new Die(die2Sequence);
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	} /* testable Dice */

	// Instance methods can also be declared anywhere in body of class
	// One convention: after the constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll()
	{
		// Roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value

		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	} /* roll */
	
	public boolean isInTestMode()
	{
		return (this.die1.isInTestMode() || this.die2.isInTestMode());
	}

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// 4 + 3, skunk + 1
	//

	public String toString()
	{
		return die1.toString() + " + " + die2.toString();
	}

	// static methods can go anywhere - but at end is one convention

	public static final int NUM_TRIALS = 360;

	public static void main(String[] args)
	{
		// simulate repeated rolls of Dice, counting the many double skunks
		
		Dice dice = new Dice();
		int doubleSkunkCount = 0;

		for (int i = 0; i < NUM_TRIALS; i++)
		{
			dice.roll();
			StdOut.println(dice);

			if (dice.getLastRoll() == 2)
				doubleSkunkCount++;
		}

		StdOut.println("Actual count: " + doubleSkunkCount);
		StdOut.println("Expected count: " + (NUM_TRIALS / 36.0));
	}
}
