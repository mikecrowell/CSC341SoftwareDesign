import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;


@RunWith(Suite.class)
@SuiteClasses({ BadGuyTest.class, BasicGameProgramGUITest.class,
		BoardCollisionTest.class, GamePrizeTest.class,
		MoveChasePlayerAndPrizeTest.class, PlayerCharacterTest.class })
public class AllTests {

}
