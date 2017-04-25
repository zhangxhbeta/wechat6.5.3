package com.tencent.mm.pluginsdk.model.app;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.cr;
import com.tencent.mm.protocal.c.cs;
import com.tencent.mm.protocal.c.sj;
import com.tencent.mm.protocal.c.sk;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.b.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public final class ad extends v {
    List<String> lAQ;

    public ad(List<String> list) {
        a aVar = new a();
        aVar.czn = new sj();
        aVar.czo = new sk();
        aVar.uri = "/cgi-bin/micromsg-bin/getappsetting";
        this.fut = aVar.Bv();
        this.lAQ = list;
        v.d("MicroMsg.NetSceneGetAppSetting", "<init>, appIdList size = " + list.size());
        LinkedList linkedList = new LinkedList();
        for (String str : list) {
            if (str != null && str.length() > 0) {
                cs csVar = new cs();
                csVar.gkz = str;
                linkedList.add(csVar);
            }
        }
        if (linkedList.size() == 0) {
            v.e("MicroMsg.NetSceneGetAppSetting", "doScene fail, reqList is empty");
        }
        sj sjVar = (sj) this.fut.czk.czs;
        sjVar.mwl = linkedList;
        sjVar.mwk = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.d("MicroMsg.NetSceneGetAppSetting", "errType = " + i2 + ", errCode = " + i3);
        if (i2 == 0 && i3 == 0) {
            sk skVar = (sk) this.fut.czl.czs;
            v.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, resp appCount = " + skVar.mwk);
            LinkedList linkedList = skVar.mwm;
            if (linkedList == null || linkedList.size() == 0) {
                v.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, settingList is empty");
                return;
            }
            i bnB = am.bnB();
            Iterator it = linkedList.iterator();
            while (it.hasNext()) {
                cr crVar = (cr) it.next();
                f aC = g.aC(crVar.gkz, false);
                if (aC != null) {
                    aC.field_authFlag = crVar.mdj;
                    aC.field_openId = crVar.glA;
                    v.d("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, update ret = " + bnB.a(aC, new String[0]) + ", appId = " + crVar.gkz);
                }
            }
            return;
        }
        v.e("MicroMsg.NetSceneGetAppSetting", "onGYNetEnd, errType = " + i2 + ", errCode = " + i3);
    }

    public final byte[] arW() {
        try {
            return ((b) this.fut.Bx()).zf();
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetAppSetting", "toProtBuf error: " + e.getMessage());
            v.a("MicroMsg.NetSceneGetAppSetting", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public final void ap(byte[] bArr) {
        if (bArr == null) {
            v.e("MicroMsg.NetSceneGetAppSetting", "buf is null");
            return;
        }
        try {
            this.fut.czl.y(bArr);
        } catch (Throwable e) {
            v.e("MicroMsg.NetSceneGetAppSetting", "bufToResp error: " + e.getMessage());
            v.a("MicroMsg.NetSceneGetAppSetting", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final int getType() {
        return 1;
    }
}
