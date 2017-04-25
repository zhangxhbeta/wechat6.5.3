package android.support.v7.widget;

import android.os.Bundle;
import android.support.v4.view.a;
import android.support.v4.view.a.b;
import android.support.v4.view.a.b.k;
import android.support.v4.view.y;
import android.support.v7.widget.RecyclerView.h;
import android.support.v7.widget.RecyclerView.l;
import android.support.v7.widget.RecyclerView.p;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

public final class ac extends a {
    final RecyclerView Zq;
    final a aaA = new a(this) {
        final /* synthetic */ ac aaB;

        {
            this.aaB = r1;
        }

        public final void a(View view, b bVar) {
            super.a(view, bVar);
            if (!this.aaB.gf() && this.aaB.Zq.Ym != null) {
                this.aaB.Zq.Ym.b(view, bVar);
            }
        }

        public final boolean performAccessibilityAction(View view, int i, Bundle bundle) {
            if (super.performAccessibilityAction(view, i, bundle)) {
                return true;
            }
            if (this.aaB.gf() || this.aaB.Zq.Ym == null) {
                return false;
            }
            h hVar = this.aaB.Zq.Ym;
            l lVar = hVar.Zq.Ye;
            p pVar = hVar.Zq.YS;
            return false;
        }
    };

    public ac(RecyclerView recyclerView) {
        this.Zq = recyclerView;
    }

    final boolean gf() {
        RecyclerView recyclerView = this.Zq;
        return !recyclerView.Yt || recyclerView.YC || recyclerView.Yg.ey();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean performAccessibilityAction(android.view.View r8, int r9, android.os.Bundle r10) {
        /*
        r7 = this;
        r5 = -1;
        r2 = 1;
        r1 = 0;
        r0 = super.performAccessibilityAction(r8, r9, r10);
        if (r0 == 0) goto L_0x000b;
    L_0x0009:
        r1 = r2;
    L_0x000a:
        return r1;
    L_0x000b:
        r0 = r7.gf();
        if (r0 != 0) goto L_0x000a;
    L_0x0011:
        r0 = r7.Zq;
        r0 = r0.Ym;
        if (r0 == 0) goto L_0x000a;
    L_0x0017:
        r0 = r7.Zq;
        r4 = r0.Ym;
        r0 = r4.Zq;
        r0 = r0.Ye;
        r0 = r4.Zq;
        r0 = r0.YS;
        r0 = r4.Zq;
        if (r0 == 0) goto L_0x000a;
    L_0x0027:
        switch(r9) {
            case 4096: goto L_0x0065;
            case 8192: goto L_0x0037;
            default: goto L_0x002a;
        };
    L_0x002a:
        r0 = r1;
        r3 = r1;
    L_0x002c:
        if (r3 != 0) goto L_0x0030;
    L_0x002e:
        if (r0 == 0) goto L_0x000a;
    L_0x0030:
        r1 = r4.Zq;
        r1.scrollBy(r0, r3);
        r1 = r2;
        goto L_0x000a;
    L_0x0037:
        r0 = r4.Zq;
        r0 = android.support.v4.view.y.g(r0, r5);
        if (r0 == 0) goto L_0x0096;
    L_0x003f:
        r0 = r4.QW;
        r3 = r4.getPaddingTop();
        r0 = r0 - r3;
        r3 = r4.getPaddingBottom();
        r0 = r0 - r3;
        r0 = -r0;
    L_0x004c:
        r3 = r4.Zq;
        r3 = android.support.v4.view.y.f(r3, r5);
        if (r3 == 0) goto L_0x0091;
    L_0x0054:
        r3 = r4.Zx;
        r5 = r4.getPaddingLeft();
        r3 = r3 - r5;
        r5 = r4.getPaddingRight();
        r3 = r3 - r5;
        r3 = -r3;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x002c;
    L_0x0065:
        r0 = r4.Zq;
        r0 = android.support.v4.view.y.g(r0, r2);
        if (r0 == 0) goto L_0x0094;
    L_0x006d:
        r0 = r4.QW;
        r3 = r4.getPaddingTop();
        r0 = r0 - r3;
        r3 = r4.getPaddingBottom();
        r0 = r0 - r3;
    L_0x0079:
        r3 = r4.Zq;
        r3 = android.support.v4.view.y.f(r3, r2);
        if (r3 == 0) goto L_0x0091;
    L_0x0081:
        r3 = r4.Zx;
        r5 = r4.getPaddingLeft();
        r3 = r3 - r5;
        r5 = r4.getPaddingRight();
        r3 = r3 - r5;
        r6 = r3;
        r3 = r0;
        r0 = r6;
        goto L_0x002c;
    L_0x0091:
        r3 = r0;
        r0 = r1;
        goto L_0x002c;
    L_0x0094:
        r0 = r1;
        goto L_0x0079;
    L_0x0096:
        r0 = r1;
        goto L_0x004c;
        */
        throw new UnsupportedOperationException("Method not decompiled: android.support.v7.widget.ac.performAccessibilityAction(android.view.View, int, android.os.Bundle):boolean");
    }

    public final void a(View view, b bVar) {
        super.a(view, bVar);
        bVar.setClassName(RecyclerView.class.getName());
        if (!gf() && this.Zq.Ym != null) {
            h hVar = this.Zq.Ym;
            l lVar = hVar.Zq.Ye;
            p pVar = hVar.Zq.YS;
            if (y.g(hVar.Zq, -1) || y.f(hVar.Zq, -1)) {
                bVar.addAction(8192);
                bVar.setScrollable(true);
            }
            if (y.g(hVar.Zq, 1) || y.f(hVar.Zq, 1)) {
                bVar.addAction(4096);
                bVar.setScrollable(true);
            }
            b.yS.f(bVar.yT, new k(b.yS.a(hVar.a(lVar, pVar), hVar.b(lVar, pVar), false, 0)).yT);
        }
    }

    public final void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(view, accessibilityEvent);
        accessibilityEvent.setClassName(RecyclerView.class.getName());
        if ((view instanceof RecyclerView) && !gf()) {
            RecyclerView recyclerView = (RecyclerView) view;
            if (recyclerView.Ym != null) {
                recyclerView.Ym.onInitializeAccessibilityEvent(accessibilityEvent);
            }
        }
    }
}
