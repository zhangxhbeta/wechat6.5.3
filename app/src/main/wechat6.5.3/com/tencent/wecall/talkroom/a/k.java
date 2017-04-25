package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ac;
import com.tencent.pb.common.b.a.a.h;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class k extends d {
    public int gLN;
    public String gpg;
    public long pIi;

    public k(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", this.ppf, "NetSceneSwitchVideoGroup");
        e hVar = new h();
        try {
            hVar.lEs = str;
            this.gpg = str;
            hVar.gFG = i;
            this.gLN = i;
            hVar.gFH = j;
            this.pIi = j;
            hVar.action = i2;
            this.ppk = 3;
            this.ppl = com.tencent.wecall.talkroom.model.c.bPu().QM(str);
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneSwitchVideoGroup constructor", e);
        }
        c(243, hVar);
    }

    public final int getType() {
        return 214;
    }

    protected final Object bs(byte[] bArr) {
        c.d("MicroMsg.Voip", this.ppf, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ac) e.a(new ac(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSSwitchVideoGroupReq";
    }
}
