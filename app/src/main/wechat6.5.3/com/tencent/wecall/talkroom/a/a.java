package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ad;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.i;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class a extends d {
    public int gLN = 0;
    public String gpg = null;
    public long pIi = 0;
    public int pJV;
    public int ppl;

    public a(String str, int i, long j, int i2, int i3) {
        c.d("MicroMsg.Voip", this.ppf, "NetSceneAckVoiceGroup");
        e iVar = new i();
        try {
            iVar.lEs = str;
            this.gpg = str;
            iVar.kty = i;
            this.gLN = i;
            iVar.ktz = j;
            this.pIi = j;
            this.pJV = i3;
            this.ppl = i2;
            ai aiVar = new ai();
            aiVar.mQu = 0;
            av avVar = new av();
            avVar.type = 3;
            avVar.psI = aiVar;
            iVar.ppU = avVar;
            this.ppk = 3;
            this.ppl = i2;
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneAckVoiceGroup constructor", e);
        }
        c(189, iVar);
    }

    public final int getType() {
        return 206;
    }

    protected final Object bs(byte[] bArr) {
        c.d("MicroMsg.Voip", this.ppf, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ad) e.a(new ad(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSVoiceAckReq";
    }
}
