package com.tencent.mm.v;

import android.os.Looper;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.platformtools.q;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pointers.PByteArray;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.protocal.MMProtocalJni;
import com.tencent.mm.protocal.ad;
import com.tencent.mm.protocal.c.aow;
import com.tencent.mm.protocal.c.aqx;
import com.tencent.mm.protocal.c.asj;
import com.tencent.mm.protocal.j.g;
import com.tencent.mm.protocal.l.b;
import com.tencent.mm.protocal.l.d;
import com.tencent.mm.protocal.s;
import com.tencent.mm.protocal.z;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;

public final class t extends com.tencent.mm.protocal.i.a {
    private static a cAO;
    private d cAM;
    private byte[] cAN;
    private int type;

    public interface a {
        void br(String str);
    }

    public static void a(a aVar) {
        cAO = aVar;
    }

    public t(d dVar, int i) {
        this.cAM = dVar;
        this.type = i;
    }

    public final boolean a(int i, byte[] bArr, byte[] bArr2) {
        PByteArray pByteArray = new PByteArray();
        if (this.cAM instanceof b) {
            PByteArray pByteArray2 = new PByteArray();
            PInt pInt = new PInt(0);
            b bVar = (b) this.cAM;
            PInt pInt2 = new PInt(0);
            try {
                if (bVar.aRf()) {
                    int y = bVar.y(bArr);
                    v.d("MicroMsg.RemoteResp", "rawData using protobuf ok");
                    this.cAM.lWU = y;
                    if (!be.kS(q.dqm)) {
                        this.cAM.lWV = q.dqm;
                    }
                    return true;
                } else if (MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, pInt2)) {
                    if (i != 701 && i != 702 && CdnLogic.MediaType_FAVORITE_FILE == q.dqj && q.dqk > 0) {
                        if (q.dqk == 2) {
                            ad.y(SQLiteDatabase.KeyEmpty, SQLiteDatabase.KeyEmpty, 0);
                        }
                        q.dqk = 0;
                        pInt.value = -13;
                        v.w("MicroMsg.RemoteResp", "dkcert dktest set session timeout once !");
                    }
                    if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001 || pInt.value == -3002 || pInt.value == -3003) {
                        this.cAM.lWU = pInt.value;
                        if (pInt.value == -3002) {
                            try {
                                this.cAM.lWV = new String(pByteArray2.value);
                            } catch (Exception e) {
                                v.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                            }
                        }
                    } else {
                        v.i("MicroMsg.RemoteResp", "fuckwifi bufToResp using protobuf ok jType:%d, enType:%d errCode:%d, len:%d", Integer.valueOf(i), Integer.valueOf(pInt2.value), Integer.valueOf(bVar.y(pByteArray2.value)), Integer.valueOf(pByteArray2.value.length));
                        this.cAM.lWU = r1;
                    }
                    this.cAM.lWT = (long) bArr.length;
                    this.cAN = pByteArray.value;
                    if (!be.kS(q.dqm)) {
                        this.cAM.lWV = q.dqm;
                    }
                    return true;
                } else {
                    v.e("MicroMsg.RemoteResp", "MMProtocalJni.unpack return false");
                    return false;
                }
            } catch (Throwable e2) {
                v.a("MicroMsg.RemoteResp", e2, "fromProtobuf unbuild exception, check now!", new Object[0]);
                v.e("MicroMsg.RemoteResp", "exception:%s", be.e(e2));
            }
        } else {
            v.f("MicroMsg.RemoteResp", "all protocal should implemented with protobuf");
            return false;
        }
    }

    public static byte[] a(byte[] bArr, byte[] bArr2, PInt pInt, aqx com_tencent_mm_protocal_c_aqx) {
        PByteArray pByteArray = new PByteArray();
        pInt.value = -1;
        PByteArray pByteArray2 = new PByteArray();
        try {
            if (!MMProtocalJni.unpack(pByteArray2, bArr, bArr2, pByteArray, pInt, new PInt(0))) {
                v.e("MicroMsg.RemoteResp", "unpack failed.");
                return null;
            } else if (pInt.value == -13 || pInt.value == -102 || pInt.value == -3001) {
                v.e("MicroMsg.RemoteResp", "unpack failed. error:%d", Integer.valueOf(pInt.value));
                return null;
            } else if (pInt.value == -3002) {
                try {
                    final String str = new String(pByteArray2.value);
                    v.i("MicroMsg.RemoteResp", "bufToRespNoRSA -3002 ERR_IDCDISASTER, errStr:%s", str);
                    new ac(Looper.getMainLooper()).post(new Runnable() {
                        public final void run() {
                            if (!be.kS(str) && t.cAO != null) {
                                t.cAO.br(str);
                            }
                        }
                    });
                    return null;
                } catch (Exception e) {
                    v.e("MicroMsg.RemoteResp", "parse string err while MM_ERR_IDCDISASTER");
                }
            } else {
                v.i("MicroMsg.RemoteResp", "fuckwifi bufToRespNoRSA using protobuf ok jtype:%d enType:%d ", Integer.valueOf(MMGIFException.D_GIF_ERR_CLOSE_FAILED), Integer.valueOf(r5.value));
                com_tencent_mm_protocal_c_aqx.az(pByteArray2.value);
                return pByteArray2.value;
            }
        } catch (Throwable e2) {
            v.a("MicroMsg.RemoteResp", e2, "parseFrom unbuild exception, check now!", new Object[0]);
            v.e("MicroMsg.RemoteResp", "exception:%s", be.e(e2));
        }
    }

    public final byte[] BP() {
        return this.cAN;
    }

    public final String Ch() {
        return this.cAM.lWV;
    }

    public final void gY(String str) {
        this.cAM.lWV = str;
    }

    public final int Ci() {
        return this.cAM.lWU;
    }

    public final void fd(int i) {
        this.cAM.lWU = i;
    }

    public final byte[] uT() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((z.b) this.cAM).dlf;
            case 701:
            case 702:
                return ((g) this.cAM).dlf;
            default:
                return bArr;
        }
    }

    public final byte[] Cj() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                asj com_tencent_mm_protocal_c_asj = ((z.b) this.cAM).lXv.mKY;
                if (com_tencent_mm_protocal_c_asj == null || com_tencent_mm_protocal_c_asj.mdV == null) {
                    v.d("MicroMsg.RemoteResp", "summerauth MMFunc_NewReg SecAuthRegKeySect is null");
                    break;
                }
                return com_tencent_mm_protocal_c_asj.mdV.mQw.toByteArray();
            case 701:
            case 702:
                if (((g) this.cAM).lWG.mXf.mdV != null) {
                    return ((g) this.cAM).lWG.mXf.mdV.mQw.toByteArray();
                }
                break;
        }
        return bArr;
    }

    public final byte[] BR() {
        byte[] bArr = new byte[0];
        switch (this.type) {
            case 126:
                return ((z.b) this.cAM).lWH;
            case 701:
            case 702:
                return ((g) this.cAM).lWH;
            default:
                return bArr;
        }
    }

    public final String Ck() {
        if (this.type == 381) {
            aow com_tencent_mm_protocal_c_aow = ((s.b) this.cAM).lXl.mxg;
            if (com_tencent_mm_protocal_c_aow != null) {
                return be.ma(com_tencent_mm_protocal_c_aow.mOC);
            }
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final String Cl() {
        if (this.type == 381) {
            aow com_tencent_mm_protocal_c_aow = ((s.b) this.cAM).lXl.mxg;
            if (com_tencent_mm_protocal_c_aow != null) {
                return be.ma(com_tencent_mm_protocal_c_aow.mOB);
            }
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final int Cm() {
        if (this.type == 381) {
            return ((s.b) this.cAM).lXl.mwr;
        }
        return 0;
    }

    public final int ww() {
        switch (this.type) {
            case 126:
                return ((z.b) this.cAM).lXv.fvo;
            case 701:
            case 702:
                return ((g) this.cAM).lWG.mXf.fvo;
            default:
                return 0;
        }
    }

    public final String Cn() {
        switch (this.type) {
            case 126:
                return ((z.b) this.cAM).lXv.gln;
            case 701:
            case 702:
                return ((g) this.cAM).dli;
            default:
                return SQLiteDatabase.KeyEmpty;
        }
    }

    public final int getCmdId() {
        return this.cAM.getCmdId();
    }
}
