package pers.baberuth.commoncode;

import cn.hutool.core.util.StrUtil;

public class OptRuntimeException extends RuntimeException
{
    private OptRuntimeException(String message)
    {
        super(message);
    }

    private OptRuntimeException(Throwable cause)
    {
        super(cause);
    }

    public static OptRuntimeException getInstance(CharSequence template, Object... params)
    {
        return new OptRuntimeException(StrUtil.format(template, params));
    }

    public static OptRuntimeException getInstance(Throwable cause)
    {
        return new OptRuntimeException(cause);
    }
}
