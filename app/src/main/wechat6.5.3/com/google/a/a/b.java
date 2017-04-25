package com.google.a.a;

import com.tencent.mmdb.FileUtils;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public final class b {
    final int aGx;
    private final byte[] buffer;
    int position = 0;

    public static class a extends IOException {
        a(int i, int i2) {
            super("CodedOutputStream was writing to a flat byte array and ran out of space (pos " + i + " limit " + i2 + ").");
        }
    }

    b(byte[] bArr, int i, int i2) {
        this.buffer = bArr;
        this.aGx = i2 + 0;
    }

    public final void e(int i, long j) {
        an(i, 0);
        n(j);
    }

    public final void f(int i, long j) {
        an(i, 0);
        n(j);
    }

    public final void aj(int i, int i2) {
        an(i, 0);
        if (i2 >= 0) {
            cx(i2);
        } else {
            n((long) i2);
        }
    }

    public final void e(int i, String str) {
        an(i, 2);
        byte[] bytes = str.getBytes("UTF-8");
        cx(bytes.length);
        i(bytes);
    }

    public final void a(int i, e eVar) {
        an(i, 2);
        if (eVar.aGz < 0) {
            eVar.mT();
        }
        cx(eVar.aGz);
        eVar.a(this);
    }

    public final void a(int i, byte[] bArr) {
        an(i, 2);
        cx(bArr.length);
        i(bArr);
    }

    public final void ak(int i, int i2) {
        an(i, 0);
        cx(i2);
    }

    public static int g(int i, long j) {
        return cw(i) + o(j);
    }

    public static int h(int i, long j) {
        return cw(i) + o(j);
    }

    public static int al(int i, int i2) {
        return cw(i) + cu(i2);
    }

    public static int f(int i, String str) {
        return cw(i) + au(str);
    }

    public static int b(int i, e eVar) {
        int cw = cw(i);
        int mT = eVar.mT();
        return cw + (mT + cy(mT));
    }

    public static int b(int i, byte[] bArr) {
        return cw(i) + (cy(bArr.length) + bArr.length);
    }

    public static int am(int i, int i2) {
        return cw(i) + cy(i2);
    }

    public static int cu(int i) {
        if (i >= 0) {
            return cy(i);
        }
        return 10;
    }

    public static int au(String str) {
        try {
            byte[] bytes = str.getBytes("UTF-8");
            return bytes.length + cy(bytes.length);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException("UTF-8 not supported.");
        }
    }

    private void cv(int i) {
        byte b = (byte) i;
        if (this.position == this.aGx) {
            throw new a(this.position, this.aGx);
        }
        byte[] bArr = this.buffer;
        int i2 = this.position;
        this.position = i2 + 1;
        bArr[i2] = b;
    }

    private void i(byte[] bArr) {
        int length = bArr.length;
        if (this.aGx - this.position >= length) {
            System.arraycopy(bArr, 0, this.buffer, this.position, length);
            this.position = length + this.position;
            return;
        }
        throw new a(this.position, this.aGx);
    }

    private void an(int i, int i2) {
        cx(g.ao(i, i2));
    }

    private static int cw(int i) {
        return cy(g.ao(i, 0));
    }

    private void cx(int i) {
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

    private void n(long j) {
        while ((-128 & j) != 0) {
            cv((((int) j) & 127) | FileUtils.S_IWUSR);
            j >>>= 7;
        }
        cv((int) j);
    }

    private static int o(long j) {
        if ((-128 & j) == 0) {
            return 1;
        }
        if ((-16384 & j) == 0) {
            return 2;
        }
        if ((-2097152 & j) == 0) {
            return 3;
        }
        if ((-268435456 & j) == 0) {
            return 4;
        }
        if ((-34359738368L & j) == 0) {
            return 5;
        }
        if ((-4398046511104L & j) == 0) {
            return 6;
        }
        if ((-562949953421312L & j) == 0) {
            return 7;
        }
        if ((-72057594037927936L & j) == 0) {
            return 8;
        }
        if ((Long.MIN_VALUE & j) == 0) {
            return 9;
        }
        return 10;
    }
}
