package coins_iterator;

import coins_iterator.model.Coin;
import coins_iterator.model.CoinCollection;

import java.util.List;

public class CoinAppl {

    public static void main(String[] args) {
        // Создаем коллекцию монет
        CoinCollection myCoins = new CoinCollection();

        // Добавляем монеты в коллекцию
        myCoins.addCoin(new Coin("Россия", "1 рубль", 1898, 20.0));
        myCoins.addCoin(new Coin("США", "1 доллар", 1921, 26.73));
        myCoins.addCoin(new Coin("Германия", "5 марок", 1971, 10.0));

        System.out.println(myCoins);

//        for (Coin coin: myCoins) {
//            System.out.println(coin);
//        }

        System.out.println("-----------------------------------");

        List<Coin> coins = myCoins.getCoins(); // забрал всю коллекцию в другой объект
        coins.remove(0); // удалил сколько угодно элементов
        System.out.println(coins.size());
        System.out.println(coins);

    }
}
