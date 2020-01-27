package com.alibaba.cola.repository;

import com.alibaba.cola.common.ApplicationContextHelper;
import com.alibaba.cola.dto.Response;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Component
@AllArgsConstructor
public class RepositoryBus {

    private PresentationHub presentationHub;

    public void command(RepositoryI presentation){
        RepositoryCommandHandler presentationHandler =  presentationHub.getCommandPresentationHandler(presentation.getClass());
        presentationHandler.command(presentation);
    }

    public Response query(RepositoryI presentation){
        PresentationQueryHandler presentationHandler =  presentationHub.getQueryPresentationHandler(presentation.getClass());
        return presentationHandler.query(presentation);
    }

    public Response onlyQuery(Class<? extends PresentationOnlyQueryHandler> clazz){
        PresentationOnlyQueryHandler presentationHandler = ApplicationContextHelper.getBean(clazz);
        return presentationHandler.query();
    }

    public Response commandResponse(RepositoryI presentation){
        RepositoryCommandResponseHandler presentationHandler =  presentationHub.getCommandResponsePresentationHandler(presentation.getClass());
        return presentationHandler.command(presentation);
    }
}
