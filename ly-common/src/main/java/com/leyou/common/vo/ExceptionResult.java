package com.leyou.common.vo;

import com.leyou.common.enums.ExceptionEnum;
import lombok.Data;

/**
 * @description 自定义异常返回实体
 */
@Data
public class ExceptionResult {
    private int status;
    private String message;
    private long timestamp;

    public ExceptionResult(ExceptionEnum em) {
        this.status = em.getCode();                     // 状态码
        this.message = em.getMsg();                     // 异常信息
        this.timestamp = System.currentTimeMillis();    // 当前时间
    }
}
