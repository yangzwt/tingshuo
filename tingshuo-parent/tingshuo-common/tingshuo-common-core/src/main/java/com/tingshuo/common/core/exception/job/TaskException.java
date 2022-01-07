package com.tingshuo.common.core.exception.job;

/**
 * 类文件描述:
 * 定时任务 错误工具类
 * 计划策略异常
 * @author yangz
 * @version 1.0.0
 * @date 2022年01月07日 21:30
 **/
public class TaskException extends Exception
{
    private static final long serialVersionUID = 1L;

    private Code code;

    public TaskException(String msg, Code code)
    {
        this(msg, code, null);
    }

    public TaskException(String msg, Code code, Exception nestedEx)
    {
        super(msg, nestedEx);
        this.code = code;
    }

    public Code getCode()
    {
        return code;
    }

    public enum Code
    {
        TASK_EXISTS, NO_TASK_EXISTS, TASK_ALREADY_STARTED, UNKNOWN, CONFIG_ERROR, TASK_NODE_NOT_AVAILABLE
    }
}
