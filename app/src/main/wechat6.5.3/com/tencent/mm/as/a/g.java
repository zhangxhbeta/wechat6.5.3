package com.tencent.mm.as.a;

import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.io.RandomAccessFile;

public final class g extends a {
    long dfR;
    long dfS;
    long[] dfW;
    long dfY;
    private long dfZ;
    private long dga;
    private long dgb;
    private long dgc;
    private int[] dgd;
    private int[] dge;
    private int[] dgf;
    private long[] dgg;
    private int[] dgh;
    private int[] dgi;

    public g(int i, long j, int i2, long j2) {
        super(i, j, i2, 0);
    }

    public final void b(RandomAccessFile randomAccessFile) {
        byte[] bArr = new byte[8];
        Object obj = null;
        Object obj2 = null;
        Object obj3 = null;
        Object obj4 = null;
        int read = randomAccessFile.read(bArr);
        while (read >= 8) {
            Object obj5;
            Object obj6;
            Object obj7;
            int k = d.k(bArr, 0);
            int k2 = d.k(bArr, 4);
            long j = 0;
            int i;
            int i2;
            if (k2 == a.dfp) {
                this.dfY = randomAccessFile.getFilePointer();
                if (d.a(randomAccessFile, 4)) {
                    byte[] bArr2 = new byte[8];
                    if (randomAccessFile.read(bArr2, 0, 4) < 4) {
                        v.w("MicroMsg.StblAtom", "stts read entry count error");
                        j = -1;
                    } else {
                        int k3 = d.k(bArr2, 0);
                        long j2 = ((long) k3) * 8;
                        if (j2 > ((long) (k - 16)) || j2 <= 0) {
                            v.w("MicroMsg.StblAtom", "stts error entryCount : " + k3);
                            j = -1;
                        } else {
                            int i3 = 0;
                            int i4 = 0;
                            this.dfW = new long[(((int) (this.dfS / this.dfR)) + 2)];
                            i = 1;
                            this.dfW[0] = 1;
                            j = 0;
                            k2 = randomAccessFile.read(bArr2);
                            while (k2 >= 8) {
                                long j3 = ((long) k2) + j;
                                int k4 = d.k(bArr2, 0);
                                int k5 = d.k(bArr2, 4);
                                int i5 = i3;
                                int i6 = i;
                                i = i4;
                                i4 = 0;
                                k3 = i6;
                                while (i4 < k4) {
                                    i5 += k5;
                                    i3 = i + 1;
                                    while (((long) i5) >= this.dfR && k3 < this.dfW.length) {
                                        i5 = (int) (((long) i5) - this.dfR);
                                        this.dfW[k3] = (long) i3;
                                        k3++;
                                    }
                                    i4++;
                                    i = i3;
                                }
                                if (j3 >= j2) {
                                    v.d("MicroMsg.StblAtom", "read stts Atom end");
                                    long j4 = j3;
                                    k2 = k3;
                                    i2 = i;
                                    j = j4;
                                    break;
                                }
                                i3 = i5;
                                i4 = i;
                                i = k3;
                                j = j3;
                                k2 = randomAccessFile.read(bArr2);
                            }
                            k2 = i;
                            i2 = i4;
                            if (k2 < this.dfW.length) {
                                this.dfW[k2] = (long) i2;
                            }
                            j += 8;
                        }
                    }
                } else {
                    j = -1;
                }
                obj = obj3;
                obj5 = obj2;
                obj6 = 1;
                obj7 = obj4;
            } else if (k2 == a.dfs) {
                j = a(randomAccessFile, k);
                obj5 = obj2;
                obj6 = obj;
                i2 = 1;
                obj7 = obj4;
            } else if (k2 == a.dfu) {
                j = b(randomAccessFile, k);
                i = 1;
                obj6 = obj;
                obj7 = obj4;
                obj = obj3;
            } else if (k2 == a.dfv) {
                j = c(randomAccessFile, k);
                i = 1;
                obj6 = obj;
                obj7 = obj4;
                obj = obj3;
            } else if (k2 == a.dft) {
                j = d(randomAccessFile, k);
                obj7 = 1;
                obj5 = obj2;
                obj6 = obj;
                obj = obj3;
            } else {
                obj7 = obj4;
                obj5 = obj2;
                obj6 = obj;
                obj = obj3;
            }
            if (d.a(randomAccessFile, (((long) k) - j) - ((long) read))) {
                if (obj6 != null && obj5 != null && obj != null && obj7 != null) {
                    v.i("MicroMsg.StblAtom", "read stbl atom finish");
                    break;
                }
                obj4 = obj7;
                obj3 = obj;
                obj2 = obj5;
                read = randomAccessFile.read(bArr);
                obj = obj6;
            } else {
                throw new IOException("skip file error.");
            }
        }
        KJ();
    }

