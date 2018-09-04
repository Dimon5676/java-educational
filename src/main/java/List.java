
public class List{
    private ListElement L; //Первый элемент списка

    void add_to_begin(int i) {
        ListElement a = new ListElement();
        a.data = i;
        if (L == null) {
            L = a;
        } else {
            ListElement b = new ListElement();
            b.next = L;
            b.data = i;
            L = b;
        }
    }
    void add_to_n(int i, int n) {
        ListElement a = new ListElement();
        ListElement temp = L;
        a.data = i;
        for (int j = 0; j < n-1; j++) {
            temp = temp.next;
        }
        a.next = temp.next;
        temp.next = a;
        a = temp;
    }
    void add_to_end(int i) {
        ListElement a = L;
        ListElement b = new ListElement();
        b.data = i;
        while (a.next != null) {
            a = a.next;
        }
        a.next = b;
    }
    void remove_from_begining() {
        L = L.next; // Т.к на предыдущий элемент исчезает указатель, java сама его удаляет
    }
    void remove_from_n(int n) {
        ListElement a = L;
        for (int i = 0; i < n-2; i++) {
            a = a.next;
        }
        a.next = a.next.next;
    }
    void remove_from_end() {
        ListElement a = L;
        while (a.next.next != null) {
            a = a.next;
        }
        a.next = null;
    }
    void find(int i) {
        ListElement a = L;
        while (a.next != null) {
            if (a.data == i) {
                System.out.println("Found: " + a.data);
            }
            a = a.next;
        }
    }
    void move(int k, int n) {
        ListElement a = L;
        int l;
        for (l = 0; l < k-2; l++) {
            a = a.next;
        }
        int what = a.next.data;
        l += 2;
        a = a.next.next;
        add_to_n(what, l-n-1);
        remove_from_n(l+1);
    }
    void printMe() {
        ListElement temp = L;
        while (temp != null) {
            System.out.println(temp.data);
            temp=temp.next;
        }
    }
}