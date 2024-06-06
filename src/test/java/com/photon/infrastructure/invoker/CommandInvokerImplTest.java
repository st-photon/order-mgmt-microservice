package com.photon.infrastructure.invoker;

import com.photon.order.commands.GetOrderListCommand;
import com.photon.order.commands.request.GetOrderDetailCommandRequest;
import com.photon.order.commands.request.GetOrderListCommandRequest;
import org.apache.catalina.core.ApplicationContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

@ExtendWith(MockitoExtension.class)
public class CommandInvokerImplTest {

    @Mock
    private ApplicationContext applicationContext;

    @InjectMocks
    public CommandInvokerImpl commandInvoker;

    @Test
    public void shouldReturnSpecificCommand() {
        //arrange
        //Mockito.when(applicationContext).getMock().thenReturn(Mockito.mock(GetOrderListCommand.class));

        //assert
        GetOrderListCommandRequest getOrderListCommandRequest = new GetOrderListCommandRequest();
        commandInvoker.invokeCommand(getOrderListCommandRequest);
    }
}
