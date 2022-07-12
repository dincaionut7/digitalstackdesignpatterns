package network.commands;

import java.util.ArrayList;
import java.util.List;

public abstract class CommandsExecutor {

    private static final List<Command> commands = new ArrayList<>();

    public synchronized static String executeCommand(Command command)
    {
        commands.add(command);
        return command.execute();
    }
}
