import java.util.Scanner;

public class Spoons {


    public void game() throws InterruptedException{
        Deck d = new Deck();
        d.shuffle();
        LinkedStack<Card> cards = new LinkedStack<>();
        for (int i = 0; i < 52; i++) {
            cards.push(d.getCard(i));
        }
        Hand playerHand= new Hand();
        Hand computerHand = new Hand();
        System.out.println("Welcome to spoons!");

        for(int j=0; j < 4; j++){
            playerHand.addCard(cards.pop());
            computerHand.addCard(cards.pop());
        }

        while(!playerHand.sameVal() && !computerHand.sameVal()) {
            System.out.println("Your hand is: ");
            for (int i = 0; i < 4; i++) {
                System.out.println(i + ": " + playerHand.getCard(i));
            }
            System.out.println("Which card would you like to discard? \t Select a number 0-3:");
            Scanner input = new Scanner(System.in);
            int response = input.nextInt();
            playerHand.removeCard(response);
            playerHand.addCard(cards.pop());
            System.out.println("Your new hand is: \n" + playerHand.toString());

            System.out.println("Computer's turn ... ");
            computerHand.sortByValue();
            if(computerHand.getCard(0).getValue()==computerHand.getCard(1).getValue()){
                computerHand.removeCard(3);
                computerHand.addCard(cards.pop());
            } else {
                computerHand.removeCard(0);
                computerHand.addCard(cards.pop());
            }
            Thread.sleep(3000);
        }
        if(playerHand.sameVal()){
            System.out.println("Congrats! You win!\n Would you like to play again?");
        } else {
            System.out.println("Oh no! You lost! \n Would you like to play again?");
        }
        System.out.println("Yes or no");
        Scanner input = new Scanner(System.in);
        String response = input.next();
        if (response.compareToIgnoreCase("yes") == 0) {
            String[] n = null;
            game();
        } else {
            System.exit(1);
        }
    }
}
