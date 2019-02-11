package semestr1.avp.lab1;

public interface InterList<E> {
    void addToBegin(E element);
    void addToN(E element, int n);
    void addToEnd(E element);
    void removeFromBegin();
    void removeFromN(int n);
    void removeFromEnd();
    boolean contains(E e);
    void show();
    void find(E element);
    void move(int k, int n);
//    void build(int from, int til);
}
