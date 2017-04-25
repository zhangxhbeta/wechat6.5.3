package com.tencent.tinker.c.a.a.a;

import com.tencent.tinker.a.a.i.e;
import com.tencent.tinker.a.a.o;
import com.tencent.tinker.a.b.b.b;
import java.util.Arrays;

public abstract class i<T extends Comparable<T>> {
    protected final com.tencent.tinker.a.a.i pCQ;
    protected final com.tencent.tinker.c.a.b.a pCS;
    private final b pCU;
    private final String pCW;
    private final b pDD;
    private a pDE = null;

    public interface a {
        boolean cr(String str, int i);
    }

    protected abstract T a(com.tencent.tinker.a.a.a.a aVar);

    protected abstract int bOT();

    protected abstract com.tencent.tinker.a.a.t.a c(com.tencent.tinker.a.a.i iVar);

    protected abstract int e(T t);

    protected abstract int f(T t);

    public i(com.tencent.tinker.c.a.b.a aVar, com.tencent.tinker.a.a.i iVar, b bVar, b bVar2, a aVar2) {
        this.pCS = aVar;
        this.pCQ = iVar;
        this.pCU = bVar;
        this.pDD = bVar2;
        this.pCW = com.tencent.tinker.a.b.b.a.R(iVar.kE(false));
        this.pDE = aVar2;
    }

    protected T a(b bVar, T t) {
        return t;
    }

    protected void a(b bVar, int i, int i2, int i3, int i4) {
    }

    protected void a(b bVar, int i, int i2) {
    }

    private boolean cr(String str, int i) {
        if (this.pDE != null) {
            return this.pDE.cr(str, i);
        }
        return true;
    }

    private int[] zv(int i) {
        int i2 = 0;
        int[] iArr = new int[i];
        int i3 = 0;
        while (i2 < i) {
            i3 += o.a(this.pCS.pDV);
            iArr[i2] = i3;
            i2++;
        }
        return iArr;
    }

    private static int a(int i, T t) {
        if (t instanceof com.tencent.tinker.a.a.t.a.a) {
            return ((com.tencent.tinker.a.a.t.a.a) t).pBP;
        }
        return i;
    }

    public final void execute() {
        int[] zv;
        int[] iArr;
        int[] iArr2;
        int i;
        com.tencent.tinker.a.a.a.a aVar;
        if (this.pCS != null) {
            int[] zv2 = zv(o.b(this.pCS.pDV));
            int[] zv3 = zv(o.b(this.pCS.pDV));
            zv = zv(o.b(this.pCS.pDV));
            iArr = zv3;
            iArr2 = zv2;
        } else {
            zv = new int[0];
            iArr = new int[0];
            iArr2 = new int[0];
        }
        com.tencent.tinker.a.a.t.a c = c(this.pCQ);
        if (c.exists()) {
            com.tencent.tinker.a.a.a.a a = this.pCQ.a(c);
            i = c.size;
            aVar = a;
        } else {
            i = 0;
            aVar = null;
        }
        if ((this.pDD == null ? 1 : null) != null) {
            int length = iArr2.length;
            int length2 = iArr.length;
            int length3 = zv.length;
            int i2 = (i + length2) - length;
            int i3 = 0;
            int i4 = 0;
            int i5 = 0;
            int i6 = 0;
            int i7 = 0;
            while (true) {
                if (i3 >= i && i4 >= i2) {
                    break;
                } else if (i6 < length2 && iArr[i6] == i4) {
                    e(a(this.pCS.pDV));
                    i4++;
                    i6++;
                } else if (i5 < length3 && zv[i5] == i4) {
                    e(a(this.pCS.pDV));
                    i4++;
                    i5++;
                } else if (Arrays.binarySearch(iArr2, i3) >= 0) {
                    a(this.pCU, i3, a(i3, a(aVar)));
                    i3++;
                    i7++;
                } else if (Arrays.binarySearch(zv, i3) >= 0) {
                    a(this.pCU, i3, a(i3, a(aVar)));
                    i3++;
                } else if (i3 < i) {
                    Comparable a2 = a(this.pCU, a(aVar));
                    a(this.pCU, i3, a(i3, a2), i4, e(a2));
                    i3++;
                    i4++;
                }
            }
            if (i6 != length2 || i7 != length || i5 != length3) {
                throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[]{Integer.valueOf(i6), Integer.valueOf(length2), Integer.valueOf(i7), Integer.valueOf(length), Integer.valueOf(i5), Integer.valueOf(length3)}));
            }
            return;
        }
        a((e) aVar, i, iArr2, iArr, zv);
    }

    private void a(e eVar, int i, int[] iArr, int[] iArr2, int[] iArr3) {
        int length = iArr.length;
        int length2 = iArr2.length;
        int length3 = iArr3.length;
        int i2 = (i + length2) - length;
        int i3 = 0;
        int i4 = 0;
        int bOT = bOT();
        int i5 = 0;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        while (true) {
            if (i3 >= i && i4 >= i2) {
                break;
            } else if (i7 < length2 && iArr2[i7] == i4) {
                r10 = a(this.pCS.pDV);
                r9 = i7 + 1;
                if (c(this.pCQ).pBO) {
                    bOT = (bOT + 3) & -4;
                }
                if (cr(this.pCW, i4)) {
                    a(this.pDD, i4, bOT, i5, e(a(this.pDD, r10)));
                    i5++;
                }
                i4++;
                bOT += f(r10);
                i7 = r9;
            } else if (i6 < length3 && iArr3[i6] == i4) {
                r10 = a(this.pCS.pDV);
                r9 = i6 + 1;
                if (c(this.pCQ).pBO) {
                    bOT = (bOT + 3) & -4;
                }
                if (cr(this.pCW, i4)) {
                    a(this.pDD, i4, bOT, i5, e(a(this.pDD, r10)));
                    i5++;
                }
                i4++;
                bOT += f(r10);
                i6 = r9;
            } else if (Arrays.binarySearch(iArr, i3) >= 0) {
                a(this.pCU, i3, a(i3, a(eVar)));
                i3++;
                i8++;
            } else if (Arrays.binarySearch(iArr3, i3) >= 0) {
                a(this.pCU, i3, a(i3, a(eVar)));
                i3++;
            } else if (i3 < i) {
                int i9;
                Comparable a = a(eVar);
                Comparable a2 = a(this.pCU, a);
                if (c(this.pCQ).pBO) {
                    bOT = (bOT + 3) & -4;
                }
                if (cr(this.pCW, i4)) {
                    a(this.pDD, i4, bOT, i5, e(a(this.pDD, a2)));
                    i9 = i5 + 1;
                } else {
                    i9 = i5;
                }
                a(this.pCU, i3, a(i3, a), i4, bOT);
                i4++;
                bOT += f(a2);
                i3++;
                i5 = i9;
            }
        }
        if (i7 != length2 || i8 != length || i6 != length3) {
            throw new IllegalStateException(String.format("bad patch operation sequence. addCounter: %d, addCount: %d, delCounter: %d, delCount: %d, replaceCounter: %d, replaceCount:%d", new Object[]{Integer.valueOf(i7), Integer.valueOf(length2), Integer.valueOf(i8), Integer.valueOf(length), Integer.valueOf(i6), Integer.valueOf(length3)}));
        }
    }
}
