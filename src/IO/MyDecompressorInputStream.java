package IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MyDecompressorInputStream extends InputStream {

    private InputStream in;

    /**
     * Constructs a MyDecompressorInputStream object with the specified input stream.
     *
     * @param in the input stream to read the compressed data from
     */
    public MyDecompressorInputStream(InputStream in) {
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
     *
     * @param b the byte array to read the decompressed data into
     * @return the total number of bytes read into the array, or -1 if the end of the stream has been reached
     * @throws IOException if an I/O error occurs while reading from the input stream
     */
    @Override
    public int read(byte[] b) throws IOException {
        ArrayList<Byte> result_byte = new ArrayList<>();
        while (in.available() > 0) {
            result_byte.add((byte) in.read());
        }
        for (int i = 0; i < 10; i++) {
            b[i] = result_byte.get(i);
        }
        int second_cell_rows = b[7];
        int rows = b[6] * 256 + second_cell_rows;
        int second_cell_columns = b[9];
        int columns = b[8] * 256 + second_cell_columns;
        int rest_cells = (rows * columns) % 8;
        int size = 8;
        int index_in_byte_array = 10;
        for (int i = 10; i < result_byte.size(); i++) {
            byte[] array_of_8 = ByteToBinary(result_byte.get(i));
            if (result_byte.size() - 1 == i && rest_cells != 0) {
                size = rest_cells;
            }
            for (int j = 0; j < size; j++) {
                b[index_in_byte_array] = array_of_8[j];
                index_in_byte_array++;
            }
        }
        return 0;
    }

    /**
     * Converts a byte number to an 8-element byte array representing its binary representation.
     * The byte number is adjusted by adding 128.
     *
     * @param byteNumToBinary the byte number to be converted
     * @return the 8-element byte array representing the binary representation
     */
    private byte[] ByteToBinary(byte byteNumToBinary) {
        int number = (int) byteNumToBinary + 128;
        byte[] array8 = new byte[8];
        for (int i = 0; i < 8; i++) {
            array8[7 - i] = (byte) (number % 2);
            number = number / 2;
        }
        return array8;
    }
}
