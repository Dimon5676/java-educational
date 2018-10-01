package avp.lab1;

public interface InterList<E> {
    void addToBegin(E element);
    void addToN(E element, int n);
    void addToEnd(E element);
    void removeFromBegin();
    void removeFromN(int n);
    void removeFromEnd();
    E get(int index);
    void show();
    void find(E element);
    void move(int k, int n);
}
