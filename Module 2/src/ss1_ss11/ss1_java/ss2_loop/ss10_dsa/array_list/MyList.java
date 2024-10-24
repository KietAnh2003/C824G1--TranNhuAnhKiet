package ss1_ss11.ss1_java.ss2_loop.ss10_dsa.array_list;

public class MyList<E> {
    private int size = 0;
    public static final int DEFAULT_CAPACITY = 10;
    public Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    public MyList(int capacity) {
        elements = new Object[capacity];
    }

    public void add(int index, E element) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    public E remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null;
        return removedElement;
    }

    public int size() {
        return size;
    }

    public MyList<E> clone() {
        MyList<E> clonedList = new MyList<>(size);
        System.arraycopy(this.elements, 0, clonedList.elements, 0, size);
        clonedList.size = this.size;
        return clonedList;
    }

    public boolean add(E e) {
        ensureCapacity(size + 1);
        elements[size++] = e;
        return true;
    }

    public int indexOf(E o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(elements[i])) {
                return i;
            }
        }
        return -1;
    }

    public void ensureCapacity(int minCapacity) {
        if (minCapacity > elements.length) {
            int newCapacity = Math.max(minCapacity, elements.length * 2);
            Object[] newElements = new Object[newCapacity];
            System.arraycopy(elements, 0, newElements, 0, size);
            elements = newElements;
        }
    }

    public E get(int i) {
        if (i >= size || i < 0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
        }
        return (E) elements[i];
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
        size = 0;
    }
}
