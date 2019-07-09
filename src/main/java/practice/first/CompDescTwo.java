package practice.first;

import java.util.Comparator;

public class CompDescTwo implements Comparator {
    public int compare(Object o1, Object o2) {
        Film f1 = (Film)o1;
        Film f2 = (Film)o2;
        if (f1.getBudget() < f2.getBudget()) return 1;
        else if (f1.getBudget() > f2.getBudget()) return -1;
        else if (Integer.valueOf(f1.getYear()) > Integer.valueOf(f2.getYear())) return 1;
        else if (Integer.valueOf(f1.getYear()) == Integer.valueOf(f2.getYear())) return 0;
        else return -1;
    }
}
