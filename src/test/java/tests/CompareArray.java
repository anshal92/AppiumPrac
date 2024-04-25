package tests;

import java.util.ArrayList;
import java.util.Arrays;

public class CompareArray {
    public static void main(String[] args) {
        String[] actual = {"Japan", "UK", "France"};
        String[] expected = {"India", "US", "UK"};

        ArrayList<String> actualList = new ArrayList<>(Arrays.asList(actual));
        ArrayList<String> expectedList = new ArrayList<>(Arrays.asList(expected));
        //Find out elements missing in actual that are in expected
        for(String x: actualList){
            expectedList.removeIf(ele -> ele.equals(x));
        }
        System.out.println("elements missing in actual that are in expected -> "+expectedList);

        //Find out elements that are common
        ArrayList<String> common = new ArrayList<>(Arrays.asList(expected));
        common.removeAll(expectedList);
        System.out.println("Elements that are common -> "+ common);

    }
}
