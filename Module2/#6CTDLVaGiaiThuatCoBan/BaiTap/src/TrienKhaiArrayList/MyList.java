package TrienKhaiArrayList;

import java.util.Arrays;

public class MyList<E> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private Object elements[];

    public MyList() {
    }

    //tao ra list voi size truyen vao
    public MyList(int capacity) {
        this.size = capacity;
        if (capacity > 0) {
            elements = new Object[capacity];
        } else throw new IllegalArgumentException("loi nhap do rong cua danh sach");
    }

    // tang size
    public void increaseSize() {
        elements = Arrays.copyOf(elements, ++size);
    }

    // giam size
    public void reduceSize() {
        elements = Arrays.copyOf(elements, --size);
    }

    // them 1 gia tri theo index
    public void add(int index, E element) {
        if (elements[index] != null) {
            increaseSize();
            for (int i = index; i < elements.length; i++) {
                elements[i + 1] = elements[i];
            }
        }
        elements[index] = element;
    }

    // lay ra gia tri theo index
    public Object get(int index) {
        return elements[index];
    }

    //xoa 1 phan tu
    public void remove(int index) {
        for (int i = index; i < elements.length - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[elements.length - 1] = null;
    }

    //them phan tu chi dinh vao cuoi danh sach
    public void add(int index) {
        if (elements[index] != null) {
            increaseSize();
            elements[size] = elements[index];
        } else throw new IllegalArgumentException("phan tu vua chi dinh khong ton tai");
    }

    //kiem tra ton tai trong mang 1 gia tri nhap vao
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                if (elements[i] == e || elements[i].equals(e)) {
                    return true;
                }
            }
        }
        return false;
    }

    //tra ve vi tri xuat hien dau tien
    public int indexOf(E e) {
        for (int i = 0; i < size; i++) {
            if (elements[i] != null) {
                if (elements[i] == e || elements[i].equals(e)) {
                    return i;
                }
            }
        }
        return -1;
    }

    //clear danh sach
    public void clear() {
        for (int i = 0; i < size; i++) {
            elements[i] = null;
        }
    }
}
