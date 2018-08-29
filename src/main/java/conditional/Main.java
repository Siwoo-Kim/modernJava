package conditional;

import org.junit.Test;

import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;

public class Main {

    @Test
    public void stepIf() {
        int[] values = {1, 2, 3, 4, 5};
        double avg = 0;
        if(values.length > 0) {
            avg = IntStream.of(values).average().orElse(0);
        }
        assertEquals(avg, 3, 0);
    }
}
