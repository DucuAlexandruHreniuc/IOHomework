
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ro.siit.IoHw.BiathlonCompetitor;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;


public class BiathlonTests {
@Test
    public void parse_csv()  {
    try {
        BufferedReader br = new BufferedReader(new FileReader("src/main/resources/BiathlonCompetitorsListTest.txt"));
        String file;
        while ((file = br.readLine()) != null) {
            String[] values = file.split(",");
            String athleteNumber = "11";
            String umarJorgson = "Umar Jorgson";
            Assertions.assertEquals(umarJorgson, values[1]);
            Assertions.assertEquals(athleteNumber, values[0]);
        }
    }
    catch (IOException e) {
        e.printStackTrace();
    }
}
@Test
    public void calculate_winners(){
    Set<BiathlonCompetitor> competitorsTest = new TreeSet<>();
    competitorsTest.add(new BiathlonCompetitor("2", "-", "-", 30, 3));
    competitorsTest.add(new BiathlonCompetitor("3", "-", "-", 100, 0));
    BiathlonCompetitor firstPlace = new BiathlonCompetitor("1", "-", "-", 30, 2 );
    competitorsTest.add(firstPlace);
    Optional<BiathlonCompetitor> winner = competitorsTest.stream().findFirst();
    Assertions.assertEquals(winner, Optional.of(firstPlace));
}
}
