import static org.junit.Assert.*;

import org.junit.Test;

public class TestDie
{
	
	@Test
	public void testDieTestable()
	{
		Integer[] testArr = {1, 5, 0};
		
		Die die = new Die(testArr);
		
		assertTrue(die.isInTestMode()); // verify operating mode = test
		
		assertEquals(1, die.getLastRoll()); // verify first roll value
		
		die.roll();
		
		assertEquals(5, die.getLastRoll()); // verify second roll value
		
		assertEquals(5, die.getLastRoll()); // verify that value does not change without a roll
		
		die.roll();
		
		assertEquals(0, die.getLastRoll()); // verify third roll value
		
		die.roll();
		
		assertEquals(Integer.MIN_VALUE, die.getLastRoll()); // verify test sequence is exhausted
		
		die.roll();
		
		assertEquals(Integer.MIN_VALUE, die.getLastRoll()); // verify test sequence is exhausted (repeat)
	} /* testDieTestable */

	@Test
	public void testDieNormal()
	{		
		Die die = new Die();
		
		assertFalse(die.isInTestMode()); // verify operating mode = normal
		
		assertTrue((die.getLastRoll() >= 1) && (die.getLastRoll() <= 6)); // verify first roll value
		
		die.roll();
		
		int lastRoll = die.getLastRoll();
		
		assertTrue((lastRoll >= 1) && (lastRoll <= 6)); // verify second roll value
		
		assertEquals(lastRoll, die.getLastRoll()); // verify that value does not change without a roll
		
		die.roll();
		
		assertTrue((die.getLastRoll() >= 1) && (die.getLastRoll() <= 6)); // verify third roll value
		
		die.roll();
		
		assertTrue((die.getLastRoll() >= 1) && (die.getLastRoll() <= 6)); // verify fourth roll value
	} /* testDieNormal */
	
	@Test
	public void testDiceTestable1()
	{
		Integer[] testArr1 = {1, 5, 0};
		Integer[] testArr2 = {6, 3, -5};
		
		Die die1 = new Die(testArr1);
		Die die2 = new Die(testArr2);
		
		Dice dice = new Dice(die1, die2);
		
		assertTrue(dice.isInTestMode()); // verify operating mode = test
		
		assertEquals(7, dice.getLastRoll()); // verify first roll value
		
		dice.roll();
		
		assertEquals(8, dice.getLastRoll()); // verify second roll value
		
		assertEquals(8, dice.getLastRoll()); // verify that value does not change without a roll
		
		dice.roll();
		
		assertEquals(-5, dice.getLastRoll()); // verify third roll value
		
		dice.roll();
		
		assertEquals(0, dice.getLastRoll()); // verify test sequence is exhausted (subtraction from minimum results in maximum)
		
		dice.roll();
		
		assertEquals(0, dice.getLastRoll()); // verify test sequence is exhausted (repeat)
	} /* testDieTestable1 */
	
	@Test
	public void testDiceTestable2()
	{
		Integer[] testArr1 = {3, 2, 7, 1};
		Integer[] testArr2 = {6, 1, -15};
		
		Die die1 = new Die(testArr1);
		Die die2 = new Die(testArr2);
		
		Dice dice = new Dice(die1, die2);
		
		assertTrue(dice.isInTestMode()); // verify operating mode = test
		
		assertEquals(9, dice.getLastRoll()); // verify first roll value
		
		dice.roll();
		
		assertEquals(3, dice.getLastRoll()); // verify second roll value
		
		assertEquals(3, dice.getLastRoll()); // verify that value does not change without a roll
		
		dice.roll();
		
		assertEquals(-8, dice.getLastRoll()); // verify third roll value
		
		dice.roll();
		
		assertEquals(Integer.MIN_VALUE + 1, dice.getLastRoll()); // verify test sequence 2 is exhausted
		
		dice.roll();
		
		assertEquals(0, dice.getLastRoll()); // verify test sequence 1 is exhausted (subtraction from minimum results in maximum)
	} /* testDieTestable2 */
	
	@Test
	public void testDiceHalfTestable1()
	{
		Integer[] testArr = {3, 2, 7, 1};
		
		Die die1 = new Die(testArr);
		Die die2 = new Die();
		
		Dice dice = new Dice(die1, die2);
		
		assertTrue(dice.isInTestMode()); // verify operating mode = test
		
		assertTrue((dice.getLastRoll() >= 4) && (dice.getLastRoll() <= 9)); // verify first roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 3) && (dice.getLastRoll() <= 8)); // verify second roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 8) && (dice.getLastRoll() <= 13)); // verify third roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 7)); // verify fourth roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= Integer.MIN_VALUE + 1) && (dice.getLastRoll() <= Integer.MIN_VALUE + 6)); // verify fifth roll value
	} /* testDiceHalfTestable1 */
	
	@Test
	public void testDiceHalfTestable2()
	{
		Integer[] testArr = {3, 2, 7, 1};
		
		Die die1 = new Die(testArr);
		Die die2 = new Die();
		
		Dice dice = new Dice(die2, die1);
		
		assertTrue(dice.isInTestMode()); // verify operating mode = test
		
		assertTrue((dice.getLastRoll() >= 4) && (dice.getLastRoll() <= 9)); // verify first roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 3) && (dice.getLastRoll() <= 8)); // verify second roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 8) && (dice.getLastRoll() <= 13)); // verify third roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 7)); // verify fourth roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= Integer.MIN_VALUE + 1) && (dice.getLastRoll() <= Integer.MIN_VALUE + 6)); // verify fifth roll value
	} /* testDiceHalfTestable2 */
	
	@Test
	public void testDiceNormal1()
	{		
		Die die1 = new Die();
		Die die2 = new Die();
		
		Dice dice = new Dice(die2, die1);
		
		assertFalse(dice.isInTestMode()); // verify operating mode = normal
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 12)); // verify first roll value
		
		dice.roll();
		
		int lastRoll = dice.getLastRoll();
		
		assertTrue((lastRoll >= 2) && (lastRoll <= 12)); // verify second roll value
		
		assertEquals(lastRoll, dice.getLastRoll()); // verify that value does not change without a roll
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 12)); // verify third roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 12)); // verify fourth roll value
	} /* testDieNormal1 */
	
	@Test
	public void testDiceNormal2()
	{		
		Dice dice = new Dice();
		
		assertFalse(dice.isInTestMode()); // verify operating mode = normal
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 12)); // verify first roll value
		
		dice.roll();
		
		int lastRoll = dice.getLastRoll();
		
		assertTrue((lastRoll >= 2) && (lastRoll <= 12)); // verify second roll value
		
		assertEquals(lastRoll, dice.getLastRoll()); // verify that value does not change without a roll
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 12)); // verify third roll value
		
		dice.roll();
		
		assertTrue((dice.getLastRoll() >= 2) && (dice.getLastRoll() <= 12)); // verify fourth roll value
	} /* testDieNormal2 */
}
