package set.interfaces;

public interface ISet<E> extends Iterable<E> {

    boolean add(E element);

    boolean contains(Object o);

    boolean remove(Object o);

    int size();
}
