package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SimpleCompressorOutputStream extends OutputStream {

    private OutputStream out;

    /**
     * Constructs a SimpleCompressorOutputStream object with the specified output stream.
     *
     * @param out the output stream to write the compressed data to
     */
    public SimpleCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    /**
     * Writes a single byte to the output stream. This method is not used in the current implementation.
     *
     * @param b the byte to be written
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void write(int b) throws IOException {
        // This method is not used in the current implementation.
    }

    /**
     * Writes the compressed data to the output stream.
     * The input byte array is compressed using a simple algorithm and then written to the output stream.
     *
     * @param b the byte array to be compressed and written
     * @throws IOException if an I/O error occurs while writing to the output stream
     */
    @Override
    public void write(byte[] b) throws IOException {
        ArrayList<Byte> result_bytes = new ArrayList<>();
        int count = -128;
        int before_num = 0;
        for (int j = 0; j < b.length; j++) {
            if (j < 10) {
                result_bytes.add(b[j]);
                continue;
            }
            if (b[j] != before_num) {
                before_num = b[j];
                result_bytes.add((byte) count);
                count = -127;
                if (j == b.length - 1) {
                    result_bytes.add((byte) count);
                }
                continue;
            }
            if (count == 127) {
                result_bytes.add((byte) count);
                result_bytes.add((byte) 0);
                count = -128;
            }
            count++;
            if (j == b.length - 1) {
                result_bytes.add((byte) count);
            }
        }
        for (Byte result_byte : result_bytes) {
            out.write(result_byte);
        }
    }
}
