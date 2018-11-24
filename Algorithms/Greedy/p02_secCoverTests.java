import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class p02_secCoverTests {

    @Test
    public void TestWithProvidedExample() {
        int[] universe = new int[]{1, 3, 5, 7, 9, 11, 20, 30, 40};
        List<int[]> sets = new ArrayList<>();
        sets.add(new int[]{20});
        sets.add(new int[]{1, 5, 20, 30});
        sets.add(new int[]{3, 7, 20, 30, 40});
        sets.add(new int[]{9, 30});
        sets.add(new int[]{11, 20, 30, 40});
        sets.add(new int[]{3, 7, 40});

        List<int[]> selectedSets = p02_secCover.chooseSets(sets, universe);

        List<int[]> expectedResult = new ArrayList<>();
        expectedResult.add(sets.get(2));
        expectedResult.add(sets.get(1));
        expectedResult.add(sets.get(3));
        expectedResult.add(sets.get(4));

        for (int i = 0; i < selectedSets.size(); i++) {
            Assert.assertEquals(selectedSets.get(i), expectedResult.get(i));
        }
    }

    @Test
    public void TestWithNoRedundantElements() {
        int[] universe = new int[]{1, 2, 3, 4, 5};
        List<int[]> sets = new ArrayList<>();
        sets.add(new int[]{1});
        sets.add(new int[]{2, 4});
        sets.add(new int[]{5});
        sets.add(new int[]{3});

        List<int[]> selectedSets = p02_secCover.chooseSets(sets, universe);

        List<int[]> expectedResult = new ArrayList<>();
        expectedResult.add(sets.get(1));
        expectedResult.add(sets.get(0));
        expectedResult.add(sets.get(2));
        expectedResult.add(sets.get(3));

        for (int i = 0; i < selectedSets.size(); i++) {
            Assert.assertEquals(selectedSets.get(i), expectedResult.get(i));
        }
    }

    @Test
    public void TestWithOneSetContainingUniverse() {
        int[] universe = new int[]{1, 2, 3, 4, 5};
        List<int[]> sets = new ArrayList<>();
        sets.add(new int[]{1, 2, 3, 4, 5});
        sets.add(new int[]{2, 3, 4, 5});
        sets.add(new int[]{5});
        sets.add(new int[]{3});

        List<int[]> selectedSets = p02_secCover.chooseSets(sets, universe);

        List<int[]> expectedResult = new ArrayList<>();
        expectedResult.add(sets.get(0));

        for (int i = 0; i < selectedSets.size(); i++) {
            Assert.assertEquals(selectedSets.get(i), expectedResult.get(i));
        }
    }

    @Test
    public void TestWithSeveralRedundantSets() {
        int[] universe = new int[]{1, 2, 3, 4, 5, 6};
        List<int[]> sets = new ArrayList<>();
        sets.add(new int[]{1, 2, 5});
        sets.add(new int[]{2, 3, 5});
        sets.add(new int[]{3, 4, 5});
        sets.add(new int[]{4, 5});
        sets.add(new int[]{1, 3, 4, 6});

        List<int[]> selectedSets = p02_secCover.chooseSets(sets, universe);

        List<int[]> expectedResult = new ArrayList<>();
        expectedResult.add(sets.get(4));
        expectedResult.add(sets.get(0));

        for (int i = 0; i < selectedSets.size(); i++) {
            Assert.assertEquals(selectedSets.get(i), expectedResult.get(i));
        }
    }
}
