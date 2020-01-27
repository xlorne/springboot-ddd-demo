package com.alibaba.cola.repository;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
public interface RepositoryQueryHandler<Res extends CmdResponseI,Req extends RepositoryI> extends RepositoryHandlerI {

    Res query(Req request);

}
