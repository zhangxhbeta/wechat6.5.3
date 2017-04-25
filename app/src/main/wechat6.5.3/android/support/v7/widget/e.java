package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.s;
import java.util.ArrayList;
import java.util.List;

final class e implements a {
    private android.support.v4.e.h.a<b> Th;
    final ArrayList<b> Ti;
    final ArrayList<b> Tj;
    final a Tk;
    Runnable Tl;
    final boolean Tm;
    final aa Tn;
    int To;

    interface a {
        void a(int i, int i2, Object obj);

        s aH(int i);

        void d(b bVar);

        void e(b bVar);

        void t(int i, int i2);

        void u(int i, int i2);

        void v(int i, int i2);

        void w(int i, int i2);
    }

    static class b {
        int Tp;
        Object Tq;
        int Tr;
        int of;

        b(int i, int i2, int i3, Object obj) {
            this.of = i;
            this.Tp = i2;
            this.Tr = i3;
            this.Tq = obj;
        }

        public final String toString() {
            String str;
            StringBuilder append = new StringBuilder().append(Integer.toHexString(System.identityHashCode(this))).append("[");
            switch (this.of) {
                case 1:
                    str = "add";
                    break;
                case 2:
                    str = "rm";
                    break;
                case 4:
                    str = "up";
                    break;
                case 8:
                    str = "mv";
                    break;
                default:
                    str = "??";
                    break;
            }
            return append.append(str).append(",s:").append(this.Tp).append("c:").append(this.Tr).append(",p:").append(this.Tq).append("]").toString();
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (this.of != bVar.of) {
                return false;
            }
            if (this.of == 8 && Math.abs(this.Tr - this.Tp) == 1 && this.Tr == bVar.Tp && this.Tp == bVar.Tr) {
                return true;
            }
            if (this.Tr != bVar.Tr) {
                return false;
            }
            if (this.Tp != bVar.Tp) {
                return false;
            }
            if (this.Tq != null) {
                if (this.Tq.equals(bVar.Tq)) {
                    return true;
                }
                return false;
            } else if (bVar.Tq != null) {
                return false;
            } else {
                return true;
            }
        }

        public final int hashCode() {
            return (((this.of * 31) + this.Tp) * 31) + this.Tr;
        }
    }

    e(a aVar) {
        this(aVar, (byte) 0);
    }

    private e(a aVar, byte b) {
        this.Th = new android.support.v4.e.h.b(30);
        this.Ti = new ArrayList();
        this.Tj = new ArrayList();
        this.To = 0;
        this.Tk = aVar;
        this.Tm = false;
        this.Tn = new aa(this);
    }

    final void reset() {
        f(this.Ti);
        f(this.Tj);
        this.To = 0;
    }

