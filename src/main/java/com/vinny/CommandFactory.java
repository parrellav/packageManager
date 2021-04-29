package com.vinny;

import com.vinny.InstallCommand;
import com.vinny.ListCommand;
import com.vinny.RemoveCommand;
import com.vinny.UnrecognizedCommand;

public class CommandFactory {
    public Command commandFrom(String[] stringArray) {
        String first = stringArray[0].toLowerCase();
        switch (first) {
            case "depend":
                return new DependCommand(stringArray);
            case "install":
                return new InstallCommand(stringArray);
            case "remove":
                return new RemoveCommand(stringArray);
            case "list":
                return new ListCommand(stringArray);
            default:
                return new UnrecognizedCommand(stringArray);
        }
    }
}

