package com.photon.infrastructure.invoker;

import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;

@FunctionalInterface
public interface Command {

    CommandResult execute(CommandRequest commandRequest);

    default CommandResult getCommandResult(Object object) {
        final CommandResult commandResult = new CommandResult();
        commandResult.setResponse(object);
        return commandResult;
    }
}
