package a.a.a.b.b;

import com.tencent.mmdb.FileUtils;
import java.io.UnsupportedEncodingException;

public final class a {
    private final int aGx;
    private final byte[] buffer;
    private int position = 0;

    public a(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aGx = i2 + 0;
    }

    public static int f(int i, String str) {
        if (str == null) {
            return 0;
        }
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + (cw(i) + cy(bytes.length));
        } catch (UnsupportedEncodingException e) {
            throw new IllegalStateException("UTF-8 not supported.");
        }
    }

    public final void cv(int i) {
        byte b = (byte) i;
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    public final void i(byte[] bArr) {
        if (bArr != null) {
            int length = bArr.length;
            if (bArr == null) {
                return;
            }
            if (this.aGx - this.position >= length) {
                System.arraycopy(bArr, 0, this.buffer, this.position, length);
                this.position = length + this.position;
                return;
            }
            int i = this.aGx - this.position;
            System.arraycopy(bArr, 0, this.buffer, this.position, i);
            int i2 = i + 0;
            length -= i;
            this.position = this.aGx;
            if (length <= this.aGx) {
                System.arraycopy(bArr, i2, this.buffer, 0, length);
                this.position = length;
            }
        }
    }

    public final void an(int i, int i2) {
        cx(a.a.a.b.a.ao(i, i2));
    }

    public static int cw(int i) {
        return cy(a.a.a.b.a.ao(i, 0));
    }

    public final void cx(int i) {
        while ((i & -128) != 0) {
            cv((i & 127) | FileUtils.S_IWUSR);
            i >>>= 7;
        }
        cv(i);
    }

    public static int cy(int i) {
        if ((i & -128) == 0) {
            return 1;
        }
        if ((i & -16384) == 0) {
            return 2;
        }
        if ((-2097152 & i) == 0) {
            return 3;
        }
        if ((-268435456 & i) == 0) {
            return 4;
        }
        return 5;
    }

    public final void n(long j) {
        while ((-128 & j) != 0) {
            cv((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        cv((int) j);
    }
}
