package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.view.ViewGroup;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.a;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.c;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.e;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.j;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.l;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.m;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.o;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.q;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.r;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.t;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.u;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.w;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.x;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.y;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.d;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.f;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.g;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.h;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.i;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.k;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.n;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.p;
import com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.s;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.logreport.UpdateInfoReportManager.UpdateLogConst;

public final class aj {
    public static j a(Context context, n nVar, ViewGroup viewGroup, int i) {
        j jVar = null;
        if (nVar != null) {
            switch (nVar.type) {
                case 21:
                    if (nVar.aYp == 2) {
                        return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.n(context, (a) nVar, viewGroup);
                    }
                    if (nVar.aYp == 6) {
                        return new r(context, (g) nVar, viewGroup);
                    }
                    break;
                case 41:
                    switch (nVar.aYp) {
                        case 0:
                            jVar = new u(context, (k) nVar, viewGroup);
                            break;
                        case 1:
                            jVar = new m(context, (k) nVar, viewGroup);
                            break;
                        default:
                            break;
                    }
                case 101:
                    jVar = new o(context, (i) nVar, viewGroup);
                    break;
                case 102:
                    jVar = new e(context, (h) nVar, viewGroup);
                    break;
                case 103:
                    com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m mVar = (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.m) nVar;
                    mVar.bgColor = i;
                    jVar = new q(context, mVar, viewGroup);
                    break;
                case UpdateLogConst.ACTION_POP_INSTALL_DIALOG /*104*/:
                    jVar = new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.g(context, (d) nVar, viewGroup);
                    break;
                case 132:
                    jVar = new y(context, (s) nVar, viewGroup);
                    break;
                default:
                    v.i("SnsAdNativeLandingPagesLayoutHelper", "unknown comp type " + nVar.type);
                    break;
            }
        }
        if (jVar != null) {
            return jVar;
        }
        if (nVar instanceof p) {
            jVar = new x(context, (p) nVar, viewGroup);
            jVar.setBackgroundColor(i);
            return jVar;
        } else if (nVar instanceof g) {
            jVar = new l(context, (g) nVar, viewGroup);
            jVar.setBackgroundColor(i);
            return jVar;
        } else if (nVar instanceof k) {
            return new u(context, (k) nVar, viewGroup);
        } else {
            if (nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.s(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.j) nVar, viewGroup);
            }
            if (nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.v(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.l) nVar, viewGroup);
            }
            if (nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r) {
                return new w(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.r) nVar, viewGroup);
            }
            if (nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.p(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.q) nVar, viewGroup);
            }
            if (nVar instanceof f) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.i(context, (f) nVar, viewGroup);
            }
            if (nVar instanceof c) {
                return new com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.component.f(context, (c) nVar, viewGroup);
            }
            if (nVar instanceof com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) {
                return new t(context, (com.tencent.mm.plugin.sns.storage.AdLandingPagesStorage.AdLandingPageComponent.o) nVar, viewGroup);
            }
            return new j(context, nVar, viewGroup);
        }
    }
}
