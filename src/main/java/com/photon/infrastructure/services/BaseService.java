package com.photon.infrastructure.services;

import com.photon.infrastructure.invoker.CommandInvoker;
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
}
