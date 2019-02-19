// Master Java Exceptions with Best Practices
package com.telerikacademy.exceptions;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class TryWithResourcesDemo {

    public static void main(String[] args) throws Exception {

    }

    public static void trivialMethod() {
        Scanner scanner = null;
        try {
            scanner = new Scanner(new File("test.txt"));
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }
    }

    public static void shortenMethod() {
        try (Scanner scanner = new Scanner(new File("test.txt"))) {
            while (scanner.hasNext()) {
                System.out.println(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public static void multipleResources() {
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"))) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        }
    }

    public static void customAutoClosable() {
        try (Scanner scanner = new Scanner(new File("testRead.txt"));
             PrintWriter writer = new PrintWriter(new File("testWrite.txt"));
             MyResource myResource = new MyResource();) {
            while (scanner.hasNext()) {
                writer.print(scanner.nextLine());
            }
        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void orderOfClosingResources() throws Exception {
        try (AutoCloseableResourcesFirst af = new AutoCloseableResourcesFirst();
             AutoCloseableResourcesSecond as = new AutoCloseableResourcesSecond()) {

            af.doSomething();
            as.doSomething();
        }
    }

}

class MyResource implements AutoCloseable {
    @Override
    public void close() throws Exception {
        System.out.println("Closed MyResource");
    }
}

class AutoCloseableResourcesFirst implements AutoCloseable {

    public AutoCloseableResourcesFirst() {
        System.out.println("Constructor -> AutoCloseableResources_First");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_First");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_First");
    }
}

class AutoCloseableResourcesSecond implements AutoCloseable {

    public AutoCloseableResourcesSecond() {
        System.out.println("Constructor -> AutoCloseableResources_Second");
    }

    public void doSomething() {
        System.out.println("Something -> AutoCloseableResources_Second");
    }

    @Override
    public void close() throws Exception {
        System.out.println("Closed AutoCloseableResources_Second");
    }
}
