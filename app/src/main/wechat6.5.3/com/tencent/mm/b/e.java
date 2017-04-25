package com.tencent.mm.b;

import java.io.InputStream;

public final class e {
    public static final boolean a(InputStream inputStream, byte[] bArr, int i) {
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2 + 0, i - i2);
            if (read < 0) {
                return false;
            }
            i2 += read;
        }
        return true;
    }
}
