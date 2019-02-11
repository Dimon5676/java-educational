package semestr1.avp.lab3;

public class LStack<E> implements InterStack<E> {
    private Node<E> top = null;
    private int size = 0;

    public void show() {
        System.out.println("Your stack with " + size + " elements:");
        Node<E> temp = top;
        for (int i = 0; i < size; i++) {
            System.out.println(temp.element);
            temp = temp.next;
        }
    }

    public void push(E e) {
        top = new Node<E>(e, top);
        size++;
    }

    public void removeBottom() {
        Node<E> temp = top;
        for (int i = 0; i < size-1; i++) {
            temp = temp.next;
        }
        temp.next = null;
        size--;
    }

    public void minToZero() {
        int min = 1000000000;
        Node<E> temp = top;
        for (int i = 0; i < size; i++) {
            if (Integer.valueOf(temp.element.toString()).compareTo(min)<0){
                min = Integer.valueOf(temp.element.toString());
            }
            temp = temp.next;
        }
        temp = top;
        for (int i = 0; i < size; i++) {
            if (temp.element.equals(min)) {
                temp.element = (E) "0";
            }
            temp = temp.next;
        }
    }

    public E pop(E e) {
        Node<E> temp = top;
        for (int i = 0; i < size; i++) {
            if (temp.element.equals(e)) {
                if ((i+1) == size) {
                    removeBottom();
                    return e;
                } else {
                    temp.element = temp.next.element;
                    temp.next = temp.next.next;
                    size--;
                    return e;
                }
            }
            temp = temp.next;
        }
        return null;
    }

    public E top() {
        if (!isEmpty()) {
            return top.element;
        }
        return null;
    }

    public boolean isEmpty() {
        return top == null;
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
