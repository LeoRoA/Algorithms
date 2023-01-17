package com.example.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;

public class IntegerListTest {
    private IntegerListImpl integerList;

    @BeforeEach
    public void setUp() {
        this.integerList = new IntegerListImpl();
    }

    @Test
    public void whenItemAddedThenItCanBeFoundedInList() {
        this.integerList.add(0);
        Assertions.assertEquals(1, this.integerList.size());
    }

    @Test
    public void whenItemAddedToSpecificIndexThenElementIsShiftedRight() {
        this.integerList.add(0);
        this.integerList.add(0, 1);
        this.integerList.add(1, 2);
        this.integerList.add(3, 3);
        Assertions.assertEquals(4, this.integerList.size());
        Assertions.assertEquals(3, this.integerList.get(3));
        Assertions.assertEquals(2, this.integerList.get(1));
        Assertions.assertEquals(0, this.integerList.get(2));
        Assertions.assertEquals(1, this.integerList.get(0));
    }

    @Test
    public void whenItemAddedAtIndexOverSizeThenException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.integerList.add(3, 0));
    }

    @Test
    public void whenItemAddedAtNegativeIndexThenException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.integerList.add(-1, 0));
    }

    @Test
    public void whenValueSetToSpecificIndexThenReturnsThisValue() {
        this.integerList.add(0);
        this.integerList.add(1);
        this.integerList.set(1, 13);
        Assertions.assertEquals(2, this.integerList.size());
        Assertions.assertEquals(13, this.integerList.get(1));
    }

    @Test
    public void whenAddedTwoElementsAndRemovedElementByValueThenSizeIsOne() {
        this.integerList.add(0);
        this.integerList.add(1, 2);
        this.integerList.remove(Integer.valueOf("0"));
        Assertions.assertEquals(1, this.integerList.size());
        Assertions.assertEquals(2, this.integerList.get(0));
    }

    @Test
    public void whenAddedTwoElementsAndRemovedElementByIncorrectValueThenExceptionAndSizeIsTwo() {
        this.integerList.add(0);
        this.integerList.add(1, 2);
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.integerList.remove(Integer.valueOf("1")));
        Assertions.assertEquals(2, this.integerList.size());

    }

    @Test
    public void whenAddedThreeElementsAndRemovedFirstElementThenSizeIsTwo() {
        this.integerList.add(1);
        this.integerList.add(1, 2);
        this.integerList.add(2, 3);
        Assertions.assertEquals(3, this.integerList.size());
        this.integerList.remove(0);
        Assertions.assertEquals(2, this.integerList.size());
        Assertions.assertEquals(2, this.integerList.get(0));
    }

    @Test
    public void whenAddedThreeElementsAndRemovedSecondElementThenSizeIsTwo() {
        this.integerList.add(0);
        this.integerList.add(1, 1);
        this.integerList.add(2, 2);
        Assertions.assertEquals(3, this.integerList.size());
        this.integerList.remove(1);
        Assertions.assertEquals(2, this.integerList.size());
        Assertions.assertEquals(2, this.integerList.get(1));
    }

    @Test
    public void whenAddedThreeElementsAndRemovedLastElementThenSizeIsTwo() {
        this.integerList.add(0);
        this.integerList.add(1, 1);
        this.integerList.add(2, 2);
        Assertions.assertEquals(3, this.integerList.size());
        this.integerList.remove(2);
        Assertions.assertEquals(2, this.integerList.size());
        Assertions.assertEquals(1, this.integerList.get(1));
    }

    @Test
    public void whenAddedSeveralElementsAndTriedCheckContainsByValueInListThenReturnsTrueOrFalse() {
        this.integerList.add(0);
        this.integerList.add(1, 1);
        this.integerList.add(2, 2);
        Assertions.assertTrue(this.integerList.contains(1));
        Assertions.assertFalse(this.integerList.contains(4));
    }

    @Test
    public void whenAddedSevenMixedElementsInListThenSortAndFindIndexOfElement() {
        this.integerList.add(3);
        this.integerList.add(6);
        this.integerList.add(0);
        this.integerList.add(4);
        this.integerList.add(1);
        this.integerList.add(5);
        this.integerList.add(2);
        Assertions.assertEquals(2, this.integerList.binaryIndexOf(2));
    }

    @Test
    public void whenAddedTwoSameElementsInListThenReturnsFirstIndex() {
        this.integerList.add(1);
        this.integerList.add(1);
        Assertions.assertEquals(2, this.integerList.size());
        Assertions.assertEquals(0, this.integerList.indexOf(1));
    }

    @Test
    public void whenAddedSeveralElementsInListThenIndexOfUnknownReturnsMinusOne() {
        this.integerList.add(0);
        this.integerList.add(1);
        this.integerList.add(2);
        Assertions.assertEquals(3, this.integerList.size());
        Assertions.assertEquals(-1, this.integerList.indexOf(MIN_VALUE));
    }


    @Test
    public void whenAddedTwoSameElementsInListThenReturnsLastIndex() {
        this.integerList.add(2);
        this.integerList.add(2);
        Assertions.assertEquals(2, this.integerList.size());
        Assertions.assertEquals(1, this.integerList.lastIndexOf(2));
    }

    @Test
    public void whenAddedThreeElementsInListThenLastIndexOfUnknownReturnsMinusOne() {
        this.integerList.add(0);
        this.integerList.add(1);
        this.integerList.add(2);
        Assertions.assertEquals(3, this.integerList.size());
        Assertions.assertEquals(-1, this.integerList.lastIndexOf(MAX_VALUE));
    }

    @Test
    public void whenAddedThreeElementsInListThenReturnsValueByIndex() {
        this.integerList.add(0);
        this.integerList.add(1);
        this.integerList.add(2);
        Assertions.assertEquals(3, this.integerList.size());
        Assertions.assertEquals(1, this.integerList.get(1));

    }

    @Test
    public void whenAddedThreeElementsInListAndCheckedByEqualsWithOtherListThenReturnsTrueOrFalse() {
        IntegerListImpl otherListImpl = new IntegerListImpl();
        otherListImpl.add(1);
        otherListImpl.add(2);
        otherListImpl.add(3);

        this.integerList.add(1);
        this.integerList.add(2);
        this.integerList.add(3);

        Assertions.assertTrue(this.integerList.equals(otherListImpl));
    }

    @Test
    public void whenAddedThreeElementsThenCheckSizeWithIncorrectSizeIsFalse() {
        this.integerList.add(0);
        this.integerList.add(1);
        this.integerList.add(2);
        Assertions.assertNotEquals(4, this.integerList.size());
    }


    @Test
    public void whenClearListThenItIsEmpty() {
        this.integerList.add(0);
        this.integerList.add(1);
        this.integerList.add(2);
        Assertions.assertEquals(3, this.integerList.size());
        this.integerList.clear();
        Assertions.assertTrue(this.integerList.isEmpty());
        Assertions.assertEquals(0, this.integerList.size());
    }

    @Test
    public void whenCheckedListWithOneValueThenIsEmptyFalse() {
        this.integerList.add(0);
        Assertions.assertFalse(this.integerList.isEmpty());
    }

    @Test
    public void whenStringListToArrayThenCheckEqualsWithNewArray() {
        this.integerList.add(1);
        this.integerList.add(2);
        this.integerList.add(3);
        Assertions.assertArrayEquals(new Integer[]{1, 2, 3},
                integerList.toArray());
    }

    @Test
    public void whenStringListToArrayThenCheckEqualsWithNewWrongArray() {
        this.integerList.add(1);
        this.integerList.add(2);
        this.integerList.add(3);
        Assertions.assertNotEquals(new Integer[]{2, 1, 3},
                integerList.toArray());
    }

    @Test
    public void whenSizeIsOverThenSizeGrowsInOneAndHalf() {
        this.integerList.add(1);
        Assertions.assertEquals(1, this.integerList.getArrLength());
        this.integerList.add(2);
        Assertions.assertEquals(2, this.integerList.getArrLength());
        this.integerList.add(3);
        Assertions.assertEquals(3, this.integerList.getArrLength());
        this.integerList.add(4);
        Assertions.assertEquals(5, this.integerList.getArrLength());
    }

    @Test
    public void AddedSevenMixedElementsInListAndUsedSortRecursionThenSortAndFindIndexOfElement() {
        this.integerList.add(3);
        this.integerList.add(6);
        this.integerList.add(0);
        this.integerList.add(4);
        this.integerList.add(1);
        this.integerList.add(5);
        this.integerList.add(2);
        Assertions.assertEquals(2, this.integerList.binaryIndexOfSortRecursionArray(2));
    }
}
