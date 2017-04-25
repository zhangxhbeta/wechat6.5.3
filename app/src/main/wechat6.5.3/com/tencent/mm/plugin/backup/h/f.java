package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.eh;
import com.tencent.mm.protocal.c.ei;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import junit.framework.Assert;

public final class f extends a {
    private static boolean beg = false;
    private static Map<String, Integer> emr = new HashMap();
    private static int emx = 10;
    private final String apU;
    private b cif;
    private final long dgA = 1800000;
    private com.tencent.mm.v.f egV = null;
    private String emA = SQLiteDatabase.KeyEmpty;
    private int emy = 100;
    public String emz;
    public String mediaId;
    private int offset = 0;

    public f(int i, String str, String str2, String str3, com.tencent.mm.v.f fVar, String str4) {
        a aVar = new a();
        aVar.czn = new eh();
        aVar.czo = new ei();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatuploadmedia";
        aVar.czm = 324;
        aVar.czp = 0;
        aVar.czq = 1000000137;
        this.cif = aVar.Bv();
        this.emn = i;
        this.ehp = str;
        this.mediaId = str2;
        this.emA = str3;
        this.emz = str4;
        eh ehVar = (eh) this.cif.czk.czs;
        ehVar.meZ = str;
        ehVar.mfa = i;
        ehVar.mfd = 0;
        ehVar.mfh = 0;
        ehVar.mfo = str2;
        this.cyu = e.aQ(this.emA);
        this.apU = i + "," + str + str2;
        Integer num = (Integer) emr.get(this.apU);
        this.offset = num == null ? 0 : num.intValue();
        if (this.cyu <= 0) {
            v.e("MicroMsg.NetSceneBakChatUploadMedia", "error totalen < 0 " + this.emA);
        }
        this.emy = (this.cyu / 8192) + 10;
        if (this.emy < 100) {
            this.emy = 100;
        }
        this.egV = fVar;
        WB();
    }

    public static void pause() {
        beg = true;
    }

    public static void WA() {
        emr.clear();
    }

    protected final void cancel() {
        super.cancel();
        emr.remove(this.apU);
    }

