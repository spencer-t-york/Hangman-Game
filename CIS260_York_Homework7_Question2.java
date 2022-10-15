/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package csu.cis260_york_homework7_question2;

//imports
import java.io.*;
import java.net.*;
import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author spenceryork
 */
public class CIS260_York_Homework7_Question2 {

    public static void main(String[] args) throws Exception {
        System.out.println("");                 // Spacing for terminal visibility

        // ------------------------------------------- RANDOM WORD GENERATOR ------------------------------------------- //
        String[] words = new String[6801];

        // Create Word List
        URL text = new URL("http://www.desiquintans.com/downloads/nounlist/nounlist.txt");
        BufferedReader in = new BufferedReader(
                new InputStreamReader(text.openStream()));

        String inputLine;
        for (int i = 0; (inputLine = in.readLine()) != null; i++) {
            words[i] = inputLine;
        }
        in.close();

        // Choose word from list
        Random random = new Random();
        int i = random.nextInt(words.length);
        String word = words[i];
        System.out.println(word);

        // VARIABLE | String word | IS THE RETURN VARIABLE

        // SPLIT WORDS INTO CHARCTERS (using an array and charAt())
        String[] splitWord = new String[word.length()];

        for (i = 0; i < word.length(); i++) 
        {
            splitWord[i] = Character.toString(word.charAt(i));
        }
        System.out.println("");                 //Spacing for terminal visibility

        
        // ------------------------------------------- HIDE WORD FROM USER ------------------------------------------- //
        // Use asteriks
        String[] coveredSplitWord = new String[word.length()];

        for (i = 0; i < word.length(); i++) 
        {
            coveredSplitWord[i] = Character.toString(word.charAt(i));
            coveredSplitWord[i] = "*";
            System.out.print(coveredSplitWord[i]);
        }
        System.out.println("");

        // ------------------------------------------- USER PROMPTS ------------------------------------------- //

        int counter = 0;
        
        // scanner
        Scanner input = new Scanner(System.in);

        // loop
        while(true)
        {
            // USER PROMPT
            System.out.print("\nGuess a letter in the word: ");
            String userInput = input.next();

            if (Arrays.asList(coveredSplitWord).contains(userInput)) {
                // TODO logo and continue if true
                System.out.print("Word already guessed correctly");
                continue;
            }

            if (!word.contains(userInput)) {
                
                counter++;
                System.out.print(userInput + " is not in the word.");
            }
            System.out.println(coveredSplitWord);

            // nested Loop
            for (int j = 0; j < word.length(); j++) 
            {
                // if guess is correct
                if (Objects.equals(userInput, splitWord[j]))
                {
                    // uncover letter
                    coveredSplitWord[j] = userInput;
                }
            }

            if (!Arrays.asList(coveredSplitWord).contains("*")) {
                System.out.println("\n\nYou guessed the word!\n Y/N");
                break;  
            }
        }
    }
}
/*
 * 
 * Each letter in the word is displayed as an asterisk. When the user makes a
 * correct guess, the actual letter is then displayed.
 * When the user finishes a word, display the number of misses and ask the user
 * whether to continue to play with another word.
 * Declare an array to store words, as follows:
 * 
 * // Add any words you wish in this array
 * String[] words = {“write”, “that”, ...};
 * 
 * |–—–———————————————————————–————————————————————————––—–|
 * |    (Guess) Enter a letter in word ******* > p         |
 * |    (Guess) Enter a letter in word p****** > r         |
 * |    (Guess) Enter a letter in word pr**r** > p         |
 * |        p is already in the word                       |
 * |    (Guess) Enter a letter in word pr**r** > o         |
 * |    (Guess) Enter a letter in word pro*r** > g         |
 * |    (Guess) Enter a letter in word progr** > n         |
 * |        n is not in the word                           |
 * |    (Guess) Enter a letter in word progr** > m         |
 * |    (Guess) Enter a letter in word progr*m > a         |
 * |    The word is program. You missed 1 time             |
 * |    Do you want to guess another word? Enter y or n    |
 * |–———————————————————————————————————————————————–––––––|
 */

// Just in case...
 /*
  *        Scanner input = new Scanner(System.in);

        for (i = 0; i < word.length(); i++)
        {
            System.out.print("\nGuess a letter in the word: ");
            String userInput = input.next();

            for (int j = 0; j < word.length(); j++) 
            {
                if (!Objects.equals(userInput, splitWord[j])) 
                {
                    wrongGuess++;
                }
                else
                {
                    for (int k = 0; k < word.length(); k++) 
                    {
                        if (Objects.equals(userInput, splitWord[k]))
                        {
                            coveredSplitWord[k] = userInput;
                        }
                    }
                }
                System.out.print(coveredSplitWord[j]);
            }
        }
        System.out.println("");
    }
}
  */