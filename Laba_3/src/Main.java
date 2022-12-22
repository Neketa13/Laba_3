import java.util.Scanner;
import java.util.Comparator;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.*;
import java.lang.*;

public class Main {
    static Scanner first = new Scanner(System.in);
    static NumberFormat format = NumberFormat.getCurrencyInstance();
    static NumberFormat nf = NumberFormat.getPercentInstance(); //%
    static NumberFormat numberFormat1 = NumberFormat.getInstance();
    public static void main(String[] args) {
        //System.out.print("Input a n = ");
        System.out.println("Введите размерность матрицы:");
        int n = first.nextInt();
        System.out.println("Hello world!");
        Integer p=0;
        System.out.println("Введите индкс начального элемента для сортировки:");
        Integer f=first.nextInt();
        System.out.println("Введите индкс конечного элемента для сортировки:");
        Integer t=first.nextInt();

        Integer[]destination=null;
        Integer mas[][];
        mas = new Integer[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                mas[i][j] = (int) (Math.random() * 10);
            }
        System.out.println("Матрица с отсортированной первой строкой:");
        MyComparator comparer = new MyComparator();
        Arrays.sort(mas[0], f-1, t, comparer);

        System.out.println("Maтрица : "+mas.length+" на "+mas[0].length);
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas.length; j++) {
                System.out.print(numberFormat1.format(mas[i][j]) + " ");

            }System.out.println();
        }

        System.out.println();
        //int k= mas.length;
        System.out.println("Скопированный массив:");
        destination = copy(mas[0],f-1,t);
        for (int i = 0; i < destination.length; i++) {
            System.out.print(numberFormat1.format(destination[i]) + " ");
        }
        System.out.println();

int mas3[][];
        mas3= new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                p=mas[i][j];
                mas3[i][j]=mas[j][i];
                mas[j][i]=p;
            }

        System.out.println("Maтрица : "+mas3.length+" на "+mas3[0].length);
        for (int i = 0; i < mas3.length; i++) {
            for (int j = 0; j < mas3[0].length; j++) {

                System.out.print(numberFormat1.format(mas3[i][j]) + " ");
            }System.out.println();
        }

        int mas1[][];
        int s=1;
        mas1 = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if (i == j) {
                    mas1[i][j] = 0;
                } else {
                    mas1[i][j] = j + 1;
                }

            }



        System.out.println("Maтрица, с номерами строк, куда переходит данный элемент : "+mas1.length+" на "+mas1[0].length);
        for (int i = 0; i < mas1.length; i++) {
            for (int j = 0; j < mas1[0].length; j++) {
                System.out.print(format.format(mas1[i][j]) + " ");
            }System.out.println();
        }

        int mas2[][];
        mas2 = new int[n][n];
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++) {
                if(i==j)
                {
                    mas2[i][j]=0;
                }
                else {
                    mas2[i][j] = i + 1;
                }

            }

        System.out.println("Maтрица, с номерами столбцов, куда переходит данный элемент : "+mas2.length+" на "+mas2[0].length);
        for (int i = 0; i < mas2.length; i++) {
            for (int j = 0; j < mas2[0].length; j++) {
                System.out.print(nf.format(0.01*mas2[i][j]) + " ");
            }System.out.println();
        }

            }

    private static Integer[] copy(Integer[] source,int i,int j) {
        return Arrays.copyOfRange(source, i, j);
    }


    public static class MyComparator implements Comparator<Integer> {
        public int compare(Integer a, Integer b) {
            if (a.equals(b)) return 0;
            else if (a > b) return -1;
            else return 1;
        }

    }
}
