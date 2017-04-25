package com.tencent.mm.plugin.backup.h;

import android.os.Looper;
import com.tencent.mm.a.e;
import com.tencent.mm.jniinterface.AesEcb;
import com.tencent.mm.network.aa;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.backup.g.g;
import com.tencent.mm.protocal.c.dz;
import com.tencent.mm.protocal.c.ea;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.f;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public final class b extends a {
    private static boolean beg = false;
    private static Map<String, Integer> emr = new HashMap();
    private int Tr = 0;
    private int aKG = 0;
    private final String apU;
    public String bNv;
    private com.tencent.mm.v.b cif;
    private final long dgA = 1800000;
    private f egV = null;
    private int ehh = 8192;
    private String emq = SQLiteDatabase.KeyEmpty;
    private final boolean ems;
    private int offset = 0;

    public b(int i, String str, String str2, int i2, String str3, f fVar) {
        int i3 = 0;
        a aVar = new a();
        aVar.czn = new dz();
        aVar.czo = new ea();
        aVar.uri = "/cgi-bin/micromsg-bin/bakchatrecoverdata";
        aVar.czm = 327;
        aVar.czp = 0;
        aVar.czq = 1000000140;
        this.cif = aVar.Bv();
        this.ehh = aa.bk(com.tencent.mm.sdk.platformtools.aa.getContext()) ? 131072 : 16384;
        this.emn = i;
        this.ehp = str;
        this.bNv = str2;
        this.aKG = i2;
        dz dzVar = (dz) this.cif.czk.czs;
        dzVar.meZ = str;
        dzVar.mfa = i;
        dzVar.mcN = str2;
        dzVar.efm = i2;
        this.ems = com.tencent.mm.plugin.backup.g.b.Vl() != null;
        this.egV = fVar;
        this.emq = str3 + "mmbakItem/" + g.pd(str2);
        if (i2 == 2) {
            this.emq = str3 + "mmbakMeida/" + g.pd(str2);
        }
        v.d("MicroMsg.NetSceneBakChatRecoverData", "req recover clientMsgId: " + str2);
        this.apU = this.emn + "," + str + str2;
        Integer num = (Integer) emr.get(this.apU);
        if (num != null) {
            i3 = num.intValue();
        }
        this.offset = i3;
        if (this.offset == 0) {
            com.tencent.mm.loader.stub.b.deleteFile(this.emq + str2);
        }
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

    private boolean WB() {
        dz dzVar = (dz) this.cif.czk.czs;
        dzVar.mfd = 0;
        dzVar.mfc = this.ehh;
        dzVar.mfb = this.offset;
        v.i("MicroMsg.NetSceneBakChatRecoverData", "bakchatSvrID:%s, clientMsgId:%s, req[%d, %d], hasPwd:%b,  downloadSize:%d", Integer.valueOf(this.emn), this.bNv, Integer.valueOf(this.offset), Integer.valueOf(this.cyu), Boolean.valueOf(this.ems), Integer.valueOf(this.ehh));
        return true;
    }

    protected final int a(p pVar) {
        return b.czU;
    }

    protected final int ul() {
        return 1000;
    }

    public final p BD() {
        return this.cif;
    }

    public final int getType() {
        return 327;
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneBakChatRecoverData", "onGYNetEnd errType:" + i2 + " errCode:" + i3);
        if (i2 == 0 && i3 == 0) {
            byte[] aesCryptEcb;
            ea eaVar = (ea) ((com.tencent.mm.v.b) pVar).czl.czs;
            this.offset = eaVar.mfb;
            this.cyu = eaVar.mdz;
            byte[] bArr2 = eaVar.mfg.mQw.lVU;
            if (com.tencent.mm.plugin.backup.g.b.Vl() != null) {
                aesCryptEcb = AesEcb.aesCryptEcb(bArr2, com.tencent.mm.plugin.backup.g.b.Vl(), false, this.offset == this.cyu);
            } else {
                aesCryptEcb = bArr2;
            }
            String str2;
            if (this.cyu == 0 || aesCryptEcb == null || aesCryptEcb.length == 0) {
                String str3 = "MicroMsg.NetSceneBakChatRecoverData";
                str2 = "decode failed, clientMsgId:%s, buflen:%d, offset:%d, totalLen:%d";
                Object[] objArr = new Object[4];
                objArr[0] = this.bNv;
                objArr[1] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
                objArr[2] = Integer.valueOf(this.offset);
                objArr[3] = Integer.valueOf(this.cyu);
                v.e(str3, str2, objArr);
                emr.remove(this.apU);
                this.cii.a(i2, i3, str, this);
                return;
            }
            long length;
            str2 = "MicroMsg.NetSceneBakChatRecoverData";
            String str4 = "resp, clientMsgId:%s, resp.ClientMsgId:%s, buflen:%d, offset:%d, totalLen:%d, endFlag:%d";
            Object[] objArr2 = new Object[6];
            objArr2[0] = this.bNv;
            objArr2[1] = eaVar.mcN;
            objArr2[2] = Integer.valueOf(bArr2 == null ? 0 : bArr2.length);
            objArr2[3] = Integer.valueOf(this.offset);
            objArr2[4] = Integer.valueOf(this.cyu);
            objArr2[5] = Integer.valueOf(eaVar.mfh);
            v.i(str2, str4, objArr2);
            this.emo = aesCryptEcb.length;
            this.Tr = 0;
            if (this.egV != null) {
                new ac(Looper.getMainLooper()).post(new Runnable(this) {
                    final /* synthetic */ b emt;

                    {
                        this.emt = r1;
                    }

                    public final void run() {
                        this.emt.egV.a(this.emt.emo, this.emt.emo, this.emt);
                    }
                });
            }
            String str5 = this.emq;
            String str6 = this.bNv;
            File file = new File(str5 + str6);
            long length2 = file.exists() ? file.length() : 0;
            e.a(str5, str6, aesCryptEcb);
            File file2 = new File(str5 + str6);
            if (file2.exists()) {
                length = file2.length();
            } else {
                length = 0;
            }
            if (length2 == length) {
                v.e("MicroMsg.NetSceneBakChatRecoverData", "append failed and try again:%s", str5 + str6);
                e.a(str5, str6, aesCryptEcb);
            }
            emr.put(this.apU, Integer.valueOf(this.offset));
            if (this.offset != this.cyu || this.cyu == 0) {
                WB();
                if (beg || a(this.czE, this.cii) < 0) {
                    this.cii.a(3, beg ? 9999 : -1, "doScene failed", this);
                    return;
                }
                return;
            }
            emr.remove(this.apU);
            this.cii.a(i2, i3, str, this);
            v.d("MicroMsg.NetSceneBakChatRecoverData", "recover media finish! clientMsgId :" + this.bNv);
            return;
        }
        v.e("MicroMsg.NetSceneBakChatRecoverData", "resp, errType:%d, errCode:%d, clientMsgId:%s, offset:%d, totalLen:%d", Integer.valueOf(i2), Integer.valueOf(i3), this.bNv, Integer.valueOf(this.offset), Integer.valueOf(this.cyu));
        if (i2 == 4 || i3 == -2) {
            emr.remove(this.apU);
        }
        this.cii.a(i2, i3, str, this);
    }
}
