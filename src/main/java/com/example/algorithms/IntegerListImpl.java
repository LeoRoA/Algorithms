package com.example.algorithms;

import java.util.Arrays;

public class IntegerListImpl implements IntegerList {
    private Integer[] data;
    private int size = 0;
    private int arrLength = 0;

    public IntegerListImpl() {
        this.data = new Integer[]{};
    }

    @Override
    public Integer add(Integer item) {
        return add(size, item);
    }

    @Override
    public Integer add(int index, Integer item) {
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
    public Integer set(int index, Integer item) {
        checkIndex(index);
        checkValue(item);
        this.data[index] = item;
        return this.data[index];
    }

    @Override
    public Integer remove(Integer item) {
        checkValue(item);
        int elementIndex = indexOf(item);
        if (elementIndex == -1) {
            throw new IllegalArgumentException("Failed to find the element to remove");
        }
        return remove(elementIndex);

    }

    @Override
    public Integer remove(int index) {
        checkIndex(index);
        Integer removedElement = this.data[index];
        this.data[index] = null;
        if (index < size - 1) {
            System.arraycopy(this.data, index + 1, this.data, index, size - index - 1);
        }
        this.size--;
        return removedElement;
    }

    @Override
    public boolean contains(Integer item) {
        return indexOf(item) != -1;
    }

    public int binaryIndexOf(Integer item) {
        Integer[] array = toArray();
        sort(array);
        return binarySearch(array, item);
    }

    public int binaryIndexOfSortRecursionArray(Integer item) {
        Integer[] array = toArray();
        sortRecursion(array, 1, array.length);
        return binarySearch(array, item);
    }

    @Override
    public int indexOf(Integer item) {
        checkValue(item);
        for (int i = 0; i < this.size; i++) {
            if (this.data[i].equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Integer item) {
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
    public Integer get(int index) {
        checkIndex(index);
        return this.data[index];
    }

    @Override
    public boolean equals(IntegerList otherList) {
        if (otherList == null) {
            return false;
        }
        IntegerListImpl otherListImpl = (IntegerListImpl) otherList;
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
    public Integer[] toArray() {
        Integer[] strings = new Integer[this.size];
        System.arraycopy(this.data, 0, strings, 0, size);
        return strings;
    }

    private void sort(Integer[] array) {
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            int j = i;
            while (j > 0 && array[j - 1] >= temp) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = temp;
        }
    }

    private void sortRecursion(Integer[] array, int i, int n) {
        int value = array[i];
        int j = i;
        while (j > 0 && array[j - 1] > value) {
            array[j] = array[j - 1];
            j--;
        }
        array[j] = value;
        if (i + 1 < n) {
            sortRecursion(array, i + 1, n);
        }
    }

    private int binarySearch(Integer[] array, int element) {
        int min = 0;
        int max = array.length - 1;

        while (min <= max) {
            int mid = (min + max) / 2;

            if (element == array[mid]) {
                return mid;
            }

            if (element < array[mid]) {
                max = mid - 1;
            } else {
                min = mid + 1;
            }
        }
        return -1;

    }

    private void checkValue(Integer item) {
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
        if (this.size != 0) {
            int newSize = (int) Math.round(this.data.length * 1.5);
            this.data = Arrays.copyOf(this.data, newSize);
            arrLength = newSize;
        } else {
            this.data = Arrays.copyOf(this.data, this.data.length + 1);
            arrLength = 1;
        }
    }

    public int getArrLength() {
        return arrLength;
    }
}
