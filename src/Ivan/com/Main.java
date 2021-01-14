package Ivan.com;
/*2 * Создать массив из слов String[] words = {"apple", "orange", "lemon", "banana", "apricot",
"avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
"mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"}; При
запуске программы компьютер загадывает слово, запрашивает ответ у пользователя, сравнивает
его с загаданным словом и сообщает правильно ли ответил пользователь. Если слово не угадано,
компьютер показывает буквы которые стоят на своих местах. apple – загаданное apricot - ответ
игрока ap############# (15 символов, чтобы пользователь не мог узнать длину слова) Для
сравнения двух слов посимвольно, можно пользоваться: String str = "apple"; str.charAt(0); - метод,
вернет char, который стоит в слове str на первой позиции Играем до тех пор, пока игрок не
отгадает слово Используем только маленькие буквы */

import java.util.Locale;
import java.util.Scanner;
import java.util.Arrays;
import java.util.Objects;

public class Main {

    public static void main(String[] args) {
    	Scanner input = new Scanner(System.in);
		String [] words = {"apple", "orange", "lemon", "banana", "apricot",
            "avocado", "broccoli", "carrot", "cherry", "garlic", "grape", "melon", "leak", "kiwi", "mango",
            "mushroom", "nut", "olive", "pea", "peanut", "pear", "pepper", "pineapple", "pumpkin", "potato"};
		String generatedWord = words[(int)Math.floor(Math.random() * words.length)];
		//System.out.println(generatedWord);
		System.out.println("Guess a word from the following:");
		System.out.println(Arrays.toString(words));
		String guessWord = input.nextLine();
		guessWord = guessWord.toLowerCase();

			if (generatedWord.equals(guessWord)) {
				System.out.println("You won!");
			}
			else {
				while (! generatedWord.equals(guessWord)) {
					char [] s = new char[15];
					int minWordLength;
					if (generatedWord.length() < guessWord.length()) {
						minWordLength = generatedWord.length();
					} else {
						minWordLength = guessWord.length();
					}
					for (int i = 0; i < minWordLength; i++) {
						if (guessWord.charAt(i) == generatedWord.charAt(i)) {
							s[i] = generatedWord.charAt(i);
						}
						else {
							s[i] = '#';
						}
					}
					for (int j = minWordLength; j < 15; j++) {
						s[j] = '#';
					}
					System.out.println("You lost! But these letters match in my and your words: " + Arrays.toString(s));
					System.out.println("Try again! Guess a word from the following:");
					System.out.println(Arrays.toString(words));
					guessWord = input.nextLine();
					guessWord = guessWord.toLowerCase();
				}
				System.out.println("Congratulations, you won!");
			}
    }
}

