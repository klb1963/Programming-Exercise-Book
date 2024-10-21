package detail.dao;

import detail.model.Detail;

public class StockImpl implements Stock {

    Detail[] details;
    int size; // сколько деталей

    public StockImpl(int capacity){
        details = new Detail[capacity];
        this.size = 0;
    }

    @Override
    public boolean addDetail(Detail detail) {
        if(detail == null ){
            return false;
        }
        if(size == details.length){
            return false;
        }
        if(findByBarCode(detail.getBarCode()) != null){
            return false;
        }
        details[size] = detail;
        size++;
        return true;
    }

    @Override
    public Detail findByBarCode(long barCod) {
        for (int i = 0; i < size; i++){
            if (details[i].getBarCode() == barCod) {
                return details[i];
            }
        }

        return null;
    }

    @Override
    public Detail updateDetail(Detail detail) {
        return null;
    }

    @Override
    public Detail deleteDetail(long barCode) {
        return null;
    }

    @Override
    public void printStock() {
        for (int i = 0; i < size; i++) {
            System.out.println(details[i]);
        }

    }

    @Override
    public int quantity() {
        return size;
    }
}
