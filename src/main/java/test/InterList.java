package test;

public interface InterList<E> {
    void addToBegin(E element);
    void addToEnd(E element);
    E get(int index);
    void show();
}
