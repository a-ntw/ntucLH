/*
    Count characters/words in a String - wordCount
    Count a specific word/character in a String - search 
    Compare to Strings - comparision case Sensitive
    Compare to Strings [ignore Case] - 
    Search for an occurance word & character in a String - first position 
    Remove a single character/word from a string - search and remove
    Replace a single character/word from a string - replace first 
    Replace all occurance character/word from a string - replace all
    Reverse a string - kiv
    Find if a string is palindrome
    Fetch a specific number of characters or words from the beginning/middle and
        end of a string -  kiv
    find a sub string - kiv
    swap strings between variables - kiv
    alter case upper to lower or mix n match - kiv

https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/lang/String.html
https://www.w3schools.com/java/java_ref_string.asp
 */

/**
 * Dated: Oct 07, 2020
 * @author antw
 */
//import java.util.Scanner;  // Import the Scanner class

public class aboutString {

    static String priStr = "She sells sea-shells on the sea-shore.";
    static String nexStr = "She sells sea-shells on The sea-shore.";
    static String WordArray[];
    static String disVal = "";
    static String inputStr = "sea"; // Input string to search
    static String replaceStr = "snail"; // replacement word
    static String palinStr = "racEr"; // replacement word

    static {
    }

    public static void main(String args[]) {

        System.out.printf("\n## First sentence: " + priStr + "\n");
        System.out.printf("## Second Second:  " + nexStr + "\n");
        System.out.printf("## Search word:    " + inputStr + "\n");
        
        System.out.printf("\n## Totals words counts: ");
        WordArray = splitStr(priStr);
        System.out.println(WordArray.length); // words count

        countCha(WordArray);
        CompareWords(priStr, nexStr);
        compareIgnoreCase(priStr, nexStr);
        findingPosi(priStr, inputStr);
        replaceStrFirst(priStr, inputStr);
        removeWord(priStr, inputStr);
        replaceStr(priStr, inputStr);
        palindrome(palinStr);
    }

    // Count characters/words in a String
    public static void palindrome(String palinStr) {
        //Scanner myObj = new Scanner(System.in);  // Create a Scanner object
        //System.out.print("Input word to check if palindrome: ");
        //String inputStr = myObj.nextLine();  // Read user input
        System.out.print("## Is " + palinStr + " a palindrome word? ");
        String myStr = palinStr.toLowerCase();
        int index = myStr.length() - 1;
        for (int i = 0; i < myStr.length(); i++) {
            if (myStr.charAt(i) != myStr.charAt(index - i)) {
                System.out.println("FALSE!\n");
                break;
            } else {
                System.out.println("TRUE!\n");
                break;
            }
        }
    }

    // replace first single character/word from a string - search and remove
    public static void replaceStrFirst(String priStr, String inputStr) {
        String myStr = priStr;
        String temp = replaceStr;
        System.out.println("## REPLACE a single character/word from a string \n"
                + myStr.replaceFirst(inputStr, temp) + "\n");
    }
    // replace ALL single character/word from a string - search and remove
    public static void replaceStr(String priStr, String inputStr) {
        //String myStr = priStr;
        String temp = replaceStr;
        System.out.println("## REPLACE ALL single character/word from a string \n"
                + priStr.replaceAll(inputStr, temp) + "\n");
    }
    // Remove all single character/word from a string - search and remove
    public static void removeWord(String priStr, String inputStr) {
        String temp = "";
        System.out.println("## REMOVE ALL single character/word from a string \n"
                + priStr.replaceAll(inputStr, temp) + "\n");
    }

    // Finding position of a Character in a String
    public static void findingPosi(String priS, String secS) {
        String myStr = priStr;
        if (priS.contains(inputStr)) {
            int posNum = priS.indexOf(secS);
            System.out.println("## Position of '" + secS + "' at "
                    + posNum + "th chars.\n");
        } else {
            System.out.println("Invalid word to search.\n");
        }
    }

    // Compare between two arrays, WordArray, nextArray.
    public static void CompareWords(String inStr, String nextStr) {
        System.out.println("## COMPARE words with: \nPrimary:   " + inStr
                + "\nSecondary: " + nextStr);
        if (inStr.compareTo(nextStr) != 0) {
            System.out.println("Two sentences are NOT the same.\n");
        } else {
            System.out.println("Yes! Both sentences are the same.\n");
        }

        /*String diffResult = "result:    ";
        String nextArray[];
        nextArray = splitStr(nextStr);

        for (int i = 0; i < WordArray.length; i++) {
            if (WordArray[i].equals(nextArray[i])) {
                diffResult += nextArray[i] + " ";
            } else {
                diffResult += "<" + nextArray[i] + "> ";
            }
        }
        System.out.println(diffResult + "\n"); */
    }

    // Compare between two sentences, Case ignore
    public static void compareIgnoreCase(String inStr, String nextStr) {
        System.out.println("## COMPARE case insensitive: " + "\nSecondary: " + nextStr);
        if (inStr.compareToIgnoreCase(nextStr) != 0) {
            System.out.println("Two sentences are NOT the same.\n");
        } else {
            System.out.println("Yes! Both sentences having the same words!\n");
        }

        /*String diffResult = "result:    ";
        String nextArray[];
        nextArray = splitStr(nextStr);

        for (int i = 0; i < WordArray.length; i++) {
            String lowerWord = WordArray[i].toLowerCase();
            String lowerNext = nextArray[i].toLowerCase();

            if (lowerWord.equals(lowerNext)) {
                diffResult += nextArray[i] + " ";
            } else {
                diffResult += "<" + nextArray[i] + "> ";
            }
        }
        System.out.println(diffResult + "\n"); */
    }

    // Count total characters of String ignore space
    public static void countCha(String[] inWord) {
        int cCount = 0;
        for (String arg : inWord) {
            cCount += arg.length();
        }
        System.out.println("## Total count of char exclusing space: " + cCount + "\n");
    }

    // split string to array by space
    public static String[] splitStr(String inStr) {
        String args[] = inStr.split(" ");
        return args;
    }

    // convert to LOWER CASE
    public static void lowerCase(String inStr) {
        System.out.println("## Convert to lowercase: "
                + inStr.toLowerCase());
    }

    // Count characters/words in a String
    public static void Count(String inStr) {

    }
}

/* 
She sells sea-shells on the sea-shore.
The shells she sells are sea-shells, I'm sure.
For if she sells sea-shells on the sea-shore
Then I'm sure she sells sea-shore shells. */
