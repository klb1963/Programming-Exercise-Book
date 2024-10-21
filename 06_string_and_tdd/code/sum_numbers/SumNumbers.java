package sum_numbers;

//Напишите программу, которая запрашивает у пользователя строку, содержащую целые числа, и выводит сумму всех этих введенных чисел.
//Используйте классы-обёртки для преобразования строк в соответствующие примитивы.

import java.util.Scanner;

public class SumNumbers {

    private String str;

    public SumNumbers(String str) {
        this.str = str;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Input string with numbers, separated with spaces: ");

        String str = scanner.nextLine();
        System.out.println("Your input is: " + str);

        String[] numbers = str.split(" ");

        int sum = getSumOfNumbers(numbers);
        System.out.println("Sum of numbers: " + sum);

    }

    public static int getSumOfNumbers(String[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            int n = Integer.parseInt(numbers[i]);
            sum += n;
        }
        return sum;
    }
}
