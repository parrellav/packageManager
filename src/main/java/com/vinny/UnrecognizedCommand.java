package com.vinny;

import java.util.Arrays;
import java.util.Objects;

public class UnrecognizedCommand implements Command {
    private final String[] stringArr;

    public UnrecognizedCommand(String[] stringArray) {
        this.stringArr = Objects.requireNonNull(stringArray);
    }

    @Override
    public void execute(Graph graph, RequestedInstalled requestedInstalled) {
        String output = String.join(" ", Arrays.asList(this.stringArr));
        try {
            Integer.parseInt(output);
        } catch (Exception ex) {
            System.out.println(output);
        }

    }

}
