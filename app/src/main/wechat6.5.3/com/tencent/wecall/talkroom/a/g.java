package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.aa;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class g extends d {
    public String gpg;

    public final int getType() {
        return 209;
    }

    protected final Object bs(byte[] bArr) {
        c.d("MicroMsg.Voip", this.ppf, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (aa) e.a(new aa(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSModifyVoiceGroupInfoReq";
    }
}
