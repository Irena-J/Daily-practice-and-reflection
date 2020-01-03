public class BusinessList {
    public String time;                          //交易时间
    public int cardnum;                        //卡号
    public String operation;                  //交易事件
    public BusinessList(){
        
    }
    public BusinessList(String time,int cardnum,String operation){
        this.time=time;
        this.cardnum=cardnum;
        this.operation=operation;
    }
    public String getTime() {
        return time;
    }

    public int getCardnum() {
        return cardnum;
    }
    
    public String getOperation() {
        return operation;
    }
}
