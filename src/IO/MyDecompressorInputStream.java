package IO;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class MyDecompressorInputStream extends InputStream {
    InputStream in;

    public MyDecompressorInputStream(InputStream in) {
        this.in = in;
    }

    @Override
    public int read() throws IOException {
        return 0;
    }

    @Override
    public int read(byte[] b) throws IOException {
        ArrayList<Byte> result = new ArrayList<>();
        while (in.available() > 0) {
            result.add((byte) in.read());
        }
        for (int i = 0; i < 10; i++) {
            b[i] = (byte) result.get(i);
        }
        int second_cell_rows = b[7];
        int rows = b[6] * 256 + second_cell_rows;
        int second_cell_columns = b[9];
        int columns = b[8] * 256 + second_cell_columns;
        int rest_cells = (rows * columns) % 8;
        int size = 8;
        int index_in_byte_array = 10;
        for(int i = 10; i < result.size();i++) {
            byte[] array_of_8 = new byte[8];
            array_of_8 = ByteToBinary((byte) result.get(i));
            if (result.size() - 1 == i && rest_cells != 0){
                size = rest_cells;
            }
            for (int j = 0; j < size; j++){
                b[index_in_byte_array] = array_of_8[j];
                index_in_byte_array++;
            }
        }
        return 0;
    }

    private byte[] ByteToBinary(byte byte_num_to_binary) {
        int number = (int) byte_num_to_binary + 128;
        byte[] array_8 = new byte[8];
        for(int i = 0; i < 8;i++){
            array_8[7-i] = (byte) (number % 2);
            number = number / 2;
        }
        return array_8;
    }
}
