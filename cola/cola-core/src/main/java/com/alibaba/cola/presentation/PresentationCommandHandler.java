package com.alibaba.cola.presentation;


/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
public interface PresentationCommandHandler<Req extends PresentationI> extends PresentationHandlerI {

    void command(Req request);

}
