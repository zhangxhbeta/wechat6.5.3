package com.tencent.mm.plugin.appbrand.d;

import com.tencent.mm.sdk.platformtools.v;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.nio.ByteBuffer;

public final class a extends InputStream {
    private final ByteBuffer dEb;

    public a(ByteBuffer byteBuffer) {
        this.dEb = byteBuffer;
    }

    public final int available() {
        return this.dEb.remaining();
    }

    public final int read() {
        return this.dEb.hasRemaining() ? this.dEb.get() & 255 : -1;
    }

    public final int read(byte[] bArr, int i, int i2) {
        if (!this.dEb.hasRemaining()) {
            return -1;
        }
        int min = Math.min(i2, this.dEb.remaining());
        this.dEb.get(bArr, i, min);
        return min;
    }

    public final void close() {
        super.close();
        ByteBuffer byteBuffer = this.dEb;
        if (byteBuffer.getClass().getName().equals("java.nio.DirectByteBuffer")) {
            try {
                Method declaredMethod = byteBuffer.getClass().getDeclaredMethod("free", new Class[0]);
                boolean isAccessible = declaredMethod.isAccessible();
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(byteBuffer, new Object[0]);
                declaredMethod.setAccessible(isAccessible);
            } catch (Exception e) {
                v.d("MicroMsg.ByteBufferBackedInputStream", "free ByteBuffer, exp = %s", new Object[]{e});
            }
        }
        System.gc();
    }
}
