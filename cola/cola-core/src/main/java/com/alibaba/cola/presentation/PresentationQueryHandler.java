package com.alibaba.cola.presentation;

import com.alibaba.cola.dto.Response;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
public interface PresentationQueryHandler<Req extends PresentationI,Res extends Response> extends PresentationHandlerI {

    Res query(Req request);

}
