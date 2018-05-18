////////////////////////////////////////////////////////////////////////////
//
// Nathaniel McDonald
// April 15, 2016
//
////////////////////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//
//  DESCRIPTION: This program calculates the number of grains of rice placed on k squares of a chessboard if one grain
//               is placed on the first square and then each successive square has twice as much rice as the previous
//               square.
//
// INPUTS:  Number of squares to calculate.
//
//
// OUTPUTS:  The total grains on k squares.
//
//
///////////////////////////////////////////////////////////////////////////////////////////////////////////////////

import java.util.*;

public class CountRiceGrains
{

  private static final int grains = 1;
  private static int squares;

  //Prompts the user to enter a number of sqares
  public void writeOutput()
   {
    Scanner keyboard = new Scanner(System.in);
    System.out.println("One grain of rice is placed on the first square of a chess board,\n"
                     + "then it is doubled and 2 grains of rice are placed on the second square,\n"
                     + "then it is doubled again and 4 grains are placed on the third square,\n"
                     + "this pattern is repeated for all squares, 64 in total.");
    System.out.println("Please enter the number of squares to compute the total grains for:");
    squares = keyboard.nextInt();
    //Limits the user input for squares to a value between 1 and 64
    do
    {
     if(squares < 1 || squares > 64)
      {
        System.out.println("Error, the number of squares must be between 1 and 64");
        squares = keyboard.nextInt();
      }
    else
      System.out.println("The number of grains on " + squares + " squares is:");
     }
    while(squares < 1 || squares > 64);
   }

  //Recursively adds the grains on each square to return a sum of k squares, entered by the user.
   public double getTotalGrains(double k,double g)
   {
    if(k==1)
      return grains;
    else
       return (getTotalGrains(k-1,g*2) + g*2);
    }

   public static void main(String[] args)
    {
     Scanner keyboard = new Scanner(System.in);
     char playAgain = 'n';
     do
     {
      CountRiceGrains newRice= new CountRiceGrains();
      newRice.writeOutput();
      System.out.println(newRice.getTotalGrains(squares, grains));
      System.out.println("Would you like to calculate another number of squares? Enter y for yes, any other key for no.");
      playAgain = keyboard.next().charAt(0);
     }
     while(playAgain == 'y' || playAgain == 'Y');
     }
}
