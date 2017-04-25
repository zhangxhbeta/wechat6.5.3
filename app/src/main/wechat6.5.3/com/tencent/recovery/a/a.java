package com.tencent.recovery.a;

import com.tencent.recovery.c;
import com.tencent.recovery.model.RecoveryExceptionItem;
import java.util.ArrayList;
import java.util.List;

public final class a {
    private static final String TAG = (com.tencent.recovery.a.ptH + "Recovery.RecoveryExpress");
    public List<List<b>> ptV;

    public static final class a {
        private List<List<b>> ptV = new ArrayList();

        public final void cJ(List<b> list) {
            this.ptV.add(list);
        }

        public final a bMB() {
            a aVar = new a();
            aVar.ptV = this.ptV;
            return aVar;
        }
    }

    public static class b {
        int count;
        int dyp;
        int ptW;
        int type;

        private b() {
        }

        public b(int i, int i2) {
            this.ptW = i;
            this.dyp = 0;
            this.type = i2;
            this.count = 3;
        }

        public final String toString() {
            return this.ptW + " " + this.dyp + " " + this.type + " " + this.count;
        }
    }

    public final String toString() {
        return this.ptV.toString();
    }

    private a() {
    }

    public final boolean a(c cVar) {
        for (List<b> list : this.ptV) {
            boolean z;
            List<RecoveryExceptionItem> list2 = cVar.ptS;
            for (b bVar : list) {
                int i = 0;
                for (RecoveryExceptionItem recoveryExceptionItem : list2) {
                    if ((bVar.ptW != 1 || recoveryExceptionItem.pua) && (!(bVar.ptW == 2 && recoveryExceptionItem.pua) && ((bVar.dyp == 0 || bVar.dyp == recoveryExceptionItem.dyp) && (bVar.type == 0 || bVar.type == recoveryExceptionItem.type)))) {
                        i++;
                    }
                }
                if (bVar.count > i) {
                    z = false;
                    continue;
                    break;
                }
            }
            z = true;
            continue;
            if (z) {
                return true;
            }
        }
        return false;
    }
}
