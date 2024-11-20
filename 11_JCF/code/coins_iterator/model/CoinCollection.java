package coins_iterator.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CoinCollection  { // implements Iterable <Coin>

    private List<Coin> coins; // получаем методы из интерфейса List

   // конструктор, который делает объекты типа CoinCollection
    public CoinCollection() {
        this.coins = new ArrayList<>(); // ArrayList - это реализация List
    }
    // получили объект типа ArrayList c Coin внутри

    public void addCoin(Coin coin){
        coins.add(coin); // метод для добавления монеты в коллекцию
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

//    @Override
//    public Iterator<Coin> iterator() {
//       return new CoinIterator();
//    }
//
//    // Внутренний класс итератора для коллекции монет
//    private class CoinIterator implements Iterator<Coin> {
//        private int index = 0;
//
//        @Override
//        public boolean hasNext() {
//            return index < coins.size();
//        }
//
//        @Override
//        public Coin next() {
//            return coins.get(index++);
//        }
//    }

}
