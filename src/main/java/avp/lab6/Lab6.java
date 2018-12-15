package avp.lab6;

public class Lab6 {

    public static void main(String[] args) {
        new Lab6();
    }

    private Lab6() {
        int[] arr = new int[50];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 100);
        }
        System.out.println("Initial array:");
        display(arr);
        System.out.println("------------------");
        System.out.println("Insertion sort:");
        display(insertSort(arr));
        System.out.println("------------------");
        System.out.println("Bubble sort:");
        display(bubbleSort(arr));
        System.out.println("------------------");
        System.out.println("Choose sort:");
        display(sortChoose(arr));
        System.out.println("------------------");
    }

    private void display(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private int[] insertSort(int[] arr) {
        int[] result = arr.clone();

        for (int i = 1; i < result.length; i++){
            int elem = result[i];
            int j = i-1;
            while (j >= 0 && result[j] > elem) {
                result[j+1] = result[j];
                j--;
            }
            result[j+1] = elem;
        }

        return result;
    }

    private int[] bubbleSort(int[] arr) {
        int[] result = arr.clone();

        for (int i = 0; i < result.length-1; i++) {
            for (int j = 0; j < result.length-1-i; j++) {
                if (result[j] > result[j+1]) {
                    int temp = result[j];
                    result[j] = result[j+1];
                    result[j+1] = temp;
                }
            }
        }

        return result;
    }

    private int[] sortChoose(int[] arr) {
        int[] result = arr.clone();

        for (int min = 0; min < result.length - 1; min++) {
            int least = min;
            for (int j = min + 1; j < result.length; j++) {
                if (result[j] < result[least]) {
                    least = j;
                }
            }
            int tmp = result[min];
            result[min] = result[least];
            result[least] = tmp;
        }

        return result;
    }
}
