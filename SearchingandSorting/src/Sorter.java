
/* **********************************************************
* Programmer:       Erika Tvaskis
* Class:            CS40S
* Assignment 2:     Searching and Sorting
* Description:      Create object Sorter
                    Sorts list using different methods
* *************************************************************
*/ 

public class Sorter 
    { //Begin class
    
//VARIABLES 
public static final String ANSI_BLUE = "\u001B[34m";
public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";    
public static int Counter = 0; 
int[] list = new int[1000];
int actualLength = list.length;  

//CONSTRUCTORS

/******************************************************
Purpose: Creates default constructor
In: None
Out: Prints message
/******************************************************/ 
public Sorter() {
    System.out.println("Sorter object has been created.");
} //End default constructor

/******************************************************
Purpose: Sorts list using bubble sort method
In: list (array of integers), actualLength (integer)
Out: None
/******************************************************/ 
public void bubbleSort(int[] list, int actualLength) {
    System.out.println(ANSI_WHITE_BACKGROUND +ANSI_BLUE + "Bubble Sort");
    int Temporary = 0;
    for (int i = 0; i < actualLength; i++) {
        for (int j = 1; j < (actualLength - i); j++) {
            if (list[j - 1] > list[j]) {
                Temporary = list[j - 1];
                list[j - 1] = list[j];
                list[j] = Temporary;
            } //Close if
        } //End for j
    } //End for i
} //End bubbleSort

/******************************************************
Purpose: Sorting list using quick sort method (pivot and swapping values)
In: list (array of integers), low (integer), high (integer)
Out: i (integer)
/******************************************************/ 
public static int swappingTime(int[] list, int low , int high) {
    int pivot = high;
    int i = low;
    int j = high;
    while(i < j) {
        if(list[i] <= list[pivot]) {
            i++;
        } //End if list[i]<=list[pivot]
        if(list[i] > list[pivot]) {   
            if((list[i] > list[pivot]) && (list[j] <= list[pivot])) {
                int temporary1 = list[i];
                list[i] = list[j];
                list[j] = temporary1;
                i++;    
            } //End if list[i]>list[pivot]) && (list[j]<=list[pivot]
            if(list[j] > list[pivot]) {
                j--;
            } //End if list[j]>list[pivot]
        } //End if list[i]>list[pivot]
    } //End while loop
    int temporary2 = list[i];
    list[i] = list[pivot];
    list[pivot] = temporary2;
    return i;
} //End swappingTime

/******************************************************
Purpose: Sorting list using quickSort part 2
In: list (array of integers), low (integer), high (integer)
Out: None
/******************************************************/ 
public static void quickSort(int[] a, int low, int high) {
    if (Counter == 0) {
        System.out.println(ANSI_WHITE_BACKGROUND +ANSI_BLUE +"Quick Sort");
    } //End if statement
    Counter++;
    if(low >= high) {
        return;
    } //End if low >= high
    int split = swappingTime(a, low, high);
    quickSort(a, low, split-1);
    quickSort(a, split+1, high);
} //End quickSort

/******************************************************
Purpose: Sorting list using selection sort
In: list (array of integers), arrayLength (integer)
Out: None
/******************************************************/ 
public static void selectionSort(int[] list, int arrayLength) {
    System.out.println(ANSI_WHITE_BACKGROUND +ANSI_BLUE + "Selection Sort");
    arrayLength = list.length;
    for (int i = 0; i < arrayLength - 1; i++) {
        int min = i;
        for (int j = i + 1; j < arrayLength; j++) {
            if (list[j] < list[min]) {
                min = j;
            } //End if
        } //End for int j
        //Swapping:
        int temporary = list[i];
        list[i] = list[min];
        list[min] = temporary;
    } //End for int i      
} //End selectionSort

/******************************************************
Purpose: Determining largest value
In: list (array of integers)
Out: larger (integer)
/******************************************************/ 
public static int largest(int list[]) {     
    int larger = list[0];
    int i;   
    for(i = 1; i < list.length; i++) {  
        if(list[i] > larger)  
            larger = list[i];  
        } //End for loop
    return larger;  
    } //End largest loop

/******************************************************
Purpose: Sorting list using radix sort
In: list (array of integers)
Out: None
/******************************************************/ 
public static void radixSort(int list[]) {  
    System.out.println(ANSI_WHITE_BACKGROUND +ANSI_BLUE +"Radix Sort");
    int bucket[][] = new int[1000][1000];  
    int bucket_count[] = new int[1000];  
    int i, j, k, remainder, NOP=0, divisor=1, larger, pass;  
    larger = largest(list);  
    while(larger > 0) {  
        NOP++;  
        larger/=10;  
    } //End while loop 
    for(pass=0;pass<NOP;pass++) {  
        for(i = 0; i < list.length; i++) { 
            bucket_count[i]=0;
        } //End nested for loop i
        for(i = 0; i < list.length; i++) {  
            // sort the numbers according to the digit at passth place            
            remainder = (list[i]/divisor)%10;  
            bucket[remainder][bucket_count[remainder]] = list[i];  
            bucket_count[remainder] += 1;  
        } //End nested for loop i
        // collect the numbers after PASS pass  
        i=0;  
        for(k = 0; k< 1000; k++) {  
            for(j = 0; j < bucket_count[k]; j++) {  
                list[i] = bucket[k][j];  
                i++;  
            } //End for loop j
        } //End for loop k
        divisor *= 10;  
    } //End for loop pass=0;pass<NOP;pass++
} //End radixSort
     
} //Closing bracket for Sorter