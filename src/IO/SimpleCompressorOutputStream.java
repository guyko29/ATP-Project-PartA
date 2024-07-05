package IO;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;

public class SimpleCompressorOutputStream extends OutputStream {
    private OutputStream out;
    public SimpleCompressorOutputStream(OutputStream out) {
        this.out = out;
    }

    @Override
    public void write(int b) throws IOException {

    }

    @Override
    public void write(byte[] b) throws IOException {
        ArrayList<Byte> result_bytes = new ArrayList<>();
        int count =- 128;
        int before_num = 0;
        for (int j = 0; j < b.length; j++){
            if (j < 10){
                result_bytes.add(b[j]);
                continue;
            }
            if (b[j] != before_num){
                before_num = b[j];
                result_bytes.add((byte) count);
                count = - 127;
                if (j == b.length - 1){
                    result_bytes.add((byte) count);
                }
                continue;
            }
            if (count == 127) {
                result_bytes.add((byte) count);
                result_bytes.add((byte) 0);
                count = - 128;
            }
            count++;
            if (j == b.length - 1){
                result_bytes.add((byte) count);
            }
        }
        for (Byte resultByte : result_bytes) {
            out.write(resultByte);
        }
    }
}
