
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import ohtuesimerkki.Player;
import ohtuesimerkki.Reader;
import ohtuesimerkki.Statistics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Raine Rantanen
 */
public class StatisticsTest {

    Reader readerStub = new Reader() {

        public List<Player> getPlayers() {
            ArrayList<Player> players = new ArrayList<Player>();

            players.add(new Player("Semenko", "EDM", 4, 12));
            players.add(new Player("Lemieux", "PIT", 45, 54));
            players.add(new Player("Kurri", "EDM", 37, 53));
            players.add(new Player("Yzerman", "DET", 42, 56));
            players.add(new Player("Gretzky", "EDM", 35, 89));

            return players;
        }
    };

    Statistics stats;

    public StatisticsTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        // luodaan Staatistics-olio joka käyttää "stubia"
        stats = new Statistics(readerStub);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void searchReturnsAddedPlayer() {
        Player kurri = stats.search("Kurri");
        assertEquals(kurri.getName(), "Kurri");
    }

    @Test
    public void searchReturnsNullIfPlayerNotAdded() {
        assertEquals(stats.search("Jutila"), null);
    }

    @Test
    public void teamReturnsRightSizePlayerList() {
        assertEquals(stats.team("EDM").size(), 3);
    }

    @Test
    public void topScorersReturnsRightPlayers() {
        List<Player> topScorers = stats.topScorers(2);
          
        assertEquals(topScorers.get(0).getName(), "Gretzky");
        assertEquals(topScorers.get(1).getName(), "Lemieux");
        assertEquals(topScorers.get(2).getName(), "Yzerman");
    }
}