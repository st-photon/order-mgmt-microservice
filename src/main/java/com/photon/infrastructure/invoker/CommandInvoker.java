package com.photon.infrastructure.invoker;

import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;
import org.springframework.stereotype.Component;

@FunctionalInterface
public interface CommandInvoker {

    CommandResult invokeCommand(CommandRequest commandRequest);
}
