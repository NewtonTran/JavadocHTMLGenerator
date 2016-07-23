package n_tran_javadoc_gui;

import java.io.IOException;

/**
 * @classname ToFile
 * @author newton
 * @description This is the main class. this class uses methods from the other three classes to create the final html file. When using this class, put the name of the desired text file in the INPUT_NAME, put the same name in the OUTPUT_NAME but with .html instead of .txt. make sure the inputed text file is in the same project folder as this package before running this method.
 *
 */
public class ToFile {

	final static String INPUT_NAME = "toHTML.txt"; //name of input file. should be changed to the actual file name.
	final static String OUTPUT_NAME = "toHTML.html"; //name of output file. should be changed to the input file name but with .html instead of .txt
	
	public static void main(String[] args) throws IOException {
		FileToString test = new FileToString(INPUT_NAME); //creates a list that contains each line of the inputed text file
		toHTML.writeTextFile(toHTML.appendString(lineFormat.format(lineFormat.checkAsterisk(test.getLines()))), OUTPUT_NAME); //uses methods from other classes together
	}

}