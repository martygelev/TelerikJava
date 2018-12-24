package com.telerikacademy.furnituremanufacturer.engine;

import com.telerikacademy.furnituremanufacturer.interfaces.engine.Renderer;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleRendererImpl implements Renderer {

    private final Scanner scanner = new Scanner(System.in);

    @Override
    public List<String> input() {

        List<String> listInput = new ArrayList<>();
        String currentLine = scanner.nextLine();
        while (currentLine != null && !currentLine.equals("")) {
            listInput.add(currentLine);
            currentLine = scanner.nextLine();
        }
        return listInput;
    }

    @Override
    public void output(List<String> output) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String string : output) {
            stringBuilder.append(string);
            stringBuilder.append(System.lineSeparator()); //what will happen if we remove this line?
        }
        System.out.println(stringBuilder.toString());
    }
}
