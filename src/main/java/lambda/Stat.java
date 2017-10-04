package lambda;

import java.util.*;

/**
 * Created by Meyttt on 24.09.2017.
 */
public class Stat {
    public static void main(String[] args) {
        List<Day> days=Arrays.asList( new Day[]{new Day(9),new Day(19),
                new Day(10),new Day(26),new Day(14),new Day(18)});
        Day.moreThan(days,new Day(18)).forEach(day-> System.out.println(day));


    }
}

class Day implements Comparable<Day>{
    private int temp;

    public Day(int temp) {
        this.temp = temp;
    }

    public int getTemp() {
        return temp;
    }
    public static List<Day> moreThan(List<Day> days, Day someDay){
        List<Day> res = new LinkedList<>();
        days.forEach(item->{
            if(item.compareTo(someDay)>=0)
                res.add(item);
        });
        return res;
    }

    @Override
    public int compareTo(Day o) {
        if(this.getTemp()>o.getTemp()){return 1;}
        if(this.getTemp()<o.getTemp()){return -1;}
        return 0;
    }

    @Override
    public String toString() {
        return String.valueOf(temp);
    }
}
