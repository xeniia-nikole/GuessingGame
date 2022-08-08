package GuessingGame;

import java.util.Scanner;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static int min = 0;
    static int max = 0;
    public static void main(String[] args) {
        System.out.println("Welcome User!\n" +
                "Enter the minimum and maximum numbers separated by a space");
        String input = scanner.nextLine();
        String[] minAndMax = input.split(" ");
        min = Integer.parseInt(minAndMax[0]);
        max = Integer.parseInt(minAndMax[1]);
        int number;
        do {
            int randomNumber = (int) ((Math.random() * (max - min) + min) * Math.random()/2);
            System.out.printf("""
                    The system has up to a number, try to figure it out
                    Enter the expected number from %d to %d
                    """, min, max);
            int expectedNumber = scanner.nextInt();

            while (randomNumber != expectedNumber) {
                System.out.println("No, try again");
                if (randomNumber > expectedNumber){
                    if (randomNumber - expectedNumber < max/10) {
                        System.out.println("Hot");
                    } else if (randomNumber - expectedNumber < max/8) {
                        System.out.println("Warm");
                    }else if (randomNumber - expectedNumber < max/4) {
                        System.out.println("Cold");
                    }  else if (randomNumber - expectedNumber < max/2){
                        System.out.println("Very cold");
                    }
                } else {
                    if (expectedNumber - randomNumber < max/10) {
                        System.out.println("Hot");
                    } else if (expectedNumber - randomNumber < max/8) {
                        System.out.println("Warm");
                    } else if (expectedNumber - randomNumber < max/4) {
                        System.out.println("Cold");
                    } else if (expectedNumber - randomNumber < max/2){
                        System.out.println("Very cold");
                    }
                }
                expectedNumber = scanner.nextInt();
                if (expectedNumber < min || expectedNumber > max) {
                    System.out.println("You've entered incorrect number!");
                    break;
                }
            }
            System.out.println("Congratulations, you guessed the number correctly. Try again?\n" +
                    "Tap 0 to finish or any other number to continue");
            number = scanner.nextInt();
        } while (number != 0);
        System.out.println("Thanks for playing\nSee you");
    }
}