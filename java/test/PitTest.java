import static org.junit.jupiter.api.Assertions.*;
import org.junit.Test;


public class PitTest {
	@Test
	public void TestConstructor() {
		Kalaha kalaha = new Kalaha();
		new Pit(4, 1, 1, kalaha);
	}

}