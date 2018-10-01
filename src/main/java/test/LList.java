package test;

public class LList<E> implements InterList<E> {
    Node<E> first;
    static int size = 0;

    public void addToBegin(E element) {
        Node<E> meow = new Node<E>(element, first);
        first = meow;
        size++;
    }

    public void addToN(E element, int n) {
        Node<E> temp = first;
        for (int i = 0; i < n-1; i++) {
            temp = temp.next;
        }
        Node<E> meow = new Node<E>(element, temp.next);
        temp.next = meow;
        size++;
    }

    public void addToEnd(E element) {
        Node<E> meow = new Node<E>(element, null);
        Node<E> temp = first;
        if (first == null) {
            first = new Node<E>(element, null);
        } else {
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = meow;
        }
        size++;
    }

    public void removeFromBegin() {
        first = first.next;
        size--;
    }

    public void removeFromN(int n) {
        Node<E> temp = first;
        for (int i = 0; i < n-1; i++) {
            temp = temp.next;
        }
        temp.next = temp.next.next;
        size--;
    }

    public void removeFromEnd() {
        Node<E> temp = first;
        for (int i = 0; i < size-1; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public E get(int index) {
        Node<E> temp = first;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }
        return temp.element;
    }

    public void show() {
        Node<E> temp = first;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }

    public void find(E element) {
        Node<E> temp = first;
        for (int i = 0; i < size; i++) {
            if (temp.element == element) {
                System.out.println("Found: " + temp.element);
            }
            temp = temp.next;
        }
    }

    public void move(int k, int n) {
        Node<E> temp = first;
        for (int i = 0; i < k-1; i++) {
            temp = temp.next;
        }
        removeFromN(k-1);
        addToN(temp.element, k-1-n);
    }


    private class  Node<E> {
        private E element;
        Node<E>  next;

        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
