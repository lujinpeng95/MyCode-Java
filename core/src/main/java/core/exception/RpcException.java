package core.exception;

/**
 * @author lujinpeng
 * @date 2023-08-25 5:19 下午
 */
public class RpcException extends RuntimeException {
    private static final long serialVersionUID = -8676085831589478911L;

    public RpcException() {
    }

    public RpcException(String message) {
        super(message);
    }

    public RpcException(Throwable cause) {
        super(cause);
    }

    public RpcException(String message, Throwable cause) {
        super(message, cause);
    }
}
