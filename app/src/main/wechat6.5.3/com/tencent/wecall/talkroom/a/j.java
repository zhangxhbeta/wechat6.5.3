package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.af;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class j extends d {
    public String gpg;

    public final int getType() {
        return 213;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (af) e.a(new af(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e);
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSVoiceMemberWhisperReq";
    }
}
