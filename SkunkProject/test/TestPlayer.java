import static org.junit.Assert.*;

import org.junit.Test;

public class TestPlayer
{
	@Test(expected= AssertionError.class)
	public void testAssertionConstructor()
	{
		Player player = new Player("P1", -1);
	}
	
	@Test(expected= AssertionError.class)
	public void testAssertionScore()
	{
		Player player = new Player("P1", 5);
		
		player.addPoints(-1);
	}
	
	@Test(expected= AssertionError.class)
	public void testAssertionChips()
	{
		Player player = new Player("P1", 5);
		
		player.addChips(-1);
	}
	
	@Test(expected= AssertionError.class)
	public void testAssertionPenalty()
	{
		Player player = new Player("P1", 5);
		
		player.drawPenalty(-1);
	}
	
	@Test
	public void testPenalty()
	{
		Player player = new Player("P1", 5);
		
		assertEquals(4, player.drawPenalty(4));
		
		assertTrue(player.hasChips());
		
		assertEquals(1, player.drawPenalty(2));
		
		assertFalse(player.hasChips());
	}
	
	@Test
	public void testScore()
	{
		Player player = new Player("P1", 5);
		
		assertTrue(player.hasChips());
		
		assertEquals(0, player.getScore());
		
		player.addPoints(3);
		
		assertEquals(3, player.getScore());
		
		player.addPoints(11);
		
		assertEquals(14, player.getScore());
		
		assertTrue(player.hasChips());
		
		player.loseAllPoints();
		
		assertEquals(0, player.getScore());
		
		assertTrue(player.hasChips());
		
		player.addPoints(7);
		
		assertEquals(7, player.getScore());
	}
}
