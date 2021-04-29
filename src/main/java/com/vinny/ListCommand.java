package com.vinny;

import java.util.Arrays;

public class ListCommand implements Command {

    private final String[] stringArray;

    public ListCommand(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public void execute(Graph graph, RequestedInstalled requestedInstalled) {
        System.out.println(String.join(" ", Arrays.asList(this.stringArray)));
        for (String installed : requestedInstalled.getInstalled()) {
            System.out.println(installed);
        }
    }

}
