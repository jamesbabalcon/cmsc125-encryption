package simplifiedDES;

public class SimplifiedDES {

	public static void main(String[] args) {
		
		String key = "1010000010";
		new KeyGen().generateKeys(key);;
	}
}
