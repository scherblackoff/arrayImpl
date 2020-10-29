package java3;

import java.util.Arrays;

public class ArrayImpl<E extends Comparable<? super E>> implements Array<E> {

    private E[] data;
    private int size;
    private static final int DEFAULT_CAPACITY = 8;


    public ArrayImpl() {
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    public ArrayImpl(int capacity) {
        this.data = (E[]) new Comparable[capacity];
    }

    @Override
    public void add(E value) {
        checkAndGrow();
        data[size++] = value;
    }

    @Override
    public void insert(E value, int index) {
        checkAndGrow();
        if (index == size) {
            add(value);
        } else {
            checkIndex(index);
            if (size - index >= 0) {
                System.arraycopy(data, index, data, index + 1, size - index);
            }
            data[index] = value;
            size++;
        }
    }

    @Override
    public void sortBubble(){
        for (int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - 1 - i; j++) {
                if(data[j].compareTo(data[j + 1]) > 0){
                    swap(j,j + 1);
                }
            }
        }
    }

    @Override
    public void sortSelect() {
        for (int i = 0; i < size - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < size; j++) {
                if (data[j].compareTo(data[minIndex]) < 0){
                    minIndex = j;
                }
            }
            swap(minIndex, i);
        }
    }

    @Override
    public void sortInsert() {
        for (int i = 1; i < size; i++) {
            E temp = data[i];
            int in = i;
            while(in > 0 && data[in - 1].compareTo(temp) >= 0){
                data[in] = data[in - 1];
                in--;
            }
            data[in] = temp;
        }
    }

    @Override
    public boolean remove(E value) {
        int index = indexOf(value);
        return remove(index) != null && index != -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E deleteValue = data[index];
        if (size - 1 - index >= 0) {
            System.arraycopy(data, index + 1, data, index, size - 1 - index);
        }
        data[size - 1] = null;
        size--;
        return deleteValue;
    }

    @Override
    public E get(int index) {
        return data[index];
    }

    @Override
    public int indexOf(E value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void show() {
        System.out.println(toString());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("[");
        for (int i = 0; i < size - 1; i++) {
            stringBuilder.append(data[i]);
            stringBuilder.append(", ");
        }
        if (size > 0) {
            stringBuilder.append(data[size - 1]);
        }
        stringBuilder.append("]");
        return String.valueOf(stringBuilder);
    }

    private void checkAndGrow() {
        if (data.length == size) {
            data = Arrays.copyOf(data, calculateSize());
        }
    }

    private int calculateSize() {
        return size > 0 ? size * 2 : 1;
    }

    private void checkIndex(int index) throws MyArrayIndexOutOfBoundsException {
        if (index < 0 || index > size) {
            throw new MyArrayIndexOutOfBoundsException(index, size);
        }
    }

    private void swap(int a, int b) {
        E temp = data[a];
        data[a] = data[b];
        data[b] = temp;
    }

    @Override
    public void copy(Array<E> InArray) {
        for (int i = 0; i < size; i++) {
            InArray.add(get(i));
        }
    }
}
