package com.tencent.mm.plugin.ext.voicecontrol;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.ct;
import com.tencent.mm.protocal.c.cu;
import com.tencent.mm.protocal.c.cv;
import com.tencent.mm.protocal.c.cz;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class a extends k implements j {
    public String appId;
    public int bdf = 1;
    b cif;
    private e cii;
    public int cyu;
    public int cyv;
    public int fIn;
    public com.tencent.mm.ba.b fIo;
    public String fIp;
    public cz fIq;
    public ct fIr;
    int fIs = 5000;
    long fIt = 0;
    public int uI;

    public a(int i, String str, int i2, String str2, cz czVar) {
        boolean z = true;
        this.appId = str;
        this.fIn = i;
        this.uI = 1;
        this.cyu = i2;
        this.fIq = czVar;
        this.fIr = null;
        this.fIp = str2;
        String str3 = "MicroMsg.ext.NetSceneAppVoiceControl";
        String str4 = "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, totalLen=%s, controlType=%s, %s, %s";
        Object[] objArr = new Object[7];
        objArr[0] = Integer.valueOf(1);
        objArr[1] = str;
        objArr[2] = Integer.valueOf(i);
        objArr[3] = Integer.valueOf(i2);
        objArr[4] = Integer.valueOf(1);
        if (czVar == null) {
            z = false;
        }
        objArr[5] = Boolean.valueOf(z);
        objArr[6] = Boolean.valueOf(false);
        v.i(str3, str4, objArr);
    }

    public a(int i, String str, ct ctVar, long j) {
        this.appId = str;
        this.fIn = i;
        this.uI = 1;
        this.fIq = null;
        this.fIr = ctVar;
        this.fIt = j;
        v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] new NetSceneAppVoiceControl, opCode=%s, appId=%s, voiceId=%s, controlType=%s, %s, %s", Integer.valueOf(2), str, Integer.valueOf(i), Integer.valueOf(1), Boolean.valueOf(false), Boolean.valueOf(true));
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        if (i2 == 0 && i3 == 0 && pVar != null) {
            v.i("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        } else {
            v.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] onGYNetEnd netId %d , errType %d, errCode %d, %s", Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str);
        }
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        } else {
            v.e("MicroMsg.ext.NetSceneAppVoiceControl", "[voiceControl] callback null");
        }
    }

    public final int getType() {
        return 985;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        com.tencent.mm.v.b.a aVar = new com.tencent.mm.v.b.a();
        aVar.czm = 985;
        aVar.uri = "/cgi-bin/micromsg-bin/appvoicecontrol";
        aVar.czn = new cu();
        aVar.czo = new cv();
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        cu cuVar = (cu) this.cif.czk.czs;
        cuVar.lZm = this.bdf;
        cuVar.glj = this.appId;
        cuVar.mdl = this.fIn;
        cuVar.mdm = this.uI;
        cuVar.mdn = this.fIq;
        cuVar.mdo = this.fIr;
        return a(eVar, this.cif, this);
    }
}
