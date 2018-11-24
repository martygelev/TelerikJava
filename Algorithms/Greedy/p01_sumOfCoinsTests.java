import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;

public class p01_sumOfCoinsTests {

    @Test
    public void TestWithProvidedExample() {
        int[] coins = new int[]{1, 2, 5, 10, 20, 50};
        int targetSum = 923;

        Map<Integer, Integer> selectedCoins = p01_sumOfCoins.chooseCoins(coins, targetSum);

        Map<Integer, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(50, 18);
        expectedResult.put(20, 1);
        expectedResult.put(2, 1);
        expectedResult.put(1, 1);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : expectedResult.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();

            boolean b = selectedCoins.containsKey(key);
            Assert.assertTrue(b);
            Assert.assertEquals(value, selectedCoins.get(key));
        }
    }

    @Test
    public void TestWithOneAvailableCoin() {
        int[] coins = new int[]{1};
        int targetSum = 42;

        Map<Integer, Integer> selectedCoins = p01_sumOfCoins.chooseCoins(coins, targetSum);

        Map<Integer, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(1, 42);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : expectedResult.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();

            boolean b = selectedCoins.containsKey(key);
            Assert.assertTrue(b);
            Assert.assertEquals(value, selectedCoins.get(key));
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void TestWithUnreachableSum() {
        int[] coins = new int[]{3, 7};
        int targetSum = 11;

        p01_sumOfCoins.chooseCoins(coins, targetSum);
    }

    @Test
    public void TestWithSeveralCoins() {
        int[] coins = new int[]{1, 2, 5};
        int targetSum = 78;

        Map<Integer, Integer> selectedCoins = p01_sumOfCoins.chooseCoins(coins, targetSum);

        Map<Integer, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(5, 15);
        expectedResult.put(2, 1);
        expectedResult.put(1, 1);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : expectedResult.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();

            boolean b = selectedCoins.containsKey(key);
            Assert.assertTrue(b);
            Assert.assertEquals(value, selectedCoins.get(key));
        }
    }

    @Test
    public void TestWithLargeSum() {
        int[] coins = new int[]{1, 2, 5};
        int targetSum = 2031154123;

        Map<Integer, Integer> selectedCoins = p01_sumOfCoins.chooseCoins(coins, targetSum);

        Map<Integer, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(5, 406230824);
        expectedResult.put(2, 1);
        expectedResult.put(1, 1);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : expectedResult.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();

            boolean b = selectedCoins.containsKey(key);
            Assert.assertTrue(b);
            Assert.assertEquals(value, selectedCoins.get(key));
        }
    }

    @Test
    public void TestWithNonOptimalParameters() {
        int[] coins = new int[]{1, 9, 10};
        int targetSum = 27;

        Map<Integer, Integer> selectedCoins = p01_sumOfCoins.chooseCoins(coins, targetSum);

        Map<Integer, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(10, 2);
        expectedResult.put(1, 7);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : expectedResult.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();

            boolean b = selectedCoins.containsKey(key);
            Assert.assertTrue(b);
            Assert.assertEquals(value, selectedCoins.get(key));
        }
    }

    @Test
    public void TestWithSmallCoins() {
        int[] coins = new int[]{1, 2, 3, 4};
        int targetSum = 1234;

        Map<Integer, Integer> selectedCoins = p01_sumOfCoins.chooseCoins(coins, targetSum);

        Map<Integer, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(4, 308);
        expectedResult.put(2, 1);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : expectedResult.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();

            boolean b = selectedCoins.containsKey(key);
            Assert.assertTrue(b);
            Assert.assertEquals(value, selectedCoins.get(key));
        }
    }

    @Test
    public void TestWithOneCoinNeededOfEachValue() {
        int[] coins = new int[]{1000, 200, 30, 4};
        int targetSum = 1234;

        Map<Integer, Integer> selectedCoins = p01_sumOfCoins.chooseCoins(coins, targetSum);

        Map<Integer, Integer> expectedResult = new LinkedHashMap<>();
        expectedResult.put(1000, 1);
        expectedResult.put(200, 1);
        expectedResult.put(30, 1);
        expectedResult.put(4, 1);

        for (Map.Entry<Integer, Integer> integerIntegerEntry : expectedResult.entrySet()) {
            Integer key = integerIntegerEntry.getKey();
            Integer value = integerIntegerEntry.getValue();

            boolean b = selectedCoins.containsKey(key);
            Assert.assertTrue(b);
            Assert.assertEquals(value, selectedCoins.get(key));
        }
    }
}
