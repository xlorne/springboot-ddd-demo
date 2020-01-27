package com.alibaba.cola.presentation;

import lombok.*;

/**
 * @author lorne
 * @date 2020/1/27
 * @description
 */
@AllArgsConstructor
@NoArgsConstructor
public class OnlyQueryPresentation  implements PresentationI{

    @Getter
    @Setter
    private Class<? extends PresentationHandlerI> presentation;



}
