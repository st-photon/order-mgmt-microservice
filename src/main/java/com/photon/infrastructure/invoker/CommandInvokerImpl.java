package com.photon.infrastructure.invoker;

import com.photon.infrastructure.invoker.annotation.CommandRequestType;
import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.reflections.Reflections;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Optional;
import java.util.Set;

@Component
@Slf4j
@RequiredArgsConstructor
public class CommandInvokerImpl implements CommandInvoker {

    private final ApplicationContext applicationContext;

    @Override
    public CommandResult invokeCommand(CommandRequest request){
        String requestClassName = request.getClass().getCanonicalName();
        Reflections reflections = new Reflections("com.photon");
        Set<Class<?>> commandClasses = reflections.getTypesAnnotatedWith(CommandRequestType.class);
        Class<?> className = commandClasses.stream()
                .filter(c -> c.getAnnotation(CommandRequestType.class).value().equals(requestClassName))
                .findAny().orElseThrow(() -> new RuntimeException("Developer error!!! no command handler found to process the request"));
        final Command command = this.applicationContext.getBean(className.getSimpleName(), Command.class);
        return command.execute(request);
    }
}
