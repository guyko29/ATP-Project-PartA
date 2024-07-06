package IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class SimpleDecompressorInputStream extends InputStream {

    private InputStream in;

    /**
     * Constructs a SimpleDecompressorInputStream object with the specified input stream.
     *
     * @param in the input stream to read the compressed data from
     */
    public SimpleDecompressorInputStream(InputStream in) {
        this.in = in;
    }

    /**
     * Reads a single byte of decompressed data. This method is not used in the current implementation.
     *
     * @return the byte read, or -1 if the end of the stream is reached
     * @throws IOException if an I/O error occurs
     */
    @Override
    public int read() throws IOException {
        return 0;
    }

    /**
     * Reads the decompressed data into the provided byte array.
     * The input byte array is decompressed using a simple algorithm and then written to the output byte array.
     *
     * @param b the byte array to read the decompressed data into
     * @return the total number of bytes read into the array, or -1 if the end of the stream has been reached
     * @throws IOException if an I/O error occurs while reading from the input stream
     */
    @Override
    public int read(byte[] b) throws IOException {
        ArrayList<Byte> maze_result = new ArrayList<>();
        while (in.available() > 0) {
            maze_result.add((byte) in.read());
        }
        int index = 10;
        for (int j = 0; j < maze_result.size(); j++) {
            if (j < 10) {
                b[j] = maze_result.get(j);
                continue;
            }
            int number = maze_result.get(j) + 128;
            if (j % 2 != 0) {
                for (int t = 0; t < number; t++) {
                    b[index] = 1;
                    index++;
                }
                continue;
            }
            for (int t = 0; t < number; t++) {
                b[index] = 0;
                index++;
            }
        }
        return 0;
    }
}
