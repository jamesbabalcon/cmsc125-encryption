package simplifiedDES;

public class Encrypt {
	
	private int[] k1;
	private int[] k2;
	private int[] pt = new int[8];

	public Encrypt(int[] k1, int[] k2) {
		this.k1 = k1;
		this.k2 = k2;
	}
	
	public void encrypt(String plainText) {
		System.out.println("Starting encryption");
		System.out.println("plaintext: ");
		for(int i = 0; i <= 7; i++) {
			pt[i] = Character.getNumericValue(plainText.charAt(i));
			System.out.print(pt[i] + " ");
		}
	}
	
	public void initialPerm() {
		
	}
}
