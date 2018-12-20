
import java.util.Arrays;
import java.util.Random;

/* **********************************************************
* Programmer:       Erika Tvaskis
* Class:            CS40S
* Assignment 2:     Searching and Sorting
* Description:      Create object ArrayFunctions
                    Generate and print list 
* *************************************************************
*/

public class ArrayFunctions 
    { //Begin class
    
//VARIABLES
public static final String ANSI_RED = "\u001B[31m";
public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";    
public final int MAXRAND = 10000;

Random r = new Random();
int[] list;
int actualLength;    
int MAX;
int Counter = 0;
    
//CONSTRUCTORS 

/******************************************************
Purpose: Creates initialized constructor
In: None
Out: None
/******************************************************/ 
public ArrayFunctions(){
    MAX = 0;
    this.list = new int[MAX];
    this.actualLength = list.length; 
} //End initialized constructor

/******************************************************
Purpose: Initializing MAX
In: MAX (integer)
Out: None
/******************************************************/ 
public ArrayFunctions(int MAX) {
    this.MAX = 1000;
} //End of ArrayFunctions(int MAX)

/******************************************************
Purpose: Loading list (generating array with random integers)
In: list (array of integers)
Out: i (integer)
/******************************************************/ 
public int loadList(int[] list) {
    System.out.println(ANSI_WHITE_BACKGROUND + ANSI_RED + "Unsorted List");
    int i = 0;
    int RandomNumber = 0;
    for(i = 0; i < MAX;i++) {               
        RandomNumber = r.nextInt(MAXRAND);
        list[i] = RandomNumber;
        Counter = 1;
    } //End for loop  
    return i;
} //End loadList

/******************************************************
Purpose: Prints the list
In: array list (integer), and length of array (integer)
Out: ListPrint (String) 
/******************************************************/ 
public String printList(int[] list, int actualLength) {
    String ListPrint = Arrays.toString(list);
    System.out.println(ListPrint);
    return ListPrint;
} //End String printList
   
} //Closing bracket for ArrayFunctions
