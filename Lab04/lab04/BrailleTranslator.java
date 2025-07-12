package lab04;

import java.io.*;
import java.util.*;


/**
 * BrailleTranslator class.  A class to translate ASCII to Braille.
 **/
public class BrailleTranslator {

    /**
     * List containing a Braille Translation
     */
    List<List<String>> translation; 
    /**
     * Map to translate characters to Braille
     */
    Map<Character, List<String>> map;

    /**
     * Create a BrailleTranslator.
     */
    public BrailleTranslator() throws IOException {
        this.translation = new ArrayList<List<String>>();
        this.map = new HashMap<>();
        initializeMap();
    }

    /**
     * Print the translation
     *
     * @return String that includes entire translation stored in translation attribute
     */
    public String toString() {
        String retval = "";
        for (List<String> l: this.translation) {
            retval += l.get(0) + "\n" + l.get(1) + "\n" + l.get(2); //three rows for every one line
            retval += "\n";

        }
        return retval;
    }

    /**
     * Getter method for map.
     *
     * @return the map used for translation
     */
    public Map<Character, List<String>> getMap() {
        return this.map;
    }


    /**
     * Initialize a map to turn ASCII characters into Braille letters.
     * Read in the file "dictionary.txt" and use it to initialize 
     * the map attribute.  This will be used to translate each ASCII
     * character to a list of strings (e.g. a -> {"10", "00", "00"})
     *
     * @throws IOException if file cannot be accessed
     */
    private void initializeMap() throws IOException {
        String filename = "dictionary.txt";
        String line = "";

        try {
            String[] record;
            File myObj = new File(filename);
            Scanner myReader = new Scanner(myObj);
            while(myReader.hasNextLine()){
                String temp = myReader.nextLine();

                char str = temp.charAt(1);
                String str2 = temp.substring(4);
                record = str2.split(", ");


                map.put(str, List.of(record));

            }
            myReader.close();
        } catch (IOException e) {
            System.out.println("IO Exception: " + e.getMessage());
            System.exit(1); //something went awry!
        }
    }



    /**
     * Translate an ASCII line to a line of Braille.
     * To translate a line, iterate over the line and translate each character.
     * Then, concatenate translated characters to form lines of Braille as List<String> objects.
     * (e.g. The string "ab" should result in -> {"1010", "0010", "0000"}.
     * This corresponds to character a ->  {"10", "00", "00"} concatenated with b ->  {"10", "10", "00"}).
     * Store each line in this.translation (which is a List of List<String> objects).
     *
     * @param input: the ASCII line of text to be translated.
     */
    public void translateLine(String input) throws BrailleLetterException {

        String s = input.toLowerCase();
        String str1 = new String();
        String str2 = new String();
        String str3 = new String();
        for(int i = 0; i < s.length(); i++) {
            List<String> store = Arrays.asList("", "", "");
            if (Character.isAlphabetic(s.charAt(i)) || (int) s.charAt(i) == 32 || (int) s.charAt(i) == 46) {
                str1 += translateChar(s.charAt(i)).get(0);
                str2 += translateChar(s.charAt(i)).get(1);
                str3 += translateChar(s.charAt(i)).get(2);
                store.set(0, str1);
                store.set(1, str2);
                store.set(2, str3);
                if ((int) s.charAt(i) == 46 || i == s.length() - 1) {
                    str1 = new String();
                    str2 = new String();
                    str3 = new String();
                    this.translation.add(store);
                }
            } else {
                translation = new ArrayList<List<String>>();
                throw new BrailleLetterException("BrailleLetterException");
            }
        }

    }


    /**
     * Translate an ASCII character to a single Braille letter with positions as follows
     *      0 3
     *      1 4
     *      2 5
     *
     * Each position should contain a zero or a one.
     *
     * @param c: the ASCII character to be translated.
     * @return a Braille character translation
     */
    public List<String> translateChar(char c){

        return getMap().get(c);

    }
}
