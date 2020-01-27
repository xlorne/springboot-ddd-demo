package com.alibaba.cola.repository;


/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
public interface RepositoryCommandHandler<Req extends RepositoryI> extends RepositoryHandlerI {

    void command(Req request);

}
