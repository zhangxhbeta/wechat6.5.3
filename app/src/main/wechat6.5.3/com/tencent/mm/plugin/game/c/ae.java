package com.tencent.mm.plugin.game.c;

import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;

public final class ae implements e {
    ArrayList<a> gjQ;
    private boolean gjR = false;

    public static class a {
        public int dbA;
        public String gjS;

        public static a g(int i, Object... objArr) {
            a aVar = new a();
            aVar.dbA = i;
            StringBuilder stringBuilder = new StringBuilder();
            int length = objArr.length - 1;
            for (int i2 = 0; i2 < length; i2++) {
                stringBuilder.append(String.valueOf(objArr[i2])).append(',');
            }
            stringBuilder.append(String.valueOf(objArr[length]));
            aVar.gjS = stringBuilder.toString();
            if (h.bfc > 0) {
                v.i("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString()});
            } else {
                v.d("MicroMsg.AppReportService", "appStat logID=%d, vals.size=%d, val = %s", new Object[]{Integer.valueOf(i), Integer.valueOf(objArr.length), stringBuilder.toString()});
            }
            return aVar;
        }
    }

    public ae() {
        ak.vy().a(427, this);
        this.gjQ = new ArrayList();
    }

    public final void a(a aVar) {
        if (!this.gjQ.contains(aVar)) {
            this.gjQ.add(aVar);
        }
        arU();
    }

    private void arU() {
        while (!this.gjR) {
            if (this.gjQ == null || this.gjQ.size() == 0) {
                v.d("MicroMsg.AppReportService", "report queue is null, no need do scnene");
                return;
            }
            a aVar = (a) this.gjQ.remove(0);
            if (aVar != null) {
                this.gjR = true;
                ak.vy().a(new com.tencent.mm.pluginsdk.model.app.ak(aVar.dbA, aVar.gjS), 0);
                return;
            }
        }
        v.i("MicroMsg.AppReportService", "is doing scene, wait for a minite");
    }

    public final void a(int i, int i2, String str, k kVar) {
        this.gjR = false;
        arU();
    }
}
