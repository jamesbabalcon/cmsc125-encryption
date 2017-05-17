package simplifiedDES;

public class KeyGen {
	
	private int[] key = new int[10];
	private int[] k1 = new int[8];
	private int[] k2 = new int[8];
	
	public KeyGen() {}
	
	public void generateKeys(String input) {
		System.out.print("key: ");
		for(int i = 0; i <= 9; i++) {
			key[i] = Character.getNumericValue(input.charAt(i));
			System.out.print(key[i] + " ");
		}
		System.out.println();
		
		perm10();
		leftShift1();
		
		k1 = perm8();
		System.out.print("k1: ");
		for(Integer i : k1) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		leftShift2();
		
		k2 = perm8();
		System.out.print("k2: ");
		for(Integer i : k2) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private void perm10() {
		int[] temp = new int[10];
		
		temp[0] = key[2];
	    temp[1] = key[4];
	    temp[2] = key[1];
	    temp[3] = key[6];
	    temp[4] = key[3];
	    
	    temp[5] = key[9];
	    temp[6] = key[0];
	    temp[7] = key[8];
	    temp[8] = key[7];
	    temp[9] = key[5];
	    
	    key = temp;
	    
	    System.out.print("key after p10: ");
		for(Integer i : key) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private void leftShift1() {
		int[] temp = new int[10];
		
		temp[0] = key[1];
		temp[1] = key[2];
		temp[2] = key[3];
		temp[3] = key[4];
		temp[4] = key[0];
		
		temp[5] = key[6];
		temp[6] = key[7];
		temp[7] = key[8];
		temp[8] = key[9];
		temp[9] = key[5];
		
		key = temp;
		
		System.out.print("key after left shift 1: ");
		for(Integer i : key) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private void leftShift2() {
		int[] temp = new int[10];
		
		temp[0] = key[2];
		temp[1] = key[3];
		temp[2] = key[4];
		temp[3] = key[0];
		temp[4] = key[1];
		
		temp[5] = key[7];
		temp[6] = key[8];
		temp[7] = key[9];
		temp[8] = key[5];
		temp[9] = key[6];
		
		key = temp;
		
		System.out.print("key after left shift 2: ");
		for(Integer i : key) {
			System.out.print(i + " ");
		}
		System.out.println();
	}
	
	private int[] perm8() {
		int[] temp = new int[8];
		
		temp[0] = key[5];
		temp[1] = key[2];
		temp[2] = key[6];
		temp[3] = key[3];
		
		temp[4] = key[7];
		temp[5] = key[4];
		temp[6] = key[9];
		temp[7] = key[8];
		
		return temp;
	}
	
	public int[] getK1() {
		return k1;
	}
	
	public int[] getK2() {
		return k2;
	}
}
