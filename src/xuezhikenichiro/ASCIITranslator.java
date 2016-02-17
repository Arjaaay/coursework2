package xuezhikenichiro;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ASCIITranslator {
	private final ArrayList<String> hexTable;
	private final ArrayList<String> letterTable;
	
	/**
	 * Loads the hexadecimal numbers(00-FF) and the letters corresponding to them.
	 * @param file The file in which the tables are written.
	 */
	public ASCIITranslator(File file) throws IOException{
		hexTable = new ArrayList<>();
		letterTable = new ArrayList<>();
		
		BufferedReader reader = new BufferedReader(new FileReader(file));
		reader.readLine();
		for(String line = reader.readLine(); line != null; line = reader.readLine()){
			StringTokenizer tokenizer = new StringTokenizer(line, ",");
			
			for(int i = 0; i < 6; i++){
				String cell = tokenizer.nextToken();
				if(i == 2){
					if(!cell.chars().allMatch(c -> ('0' <= c && c <= '9') || ('A' <= c && c <= 'F'))){
						reader.close();
						throw new IllegalArgumentException("Detected an illegal hexadecimal number.");
					}
					hexTable.add(cell);
				}
				if(i == 4)letterTable.add(cell);
			}
		}
		reader.close();
	}
	/**
	 * Generates the pair of the integer values which correspond to the hexadecimal characters translated from the letter.
	 * @param letter The letter to be translated.
	 */
	public List<Integer> toIntPair(char letter){
		int index = letterTable.indexOf(Character.toString(letter));
		if(index == -1)throw new IllegalArgumentException();
		List<Integer> result = new ArrayList<>();
		String hex = hexTable.get(index);
		for(int i = 0; i < 2; i++){
			char c = hex.charAt(i);
			if('0' <= c && c <= '9')result.add(c - '0');
			else if('A' <= c && c <= 'F')result.add(c - 'A' + 10);
			else throw new AssertionError();
		}
		return result;
	}
}
