package android.support.v7.widget;

import android.support.v4.e.e;
import android.support.v7.widget.RecyclerView.s;

final class ar {
    final android.support.v4.e.a<s, a> aeK = new android.support.v4.e.a();
    final e<s> aeL = new e();

    static class a {
        static android.support.v4.e.h.a<a> aeO = new android.support.v4.e.h.b(20);
        android.support.v7.widget.RecyclerView.e.b aeM;
        android.support.v7.widget.RecyclerView.e.b aeN;
        int flags;

        private a() {
        }

        static a hf() {
            a aVar = (a) aeO.bJ();
            return aVar == null ? new a() : aVar;
        }

        static void a(a aVar) {
            aVar.flags = 0;
            aVar.aeM = null;
            aVar.aeN = null;
            aeO.i(aVar);
        }

        static void hg() {
            do {
            } while (aeO.bJ() != null);
        }
    }

    interface b {
        void a(s sVar, android.support.v7.widget.RecyclerView.e.b bVar, android.support.v7.widget.RecyclerView.e.b bVar2);

        void b(s sVar, android.support.v7.widget.RecyclerView.e.b bVar, android.support.v7.widget.RecyclerView.e.b bVar2);

        void c(s sVar, android.support.v7.widget.RecyclerView.e.b bVar, android.support.v7.widget.RecyclerView.e.b bVar2);

        void i(s sVar);
    }

    ar() {
    }

    final void clear() {
        this.aeK.clear();
        e eVar = this.aeL;
        int i = eVar.hO;
        Object[] objArr = eVar.vE;
        for (int i2 = 0; i2 < i; i2++) {
            objArr[i2] = null;
        }
        eVar.hO = 0;
        eVar.vC = false;
    }

    final void b(s sVar, android.support.v7.widget.RecyclerView.e.b bVar) {
        a aVar = (a) this.aeK.get(sVar);
        if (aVar == null) {
            aVar = a.hf();
            this.aeK.put(sVar, aVar);
        }
        aVar.aeM = bVar;
        aVar.flags |= 4;
    }

    final boolean z(s sVar) {
        a aVar = (a) this.aeK.get(sVar);
        return (aVar == null || (aVar.flags & 1) == 0) ? false : true;
    }

    final android.support.v7.widget.RecyclerView.e.b b(s sVar, int i) {
        android.support.v7.widget.RecyclerView.e.b bVar = null;
        int indexOfKey = this.aeK.indexOfKey(sVar);
        if (indexOfKey >= 0) {
            a aVar = (a) this.aeK.valueAt(indexOfKey);
            if (!(aVar == null || (aVar.flags & i) == 0)) {
                aVar.flags &= i ^ -1;
                if (i == 4) {
                    bVar = aVar.aeM;
                } else if (i == 8) {
                    bVar = aVar.aeN;
                } else {
                    throw new IllegalArgumentException("Must provide flag PRE or POST");
                }
                if ((aVar.flags & 12) == 0) {
                    this.aeK.removeAt(indexOfKey);
                    a.a(aVar);
                }
            }
        }
        return bVar;
    }

    final void a(long j, s sVar) {
        this.aeL.put(j, sVar);
    }

    final void c(s sVar, android.support.v7.widget.RecyclerView.e.b bVar) {
        a aVar = (a) this.aeK.get(sVar);
        if (aVar == null) {
            aVar = a.hf();
            this.aeK.put(sVar, aVar);
        }
        aVar.aeN = bVar;
        aVar.flags |= 8;
    }

    final void A(s sVar) {
        a aVar = (a) this.aeK.get(sVar);
        if (aVar == null) {
            aVar = a.hf();
            this.aeK.put(sVar, aVar);
        }
        r0.flags |= 1;
    }

    final void B(s sVar) {
        a aVar = (a) this.aeK.get(sVar);
        if (aVar != null) {
            aVar.flags &= -2;
        }
    }

    final void a(b bVar) {
        for (int size = this.aeK.size() - 1; size >= 0; size--) {
            s sVar = (s) this.aeK.keyAt(size);
            a aVar = (a) this.aeK.removeAt(size);
            if ((aVar.flags & 3) == 3) {
                bVar.i(sVar);
            } else if ((aVar.flags & 1) != 0) {
                if (aVar.aeM == null) {
                    bVar.i(sVar);
                } else {
                    bVar.a(sVar, aVar.aeM, aVar.aeN);
                }
            } else if ((aVar.flags & 14) == 14) {
                bVar.b(sVar, aVar.aeM, aVar.aeN);
            } else if ((aVar.flags & 12) == 12) {
                bVar.c(sVar, aVar.aeM, aVar.aeN);
            } else if ((aVar.flags & 4) != 0) {
                bVar.a(sVar, aVar.aeM, null);
            } else if ((aVar.flags & 8) != 0) {
                bVar.b(sVar, aVar.aeM, aVar.aeN);
            } else {
                int i = aVar.flags;
            }
            a.a(aVar);
        }
    }

    final void C(s sVar) {
        a aVar;
        for (int size = this.aeL.size() - 1; size >= 0; size--) {
            if (sVar == this.aeL.valueAt(size)) {
                e eVar = this.aeL;
                if (eVar.vE[size] != e.vB) {
                    eVar.vE[size] = e.vB;
                    eVar.vC = true;
                }
                aVar = (a) this.aeK.remove(sVar);
                if (aVar != null) {
                    a.a(aVar);
                }
            }
        }
        aVar = (a) this.aeK.remove(sVar);
        if (aVar != null) {
            a.a(aVar);
        }
    }
}
