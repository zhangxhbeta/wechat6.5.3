package com.tencent.mm.plugin.appbrand.k;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public final class f {
    private static final Comparator<e> dSS = new Comparator<e>() {
        public final /* bridge */ /* synthetic */ int compare(Object obj, Object obj2) {
            e eVar = (e) obj;
            e eVar2 = (e) obj2;
            int i = eVar.x - eVar2.x;
            return i == 0 ? eVar.y - eVar2.y : i;
        }
    };

    public static abstract class a {
        public abstract int Sf();

        public abstract int Sg();

        public abstract boolean ba(int i, int i2);

        public abstract boolean bb(int i, int i2);

        public Object bc(int i, int i2) {
            return null;
        }
    }

    public static class b {
        public final List<e> dST;
        public final int[] dSU;
        private final int[] dSV;
        public final a dSW;
        public final int dSX;
        public final int dSY;
        private final boolean dSZ = true;

        class AnonymousClass1 implements g {
            final /* synthetic */ android.support.v7.widget.RecyclerView.a dTa;
            final /* synthetic */ b dTb;

            public AnonymousClass1(b bVar, android.support.v7.widget.RecyclerView.a aVar) {
                this.dTb = bVar;
                this.dTa = aVar;
            }

            public final void be(int i, int i2) {
                this.dTa.P(i, i2);
            }

            public final void bf(int i, int i2) {
                this.dTa.Q(i, i2);
            }

            public final void bg(int i, int i2) {
                this.dTa.O(i, i2);
            }

            public final void d(int i, int i2, Object obj) {
                this.dTa.b(i, i2, obj);
            }
        }

        b(a aVar, List<e> list, int[] iArr, int[] iArr2, boolean z) {
            this.dST = list;
            this.dSU = iArr;
            this.dSV = iArr2;
            Arrays.fill(this.dSU, 0);
            Arrays.fill(this.dSV, 0);
            this.dSW = aVar;
            this.dSX = aVar.Sf();
            this.dSY = aVar.Sg();
            e eVar = this.dST.isEmpty() ? null : (e) this.dST.get(0);
            if (!(eVar != null && eVar.x == 0 && eVar.y == 0)) {
                eVar = new e();
                eVar.x = 0;
                eVar.y = 0;
                eVar.dTe = false;
                eVar.size = 0;
                eVar.dTj = false;
                this.dST.add(0, eVar);
            }
            Sp();
        }

        private void Sp() {
            int i = this.dSX;
            int i2 = this.dSY;
            for (int size = this.dST.size() - 1; size >= 0; size--) {
                e eVar = (e) this.dST.get(size);
                int i3 = eVar.x + eVar.size;
                int i4 = eVar.y + eVar.size;
                if (this.dSZ) {
                    while (i > i3) {
                        if (this.dSU[i - 1] == 0) {
                            d(i, i2, size, false);
                        }
                        i--;
                    }
                    while (i2 > i4) {
                        if (this.dSV[i2 - 1] == 0) {
                            d(i, i2, size, true);
                        }
                        i2--;
                    }
                }
                for (i2 = 0; i2 < eVar.size; i2++) {
                    i3 = eVar.x + i2;
                    i4 = eVar.y + i2;
                    i = this.dSW.bb(i3, i4) ? 1 : 2;
                    this.dSU[i3] = (i4 << 5) | i;
                    this.dSV[i4] = i | (i3 << 5);
                }
                i = eVar.x;
                i2 = eVar.y;
            }
        }

        private boolean d(int i, int i2, int i3, boolean z) {
            int i4;
            int i5;
            int i6 = 8;
            if (z) {
                int i7 = i2 - 1;
                i2--;
                i4 = i;
                i5 = i7;
            } else {
                i5 = i - 1;
                i4 = i - 1;
            }
            while (i3 >= 0) {
                e eVar = (e) this.dST.get(i3);
                int i8 = eVar.x + eVar.size;
                int i9 = eVar.y + eVar.size;
                if (z) {
                    for (i4--; i4 >= i8; i4--) {
                        if (this.dSW.ba(i4, i5)) {
                            i7 = this.dSW.bb(i4, i5) ? 8 : 4;
                            this.dSV[i5] = (i4 << 5) | 16;
                            this.dSU[i4] = i7 | (i5 << 5);
                            return true;
                        }
                    }
                    continue;
                } else {
                    for (i4 = i2 - 1; i4 >= i9; i4--) {
                        if (this.dSW.ba(i5, i4)) {
                            if (!this.dSW.bb(i5, i4)) {
                                i6 = 4;
                            }
                            this.dSU[i - 1] = (i4 << 5) | 16;
                            this.dSV[i4] = i6 | ((i - 1) << 5);
                            return true;
                        }
                    }
                    continue;
                }
                i4 = eVar.x;
                i2 = eVar.y;
                i3--;
            }
            return false;
        }

        private static c a(List<c> list, int i, boolean z) {
            for (int size = list.size() - 1; size >= 0; size--) {
                c cVar = (c) list.get(size);
                if (cVar.dTc == i && cVar.dTe == z) {
                    list.remove(size);
                    for (int i2 = size; i2 < list.size(); i2++) {
                        c cVar2 = (c) list.get(i2);
                        cVar2.dTd = (z ? 1 : -1) + cVar2.dTd;
                    }
                    return cVar;
                }
            }
            return null;
        }

        public final void a(List<c> list, g gVar, int i, int i2, int i3) {
            if (this.dSZ) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.dSV[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            gVar.be(i, 1);
                            for (c cVar : list) {
                                cVar.dTd++;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.dSV[i3 + i4] >> 5;
                            gVar.bg(a(list, i6, true).dTd, i);
                            if (i5 != 4) {
                                break;
                            }
                            gVar.d(i, 1, this.dSW.bc(i6, i3 + i4));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i, false));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            gVar.be(i, i2);
        }

        public final void b(List<c> list, g gVar, int i, int i2, int i3) {
            if (this.dSZ) {
                for (int i4 = i2 - 1; i4 >= 0; i4--) {
                    int i5 = this.dSU[i3 + i4] & 31;
                    switch (i5) {
                        case 0:
                            gVar.bf(i + i4, 1);
                            for (c cVar : list) {
                                cVar.dTd--;
                            }
                            break;
                        case 4:
                        case 8:
                            int i6 = this.dSU[i3 + i4] >> 5;
                            c a = a(list, i6, false);
                            gVar.bg(i + i4, a.dTd - 1);
                            if (i5 != 4) {
                                break;
                            }
                            gVar.d(a.dTd - 1, 1, this.dSW.bc(i3 + i4, i6));
                            break;
                        case 16:
                            list.add(new c(i3 + i4, i + i4, true));
                            break;
                        default:
                            throw new IllegalStateException("unknown flag for pos " + (i4 + i3) + " " + Long.toBinaryString((long) i5));
                    }
                }
                return;
            }
            gVar.bf(i, i2);
        }
    }

    private static class c {
        int dTc;
        int dTd;
        boolean dTe;

        public c(int i, int i2, boolean z) {
            this.dTc = i;
            this.dTd = i2;
            this.dTe = z;
        }
    }

    static class d {
        int dTf;
        int dTg;
        int dTh;
        int dTi;

        public d(int i, int i2) {
            this.dTf = 0;
            this.dTg = i;
            this.dTh = 0;
            this.dTi = i2;
        }
    }

    static class e {
        boolean dTe;
        boolean dTj;
        public int size;
        public int x;
        public int y;

        e() {
        }
    }

    public static b a(a aVar) {
        int Sf = aVar.Sf();
        int Sg = aVar.Sg();
        List arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        arrayList2.add(new d(Sf, Sg));
        int abs = (Sf + Sg) + Math.abs(Sf - Sg);
        int[] iArr = new int[(abs * 2)];
        int[] iArr2 = new int[(abs * 2)];
        List arrayList3 = new ArrayList();
        while (!arrayList2.isEmpty()) {
            d dVar = (d) arrayList2.remove(arrayList2.size() - 1);
            e a = a(aVar, dVar.dTf, dVar.dTg, dVar.dTh, dVar.dTi, iArr, iArr2, abs);
            if (a != null) {
                if (a.size > 0) {
                    arrayList.add(a);
                }
                a.x += dVar.dTf;
                a.y += dVar.dTh;
                d dVar2 = arrayList3.isEmpty() ? new d() : (d) arrayList3.remove(arrayList3.size() - 1);
                dVar2.dTf = dVar.dTf;
                dVar2.dTh = dVar.dTh;
                if (a.dTj) {
                    dVar2.dTg = a.x;
                    dVar2.dTi = a.y;
                } else if (a.dTe) {
                    dVar2.dTg = a.x - 1;
                    dVar2.dTi = a.y;
                } else {
                    dVar2.dTg = a.x;
                    dVar2.dTi = a.y - 1;
                }
                arrayList2.add(dVar2);
                if (!a.dTj) {
                    dVar.dTf = a.x + a.size;
                    dVar.dTh = a.y + a.size;
                } else if (a.dTe) {
                    dVar.dTf = (a.x + a.size) + 1;
                    dVar.dTh = a.y + a.size;
                } else {
                    dVar.dTf = a.x + a.size;
                    dVar.dTh = (a.y + a.size) + 1;
                }
                arrayList2.add(dVar);
            } else {
                arrayList3.add(dVar);
            }
        }
        Collections.sort(arrayList, dSS);
        return new b(aVar, arrayList, iArr, iArr2, true);
    }

    private static e a(a aVar, int i, int i2, int i3, int i4, int[] iArr, int[] iArr2, int i5) {
        int i6 = i2 - i;
        int i7 = i4 - i3;
        if (i2 - i <= 0 || i4 - i3 <= 0) {
            return null;
        }
        int i8 = i6 - i7;
        int i9 = ((i6 + i7) + 1) / 2;
        Arrays.fill(iArr, (i5 - i9) - 1, (i5 + i9) + 1, 0);
        Arrays.fill(iArr2, ((i5 - i9) - 1) + i8, ((i5 + i9) + 1) + i8, i6);
        Object obj = i8 % 2 != 0 ? 1 : null;
        int i10 = 0;
        while (i10 <= i9) {
            int i11;
            int i12 = -i10;
            while (i12 <= i10) {
                boolean z;
                if (i12 == (-i10) || (i12 != i10 && iArr[(i5 + i12) - 1] < iArr[(i5 + i12) + 1])) {
                    i11 = iArr[(i5 + i12) + 1];
                    z = false;
                } else {
                    i11 = iArr[(i5 + i12) - 1] + 1;
                    z = true;
                }
                int i13 = i11;
                i11 -= i12;
                while (i13 < i6 && i11 < i7 && aVar.ba(i + i13, i3 + i11)) {
                    i13++;
                    i11++;
                }
                iArr[i5 + i12] = i13;
                if (obj == null || i12 < (i8 - i10) + 1 || i12 > (i8 + i10) - 1 || iArr[i5 + i12] < iArr2[i5 + i12]) {
                    i12 += 2;
                } else {
                    e eVar = new e();
                    eVar.x = iArr2[i5 + i12];
                    eVar.y = eVar.x - i12;
                    eVar.size = iArr[i5 + i12] - iArr2[i5 + i12];
                    eVar.dTe = z;
                    eVar.dTj = false;
                    return eVar;
                }
            }
            i12 = -i10;
            while (i12 <= i10) {
                int i14 = i12 + i8;
                if (i14 == i10 + i8 || (i14 != (-i10) + i8 && iArr2[(i5 + i14) - 1] < iArr2[(i5 + i14) + 1])) {
                    i11 = iArr2[(i5 + i14) - 1];
                    z = false;
                } else {
                    i11 = iArr2[(i5 + i14) + 1] - 1;
                    z = true;
                }
                i13 = i11;
                i11 -= i14;
                while (i13 > 0 && i11 > 0 && aVar.ba((i + i13) - 1, (i3 + i11) - 1)) {
                    i13--;
                    i11--;
                }
                iArr2[i5 + i14] = i13;
                if (obj != null || i12 + i8 < (-i10) || i12 + i8 > i10 || iArr[i5 + i14] < iArr2[i5 + i14]) {
                    i12 += 2;
                } else {
                    eVar = new e();
                    eVar.x = iArr2[i5 + i14];
                    eVar.y = eVar.x - i14;
                    eVar.size = iArr[i5 + i14] - iArr2[i5 + i14];
                    eVar.dTe = z;
                    eVar.dTj = true;
                    return eVar;
                }
            }
            i10++;
        }
        throw new IllegalStateException("DiffUtil hit an unexpected case while trying to calculate the optimal path. Please make sure your data is not changing during the diff calculation.");
    }
}