    final void ew() {
        aa aaVar = this.Tn;
        List list = this.Ti;
        while (true) {
            int i;
            int i2;
            b bVar;
            b bVar2;
            b bVar3;
            int size;
            Object obj = null;
            int size2 = list.size() - 1;
            while (size2 >= 0) {
                Object obj2;
                Object obj3;
                Object obj4;
                int i3;
                int i4;
                int i5;
                int i6;
                int i7;
                if (((b) list.get(size2)).of != 8) {
                    obj2 = 1;
                } else if (obj != null) {
                    i = size2;
                    if (i != -1) {
                        i2 = i + 1;
                        bVar = (b) list.get(i);
                        bVar2 = (b) list.get(i2);
                        switch (bVar2.of) {
                            case 1:
                                size2 = 0;
                                if (bVar.Tr < bVar2.Tp) {
                                    size2 = -1;
                                }
                                if (bVar.Tp < bVar2.Tp) {
                                    size2++;
                                }
                                if (bVar2.Tp <= bVar.Tp) {
                                    bVar.Tp += bVar2.Tr;
                                }
                                if (bVar2.Tp <= bVar.Tr) {
                                    bVar.Tr += bVar2.Tr;
                                }
                                bVar2.Tp = size2 + bVar2.Tp;
                                list.set(i, bVar2);
                                list.set(i2, bVar);
                                break;
                            case 2:
                                bVar3 = null;
                                obj3 = null;
                                if (bVar.Tp < bVar.Tr) {
                                    obj4 = null;
                                    if (bVar2.Tp == bVar.Tp && bVar2.Tr == bVar.Tr - bVar.Tp) {
                                        obj3 = 1;
                                    }
                                } else {
                                    obj4 = 1;
                                    if (bVar2.Tp == bVar.Tr + 1 && bVar2.Tr == bVar.Tp - bVar.Tr) {
                                        obj3 = 1;
                                    }
                                }
                                if (bVar.Tr < bVar2.Tp) {
                                    if (bVar.Tr < bVar2.Tp + bVar2.Tr) {
                                        bVar2.Tr--;
                                        bVar.of = 2;
                                        bVar.Tr = 1;
                                        if (bVar2.Tr != 0) {
                                            break;
                                        }
                                        list.remove(i2);
                                        aaVar.XW.c(bVar2);
                                        break;
                                    }
                                }
                                bVar2.Tp--;
                                if (bVar.Tp <= bVar2.Tp) {
                                    bVar2.Tp++;
                                } else if (bVar.Tp < bVar2.Tp + bVar2.Tr) {
                                    bVar3 = aaVar.XW.a(2, bVar.Tp + 1, (bVar2.Tp + bVar2.Tr) - bVar.Tp, null);
                                    bVar2.Tr = bVar.Tp - bVar2.Tp;
                                }
                                if (obj3 == null) {
                                    if (obj4 == null) {
                                        if (bVar3 != null) {
                                            if (bVar.Tp > bVar3.Tp) {
                                                bVar.Tp -= bVar3.Tr;
                                            }
                                            if (bVar.Tr > bVar3.Tp) {
                                                bVar.Tr -= bVar3.Tr;
                                            }
                                        }
                                        if (bVar.Tp > bVar2.Tp) {
                                            bVar.Tp -= bVar2.Tr;
                                        }
                                        if (bVar.Tr > bVar2.Tp) {
                                            bVar.Tr -= bVar2.Tr;
                                        }
                                    } else {
                                        if (bVar3 != null) {
                                            if (bVar.Tp >= bVar3.Tp) {
                                                bVar.Tp -= bVar3.Tr;
                                            }
                                            if (bVar.Tr >= bVar3.Tp) {
                                                bVar.Tr -= bVar3.Tr;
                                            }
                                        }
                                        if (bVar.Tp >= bVar2.Tp) {
                                            bVar.Tp -= bVar2.Tr;
                                        }
                                        if (bVar.Tr >= bVar2.Tp) {
                                            bVar.Tr -= bVar2.Tr;
                                        }
                                    }
                                    list.set(i, bVar2);
                                    if (bVar.Tp == bVar.Tr) {
                                        list.set(i2, bVar);
                                    } else {
                                        list.remove(i2);
                                    }
                                    if (bVar3 == null) {
                                        break;
                                    }
                                    list.add(i, bVar3);
                                    break;
                                }
                                list.set(i, bVar2);
                                list.remove(i2);
                                aaVar.XW.c(bVar);
                                break;
                            case 4:
                                obj4 = null;
                                obj3 = null;
                                if (bVar.Tr < bVar2.Tp) {
                                    bVar2.Tp--;
                                } else if (bVar.Tr < bVar2.Tp + bVar2.Tr) {
                                    bVar2.Tr--;
                                    obj4 = aaVar.XW.a(4, bVar.Tp, 1, bVar2.Tq);
                                }
                                if (bVar.Tp <= bVar2.Tp) {
                                    bVar2.Tp++;
                                } else if (bVar.Tp < bVar2.Tp + bVar2.Tr) {
                                    i3 = (bVar2.Tp + bVar2.Tr) - bVar.Tp;
                                    obj3 = aaVar.XW.a(4, bVar.Tp + 1, i3, bVar2.Tq);
                                    bVar2.Tr -= i3;
                                }
                                list.set(i2, bVar);
                                if (bVar2.Tr <= 0) {
                                    list.set(i, bVar2);
                                } else {
                                    list.remove(i);
                                    aaVar.XW.c(bVar2);
                                }
                                if (obj4 != null) {
                                    list.add(i, obj4);
                                }
                                if (obj3 == null) {
                                    break;
                                }
                                list.add(i, obj3);
                                break;
                            default:
                                break;
                        }
                    }
                    size = this.Ti.size();
                    for (i = 0; i < size; i++) {
                        bVar = (b) this.Ti.get(i);
                        switch (bVar.of) {
                            case 1:
                                b(bVar);
                                break;
                            case 2:
                                i2 = bVar.Tp;
                                i4 = bVar.Tr + bVar.Tp;
                                i3 = -1;
                                size2 = bVar.Tp;
                                i5 = 0;
                                while (size2 < i4) {
                                    obj = null;
                                    if (this.Tk.aH(size2) == null || aE(size2)) {
                                        if (i3 == 0) {
                                            a(a(2, i2, i5, null));
                                            obj = 1;
                                        }
                                        i3 = 1;
                                    } else {
                                        if (i3 == 1) {
                                            b(a(2, i2, i5, null));
                                            obj = 1;
                                        }
                                        i3 = 0;
                                    }
                                    if (obj == null) {
                                        i6 = size2 - i5;
                                        size2 = i4 - i5;
                                        i4 = 1;
                                    } else {
                                        i7 = size2;
                                        size2 = i4;
                                        i4 = i5 + 1;
                                        i6 = i7;
                                    }
                                    i5 = i4;
                                    i4 = size2;
                                    size2 = i6 + 1;
                                }
                                if (i5 != bVar.Tr) {
                                    c(bVar);
                                    bVar = a(2, i2, i5, null);
                                }
                                if (i3 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 4:
                                i3 = bVar.Tp;
                                i5 = bVar.Tp + bVar.Tr;
                                i4 = bVar.Tp;
                                i6 = 0;
                                size2 = i3;
                                i3 = -1;
                                while (i4 < i5) {
                                    if (this.Tk.aH(i4) == null || aE(i4)) {
                                        if (i3 == 0) {
                                            a(a(4, size2, i6, bVar.Tq));
                                            i6 = 0;
                                            size2 = i4;
                                        }
                                        i3 = size2;
                                        size2 = i6;
                                        i6 = 1;
                                    } else {
                                        if (i3 == 1) {
                                            b(a(4, size2, i6, bVar.Tq));
                                            i6 = 0;
                                            size2 = i4;
                                        }
                                        i3 = size2;
                                        size2 = i6;
                                        i6 = 0;
                                    }
                                    i4++;
                                    i7 = i6;
                                    i6 = size2 + 1;
                                    size2 = i3;
                                    i3 = i7;
                                }
                                if (i6 != bVar.Tr) {
                                    obj3 = bVar.Tq;
                                    c(bVar);
                                    bVar = a(4, size2, i6, obj3);
                                }
                                if (i3 != 0) {
                                    b(bVar);
                                    break;
                                } else {
                                    a(bVar);
                                    break;
                                }
                                break;
                            case 8:
                                b(bVar);
                                break;
                        }
                        if (this.Tl != null) {
                            this.Tl.run();
                        }
                    }
                    this.Ti.clear();
                    return;
                } else {
                    obj2 = obj;
                }
                size2--;
                obj = obj2;
            }
            i = -1;
            if (i != -1) {
                i2 = i + 1;
                bVar = (b) list.get(i);
                bVar2 = (b) list.get(i2);
                switch (bVar2.of) {
                    case 1:
                        size2 = 0;
                        if (bVar.Tr < bVar2.Tp) {
                            size2 = -1;
                        }
                        if (bVar.Tp < bVar2.Tp) {
                            size2++;
                        }
                        if (bVar2.Tp <= bVar.Tp) {
                            bVar.Tp += bVar2.Tr;
                        }
                        if (bVar2.Tp <= bVar.Tr) {
                            bVar.Tr += bVar2.Tr;
                        }
                        bVar2.Tp = size2 + bVar2.Tp;
                        list.set(i, bVar2);
                        list.set(i2, bVar);
                        break;
                    case 2:
                        bVar3 = null;
                        obj3 = null;
                        if (bVar.Tp < bVar.Tr) {
                            obj4 = null;
                            obj3 = 1;
                            break;
                        }
                        obj4 = 1;
                        obj3 = 1;
                        break;
                        if (bVar.Tr < bVar2.Tp) {
                            if (bVar.Tr < bVar2.Tp + bVar2.Tr) {
                                bVar2.Tr--;
                                bVar.of = 2;
                                bVar.Tr = 1;
                                if (bVar2.Tr != 0) {
                                    list.remove(i2);
                                    aaVar.XW.c(bVar2);
                                    break;
                                }
                                break;
                            }
                        }
                        bVar2.Tp--;
                        if (bVar.Tp <= bVar2.Tp) {
                            bVar2.Tp++;
                        } else if (bVar.Tp < bVar2.Tp + bVar2.Tr) {
                            bVar3 = aaVar.XW.a(2, bVar.Tp + 1, (bVar2.Tp + bVar2.Tr) - bVar.Tp, null);
                            bVar2.Tr = bVar.Tp - bVar2.Tp;
                        }
                        if (obj3 == null) {
                            list.set(i, bVar2);
                            list.remove(i2);
                            aaVar.XW.c(bVar);
                            break;
                        }
                        if (obj4 == null) {
                            if (bVar3 != null) {
                                if (bVar.Tp >= bVar3.Tp) {
                                    bVar.Tp -= bVar3.Tr;
                                }
                                if (bVar.Tr >= bVar3.Tp) {
                                    bVar.Tr -= bVar3.Tr;
                                }
                            }
                            if (bVar.Tp >= bVar2.Tp) {
                                bVar.Tp -= bVar2.Tr;
                            }
                            if (bVar.Tr >= bVar2.Tp) {
                                bVar.Tr -= bVar2.Tr;
                            }
                        } else {
                            if (bVar3 != null) {
                                if (bVar.Tp > bVar3.Tp) {
                                    bVar.Tp -= bVar3.Tr;
                                }
                                if (bVar.Tr > bVar3.Tp) {
                                    bVar.Tr -= bVar3.Tr;
                                }
                            }
                            if (bVar.Tp > bVar2.Tp) {
                                bVar.Tp -= bVar2.Tr;
                            }
                            if (bVar.Tr > bVar2.Tp) {
                                bVar.Tr -= bVar2.Tr;
                            }
                        }
                        list.set(i, bVar2);
                        if (bVar.Tp == bVar.Tr) {
                            list.remove(i2);
                        } else {
                            list.set(i2, bVar);
                        }
                        if (bVar3 == null) {
                            list.add(i, bVar3);
                            break;
                        }
                        break;
                    case 4:
                        obj4 = null;
                        obj3 = null;
                        if (bVar.Tr < bVar2.Tp) {
                            bVar2.Tp--;
                        } else if (bVar.Tr < bVar2.Tp + bVar2.Tr) {
                            bVar2.Tr--;
                            obj4 = aaVar.XW.a(4, bVar.Tp, 1, bVar2.Tq);
                        }
                        if (bVar.Tp <= bVar2.Tp) {
                            bVar2.Tp++;
                        } else if (bVar.Tp < bVar2.Tp + bVar2.Tr) {
                            i3 = (bVar2.Tp + bVar2.Tr) - bVar.Tp;
                            obj3 = aaVar.XW.a(4, bVar.Tp + 1, i3, bVar2.Tq);
                            bVar2.Tr -= i3;
                        }
                        list.set(i2, bVar);
                        if (bVar2.Tr <= 0) {
                            list.remove(i);
                            aaVar.XW.c(bVar2);
                        } else {
                            list.set(i, bVar2);
                        }
                        if (obj4 != null) {
                            list.add(i, obj4);
                        }
                        if (obj3 == null) {
                            list.add(i, obj3);
                            break;
                        }
                        break;
                    default:
                        break;
                }
            }
            size = this.Ti.size();
            for (i = 0; i < size; i++) {
                bVar = (b) this.Ti.get(i);
                switch (bVar.of) {
                    case 1:
                        b(bVar);
                        break;
                    case 2:
                        i2 = bVar.Tp;
                        i4 = bVar.Tr + bVar.Tp;
                        i3 = -1;
                        size2 = bVar.Tp;
                        i5 = 0;
                        while (size2 < i4) {
                            obj = null;
                            if (this.Tk.aH(size2) == null) {
                                break;
                            }
                            if (i3 == 0) {
                                a(a(2, i2, i5, null));
                                obj = 1;
                            }
                            i3 = 1;
                            if (obj == null) {
                                i7 = size2;
                                size2 = i4;
                                i4 = i5 + 1;
                                i6 = i7;
                            } else {
                                i6 = size2 - i5;
                                size2 = i4 - i5;
                                i4 = 1;
                            }
                            i5 = i4;
                            i4 = size2;
                            size2 = i6 + 1;
                        }
                        if (i5 != bVar.Tr) {
                            c(bVar);
                            bVar = a(2, i2, i5, null);
                        }
                        if (i3 != 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                    case 4:
                        i3 = bVar.Tp;
                        i5 = bVar.Tp + bVar.Tr;
                        i4 = bVar.Tp;
                        i6 = 0;
                        size2 = i3;
                        i3 = -1;
                        while (i4 < i5) {
                            if (this.Tk.aH(i4) == null) {
                                break;
                            }
                            if (i3 == 0) {
                                a(a(4, size2, i6, bVar.Tq));
                                i6 = 0;
                                size2 = i4;
                            }
                            i3 = size2;
                            size2 = i6;
                            i6 = 1;
                            i4++;
                            i7 = i6;
                            i6 = size2 + 1;
                            size2 = i3;
                            i3 = i7;
                        }
                        if (i6 != bVar.Tr) {
                            obj3 = bVar.Tq;
                            c(bVar);
                            bVar = a(4, size2, i6, obj3);
                        }
                        if (i3 != 0) {
                            a(bVar);
                            break;
                        } else {
                            b(bVar);
                            break;
                        }
                    case 8:
                        b(bVar);
                        break;
                }
                if (this.Tl != null) {
                    this.Tl.run();
                }
            }
            this.Ti.clear();
            return;
        }
    }

    final void ex() {
        int size = this.Tj.size();
        for (int i = 0; i < size; i++) {
            this.Tk.e((b) this.Tj.get(i));
        }
        f(this.Tj);
        this.To = 0;
    }

    private void a(b bVar) {
        if (bVar.of == 1 || bVar.of == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int i;
        int r = r(bVar.Tp, bVar.of);
        int i2 = bVar.Tp;
        switch (bVar.of) {
            case 2:
                i = 0;
                break;
            case 4:
                i = 1;
                break;
            default:
                throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i3 = 1;
        int i4 = r;
        r = i2;
        for (i2 = 1; i2 < bVar.Tr; i2++) {
            Object obj;
            int r2 = r(bVar.Tp + (i * i2), bVar.of);
            int i5;
            switch (bVar.of) {
                case 2:
                    if (r2 != i4) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                case 4:
                    if (r2 != i4 + 1) {
                        obj = null;
                        break;
                    } else {
                        i5 = 1;
                        break;
                    }
                default:
                    obj = null;
                    break;
            }
            if (obj != null) {
                i3++;
            } else {
                b a = a(bVar.of, i4, i3, bVar.Tq);
                a(a, r);
                c(a);
                if (bVar.of == 4) {
                    r += i3;
                }
                i3 = 1;
                i4 = r2;
            }
        }
        Object obj2 = bVar.Tq;
        c(bVar);
        if (i3 > 0) {
            b a2 = a(bVar.of, i4, i3, obj2);
            a(a2, r);
            c(a2);
        }
    }

    private void a(b bVar, int i) {
        this.Tk.d(bVar);
        switch (bVar.of) {
            case 2:
                this.Tk.t(i, bVar.Tr);
                return;
            case 4:
                this.Tk.a(i, bVar.Tr, bVar.Tq);
                return;
            default:
                throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    private int r(int i, int i2) {
        int i3;
        int size = this.Tj.size() - 1;
        int i4 = i;
        while (size >= 0) {
            int i5;
            b bVar = (b) this.Tj.get(size);
            if (bVar.of == 8) {
                int i6;
                if (bVar.Tp < bVar.Tr) {
                    i6 = bVar.Tp;
                    i3 = bVar.Tr;
                } else {
                    i6 = bVar.Tr;
                    i3 = bVar.Tp;
                }
                if (i4 < i6 || i4 > r2) {
                    if (i4 < bVar.Tp) {
                        if (i2 == 1) {
                            bVar.Tp++;
                            bVar.Tr++;
                            i5 = i4;
                        } else if (i2 == 2) {
                            bVar.Tp--;
                            bVar.Tr--;
                        }
                    }
                    i5 = i4;
                } else if (i6 == bVar.Tp) {
                    if (i2 == 1) {
                        bVar.Tr++;
                    } else if (i2 == 2) {
                        bVar.Tr--;
                    }
                    i5 = i4 + 1;
                } else {
                    if (i2 == 1) {
                        bVar.Tp++;
                    } else if (i2 == 2) {
                        bVar.Tp--;
                    }
                    i5 = i4 - 1;
                }
            } else {
                if (bVar.Tp <= i4) {
                    if (bVar.of == 1) {
                        i5 = i4 - bVar.Tr;
                    } else if (bVar.of == 2) {
                        i5 = bVar.Tr + i4;
                    }
                } else if (i2 == 1) {
                    bVar.Tp++;
                    i5 = i4;
                } else if (i2 == 2) {
                    bVar.Tp--;
                }
                i5 = i4;
            }
            size--;
            i4 = i5;
        }
        for (i3 = this.Tj.size() - 1; i3 >= 0; i3--) {
            bVar = (b) this.Tj.get(i3);
            if (bVar.of == 8) {
                if (bVar.Tr == bVar.Tp || bVar.Tr < 0) {
                    this.Tj.remove(i3);
                    c(bVar);
                }
            } else if (bVar.Tr <= 0) {
                this.Tj.remove(i3);
                c(bVar);
            }
        }
        return i4;
    }

    private boolean aE(int i) {
        int size = this.Tj.size();
        for (int i2 = 0; i2 < size; i2++) {
            b bVar = (b) this.Tj.get(i2);
            if (bVar.of == 8) {
                if (s(bVar.Tr, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.of == 1) {
                int i3 = bVar.Tp + bVar.Tr;
                for (int i4 = bVar.Tp; i4 < i3; i4++) {
                    if (s(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    private void b(b bVar) {
        this.Tj.add(bVar);
        switch (bVar.of) {
            case 1:
                this.Tk.v(bVar.Tp, bVar.Tr);
                return;
            case 2:
                this.Tk.u(bVar.Tp, bVar.Tr);
                return;
            case 4:
                this.Tk.a(bVar.Tp, bVar.Tr, bVar.Tq);
                return;
            case 8:
                this.Tk.w(bVar.Tp, bVar.Tr);
                return;
            default:
                throw new IllegalArgumentException("Unknown update op type for " + bVar);
        }
    }

    final boolean ey() {
        return this.Ti.size() > 0;
    }

    final boolean aF(int i) {
        return (this.To & i) != 0;
    }

    final int aG(int i) {
        return s(i, 0);
    }

    final int s(int i, int i2) {
        int size = this.Tj.size();
        int i3 = i;
        while (i2 < size) {
            b bVar = (b) this.Tj.get(i2);
            if (bVar.of == 8) {
                if (bVar.Tp == i3) {
                    i3 = bVar.Tr;
                } else {
                    if (bVar.Tp < i3) {
                        i3--;
                    }
                    if (bVar.Tr <= i3) {
                        i3++;
                    }
                }
            } else if (bVar.Tp > i3) {
                continue;
            } else if (bVar.of == 2) {
                if (i3 < bVar.Tp + bVar.Tr) {
                    return -1;
                }
                i3 -= bVar.Tr;
            } else if (bVar.of == 1) {
                i3 += bVar.Tr;
            }
            i2++;
        }
        return i3;
    }

    final void ez() {
        ex();
        int size = this.Ti.size();
        for (int i = 0; i < size; i++) {
            b bVar = (b) this.Ti.get(i);
            switch (bVar.of) {
                case 1:
                    this.Tk.e(bVar);
                    this.Tk.v(bVar.Tp, bVar.Tr);
                    break;
                case 2:
                    this.Tk.e(bVar);
                    this.Tk.t(bVar.Tp, bVar.Tr);
                    break;
                case 4:
                    this.Tk.e(bVar);
                    this.Tk.a(bVar.Tp, bVar.Tr, bVar.Tq);
                    break;
                case 8:
                    this.Tk.e(bVar);
                    this.Tk.w(bVar.Tp, bVar.Tr);
                    break;
            }
            if (this.Tl != null) {
                this.Tl.run();
            }
        }
        f(this.Ti);
        this.To = 0;
    }

    public final b a(int i, int i2, int i3, Object obj) {
        b bVar = (b) this.Th.bJ();
        if (bVar == null) {
            return new b(i, i2, i3, obj);
        }
        bVar.of = i;
        bVar.Tp = i2;
        bVar.Tr = i3;
        bVar.Tq = obj;
        return bVar;
    }

    public final void c(b bVar) {
        if (!this.Tm) {
            bVar.Tq = null;
            this.Th.i(bVar);
        }
    }

    private void f(List<b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            c((b) list.get(i));
        }
        list.clear();
    }
}
