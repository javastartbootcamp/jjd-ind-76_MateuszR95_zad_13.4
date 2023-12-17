package pl.javastart.task;

import java.util.Arrays;

// Uzupełnij klasę. Możesz ją dowolnie modyfikować.
// Celem jest, żeby przechodziły testy w src/test/java/[...]/CustomListTest
public class CustomList<T> {

    private int initialCapacity = 1;
    private Object[] array;
    private int size;

    public CustomList() {
        this.array = new Object[initialCapacity];
        this.size = 0;
    }

    public void add(T element) {
        ensureCapacity();
        array[size] = element;
        size++;
    }

    public void add(int index, T element) {
        checkIndexForAddingUnderIndex(index);
        ensureCapacity();

        for (int i = size - 1; i >= index; i--) {
            array[i + 1] = array[i];
        }
        array[index] = element;
        size++;
    }

    public T get(int index) {
        checkIndex(index);
        return (T) array[index];
    }

    public int size() {
        return size;
    }

    public void remove(int index) {
        checkIndex(index);
        for (int i = index; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }
        array[array.length - 1] = null;
        size--;

    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            if (i == size - 1) {
                builder.append(array[i]).append("]");
            } else {
                builder.append(array[i]).append(", ");
            }
        }
        return builder.toString();
    }

    private void ensureCapacity() {
        if (size == array.length) {
            array = Arrays.copyOf(array, array.length + 1);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Odwołujesz się do elementu wykraczającego poza zakres listy");
        }
    }

    private void checkIndexForAddingUnderIndex(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Chcesz dodać element pod nieistniejący indeks");
        }
    }
}
