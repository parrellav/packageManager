package com.vinny;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class RequestedInstalled {
    // private List<String> requested = new ArrayList<>();
    // private List<String> installed = new ArrayList<>();

    private Graph installGraph = new Graph();
    private Map<String, List<String>> installMap = new LinkedHashMap<>();

    public List<String> getInstalled() {
        List<String> installed = new ArrayList<>();
        for (Map.Entry<String, List<String>> entry : installMap.entrySet()) {
            for (String dep : entry.getValue()) {
                if (!installed.contains(dep)) {
                    installed.add(dep);
                }
            }
            // entry.getValue().stream()
            // .filter(p -> !installed.contains(p))
            // .collect(Collectors.toList());
            // // entry.getValue().forEach(s -> installed.add(s));
            installed.add(entry.getKey());
        }
        return installed;
    }

    public Map<String, List<String>> getInstallMap() {
        return installMap;
    }

    public Graph getInstallGraph() {
        return installGraph;
    }

    public boolean isRequiredDependency(String toRemove) {
        return this.installGraph.isRequiredDependency(toRemove);
    }

    public void remove(String toRemove) {
        this.installGraph.remove(toRemove);
        this.installMap.remove(toRemove);
    }

    // public void addRequested(String requested) {
    // if (!this.requested.contains(requested)) {
    // this.requested.add(requested);
    // }
    // }

    // public void addInstalled(String installed) {
    // if (!this.installed.contains(installed)) {
    // this.installed.add(installed);
    // }
    // }

    // public boolean isRequested(String aRequested) {
    // return requested.contains(aRequested);
    // }

    // public boolean isInstalled(String aInstalled) {
    // return installed.contains(aInstalled);
    // }

    // public List<String> missingInstalled() {
    // List<String> reqCopy = new ArrayList<>(requested);
    // reqCopy.removeAll(this.installed);
    // return reqCopy;
    // }

    // public void removeInstalled(String toRemove) {
    // this.installed.remove(toRemove);
    // }

    // public void removeRequested(String toRemove) {
    // this.requested.remove(toRemove);
    // }

}
