import java.util.Random;

public class Main {

    public static void InsertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }

    public static void QuickSort(int[] array, int low, int high) {

        int middle = low + ((high - low) / 2);
        int border = array[middle];

        int i = low, j = high;
        while(i <= j) {
            while(array[i] < border) i++;
            while(array[j] > border) j--;
            if(i <= j) {
                int swap = array[i];;
                array[i] = array[j];
                array[j] = swap;
                i++;
                j--;
            }
        }

        if(low < j) {
            QuickSort(array, low, j);
        }
        if(high > i) {
            QuickSort(array, i, high);
        }
    }

    public static void CombSort(int[] arr) {
        int n = arr.length;
        int gap = n;
        boolean swapped = true;
        double shrink = 1.3;
        
        while (gap > 1 || swapped) {
            gap = Math.max(1, (int)(gap / shrink));
            swapped = false;
            
            for (int i = 0; i + gap < n; i++) {
                if (arr[i] > arr[i + gap]) {
                    int temp = arr[i];
                    arr[i] = arr[i + gap];
                    arr[i + gap] = temp;
                    swapped = true;
                }
            }
        }
    }
    public static void CreateArray(int[] array, int min, int max) {
        Random rand = new Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = rand.nextInt(min, max);
        }
    }

    private static void Time(Runnable task) {
        long startTime = System.nanoTime();
        task.run();
        long endTime = System.nanoTime();
        System.out.println(endTime - startTime);
    }

    private static int[][] Copy(int[] array) {
        int[][] copyes = new int[3][];
        copyes[0] = array.clone();
        copyes[1] = array.clone();
        copyes[2] = array.clone();
        return copyes;
    }

    private static void SortTime(String arrayName, int[] mainArray) {
        System.out.println("\n" + arrayName + " (размер: " + mainArray.length + ")");

        int[][] copies = Copy(mainArray);

        System.out.print("Сортировка вставками: ");
        Time(() ->  InsertionSort(copies[0]));

        System.out.print("Быстрая сортировка: ");
        Time(() -> QuickSort(copies[1], 0, copies[1].length - 1));

        System.out.print("Cортировка расческой: ");
        Time(() -> CombSort(copies[2]));

        System.out.println("-".repeat(50));
    }

    public static void main(String[] args) {

        int[] smallAr = new int[30];
        CreateArray(smallAr, 1, 100);
        int[] middleAr = new int[100];
        CreateArray(middleAr, 1, 300);
        int[] bigAr = new int[1000];
        CreateArray(bigAr, 1, 2000);

        int[] randAr = {7, 3, 6, 2, 6, 9, 8, 1, 4, 3, 8, 6};
        int[] Ar75 = {2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9, 2, 6, 4, 8, 5};
        int[] revAr = {9, 8, 7, 6, 5, 4, 3, 2, 1, 0};
        int[] ArManyDup = {2, 3, 4, 7, 6, 6, 5, 4, 6, 5, 6, 7, 6, 8, 9, 8, 9, 1, 1};
        int[] Ar90 = {2, 5, 6, 7, 8, 9, 1, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 4, 3};
        
        SortTime("Маленький массив", smallAr);
        SortTime("Средний массив",  middleAr);
        SortTime("Большой массив", bigAr);

        SortTime("Случайный массив", randAr);
        SortTime("Массив отсортированный на 75%", Ar75);
        SortTime("Отсортированный наоборот массив", revAr);
        SortTime("Массив с 10% уникальных значений ", ArManyDup);
        SortTime("Массив отсортированный на 90%", Ar90);
    }
}