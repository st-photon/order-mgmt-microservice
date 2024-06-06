package com.photon.infrastructure.services;

import com.photon.infrastructure.invoker.CommandInvoker;
import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class BaseService extends AbstractBaseService {

    @Setter(onMethod_ = {@Autowired})
    private CommandInvoker commandInvoker;

    public CommandInvoker getCommandInvoker() {
        return this.commandInvoker;
    }

    protected CommandResult invokeCommand(CommandRequest commandRequest) {
        return this.commandInvoker.invokeCommand(commandRequest);
    }
}
