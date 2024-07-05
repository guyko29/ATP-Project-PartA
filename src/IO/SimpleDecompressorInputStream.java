package IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SimpleDecompressorInputStream extends InputStream {
    InputStream in;

    public SimpleDecompressorInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
        ArrayList<Byte> maze_result = new ArrayList<>();
        while (in.available() > 0){
            maze_result.add((byte) in.read());
        }
        int index = 10;
        for (int j = 0; j < maze_result.size(); j++){
            if (j < 10){
                b[j] = maze_result.get(j);
                continue;
            }
            int number = maze_result.get(j) + 128;
            if (j % 2 != 0){
                for (int t = 0; t < number; t++){
                    b[index] = 1;
                    index++;
                }
                continue;
            }
            for (int t = 0; t < number; t++){
                b[index] = 0;
                index++;
            }
        }
        return 0;
    }
}
