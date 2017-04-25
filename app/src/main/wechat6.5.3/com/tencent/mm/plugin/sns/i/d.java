package com.tencent.mm.plugin.sns.i;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.c;
import com.tencent.mm.storage.q;
import com.tencent.mm.storage.t;
import java.util.HashMap;
import java.util.Map;

public final class d {
    public static d jtP = new d();
    public q bYA;
    public int cNA = 0;
    public HashMap<String, Integer> jtQ;
    public int jtR = 200;
    public int jtS = 86400;

    private d() {
        c Ls = com.tencent.mm.model.c.c.Au().Ls("100077");
        if (Ls.isValid()) {
            Map buX = Ls.buX();
            this.jtR = be.getInt((String) buX.get("maxCacheFeedCount"), 200);
            this.jtS = be.getInt((String) buX.get("maxCacheSeconds"), 86400);
            this.cNA = be.getInt((String) buX.get("needUploadData"), 0);
        }
        v.i("MicroMsg.SnsReportHelper", "initAbtestArg maxCacheFeedCount:%d, maxCacheSeconds:%d, needUploadData:%d", new Object[]{Integer.valueOf(this.jtR), Integer.valueOf(this.jtS), Integer.valueOf(this.cNA)});
        this.bYA = new q(t.cng + "snsreport.cfg");
        Object obj = this.bYA.get(3, new HashMap());
        if (obj instanceof HashMap) {
            this.jtQ = (HashMap) obj;
            return;
        }
        FileOp.deleteFile(t.cng + "snsreport.cfg");
        this.jtQ = new HashMap();
    }

    public final void Bb(String str) {
        if (this.cNA != 0) {
            this.jtQ.put(str, Integer.valueOf(this.jtQ.containsKey(str) ? ((Integer) this.jtQ.get(str)).intValue() + 1 : 1));
        }
    }
}
