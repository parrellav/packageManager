package com.vinny;

import java.util.Arrays;

import com.vinny.Graph;
import com.vinny.RequestedInstalled;

public class DependCommand implements Command {

    private final String[] stringArray;

    public DependCommand(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public void execute(Graph graph, RequestedInstalled requestedInstalled) {
        System.out.println(String.join(" ", Arrays.asList(this.stringArray)));

        String source = stringArray[1];

        for (int i = 2; i < stringArray.length; i++) {
            graph.addEdge(source, stringArray[i]);
        }
    }

}

