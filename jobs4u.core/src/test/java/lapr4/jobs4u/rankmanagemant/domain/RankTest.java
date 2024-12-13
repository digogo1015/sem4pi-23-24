package lapr4.jobs4u.rankmanagemant.domain;

import lapr4.jobs4u.rankmanagement.domain.Rank;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class RankTest {

    private final Rank r1 = new Rank(1);
    private final Rank r2 = new Rank(23);

    @Test
    public void testWithNullRank() {
        boolean check = true;
        try {
            Rank r = new Rank(null);
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void testNegativeRank() {
        boolean check = true;
        try {
            Rank r = new Rank(-10);
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }

    @Test
    public void testRankZero() {
        boolean check = true;
        try {
            Rank r = new Rank(0);
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assertFalse(check);
    }


    @Test
    public void validTest1() {
        boolean check = true;
        try {
            Rank r = new Rank(2);
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assert (check);
    }

    @Test
    public void validTest2() {
        boolean check = true;
        try {
            Rank r = new Rank(12);
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assert (check);
    }

    @Test
    public void validTest3() {
        boolean check = true;
        try {
            Rank r = new Rank(9);
        } catch (IllegalArgumentException e) {
            check = false;
        }
        assert (check);
    }

    @Test
    public void testEqualsWithDifferentNumber() {
        final boolean expected = r1.equals(r2);

        assertFalse(expected);
    }

    @Test
    public void testEqualsWithSameNumber() {
        final boolean expected = r1.equals(r1);

        assertTrue(expected);
    }

}