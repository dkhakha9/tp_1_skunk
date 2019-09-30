import java.util.ArrayList;
import java.util.Arrays;

public class Die
{
	private int lastRoll;
	private ArrayList<Integer> rollSequence;
	private boolean testMode;

	public Die()
	{
		this.testMode = false;
		this.roll();
	}
	
	public Die(Integer[] testSequence)
	{
		this.testMode = true;
		this.rollSequence = new ArrayList<Integer>(Arrays.asList(testSequence));
		this.roll();
	}

	public int getLastRoll() // getter or accessor method
	{
		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return
						// anything
	{
		if (testMode)
		{
			if (this.rollSequence.isEmpty())
			{
				this.lastRoll = Integer.MIN_VALUE;
			}
			else
			{
				this.lastRoll = this.rollSequence.remove(0);
			}
		}
		else
		{
			this.lastRoll = (int) (Math.random() * 6 + 1);
		}
	} /* roll */

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}
	
	public boolean isInTestMode()
	{
		return this.testMode;
	}

}
