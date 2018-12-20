/********************************************************************
 * Programmer:	sveinson
 * Class:  CS20S
 * Assignment: Client code for searching and sorting classes
 * Program Name:  SandSClient
 * Description: driver code used to implement various sorting and searching objects
 * Input: an array, unsorted, varying types and sizes
 * Output: unsorted and sorted lists
 ***********************************************************************/
 
 // import java libraries here as needed
 
import java.text.DecimalFormat;
import java.util.Random;
import javax.swing.*;

public class SandSClient {  // begin class
    
    public static void main(String[] args) {  // begin main
    
    // ********* declaration of constants **********
        
        final int MAX = 1000;        // max size of test array
    
    // ********** declaration of variables **********

        String strin;				// string data input from keyboard
        String strout;				// processed info string to be output
        String bannerOut;			// string to print banner to message dialogs

        String prompt;				// prompt for use in input dialogs

        String delim = "[ :]+";		// delimiter string for splitting input string
        String tabSpace = "      ";	// six spaces
        
        int[] list = new int[MAX];          // TEST ARRAY
        int actualLength = 0;
        
        int key = 0;                // search key
        int searchIndex = 0;        // index of key if found in list


    // **************** create objects **********************

        ProgramInfo programInfo = new ProgramInfo();
        ArrayFunctions  arrayFunctions = new ArrayFunctions(MAX);
        Random rnd = new Random();
    	
    // ********** Print output Banner **********
    
        System.out.println(programInfo.getBanner("A2 Search and Sort"));
    	
    // ************************ get input **********************

    // ************************ processing ***************************
  
        Sorter s = new Sorter();

        actualLength = arrayFunctions.loadList(list); 
        arrayFunctions.printList(list, actualLength);

        //bubble sort
        s.bubbleSort(list, actualLength);
        arrayFunctions.printList(list, actualLength); 
       
        //quick sort
        actualLength = arrayFunctions.loadList(list);
        arrayFunctions.printList(list, actualLength);
        s.quickSort(list, 0, list.length - 1);
        arrayFunctions.printList(list, actualLength);

	//selection sort
        actualLength = arrayFunctions.loadList(list);
        arrayFunctions.printList(list, actualLength);
        s.selectionSort(list, actualLength);
        arrayFunctions.printList(list, actualLength);
        actualLength = arrayFunctions.loadList(list);
        arrayFunctions.printList(list, actualLength);

        //radix sort! (I added this)
        s.radixSort(list);
        arrayFunctions.printList(list, actualLength);
        
        // ************** searchin **********************
        
        Searcher searcher = new Searcher();
        
        actualLength = arrayFunctions.loadList(list);
        arrayFunctions.printList(list, actualLength); 
        //(I added this so it can print the newly generated list)
        key = rnd.nextInt(10000);
        key++;
        searchIndex = searcher.linearSearch(list, actualLength, key);
        s.quickSort(list, 0, list.length - 1);
        arrayFunctions.printList(list, actualLength); 
        //(I added this so it can print the newly sorted list)
        searchIndex = searcher.linearSearch(list, actualLength, key);
        searchIndex = searcher.binarySearch(list, actualLength, key);
       

    // ************************ print output ****************************
    
    
        // ******** closing message *********
        
        System.out.println(programInfo.getClosingMessage());
    }  // end main
    

}  // end class
