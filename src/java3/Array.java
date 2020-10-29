package java3;

public interface Array<E> {

    void add(E value);

    boolean remove(E value);
    E remove(int index);

    E get(int index);

    int indexOf(E value);

    default boolean contains(E value) {
        return indexOf(value) != -1;
    }

    int size();

    default boolean isEmpty(){
        return size() == 0;
    }

    void show();

    void insert(E value, int index);

    void sortBubble();

    void sortSelect();

    void sortInsert();

    void copy(Array<E> InArray);
 }
