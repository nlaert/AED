package serie3;

import java.io.IOException;

public class LoadWordsFromFileTest {
	static TNode root = new TNode();
	public static void main(String[] args) throws IOException {
		root = AutoCompleteUtils.loadWordsFromFile(root, "C:/Users/Nick/Documents/GitHub/main/teste.txt");
		System.out.println();
	}
	
}
