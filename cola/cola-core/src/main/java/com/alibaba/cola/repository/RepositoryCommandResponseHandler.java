package com.alibaba.cola.repository;


/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
public interface RepositoryCommandResponseHandler<Res extends CmdResponseI,Req extends RepositoryI>
        extends RepositoryHandlerI {

    Res command(Req request);

}
