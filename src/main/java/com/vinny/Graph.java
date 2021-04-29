package com.vinny;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private Map<String, List<String>> lookup = new HashMap<>();

    public void addEdge(String source, String edge) {
        List<String> myList = lookup.get(edge);
        if (null != myList) {
            if (myList.contains(source)) {
                System.out.println(edge + " depends on " + source + ", ignoring command");
                return;
            }
        }
        List<String> adj = lookup.get(source);
        if (null == adj) {
            adj = new ArrayList<>();
        }
        if (!adj.contains(edge)) {
            adj.add(edge);
        }
        lookup.put(source, adj);
    }

    private boolean _hasCycle(Map<String, Boolean> visited, Map<String, Boolean> stackRecur, String node) {
        if (stackRecur.containsKey(node)) {
            return true;
        }
        if (visited.containsKey(node)) {
            return false;
        }
        stackRecur.put(node, true);
        visited.put(node, true);
        List<String> adj = lookup.get(node);
        if (null != adj) {
            for (String vert : adj) {
                if (true == _hasCycle(visited, stackRecur, vert)) {
                    return true;
                }
            }
        }
        return false;

    }

    public boolean hasCycle() {
        Map<String, Boolean> visited = new HashMap<>();
        Map<String, Boolean> stackRecur = new HashMap<>();

        for (String key : lookup.keySet()) {
            if (_hasCycle(visited, stackRecur, key)) {
                return true;
            }
        }
        return false;
    }

    public List<String> getDeps(String aString) {
        List<String> myList = new ArrayList<>();
        if (lookup.containsKey(aString)) {
            myList = lookup.get(aString);
        }
        return myList;
    }

    public boolean isRequiredDependency(String required) {
        for (Map.Entry<String, List<String>> entry : lookup.entrySet()) {
            List<String> deps = entry.getValue();
            if (deps.contains(required)) {
                return true;
            }
        }
        return false;
    }

    public boolean contains(String aDep) {
        return lookup.containsKey(aDep);
    }

    public void remove(String aDep) {
        if (lookup.containsKey(aDep)) {
            lookup.remove(aDep);
        }
    }

    public static void main(String[] args) {
        Graph graph = new Graph();
        graph.addEdge("0", "1");
        graph.addEdge("1", "2");
        graph.addEdge("1", "3");
        graph.addEdge("3", "0");
        System.out.println(graph.hasCycle());
    }
}
