package com.tencent.tinker.c.c;

import java.io.BufferedInputStream;
import java.io.Closeable;
import java.io.DataInputStream;
import java.io.File;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.nio.ByteOrder;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.zip.ZipException;

public final class g implements Closeable {
    private final String filename;
    private String mSg;
    public final LinkedHashMap<String, f> pFi;
    private File pFj;
    private RandomAccessFile pFk;

    class AnonymousClass1 implements Enumeration<f> {
        final /* synthetic */ Iterator pFl;
        final /* synthetic */ g pFm;

        public AnonymousClass1(g gVar, Iterator it) {
            this.pFm = gVar;
            this.pFl = it;
        }

        public final /* synthetic */ Object nextElement() {
            this.pFm.bOV();
            return (f) this.pFl.next();
        }

        public final boolean hasMoreElements() {
            this.pFm.bOV();
            return this.pFl.hasNext();
        }
    }

    public static class a extends InputStream {
        private long cOf;
        private final RandomAccessFile pFn;
        private long pFo;

        private a(RandomAccessFile randomAccessFile, long j, long j2) {
            this.pFn = randomAccessFile;
            this.cOf = j;
            this.pFo = j2;
        }

        public a(RandomAccessFile randomAccessFile, long j) {
            this(randomAccessFile, j, randomAccessFile.length());
        }

        public final int available() {
            return this.cOf < this.pFo ? 1 : 0;
        }

        public final int read() {
            return e.p(this);
        }

        public final int read(byte[] bArr, int i, int i2) {
            int read;
            synchronized (this.pFn) {
                long j = this.pFo - this.cOf;
                if (((long) i2) > j) {
                    i2 = (int) j;
                }
                this.pFn.seek(this.cOf);
                read = this.pFn.read(bArr, i, i2);
                if (read > 0) {
                    this.cOf += (long) read;
                } else {
                    read = -1;
                }
            }
            return read;
        }

        public final long skip(long j) {
            if (j > this.pFo - this.cOf) {
                j = this.pFo - this.cOf;
            }
            this.cOf += j;
            return j;
        }
    }

    public g(File file) {
        this(file, (byte) 0);
    }

    public g(String str) {
        this(new File(str), (byte) 0);
    }

    private g(File file, byte b) {
        this.pFi = new LinkedHashMap();
        this.filename = file.getPath();
        this.pFj = null;
        this.pFk = new RandomAccessFile(this.filename, "r");
        bOW();
    }

    static void a(String str, long j, String str2, long j2, String str3, int i) {
        throw new ZipException("file name:" + str + ", file size" + j + ", entry name:" + str2 + ", entry localHeaderRelOffset:" + j2 + ", " + str3 + " signature not found; was " + Integer.toHexString(i));
    }

    public final void close() {
        RandomAccessFile randomAccessFile = this.pFk;
        if (randomAccessFile != null) {
            synchronized (randomAccessFile) {
                this.pFk = null;
                randomAccessFile.close();
            }
            if (this.pFj != null) {
                this.pFj.delete();
                this.pFj = null;
            }
        }
    }

    public final void bOV() {
        if (this.pFk == null) {
            throw new IllegalStateException("Zip file closed");
        }
    }

    public final f Qv(String str) {
        bOV();
        if (str == null) {
            throw new NullPointerException("entryName == null");
        }
        f fVar = (f) this.pFi.get(str);
        if (fVar == null) {
            return (f) this.pFi.get(str + "/");
        }
        return fVar;
    }

    public final InputStream a(f fVar) {
        f Qv = Qv(fVar.name);
        if (Qv == null) {
            return null;
        }
        InputStream aVar;
        RandomAccessFile randomAccessFile = this.pFk;
        synchronized (randomAccessFile) {
            aVar = new a(randomAccessFile, Qv.pFg);
            DataInputStream dataInputStream = new DataInputStream(aVar);
            int reverseBytes = Integer.reverseBytes(dataInputStream.readInt());
            if (((long) reverseBytes) != 67324752) {
                a(this.filename, randomAccessFile.length(), Qv.name, Qv.pFg, "Local File Header", reverseBytes);
            }
            dataInputStream.skipBytes(2);
            int reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            if ((reverseBytes2 & 1) != 0) {
                throw new ZipException("Invalid General Purpose Bit Flag: " + reverseBytes2);
            }
            dataInputStream.skipBytes(18);
            reverseBytes2 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            int reverseBytes3 = Short.reverseBytes(dataInputStream.readShort()) & 65535;
            dataInputStream.close();
            aVar.skip((long) (reverseBytes2 + reverseBytes3));
            if (Qv.pFd == 0) {
                aVar.pFo = aVar.cOf + Qv.size;
            } else {
                aVar.pFo = aVar.cOf + Qv.pFc;
            }
        }
        return aVar;
    }

    private void bOW() {
        long j = 0;
        long length = this.pFk.length() - 22;
        if (length < 0) {
            throw new ZipException("File too short to be a zip file: " + this.pFk.length());
        }
        this.pFk.seek(0);
        if (((long) Integer.reverseBytes(this.pFk.readInt())) != 67324752) {
            throw new ZipException("Not a zip archive");
        }
        long j2 = length - 65536;
        if (j2 < 0) {
            j2 = length;
        } else {
            j = j2;
            j2 = length;
        }
        do {
            this.pFk.seek(j2);
            if (((long) Integer.reverseBytes(this.pFk.readInt())) != 101010256) {
                j2--;
            } else {
                byte[] bArr = new byte[18];
                this.pFk.readFully(bArr);
                b a = c.a(bArr, 18, ByteOrder.LITTLE_ENDIAN);
                int readShort = a.readShort() & 65535;
                int readShort2 = a.readShort() & 65535;
                int readShort3 = a.readShort() & 65535;
                int readShort4 = a.readShort() & 65535;
                a.bOU();
                long readInt = ((long) a.readInt()) & 4294967295L;
                int readShort5 = a.readShort() & 65535;
                if (readShort3 == readShort4 && readShort == 0 && readShort2 == 0) {
                    if (readShort5 > 0) {
                        bArr = new byte[readShort5];
                        this.pFk.readFully(bArr);
                        this.mSg = new String(bArr, 0, bArr.length, d.UTF_8);
                    }
                    InputStream bufferedInputStream = new BufferedInputStream(new a(this.pFk, readInt), 4096);
                    byte[] bArr2 = new byte[46];
                    for (readShort5 = 0; readShort5 < readShort3; readShort5++) {
                        f fVar = new f(bArr2, bufferedInputStream, d.UTF_8);
                        if (fVar.pFg >= readInt) {
                            throw new ZipException("Local file header offset is after central directory");
                        }
                        String str = fVar.name;
                        if (this.pFi.put(str, fVar) != null) {
                            throw new ZipException("Duplicate entry name: " + str);
                        }
                    }
                    return;
                }
                throw new ZipException("Spanned archives not supported");
            }
        } while (j2 >= j);
        throw new ZipException("End Of Central Directory signature not found");
    }
}
