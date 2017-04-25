package android.support.v7.widget;

import android.support.v4.view.ah;
import android.support.v4.view.al;
import android.support.v4.view.y;
import android.support.v7.widget.RecyclerView.e;
import android.support.v7.widget.RecyclerView.s;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class v extends aj {
    private ArrayList<s> Ve = new ArrayList();
    private ArrayList<s> Vf = new ArrayList();
    private ArrayList<b> Vg = new ArrayList();
    private ArrayList<a> Vh = new ArrayList();
    ArrayList<ArrayList<s>> Vi = new ArrayList();
    ArrayList<ArrayList<b>> Vj = new ArrayList();
    ArrayList<ArrayList<a>> Vk = new ArrayList();
    ArrayList<s> Vl = new ArrayList();
    ArrayList<s> Vm = new ArrayList();
    ArrayList<s> Vn = new ArrayList();
    ArrayList<s> Vo = new ArrayList();

    private static class a {
        public s VB;
        public s VC;
        public int VD;
        public int VE;
        public int VF;
        public int VG;

        private a(s sVar, s sVar2) {
            this.VB = sVar;
            this.VC = sVar2;
        }

        private a(s sVar, s sVar2, int i, int i2, int i3, int i4) {
            this(sVar, sVar2);
            this.VD = i;
            this.VE = i2;
            this.VF = i3;
            this.VG = i4;
        }

        public final String toString() {
            return "ChangeInfo{oldHolder=" + this.VB + ", newHolder=" + this.VC + ", fromX=" + this.VD + ", fromY=" + this.VE + ", toX=" + this.VF + ", toY=" + this.VG + '}';
        }
    }

    private static class b {
        public int VD;
        public int VE;
        public int VF;
        public int VG;
        public s VH;

        private b(s sVar, int i, int i2, int i3, int i4) {
            this.VH = sVar;
            this.VD = i;
            this.VE = i2;
            this.VF = i3;
            this.VG = i4;
        }
    }

    private static class c implements al {
        private c() {
        }

        public void p(View view) {
        }

        public void q(View view) {
        }

        public void ar(View view) {
        }
    }

    class AnonymousClass5 extends c {
        final /* synthetic */ v Vq;
        final /* synthetic */ s Vt;
        final /* synthetic */ ah Vu;

        AnonymousClass5(v vVar, s sVar, ah ahVar) {
            this.Vq = vVar;
            this.Vt = sVar;
            this.Vu = ahVar;
            super();
        }

        public final void p(View view) {
        }

        public final void ar(View view) {
            y.d(view, 1.0f);
        }

        public final void q(View view) {
            this.Vu.a(null);
            this.Vq.k(this.Vt);
            this.Vq.Vl.remove(this.Vt);
            this.Vq.eO();
        }
    }

    class AnonymousClass6 extends c {
        final /* synthetic */ v Vq;
        final /* synthetic */ s Vt;
        final /* synthetic */ ah Vu;
        final /* synthetic */ int Vv;
        final /* synthetic */ int Vw;

        AnonymousClass6(v vVar, s sVar, int i, int i2, ah ahVar) {
            this.Vq = vVar;
            this.Vt = sVar;
            this.Vv = i;
            this.Vw = i2;
            this.Vu = ahVar;
            super();
        }

        public final void p(View view) {
        }

        public final void ar(View view) {
            if (this.Vv != 0) {
                y.b(view, 0.0f);
            }
            if (this.Vw != 0) {
                y.c(view, 0.0f);
            }
        }

        public final void q(View view) {
            this.Vu.a(null);
            this.Vq.k(this.Vt);
            this.Vq.Vm.remove(this.Vt);
            this.Vq.eO();
        }
    }

    class AnonymousClass7 extends c {
        final /* synthetic */ v Vq;
        final /* synthetic */ a Vx;
        final /* synthetic */ ah Vy;

        AnonymousClass7(v vVar, a aVar, ah ahVar) {
            this.Vq = vVar;
            this.Vx = aVar;
            this.Vy = ahVar;
            super();
        }

        public final void p(View view) {
        }

        public final void q(View view) {
            this.Vy.a(null);
            y.d(view, 1.0f);
            y.b(view, 0.0f);
            y.c(view, 0.0f);
            this.Vq.k(this.Vx.VB);
            this.Vq.Vo.remove(this.Vx.VB);
            this.Vq.eO();
        }
    }

    class AnonymousClass8 extends c {
        final /* synthetic */ View VA;
        final /* synthetic */ v Vq;
        final /* synthetic */ a Vx;
        final /* synthetic */ ah Vz;

        AnonymousClass8(v vVar, a aVar, ah ahVar, View view) {
            this.Vq = vVar;
            this.Vx = aVar;
            this.Vz = ahVar;
            this.VA = view;
            super();
        }

        public final void p(View view) {
        }

        public final void q(View view) {
            this.Vz.a(null);
            y.d(this.VA, 1.0f);
            y.b(this.VA, 0.0f);
            y.c(this.VA, 0.0f);
            this.Vq.k(this.Vx.VC);
            this.Vq.Vo.remove(this.Vx.VC);
            this.Vq.eO();
        }
    }

    public final void eN() {
        int i;
        int i2;
        int i3;
        int i4 = !this.Ve.isEmpty() ? 1 : 0;
        if (this.Vg.isEmpty()) {
            i = 0;
        } else {
            i = 1;
        }
        if (this.Vh.isEmpty()) {
            i2 = 0;
        } else {
            i2 = 1;
        }
        if (this.Vf.isEmpty()) {
            i3 = 0;
        } else {
            i3 = 1;
        }
        if (i4 != 0 || i != 0 || i3 != 0 || i2 != 0) {
            final ArrayList arrayList;
            Runnable anonymousClass1;
            Iterator it = this.Ve.iterator();
            while (it.hasNext()) {
                final s sVar = (s) it.next();
                final ah U = y.U(sVar.aal);
                this.Vn.add(sVar);
                U.c(this.Zn).p(0.0f).a(new c(this) {
                    final /* synthetic */ v Vq;

                    public final void p(View view) {
                    }

                    public final void q(View view) {
                        U.a(null);
                        y.d(view, 1.0f);
                        this.Vq.k(sVar);
                        this.Vq.Vn.remove(sVar);
                        this.Vq.eO();
                    }
                }).start();
            }
            this.Ve.clear();
            if (i != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.Vg);
                this.Vj.add(arrayList);
                this.Vg.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ v Vq;

                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            b bVar = (b) it.next();
                            e eVar = this.Vq;
                            s sVar = bVar.VH;
                            int i = bVar.VD;
                            int i2 = bVar.VE;
                            int i3 = bVar.VF;
                            int i4 = bVar.VG;
                            View view = sVar.aal;
                            i = i3 - i;
                            i2 = i4 - i2;
                            if (i != 0) {
                                y.U(view).q(0.0f);
                            }
                            if (i2 != 0) {
                                y.U(view).r(0.0f);
                            }
                            ah U = y.U(view);
                            eVar.Vm.add(sVar);
                            U.c(eVar.Zo).a(new AnonymousClass6(eVar, sVar, i, i2, U)).start();
                        }
                        arrayList.clear();
                        this.Vq.Vj.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    y.a(((b) arrayList.get(0)).VH.aal, anonymousClass1, this.Zn);
                } else {
                    anonymousClass1.run();
                }
            }
            if (i2 != 0) {
                arrayList = new ArrayList();
                arrayList.addAll(this.Vh);
                this.Vk.add(arrayList);
                this.Vh.clear();
                anonymousClass1 = new Runnable(this) {
                    final /* synthetic */ v Vq;

                    public final void run() {
                        Iterator it = arrayList.iterator();
                        while (it.hasNext()) {
                            a aVar = (a) it.next();
                            e eVar = this.Vq;
                            s sVar = aVar.VB;
                            View view = sVar == null ? null : sVar.aal;
                            s sVar2 = aVar.VC;
                            View view2 = sVar2 != null ? sVar2.aal : null;
                            if (view != null) {
                                ah c = y.U(view).c(eVar.Zp);
                                eVar.Vo.add(aVar.VB);
                                c.q((float) (aVar.VF - aVar.VD));
                                c.r((float) (aVar.VG - aVar.VE));
                                c.p(0.0f).a(new AnonymousClass7(eVar, aVar, c)).start();
                            }
                            if (view2 != null) {
                                c = y.U(view2);
                                eVar.Vo.add(aVar.VC);
                                c.q(0.0f).r(0.0f).c(eVar.Zp).p(1.0f).a(new AnonymousClass8(eVar, aVar, c, view2)).start();
                            }
                        }
                        arrayList.clear();
                        this.Vq.Vk.remove(arrayList);
                    }
                };
                if (i4 != 0) {
                    y.a(((a) arrayList.get(0)).VB.aal, anonymousClass1, this.Zn);
                } else {
                    anonymousClass1.run();
                }
            }
            if (i3 != 0) {
                final ArrayList arrayList2 = new ArrayList();
                arrayList2.addAll(this.Vf);
                this.Vi.add(arrayList2);
                this.Vf.clear();
                Runnable anonymousClass3 = new Runnable(this) {
                    final /* synthetic */ v Vq;

                    public final void run() {
                        Iterator it = arrayList2.iterator();
                        while (it.hasNext()) {
                            s sVar = (s) it.next();
                            e eVar = this.Vq;
                            ah U = y.U(sVar.aal);
                            eVar.Vl.add(sVar);
                            U.p(1.0f).c(eVar.Zm).a(new AnonymousClass5(eVar, sVar, U)).start();
                        }
                        arrayList2.clear();
                        this.Vq.Vi.remove(arrayList2);
                    }
                };
                if (i4 == 0 && i == 0 && i2 == 0) {
                    anonymousClass3.run();
                    return;
                }
                long j;
                long j2;
                long j3 = i4 != 0 ? this.Zn : 0;
                if (i != 0) {
                    j = this.Zo;
                } else {
                    j = 0;
                }
                if (i2 != 0) {
                    j2 = this.Zp;
                } else {
                    j2 = 0;
                }
                y.a(((s) arrayList2.get(0)).aal, anonymousClass3, j3 + Math.max(j, j2));
            }
        }
    }

    public final boolean b(s sVar) {
        e(sVar);
        this.Ve.add(sVar);
        return true;
    }

    public final boolean c(s sVar) {
        e(sVar);
        y.d(sVar.aal, 0.0f);
        this.Vf.add(sVar);
        return true;
    }

    public boolean a(s sVar, int i, int i2, int i3, int i4) {
        View view = sVar.aal;
        int Q = (int) (((float) i) + y.Q(sVar.aal));
        int R = (int) (((float) i2) + y.R(sVar.aal));
        e(sVar);
        int i5 = i3 - Q;
        int i6 = i4 - R;
        if (i5 == 0 && i6 == 0) {
            k(sVar);
            return false;
        }
        if (i5 != 0) {
            y.b(view, (float) (-i5));
        }
        if (i6 != 0) {
            y.c(view, (float) (-i6));
        }
        this.Vg.add(new b(sVar, Q, R, i3, i4));
        return true;
    }

    public final boolean a(s sVar, s sVar2, int i, int i2, int i3, int i4) {
        if (sVar == sVar2) {
            return a(sVar, i, i2, i3, i4);
        }
        float Q = y.Q(sVar.aal);
        float R = y.R(sVar.aal);
        float G = y.G(sVar.aal);
        e(sVar);
        int i5 = (int) (((float) (i3 - i)) - Q);
        int i6 = (int) (((float) (i4 - i2)) - R);
        y.b(sVar.aal, Q);
        y.c(sVar.aal, R);
        y.d(sVar.aal, G);
        if (sVar2 != null) {
            e(sVar2);
            y.b(sVar2.aal, (float) (-i5));
            y.c(sVar2.aal, (float) (-i6));
            y.d(sVar2.aal, 0.0f);
        }
        this.Vh.add(new a(sVar, sVar2, i, i2, i3, i4));
        return true;
    }

    private void a(List<a> list, s sVar) {
        for (int size = list.size() - 1; size >= 0; size--) {
            a aVar = (a) list.get(size);
            if (a(aVar, sVar) && aVar.VB == null && aVar.VC == null) {
                list.remove(aVar);
            }
        }
    }

    private void a(a aVar) {
        if (aVar.VB != null) {
            a(aVar, aVar.VB);
        }
        if (aVar.VC != null) {
            a(aVar, aVar.VC);
        }
    }

    private boolean a(a aVar, s sVar) {
        if (aVar.VC == sVar) {
            aVar.VC = null;
        } else if (aVar.VB != sVar) {
            return false;
        } else {
            aVar.VB = null;
        }
        y.d(sVar.aal, 1.0f);
        y.b(sVar.aal, 0.0f);
        y.c(sVar.aal, 0.0f);
        k(sVar);
        return true;
    }

    public final void d(s sVar) {
        int size;
        View view = sVar.aal;
        y.U(view).cancel();
        for (size = this.Vg.size() - 1; size >= 0; size--) {
            if (((b) this.Vg.get(size)).VH == sVar) {
                y.c(view, 0.0f);
                y.b(view, 0.0f);
                k(sVar);
                this.Vg.remove(size);
            }
        }
        a(this.Vh, sVar);
        if (this.Ve.remove(sVar)) {
            y.d(view, 1.0f);
            k(sVar);
        }
        if (this.Vf.remove(sVar)) {
            y.d(view, 1.0f);
            k(sVar);
        }
        for (size = this.Vk.size() - 1; size >= 0; size--) {
            List list = (ArrayList) this.Vk.get(size);
            a(list, sVar);
            if (list.isEmpty()) {
                this.Vk.remove(size);
            }
        }
        for (int size2 = this.Vj.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList = (ArrayList) this.Vj.get(size2);
            int size3 = arrayList.size() - 1;
            while (size3 >= 0) {
                if (((b) arrayList.get(size3)).VH == sVar) {
                    y.c(view, 0.0f);
                    y.b(view, 0.0f);
                    k(sVar);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.Vj.remove(size2);
                    }
                } else {
                    size3--;
                }
            }
        }
        for (size = this.Vi.size() - 1; size >= 0; size--) {
            arrayList = (ArrayList) this.Vi.get(size);
            if (arrayList.remove(sVar)) {
                y.d(view, 1.0f);
                k(sVar);
                if (arrayList.isEmpty()) {
                    this.Vi.remove(size);
                }
            }
        }
        this.Vn.remove(sVar);
        this.Vl.remove(sVar);
        this.Vo.remove(sVar);
        this.Vm.remove(sVar);
        eO();
    }

    private void e(s sVar) {
        android.support.v4.a.a.v(sVar.aal);
        d(sVar);
    }

    public final boolean isRunning() {
        return (this.Vf.isEmpty() && this.Vh.isEmpty() && this.Vg.isEmpty() && this.Ve.isEmpty() && this.Vm.isEmpty() && this.Vn.isEmpty() && this.Vl.isEmpty() && this.Vo.isEmpty() && this.Vj.isEmpty() && this.Vi.isEmpty() && this.Vk.isEmpty()) ? false : true;
    }

    final void eO() {
        if (!isRunning()) {
            fU();
        }
    }

    public final void eP() {
        int size;
        for (size = this.Vg.size() - 1; size >= 0; size--) {
            b bVar = (b) this.Vg.get(size);
            View view = bVar.VH.aal;
            y.c(view, 0.0f);
            y.b(view, 0.0f);
            k(bVar.VH);
            this.Vg.remove(size);
        }
        for (size = this.Ve.size() - 1; size >= 0; size--) {
            k((s) this.Ve.get(size));
            this.Ve.remove(size);
        }
        for (size = this.Vf.size() - 1; size >= 0; size--) {
            s sVar = (s) this.Vf.get(size);
            y.d(sVar.aal, 1.0f);
            k(sVar);
            this.Vf.remove(size);
        }
        for (size = this.Vh.size() - 1; size >= 0; size--) {
            a((a) this.Vh.get(size));
        }
        this.Vh.clear();
        if (isRunning()) {
            int size2;
            ArrayList arrayList;
            int size3;
            for (size2 = this.Vj.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.Vj.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    b bVar2 = (b) arrayList.get(size3);
                    View view2 = bVar2.VH.aal;
                    y.c(view2, 0.0f);
                    y.b(view2, 0.0f);
                    k(bVar2.VH);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.Vj.remove(arrayList);
                    }
                }
            }
            for (size2 = this.Vi.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.Vi.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    s sVar2 = (s) arrayList.get(size3);
                    y.d(sVar2.aal, 1.0f);
                    k(sVar2);
                    arrayList.remove(size3);
                    if (arrayList.isEmpty()) {
                        this.Vi.remove(arrayList);
                    }
                }
            }
            for (size2 = this.Vk.size() - 1; size2 >= 0; size2--) {
                arrayList = (ArrayList) this.Vk.get(size2);
                for (size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    a((a) arrayList.get(size3));
                    if (arrayList.isEmpty()) {
                        this.Vk.remove(arrayList);
                    }
                }
            }
            g(this.Vn);
            g(this.Vm);
            g(this.Vl);
            g(this.Vo);
            fU();
        }
    }

    private static void g(List<s> list) {
        for (int size = list.size() - 1; size >= 0; size--) {
            y.U(((s) list.get(size)).aal).cancel();
        }
    }

    public final boolean a(s sVar, List<Object> list) {
        return !list.isEmpty() || super.a(sVar, list);
    }
}
