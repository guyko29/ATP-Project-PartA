package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class MyCompressorOutputStream extends OutputStream {
    OutputStream out;

    public MyCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {
        ArrayList<Byte> result = new ArrayList<>();
        int counter_cells = 0;
        byte[] array_of_8 = new byte[8];
        for (int i = 0; i < b.length; i++) {
            if (i < 10) {
                result.add(b[i]);
                continue;
            }
            array_of_8[counter_cells] = b[i];
            counter_cells++;
            if (counter_cells == 8) {
                result.add(byte_array_to_byte_num(array_of_8));
                counter_cells = 0;
                continue;
            }
            if (i == b.length - 1) {
                for (int k = counter_cells; k < 8; k++) {
                    array_of_8[k] = 0;
                }
                result.add(byte_array_to_byte_num(array_of_8));
            }
        }
        for (Byte aByte : result) {
            out.write(aByte);
        }
    }

    private byte byte_array_to_byte_num(byte[] array8) {
        int byte_number = 0;
        for (int i = 7; i >= 0; i--) {
            byte_number += ((int) array8[i]) * (int) Math.pow(2, 7 - i);
        }
        byte_number = byte_number - 128;
        return((byte) byte_number);
    }
}
