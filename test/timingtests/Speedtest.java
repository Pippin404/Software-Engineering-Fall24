package timingtests;

import org.junit.jupiter.api.Test;

public class Speedtest {

    @SuppressWarnings("unused")
    @Test
    public static void testCodeSpeed() {

        // TODO: Make 2 methods, one faster one slower

        // here is one test; FASTER ONE
        long timeStart1 = System.currentTimeMillis();
        // do method one
        long timeEnd1 = System.currentTimeMillis();

        // test2 SLOWER ONE
        long timeStart2 = System.currentTimeMillis();
        // do method two
        long timeEnd2 = System.currentTimeMillis();

        long totalTime1 = timeStart1 - timeEnd1;
        long totalTime2 = timeStart2 - timeEnd2;
        // compare results
        boolean fastEnough = false;

        // .20 seconds??
        if (totalTime1 / totalTime2 < .90) {
            fastEnough = true;
        }
        System.out.println(fastEnough);
        // assersions.assertEquals(fastEnough,true);

    }

}
