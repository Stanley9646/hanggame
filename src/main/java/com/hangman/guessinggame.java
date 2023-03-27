package com.hangman;

import java.util.Random;

public class guessinggame {
    private  static String[] words ={"Toyota","Honda","Ford","Chevrolet", "Nissan", "BMW", "Mercedes-Benz", "Audi", "Lexus", "Tesla" };
    private  static Random random = new Random();
    private  static  int index = random.nextInt(words.length);
    private  static  String randomWord = words[index];
    public static void main  (String[]args){
        System.out.println("Welcome to the hangman game");
        System.out.println("Guess the word by suggesting letters ");

        String guessedWord = generateGuessedWord(randomWord);
        System.out.println("The wor to guess is : " + guessedWord);

        int numberOfTries =0;
        while (numberOfTries < 6){
            System.out.println("Enter a letter : ");
            char guess = new java.util.Scanner(System.in).next().charAt(0);
            if (randomWord.indexOf(guess) == -1 ){
                numberOfTries++;
                System.out.print("Incorrect ! You have " + (6-numberOfTries) + "TRIES LEFT" );

            }else {
                guessedWord = updateGuessedWord(randomWord , guessedWord ,guess);
                System.out.println("Correct looks like " + guessedWord );
                if ( guessedWord.equals(randomWord)){
                    System.out.println("Congrats !!!! You wonnn");
                    return;
                }
            }
        }
        System.out.println("The word was : " + randomWord);

    }
    private static String generateGuessedWord(String word) {
        return new String(new char[word.length()]).replace("\0", "-");
    }

    private static String updateGuessedWord(String word, String guessedWord, char guess) {
        char[] guessedWordChars = guessedWord.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == guess) {
                guessedWordChars[i] = guess;
            }
        }
        return new String(guessedWordChars);
    }
}
