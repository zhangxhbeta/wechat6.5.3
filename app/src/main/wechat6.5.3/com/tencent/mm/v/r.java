package com.tencent.mm.v;

import com.tencent.mm.plugin.zero.a.h;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.ahp;
import com.tencent.mm.protocal.c.do;
import com.tencent.mm.protocal.d;
import com.tencent.mm.protocal.h.a;
import com.tencent.mm.protocal.j;
import com.tencent.mm.protocal.l;
import com.tencent.mm.protocal.l.c;
import com.tencent.mm.protocal.s;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.b.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;

public final class r extends a {
    private static h cAE;
    private byte[] cAF;
    public c czA;
    private int type;

    public static void a(h hVar) {
        cAE = hVar;
    }

    public r(c cVar, int i) {
        this.czA = cVar;
        this.type = i;
    }

    public static boolean a(byte[] bArr, byte[] bArr2, byte[] bArr3, c cVar, ByteArrayOutputStream byteArrayOutputStream, boolean z) {
        if (be.bl(bArr)) {
            String str = "MicroMsg.RemoteReq";
            String str2 = "reqToBufNoRSA session is null :%d";
            Object[] objArr = new Object[1];
            objArr[0] = Integer.valueOf(bArr == null ? -1 : bArr.length);
            v.e(str, str2, objArr);
            return false;
        }
        PByteArray pByteArray = new PByteArray();
        try {
            l.a aVar = (l.a) cVar;
            byte[] zf = aVar.zf();
            if (zf == null) {
                return false;
            }
            if (aVar.aRf()) {
                byteArrayOutputStream.write(zf);
                return true;
            }
            ad brG = ad.brG();
            if (!MMProtocalJni.pack(zf, pByteArray, bArr, bArr2, cVar.lWP, cVar.lWM, aVar.zg(), brG.ver, brG.lXA.getBytes(), brG.lXB.getBytes(), bArr3, z)) {
                return false;
            }
            v.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d", Integer.valueOf(pByteArray.value.length));
            byteArrayOutputStream.write(pByteArray.value);
            return true;
        } catch (Throwable e) {
            v.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e.getMessage());
            v.a("MicroMsg.RemoteReq", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return false;
        }
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2, byte[] bArr3, int i2, boolean z) {
        PByteArray pByteArray = new PByteArray();
        v.d("MicroMsg.RemoteReq", "reqToBuf jType: %d, stack: %s", Integer.valueOf(i), be.bur());
        switch (i) {
            case 268369922:
                try {
                    this.cAF = ((l.a) this.czA).zf();
                    this.czA.lWT = (long) this.cAF.length;
                    return true;
                } catch (Throwable e) {
                    v.a("MicroMsg.RemoteReq", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return false;
                }
            default:
                if (this.czA instanceof l.a) {
                    try {
                        l.a aVar = (l.a) this.czA;
                        byte[] zf = aVar.zf();
                        if (zf == null) {
                            return false;
                        }
                        if (aVar.aRf()) {
                            this.cAF = zf;
                            this.czA.lWT = (long) this.cAF.length;
                            return true;
                        }
                        long j;
                        byte[][] a;
                        Object obj;
                        long j2 = (long) this.czA.lWM;
                        if (b.bsI() && j2 == 0) {
                            j = d.lWg;
                        } else {
                            j = j2;
                        }
                        ad adVar = this.czA.lWS;
                        if (!adVar.brJ()) {
                            bArr = new byte[0];
                        }
                        int i3;
                        switch (i) {
                            case 701:
                                ahp com_tencent_mm_protocal_c_ahp = ((j.d) this.czA).lWD;
                                a = a(j, com_tencent_mm_protocal_c_ahp.mHk, com_tencent_mm_protocal_c_ahp.mHl);
                                i3 = 1;
                                break;
                            case 702:
                                v.e("MicroMsg.RemoteReq", "summer reqToBuf rsaReqData");
                                if (j == 0) {
                                    v.w("MicroMsg.RemoteReq", "summer autoauth uin is invalid!");
                                }
                                do doVar = ((j.a) this.czA).lWB;
                                a = a(j, doVar.met, doVar.meu);
                                i3 = 1;
                                break;
                            default:
                                obj = null;
                                a = null;
                                break;
                        }
                        if (obj == null) {
                            if (cAE != null) {
                                PBool pBool = new PBool();
                                pBool.value = false;
                                if (cAE.a(pBool, pByteArray, this, i, bArr2, bArr3, z)) {
                                    if (!pBool.value) {
                                        return false;
                                    }
                                    if (pByteArray.value != null) {
                                        this.cAF = pByteArray.value;
                                        this.czA.lWT = (long) this.cAF.length;
                                    }
                                    return true;
                                }
                            }
                            if (adVar.brJ() && be.bl(bArr)) {
                                v.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                                return false;
                            }
                            v.d("MicroMsg.RemoteReq", "dkrsa use session :%s  type:%d, ecdh:[%s]", bArr, Integer.valueOf(i), be.bk(bArr3));
                            if (MMProtocalJni.pack(zf, pByteArray, bArr, bArr2, this.czA.lWP, (int) j, aVar.zg(), adVar.ver, adVar.lXA.getBytes(), adVar.lXB.getBytes(), bArr3, z)) {
                                v.d("MicroMsg.RemoteReq", "reqToBuf using protobuf ok, len:%d", Integer.valueOf(pByteArray.value.length));
                                this.cAF = pByteArray.value;
                            }
                            this.czA.lWT = (long) this.cAF.length;
                        } else if (adVar.brJ() && be.bl(bArr)) {
                            v.e("MicroMsg.RemoteReq", "dksession jType %d session should not null", Integer.valueOf(i));
                            return false;
                        } else if (a == null) {
                            return false;
                        } else {
                            byte[] bArr4 = a[0];
                            byte[] bArr5 = a[1];
                            switch (i) {
                                case 702:
                                    if (MMProtocalJni.packDoubleHybrid(pByteArray, bArr2, this.czA.lWP, (int) j, aVar.zg(), adVar.ver, bArr4, bArr5, adVar.lXA.getBytes(), adVar.lXB.getBytes(), Cb(), z)) {
                                        v.d("MicroMsg.RemoteReq", "summer reqToBuf packDoubleHybrid AutoAuth using protobuf ok, len:%d", Integer.valueOf(pByteArray.value.length));
                                        this.cAF = pByteArray.value;
                                        break;
                                    }
                                    break;
                                default:
                                    if (MMProtocalJni.packHybrid(pByteArray, bArr2, this.czA.lWP, (int) j, aVar.zg(), adVar.ver, bArr4, bArr5, adVar.lXA.getBytes(), adVar.lXB.getBytes(), Cb(), z)) {
                                        v.d("MicroMsg.RemoteReq", "MMEncryptCheckResUpdate reqToBuf packHybrid EncryptCheckResUpdate using protobuf ok, len:%d", Integer.valueOf(pByteArray.value.length));
                                        this.cAF = pByteArray.value;
                                        break;
                                    }
                                    break;
                            }
                            this.czA.lWT = (long) this.cAF.length;
                        }
                        return true;
                    } catch (Throwable e2) {
                        v.e("MicroMsg.RemoteReq", "protobuf build exception, check now! :" + e2.getMessage());
                        v.a("MicroMsg.RemoteReq", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                }
                v.f("MicroMsg.RemoteReq", "all protocal should implemented with protobuf");
                return false;
        }
    }

    public static byte[][] a(long j, com.tencent.mm.ba.a aVar, com.tencent.mm.ba.a aVar2) {
        byte[] toByteArray;
        if (j == 0) {
            v.w("MicroMsg.RemoteReq", "toRsaAesByteArray autoauth uin is invalid!");
        }
        try {
            toByteArray = aVar.toByteArray();
        } catch (Throwable e) {
            v.e("MicroMsg.RemoteReq", "toRsaAesByteArray reqToBuf rsaReqData toProtoBuf exception:%s", be.e(e));
            toByteArray = null;
        }
        if (be.bl(toByteArray)) {
            v.e("MicroMsg.RemoteReq", "toRsaAesByteArray reqToBuf rsaReqDataBuf is null and ret false");
            return null;
        }
        byte[] toByteArray2;
        try {
            toByteArray2 = aVar2.toByteArray();
        } catch (Throwable e2) {
            v.e("MicroMsg.RemoteReq", "toRsaAesByteArray reqToBuf aesReqData toProtoBuf exception:%s", be.e(e2));
            toByteArray2 = null;
        }
        if (be.bl(toByteArray2)) {
            v.e("MicroMsg.RemoteReq", "toRsaAesByteArray reqToBuf aesReqDataBuf is null and ret false");
            return null;
        }
        return new byte[][]{toByteArray, toByteArray2};
    }

    public final byte[] BX() {
        return this.cAF;
    }

    public final void B(byte[] bArr) {
        c cVar = this.czA;
        if (bArr == null) {
            bArr = new byte[0];
        }
        cVar.aKD = bArr;
    }

    public final byte[] uT() {
        return this.czA.aKD;
    }

    public final void cW(int i) {
        this.czA.cW(i);
    }

    public final int ww() {
        return this.czA.lWM;
    }

    public final void fb(int i) {
        this.czA.lWN = i;
    }

    public final int getClientVersion() {
        return this.czA.lWN;
    }

    public final void gV(String str) {
        this.czA.lWO = str;
    }

    public final String BY() {
        return this.czA.lWO;
    }

    public final String BZ() {
        return this.czA.lWP;
    }

    public final void gW(String str) {
        this.czA.lWP = str;
    }

    public final void fc(int i) {
        this.czA.lWQ = i;
    }

    public final int Ca() {
        return this.czA.lWQ;
    }

    public final byte[] Cb() {
        v.d("MicroMsg.RemoteReq", "dkrsa getpass type:%d", Integer.valueOf(this.type));
        switch (this.type) {
            case 126:
                return ((z.a) this.czA).lXu.mgD.mQw.toByteArray();
            case 381:
                return ((s.a) this.czA).lXk.mgD.mQw.toByteArray();
            case 701:
                return ((j.d) this.czA).lWD.mHk.mgD.mQw.toByteArray();
            case 702:
                return ((j.a) this.czA).lWB.met.mev.mQw.toByteArray();
            default:
                if (cAE != null) {
                    byte[] a = cAE.a(this.czA, this.type);
                    if (a != null) {
                        return a;
                    }
                }
                return uT();
        }
    }

    public final String getPassword() {
        switch (this.type) {
            case 126:
                return ((z.a) this.czA).lXu.mgI;
            case 701:
                return ((j.d) this.czA).lWD.mHk.mgI;
            default:
                return SQLiteDatabase.KeyEmpty;
        }
    }

    public final String Cc() {
        switch (this.type) {
            case 701:
                return ((j.d) this.czA).lWD.mHk.mgS;
            default:
                return SQLiteDatabase.KeyEmpty;
        }
    }

    public final String getUserName() {
        switch (this.type) {
            case 126:
                return ((z.a) this.czA).lXu.gln;
            case 701:
                return ((j.d) this.czA).lWD.mHk.gln;
            case 702:
                return ((j.a) this.czA).username;
            default:
                return SQLiteDatabase.KeyEmpty;
        }
    }

    public final int getCmdId() {
        return this.czA.getCmdId();
    }

    public final boolean Cd() {
        return this.czA.Cd();
    }
}
