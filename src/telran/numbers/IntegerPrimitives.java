package telran.numbers;

public class IntegerPrimitives {

	public static byte getMaxByte() {
		byte res = 1;
		while(res > 0) {
			res = (byte) (res + 1);
		}
		return (byte) (res - 1);
	}

	public static byte getMinByte() {
		return (byte) (getMaxByte() + 1);
	}

	public static int getLengthByte() {
		int res = getLength(getMinByte());
		return res;
	}

	public static char getMaxChar() {
		char res = 1;
		while(res > 0) {
			res = (char) (res * 2);
		}
		return (char) (res - 1);
	}

	public static char getMinChar() {
		return (char) (getMaxChar() + 1);
	}

	public static int getLengthChar() {
		int res = getLength(getMinChar());
		return res;
	}

	public static short getMaxShort() {
		short res = 1;
		while(res > 0) {
			res = (short) (res * 2);
		}
		return (short)((int)res - 1);
	}

	public static short getMinShort() {
		return (short) (getMaxShort() + 1);
	}

	public static int getLengthShort() {
		int res = getLength(getMinShort());
		return res;
	}

	public static int getMaxInt() {
		int res = 1;
		while(res > 0) {
			res = res * 2;
		}
		return res - 1;
	}

	public static int getMinInt() {
		return getMaxInt() + 1;
	}

	public static int getLengthInt() {
		int res = getLength(getMinInt());
		return res;
	}

	public static long getMaxLong() {
		long res = 1;
		while(res > 0) {
			res*=2;
		}
		return res - 1;
	}

	public static long getMinLong() {
		return getMaxLong() + 1;
	}

	public static int getLengthLong() {
		int res = getLength(getMinLong());
		return res;
	}
	/**
	 * 
	 * @param x you should understand what x is 
	 * @return length of any type in accordance to the x
	 * length is number of bytes for any type
	 */
	private static int getLength(long x) {
		int count = 0;
		x = -x;
		while(x > 1) {
			x = x / 2;
			count++;
		}
		return ((count + 1) / 8); 
	}
	
}
