package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.z;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class f extends d {
    public f(String str, int i, long j, int i2) {
        c.d("MicroMsg.Voip", this.ppf, "eixt", str, Integer.valueOf(i), Long.valueOf(j), Integer.valueOf(i2));
        e fVar = new com.tencent.pb.common.b.a.a.f();
        try {
            fVar.lEs = str;
            fVar.kty = i;
            fVar.ktz = j;
            fVar.bhB = i2;
            this.ppk = 2;
            this.ppl = com.tencent.wecall.talkroom.model.c.bPu().QM(str);
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneExitVoiceRoom constructor", e);
        }
        c(143, fVar);
    }

    public final int getType() {
        return 203;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (z) e.a(new z(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSExitVoiceRoomReq";
    }
}
