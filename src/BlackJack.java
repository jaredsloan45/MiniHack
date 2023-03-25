import java.util.Scanner;

public class BlackJack {
    int dealerScore = 0;
    int playerScore = 0;

    public BlackJack(){

    }
    public static int updateScore(Card c){
        int r = 0;
        if(c.getValue()>10){
            r = 10;
        } else if (c.getValue()==1) {
            r =11;
        }
        else{
            r = c.getValue();
        }
        return r;
    }
    public void Game() throws InterruptedException {
        System.out.println("Welcome to BlackJack!");
        Deck d = new Deck();
        d.shuffle();
        LinkedStack<Card> cards = new LinkedStack<>();
        for (int i = 0; i < 52; i++) {
            cards.push(d.getCard(i));
        }

        int dealerscore = 0;
        int playerscore = 0;
        int playeraces = 0;
        int dealeraces = 0;
        Card dealer1 = cards.pop();
        System.out.println("Dealer's face up card is " + dealer1);
        dealerscore += updateScore(dealer1);
        if(dealer1.getValue==11){
            dealeraces+= 1;
        }
        System.out.println("Dealer's score is: " + dealerscore);
        Card P1 = cards.pop();
        Card P2 = cards.pop();
        if(P1.getValue ==11){
            playeraces+=1;
        }
        if(P2.getValue ==11){
            playeraces+=1;
        }
        System.out.println("Your cards are " + P1 + " and " + P2);
        playerscore += (updateScore(P1) + updateScore(P2));
        System.out.println("Your score is: " + playerscore);

        //While loop for player
        while (playerscore <= 21) {
            System.out.println("Would you like another card?");
            System.out.println("Yes or no");
            Scanner input = new Scanner(System.in);
            String response = input.next();
            if (response.compareToIgnoreCase("yes") == 0) {
                Card P = cards.pop();
                if(P.getValue ==11){
                    playeraces+=1;
                }
                System.out.println("Your card is " + P);
                if(playerscore + updateScore(P)>21){
                    playerscore -= 10*playeraces
                    playeraces = 0
                }
                playerscore += updateScore(P);
                System.out.println("Your score is: " + playerscore);
            } else if (response.compareToIgnoreCase("no") == 0) {
                break;
            } else {
                System.out.println("That is an invalid argument");
            }
        }

        if (playerscore > 21) {
            System.out.println("Oh no! You went bust!");
            System.out.println("Would you like to play again?");
            System.out.println("Yes or no");
            Scanner input = new Scanner(System.in);
            String response = input.next();
            if (response.compareToIgnoreCase("yes") == 0) {
                String[] n = null;
                Game();
            } else {
                System.exit(1);
            }
        } else {
            System.out.println("Your score is: " + playerscore);
            System.out.println("Now it's the dealer's turn");
        }
        //While loop for dealer
        while (dealerscore < playerscore) {
            Card P = cards.pop();
            if(P.getValue ==11){
                dealeraces+=1;
            }
            System.out.println("The dealer's card is: " + P);
            if(dealerscore + updateScore(P)>21){
                dealerscore -= 10*dealeraces
                dealeraces = 0
            }
            dealerscore += updateScore(P);
            System.out.println("The dealer's score is " + dealerscore);
            System.out.println("...");
            Thread.sleep(5000);
        }
        if (dealerscore <= 21) {
            System.out.println("Oh no! You lost!");
        } else {
            System.out.println("The dealer went bust, you win!");
        }
        System.out.println("Would you like to play again?");
        System.out.println("Yes or no");
        Scanner input = new Scanner(System.in);
        String response = input.next();
        if (response.compareToIgnoreCase("yes") == 0) {
            String[] n = null;
            Game();
        } else {
            System.exit(1);
        }

    }
}