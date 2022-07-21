package com.example.novel.core.common.exception;

import com.example.novel.core.common.constant.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义业务异常，用于处理用户请求时，业务错误时抛出
 * @author:wxh
 * @date:2022/7/18
 **/
@EqualsAndHashCode(callSuper = true)
@Data
public class BusinessException extends RuntimeException{

    private final ErrorCodeEnum errorCodeEnum;

    public BusinessException(ErrorCodeEnum errorCodeEnum){
        super(errorCodeEnum.getMessage(), null, false, false);
        this.errorCodeEnum = errorCodeEnum;
    }
}
