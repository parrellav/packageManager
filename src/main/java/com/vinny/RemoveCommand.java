package com.vinny;

import java.util.Arrays;

public class RemoveCommand implements Command {

    private final String[] stringArray;

    public RemoveCommand(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public void execute(Graph graph, RequestedInstalled requestedInstalled) {

        System.out.println(String.join(" ", Arrays.asList(this.stringArray)));
        for (int i = 1; i < stringArray.length; i++) {
            String toRemove = stringArray[i];
            if (requestedInstalled.isRequiredDependency(toRemove)) {
                System.out.println(toRemove + " is still needed");
            }
            // if (requestedInstalled.isRequested(toRemove) &&
            // requestedInstalled.isInstalled(toRemove)
            // && graph.getDeps(toRemove).isEmpty()) {

            // }
            else {
                // requestedInstalled.removeInstalled(toRemove);
                // requestedInstalled.removeRequested(toRemove);
                requestedInstalled.remove(toRemove);
                System.out.println("Removing " + toRemove);
                // List<String> missing = requestedInstalled.missingInstalled();
                // if (!missing.isEmpty()) {
                // String[] missingArr = new String[missing.size()];
                // System.out.println(String.join(" ",
                // Arrays.asList(missing.toArray(missingArr))));
                // }
            }
        }

    }

}
