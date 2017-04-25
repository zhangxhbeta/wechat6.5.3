package com.tencent.mm.plugin.brandservice;

import android.content.Context;
import com.tencent.mm.e.a.aa;
import com.tencent.mm.model.ag;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.brandservice.a.h;
import com.tencent.mm.pluginsdk.c.c;
import com.tencent.mm.pluginsdk.i;
import com.tencent.mm.sdk.c.a;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;

public class Plugin implements c {
    public i createApplication() {
        a.nhr.e(new com.tencent.mm.sdk.c.c<aa>(this) {
            final /* synthetic */ Plugin exh;

            {
                this.exh = r2;
                this.nhz = aa.class.getName().hashCode();
            }

            public final /* synthetic */ boolean a(b bVar) {
                aa aaVar = (aa) bVar;
                if (aaVar == null || !(aaVar instanceof aa)) {
                    return false;
                }
                aa aaVar2 = aaVar;
                switch (aaVar2.aXn.action) {
                    case 1:
                        Context context = aaVar2.aXn.context;
                        String str = aaVar2.aXn.aXp;
                        String str2 = aaVar2.aXn.title;
                        int i = aaVar2.aXn.fromScene;
                        long j = aaVar2.aXn.aXq;
                        int i2 = aaVar2.aXn.offset;
                        boolean z = aaVar2.aXn.aXr;
                        if (context == null || be.kS(str)) {
                            v.e("MicroMsg.BrandService.BrandServiceLogic", "context(%s) or keyword(%s) is null or nil.", new Object[]{context, str});
                            return false;
                        }
                        ak.vy().a(1071, new a(context, str, j, i2, i, str2, z, aaVar2));
                        ak.vy().a(new h(str, j, i2, i, ""), 0);
                        return true;
                    default:
                        v.d("MicroMsg.BrandService.BrandServiceLogic", "Do not support the action(%d).", new Object[]{Integer.valueOf(aaVar2.aXn.action)});
                        return false;
                }
            }
        });
        return new a();
    }

    public com.tencent.mm.pluginsdk.c.b getContactWidgetFactory() {
        return null;
    }

    public ag createSubCore() {
        return new b();
    }
}