    private long a(RandomAccessFile randomAccessFile, int i) {
        this.dfZ = randomAccessFile.getFilePointer();
        if (!d.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[12];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            v.w("MicroMsg.StblAtom", "stsc read entry count error");
            return -1;
        }
        int k = d.k(bArr, 0);
        long j = 12 * ((long) k);
        if (j > ((long) (i - 16)) || j <= 0) {
            v.w("MicroMsg.StblAtom", "stsc error entryCount : " + k);
            return -1;
        }
        v.d("MicroMsg.StblAtom", "handle stsc entryCount : " + k);
        this.dgd = new int[k];
        this.dge = new int[k];
        int i2 = 0;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 12) {
            j2 += (long) read;
            this.dgd[i2] = d.k(bArr, 0);
            this.dge[i2] = d.k(bArr, 4);
            i2++;
            if (j2 >= j) {
                v.d("MicroMsg.StblAtom", "read stsc atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
        }
        return j2 + 8;
    }

    private long b(RandomAccessFile randomAccessFile, int i) {
        this.dga = randomAccessFile.getFilePointer();
        if (!d.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            v.w("MicroMsg.StblAtom", "stco read entry count error");
            return -1;
        }
        int k = d.k(bArr, 0);
        long j = 4 * ((long) k);
        if (j <= 0 || j > ((long) (i - 16))) {
            v.w("MicroMsg.StblAtom", "stco error entryCount : " + k);
            return -1;
        }
        this.dgf = new int[(k + 1)];
        int i2 = 1;
        long j2 = 0;
        int read = randomAccessFile.read(bArr);
        while (read >= 4) {
            j2 += (long) read;
            int i3 = i2 + 1;
            this.dgf[i2] = d.k(bArr, 0);
            if (j2 >= j) {
                v.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = i3;
        }
        return j2 + 8;
    }

    private long c(RandomAccessFile randomAccessFile, int i) {
        this.dgb = randomAccessFile.getFilePointer();
        if (!d.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[8];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            v.w("MicroMsg.StblAtom", "co64 read entry count error");
            return -1;
        }
        int k = d.k(bArr, 0);
        long j = ((long) k) * 8;
        if (j <= 0 || j > ((long) (i - 16))) {
            v.w("MicroMsg.StblAtom", "stco error entryCount : " + k);
            return -1;
        }
        this.dgg = new long[(k + 1)];
        int read = randomAccessFile.read(bArr);
        int i2 = 1;
        long j2 = 0;
        while (read >= 8) {
            j2 += (long) read;
            k = i2 + 1;
            this.dgg[i2] = d.D(bArr);
            if (j2 >= j) {
                v.d("MicroMsg.StblAtom", "read stco atom end");
                break;
            }
            read = randomAccessFile.read(bArr);
            i2 = k;
        }
        return j2 + 8;
    }

    private long d(RandomAccessFile randomAccessFile, int i) {
        this.dgc = randomAccessFile.getFilePointer();
        if (!d.a(randomAccessFile, 4)) {
            return -1;
        }
        byte[] bArr = new byte[4];
        if (randomAccessFile.read(bArr, 0, 4) < 4) {
            v.w("MicroMsg.StblAtom", "stsz read sample size error");
            return -1;
        }
        int k = d.k(bArr, 0);
        if (k > 0) {
            this.dgh = new int[1];
            this.dgh[0] = k;
            v.i("MicroMsg.StblAtom", "all sample size is the same. size : " + k);
            return 8;
        } else if (randomAccessFile.read(bArr, 0, 4) < 4) {
            v.w("MicroMsg.StblAtom", "stsz read entry count error");
            return -1;
        } else {
            k = d.k(bArr, 0);
            long j = 4 * ((long) k);
            if (j <= 0 || j > ((long) (i - 20))) {
                v.w("MicroMsg.StblAtom", "stco error entryCount : " + k);
                return -1;
            }
            this.dgh = new int[(k + 1)];
            int i2 = 1;
            int read = randomAccessFile.read(bArr);
            long j2 = 0;
            while (read >= 4) {
                j2 += (long) read;
                int i3 = i2 + 1;
                this.dgh[i2] = d.k(bArr, 0);
                if (j2 >= j) {
                    v.d("MicroMsg.StblAtom", "read stsz atom end");
                    break;
                }
                read = randomAccessFile.read(bArr);
                i2 = i3;
            }
            return j2 + 12;
        }
    }

    private boolean KJ() {
        int i;
        int i2;
        int length = (this.dgf != null ? this.dgf.length : this.dgg.length) - 1;
        int length2 = this.dgd.length;
        for (i = 1; i < length2; i++) {
            this.dgd[i - 1] = this.dgd[i] - this.dgd[i - 1];
        }
        this.dgd[length2 - 1] = (length - this.dgd[length2 - 1]) + 1;
        this.dgi = new int[(length + 1)];
        this.dgi[0] = 0;
        i = 1;
        for (i2 = 0; i2 < length2; i2++) {
            int i3 = this.dgd[i2];
            int i4 = this.dge[i2];
            for (length = 0; length < i3; length++) {
                this.dgi[i] = this.dgi[i - 1] + i4;
                i++;
            }
        }
        for (i3 = 0; i3 < this.dfW.length; i3++) {
            long j;
            i4 = (int) this.dfW[i3];
            for (i = 0; i < this.dgi.length; i++) {
                if (i4 <= this.dgi[i]) {
                    i2 = i;
                    break;
                }
            }
            i2 = 0;
            i = this.dgi[i2 - 1] + 1;
            if (this.dgh.length == 1) {
                j = (long) ((i4 - i) * this.dgh[0]);
            } else {
                j = 0;
                for (length2 = i; length2 < i4; length2++) {
                    j += (long) this.dgh[length2];
                }
            }
            long j2 = this.dgf != null ? (long) this.dgf[i2] : this.dgg != null ? this.dgg[i2] : 0;
            this.dfW[i3] = j + j2;
        }
        return true;
    }
}
