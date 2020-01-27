package com.alibaba.cola.presentation;

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
    private Map<Class<? extends PresentationI>, PresentationCommandHandler> presentationCommandRepository = new HashMap<>();

    @Getter
    private Map<Class<? extends PresentationI>, PresentationQueryHandler> presentationQueryRepository = new HashMap<>();

    @Getter
    private Map<Class<? extends PresentationI>, PresentationCommandResponseHandler> presentationCommandResponseRepository = new HashMap<>();


    public PresentationCommandResponseHandler getCommandResponsePresentationHandler(Class<? extends PresentationI> presentationClass) {
        PresentationCommandResponseHandler presentationHandler = presentationCommandResponseRepository.get(presentationClass);
        if (presentationHandler == null ) {
            throw new ColaException(presentationClass + "is not registered in presentationHub, please register first");
        }
        return presentationHandler;
    }


    public PresentationCommandHandler getCommandPresentationHandler(Class<? extends PresentationI> presentationClass) {
        PresentationCommandHandler presentationHandler = presentationCommandRepository.get(presentationClass);
        if (presentationHandler == null ) {
            throw new ColaException(presentationClass + "is not registered in presentationHub, please register first");
        }
        return presentationHandler;
    }


    public PresentationQueryHandler getQueryPresentationHandler(Class<? extends PresentationI> presentationClass) {
        PresentationQueryHandler presentationHandler = presentationQueryRepository.get(presentationClass);
        if (presentationHandler == null ) {
            throw new ColaException(presentationClass + "is not registered in presentationHub, please register first");
        }
        return presentationHandler;
    }

}
