import java.util.*;

//~ Нурзада Эркулов курсовая работа

class kursa4 {
	
	
	public static int LEN = 7; //~ Количество бит
	public static int _XOR = 1000000007; //~ Число-ключ
	
	public static String word = "NURZADA ERKULOVA"; //~ Текст для шифровки
	public static String ans1 = ""; //~ Зашифрованный текст
	public static String ans2 = ""; //~ Расшифрованный текст
	
	public static ArrayList<Integer> nums = new ArrayList<>(); //~ Массив чисел для расшифровки
	
	public static Map<Integer, Character> B = new HashMap<Integer, Character>(); //~ Таблица замен
	public static Map<Character, Integer> A = new HashMap<Character, Integer>(); //~ Таблица замен
	
	public static String to_bin(int n, int len) { //~ перевод числа из десятичной системы в двоичную
		String x = "";
		while(n > 0) {
			int a = n % 2;
			x = a + x;
			n = n / 2;
		}
		while (x.length() < len) {
			x = '0' + x;
		}
		return x;
	}
	
	public static void encode() { //~ функция для шифровки текста
		for (int i = 0; i < word.length(); ++i) {
			int num = A.get(word.charAt(i));
			num ^= _XOR;
			nums.add(num);
			ans1 += to_bin(num, LEN);
		}
	}
	
	public static void decode() { //~ функция для расшифровки текста
		for (int el : nums) {
			ans2 += B.get(el ^ _XOR);
		}
	}
	
	public static void main(String args[]) { //~ Главная функция - точка входа
		int number = 1;
		for (char c = 'A'; c <= 'Z'; ++c) {
			A.put(c, number);
			B.put(number, c);
			number++;
		}
		B.put(number, ' ');
		A.put(' ', number);
		encode();
		decode();
		System.out.println("Текст для шифровки: " + word);
		System.out.println("Зашифрованный текст: \n" + ans1);
		System.out.println("\nРасшифрованный текст: " + ans2);
	}
}
