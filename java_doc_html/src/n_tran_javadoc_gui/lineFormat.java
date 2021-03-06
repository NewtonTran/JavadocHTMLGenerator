package n_tran_javadoc_gui;
import java.util.*;

/**
 * @classname lineFormat
 * @author newton 
 * @description This class contains methods that format the regular lines of text to HTML. To use this class, appropriate 
 * keywords must be used when creating comments. For example, for a description, use "@description" before writing the 
 * description. the name of the class or method followed by the author must be used before the other keywords. for example, 
 * " @.methodname name \n @.author author \n @.description description...". 
 */

public class lineFormat {

	final static String keywords[] = {"@classname", "@author", "@param", "@return", "@version", "@throws", "@since", "@description", "@methodname"};
	
	/**
	 * @methodname format
	 * @description This method takes in an arrayList of arrayLists that contain strings of unformatted text for HTML then 
	 * returns an arrayList of arrayLists of formatted lines of text with appropriate HTML tags. This method will look for
	 * keywords and when a keyword is found, the method will create a string starting with an HTML tag, then the substring
	 * following the HTML tag, then the closing HTML tag. This string then replaces the unformatted version of itself.
	 * @param unformattedLines - an arrayList of arrayLists that contain the unformatted lines of the comment blocks for HTML
	 * @return formattedLines - an arrayList of arrayLists that contain formatted lines of the comment blocks for HTML
	 */
	public static ArrayList<ArrayList<String>> format(ArrayList<ArrayList<String>> unformattedLines){
		ArrayList<ArrayList<String>> formattedLines = new ArrayList<ArrayList<String>>();
		for (int i = 0;i < unformattedLines.size();i += 1){ //for each arrayList in the the arrayList unformattedLines
			ArrayList<String> temp = new ArrayList<String>();
			for (int j = 0;j < unformattedLines.get(i).size();j += 1){ // for each string in the arrayList in unformattedLines
				if (unformattedLines.get(i).get(j).contains(keywords[0])){ //if @classname is found
					temp.add("<h2>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("classname"), unformattedLines.get(i).get(j).indexOf("e") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("e") + 1) + "</h2>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[1])){ //if @author is found
					temp.add("<h4>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("author"), unformattedLines.get(i).get(j).indexOf("r") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("r") + 1) + "</h4>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[2])){ //if @param is found
					temp.add("<h4>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("param"), unformattedLines.get(i).get(j).indexOf("m") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("m") + 1) + "</h4>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[3])){ //if @return is found
					temp.add("<h4>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("return"), unformattedLines.get(i).get(j).indexOf("n") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("n") + 1) + "</h4>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[4])){ //if @version is found
					temp.add("<h4>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("version"), unformattedLines.get(i).get(j).indexOf("n") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("n") + 1) + "</h4>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[5])){ //if @throws is found
					temp.add("<h4>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("throws"), unformattedLines.get(i).get(j).indexOf("s") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("s") + 1) + "</h4>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[6])){ //if @since is found
					temp.add("<h4>" + unformattedLines.get(i).get(j).substring( 
							unformattedLines.get(i).get(j).indexOf("since"), unformattedLines.get(i).get(j).indexOf("e") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("e") + 1) + "</h4>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[7])){ //if @description is found
					temp.add("<h4>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("description"), unformattedLines.get(i).get(j).indexOf("n") + 1)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("n") + 1) + "</h4>");
				}
				else if (unformattedLines.get(i).get(j).contains(keywords[8])){ //if @methodname is found
					temp.add("<h2>" + unformattedLines.get(i).get(j).substring(
							unformattedLines.get(i).get(j).indexOf("methodname"), unformattedLines.get(i).get(j).indexOf("ame") + 3)
							+ ": " +  unformattedLines.get(i).get(j).substring(unformattedLines.get(i).get(j).indexOf("ame") + 3) + "</h2>");
				} //each if/else if statement above looks for a keyword then adds the correct HTML tags to the string
				  //this string is then put into an arrayList called temp
				  //this process is repeated for every string in every arrayList in unformattedLines
			}
			formattedLines.add(temp); //temp is then stored in an arrayList called formattedLines
		}
		return formattedLines; //the final ArrayList that contains all formatted HTML lines of text is returned
	}
	
	/**
	 * @methodname checkAsterisk
	 * @description This method takes in the raw text from the file given and organizes it into arrayLists. an arraylist is
	 * created for each comment block from the text file given and these arrayLists are stored in another arrayList. The final
	 * product of this method is an arrayList of arrayLists that each contain a block of comments.
	 * @param lineList - list of each line from the inputed text file
	 * @return tempArrayListA - arrayList of arrayLists that each contain the lines of a comment block
	 */
	public static ArrayList<ArrayList<String>> checkAsterisk(List<String> lineList){
		
		ArrayList<ArrayList<String>> tempArrayListA = new ArrayList<ArrayList<String>>();
		
		for (int i = 0;i < lineList.size(); i += 1){ //for every line in the list of lines given
			if (lineList.get(i).contains("/*") == true){ // if the beginning of a comment block is found
				ArrayList<String> tempArrayListB = new ArrayList<String>();
				int j = i;
				String notifier = null;
				while(notifier != "done"){
					tempArrayListB.add(lineList.get(j)); //add lines of the text file to this arrayList that follow the beginning of the comment block
					j += 1;
					if (lineList.get(j).contains("*/") == true){//when the end of the comment block is found ('*/'), stop adding lines to this arrayList
						notifier = "done";
					}
				}
				tempArrayListA.add(tempArrayListB); //store the arraylist just created (tempArrayListB) into another arrayList (tempArrayListA)
				i = j; //variables i and j are used to ensure that no lines from the text file are checked more than once
				       //the variable j and i are basically the same number at all times. when i increases, j increases aswell.
			}
		}
		return tempArrayListA; 
	}
}
