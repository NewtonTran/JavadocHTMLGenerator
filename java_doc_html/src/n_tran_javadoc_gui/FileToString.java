package n_tran_javadoc_gui;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * @classname FileToString
 * @author newton
 * @description This class contains a method that reads the lines of a given '.txt' file and puts each line of
 * that text file into a list. The other methods in the class are used to access this newly created list as well
 * as the name of the file. All instances of this class will have a list containing strings of each line of the inputed 
 * text file, as well as a string of the file name.
 */

public class FileToString {

	private List<String> lineList;
	private String fileName;
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	/**
	 * @methodname FileToString (constructor)
	 * @description This constructor creates a list containing strings of each line of the given text file. This
	 * list is then assigned to the variable 'lineList'. This constructor also assigns the name of the file to 
	 * 'fileName'.
	 * @param fileName - name of the input file
	 * @throws IOException
	 */
	public FileToString(String fileName) throws IOException{
		this.fileName = fileName; //assigns name of the file to the variable 'fileName'
		Path path = Paths.get(fileName); //gets path of the name of the file given
		this.lineList =  Files.readAllLines(path, ENCODING); //creates list of lines of text and assigns to 'lineList'
	}
	
	/**
	 * @methodname getLines
	 * @description This method returns the list of lines from the text file.
	 * @return lineList - the list of lines of the inputed text file
	 */
	public List<String> getLines(){
		return this.lineList;
	}
	
	/**
	 * @methodname getFileName
	 * @description This method returns the name of the file given.
	 * @return String - the file name
	 */
	public String getFileName(){
		return this.fileName;
	}
}
