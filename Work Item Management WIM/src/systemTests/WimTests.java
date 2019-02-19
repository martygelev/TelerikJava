package systemTests;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.junit.Assert;
import org.junit.Test;
import system.wim.engine.EngineImpl;
import system.wim.engine.contracts.Engine;
import system.wim.engine.factory.WorkItemFactory;
import system.wim.engine.factory.WorkItemFactoryImpl;


public class WimTests {

    // The tests are located in the Tests folder
    // Each test has two files - "in" and "out"
    // The "in" file is the input
    // The "out" file is the expected output of your program


    @Test
    public void test_001() throws Exception {
        executeIOTest("001");
    }

    @Test
    public void test_002() throws Exception {
        executeIOTest("002");
    }

    @Test
    public void test_003() throws Exception {
        executeIOTest("003");
    }

    @Test
    public void test_004() throws Exception {
        executeIOTest("004");
    }

    @Test
    public void test_005() throws Exception {
        executeIOTest("005");
    }

    @Test
    public void test_006() throws Exception {
        executeIOTest("006");
    }

    @Test
    public void test_007() throws Exception {
        executeIOTest("007");
    }

    @Test
    public void test_008() throws Exception {
        executeIOTest("008");
    }

    @Test
    public void test_009() throws Exception {
        executeIOTest("009");
    }

    @Test
    public void test_010() throws Exception {
        executeIOTest("010");
    }

    @Test
    public void test_011() throws Exception {
        executeIOTest("011");
    }

    @Test
    public void test_012() throws Exception {
        executeIOTest("012");
    }

    @Test
    public void test_013() throws Exception {
        executeIOTest("013");
    }

    @Test
    public void test_014() throws Exception {
        executeIOTest("014");
    }

    @Test
    public void test_015() throws Exception {
        executeIOTest("015");
    }

    @Test
    public void test_016() throws Exception {
        executeIOTest("016");
    }

    @Test
    public void test_017() throws Exception {
        executeIOTest("017");
    }

    @Test
    public void test_018() throws Exception {
        executeIOTest("018");
    }

    @Test
    public void test_019() throws Exception {
        executeIOTest("019");
    }

    @Test
    public void test_020() throws Exception {
        executeIOTest("020");
    }

    @Test
    public void test_021() throws Exception {
        executeIOTest("021");
    }

    @Test
    public void test_022() throws Exception {
        executeIOTest("022");
    }

    @Test
    public void test_023() throws Exception {
        executeIOTest("023");
    }

    @Test
    public void test_024() throws Exception {
        executeIOTest("024");
    }

    @Test
    public void test_025() throws Exception {
        executeIOTest("025");
    }

    @Test
    public void test_026() throws Exception {
        executeIOTest("026");
    }

    @Test
    public void test_027() throws Exception {
        executeIOTest("027");
    }

    @Test
    public void test_028() throws Exception {
        executeIOTest("028");
    }

    @Test
    public void test_029() throws Exception {
        executeIOTest("029");
    }

    @Test
    public void test_030() throws Exception {
        executeIOTest("030");
    }

    private void executeIOTest(String testNumber) throws Exception {
        String testInputFilePath = "/Users/martingelev/TelerikJava/Work Item Management WIM/work-item-management-wim/work-item-management-wim-tests/src/systemTests/TestData/test." + testNumber + ".in.txt";
        //String testInputFilePath = "./work-item-management-wim-tests/src/systemTests/TestData/test." + testNumber + ".in.txt";
        InputStream testInput = new FileInputStream(testInputFilePath);
        System.setIn(testInput);

        ByteArrayOutputStream outputByteStream = new ByteArrayOutputStream();
        PrintStream output = new PrintStream(outputByteStream, true);
        System.setOut(output);

        WorkItemFactory factory = new WorkItemFactoryImpl();
        Engine engine = new EngineImpl(factory);
        engine.start();

        String testOutputFilePath = "/Users/martingelev/TelerikJava/Work Item Management WIM/work-item-management-wim/work-item-management-wim-tests/src/systemTests/TestData/test." + testNumber + ".out.txt";
        //String testOutputFilePath = "./work-item-management-wim-tests/src/systemTests/TestData/test." + testNumber + ".out.txt";
        byte[] testOutputData = Files.readAllBytes(Paths.get(testOutputFilePath));
        String expected = new String(testOutputData, StandardCharsets.UTF_8);
        String actual = new String(outputByteStream.toByteArray(), StandardCharsets.UTF_8);//.replaceAll("\r","");

        Assert.assertEquals(expected.trim(), actual.trim());
    }
}