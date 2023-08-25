package core.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.UUID;

@ApiModel(description = "Amis通用响应返回对象")
@Data
public class AmisR<T> implements Serializable {

    /**
     * 返回状态码
     */
    @ApiModelProperty(value = "返回状态码", position = 0)
    private int status;

    /**
     * 返回信息
     */
    @ApiModelProperty(value = "返回信息", position = 1)
    private String msg;

    /**
     * 返回当时的时间戳，秒为单位
     */
    @ApiModelProperty(value = "时间戳", position = 2)
    private Long timestamp;

    /**
     * 请求request_id，即logid
     */
    @ApiModelProperty(value = "日志ID", position = 3)
    private String requestId;

    /**
     * 返回结果数据
     */
    @ApiModelProperty(value = "结果数据", position = 4)
    private T data;

    public static <T> AmisR<T> error() {
        return error(500, "fail");
    }

    public static <T> AmisR<T> error(String msg) {
        return error(500, msg);
    }

    public static <T> AmisR<T> error(Integer status, String msg) {
        AmisR<T> r = new AmisR<>();
        r.setStatus(status);
        r.setMsg(msg);
        r.setTimestamp(System.currentTimeMillis() / 1000L);
        r.setRequestId(UUID.randomUUID().toString().replace("-", ""));
        return r;
    }

    public static <T> AmisR<T> ok() {
        AmisR<T> r = new AmisR<>();
        r.setStatus(0);
        r.setMsg("success");
        r.setTimestamp(System.currentTimeMillis() / 1000L);
        r.setRequestId(UUID.randomUUID().toString().replace("-", ""));
        return r;
    }

    public static <T> AmisR<T> ok(T data) {
        AmisR<T> r = new AmisR<>();
        r.setStatus(0);
        r.setMsg("success");
        r.setTimestamp(System.currentTimeMillis() / 1000L);
        r.setRequestId(UUID.randomUUID().toString().replace("-", ""));
        r.setData(data);
        return r;
    }

    @ApiModelProperty(value = "返回状态码", position = 0)
    public int getStatus() {
        return status;
    }

    @ApiModelProperty(value = "返回状态码", position = 0)
    public void setStatus(int status) {
        this.status = status;
    }

    @ApiModelProperty(value = "返回信息", position = 1)
    public String getMsg() {
        return msg;
    }

    @ApiModelProperty(value = "返回信息", position = 1)
    public void setMsg(String msg) {
        this.msg = msg;
    }

    @ApiModelProperty(value = "时间戳", position = 2)
    public Long getTimestamp() {
        return timestamp;
    }

    @ApiModelProperty(value = "时间戳", position = 2)
    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @ApiModelProperty(value = "日志ID", position = 3)
    public String getRequestId() {
        return requestId;
    }

    @ApiModelProperty(value = "日志ID", position = 3)
    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    @ApiModelProperty(value = "结果数据", position = 4)
    public T getData() {
        return data;
    }

    @ApiModelProperty(value = "结果数据", position = 4)
    public void setData(T data) {
        this.data = data;
    }

}
