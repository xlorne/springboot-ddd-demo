package com.alibaba.cola.executor;

import com.alibaba.cola.dto.Command;
import com.alibaba.cola.dto.Response;

public interface QueryExecutorI<R extends Response, C extends Command> extends ExecutorI<R,C> {

}
