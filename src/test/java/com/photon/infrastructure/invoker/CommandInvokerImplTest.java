package com.photon.infrastructure.invoker;

import com.photon.infrastructure.invoker.request.CommandRequest;
import com.photon.infrastructure.invoker.result.CommandResult;
import com.photon.order.commands.request.GetOrderListCommandRequest;
import jakarta.persistence.criteria.Order;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class CommandInvokerImplTest {

    @Mock
    private CommandInvokeExecutor commandInvokeExecutor;

    @InjectMocks
    private CommandInvokerImpl commandInvoker;

    @Test
    @DisplayName("Should fetch specific command to execute based on command request")
    public void shouldExecuteCommand() {
        //arrange
        CommandResult commandResult = new CommandResult();
        commandResult.setResponse(Mockito.mock(Order.class));
        Mockito.when(commandInvokeExecutor.executeCommand(Mockito.any(), Mockito.any())).thenReturn(commandResult);

        //act
        GetOrderListCommandRequest getOrderListCommandRequest = new GetOrderListCommandRequest();
        CommandResult commandResult1 = commandInvoker.invokeCommand(getOrderListCommandRequest);

        //assert
        Mockito.verify(commandInvokeExecutor, Mockito.times(1)).executeCommand(Mockito.any(), Mockito.any());
        Assertions.assertNotNull(commandResult1.getResponse());
    }

    @Test
    @DisplayName("should throw exception when specific command handler not found")
    public void shouldThrowErrorWhenCommandNotFound() {
        try {
            //act
            CommandRequest getOrderListCommandRequest = new CommandRequest();
            commandInvoker.invokeCommand(getOrderListCommandRequest);
        } catch (RuntimeException e){
            //assert
            Assertions.assertEquals("Developer error!!! no command handler found to process the request", e.getMessage());
        }
    }
}
