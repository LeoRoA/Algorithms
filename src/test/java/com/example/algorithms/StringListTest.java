package com.example.algorithms;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class StringListTest {

    private StringList stringList;

    @BeforeEach
    public void setUp() {
        this.stringList = new StringListImpl();
    }

    @Test
    public void whenItemAddedThenItCanBeFoundedInList() {
        this.stringList.add("first");
        Assertions.assertEquals(1, this.stringList.size());
    }

    @Test
    public void whenItemAddedToSpecificIndexThenElementIsShiftedRight() {
        this.stringList.add("test");
        this.stringList.add(0, "first");
        this.stringList.add(1, "middle");
        this.stringList.add(3, "last");
        Assertions.assertEquals(4, this.stringList.size());
        Assertions.assertEquals("last", this.stringList.get(3));
        Assertions.assertEquals("middle", this.stringList.get(1));
        Assertions.assertEquals("test", this.stringList.get(2));
        Assertions.assertEquals("first", this.stringList.get(0));
    }

    @Test
    public void whenItemAddedAtIndexOverSizeThenException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.stringList.add(3, "test"));
    }

    @Test
    public void whenItemAddedAtNegativeIndexThenException() {
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.stringList.add(-1, "test"));
    }

    @Test
    public void whenValueSetToSpecificIndexThenReturnsThisValue() {
        this.stringList.add("test");
        this.stringList.add("test2");
        this.stringList.set(1, "successSetting");
        Assertions.assertEquals(2, this.stringList.size());
        Assertions.assertEquals("successSetting", this.stringList.get(1));
    }

    @Test
    public void whenAddedTwoElementsAndRemovedElementByValueThenSizeIsOne() {
        this.stringList.add("first");
        this.stringList.add(1, "last");
        this.stringList.remove("first");
        Assertions.assertEquals(1, this.stringList.size());
        Assertions.assertEquals("last", this.stringList.get(0));
    }

    @Test
    public void whenAddedTwoElementsAndRemovedElementByIncorrectValueThenExceptionAndSizeIsTwo() {
        this.stringList.add("first");
        this.stringList.add(1, "last");
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> this.stringList.remove("firts"));
        Assertions.assertEquals(2, this.stringList.size());

    }

    @Test
    public void whenAddedThreeElementsAndRemovedFirstElementThenSizeIsTwo() {
        this.stringList.add("first");
        this.stringList.add(1, "middle");
        this.stringList.add(2, "last");
        Assertions.assertEquals(3, this.stringList.size());
        this.stringList.remove(0);
        Assertions.assertEquals(2, this.stringList.size());
        Assertions.assertEquals("middle", this.stringList.get(0));
    }

    @Test
    public void whenAddedThreeElementsAndRemovedSecondElementThenSizeIsTwo() {
        this.stringList.add("first");
        this.stringList.add(1, "middle");
        this.stringList.add(2, "last");
        Assertions.assertEquals(3, this.stringList.size());
        this.stringList.remove(1);
        Assertions.assertEquals(2, this.stringList.size());
        Assertions.assertEquals("last", this.stringList.get(1));
    }

    @Test
    public void whenAddedThreeElementsAndRemovedLastElementThenSizeIsTwo() {
        this.stringList.add("first");
        this.stringList.add(1, "middle");
        this.stringList.add(2, "last");
        Assertions.assertEquals(3, this.stringList.size());
        this.stringList.remove(2);
        Assertions.assertEquals(2, this.stringList.size());
        Assertions.assertEquals("middle", this.stringList.get(1));
    }

    @Test
    public void whenAddedSeveralElementsAndTriedCheckContainsByValueInListThenReturnsTrueOrFalse() {
        this.stringList.add("first");
        this.stringList.add(1, "middle");
        this.stringList.add(2, "last");
        Assertions.assertTrue(this.stringList.contains("middle"));
        Assertions.assertFalse(this.stringList.contains("second"));
    }

    @Test
    public void whenAddedTwoSameElementsInListThenReturnsFirstIndex() {
        this.stringList.add("test1");
        this.stringList.add("test1");
        Assertions.assertEquals(2, this.stringList.size());
        Assertions.assertEquals(0, this.stringList.indexOf("test1"));
    }

    @Test
    public void whenAddedSeveralElementsInListThenIndexOfUnknownReturnsMinusOne() {
        this.stringList.add("test");
        this.stringList.add("test1");
        this.stringList.add("test2");
        Assertions.assertEquals(3, this.stringList.size());
        Assertions.assertEquals(-1, this.stringList.indexOf("NON_EXISTING_VALUE"));
    }

    @Test
    public void whenAddedTwoSameElementsInListThenReturnsLastIndex() {
        this.stringList.add("test2");
        this.stringList.add("test2");
        Assertions.assertEquals(2, this.stringList.size());
        Assertions.assertEquals(1, this.stringList.lastIndexOf("test2"));
    }

    @Test
    public void whenAddedThreeElementsInListThenLastIndexOfUnknownReturnsMinusOne() {
        this.stringList.add("test");
        this.stringList.add("test1");
        this.stringList.add("test2");
        Assertions.assertEquals(3, this.stringList.size());
        Assertions.assertEquals(-1, this.stringList.lastIndexOf("NON_EXISTING_VALUE"));
    }

    @Test
    public void whenAddedThreeElementsInListThenReturnsValueByIndex() {
        this.stringList.add("test");
        this.stringList.add("test1");
        this.stringList.add("test2");
        Assertions.assertEquals(3, this.stringList.size());
        Assertions.assertEquals("test1", this.stringList.get(1));

    }

    @Test
    public void whenAddedThreeElementsInListAndCheckedByEqualsWithOtherListThenReturnsTrueOrFalse() {
        StringListImpl otherListImpl = new StringListImpl();
        otherListImpl.add("test");
        otherListImpl.add("test1");
        otherListImpl.add("test2");

        this.stringList.add("test");
        this.stringList.add("test1");
        this.stringList.add("test2");

        Assertions.assertTrue(this.stringList.equals(otherListImpl));
    }

    @Test
    public void whenAddedThreeElementsThenCheckSizeWithIncorrectSizeIsFalse() {
        this.stringList.add("test");
        this.stringList.add("test1");
        this.stringList.add("test2");
        Assertions.assertNotEquals(2, this.stringList.size());
    }


    @Test
    public void whenClearListThenItIsEmpty() {
        this.stringList.add("test");
        this.stringList.add("test1");
        this.stringList.add("test2");
        Assertions.assertEquals(3, this.stringList.size());
        this.stringList.clear();
        Assertions.assertTrue(this.stringList.isEmpty());
        Assertions.assertEquals(0, this.stringList.size());
    }

    @Test
    public void whenCheckedListWithOneValueThenIsEmptyFalse() {
        this.stringList.add("test");
        Assertions.assertFalse(this.stringList.isEmpty());
    }

    @Test
    public void whenStringListToArrayThenCheckEqualsWithNewArray() {
        this.stringList.add("test1");
        this.stringList.add("test2");
        this.stringList.add("test3");
        Assertions.assertArrayEquals(new String[]{"test1", "test2", "test3"},
                stringList.toArray());
    }

    @Test
    public void whenStringListToArrayThenCheckEqualsWithNewWrongArray() {
        this.stringList.add("test1");
        this.stringList.add("test2");
        this.stringList.add("test3");
        Assertions.assertNotEquals(new String[]{"test2", "test1", "test3"},
                stringList.toArray());
    }
}
