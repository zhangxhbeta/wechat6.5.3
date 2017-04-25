package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.pb.common.b.a.a.a;
import com.tencent.pb.common.b.a.a.v;
import com.tencent.pb.common.b.d;
import com.tencent.pb.common.c.c;

public final class b extends d {
    public int gLN;
    public String gpg;
    public long pIi;

    public b(String str, int i, long j, String[] strArr) {
        c.d("MicroMsg.Voip", this.ppf, "addmember", str);
        e aVar = new a();
        try {
            aVar.lEs = str;
            this.gpg = str;
            aVar.kty = i;
            this.gLN = i;
            aVar.ktz = j;
            this.pIi = j;
            aVar.ppP = strArr;
            aVar.kty = i;
            this.ppk = 3;
            this.ppl = com.tencent.wecall.talkroom.model.c.bPu().QM(str);
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneAddVoiceGroupMember constructor", e);
        }
        c(145, aVar);
    }

    public final int getType() {
        return 204;
    }

    protected final Object bs(byte[] bArr) {
        if (bArr == null) {
            return null;
        }
        try {
            return (v) e.a(new v(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSAddVoiceGroupMemberReq";
    }
}
