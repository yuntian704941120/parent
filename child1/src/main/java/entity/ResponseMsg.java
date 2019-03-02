package entity;

import org.apache.log4j.Logger;

import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;

@ApiModel(value = "返回结果", description = "返回结果数据")
public class ResponseMsg implements Serializable{

    Logger log = Logger.getLogger(ResponseMsg.class);

    @ApiModelProperty(value = "错误码")
    private int code;
    @ApiModelProperty(value = "消息提示")
    private String msg = "";
    @ApiModelProperty(value = "数据")
    private Object data;

    private Date time;

    @ApiModelProperty(value = "缓存ticket")
    private String ticket;

    public String getTicket() {
        return ticket;
    }

    public void setTicket(String ticket) {
        this.ticket = ticket;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public ResponseMsg(){}
    public ResponseMsg(Object data){
        this.data = data;
    }

    public ResponseMsg setError(String str) {
        this.setCode(-1);
        this.setMsg(str);
        return this;
    }

    public ResponseMsg setError(int code, String str) {
        this.setCode(code);
        this.setMsg(str);
        return this;
    }

    public ResponseMsg setError(Throwable e) {
        //lhtd VipmoreException 异常表示已知如何处理的异常 code！= -1 如果把无法处理的异常转换成该异常 需要  修改对应代码  (暂时保留该 log)
        this.log.error(e.toString());

        this.setCode(-1);
        e.printStackTrace();
        if (e.getMessage() != null && e.getMessage().length() != e.getMessage().getBytes().length
                && e.getMessage().length() < 50) {
            this.setMsg(e.getMessage());
        } else if (e.getMessage() == null) {
            this.setMsg("程序出错,请联系客服");
        } else {
            this.setMsg("程序出错,请联系客服");
        }
        this.data = null;
        return this;
    }

    @Override
    public String toString() {
        return "ResponseMsg [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}
