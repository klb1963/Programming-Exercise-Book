package set.model;

import set.interfaces.ISet;

import java.util.Iterator;
import java.util.LinkedList;

public class MyHashSet<E> implements ISet<E> {
    private LinkedList<E>[] hashset; // это массив из связных листов, то есть
    private int size;
    private int capacity; // кол-во "ячеек", "гвоздиков" для цепочек
    private double loadFactor; // объем загрузки этих ячеек

    public MyHashSet(int capacity, double loadFactor) {
        this.capacity = capacity;
        this.loadFactor = loadFactor;
        hashset = new LinkedList[capacity];
    }

    public MyHashSet(int capacity) {
        this(capacity, 0.75);
    }

    public MyHashSet() {
        this(16);
    }

    // O(1)
    @Override
    public boolean add(E element) {
        if (size >= loadFactor * capacity) {
            rebuildArray();
        }
        int index = getIndex(element);
        if (hashset[index] == null) {
            hashset[index] = new LinkedList<>();
        }
        if (hashset[index].contains(element)) {
            return false; // следим за уникальностью элементов
        }
        hashset[index].add(element);
        size++;
        return true;
    }

    private void rebuildArray() {
        capacity = capacity << 1; // удвоили размер
        LinkedList<E>[] newHashset = new LinkedList[capacity];
        // надо обежать весь hashSet, залезть в каждый его LinkedList, переложить элементы в новый
        for (int i = 0; i < hashset.length; i++) {
            if (hashset[i] != null) {
                for (E e : hashset[i]) {
                    int index = getIndex(e);
                    if (newHashset[index] == null) {
                        newHashset[index] = new LinkedList<>(); // создаем новый лист
                    }
                    newHashset[index].add(e); // добавляем элемент в LinkedList
                }
            }
        }
        hashset = newHashset; // переопределили ссылку, garbage collector очистит память
    }

    private int getIndex(Object o) {
        int hashcode = o.hashCode(); // вычисляем hashcode элемента
        hashcode = hashcode >= 0 ? hashcode : -hashcode; // делаем его > 0
        return hashcode % capacity; // деление с остатком, вычисление индекса LinkedList
    }

    // O(1)
    @Override
    public boolean contains(Object o) {
        int index = getIndex(o);
        if (hashset[index] == null) {
            return false;
        }
        return hashset[index].contains(o); // проверяем наличие элемента
    }

    // O(1)
    @Override
    public boolean remove(Object o) {
        int index = getIndex(o);
        if (hashset[index] == null) {
            return false;
        }
        boolean res = hashset[index].remove(o);
        if (res) {
            size--;
        }
        return res;
    }

    // O(1)
    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            int totalCounter;
            int i;
            int j;

            @Override
            public boolean hasNext() {
                return totalCounter < size;
            }

            @Override
            public E next() {
                while (hashset[i] == null || hashset[i].isEmpty()) {
                    i++;
                }
                E res = hashset[i].get(j);
                totalCounter++;
                if (j < hashset[i].size() - 1) {
                    j++;
                } else {
                    i++;
                    j = 0;
                }
                return res;
            }
        };
    }
}
