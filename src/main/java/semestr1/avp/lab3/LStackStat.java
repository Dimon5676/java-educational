package semestr1.avp.lab3;

public class LStackStat {

    private int[] stack;
    private int size;
    private int filled = 0;

    public LStackStat(int n) {
       stack  = new int[n];
       this.size = n;
    }

    public void show() {
        for (int i : stack) {
            System.out.println(i);
        }
    }

    public void push(int e) {
        for (int i = 0; i < size-1; i++) {
            stack[i] = stack[i+1];
        }
        stack[size-1] = e;
    }

    public void minToZero() {
        int min = 999999999;
        for (int i : stack) {
            if (i < min) min = i;
        }
        for (int i = 0; i < size; i++) {
            if (stack[i] == min) stack[i] = 0;
        }
    }

    public int pop(int e) {
        int index = -1;
        int val = 0;
        for (int i = 0; i < size; i++) {
            if (stack[i] == e) {
                index = i;
                val = stack[i];
            }
        }
        if (index >= 0) {
            for (int i = index; i > 0; i--) {
                stack[i] = stack[i - 1];
            }
            stack[0] = 0;
            return val;
        }
        return 0;
    }

    public int top() {
        return stack[0];
    }

    public boolean isEmpty() {
        int sum = 0;
        for (int i : stack) {
            sum += i;
        }
        if (sum == 0) return true;
        return false;
    }
}
