import java.util.Scanner;

public class BinarySearch {
    void method(){
        int[] array = init();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the target of search:");
        int t = scanner.nextInt();
        int first = 0;
        int last = array.length - 1;
        int middle = array.length / 2;
        int target;
        if(array[0] < array[array.length - 1]){
            target = search(array, first, last, t, true);
        }
        else {
            target = search(array, first, last, t, false);
        }
        if(target > -1){
            System.out.println("The first founded target element`s position is " + target);
        }
        else {
            System.out.println("No matches found");
        }
    }
    int search(int[] arr, int f, int l, int t, boolean m){
        int mid = f + (l - f) / 2;
        if(l >= f) {
            if (m) {
                if (t == arr[mid]) {
                    return mid;
                } else {
                    if (t < arr[mid]) {
                        return search(arr, f, mid, t, m);
                    } else {
                        return search(arr, (mid + 1), l, t, m);
                    }
                }
            } else {
                if (t == arr[mid]) {
                    return mid;
                } else {
                    if (t < arr[mid]) {
                        return search(arr, (mid + 1), l, t, m);
                    } else {
                        return search(arr, f, mid, t, m);
                    }
                }
            }
        }
        return -1;
    }
    int[] init(){
        Scanner scanner = new Scanner(System.in);
        int n;
        int [] massive;
        boolean isSorted = false;
        do {
            System.out.println("Enter the length of the massive");
            n = scanner.nextInt();
            System.out.println("Enter the sorted massive of integers");
            massive = new int[n];
            for (int i = 0; i < n; i++) {
                massive[i] = scanner.nextInt();
            }
            if(n > 1) {
                for (int i = 0; i < n - 1; i++) {
                    if (massive[i] > massive[i + 1]) {
                        break;
                    }
                    if (i == n - 2) {
                        isSorted = true;
                    }
                }
                for (int i = 0; i < n - 1; i++) {
                    if (massive[i] < massive[i + 1]) {
                        break;
                    }
                    if (i == n - 2) {
                        isSorted = true;
                    }
                }
                if(massive[0] == massive[n - 1]){
                    isSorted = false;
                    System.out.println("All the elements of the massive are equal");
                }
            }
            else {
                System.out.println("The length of the array is less than 2");
            }
            if(!isSorted){
                System.out.println("The massive is not sorted or too short, some more attention, please :)");
            }
        } while(!isSorted);
        return massive;
    }
}
