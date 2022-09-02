package ro.siit.IoHw;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLOutput;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/main/resources/BiathlonCompetitorsList.txt"));
            Set<BiathlonCompetitor> competitors = new TreeSet<>();
            String line;
            while ((line = br.readLine())  != null){
                String[] values = line.split(",");
                String name = values[1];
                String time = values[3] ;
                String shootingRanges = values[4] + "," + values[5] +"," + values[6];
                String[] timeArray = time.split(":");
                int misses = (int) shootingRanges.chars().filter(num -> num == 'o').count();
                int minutes = Integer.parseInt(timeArray[0]);
                int seconds = Integer.parseInt(timeArray[1]);
                int timeBySeconds = (minutes * 60) + seconds + (misses*10);
                competitors.add(new BiathlonCompetitor(name, time, shootingRanges, timeBySeconds, misses));
            }
            showWinners(competitors);
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    private static void showWinners(Set<BiathlonCompetitor> competitors) {
        System.out.println("First place: ");
        competitors.stream().limit(1).forEach(System.out::println);
        System.out.println("Runner up: ");
        competitors.stream().skip(1).limit(1).forEach(System.out::println);
        System.out.println("Third place: ");
        competitors.stream().skip(2).limit(1).forEach(System.out::println);
    }

}