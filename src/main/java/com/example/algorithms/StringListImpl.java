package com.example.algorithms;

import java.util.Arrays;

public class StringListImpl implements StringList {
    private String[] data;
    private int size = 0;

    public StringListImpl() {
        this.data = new String[]{};
    }

    @Override
    public String add(String item) {
        return add(size, item);
    }

    @Override
    public String add(int index, String item) {
        checkValue(item);
        if (index > size || index < 0) {
            throw new IllegalArgumentException("Incorrect index");
        }
        if (size + 1 > data.length) {
            grow();
        }
        System.arraycopy(this.data, index, this.data, index + 1, size - index);
        this.data[index] = item;
        this.size++;
        return item;
    }

    @Override
    public String set(int index, String item) {
        checkIndex(index);
        checkValue(item);
        this.data[index] = item;
        return this.data[index];
    }

    @Override
    public String remove(String item) {
        checkValue(item);
        int elementIndex = indexOf(item);
        if (elementIndex == -1) {
            throw new IllegalArgumentException("Failed to find the element to remove");
        }
        return remove(elementIndex);

    }

    @Override
    public String remove(int index) {
        checkIndex(index);
        String removedElement = this.data[index];
        this.data[index] = null;
        if (index < size - 1) {
            System.arraycopy(this.data, index + 1, this.data, index, size - index - 1);
        }
        this.size--;
        return removedElement;
    }

    @Override
    public boolean contains(String item) {
        return indexOf(item) != -1;
    }

    @Override
    public int indexOf(String item) {
        checkValue(item);
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(String item) {
        checkValue(item);
        int lastIndex = -1;
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(item)) {
                lastIndex = i;
            }
        }
        return lastIndex;
    }


    @Override
    public String get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    @Override
    public boolean equals(StringList otherList) {
        if (otherList == null) {
            return false;
        }
        StringListImpl otherListImpl = (StringListImpl) otherList;
        if (otherListImpl.size != this.size) {
            return false;
        }
        for (int i = 0; i < size; i++) {
            if (!otherListImpl.data[i].equals(this.data[i])) {
                return false;
            }
        }
        return true;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            this.data[i] = null;
        }
        this.size = 0;
    }

    @Override
    public String[] toArray() {
        String[] strings = new String[this.size];
        System.arraycopy(this.data, 0, strings, 0, size);
        return strings;
    }

    private void checkValue(String item) {
        if (item == null) {
            throw new IllegalArgumentException("Value in the list can`t be null");
        }
    }

    private void checkIndex(int index) {
        if (index >= size || index < 0) {
            throw new IllegalArgumentException("Incorrect index");
        }

    }

    private void grow() {
        this.data = Arrays.copyOf(this.data, this.data.length + 1);
    }

}
