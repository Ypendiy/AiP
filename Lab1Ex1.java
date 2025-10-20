import java.util.Scanner;
public class Main
{
    public static void main(String[] args) {
        System.out.print("Введите длину массива ");
        Scanner scan = new Scanner(System.in);
        int lar = scan.nextInt();
        int[] ar = new int[lar];
        System.out.print("Введите " + lar + " чисел через пробел: ");
        for (int i = 0; i < lar; i++) {
            ar[i] = scan.nextInt();}
        int[] bar = new int[lar];
        int ind = 0;
        for (int i = 1; i < lar; i += 2) {
            bar[ind] = ar[i];ind++; }
        for (int i = 0; i < lar; i += 2) {
            bar[ind] = ar[i];ind++; }
        System.out.print("Новый массив: ");
        for (int i = 0; i < lar; i++) {System.out.print(bar[i] + " ");}
    }
}