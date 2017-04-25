package com.tencent.mm.modelsfs;

import java.io.IOException;
import java.io.InputStream;

public class SFSInputStream extends InputStream {
    private long cXN = 0;
    private long mNativePtr;

    private static native int nativeClose(long j);

    private static native int nativeRead(long j, byte[] bArr, int i, int i2);

    private static native long nativeSeek(long j, long j2, int i);

    private static native long nativeSize(long j);

    public SFSInputStream(long j) {
        this.mNativePtr = j;
    }

    public int available() {
        if (this.mNativePtr == 0) {
            throw new IOException("Stream already closed.");
        }
        long nativeSize = nativeSize(this.mNativePtr);
        if (nativeSize < 0) {
            throw new IOException(SFSContext.nativeErrorMessage());
        }
        long nativeSeek = nativeSeek(this.mNativePtr, 0, 1);
        if (nativeSeek >= 0) {
            return (int) (nativeSize - nativeSeek);
        }
        throw new IOException(SFSContext.nativeErrorMessage());
    }

    public void close() {
        if (this.mNativePtr != 0) {
            if (nativeClose(this.mNativePtr) == -1) {
                throw new IOException(SFSContext.nativeErrorMessage());
            }
            this.mNativePtr = 0;
        }
    }

    public boolean markSupported() {
        return true;
    }

    public void mark(int i) {
        if (this.mNativePtr != 0) {
            this.cXN = nativeSeek(this.mNativePtr, 0, 1);
        }
    }

    public void reset() {
        if (this.mNativePtr == 0) {
            throw new IOException("Stream already closed.");
        } else if (this.cXN < 0) {
            throw new IOException("Previous call to mark() failed.");
        } else if (nativeSeek(this.mNativePtr, this.cXN, 0) != this.cXN) {
            throw new IOException("Seeking to previous position failed.");
        }
    }

    public int read() {
        if (this.mNativePtr == 0) {
            throw new IOException("Stream already closed.");
        }
        byte[] bArr = new byte[1];
        int nativeRead;
        do {
            nativeRead = nativeRead(this.mNativePtr, bArr, 0, 1);
        } while (nativeRead == 0);
        if (nativeRead == -1) {
            return -1;
        }
        return bArr[0];
    }

    public int read(byte[] bArr, int i, int i2) {
        if (this.mNativePtr == 0) {
            throw new IOException("Stream already closed.");
        } else if ((i | i2) < 0 || i > bArr.length || bArr.length - i < i2) {
            throw new ArrayIndexOutOfBoundsException("length = " + bArr.length + ", offset = " + i + ", count = " + i2);
        } else {
            int nativeRead = nativeRead(this.mNativePtr, bArr, i, i2);
            if (nativeRead == 0) {
                return -1;
            }
            if (nativeRead != -1) {
                return nativeRead;
            }
            throw new IOException(SFSContext.nativeErrorMessage());
        }
    }

    public long skip(long j) {
        if (this.mNativePtr == 0) {
            throw new IOException("Stream already closed.");
        } else if (j < 0) {
            throw new IOException("byteCount < 0: " + j);
        } else {
            long nativeSeek = nativeSeek(this.mNativePtr, 0, 1);
            long nativeSeek2 = nativeSeek(this.mNativePtr, j, 1);
            if (nativeSeek != -1 && nativeSeek2 != -1) {
                return nativeSeek2 - nativeSeek;
            }
            throw new IOException(SFSContext.nativeErrorMessage());
        }
    }

    protected void finalize() {
        if (this.mNativePtr != 0) {
            close();
        }
        super.finalize();
    }
}
