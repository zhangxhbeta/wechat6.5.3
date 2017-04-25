package com.tencent.mm.pluginsdk.model;

import com.tencent.mm.network.p;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.model.app.v;
import com.tencent.mm.protocal.c.zy;
import com.tencent.mm.protocal.c.zz;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.b.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.Iterator;
import java.util.LinkedList;

public final class k extends v {
    public String lzC;

    public k(String str, LinkedList<String> linkedList) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGetUserInfoInApp", "appID: %s", str);
        this.lzC = str;
        a aVar = new a();
        aVar.czn = new zy();
        aVar.czo = new zz();
        aVar.uri = "/cgi-bin/micromsg-bin/getuserinfoinapp";
        this.fut = aVar.Bv();
        zy zyVar = (zy) this.fut.czk.czs;
        zyVar.gkz = str;
        LinkedList linkedList2 = new LinkedList();
        Iterator it = linkedList.iterator();
        while (it.hasNext()) {
            String str2 = (String) it.next();
            if (!be.kS(str2)) {
                linkedList2.add(m.lY(str2));
            }
        }
        zyVar.mfO = linkedList2;
        zyVar.mxK = linkedList.size();
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        com.tencent.mm.sdk.platformtools.v.i("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        if (i2 != 0 || i3 != 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetUserInfoInApp", "errType = " + i2 + ", errCode = " + i3);
        }
    }

    public final byte[] arW() {
        try {
            return ((b) this.fut.Bx()).zf();
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.NetSceneGetUserInfoInApp", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            return null;
        }
    }

    public final void ap(byte[] bArr) {
        if (bArr == null) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetUserInfoInApp", "buf is null");
            return;
        }
        try {
            this.fut.czl.y(bArr);
        } catch (Throwable e) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.NetSceneGetUserInfoInApp", e.getMessage());
            com.tencent.mm.sdk.platformtools.v.a("MicroMsg.NetSceneGetUserInfoInApp", e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
    }

    public final int getType() {
        return 14;
    }
}
