package ro.siit.IoHw;

public class BiathlonCompetitor implements Comparable<BiathlonCompetitor> {
    String name;
    String timing;
    String shootingRange;
    int misses;
    int timeBySeconds;

    public BiathlonCompetitor(String name, String skiTiming, String shootingRange,  int timeBySeconds, int misses) {
        this.timeBySeconds = timeBySeconds;
        this.name = name;
        this.timing = skiTiming;
        this.shootingRange = shootingRange;
        this.misses = misses;
    }

    @Override
    public String toString() {
        return "Name: " + name +
                "| Ski Timing: " + timing + " + (" + misses*10 + ")" +
                "| Shooting Range Results: " + shootingRange + "\n";
    }

    @Override
    public int compareTo(BiathlonCompetitor otherBiathlonCompetitor) {
        if(timeBySeconds > otherBiathlonCompetitor.timeBySeconds){
            return 1;
        }
        if (timeBySeconds < otherBiathlonCompetitor.timeBySeconds){
            return -1;
        }
        return name.compareTo(otherBiathlonCompetitor.name);
        }
}
