package com.alibaba.cola.repository;

import com.alibaba.cola.exception.framework.ColaException;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@Component
public class PresentationHub {


    @Getter
    private Map<Class<? extends RepositoryI>, RepositoryCommandHandler> presentationCommandRepository = new HashMap<>();

    @Getter
    private Map<Class<? extends RepositoryI>, PresentationQueryHandler> presentationQueryRepository = new HashMap<>();

    @Getter
    private Map<Class<? extends RepositoryI>, RepositoryCommandResponseHandler> presentationCommandResponseRepository = new HashMap<>();


    public RepositoryCommandResponseHandler getCommandResponsePresentationHandler(Class<? extends RepositoryI> presentationClass) {
        RepositoryCommandResponseHandler presentationHandler = presentationCommandResponseRepository.get(presentationClass);
        if (presentationHandler == null ) {
            throw new ColaException(presentationClass + "is not registered in presentationHub, please register first");
        }
        return presentationHandler;
    }


    public RepositoryCommandHandler getCommandPresentationHandler(Class<? extends RepositoryI> presentationClass) {
        RepositoryCommandHandler presentationHandler = presentationCommandRepository.get(presentationClass);
        if (presentationHandler == null ) {
            throw new ColaException(presentationClass + "is not registered in presentationHub, please register first");
        }
        return presentationHandler;
    }


    public PresentationQueryHandler getQueryPresentationHandler(Class<? extends RepositoryI> presentationClass) {
        PresentationQueryHandler presentationHandler = presentationQueryRepository.get(presentationClass);
        if (presentationHandler == null ) {
            throw new ColaException(presentationClass + "is not registered in presentationHub, please register first");
        }
        return presentationHandler;
    }

}
