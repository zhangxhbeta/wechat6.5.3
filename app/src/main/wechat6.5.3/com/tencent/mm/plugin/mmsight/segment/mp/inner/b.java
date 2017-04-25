package com.tencent.mm.plugin.mmsight.segment.mp.inner;

import com.tencent.mm.plugin.mmsight.segment.mp.inner.h.k;
import java.util.ArrayList;
import java.util.List;

class b {
    private static final String TAG = b.class.getSimpleName();
    List<e> htE = new ArrayList();
    f htF;
    private d htG;

    public final void a(e eVar) {
        this.htE.add(eVar);
        if (eVar instanceof f) {
            this.htF = (f) eVar;
        } else if (eVar instanceof d) {
            this.htG = (d) eVar;
        }
    }

    public final a eq(boolean z) {
        boolean z2 = false;
        while (!z2) {
            a aVar = null;
            int i = 0;
            for (e eVar : this.htE) {
                a aBg;
                int i2;
                while (true) {
                    aBg = eVar.aBg();
                    if (aBg == null) {
                        break;
                    } else if (eVar == this.htF) {
                        break;
                    } else {
                        eVar.a(aBg, 0);
                    }
                }
                aBg = aVar;
                do {
                } while (eVar.er(false));
                if (eVar.htR) {
                    i2 = i + 1;
                } else {
                    i2 = i;
                }
                aVar = aBg;
                i = i2;
            }
            if (aVar != null) {
                return aVar;
            }
            if (!z) {
                return null;
            }
            z2 = i == this.htE.size();
        }
        return null;
    }

    public final void a(k kVar, long j) {
        for (e a : this.htE) {
            a.a(kVar, j);
        }
    }

    public final void aAZ() {
        for (e eVar : this.htE) {
            if (eVar.htY != null) {
                eVar.a(eVar.htY, 0);
            }
        }
    }

    public final long aBa() {
        long j = Long.MAX_VALUE;
        for (e eVar : this.htE) {
            long j2 = eVar.htX;
            if (j2 == Long.MIN_VALUE || j <= j2) {
                j2 = j;
            }
            j = j2;
        }
        return j;
    }

    public final boolean aBb() {
        int i = 0;
        for (e eVar : this.htE) {
            int i2;
            if (eVar.htR) {
                i2 = i + 1;
            } else {
                i2 = i;
            }
            i = i2;
        }
        if (i == this.htE.size()) {
            return true;
        }
        return false;
    }

    public final long getCachedDuration() {
        long j = Long.MAX_VALUE;
        for (e eVar : this.htE) {
            j = Math.min(eVar.htJ.huf.getCachedDuration(), j);
        }
        if (j == Long.MAX_VALUE) {
            return -1;
        }
        return j;
    }

    public final boolean hasCacheReachedEndOfStream() {
        for (e eVar : this.htE) {
            if (!eVar.htJ.huf.hasCacheReachedEndOfStream()) {
                return false;
            }
        }
        return true;
    }
}
