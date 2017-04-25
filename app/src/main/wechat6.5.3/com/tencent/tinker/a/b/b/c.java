package com.tencent.tinker.a.b.b;

import com.tencent.tinker.a.a.j;
import com.tencent.tinker.a.b.a.d;
import com.tencent.tinker.a.b.a.e;
import com.tencent.tinker.a.b.a.f;
import com.tencent.tinker.a.b.a.g;
import com.tencent.tinker.a.b.a.h;

public final class c {
    final b pCN;

    private final class a extends e {
        final /* synthetic */ c pCO;

        a(c cVar, e eVar) {
            this.pCO = cVar;
            super(eVar);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j) {
            super.a(i, i2, dR(i3, i4), i4, i5, j);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6) {
            super.a(i, i2, dR(i3, i4), i4, i5, j, i6);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.a(i, i2, dR(i3, i4), i4, i5, j, i6, i7);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8) {
            super.a(i, i2, dR(i3, i4), i4, i5, j, i6, i7, i8);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9) {
            super.a(i, i2, dR(i3, i4), i4, i5, j, i6, i7, i8, i9);
        }

        public final void a(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7, int i8, int i9, int i10) {
            super.a(i, i2, dR(i3, i4), i4, i5, j, i6, i7, i8, i9, i10);
        }

        public final void b(int i, int i2, int i3, int i4, int i5, long j, int i6, int i7) {
            super.b(i, i2, dR(i3, i4), i4, i5, j, i6, i7);
        }

        private int dR(int i, int i2) {
            switch (i2) {
                case 2:
                    return this.pCO.pCN.zp(i);
                case 3:
                    return this.pCO.pCN.zo(i);
                case 4:
                    return this.pCO.pCN.zr(i);
                case 5:
                    return this.pCO.pCN.zq(i);
                default:
                    return i;
            }
        }
    }

    public c(b bVar) {
        this.pCN = bVar;
    }

    public final short[] a(short[] sArr) {
        com.tencent.tinker.a.b.a.a hVar = new h(sArr.length);
        e cVar = new com.tencent.tinker.a.b.a.c();
        e fVar = new f(hVar, cVar);
        d dVar = new d(new g(sArr));
        try {
            dVar.a(new a(this, cVar));
            dVar.a(new a(this, fVar));
            int i = hVar.pBY;
            if (i == hVar.pCg.length) {
                return hVar.pCg;
            }
            short[] sArr2 = new short[i];
            System.arraycopy(hVar.pCg, 0, sArr2, 0, i);
            return sArr2;
        } catch (Throwable e) {
            throw new j(e);
        }
    }
}
