package zjc.edu.model;

import android.content.Intent;

import org.w3c.dom.Text;

import java.util.Date;

public class WorkOrders {
    int workorderid;
    int userid;
    String workordertheme;
    String description;
    String status;
    String creationdate;

    public int getWorkorderid() {
        return workorderid;
    }

    public void setWorkorderid(int workorderid) {
        this.workorderid = workorderid;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getWorkordertheme() {
        return workordertheme;
    }

    public void setWorkordertheme(String workordertheme) {
        this.workordertheme = workordertheme;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(String creationdate) {
        this.creationdate = creationdate;
    }
}
