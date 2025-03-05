import java.util.ArrayList; 
import java.util.Scanner; 


  public class UserGiver {

    /*
     * ArrayLists that contain the adjectives and nouns.
     */
    
    private ArrayList<String> adjectives;
    private ArrayList<String> nouns;

    public UserGiver(ArrayList<String> adjectives, ArrayList<String> nouns) {
      
      this.adjectives = adjectives;
      this.nouns = nouns; 
      
    }
    
    public UserGiver() {
      
      adjectives = createUser("adjectives.txt");
      nouns = createUser("nouns.txt"); 
      
    }

     // Accesses the TextProcessor class
    public ArrayList<String> createUser(String fileName){
      
      TextProcessor tp = new TextProcessor(fileName);
      return tp.textToWords(); 
      
    }

    // Methods for UserGiver

    /* 
     * What's actually printed in the console. 
     */

    public void prompt() {
      Scanner input = new Scanner(System.in);

// Clears the screen, only showing the intial text.
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");
      System.out.println("\n");

      // Initial text
      System.out.println("Welcome to the User Maker! Do you want to get started? (Type anything)");
      String getStarted = input.nextLine(); 
      System.out.println("\n"); 
      
      // First input 
      System.out.println("What letter for the first word?");
      String userAdjLetter = input.nextLine();
      System.out.println("\n");

      // First output 
      System.out.println("What letter for the second word?");
      String userNounLetter = input.nextLine();
      System.out.println("\n");

      // Second input 
      String randAdj = chooseWord(userAdjLetter, adjectives);
      String randNoun = chooseWord(userNounLetter, nouns);
      System.out.println("\n");

      // Second output
      System.out.println("You chose " + userAdjLetter + ". Here is a random adjective:");
      System.out.println(randAdj);
      System.out.println("\n");
      System.out.println("You chose " + userNounLetter + ". Here is a random noun:");
      System.out.println(randNoun);
      System.out.println("\n");

     // Final outputs
      System.out.println("Are you ready to see your username? (Type anything)");
      String finalStep = input.nextLine();
      
      int randNumber = (int)(Math.random() * 999); 
      System.out.println("Here is your username together: " + randAdj + randNoun + randNumber); 

      String finalUser = randAdj + randNoun + randNumber; 
 
      System.out.println("Thank you for signing in " + finalUser + "!");
      
      input.close();
    }

    /**
     * Chooses a random word from an array list based on the first letter after inputting a letter. 
     * 
     * Precondition: A letter must be provided in order to proceed. 
     * Postcondition: The values inputted must be a letter and lowercase. 
     * 
     * @param letter 
     * @return Random word 
     */
    
     public String chooseWord(String letter, ArrayList<String> list) {
      ArrayList<String> possibleWords = new ArrayList<String>();
      
      for (int i = 0; i < list.size(); i++) {
        String word = list.get(i);
        
        if (word.substring(0, 1).equals(letter)) {
          possibleWords.add(word);
        }
      }

      int random = (int) (Math.random() * possibleWords.size());
      System.out.println(possibleWords.get(random));
      
      return possibleWords.get(random); 
    }

  }