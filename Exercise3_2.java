package CH03;

import java.util.Random;

public class Exercise3_2 {
    public static void main(String[] args) {
        int winCount = 0, loseCount = 0,
                point, diceOne, diceTwo, diceTotal;

        //Create random class
        Random random = new Random();

        //Loop for 10000 Games
        for (int loopCounter = 1; loopCounter <= 10000; loopCounter++){

            //6 sided dice one
            diceOne = random.nextInt(6) + 1;

            //6 sided dice two
            diceTwo = random.nextInt(6) + 1;

            //Total of both dices
            diceTotal = diceOne + diceTwo;

            //Come out roll for win
            if (diceTotal == 7 || diceTotal == 11)
                //Win Count Increase
                winCount++;

                //Come out roll for the lost
            else if (diceTotal == 2 || diceTotal == 3 || diceTotal == 12)
                //Lose Count Increase
                loseCount++;

                //Point
            else {
                // If 4, 5, 6, 8, 9, or 10 is rolled on the come out roll,
                // that number becomes “the point.”
                point = diceTotal;

                while (point != 7 && diceTotal != point){
                    diceOne = random.nextInt(6) + 1;
                    diceTwo = random.nextInt(6) + 1;
                    diceTotal = diceOne + diceTwo;

                    if (point == diceTotal) winCount++;
                    else if (diceTotal == 7) loseCount++;
                }
            }

        }
        //Probability of winning
        int probability = (winCount / (winCount + loseCount));
        System.out.println("Won: " + winCount);
        System.out.println("Lost: " + loseCount);
        
        if (winCount > loseCount) System.out.println("You Win");
        else System.out.println("The House Win's");

    }
}
