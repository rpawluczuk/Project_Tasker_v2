package GUI.Allgorithms;

import java.io.*;
import java.util.LinkedList;
import java.util.List;

public class Memory implements Serializable {
    private List<Task> listWithTasks = new LinkedList<Task>();

    public Memory() {
    }

    public List<Task> getListWithTasks() {
        return listWithTasks;
    }

    public void setListWithTasks(List<Task> listWithTasks) {
        this.listWithTasks = listWithTasks;
    }


    public void serializable(List<Task> temporaryList) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("memory.dat"))) {
            outputStream.writeObject(temporaryList);
        }
    }
}
