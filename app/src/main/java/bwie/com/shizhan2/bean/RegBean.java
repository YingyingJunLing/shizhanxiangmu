package bwie.com.shizhan2.bean;

import java.io.Serializable;

public class RegBean implements Serializable
{

    /**
     * message : 请先登陆
     * status : 0001
     */

    private String message;
    private String status;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
