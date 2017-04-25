package com.tencent.tinker.c.c;

import java.io.ByteArrayOutputStream;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HashSet;
import java.util.zip.ZipException;

public final class h extends FilterOutputStream {
    public static final byte[] pFp = new byte[0];
    private static final byte[] pFq = new byte[]{(byte) -1, (byte) -1, (byte) -1, (byte) -1};
    private long cOf;
    private final HashSet<String> pFr;
    private final boolean pFs;
    private byte[] pFt;
    private int pFu;
    private ByteArrayOutputStream pFv;
    private f pFw;
    private byte[] pFx;
    private byte[] pFy;
    private boolean pFz;

    public h(OutputStream outputStream) {
        this(outputStream, (byte) 0);
    }

    private h(OutputStream outputStream, byte b) {
        super(outputStream);
        this.pFr = new HashSet();
        this.pFt = pFp;
        this.pFu = 8;
        this.pFv = new ByteArrayOutputStream();
        this.cOf = 0;
        this.pFs = false;
    }

    private static long a(OutputStream outputStream, long j) {
        outputStream.write((int) (255 & j));
        outputStream.write(((int) (j >> 8)) & 255);
        outputStream.write(((int) (j >> 16)) & 255);
        outputStream.write(((int) (j >> 24)) & 255);
        return j;
    }

    private static int b(OutputStream outputStream, int i) {
        outputStream.write(i & 255);
        outputStream.write((i >> 8) & 255);
        return i;
    }

    public final void close() {
        if (this.out == null) {
            return;
        }
        if (this.out == null) {
            throw new IOException("Stream is closed");
        }
        if (this.pFv != null) {
            if (this.pFr.isEmpty()) {
                throw new ZipException("No entries");
            }
            if (this.pFw != null) {
                closeEntry();
            }
            int size = this.pFv.size();
            a(this.pFv, 101010256);
            b(this.pFv, 0);
            b(this.pFv, 0);
            if (this.pFz) {
                b(this.pFv, 65535);
                b(this.pFv, 65535);
                a(this.pFv, -1);
                a(this.pFv, -1);
            } else {
                b(this.pFv, this.pFr.size());
                b(this.pFv, this.pFr.size());
                a(this.pFv, (long) size);
                a(this.pFv, this.cOf);
            }
            b(this.pFv, this.pFt.length);
            if (this.pFt.length > 0) {
                this.pFv.write(this.pFt);
            }
            this.pFv.writeTo(this.out);
            this.pFv = null;
        }
        this.out.close();
        this.out = null;
    }

    public final void closeEntry() {
        bOX();
        if (this.pFw != null) {
            long j = 30;
            if (this.pFw.pFd != 0) {
                j = 46;
                a(this.out, 134695760);
                a(this.out, this.pFw.pFb);
                a(this.out, this.pFw.pFc);
                a(this.out, this.pFw.size);
            }
            int i = (this.pFw.pFd == 0 ? 0 : 8) | 2048;
            a(this.pFv, 33639248);
            b(this.pFv, 20);
            b(this.pFv, 20);
            b(this.pFv, i);
            b(this.pFv, this.pFw.pFd);
            b(this.pFv, this.pFw.hrm);
            b(this.pFv, this.pFw.pFe);
            a(this.pFv, this.pFw.pFb);
            if (this.pFw.pFd == 8) {
                j += this.pFw.pFc;
            } else {
                j += this.pFw.size;
            }
            a(this.pFv, this.pFw.pFc);
            a(this.pFv, this.pFw.size);
            j += (long) b(this.pFv, this.pFx.length);
            if (this.pFw.pFf != null) {
                j += (long) b(this.pFv, this.pFw.pFf.length);
            } else {
                b(this.pFv, 0);
            }
            b(this.pFv, this.pFy.length);
            b(this.pFv, 0);
            b(this.pFv, 0);
            a(this.pFv, 0);
            a(this.pFv, this.pFw.pFg);
            this.pFv.write(this.pFx);
            this.pFx = null;
            if (this.pFw.pFf != null) {
                this.pFv.write(this.pFw.pFf);
            }
            this.cOf = j + this.cOf;
            if (this.pFy.length > 0) {
                this.pFv.write(this.pFy);
                this.pFy = pFp;
            }
            this.pFw = null;
        }
    }

    public final void b(f fVar) {
        int i;
        if (this.pFw != null) {
            closeEntry();
        }
        int i2 = fVar.pFd;
        if (i2 == -1) {
            i = this.pFu;
        } else {
            i = i2;
        }
        if (i == 0) {
            if (fVar.pFc == -1) {
                fVar.pFc = fVar.size;
            } else if (fVar.size == -1) {
                fVar.setSize(fVar.pFc);
            }
            if (fVar.pFb == -1) {
                throw new ZipException("STORED entry missing CRC");
            } else if (fVar.size == -1) {
                throw new ZipException("STORED entry missing size");
            } else if (fVar.size != fVar.pFc) {
                throw new ZipException("STORED entry size/compressed size mismatch");
            }
        }
        bOX();
        fVar.mSg = null;
        fVar.pFf = null;
        fVar.hrm = 40691;
        fVar.pFe = 18698;
        this.pFx = fVar.name.getBytes(d.UTF_8);
        v("Name", this.pFx);
        this.pFy = pFp;
        if (fVar.mSg != null) {
            this.pFy = fVar.mSg.getBytes(d.UTF_8);
            v("Comment", this.pFy);
        }
        fVar.setMethod(i);
        this.pFw = fVar;
        this.pFw.pFg = this.cOf;
        this.pFr.add(this.pFw.name);
        i2 = (i == 0 ? 0 : 8) | 2048;
        a(this.out, 67324752);
        b(this.out, 20);
        b(this.out, i2);
        b(this.out, i);
        b(this.out, this.pFw.hrm);
        b(this.out, this.pFw.pFe);
        if (i == 0) {
            a(this.out, this.pFw.pFb);
            a(this.out, this.pFw.size);
            a(this.out, this.pFw.size);
        } else {
            a(this.out, 0);
            a(this.out, 0);
            a(this.out, 0);
        }
        b(this.out, this.pFx.length);
        if (this.pFw.pFf != null) {
            b(this.out, this.pFw.pFf.length);
        } else {
            b(this.out, 0);
        }
        this.out.write(this.pFx);
        if (this.pFw.pFf != null) {
            this.out.write(this.pFw.pFf);
        }
    }

    public final void write(byte[] bArr, int i, int i2) {
        a.W(bArr.length, i, i2);
        if (this.pFw == null) {
            throw new ZipException("No active entry");
        }
        this.out.write(bArr, i, i2);
    }

    private void bOX() {
        if (this.pFv == null) {
            throw new IOException("Stream is closed");
        }
    }

    private static void v(String str, byte[] bArr) {
        if (bArr.length > 65535) {
            throw new IllegalArgumentException(str + " too long in UTF-8:" + bArr.length + " bytes");
        }
    }
}
