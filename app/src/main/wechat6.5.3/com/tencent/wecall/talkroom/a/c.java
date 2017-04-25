package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.b;
import com.tencent.pb.common.b.a.a.w;
import com.tencent.pb.common.b.d;

public final class c extends d {
    public c(String str, int i, int i2) {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", this.ppf, "NetSceneCancelCreateVoiceGroup");
        e bVar = new b();
        try {
            bVar.ppQ = str;
            bVar.bhB = i;
            this.ppk = 3;
            this.ppl = i2;
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i(this.ppf, "NetSceneCancelCreateVoiceGroup constructor", e);
        }
        c(183, bVar);
    }

    public final int getType() {
        return 208;
    }

    protected final Object bs(byte[] bArr) {
        com.tencent.pb.common.c.c.d("MicroMsg.Voip", this.ppf, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (w) e.a(new w(), bArr, bArr.length);
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSCancelCreateVoiceGroupReq";
    }
}
