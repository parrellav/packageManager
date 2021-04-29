package com.vinny;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.vinny.CommandFactory;

public class PackageManager {

    public static void main(String[] args) {
        CommandFactory commandFactory = new CommandFactory();
        Graph graph = new Graph();
        RequestedInstalled requestedInstalled = new RequestedInstalled();
        BufferedReader reader;
        try {
            reader = new BufferedReader(new FileReader(
                    "/Users/vparre200/github/packageManager/input.txt"));
            String line = reader.readLine();
            while (line != null) {
                String[] stringArray = line.split(" ");
                Command currentCommand = commandFactory.commandFrom(stringArray);
                currentCommand.execute(graph, requestedInstalled);
                // read next line
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
