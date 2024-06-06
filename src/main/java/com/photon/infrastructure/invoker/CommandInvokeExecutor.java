package com.photon.infrastructure.invoker;

import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@Setter
@RequiredArgsConstructor
public class CommandInvokeExecutor {

    private final ApplicationContext applicationContext;

    public CommandResult executeCommand(Class<?> commandClass, CommandRequest request) {
        try {
            final Command command = this.applicationContext.getBean(commandClass.getSimpleName(), Command.class);
            return command.execute(request);
        } catch (Exception e) {
            throw new RuntimeException("Command not found");
        }
    }
}
