package com.example.springboot.core.view;

import com.alibaba.cola.repository.CmdResponseI;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lorne
 * @date 2020/1/3
 * @description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MsgRes implements CmdResponseI {

    private long time;
}
