import java.io.*;

/**
 * Created by lzakharov on 09.05.15.
 */
public class b26 {
    public static void main(String[] args) {
        Graph[] graphs = new Graph[15];
        for (int i = 0; i < 15; i++) {
            graphs[i] = new Graph();
        }

        int cnt = 0;

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("objects.out"));
            for (int i = 0; i < 15; i++) {
                objectOutputStream.writeObject(graphs[i]);
            }

            objectOutputStream.close();

            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("objects.out"));
            for (int i = 0; i < 15; i++) {
                Graph graph = (Graph)objectInputStream.readObject();
                if (graph.getSize() % 2 == 0) {
                    cnt++;
                }
            }
        } catch (IOException e) {
        } catch (ClassNotFoundException e) {
        }

        System.out.println(cnt);
    }
}
