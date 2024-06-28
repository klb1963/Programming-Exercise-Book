public class Coin {

    // Промоделируйте 100 бросков монеты. Подсчитайте, сколько раз выпал орел, а сколько решка.

    public static void main(String[] args) {

        int[] coinThrow = new int[100];
        int a = 0, b = 1;

        // fill array
        for (int i = 0; i < coinThrow.length ; i++) {
            coinThrow[i] = (int)(Math.random() * (b - a + 1) + a);
        }
        // count results
        int countAvers = 0;
        int countRevers = 0;
        for (int i = 0; i < coinThrow.length ; i++) {

            if(coinThrow[i] == 0) {
                countAvers++;
            } else {
                countRevers++;
            }
        }
        // print results
        System.out.println("Avers: " + countAvers + ", frequency: " + countAvers/(double)coinThrow.length);
        System.out.println("Revers: " + countRevers + ", frequency: " + countRevers/(double)coinThrow.length);

    }
}
