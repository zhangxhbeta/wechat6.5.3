package com.tencent.mm.plugin.sns;

import android.database.Cursor;
import com.tencent.mm.e.a.oj;
import com.tencent.mm.plugin.sns.data.i;
import com.tencent.mm.plugin.sns.e.ad;
import com.tencent.mm.plugin.sns.j.a;
import com.tencent.mm.plugin.sns.storage.l;
import com.tencent.mm.protocal.c.aib;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.v;

public final class k extends c<oj> {
    public k() {
        this.nhz = oj.class.getName().hashCode();
    }

    public final /* synthetic */ boolean a(b bVar) {
        com.tencent.mm.plugin.sns.storage.k kVar = null;
        oj ojVar = (oj) bVar;
        if (ojVar instanceof oj) {
            l aSE = ad.aSE();
            if (aSE != null) {
                Cursor query;
                String zT = i.zT(ojVar.bpr.bpt.gID);
                com.tencent.mm.plugin.sns.storage.k kVar2 = new com.tencent.mm.plugin.sns.storage.k();
                if (aSE.jBU) {
                    query = aSE.cie.query("SnsInfo", null, "snsId=?", new String[]{l.BA(zT)}, null, null, null);
                } else {
                    query = aSE.cie.query("SnsInfo", null, "stringSeq=?", new String[]{zT}, null, null, null);
                }
                if (query.getCount() != 0) {
                    query.moveToFirst();
                    kVar2.b(query);
                    query.close();
                    kVar = kVar2;
                } else {
                    query.close();
                }
                if (kVar != null) {
                    ojVar.bps.aYN = a.a(ojVar.bpr.bpq, kVar, (aib) ojVar.bpr.bpt.mWq.mom.get(0));
                }
            }
            return true;
        }
        v.f("MicroMsg.SnsfillEventMediaListener", "mismatched event");
        return false;
    }
}
