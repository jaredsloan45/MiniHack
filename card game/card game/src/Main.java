import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        BlackJack b= new BlackJack();
        Spoons s= new Spoons();
        boolean quit = false;

        while (!quit) {
            System.out.println("Hello! What game do you want to play today? \n 1. Black Jack 2. Spoons \t type in number or 'quit' to quit: ");
            Scanner input = new Scanner(System.in);
            String response = input.next();
            if (response.compareToIgnoreCase("1") == 0) {
                b.Game();
            } else if (response.compareToIgnoreCase("2") == 0) {
                s.game();
            } else {
                quit = true;
            }
        }
    }

}
