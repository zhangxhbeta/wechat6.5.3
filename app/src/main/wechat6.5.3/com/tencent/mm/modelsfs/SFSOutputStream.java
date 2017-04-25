package com.tencent.mm.modelsfs;

import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.OutputStream;

public class SFSOutputStream extends OutputStream {
    private StackTraceElement[] cYg = Thread.currentThread().getStackTrace();
    private long mNativePtr;

    private static native int nativeClose(long j);

    private static native int nativeWrite(long j, byte[] bArr, int i, int i2);

    public SFSOutputStream(long j) {
        this.mNativePtr = j;
    }

    public void close() {
        if (this.mNativePtr != 0) {
            if (nativeClose(this.mNativePtr) == -1) {
                throw new IOException(SFSContext.nativeErrorMessage());
            }
            this.mNativePtr = 0;
        }
    }

    public void write(int i) {
        if (this.mNativePtr == 0) {
            throw new IOException("Stream already closed.");
        }
        if (nativeWrite(this.mNativePtr, new byte[]{(byte) i}, 0, 1) != 1) {
            throw new IOException(SFSContext.nativeErrorMessage());
        }
    }

    public void write(byte[] bArr, int i, int i2) {
        if (this.mNativePtr == 0) {
            throw new IOException("Stream already closed.");
        } else if ((i | i2) < 0 || i > bArr.length || bArr.length - i < i2) {
            throw new ArrayIndexOutOfBoundsException("length = " + bArr.length + "offset = " + i + "count = " + i2);
        } else if (nativeWrite(this.mNativePtr, bArr, i, i2) != i2) {
            throw new IOException(SFSContext.nativeErrorMessage());
        }
    }

    protected void finalize() {
        if (this.mNativePtr != 0) {
            StringBuilder stringBuilder = new StringBuilder("SFSOutputStream leaked:\n");
            for (StackTraceElement stackTraceElement : this.cYg) {
                stringBuilder.append(stackTraceElement.toString()).append('\n');
            }
            v.e("MicroMsg.SFSOutputStream", stringBuilder.toString());
            close();
        }
        super.finalize();
    }
}
