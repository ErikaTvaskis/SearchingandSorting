
import java.util.Scanner;

/* **********************************************************
* Programmer:       Erika Tvaskis
* Class:            CS40S
* Assignment 2:     Searching and Sorting
* Description:      Create object Searcher
                    Searches list using differen methods
* *************************************************************
*/ 

public class Searcher 
    { //Begin class
    
//VARIABLES 
public static final String ANSI_GREEN = "\u001B[32m";
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m"; 
public Scanner Scanner = new Scanner(System.in);   
 
//CONSTRUCTORS

/******************************************************
Purpose: Creates default constructor
In: None
Out: Prints message
/******************************************************/ 
public Searcher() {
    System.out.println();
    System.out.println("Searcher object has been created.");
} //End default constructor    
    
/******************************************************
Purpose: Searches list for key using linear search method
In: list (array of integers), arraylength (integer), key (integer)
Out: i (integer) or -1
/******************************************************/ 
public int linearSearch(int[] list, int arraylength, int key) {
    System.out.println(ANSI_WHITE_BACKGROUND + ANSI_GREEN + "Linear Search");
    System.out.println("Generated: " + key); 
    for (int i = 0; i < arraylength; i++) { 
        if (list[i] == key) {
            System.out.println("Position: " + i);
            return i; 
        } //Close if statement
    } //Close for loop
    System.out.println("Position: -1 (NOT FOUND)");
    return -1; 
} //End linearSearch

/******************************************************
Purpose: Searches list for key using binary search method
In: list (array of integers), high (integer), key (integer)
Out: index (integer)
/******************************************************/ 
 public int binarySearch(int[] sortedlist, int high, int key) {
    int index = -1;
    int Counter1 = 0;
    int Counter2 = 0;
    int low = 0;
    while (low <= high && Counter2 == 0) {
        int mid = (low + high) / 2;
        //Determing middle value of array
        if (sortedlist[mid] < key) {
            low = mid + 1;
        } 
        else if (sortedlist[mid] > key) {
            high = mid - 1;
        } 
        else if (sortedlist[mid] == key) {
            index = mid; 
            //DEALING WITH REPEATING VALUES...
            //IF THE MIDDLE VALUE = KEY, BUT WHAT IF KEY APPEARS BEFORE MIDDLE VALUE
            while (index - 1 >= 0 && Counter1 == 0) {       
                if (sortedlist[index-1] == key) {
                    index = index - 1;
                } //End if statemenet
                else {
                    Counter1 = -1;
                } //End else statement
            } //End of while loop 
            
        //break; since you don't like breaks, made counter :)
        Counter2 = -1;    
        } //End else if
    } //End while loop
    System.out.println(ANSI_WHITE_BACKGROUND + ANSI_GREEN + "Binary Search");
    System.out.println("Generated: " + key); 
    if (index == -1) {
        System.out.println("Position: "+ index + " (NOT FOUND)" ); 
    } //End if
    else {
        System.out.println("Position: "+ index ); 
    } //End else
    return index;
} //End binarySearch

} //Closing bracket for Searcher
