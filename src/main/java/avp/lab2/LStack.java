package avp.lab2;

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
        for (int i = 0; i < n-2; i++) {
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
        if (n <= 1) {
            removeFromBegin();
        } else {
            Node<E> temp = first;
            for (int i = 0; i < n - 2; i++) {
                temp = temp.next;
            }
            temp.next = temp.next.next;
        }
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

    public boolean contains(E e) {
        boolean cont = false;
        Node<E> temp = first;
        while (temp.next != null) {
            if (temp.element == e) {
                cont = true;
            } else {
                cont = false;
            }
            temp = temp.next;
        }
        return cont;
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
        removeFromN(k);
        addToN(temp.element, k-n);
    }

//    public void build(int from, int til) {
//        LList<Integer> range = new LList<Integer>();
//        LList<E> list1 = new LList<E>();
//        LList<E> list2 = new LList<E>();
//        for (int i = from; i <= til; i++) {
//            range.addToEnd(i);
//        }
//        Node<E> temp = first;
//        while (temp.next.next != null) {
//            if (range.contains((Integer) temp.element)) {
//                list1.addToEnd(temp.element);
//            } else {
//                list2.addToEnd(temp.element);
//            }
//            temp = temp.next;
//        }
//        System.out.println("List that contains range");
//        list1.show();
//        System.out.println("List that doesn't contain range");
//        list2.show();
//    }


    private class  Node<E> {
        private E element;
        Node<E>  next;

        private Node(E element, Node<E> next) {
            this.element = element;
            this.next = next;
        }
    }
}
