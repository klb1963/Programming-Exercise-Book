public class Fill10RandomNumbers {
    // Заполните массив на 10 элементов случайными целыми числами из интервала от 1 до 10.

    public static void main(String[] args) {

        int[] array = new int[10];
        int a = 1, b = 10;

        // int n = (int)(Math.random() * (b - a + 1) + a) - генерирует случайное **целое** число в интервале [a, b]
        // fill array
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random()*(b - a + 1) + a);
        }

        // print array
        for (int i = 0; i < array.length ; i++) {
            System.out.print(array[i] + " | ");
        }
        System.out.println(); // new line
        System.out.println("----------------------------");
    }
}
