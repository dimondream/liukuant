package lab02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;

public class IterationExercises {

    /**
     * Returns the sum of all odd numbers up to the given integer.
     *
     * @param n	any integer
     * @return the sum of all odd integers up to and including n
     */
    public static int addOdds(int n) {
        int sum = 0 ;
        for(int i = 0; i <= n; i++){ //replace this line!!
            if (i%2 == 1){
                sum += i;
            }
        }
        return sum ;
    }

    /**
     * Given a string, replaces each digit in the string, that many occurrences of an asterisk character
     * Example: given the String "boole7an", return the String "boole*******an".
     *
     * @param str
     * @return an "asterisked up" string
     */
    public static String asteriskUp(String str) {
        String s = "";
        for(int i = 0;i < str.length(); i++){
            String star = "*";
            if (Character.isDigit(str.charAt(i)))
            {
                s += star.repeat(Character.getNumericValue(str.charAt(i)));
            }
            else
            {
                s += str.charAt(i);
            }
        }
        return s;
    }

    /**
     * Return the number of characters in String str1 that are also in String str2.
     * Example 1: if str1 is Pizza and str2 is Pepperoni, the function should return 2.
     * Example 2: if str1 is Pepperoni and str2 is Pizza, the function should return 4.
     *
     * @param str1	a String
     * @param str2	a String
     * @return	the number of characters in str1 that occur in str2.
     */
    public static int countCharacters(String str1, String str2) {
        int count = 0 ;
        String s1 = str1.toLowerCase();
        String s2 = str2.toLowerCase();
        for(int i = 0; i < s1.length(); i++){
            if (s2.contains("" + s1.charAt(i))){
                count ++;
            }
        }
        return count ;
    }

    /**
     * Given array arr1 and ArrayList arr2, count the number of elements in arr1
     * that occur arr2
     *
     * @param arr1	an array of elements
     * @param arr2	an ArrayList of elements
     *
     * @return	the number of elements in arr1 that occur in arr2
     */
    public static int inArrayList(int[] arr1, ArrayList<Integer> arr2) {
        int count = 0;
        for(int i = 0; i < arr1.length; i++) {
            if (arr2.contains(arr1[i])){
                count++;
            }
        }
        return count;
    }

    /**
     * Mutate an ArrayList of Strings such that the value at
     * index a is replaced with the value at index b and vice versa.
     * Do nothing if either index is invalid.
     *
     * @param swapList the list to be mutated
     * @param a	an integer index
     * @param b	an integer index
     *
     */
    public static void swapElements(ArrayList<String> swapList, int a, int b) {
        throw new UnsupportedOperationException(); //replace this line!!
    }

    /**
     * Return a HashMap that includes unique elements in an array
     * as keys and the number of times they occur in the
     * array as the value.
     *
     * @param arr1	an array of elements
     *
     * @return a hashmap that shows frequency count of elements in given array
     */
    public static HashMap<Integer, Integer> countOccurences(int[] arr1) {
        HashMap<Integer, Integer> h = new HashMap<>();
        for(int i = 0; i < arr1.length; i++){
            if (h.containsKey(arr1[i])) {
                h.put(arr1[i],h.get(arr1[i]) + 1);
            }
            else{
                h.put(arr1[i],1);
            }
        }
        return h;
    }

    /**
     * Main method
     *
     * @param args	method arguments, if any
     */
    public static void main(String[] args) {

        try {
            System.out.println(asteriskUp("hell8o"));
        }  catch (Exception e) {
            System.out.println("You have to implement the asteriskUp method!");
            System.exit(1); //0 indicates no error, 1 indicates something went awry
        }

        try {
            System.out.println(countCharacters("Pizza", "Pepperoni"));
        }  catch (Exception e) {
            System.out.println("You have to implement the countCharacters method!");
            System.exit(1); //0 indicates no error, 1 indicates something went awry
        }
        try {
            System.out.println(addOdds(8));
        }  catch (Exception e) {
            System.out.println("You have to implement the addOdds method!");
            System.exit(1); //0 indicates no error, 1 indicates something went awry
        }

        try {
            int[] arr1 = {4, 5, 6, 8};
            ArrayList<Integer> arr2 = new ArrayList<Integer>(Arrays.asList(1, 2, 4, 5, 5, 5));
            System.out.println(inArrayList(arr1, arr2));
        }  catch (Exception e) {
            System.out.println("You have to implement the inArrayList method!");
            System.exit(1); //0 indicates no error, 1 indicates something went awry
        }

        try {
            int[] arr = {1, 2, 3, 4, 1, 1, 3, 3, 3, 5};
            System.out.println(countOccurences(arr));
        } catch (Exception e) {
            System.out.println("You have to implement the countOccurences method!");
            System.exit(1); //0 indicates no error, 1 indicates something went awry
        }

    }

}
