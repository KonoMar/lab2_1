package edu.iis.mto.bsearch;

import org.junit.Assert;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BinarySearchTest {

    @Test
    public void shouldReturnTrueWhenOneElemIsInSequenceAndLenghtOfSequenceIsOne() {

        int key = 1;
        int[] seq = {1};
        assertTrue(isSorted(seq, 0));
        SearchResult result = BinarySearch.search(key, seq);
        assertEquals(key, seq[result.getPosition()]);
        assertThat(result.isFound(), is(true));

    }

    @Test
    public void shouldReturnFalseWhenNoElemIsInSequenceAndLenghtOfSequenceIsOne() {

        int key = 1;
        int[] seq = {2};
        assertTrue(isSorted(seq, 0));
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), is(false));

    }


    @Test
    public void elementShouldBeFoundIfIsInFirstPosition() {

        int key = 1;
        int[] seq = {1, 2, 3, 5, 7, 12};
        assertTrue(isSorted(seq, 0));
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.getPosition(), is(0));

    }

    @Test
    public void elementShouldBeFoundIfIsInLastOnePosition() {

        int key = 12;
        int[] seq = {1, 2, 3, 5, 7, 12};
        assertTrue(isSorted(seq, 0));
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.getPosition(), is(5));

    }

    @Test
    public void elementShouldBeFoundIfIsInTheMiddleInSequence() {

        int key = 12;
        int[] seq = {1, 2, 3, 5, 7, 12};
        assertTrue(isSorted(seq, 0));
        final int middlePosition = seq.length / 2;
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.getPosition(), is(middlePosition));

    }

    @Test
    public void elementShouldBeNotFoundIfElementIsNotInSequence() {

        int key = 12323;
        int[] seq = {1, 2, 3, 5, 7, 12};
        assertTrue(isSorted(seq, 0));
        SearchResult result = BinarySearch.search(key, seq);
        assertThat(result.isFound(), is(false));
    }


    public static boolean isSorted(int[] a, int start) {
        if (start == a.length - 1)
            return true;
        if (a[start] <= a[start + 1])
            return isSorted(a, start + 1);
        else
            return false;
    }


}