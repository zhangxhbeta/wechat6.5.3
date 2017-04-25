package android.support.v4.e;

import com.tencent.mmdb.FileUtils;
import java.io.Writer;

public final class d extends Writer {
    private final String oZ;
    private StringBuilder vA = new StringBuilder(FileUtils.S_IWUSR);

    public d(String str) {
        this.oZ = str;
    }

    public final void close() {
        bH();
    }

    public final void flush() {
        bH();
    }

    public final void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                bH();
            } else {
                this.vA.append(c);
            }
        }
    }

    private void bH() {
        if (this.vA.length() > 0) {
            this.vA.delete(0, this.vA.length());
        }
    }
}
