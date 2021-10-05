/**
* author : Ayush Saini, https://github.com/CinematicGenius007
*/

// Just a cool java project to revise some basic java concepts to run on Command Line.

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@SuppressWarnings("unused")
public class Main {
	private static final Scanner scanner = new Scanner(System.in);
	private static final NumberFormat myFormat = NumberFormat.getInstance();
	private static final Class<Main> cls = Main.class;

	
	public static void main(String[] args) throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		//Greetings
		print("Welcome to Amazing Numbers!\n", true);
		
		print(instructions(), true);
		
		while (true) {
			long n = 0L;
			int range = 1;
			List<Main.Property> list = new ArrayList<>();
			
			print("\nEnter a request (0 to exit): ", false);
			
			String[] response = scanner.nextLine().split(" ");
			print("", true);
			
			if (response.length == 0) {
				print(instructions(), true); 
				continue;
			}
			
			if (response[0].charAt(0) == '0') break;
			
			if ((n = checkNumber(response[0])) < 0L) continue;
			
			if (response.length > 1 
					&& (range = checkRange(response[1])) < 0) continue;
			
			if (response.length > 2
					&& (list = checkProps(response)) == null) continue;
			
			if (range == 1) singleProp(n);
			else if (list.size() == 0) for (int i = 0; i < range; i++) printPropList(n + i);
			else if (list.size() > 0 && range > -1) {
				for (int i = 0, j = 0; i < range; j++) {
					boolean isValid = true;
					for (int k = 0; k < list.size(); k++) {
						Method m = cls.getDeclaredMethod(list.get(k).getName(), long.class);
						m.setAccessible(true);
//						print(m.toString(), true);
						isValid = isValid && (boolean) m.invoke(null, n + j);
						if (!isValid) break;
					}
					if (isValid && ++i >= 0) printPropList(n + j);
				}
			}
			
		}
		
