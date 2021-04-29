package com.vinny;

import com.vinny.Graph;
import com.vinny.RequestedInstalled;

public interface Command {
    public void execute(Graph graph, RequestedInstalled requestedInstalled);
}

