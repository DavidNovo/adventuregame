package net.novogrodsky.javamasterclass.adventuregame;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class AdventureGame {

  private static Locations locations = new Locations();

  public static void main(String[] args) {
    // Change the program to allow players to type full words, or phrases, then move to the
    // correct location based upon their input.
    // The player should be able to type commands such as "Go West", "run South", or just "East"
    // and the program will move to the appropriate location if there is one.  As at present, an
    // attempt to move in an invalid direction should print a message and remain in the same place.
    //
    // Single letter commands (N, W, S, E, Q) should still be available.

    //its time for a challenge and a challenge is to rewrite
    // the static initialization block the you can see on screen
    // now using the try with resources that we've talked about
    // and discussed in this section instead of the try finally
    // code that we got in here in place now so pause the
    // video and go away and convert this static initialization
    // block into using try with resources
    Scanner scanner = new Scanner(System.in);

    Map<String, String> vocabulary = new HashMap<String, String>();
    vocabulary.put("QUIT", "Q");
    vocabulary.put("NORTH", "N");
    vocabulary.put("SOUTH", "S");
    vocabulary.put("WEST", "W");
    vocabulary.put("EAST", "E");
    vocabulary.put("UP", "U");
    vocabulary.put("DOWN", "D");

    int loc = 64;
//        int loc = 1;
    while (true) {
      System.out.println(locations.get(loc).getDescription());

      if (loc == 0) {
        break;
      }

      Map<String, Integer> exits = locations.get(loc).getExits();
      System.out.print("Available exits are ");
      for (String exit : exits.keySet()) {
        System.out.print(exit + ", ");
      }
      System.out.println();

      String direction = scanner.nextLine().toUpperCase();
      if (direction.length() > 1) {
        String[] words = direction.split(" ");
        for (String word : words) {
          if (vocabulary.containsKey(word)) {
            direction = vocabulary.get(word);
            break;
          }
        }
      }

      if (exits.containsKey(direction)) {
        loc = exits.get(direction);

      } else {
        System.out.println("You cannot go in that direction");
      }
    }

  }
}
