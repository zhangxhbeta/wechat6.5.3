package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ag;
import com.tencent.pb.common.b.a.a.j;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class h extends d {
    public int gFG;
    public long gFH;
    public String lEs;

    public h(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", this.ppf, "NetSceneRejectVoiceGroup");
        e jVar = new j();
        try {
            jVar.lEs = str;
            jVar.kty = i;
            jVar.ktz = j;
            jVar.gGl = i2;
            jVar.ppW = 2;
            this.ppk = 3;
            this.ppl = com.tencent.wecall.talkroom.model.c.bPu().QM(str);
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneRedirect constructor", e);
        }
        c(211, jVar);
    }

    public final int getType() {
        return 211;
    }

    protected final Object bs(byte[] bArr) {
        c.d("MicroMsg.Voip", this.ppf, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ag) e.a(new ag(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSVoiceRedirectReq";
    }
}
