package Aftale;

import java.util.Date;

public class Aftale {

    private Date date;
    private String cpr;

    public Aftale(Date date, String cpr){
        this.date = date;
        this.cpr = cpr;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String toString(){
        return this.date + " " + this.cpr;
    }
}
