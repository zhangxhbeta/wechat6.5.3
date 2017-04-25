package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.ab;
import com.tencent.pb.common.b.a.a.g;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class i extends d {
    public i(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", this.ppf, "NetSceneRejectVoiceGroup");
        e gVar = new g();
        try {
            gVar.lEs = str;
            gVar.kty = i;
            gVar.ktz = j;
            gVar.bhB = i2;
            this.ppk = 3;
            this.ppl = com.tencent.wecall.talkroom.model.c.bPu().QM(str);
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneRejectVoiceGroup constructor", e);
        }
        c(181, gVar);
    }

    public final int getType() {
        return 207;
    }

    protected final Object bs(byte[] bArr) {
        c.d("MicroMsg.Voip", this.ppf, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (ab) e.a(new ab(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSRejectEnterVoiceRoomReq";
    }
}
