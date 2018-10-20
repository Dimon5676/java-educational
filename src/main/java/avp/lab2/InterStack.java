package avp.lab2;

public interface InterStack<E> {
    void show();
    void push(E e);
    void removeBottom();
    void minToZero();
    E pop(E e);
    E top();
    boolean isEmpty();
}
