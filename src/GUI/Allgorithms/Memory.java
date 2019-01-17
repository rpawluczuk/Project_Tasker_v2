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

    public void serialization(List<Task> temporaryList) throws IOException {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("memory.dat"))) {
            outputStream.writeObject(temporaryList);
        }
    }

    public void deserialization() throws IOException, ClassNotFoundException {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("memory.dat"))) {
            listWithTasks = (List<Task>) inputStream.readObject();
        }
    }
}
