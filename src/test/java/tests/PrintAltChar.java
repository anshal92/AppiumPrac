package tests;

public class PrintAltChar {
    public static void main(String[] args) {
        String str ="123456789.764746"; //Output: 2468.676
        char[] strCharArray = str.toCharArray();
        System.out.println("The output array is -> ");
        for(int i = 1; i< strCharArray.length; i +=2){
            System.out.print(strCharArray[i]);
        }
    }
}
