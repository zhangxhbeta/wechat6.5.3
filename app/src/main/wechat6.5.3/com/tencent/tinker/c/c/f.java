package com.tencent.tinker.c.c;

import java.io.InputStream;
import java.nio.ByteOrder;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.zip.ZipException;

public final class f implements Cloneable {
    int hrm = -1;
    String mSg;
    public String name;
    public long pFb = -1;
    public long pFc = -1;
    int pFd = -1;
    int pFe = -1;
    byte[] pFf;
    long pFg = -1;
    long pFh = -1;
    long size = -1;

    public f(f fVar) {
        this.name = fVar.name;
        this.mSg = fVar.mSg;
        this.hrm = fVar.hrm;
        this.size = fVar.size;
        this.pFc = fVar.pFc;
        this.pFb = fVar.pFb;
        this.pFd = fVar.pFd;
        this.pFe = fVar.pFe;
        this.pFf = fVar.pFf;
        this.pFg = fVar.pFg;
        this.pFh = fVar.pFh;
    }

    f(byte[] bArr, InputStream inputStream, Charset charset) {
        e.b(inputStream, bArr, 0, 46);
        b a = c.a(bArr, 46, ByteOrder.LITTLE_ENDIAN);
        int readInt = a.readInt();
        if (((long) readInt) != 33639248) {
            g.a("unknown", (long) inputStream.available(), "unknown", 0, "Central Directory Entry", readInt);
        }
        a.py(8);
        int readShort = a.readShort() & 65535;
        if ((readShort & 1) != 0) {
            throw new ZipException("Invalid General Purpose Bit Flag: " + readShort);
        }
        if ((readShort & 2048) != 0) {
            charset = Charset.forName("UTF-8");
        }
        this.pFd = a.readShort() & 65535;
        this.hrm = a.readShort() & 65535;
        this.pFe = a.readShort() & 65535;
        this.pFb = ((long) a.readInt()) & 4294967295L;
        this.pFc = ((long) a.readInt()) & 4294967295L;
        this.size = ((long) a.readInt()) & 4294967295L;
        readShort = a.readShort() & 65535;
        int readShort2 = a.readShort() & 65535;
        int readShort3 = a.readShort() & 65535;
        a.py(42);
        this.pFg = ((long) a.readInt()) & 4294967295L;
        byte[] bArr2 = new byte[readShort];
        e.b(inputStream, bArr2, 0, bArr2.length);
        if (bA(bArr2)) {
            throw new ZipException("Filename contains NUL byte: " + Arrays.toString(bArr2));
        }
        this.name = new String(bArr2, 0, bArr2.length, charset);
        if (readShort2 > 0) {
            this.pFf = new byte[readShort2];
            e.b(inputStream, this.pFf, 0, readShort2);
        }
        if (readShort3 > 0) {
            bArr2 = new byte[readShort3];
            e.b(inputStream, bArr2, 0, readShort3);
            this.mSg = new String(bArr2, 0, bArr2.length, charset);
        }
    }

    private static boolean bA(byte[] bArr) {
        for (byte b : bArr) {
            if (b == (byte) 0) {
                return true;
            }
        }
        return false;
    }

    public final void setMethod(int i) {
        if (i == 0 || i == 8) {
            this.pFd = i;
            return;
        }
        throw new IllegalArgumentException("Bad method: " + i);
    }

    public final void setSize(long j) {
        if (j < 0) {
            throw new IllegalArgumentException("Bad size: " + j);
        }
        this.size = j;
    }

    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("name:" + this.name);
        stringBuffer.append("\ncomment:" + this.mSg);
        stringBuffer.append("\ntime:" + this.hrm);
        stringBuffer.append("\nsize:" + this.size);
        stringBuffer.append("\ncompressedSize:" + this.pFc);
        stringBuffer.append("\ncrc:" + this.pFb);
        stringBuffer.append("\ncompressionMethod:" + this.pFd);
        stringBuffer.append("\nmodDate:" + this.pFe);
        stringBuffer.append("\nextra:" + this.pFf);
        stringBuffer.append("\nlocalHeaderRelOffset:" + this.pFg);
        stringBuffer.append("\ndataOffset:" + this.pFh);
        return stringBuffer.toString();
    }

    public final Object clone() {
        try {
            f fVar = (f) super.clone();
            fVar.pFf = this.pFf != null ? (byte[]) this.pFf.clone() : null;
            return fVar;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    public final int hashCode() {
        return this.name.hashCode();
    }
}
