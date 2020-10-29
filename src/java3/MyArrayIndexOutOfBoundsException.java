package java3;

public class MyArrayIndexOutOfBoundsException extends RuntimeException {
    public MyArrayIndexOutOfBoundsException(int index, int size) {
        super(String.format("Указанный индекс (%s) выходит за границы массива размерностью [%s]", index, size));
    }
}
