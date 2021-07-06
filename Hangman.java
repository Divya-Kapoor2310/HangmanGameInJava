package hangmangame;


import java.util.ArrayList;
import java.util.Scanner;

public class Hangman {
    



 
 private static Scanner s;

 static public void guess (String word, int life) {
  
  char[] filler = new char [word.length()];
  int i = 0;
  while (i<word.length()) {
   filler[i] = '-';
   if(word.charAt(i) == ' ') {
    filler[i] = ' ';
   }
   i++;
  }
  System.out.print(filler);
  System.out.println("  life remaining=" +life);
  
  s = new Scanner (System.in);
  
  ArrayList<Character> l= new ArrayList<Character>();
  
  while(life>0) {
   char x=s.next().charAt(0); //read input from user
   
   if(l.contains(x)) {
    System.out.println("Already entered");
    continue; 
   }
   l.add(x);
   
   if(word.contains(x+"")) {
    for (int y=0; y<word.length();y++) { //iterating characters of word to be guessed
     if(word.charAt(y)==x) {   //if at y index in word, x is present
      filler[y]=x;     //write that word at y index in filler too
     }
    }
   }
   else {
    life--;  //if x is not in word,life decreases
   }
   
   if(word.equals(String.valueOf(filler))) { //if word==filler
    System.out.println(filler);
    System.out.println("You won the game!!");
    break; 
   }
   
   System.out.println(filler);
   System.out.println(" life remaining=" +life);
  }
  
  if(life == 0) {
   System.out.println("You lose the game!!");
  }
}  
 
 public static void main(String [] args) {
  String word = "welcome to hangman"; //word to be guessed
  int life = 5; //initialized with 5 lives
  guess(word, life);
 }
}