    private static byte[] c(String str, int i, int i2) {
        RandomAccessFile randomAccessFile;
        byte[] bArr;
        Throwable e;
        Throwable th;
        v.i("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile fileName:%s offset:%d len:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        if (be.kS(str)) {
            return null;
        }
        File file = new File(str);
        if (file.exists()) {
            if (i2 == -1) {
                i2 = (int) file.length();
            }
            if (i < 0 || i2 <= 0 || i + i2 > ((int) file.length())) {
                v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile Length error fileName:%s offset:%d len:%d filelen:%d", str, Integer.valueOf(i), Integer.valueOf(i2), Long.valueOf(file.length()));
                return null;
            }
            try {
                randomAccessFile = new RandomAccessFile(str, "r");
                try {
                    bArr = new byte[i2];
                    try {
                        randomAccessFile.seek((long) i);
                        randomAccessFile.readFully(bArr);
                        try {
                            randomAccessFile.close();
                            return bArr;
                        } catch (Throwable e2) {
                            v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile close fileName:%s offset:%d len:%d e:%s", str, Integer.valueOf(i), Integer.valueOf(i2), be.e(e2));
                            return bArr;
                        }
                    } catch (Exception e3) {
                        e2 = e3;
                        try {
                            v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile fileName:%s offset:%d len:%d e:%s", str, Integer.valueOf(i), Integer.valueOf(i2), be.e(e2));
                            if (randomAccessFile != null) {
                                return bArr;
                            }
                            try {
                                randomAccessFile.close();
                                return bArr;
                            } catch (Throwable e22) {
                                v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile close fileName:%s offset:%d len:%d e:%s", str, Integer.valueOf(i), Integer.valueOf(i2), be.e(e22));
                                return bArr;
                            }
                        } catch (Throwable th2) {
                            th = th2;
                            if (randomAccessFile != null) {
                                try {
                                    randomAccessFile.close();
                                } catch (Throwable e222) {
                                    v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile close fileName:%s offset:%d len:%d e:%s", str, Integer.valueOf(i), Integer.valueOf(i2), be.e(e222));
                                }
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th3) {
                    e222 = th3;
                    bArr = null;
                    v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile fileName:%s offset:%d len:%d e:%s", str, Integer.valueOf(i), Integer.valueOf(i2), be.e(e222));
                    if (randomAccessFile != null) {
                        return bArr;
                    }
                    randomAccessFile.close();
                    return bArr;
                }
            } catch (Throwable th32) {
                randomAccessFile = null;
                e222 = th32;
                bArr = null;
                v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile fileName:%s offset:%d len:%d e:%s", str, Integer.valueOf(i), Integer.valueOf(i2), be.e(e222));
                if (randomAccessFile != null) {
                    return bArr;
                }
                randomAccessFile.close();
                return bArr;
            } catch (Throwable th4) {
                th32 = th4;
                randomAccessFile = null;
                if (randomAccessFile != null) {
                    randomAccessFile.close();
                }
                throw th32;
            }
        }
        v.e("MicroMsg.NetSceneBakChatUploadMedia", "dkbak readFromFile file Not Exist fileName:%s offset:%d len:%d", str, Integer.valueOf(i), Integer.valueOf(i2));
        return null;
    }

    private boolean WB() {
        int i;
        int i2 = -1;
        int i3 = aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext()) ? 16384 : 8192;
        int i4 = this.cyu - this.offset;
        if (i4 > i3) {
            i4 = i3;
        }
        byte[] bArr = null;
        i3 = 3;
        while (true) {
            i = i3 - 1;
            if (i3 <= 0) {
                break;
            }
            bArr = c(this.emA, this.offset, i4);
            if (bArr != null) {
                break;
            }
            i3 = i;
        }
        i = bArr == null ? -1 : bArr.length;
        int length = com.tencent.mm.plugin.backup.g.b.Vl() == null ? -1 : com.tencent.mm.plugin.backup.g.b.Vl().length;
        if (length > 0) {
            boolean z;
            byte[] Vl = com.tencent.mm.plugin.backup.g.b.Vl();
            if (this.offset + i4 >= this.cyu) {
                z = true;
            } else {
                z = false;
            }
            byte[] aesCryptEcb = AesEcb.aesCryptEcb(bArr, Vl, true, z);
            if (aesCryptEcb == null || aesCryptEcb.length % 2 <= 0) {
                bArr = aesCryptEcb;
            } else {
                String str = "MicroMsg.NetSceneBakChatUploadMedia";
                String str2 = "dkbak onPreDoScene ERROR aesCryptEcb Buf Size Wrong . len[%d,%d] pwd:%d offset:%d dataLen:%d total[%d %d] . mediaid:%s path:%s";
                Object[] objArr = new Object[9];
                objArr[0] = Integer.valueOf(i);
                if (aesCryptEcb != null) {
                    i2 = aesCryptEcb.length;
                }
                objArr[1] = Integer.valueOf(i2);
                objArr[2] = Integer.valueOf(length);
                objArr[3] = Integer.valueOf(this.offset);
                objArr[4] = Integer.valueOf(i4);
                objArr[5] = Integer.valueOf(i4 + this.offset);
                objArr[6] = Integer.valueOf(this.cyu);
                objArr[7] = this.mediaId;
                objArr[8] = this.emA;
                v.e(str, str2, objArr);
                i3 = emx;
                emx = i3 - 1;
                if (i3 >= 0) {
                    return false;
                }
                Assert.assertTrue("aesCryptEcb Buf Size Wrong too much ", false);
                return false;
            }
        }
        if (this.offset + i4 > this.cyu || this.offset < 0 || i4 < 0 || this.cyu < 0) {
            str2 = "MicroMsg.NetSceneBakChatUploadMedia";
            String str3 = "dkbak onPreDoScene Warn Check file Read Lens . len[%d,%d] pwd:%d offset:%d dataLen:%d total[%d %d] . mediaid:%s path:%s";
            Object[] objArr2 = new Object[9];
            objArr2[0] = Integer.valueOf(i);
            objArr2[1] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            objArr2[2] = Integer.valueOf(length);
            objArr2[3] = Integer.valueOf(this.offset);
            objArr2[4] = Integer.valueOf(i4);
            objArr2[5] = Integer.valueOf(this.offset + i4);
            objArr2[6] = Integer.valueOf(this.cyu);
            objArr2[7] = this.mediaId;
            objArr2[8] = this.emA;
            v.w(str2, str3, objArr2);
        }
        if (bArr == null || bArr.length <= 0) {
            String str4 = "MicroMsg.NetSceneBakChatUploadMedia";
            str2 = "dkbak onPreDoScene ERROR buf is null. len[%d,%d] pwd:%d offset:%d dataLen:%d total[%d %d] . mediaid:%s path:%s";
            objArr = new Object[9];
            objArr[0] = Integer.valueOf(i);
            if (bArr != null) {
                i2 = bArr.length;
            }
            objArr[1] = Integer.valueOf(i2);
            objArr[2] = Integer.valueOf(length);
            objArr[3] = Integer.valueOf(this.offset);
            objArr[4] = Integer.valueOf(i4);
            objArr[5] = Integer.valueOf(i4 + this.offset);
            objArr[6] = Integer.valueOf(this.cyu);
            objArr[7] = this.mediaId;
            objArr[8] = this.emA;
            v.e(str4, str2, objArr);
            return false;
        }
        are com_tencent_mm_protocal_c_are = new are();
        com_tencent_mm_protocal_c_are.ba(bArr);
        eh ehVar = (eh) this.cif.czk.czs;
        ehVar.mfg = com_tencent_mm_protocal_c_are;
        ehVar.mff = bArr.length;
        ehVar.mfb = this.offset;
        ehVar.mfd = 0;
        if (this.offset + bArr.length >= this.cyu) {
            ehVar.mfh = 1;
        }
        str2 = "MicroMsg.NetSceneBakChatUploadMedia";
        str3 = "dkbak onPreDoScene len[%d,%d] pwd:%d offset:%d dataLen:%d total[%d %d] Req skb[%d,%d] endflag:%d mediaid:%s path:%s";
        objArr2 = new Object[12];
        objArr2[0] = Integer.valueOf(i);
        if (bArr != null) {
            i2 = bArr.length;
        }
        objArr2[1] = Integer.valueOf(i2);
        objArr2[2] = Integer.valueOf(length);
        objArr2[3] = Integer.valueOf(this.offset);
        objArr2[4] = Integer.valueOf(i4);
        objArr2[5] = Integer.valueOf(i4 + this.offset);
        objArr2[6] = Integer.valueOf(this.cyu);
        objArr2[7] = Integer.valueOf(ehVar.mfg.mQu);
        objArr2[8] = Integer.valueOf(ehVar.mff);
        objArr2[9] = Integer.valueOf(ehVar.mfh);
        objArr2[10] = this.mediaId;
        objArr2[11] = this.emA;
        v.i(str2, str3, objArr2);
        this.emo = bArr.length;
        return true;
    }

    public final p BD() {
        return this.cif;
    }

    public final int getType() {
        return 324;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return this.emy;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        ei eiVar = (ei) ((b) pVar).czl.czs;
        if (eiVar != null) {
            v.i("MicroMsg.NetSceneBakChatUploadMedia", "dkbak onGYNetEnd [%d,%d,%s] BakChatSvrId:%d EndFlag:%d MaxLength:%d Offset:%d mediaId:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, Integer.valueOf(eiVar.mfa), Integer.valueOf(eiVar.mfh), Integer.valueOf(eiVar.mfc), Integer.valueOf(eiVar.mfb), this.mediaId);
        } else {
            v.i("MicroMsg.NetSceneBakChatUploadMedia", "dkbak onGYNetEnd [%d,%d,%s] mediaId:%s", Integer.valueOf(i2), Integer.valueOf(i3), str, this.mediaId);
        }
        if (i2 == 4) {
            this.cii.a(i2, i3, str, this);
        } else if (i2 != 0 || i3 != 0) {
            this.cii.a(i2, i3, str, this);
        } else if (eiVar.mfb < 0 || (eiVar.mfb > this.cyu && this.cyu > 0)) {
            this.cii.a(i2, i3, str, this);
        } else if (eiVar.mfb < this.offset) {
            v.e("MicroMsg.NetSceneBakChatUploadMedia", "onGYNetEnd, offset invalid(%d < %d), drop this media:%s", Integer.valueOf(eiVar.mfb), Integer.valueOf(this.offset), this.mediaId);
            this.cii.a(i2, i3, str, this);
        } else {
            this.offset = eiVar.mfb;
            emr.put(this.apU, Integer.valueOf(this.offset));
            if (this.egV != null) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ f emB;

                    {
                        this.emB = r1;
                    }

                    public final void run() {
                        this.emB.egV.a(this.emB.emo, this.emB.emo, this.emB);
                    }
                });
            }
            if (this.offset == this.cyu && this.cyu != 0) {
                emr.remove(this.apU);
                this.cii.a(i2, i3, str, this);
                v.i("MicroMsg.NetSceneBakChatUploadMedia", "dkbak onGYNetEnd upload media finish total:%d mediaid:%s path:%s", Integer.valueOf(this.cyu), this.mediaId, this.emA);
            } else if (!WB()) {
                this.cii.a(3, beg ? 9999 : -1, "doScene failed", this);
            } else if (beg || a(this.czE, this.cii) < 0) {
                this.cii.a(3, beg ? 9999 : -1, "doScene failed", this);
            }
        }
    }
}
