package in.bluehorse.caldroidcalendar.util;

/**
 * Created by BLUEHORSE 123 on 5/23/2016.
 */
public class Event {
    public int type;
    public String msg;
    public Event(int type,String msg) { this.type = type; this.msg = msg; }
    public String getMsg(){ return this.msg;}
}
