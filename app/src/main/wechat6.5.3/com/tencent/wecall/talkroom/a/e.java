package com.tencent.wecall.talkroom.a;

import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.y;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class e extends d {
    public int gLN = 0;
    public String gpg = null;
    public long pIi = 0;
    public int pJX = 0;

    public e(e eVar) {
        this.gpg = eVar.gpg;
        this.gLN = eVar.gLN;
        this.pIi = eVar.pIi;
        this.pJX = eVar.pJX;
        this.pph = eVar.pph;
        this.ppj = eVar.ppj;
        this.ppl = eVar.ppl;
        this.ppk = 1;
    }

    public e(String str, int i, long j, byte[] bArr, int i2, int i3) {
        c.d("MicroMsg.Voip", this.ppf, "enter", str, Integer.valueOf(i), Long.valueOf(j));
        com.google.a.a.e eVar = new com.tencent.pb.common.b.a.a.e();
        try {
            eVar.lEs = str;
            this.gpg = str;
            eVar.kty = i;
            this.gLN = i;
            eVar.ktz = j;
            this.pIi = j;
            eVar.pqc = i3;
            this.pJX = i3;
            ai aiVar = new ai();
            if (bArr != null) {
                aiVar.buffer = bArr;
                aiVar.mQu = bArr.length;
            } else {
                aiVar.mQu = 0;
            }
            av avVar = new av();
            avVar.type = 3;
            avVar.psI = aiVar;
            eVar.ppU = avVar;
            this.ppk = 2;
            this.ppl = i2;
            eVar.ppW = 2;
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneEnterVoiceRoom constructor", e);
        }
        c(141, eVar);
    }

    public final int getType() {
        return 202;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (y) com.google.a.a.e.a(new y(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSEnterVoiceRoomReq";
    }
}
