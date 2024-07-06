package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

/**
 * The MyCompressorOutputStream class is used to compress data and write it to an output stream.
 * It extends the OutputStream class and provides compression functionality.
 */
public class MyCompressorOutputStream extends OutputStream {

    private OutputStream out;

    /**
     * Constructs a MyCompressorOutputStream object with the specified output stream.
     *
     * @param out the output stream to write the compressed data to
     */
    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    /**
     * Writes a single byte to the output stream. This method is not used in the current implementation.
     *
     * @param b the byte to be written
     * @throws IOException if an I/O error occurs
     */
    @Override
    public void write(int b) throws IOException {}

    /**
     * Writes the compressed data to the output stream.
     * The input byte array is compressed using a custom algorithm and then written to the output stream.
     *
     * @param b the byte array to be compressed and written
     * @throws IOException if an I/O error occurs while writing to the output stream
     */
    @Override
    public void write(byte[] b) throws IOException {
        ArrayList<Byte> result_byte = new ArrayList<>();
        int counter_cells = 0;
        byte[] array_of_8 = new byte[8];
        for (int i = 0; i < b.length; i++) {
            if (i < 10) {
                result_byte.add(b[i]);
                continue;
            }
            array_of_8[counter_cells] = b[i];
            counter_cells++;
            if (counter_cells == 8) {
                result_byte.add(byte_array_to_byte_num(array_of_8));
                counter_cells = 0;
            }
            if (i == b.length - 1 && counter_cells != 0) {
                for (int k = counter_cells; k < 8; k++) {
                    array_of_8[k] = 0;
                }
                result_byte.add(byte_array_to_byte_num(array_of_8));
            }
        }
        for (Byte aByte : result_byte) {
            out.write(aByte);
        }
    }

    /**
     * Converts an 8-element byte array to a byte number using binary representation.
     * The byte number is adjusted by subtracting 128.
     *
     * @param array8 the byte array to be converted
     * @return the converted byte number
     */
    private byte byte_array_to_byte_num(byte[] array8) {
        int byte_number = 0;
        for (int i = 7; i >= 0; i--) {
            byte_number += (array8[i]) * (int) Math.pow(2, 7 - i);
        }
        byte_number = byte_number - 128;
        return (byte) byte_number;
    }
}
