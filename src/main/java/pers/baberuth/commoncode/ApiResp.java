package pers.baberuth.commoncode;

import cn.hutool.core.lang.Assert;
import cn.hutool.core.util.StrUtil;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class ApiResp<T>
{
    private Integer status;

    private T data;

    private String errMsg;

    private ApiResp()
    {
    }

    public static ApiResp<String> success()
    {
        ApiResp<String> resp = new ApiResp<>();
        resp.status = StatusCode.SUCCESS.code;
        return resp;
    }

    public static <R> ApiResp<R> success(R data)
    {
        ApiResp<R> resp = new ApiResp<>();
        resp.status = StatusCode.SUCCESS.code;
        resp.data = data;
        return resp;
    }

    public static ApiResp<String> fail(StatusCode statusCode)
    {
        Assert.isFalse(statusCode.code != StatusCode.SUCCESS.code.intValue(), "失败的返回【status】不能使用【{}】", statusCode.code);
        ApiResp<String> resp = new ApiResp<>();
        resp.status = statusCode.code;
        return resp;
    }

    public static <R> ApiResp<R> fail(StatusCode statusCode, R data)
    {
        Assert.isFalse(statusCode.code != StatusCode.SUCCESS.code.intValue(), "失败的返回【status】不能使用【{}】", statusCode.code);
        ApiResp<R> resp = new ApiResp<>();
        resp.status = statusCode.code;
        resp.data = data;
        return resp;
    }

    public static <R> ApiResp<R> fail(StatusCode statusCode, R data, CharSequence template, Object... params)
    {
        Assert.isFalse(statusCode.code != StatusCode.SUCCESS.code.intValue(), "失败的返回【status】不能使用【{}】", statusCode.code);
        ApiResp<R> resp = new ApiResp<>();
        resp.status = statusCode.code;
        resp.data = data;
        resp.errMsg = StrUtil.format(template, params);
        return resp;
    }

    /**
     * 状态码
     */
    public enum StatusCode
    {
        /**
         * 业务成功
         */
        SUCCESS(0),

        /**
         * 业务失败 <br/>
         * 一般
         */
        FAIL(1),

        /**
         * 业务失败 <br/>
         * 未登录
         */
        NO_LOGIN(2),

        /**
         * 业务失败 <br/>
         * 全局捕获异常
         */
        GLOBAL_EXCEPTION(3);

        public final Integer code;

        StatusCode(int code)
        {
            this.code = code;
        }
    }
}
