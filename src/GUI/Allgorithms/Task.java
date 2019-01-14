package GUI.Allgorithms;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Task {
    private String nameOfTask;
    private String taskCreationDate = new SimpleDateFormat
            ("yyyy-MM-dd").format(new Date());
    private String expectedEndDateOfTheTask;
    private String status;
    private String comment;
}
