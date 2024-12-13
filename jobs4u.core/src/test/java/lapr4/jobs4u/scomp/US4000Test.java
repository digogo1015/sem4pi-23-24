package lapr4.jobs4u.scomp;

import lapr4.jobs4u.scomp.US4000.US4000;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class US4000Test {


    @Test
    public void directoryDoesNotExistTest() {

        boolean expected;

        try {
            US4000.CountWords("RandomName");
            expected = true;
        } catch (Exception ex) {
            expected = false;
        }

        assertFalse(expected);

    }

    @Test
    public void pathIsNotOfDirectory() {

        boolean expected;

        try {
            US4000.CountWords("src/main/java/lapr4/jobs4u/scomp/applicationFiles/test1/test-1.txt");
            expected = true;
        } catch (Exception ex) {
            expected = false;
        }

        assertFalse(expected);

    }


    @Test
    public void directoryTest1() {

        List<String> list = US4000.CountWords("src/main/java/lapr4/jobs4u/scomp/applicationFiles/test1");

        for (String ele : list) {
            System.out.println(ele);
        }

    }

    @Test
    public void directoryTest2() {

        List<String> list = US4000.CountWords("src/main/java/lapr4/jobs4u/scomp/applicationFiles/test2");

        for (String ele : list) {
            System.out.println(ele);
        }

    }

}