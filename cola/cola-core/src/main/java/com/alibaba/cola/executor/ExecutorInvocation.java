package com.alibaba.cola.executor;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.dto.Response;
import com.alibaba.cola.exception.framework.ExceptionHandlerFactory;
import com.alibaba.cola.logger.Logger;
import com.alibaba.cola.logger.LoggerFactory;
import com.google.common.collect.FluentIterable;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class ExecutorInvocation {

    private static Logger logger = LoggerFactory.getLogger(ExecutorInvocation.class);

    @Setter
    private ExecutorI commandExecutor;
    @Setter
    private Iterable<ExecutorInterceptorI> preInterceptors;
    @Setter
    private Iterable<ExecutorInterceptorI> postInterceptors;

    @Autowired
    private ExecutorHub executorHub;


    public ExecutorInvocation() {
        
    }
    
    public ExecutorInvocation(ExecutorI commandExecutor, List<ExecutorInterceptorI> preInterceptors,
                              List<ExecutorInterceptorI> postInterceptors){
        this.commandExecutor = commandExecutor;
        this.preInterceptors = preInterceptors;
        this.postInterceptors = postInterceptors;
    }

    public Response invoke(Command command) {
        Response response = null;
        try {
            preIntercept(command);
            response = commandExecutor.execute(command);  
        }
        catch(Exception e){
            response = getResponseInstance(command);
            response.setSuccess(false);
            ExceptionHandlerFactory.getExceptionHandler().handleException(command, response, e);
        }
        finally {
            //make sure post interceptors performs even though exception happens
            postIntercept(command, response);
        }          
        return response;
    }

    private void postIntercept(Command command, Response response) {
        try {
            for (ExecutorInterceptorI postInterceptor : FluentIterable.from(postInterceptors).toSet()) {
                postInterceptor.postIntercept(command, response);
            }
        }
        catch(Exception e){
            logger.error("postInterceptor error:"+e.getMessage(), e);
        }
    }

    private void preIntercept(Command command) {
        for (ExecutorInterceptorI preInterceptor : FluentIterable.from(preInterceptors).toSet()) {
            preInterceptor.preIntercept(command);
        }
    }

    private Response getResponseInstance(Command cmd) {
        Class responseClz = executorHub.getResponseRepository().get(cmd.getClass());
        try {
            return (Response) responseClz.newInstance();
        } catch (Exception e) {
            return new Response();
        }
    }
}
