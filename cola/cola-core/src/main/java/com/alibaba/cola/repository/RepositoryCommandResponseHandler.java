package com.alibaba.cola.repository;


import com.alibaba.cola.dto.Response;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
public interface RepositoryCommandResponseHandler<Req extends RepositoryI,Res extends Response>
        extends RepositoryHandlerI {

    Res command(Req request);

}
