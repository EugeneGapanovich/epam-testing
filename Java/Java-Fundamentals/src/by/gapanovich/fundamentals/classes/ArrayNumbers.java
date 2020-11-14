package by.gapanovich.fundamentals.classes;

public class ArrayNumbers {

    public static final int START = -100;
    public static final int END = 100;

    public double[] randomFillArray(int size){
        double[] array = new double[size];
        for (int i = 0; i < size; i++){
            array[i] = ( Math.random() * (END-START) ) + START;
        }
        return array;
    }

    public void printReverse(double[] array){
        for (int i = array.length - 1; i > 0; i--){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[0]);
    }

    public void print(double[] array){
        for (int i = 0; i < array.length - 1; i++){
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[array.length - 1]);
    }

    public int[] factoryArray(String[] values){
        int[] result = new int[values.length];
        for (int i = 0; i < values.length ; i++) {
            result[i] = Integer.parseInt(values[i]);
        }
        return  result;
    }
}
