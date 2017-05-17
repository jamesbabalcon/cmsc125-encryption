package simplifiedDES;

public class Decrypt {
	
	private int[] k1, k2;
	private int[] pt = new int[8];
	private int[] decrypted = new int[8];

	public Decrypt() {}
	
	public void decrypt(int[] pt, int[] k1, int[] k2) {
		this.pt = pt;
		this.k1 = k1;
		this.k2 = k2;
//		System.out.println("\nStarting encryption");
		round1();
		round2();
	}
	
	private void round1() {
//		System.out.println("ROUND 1");
//		System.out.print("subkey: ");
//		for(Integer i : k2) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
		initialPerm();
//		int[] ep = ep();
//		System.out.print("ep: ");
//		for(Integer i : ep) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] xor = xorsubkey(k2);
//		System.out.print("xorsubkey: ");
//		for(Integer i : xor) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] sbox = sbox(k2);
//		System.out.print("sbox: ");
//		for(Integer i : sbox) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] p4 = perm4(k2);
//		System.out.print("p4: ");
//		for(Integer i : p4) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] xorFk = xorFk(k2);
//		System.out.print("xorFk: ");
//		for(Integer i : xorFk) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] sw = sw(k2);
//		System.out.print("finally: ");
//		for(Integer i : sw) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
	}
	
	private void round2() {
//		System.out.println("ROUND 2");
//		System.out.print("subkey: ");
//		for(Integer i : k1) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		pt = sw(k2);

//		int[] ep = ep();
//		System.out.print("ep: ");
//		for(Integer i : ep) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] xor = xorsubkey(k1);
//		System.out.print("xorsubkey: ");
//		for(Integer i : xor) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] sbox = sbox(k1);
//		System.out.print("sbox: ");
//		for(Integer i : sbox) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] p4 = perm4(k1);
//		System.out.print("p4: ");
//		for(Integer i : p4) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] xorFk = xorFk(k1);
//		System.out.print("xorFk: ");
//		for(Integer i : xorFk) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
//		
//		int[] test = test();
//		System.out.print("test: ");
//		for(Integer i : test) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
		
		decrypted = ipInverse(k1);
//		System.out.print("finally: ");
//		for(Integer i : encrypted) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
	}
	
	private void initialPerm() {
		int[] temp = new int[8];
		
		temp[0] = pt[1];
		temp[1] = pt[5];
		temp[2] = pt[2];
		temp[3] = pt[0];
		
		temp[4] = pt[3];
		temp[5] = pt[7];
		temp[6] = pt[5];
		temp[7] = pt[6];
		
		pt = temp;
		
//		System.out.print("pt after ip: ");
//		for(Integer i : pt) {
//			System.out.print(i + " ");
//		}
//		System.out.println();
	}
	
	private int[] test(int[] subkey) {
		int[] temp = new int[8];
		int[] xor = xorFk(subkey);
		
		temp[0] = xor[0];
		temp[1] = xor[1];
		temp[2] = xor[2];
		temp[3] = xor[3];
		
		temp[4] = pt[4];
		temp[5] = pt[5];
		temp[6] = pt[6];
		temp[7] = pt[7];
		
		return temp;
	}
	
	private int[] ipInverse(int[] subkey) {
		int[] temp = test(subkey);
		int[] inverse = new int[8];
		
		inverse[0] = temp[3];
		inverse[1] = temp[0];
		inverse[2] = temp[2];
		inverse[3] = temp[5];
	
		inverse[4] = temp[6];
		inverse[5] = temp[1];
		inverse[6] = temp[7];
		inverse[7] = temp[5];
		
		return inverse;
	}
	
	private int[] ep() {
		int[] temp = new int[8];
		
		temp[0] = pt[7];
		temp[1] = pt[4];
		temp[2] = pt[5];
		temp[3] = pt[6];
		
		temp[4] = pt[5];
		temp[5] = pt[6];
		temp[6] = pt[7];
		temp[7] = pt[4];
		
		return temp;
	}
	
	private int[] xorsubkey(int[] subkey) {
		int[] temp = new int[8];
		int[] ep = ep();
		
		for(int i = 0; i <= 7; i++) {
			temp[i] = xor(subkey[i], ep[i]);
		}
		
		return temp;
	}
	
	private int xor(int a, int b) {
		if(a == 0 && b == 0)
			return 0;
		else if(a == 1 && b == 0)
			return 1;
		else if(a == 0 && b == 1)
			return 1;
		else if(a == 1 && b == 1)
			return 0;
		
		return -1;
	}
	
	private int[] sbox(int[] subkey) {
		int[] temp = new int[4];
		int[] xor = xorsubkey(subkey);
		
		String[][] s0 = { {"01", "00", "11", "10"},
				 	      {"11", "10", "01", "00"},
				 	      {"00", "10", "01", "11"},
				 	      {"11", "01", "11", "10"}
					    };
		
		String[][] s1 = { {"00", "01", "10", "11"},
		 	      		  {"10", "00", "01", "11"},
		 	      		  {"11", "00", "01", "00"},
		 	      		  {"10", "01", "00", "11"}
			    		};
		
		temp[0] = Character.getNumericValue(s0[lookup(xor[0], xor[3])][lookup(xor[1], xor[2])].charAt(0));
		temp[1] = Character.getNumericValue(s0[lookup(xor[0], xor[3])][lookup(xor[1], xor[2])].charAt(1));
		temp[2] = Character.getNumericValue(s1[lookup(xor[4], xor[7])][lookup(xor[5], xor[6])].charAt(0));
		temp[3] = Character.getNumericValue(s1[lookup(xor[4], xor[7])][lookup(xor[5], xor[6])].charAt(1));
		
		return temp;
	}
	
	private int lookup(int a, int b) {
		int[] bits = new int[2];
		bits[0] = a;
		bits[1] = b;
		int temp = 0;
		int base = 1;
		
		for(int i = bits.length - 1; i >= 0; i--) {
			temp = temp + (bits[i] * base);
			base *= 2;
		}
		
		return temp;
	}
	
	private int[] perm4(int[] subkey) {
		int[] temp = new int[4];
		int[] sbox = sbox(subkey);
		
		temp[0] = sbox[1];
		temp[1] = sbox[3];
		temp[2] = sbox[2];
		temp[3] = sbox[0];
		
		return temp;
	}
	
	private int[] xorFk(int[] subkey) {
		int[] temp = new int[4];
		int[] perm4 = perm4(subkey);
		
		for(int i = 0; i <= 3; i++) {
			temp[i] = xor(pt[i], perm4[i]);
		}
		
		return temp;
	}
	
	private int[] sw(int[] subkey) {
		int[] temp = new int[8];
		int[] fk = xorFk(subkey);
		
		temp[0] = pt[4];
		temp[1] = pt[5];
		temp[2] = pt[6];
		temp[3] = pt[7];
		
		temp[4] = fk[0];
		temp[5] = fk[1];
		temp[6] = fk[2];
		temp[7] = fk[3];
		
		return temp;
	}
	
	public String getDecrypted() {
		String res = "";
		
		for(int i = 0; i <= 7; i++) {
			res += Integer.toString(decrypted[i]);
		}
		
		return res;
	}
}
