package by.gapanovich.fundamentals.main;

import by.gapanovich.fundamentals.classes.ArrayNumbers;
import by.gapanovich.fundamentals.classes.HelloClass;
import by.gapanovich.fundamentals.filter.StringFilter;
import by.gapanovich.fundamentals.operation.OperationArray;
import by.gapanovich.fundamentals.reader.InfoReader;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        /*  Task 1  */
        /*  Приветствовать любого пользователя при вводе его имени через командную строку.  */
        System.out.println("Hello, enter user name, please:");
        Scanner scan = new Scanner(System.in);
        String userName = scan.nextLine();

        HelloClass user = new HelloClass();
        user.helloUser(userName);


        /*  Task 2  */
        /*   Отобразить в окне консоли аргументы командной строки в обратном порядке.   */
        System.out.println("\n\nEnter the string of args:");
        StringBuffer strArgs = new StringBuffer(scan.nextLine());
        strArgs.reverse();
        System.out.println(strArgs);


        /*  Task 3  */
        /*    Вывести заданное количество случайных чисел с переходом и без перехода на новую строку    */
        System.out.println("\n\nEnter the size of the array:");
        int size = scan.nextInt();
        System.out.println("Array creation in progress...");
        System.out.println("Initial array:");
        ArrayNumbers arr = new ArrayNumbers();
        double[] numbers = arr.randomFillArray(size);
        arr.print(numbers);
        System.out.println("Reverse array:");
        arr.printReverse(numbers);

        /*   Task 4 */
        /*  Ввести целые числа как аргументы командной строки, подсчитать их сумму (произведение)
            и вывести результат на консоль. */
        String[] strings;
        System.out.println("Enter the numbers: ");
        InfoReader reader = new InfoReader();
        strings = reader.readStringArray(System.in);
        StringFilter filter = new StringFilter();
        String[] strNumbers = filter.filterInt(strings);
        ArrayNumbers creator = new ArrayNumbers();
        int[] array = creator.factoryArray(strNumbers);
        System.out.println("Filtered array:");
        System.out.println(Arrays.toString(array));
        OperationArray oper = new OperationArray();
        int sum = oper.sum(array);
        System.out.println("sum = " + sum);
        int product = oper.multiplication(array);
        System.out.println("mult = " + product);

        /*  Task 5  */
        /* Ввести число от 1 до 12. Вывести на консоль название месяца, соответствующего данному числу.
         Осуществить проверку корректности ввода чисел. */
        System.out.println("Enter the month number");
        int number = scan.nextInt();
        while(number < 1 || number > 12){
            System.out.println("Incorrect input! Try again!");
            number = scan.nextInt();
        }

        switch (number){
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Incorrect input");
                break;
        }
    }
}