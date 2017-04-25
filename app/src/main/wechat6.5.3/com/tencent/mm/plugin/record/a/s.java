package com.tencent.mm.plugin.record.a;

import com.tencent.mm.bg.g.c;
import com.tencent.mm.e.a.kh;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;

public final class s implements ag {
    private static HashMap<Integer, c> bXq;
    private l ipK = null;
    private i ipL = null;
    private p ipM = null;
    private h ipN = null;
    private e ipO = null;
    private q ipP = new q();
    private com.tencent.mm.sdk.c.c ipQ = new com.tencent.mm.sdk.c.c<kh>(this) {
        final /* synthetic */ s ipR;

        {
            this.ipR = r2;
            this.nhz = kh.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            kh khVar = (kh) bVar;
            String str = khVar.blo.blq;
            long j = khVar.blo.aYG;
            Iterator it = m.yy(str).cqE.iterator();
            String str2 = "";
            while (it.hasNext()) {
                str2 = str2 + m.c((pw) it.next(), j) + ":";
            }
            khVar.blp.blr = str2;
            return true;
        }
    };

    private static s aJC() {
        s sVar = (s) ak.yP().fY("plugin.record");
        if (sVar != null) {
            return sVar;
        }
        sVar = new s();
        ak.yP().a("plugin.record", sVar);
        return sVar;
    }

    public static l aJD() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aJC().ipK == null) {
            s aJC = aJC();
            ak.yW();
            aJC.ipK = new l(com.tencent.mm.model.c.wE());
        }
        return aJC().ipK;
    }

    public static i aJE() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aJC().ipL == null) {
            s aJC = aJC();
            ak.yW();
            aJC.ipL = new i(com.tencent.mm.model.c.wE());
        }
        return aJC().ipL;
    }

    public static p aJF() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aJC().ipM == null) {
            aJC().ipM = new p();
        }
        return aJC().ipM;
    }

    public static h aJG() {
        ak.yW();
        if (com.tencent.mm.model.c.ww() == 0) {
            throw new com.tencent.mm.model.b();
        }
        if (aJC().ipN == null) {
            aJC().ipN = new h();
        }
        return aJC().ipN;
    }

    static {
        HashMap hashMap = new HashMap();
        bXq = hashMap;
        hashMap.put(Integer.valueOf("RECORD_MSG_INFO_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return l.cic;
            }
        });
        bXq.put(Integer.valueOf("RECORD_MSG_CDN_TABLE".hashCode()), new c() {
            public final String[] pS() {
                return i.cic;
            }
        });
    }

    public final HashMap<Integer, c> ti() {
        return bXq;
    }

    public final void ed(int i) {
    }

    public final void aG(boolean z) {
        v.d("MicroMsg.SubCoreRecordMsg", "on account post reset");
        a.nhr.e(this.ipP);
        a.nhr.e(this.ipQ);
        this.ipO = new e();
        aJE().a(this.ipO);
        ak.yW();
        File file = new File(com.tencent.mm.model.c.xf());
        if (!file.exists() || !file.isDirectory()) {
            v.d("MicroMsg.SubCoreRecordMsg", "record stg dir[%s] not exsit, create it");
            file.mkdirs();
        }
    }

    public final void aH(boolean z) {
    }

    public final void th() {
        v.d("MicroMsg.SubCoreRecordMsg", "on account post release");
        a.nhr.f(this.ipP);
        a.nhr.f(this.ipQ);
        aJE().b(this.ipO);
        this.ipO = null;
        i.a aVar = aJC().ipM;
        if (aVar != null) {
            aVar.finish();
            ak.vy().b(632, aVar);
            aJE().b(aVar);
        }
        f fVar = aJC().ipN;
        if (fVar != null) {
            fVar.finish();
        }
    }
}
