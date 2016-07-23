package java_doc_html;
import java.util.*;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * @classname toHTML
 * @author newton
 * @description This class contains a method that will create the final string that will be written into a text file and 
 * saved as an html file, as well as the method that will actually write the html file.
 */

public class toHTML {

	/**
	 * @methodname appendString
	 * @description This method takes in the arrayList of arrayLists of strings that are already formatted for HTML and 
	 * returns one large string using StringBuilder. this large string when saved as an HTML file, will create an HTML page
	 *  with all the necessary information from the original text file provided. This method appends every line in the 
	 *  arrayList of arrayLists of lines to a master string using StringBuilder.
	 * @param formattedLines - an arrayList of arrayLists that contain formatted lines of the comment blocks for HTML
	 * @return String - a master string that contains every formatted line created. When this string is written and saved 
	 * as an html file, the html file will contain all the necessary information from the original text file formatted correctly.
	 */
	public static String appendString(ArrayList<ArrayList<String>> formattedLines){
		//These are just fillers so errors don't occur
		StringBuilder sb = new StringBuilder(formattedLines.size());
		for(int i = 0; i < formattedLines.size(); i++){ //for each arraylist in formattedLines
			for(int j = 0;j < formattedLines.get(i).size();j += 1){ //for each string in each arraylist in formatted lines
				sb.append(formattedLines.get(i).get(j)); //add the formatted line to the large string
			}
		}
		return sb.toString(); //return the large string
	}
	
	/**
	 * @methodname writeTextFile
	 * @description This method takes a string and writes that string into a txt file and saves it as .html.
	 * @param finalString - the master string ready to be saved as an html file
	 * @param aFileName - string of desired name of the output file
	 * @throws IOException
	 */
	public static void writeTextFile(String finalString, String fileName) throws IOException {
		List<String> finalStringList = new ArrayList(); //the Files.write method requires the string to be in a list
		finalStringList.add(finalString); //the string is put in a list with these two lines
	    Path path = Paths.get(fileName); //gets the path of the original text file
	    Files.write(path, finalStringList, StandardCharsets.UTF_8); //creates a file in the same location
	}
}
