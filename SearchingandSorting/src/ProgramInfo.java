
/* **********************************************************
 * Programmer:      Erika Tvaskis
 * Class:           CS40S
 * Assignment 2:    Searching and Sorting 
 * Description:     Class to print banners and closing messages
 * *************************************************************
 */

public class ProgramInfo
    {  //Begin class

/******************************************************
Purpose: Creates default constructor
In: None
Out: None
/******************************************************/ 
public ProgramInfo(){
} //End default constructor

/******************************************************
Purpose: Get banner
In: a (String)
Out: bannerOut
/******************************************************/ 
public static String getBanner(String a){
    String bannerOut = "";
    bannerOut = "*******************************************\n";
    bannerOut += "Name:		Erika Tvaskis\n";
    bannerOut += "Class:		CS40S\n";
    bannerOut += "Assignment:	" + 2 + "\n";
    bannerOut += "*******************************************\n";         
    return bannerOut;
} //End getBanner
     
/******************************************************
Purpose: Get closing message
In: None
Out: closing
/******************************************************/
public static String getClosingMessage(){
    String closing = "\n";
    closing += "End of processing.\n";
    return closing;
} //End getClosingMessage

} //End ProgramInfo