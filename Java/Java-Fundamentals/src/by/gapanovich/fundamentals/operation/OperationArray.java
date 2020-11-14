package by.gapanovich.fundamentals.operation;

public class OperationArray {
    public int sum(int[] array){
        int sum = 0;
        for (int value : array) {
            sum += value;
        }
        return sum;
    }

    public int multiplication(int[] array){
        int res = 1;
        for (int value : array) {
            res *= value;
        }
        return res;
    }
}
