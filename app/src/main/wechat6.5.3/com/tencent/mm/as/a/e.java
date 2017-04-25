package com.tencent.mm.as.a;

import com.tencent.mm.sdk.platformtools.v;
import java.io.RandomAccessFile;

public final class e extends a {
    public static final int dfO = d.kT("vide");
    public static final int dfP = d.kT("soun");
    public static final int dfQ = d.kT("hint");
    long dfR = 0;
    long dfS = 0;
    long dfT = 0;
    long dfU = 0;

    public e(int i, long j, int i2, long j2) {
        super(i, j, i2, 0);
    }

    public final boolean a(RandomAccessFile randomAccessFile, byte[] bArr) {
        Object obj;
        Object obj2 = null;
        Object obj3 = null;
        int read = randomAccessFile.read(bArr);
        Object obj4 = null;
        while (read >= 8) {
            long j;
            int k = d.k(bArr, 0);
            int k2 = d.k(bArr, 4);
            int i;
            if (k2 == a.deW) {
                byte[] bArr2 = new byte[4];
                k2 = randomAccessFile.read(bArr2);
                if (k2 < 4) {
                    k2 = -1;
                } else {
                    k2 += 0;
                    if (bArr2[0] == (byte) 0) {
                        if (d.a(randomAccessFile, 8)) {
                            i = k2 + 8;
                            k2 = randomAccessFile.read(bArr);
                            if (k2 < 8) {
                                k2 = -1;
                            } else {
                                i += k2;
                                this.dfR = d.l(bArr, 0);
                                this.dfS = d.l(bArr, 4);
                            }
                        } else {
                            k2 = -1;
                        }
                    } else if (d.a(randomAccessFile, 16)) {
                        k2 += 16;
                        int read2 = randomAccessFile.read(bArr2);
                        if (read2 < 4) {
                            k2 = -1;
                        } else {
                            k2 += read2;
                            this.dfR = d.l(bArr2, 0);
                            i = randomAccessFile.read(bArr);
                            if (i < 8) {
                                k2 = -1;
                            } else {
                                i += k2;
                                this.dfS = d.D(bArr);
                            }
                        }
                    } else {
                        k2 = -1;
                    }
                    k2 = i;
                }
                if (k2 <= 0) {
                    v.w("MicroMsg.MdiaAtom", "handle mdhd atom error.");
                    return false;
                }
                j = (long) ((k - read) - k2);
                obj = obj3;
                obj3 = obj2;
                obj2 = 1;
                obj4 = obj;
            } else if (k2 == a.deX) {
                int read3;
                if (d.a(randomAccessFile, 8)) {
                    read3 = randomAccessFile.read(bArr, 0, 4);
                    if (read3 < 4) {
                        read3 = -1;
                    } else {
                        this.dfT = (long) d.k(bArr, 0);
                        read3 += 8;
                    }
                } else {
                    read3 = -1;
                }
                if (read3 <= 0) {
                    v.w("MicroMsg.MdiaAtom", "handle hdlr atom error.");
                    return false;
                }
                long j2 = (long) ((k - read) - read3);
                obj2 = obj4;
                obj4 = obj3;
                int i2 = 1;
                j = j2;
            } else if (k2 == a.deL) {
                this.dfU = randomAccessFile.getFilePointer() - ((long) read);
                j = (long) (k - read);
                obj3 = obj2;
                obj2 = obj4;
                i = 1;
            } else {
                j = (long) (k - 8);
                obj = obj3;
                obj3 = obj2;
                obj2 = obj4;
                obj4 = obj;
            }
            if (obj2 != null && obj3 != null && obj4 != null) {
                break;
            } else if (!d.a(randomAccessFile, j)) {
                return false;
            } else {
                read = randomAccessFile.read(bArr);
                obj = obj4;
                obj4 = obj2;
                obj2 = obj3;
                obj3 = obj;
            }
        }
        obj = obj3;
        obj3 = obj2;
        obj2 = obj4;
        obj4 = obj;
        return (obj2 == null || obj3 == null || obj4 == null) ? false : true;
    }
}
