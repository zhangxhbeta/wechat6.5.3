package com.tencent.mm.plugin.exdevice.model;

import com.tencent.mm.network.j;
import com.tencent.mm.network.p;
import com.tencent.mm.plugin.exdevice.service.u;
import com.tencent.mm.protocal.c.abt;
import com.tencent.mm.protocal.c.abx;
import com.tencent.mm.protocal.c.are;
import com.tencent.mm.protocal.c.asr;
import com.tencent.mm.protocal.c.ass;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;

public final class w extends k implements j {
    private e cxf = null;
    String fuC;
    public b fut = null;

    public w(long j, String str, String str2, long j2, long j3, byte[] bArr, int i) {
        v.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "NetSceneSendHardDeviceMsg deviceType = %s, deviceId = %s, sessionId = %d, createTime = %d, data length = %d, msgType = %d", new Object[]{str, str2, Long.valueOf(j2), Long.valueOf(j3), Integer.valueOf(bArr.length), Integer.valueOf(i)});
        this.fuC = str2;
        a aVar = new a();
        aVar.czn = new asr();
        aVar.czo = new ass();
        aVar.czm = 538;
        aVar.uri = "/cgi-bin/micromsg-bin/sendharddevicemsg";
        aVar.czp = 0;
        aVar.czq = 0;
        this.fut = aVar.Bv();
        asr com_tencent_mm_protocal_c_asr = (asr) this.fut.czk.czs;
        abt com_tencent_mm_protocal_c_abt = new abt();
        com_tencent_mm_protocal_c_abt.meq = str;
        com_tencent_mm_protocal_c_abt.eez = str2;
        com_tencent_mm_protocal_c_asr.mgm = com_tencent_mm_protocal_c_abt;
        abx com_tencent_mm_protocal_c_abx = new abx();
        com_tencent_mm_protocal_c_abx.mDf = j2;
        com_tencent_mm_protocal_c_abx.hNS = (int) j3;
        com_tencent_mm_protocal_c_abx.meT = new are().ba(bArr);
        com_tencent_mm_protocal_c_abx.efm = i;
        com_tencent_mm_protocal_c_asr.mRm = com_tencent_mm_protocal_c_abx;
        if (j != 0) {
            com_tencent_mm_protocal_c_asr.mCZ = new are().ba(u.ajV().h(j, 2));
            return;
        }
        com.tencent.mm.plugin.exdevice.h.b sq = ac.ajq().sq(str2);
        if (sq != null) {
            com_tencent_mm_protocal_c_asr.mCZ = new are().ba(sq.field_sessionBuf);
        }
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.exdevice.NetSceneSendHardDeviceMsg", "onGYNetEnd netId = " + i + " errType = " + i2 + " errCode = " + i3 + str);
        this.cxf.a(i2, i3, str, this);
    }

    public final int getType() {
        return 538;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cxf = eVar2;
        return a(eVar, this.fut, this);
    }
}
