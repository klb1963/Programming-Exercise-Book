public class GameOfDice {

    // Смоделируйте игру в кости. В каждой попытке бросаются три игральных кубика и подсчитывается сумма выпавших очков.

    public static void main(String[] args) {

        int[] dice = new int[3];

        // throw dice
        int a = 1, b = 6;

        for (int i = 0; i <dice.length ; i++) {
            dice[i] = (int)(Math.random() * (b - a + 1) + a);
            System.out.print(dice[i] + " ");
        }

        System.out.println();

        // count result for 3 dice
        int res = 0;
        for (int i = 0; i < dice.length; i++) {
            res = res + dice[i];
        }

        // print result
        System.out.println(res);
    }
}
