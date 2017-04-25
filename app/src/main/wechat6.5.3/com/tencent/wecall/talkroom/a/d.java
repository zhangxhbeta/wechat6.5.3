package com.tencent.wecall.talkroom.a;

import com.google.a.a.e;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.pb.b.a.a;
import com.tencent.pb.common.b.a.a.ai;
import com.tencent.pb.common.b.a.a.ao;
import com.tencent.pb.common.b.a.a.at;
import com.tencent.pb.common.b.a.a.av;
import com.tencent.pb.common.b.a.a.x;
import com.tencent.pb.common.c.c;

public final class d extends com.tencent.pb.common.b.d {
    public int mType;
    public String pIh;
    public boolean pJW = true;

    public d(String str, String[] strArr, byte[] bArr, String str2, at atVar, int i, int i2, long j, String str3, boolean z, String str4) {
        c.d("MicroMsg.Voip", this.ppf, "create");
        e dVar = new com.tencent.pb.common.b.a.a.d();
        try {
            dVar.ppQ = str;
            this.pIh = str;
            dVar.ppV = i;
            this.ppl = i;
            if (atVar != null) {
                dVar.ppX = atVar;
            }
            ao aoVar = new ao();
            aoVar.name = str2;
            aoVar.prP = str4;
            aoVar.prO = a.bMo();
            aoVar.bdW = i2;
            this.mType = i2;
            this.pJW = z;
            aoVar.prI = j;
            dVar.ppS = aoVar;
            dVar.ppZ = strArr;
            if (str3 == null) {
                str3 = SQLiteDatabase.KeyEmpty;
            }
            dVar.ppY = str3;
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
            dVar.ppU = avVar;
            this.ppk = 3;
            dVar.ppW = 2;
        } catch (Exception e) {
            c.i(this.ppf, "NetSceneCreateVoiceGroup constructor", e);
        }
        c(139, dVar);
    }

    public final int getType() {
        return 201;
    }

    protected final Object bs(byte[] bArr) {
        c.d("MicroMsg.Voip", this.ppf, "data2Resp");
        if (bArr == null) {
            return null;
        }
        try {
            return (x) e.a(new x(), bArr, bArr.length);
        } catch (Exception e) {
            c.i(this.ppf, "data2Resp", e.getMessage());
            return null;
        }
    }

    protected final String bLS() {
        return "CsCmd.Cmd_V_CSCreateVoiceGroupReq";
    }
}
