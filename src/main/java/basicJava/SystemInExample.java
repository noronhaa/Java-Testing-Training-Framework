package basicJava;

import java.util.Scanner;

/**
 * Created by noronhaa on 16/08/15.
 */
public class SystemInExample {

    public static void main(String[] args){
        String answer = "praying mantice";
        int gueses = 1;
        System.out.println("Lets Play a game...");
        System.out.println("Clue number 1: Guess the animal im thinking of in 8 or less gueses, you will get a clue for each incorrect guess");
        System.out.println("Guess number 1");

        String questions[]= {"I am small","I am a predator", "I am green", "I am a bug", " I eat spiders amoungst other things", " I have a martial arts style names after me", "my name has 2 parts (2 words)", "first word of my name is what religious people do"};

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        gueses = 2;
        for (int i=0 ; i<8 ; i++) {


            if (gueses==9){
                System.out.println("you loose! I am a praying mantice!");
                break;
            }

            if (!input.toLowerCase().equals(answer)) {
                System.out.println("Incorrect answer");
                System.out.println("Clue number "+ String.valueOf(gueses) + ": " + questions[i]);
                System.out.println("Guess number " + gueses);
                input  = scanner.nextLine();
            } else {
                System.out.println("Congratulations you won!");
                System.out.println("you got the answer in "+ gueses +" guesses");
                if (gueses <4){
                    System.out.println("Thats Amazing!");
                } else if (4 < gueses && gueses < 7){
                    System.out.println("Thats Average :/");
                } else if (gueses > 6){
                    System.out.println("Thats pretty poor....");

                }

                break;
            }
            gueses++;
        }

    }


}
