package tests;

import java.util.HashMap;

public class PrintFreqOfChar {
    public static void main(String[] args) {
        String [] str = {"a" , "c" , "c" , "b" , "a" , "d"};
        HashMap<String, Integer> hashMap = new HashMap<>();

        for(String s: str){
            if(!hashMap.containsKey(s)) hashMap.put(s, 1);
            else hashMap.put(s, hashMap.get(s)+1);
        }
        System.out.println("The frequency for str array is -> "+ hashMap);
    }
}
