package com.vinny;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class InstallCommand implements Command {

    private final String[] stringArray;

    public InstallCommand(String[] stringArray) {
        this.stringArray = stringArray;
    }

    @Override
    public void execute(Graph graph, RequestedInstalled requestedInstalled) {
        System.out.println(String.join(" ", Arrays.asList(this.stringArray)));
        for (int i = 1; i < stringArray.length; i++) {
            String toInstall = stringArray[i];

            List<String> deps = graph.getDeps(toInstall);
            Graph installGraph = requestedInstalled.getInstallGraph();
            Map<String, List<String>> installMap = requestedInstalled.getInstallMap();
            List<String> installedDeps = installGraph.getDeps(toInstall);
            if (installedDeps.isEmpty()) {
                if (deps.isEmpty()) {
                    installGraph.addEdge(toInstall, null);
                    installMap.put(toInstall, new ArrayList<>());
                } else {
                    for (String dep : deps) {
                        // if (!installGraph.isRequiredDependency(dep) && !installGraph.contains(dep)) {
                        if (!installGraph.isRequiredDependency(dep) && !installGraph.contains(dep)) {
                            System.out.println("Installing " + dep);
                            if (graph.contains(dep)) {
                                List<String> thisDependencyDeps = graph.getDeps(dep);
                                for (String secondLevelDep : thisDependencyDeps) {
                                    installGraph.addEdge(dep, secondLevelDep);
                                    List<String> installed = installMap.get(dep);
                                    if (null == installed) {
                                        installed = new ArrayList<>();
                                    }
                                    installed.add(secondLevelDep);
                                    installMap.put(dep, installed);
                                }
                            }
                        }
                        installGraph.addEdge(toInstall, dep);
                        List<String> myDeps = installMap.get(toInstall);
                        if (null == myDeps) {
                            myDeps = new ArrayList<>();
                        }
                        myDeps.add(dep);
                        installMap.put(toInstall, myDeps);

                        // }
                    }
                }
                System.out.println("Installing " + toInstall);
            }
            // for (String dep : deps) {
            // if (!requestedInstalled.isInstalled(dep)) {
            // requestedInstalled.addRequested(dep);
            // requestedInstalled.addInstalled(dep);
            // System.out.println("Installing " + dep);
            // }
            // }

            // if (!requestedInstalled.isInstalled(toInstall)) {
            // requestedInstalled.addRequested(toInstall);
            // requestedInstalled.addInstalled(toInstall);
            // System.out.println("Installing " + toInstall);
            // }
            else {
                System.out.println(toInstall + " is already installed");
            }

        }

    }

}
