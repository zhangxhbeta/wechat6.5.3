package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ah;
import com.tencent.pb.common.b.a.a.k;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class l extends d {
    public int gLN;
    public String gpg;
    public long pIi;

    public l(String str, int i, long j, int i2, int i3) {
        c.d("MicroMsg.Voip", this.ppf, "hello", str, Integer.valueOf(i), Long.valueOf(j));
        e kVar = new k();
        kVar.pqh = i3;
        kVar.kty = i;
        this.gLN = i;
        kVar.ktz = j;
        this.pIi = j;
        kVar.lEs = str;
        this.gpg = str;
        kVar.gGl = i2;
        try {
            this.ppl = com.tencent.wecall.talkroom.model.c.bPu().QM(str);
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneVoiceRoomHello constructor", e);
        }
        c(147, kVar);
    }

    public final int getType() {
        return 205;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (ah) e.a(new ah(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSVoiceRoomHelloReq";
    }
}
