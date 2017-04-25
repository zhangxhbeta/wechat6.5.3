package com.tencent.mm.plugin.ipcall.a.d;

import com.tencent.mm.network.p;
import com.tencent.mm.protocal.c.atf;
import com.tencent.mm.protocal.c.atg;
import com.tencent.mm.protocal.c.bgg;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.b;
import com.tencent.mm.v.b.a;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.LinkedList;

public final class j extends k implements com.tencent.mm.network.j {
    private b cif = null;
    private e cii;
    private atf gHQ = null;
    public atg gHR = null;

    public j(int i, int i2, LinkedList<bgg> linkedList) {
        a aVar = new a();
        aVar.czn = new atf();
        aVar.czo = new atg();
        aVar.czm = 871;
        aVar.uri = "/cgi-bin/micromsg-bin/sendwcofeedback";
        aVar.czp = 0;
        aVar.czq = 0;
        this.cif = aVar.Bv();
        this.gHQ = (atf) this.cif.czk.czs;
        this.gHQ.mIZ = i2;
        this.gHQ.mRx = linkedList;
        this.gHQ.mRw = linkedList.size();
        this.gHQ.mRy = i;
        v.i("MicroMsg.NetSceneIPCallSendFeedback", "NetSceneIPCallSendFeedback roomid=%d, level=%d, feedbackCount=%d", new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(linkedList.size())});
    }

    public final int getType() {
        return 871;
    }

    public final int a(com.tencent.mm.network.e eVar, e eVar2) {
        this.cii = eVar2;
        return a(eVar, this.cif, this);
    }

    public final void a(int i, int i2, int i3, String str, p pVar, byte[] bArr) {
        v.i("MicroMsg.NetSceneIPCallSendFeedback", "onGYNetEnd, errType: %d, errCode: %d", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)});
        this.gHR = (atg) ((b) pVar).czl.czs;
        if (this.cii != null) {
            this.cii.a(i2, i3, str, this);
        }
    }
}
