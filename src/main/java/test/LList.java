package test;

public class LList<E> implements InterList<E> {
    Node<E> first;
    int size = 0;

    public void addToBegin(E element) {
        Node<E> meow = new Node<E>(element, first);
        first = meow;
        size++;
    }

    public void addToEnd(E element) {
        Node<E> meow = new Node<E>(element, null);
        Node<E> temp = first;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = meow;
        size++;
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


    private class  Node<E> {
        private E element;
        Node<E>  next;

        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
