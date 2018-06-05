package hu.javalife.heroesofempires.hero.service.ejb;

/**
 * @author user
 */
public class BException extends Throwable{
    private long errorCode;
    private Object data;

    public BException(long errorCode, Object data, String message) {
        super(message);
        this.errorCode = errorCode;
        this.data = data;
    }

    public long getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(long errorCode) {
        this.errorCode = errorCode;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
    
    
    
}
