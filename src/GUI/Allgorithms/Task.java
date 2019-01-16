package GUI.Allgorithms;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Serializable {
    private String name;
    private String creationDate = new SimpleDateFormat
            ("yyyy-MM-dd").format(new Date());
    private String endDate;
    private String status;
    private String comment;

    public Task() {
        this.name = "default";
        this.endDate = "default";
        this.status = "default";
        this.comment = "default";
    }

    public Task(String name, String endDate,
                String status, String comment) {
        this.name = name;
        this.endDate = endDate;
        this.status = status;
        this.comment = comment;
    }

    @Override
    public String toString() {
        return  "Name of task: " + name +
                "\nTask creation date: " + creationDate +
                "\nExpected end date of the task: " + endDate +
                "\nStatus: " + status +
                "\nComment: " + comment +
                "\n----------------------\n";
    }

    public String getName() {
        return name;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public String getStatus() {
        return status;
    }

    public String getComment() {
        return comment;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}