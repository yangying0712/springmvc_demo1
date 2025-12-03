package org.xd.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.xd.pojo.Result;

/**
 * 全局异常处理
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {
    //处理异常
    @ExceptionHandler
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        log.error("服务器发生异常：", e);
//        e.printStackTrace();//打印堆栈中的异常信息
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e){
        log.error("服务器发生异常：", e);
        String msg = e.getMessage();
        int i= msg.lastIndexOf("Duplicate entry");
        String errMsg = msg.substring(i);
        String[] arr = errMsg.split(" ");
        //捕获到异常之后，响应一个标准的Result
        return Result.error(arr[2]+",数据已存在,请修改后重新添加");
    }
}
