package Hangman;

import java.util.*;

public class HangMan{
    private static String[] dictionary = {"HELLO", "SARAH", "SAHIL", "OCYRUS", "WILL", "FISERV", "CODING", "JAVA", "ALGORITHM", "MOTORCYCLE", "TOYOTA"};
    //private static String[] dictionary = {"HELLO"};
    static Scanner input = new Scanner(System.in);
    public static void play()
    {  
        //generates random word  
        Random random = new Random();
        String word = dictionary[random.nextInt(dictionary.length)];
        word = word.toUpperCase();
         String wordExample = word.replaceAll("[A-Z]", "_");
         System.out.println("Welcome to Hangman!");
        Hashtable<Character, Integer> lettersInWord = new Hashtable<Character, Integer>();
        for(char c: word.toCharArray()){
            lettersInWord.put(c,1);
        }
        Hashtable<Character, Integer> guessedLetters = new Hashtable<Character, Integer>();
        int guess = 5;
        char letter;        
        while (guess > 0)
        {
            for(char c: word.toCharArray()){
                if(guessedLetters.containsKey(c)){
                    System.out.print(c);
                }
                else{
                    System.out.print("_");
                }
            }
            System.out.println();
            System.out.println("Enter a character:");
            letter = Character.toUpperCase(input.nextLine().trim().charAt(0));
            if(guessedLetters.containsKey(letter)){
                System.out.println("You already guessed this");
                continue;
            }
            else if(lettersInWord.containsKey(letter)){
                System.out.println(letter + " is present in the word.");
                guessedLetters.put(letter,1);
                if(guessedLetters.keySet().size()==lettersInWord.keySet().size()){
                    
                    break;
                }
            }
            else{
                System.out.println(letter + " is not in the word.");
                guess--;
                System.out.println(guess+" guesses remaining.");
            }
        }
        
        if (guess == 0)
        {
            System.out.println("You Lost! Guess limit reached.");
            
        }
        else
        {
            System.out.println("You won!");
        }        
        System.out.println("The word is "+ word);
    }

    public static void main(String[] args){
        
        play();
    }
}