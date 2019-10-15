import static org.junit.Assert.*;

import org.junit.Test;

public class SkunkAppTest {

	@Test
	public void test_game_state() {
		SkunkApp skunk = new SkunkApp();
		
		assertFalse(skunk.isGameOver());
	}

}