		print("Goodbye!\r\n"
				+ "\r\n"
				+ "Process finished with exit code 0", true);
		
	}
	
	private static long checkNumber(String no) {
		long n = -1L;
		try {
			n = Long.parseLong(no);
			if (n < 0L) throw new Exception();
		} catch (Exception e) {
			n = -1L;
			error1();
		}
		return n;
	}
	
	private static int checkRange(String no) {
		int n = -1;
		try {
			n = Integer.parseInt(no);
			if (n < 0L) throw new Exception();
		} catch (Exception e) {
			n = -1;
			error2();
		}
		return n;
	}
	
	private static List<Main.Property> checkProps(String[] res) {
		List<Main.Property> list = new ArrayList<>();
		List<String> errors = new ArrayList<>();
		for (int i = 2; i < res.length; i++) {
			Main.Property p = Main.Property.isProp(res[i].toLowerCase());
			if (p == null) {
				errors.add(res[i].toUpperCase());
				list = null;
			} else if (list != null && p != null) {
				list.add(p);
			}
		}
		if (list == null || errors.size() > 0) error4(errors);
		if (list != null && errors.size() == 0) {
			if (list.contains(Main.Property.EVEN) && list.contains(Main.Property.ODD)) {
				errors.add(Main.Property.EVEN.toString()); errors.add(Main.Property.ODD.toString());
			} else if (list.contains(Main.Property.DUCK) && list.contains(Main.Property.SPY)) {
				errors.add(Main.Property.DUCK.toString()); errors.add(Main.Property.SPY.toString());
			} else if (list.contains(Main.Property.SQUARE) && list.contains(Main.Property.SUNNY)) {
				errors.add(Main.Property.SQUARE.toString()); errors.add(Main.Property.SUNNY.toString());
			} else if (list.contains(Main.Property.SAD) && list.contains(Main.Property.HAPPY)) {
				errors.add(Main.Property.SAD.toString()); errors.add(Main.Property.HAPPY.toString());
			} else if (list.contains(Main.Property._EVEN) && list.contains(Main.Property._ODD)) {
				errors.add("-EVEN"); errors.add("-ODD");
			} else if (list.contains(Main.Property._DUCK) && list.contains(Main.Property._SPY)) {
				errors.add("-DUCK"); errors.add("-SPY");
			} else if (list.contains(Main.Property._SQUARE) && list.contains(Main.Property._SUNNY)) {
				errors.add("-SQUARE"); errors.add("-SUNNY");
			} else if (list.contains(Main.Property._SAD) && list.contains(Main.Property._HAPPY)) {
				errors.add("-SAD"); errors.add("-HAPPY");
			} else if (list.contains(Main.Property._EVEN) && list.contains(Main.Property.EVEN)) {
				errors.add("-EVEN"); errors.add("EVEN");
			} else if (list.contains(Main.Property._ODD) && list.contains(Main.Property.ODD)) {
				errors.add("-ODD"); errors.add("ODD");
			} else if (list.contains(Main.Property._BUZZ) && list.contains(Main.Property.BUZZ)) {
				errors.add("-BUZZ"); errors.add("BUZZ");
			} else if (list.contains(Main.Property._DUCK) && list.contains(Main.Property.DUCK)) {
				errors.add("-DUCK"); errors.add("DUCK");
			} else if (list.contains(Main.Property._PALINDROMIC) && list.contains(Main.Property.PALINDROMIC)) {
				errors.add("-PALINDROME"); errors.add("PALINDROME");
			} else if (list.contains(Main.Property._GAPFUL) && list.contains(Main.Property.GAPFUL)) {
				errors.add("-GAPFUL"); errors.add("GAPFUL");
			} else if (list.contains(Main.Property._SPY) && list.contains(Main.Property.SPY)) {
				errors.add("-SPY"); errors.add("SPY");
			} else if (list.contains(Main.Property._SQUARE) && list.contains(Main.Property.SQUARE)) {
				errors.add("-SQUARE"); errors.add("SQUARE");
			} else if (list.contains(Main.Property._SUNNY) && list.contains(Main.Property.SUNNY)) {
				errors.add("-SUNNY"); errors.add("SUNNY");
			} else if (list.contains(Main.Property._JUMPING) && list.contains(Main.Property.JUMPING)) {
				errors.add("-JUMPING"); errors.add("JUMPING");
			} else if (list.contains(Main.Property._SAD) && list.contains(Main.Property.SAD)) {
				errors.add("-SAD"); errors.add("SAD");
			} else if (list.contains(Main.Property._HAPPY) && list.contains(Main.Property.HAPPY)) {
				errors.add("-HAPPY"); errors.add("HAPPY");
			} if (errors.size() != 0) {error6(errors); list = null;}
		}
		return list;
	}
	
	private static void singleProp(long n) {
		myFormat.setGroupingUsed(true);
		print("Properties of " + myFormat.format(n) + "\r\n"
				+ "        buzz: " + isBuzz(n) + "\r\n"
				+ "        duck: " + isDuck(n) + "\r\n"
				+ " palindromic: " + isPalindrome(n) + "\r\n"
				+ "      gapful: " + isGapful(n) + "\r\n"
				+ "         spy: " + isSpy(n) + "\r\n"
				+ "      square: " + isSquare(n) + "\r\n"
				+ "       sunny: " + isSunny(n) + "\r\n"
				+ "     jumping: " + isJumping(n) + "\r\n"
				+ "         sad: " + isSad(n) + "\r\n"
				+ "       happy: " + isHappy(n) + "\r\n"
				+ "        even: " + isEven(n) + "\r\n"
				+ "         odd: " + isOdd(n), true);
	}
	
	private static String instructions() {
		return "Supported requests:\r\n"
				+ "- enter a natural number to know its properties;\r\n"
				+ "- enter two natural numbers to obtain the properties of the list:\r\n"
				+ "  * the first parameter represents a starting number;\r\n"
				+ "  * the second parameter shows how many consecutive numbers are to be processed;\r\n"
				+ "- two natural numbers and properties to search for;\r\n"
				+ "- a property preceded by minus must not be present in numbers;\r\n"
				+ "- separate the parameters with one space;\r\n"
				+ "- enter 0 to exit.";
	}
	
	private static void printPropList(long n) {
		myFormat.setGroupingUsed(true);
		System.out.printf("%16s", myFormat.format(n));
		print(" is "
				+ (isBuzz(n) ? "buzz, " : "")
				+ (isDuck(n) ? "duck, " : "")
				+ (isPalindrome(n) ? "palindromic, " : "")
				+ (isGapful(n) ? "gapful, " : "")
				+ (isSpy(n) ? "spy, " : "")
				+ (isSquare(n) ? "square, " : "")
				+ (isSunny(n) ? "sunny, " : "")
				+ (isJumping(n) ? "jumping, " : "")
				+ (isSad(n) ? "sad, " : "")
				+ (isHappy(n) ? "happy, " : "")
				+ (isEven(n) ? "even" : "")
				+ (isOdd(n) ? "odd" : "")
				+ "", true);
	}
	
	//Properties
	private static boolean isOdd(long n)  {return n % 2 != 0;}
	private static boolean isEven(long n)  {return n % 2 == 0;}
	private static boolean isBuzz(long n)  {return n % 7 == 0 || n % 10 == 7;}
	private static boolean isDuck(long n)  {return ("" + n).indexOf("0") >= 0;}
	private static boolean isPalindrome(long n)  {
		return ("" + n).equals(new StringBuilder("" + n).reverse().toString());
	}
	private static boolean isGapful(long n)  {
		return Long.toString(n).length() > 2 
				&& n % Long.parseLong(Long.toString(n).charAt(0) + Long.toString(n % 10L)) == 0;
	}
	private static boolean isSpy(long n) {
		long sum = 0;
		long product = 1;
		while (n > 0L) {
			sum += n % 10;
			product *= n % 10;
			n /= 10;
		}
		return sum == product;
	}
	private static boolean isSquare(long n) {
		return Math.sqrt(n) - Math.floor(Math.sqrt(n)) == 0;
	}
	private static boolean isSunny(long n) {
		return Math.sqrt(n + 1L) - Math.floor(Math.sqrt(n + 1L)) == 0;
	}
	private static boolean isJumping(long n) {
		while (n > 10) {
			if (Math.abs((n % 10) - ((n / 10) % 10)) != 1) {
				return false;
			}
			n /= 10;
		}
		return true;
	}
	private static boolean isSad(long n) {
		while (n != 1L || n != 4L) {
			long sum = 0;
			while (n > 0) {
				sum += Math.pow(n % 10, 2);
				n /= 10;
			}
			if (sum == 4) return true;
			else if (sum == 1) return false;
			n = sum;
		}
		return false;
	}
	private static boolean isHappy(long n) {return !isSad(n);}
	
	//negation of methods
	
	private static boolean isNotEven(long n) {return !isEven(n);}
	private static boolean isNotOdd(long n) {return !isOdd(n);}
	private static boolean isNotBuzz(long n) {return !isBuzz(n);}
	private static boolean isNotDuck(long n) {return !isDuck(n);}
	private static boolean isNotPalindrome(long n) {return !isPalindrome(n);}
	private static boolean isNotGapful(long n) {return !isGapful(n);}
	private static boolean isNotSpy(long n) {return !isSpy(n);}
	private static boolean isNotSquare(long n) {return !isSquare(n);}
	private static boolean isNotSunny(long n) {return !isSunny(n);}
	private static boolean isNotJumping(long n) {return !isJumping(n);}
	private static boolean isNotSad(long n) {return !isSad(n);}
	private static boolean isNotHappy(long n) {return !isHappy(n);}
	
	
	
	private static void print(String str, boolean newLine) {
		if (str != null) {
			if (newLine)
				System.out.println(str);
			else 
				System.out.print(str);
		} else if (newLine) {
			System.out.println();
		}
	}
	
	private static void error1() {
		print("The first parameter should be a natural number or zero.", true);
	}
	
	private static void error2() {
		print("The second parameter should be a natural number.", true);
	}
	
	private static void error4(List<String> errors) {
		print("The propert" + (errors.size() > 1 ? "ies " : "y ")
				+ errors
				+ (errors.size() > 1 ? " are " : " is ")
				+ "wrong.\r\n"
				+ "Available properties: "
				+ "[EVEN, ODD, BUZZ, DUCK, "
				+ "PALINDROMIC, GAPFUL, SPY, "
				+ "SQUARE, SUNNY, JUMPING, SAD, HAPPY]", true);
	}
	
	private static void error6(List<String> list) {
		print("The request contains mutually exclusive properties: " 
				+ list + "\r\n"
				+ "There are no numbers with these properties.", true);
	}
	
	protected enum Property {
		EVEN("isEven"), 
		ODD("isOdd"), 
		BUZZ("isBuzz"), 
		DUCK("isDuck"), 
		PALINDROMIC("isPalindrome"), 
		GAPFUL("isGapful"), 
		SPY("isSpy"), 
		SQUARE("isSquare"), 
		SUNNY("isSunny"), 
		JUMPING("isJumping"), 
		SAD("isSad"),
		HAPPY("isHappy"), 
		_EVEN("isNotEven"), 
		_ODD("isNotOdd"), 
		_BUZZ("isNotBuzz"), 
		_DUCK("isNotDuck"), 
		_PALINDROMIC("isNotPalindrome"), 
		_GAPFUL("isNotGapful"), 
		_SPY("isNotSpy"), 
		_SQUARE("isNotSquare"), 
		_SUNNY("isNotSunny"), 
		_JUMPING("isNotJumping"), 
		_SAD("isNotSad"),
		_HAPPY("isNotHappy");
		
		private final String name;
		
		Property(String name) {
			this.name = name;
		}
		
		public String getName() {
			return this.name;
		}
		
		public static Property isProp(String s) {
			switch (s) {
			case "even": 			return EVEN;
			case "odd": 			return ODD;
			case "buzz": 			return BUZZ;
			case "duck": 			return DUCK;
			case "palindromic": 	return PALINDROMIC;
			case "gapful": 			return GAPFUL;
			case "spy": 			return SPY;
			case "square": 			return SQUARE;
			case "sunny": 			return SUNNY;
			case "jumping": 		return JUMPING;
			case "sad":				return SAD;
			case "happy":			return HAPPY;
			case "-even": 			return _EVEN;
			case "-odd": 			return _ODD;
			case "-buzz": 			return _BUZZ;
			case "-duck": 			return _DUCK;
			case "-palindromic": 	return _PALINDROMIC;
			case "-gapful": 		return _GAPFUL;
			case "-spy": 			return _SPY;
			case "-square": 		return _SQUARE;
			case "-sunny": 			return _SUNNY;
			case "-jumping": 		return _JUMPING;
			case "-sad":			return _SAD;
			case "-happy":			return _HAPPY;
			default: 				return null;
			}
		}
		
	}
}
