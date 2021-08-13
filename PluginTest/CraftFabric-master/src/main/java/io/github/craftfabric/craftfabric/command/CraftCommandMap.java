package io.github.craftfabric.craftfabric.command;

import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.SimpleCommandMap;

import java.util.Map;

public class CraftCommandMap extends SimpleCommandMap {

    public CraftCommandMap(Server server) {
        super(server);
    }

    public Map<String, Command> getKnownCommands() {
        return knownCommands;
    }
}
