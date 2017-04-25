package com.tencent.mm.plugin.scanner.a;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mm.e.a.ad;
import com.tencent.mm.e.a.bl;
import com.tencent.mm.e.a.ir;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.scanner.b.a;
import com.tencent.mm.plugin.scanner.b.e;
import com.tencent.mm.plugin.scanner.b.q;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.g;

public final class b {
    String ivT;
    e ivU;
    a ivV;
    e.a ivW = new e.a(this) {
        final /* synthetic */ b ivZ;

        {
            this.ivZ = r1;
        }

        public final void f(int i, Bundle bundle) {
            v.i("MicroMsg.ExternRequestDealQBarStrHandler", "Deal QBar String notify, id:%d", new Object[]{Integer.valueOf(i)});
            ir irVar = new ir();
            irVar.bjg.bje = i;
            irVar.bjg.aXH = this.ivZ.pP;
            irVar.bjg.aXG = this.ivZ.ivT;
            irVar.bjg.bjh = bundle;
            com.tencent.mm.sdk.c.a.nhr.z(irVar);
        }
    };
    public c ivX = new c<bl>(this) {
        final /* synthetic */ b ivZ;

        {
            this.ivZ = r2;
            this.nhz = bl.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            bl blVar = (bl) bVar;
            if (blVar == null || !(blVar instanceof bl)) {
                v.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a DealQBarStrEvent instance");
            } else {
                this.ivZ.aKR();
                this.ivZ.ivT = blVar.aYU.aXG;
                this.ivZ.pP = blVar.aYU.aXH;
                v.i("MicroMsg.ExternRequestDealQBarStrHandler", "request deal qbar, activity:%s, str:%s, codeType: %s, codeVersion: %s", new Object[]{this.ivZ.pP, this.ivZ.ivT, Integer.valueOf(blVar.aYU.aYV), Integer.valueOf(blVar.aYU.aYW)});
                if (blVar.aYU.aYV == 19) {
                    this.ivZ.ivU = new e();
                    this.ivZ.ivU.aYX = blVar.aYU.aYX;
                    this.ivZ.ivU.aHM = blVar.aYU.aHM;
                    this.ivZ.ivU.a(this.ivZ.pP, this.ivZ.ivT, 2, blVar.aYU.aYV, blVar.aYU.aYW, this.ivZ.ivW);
                } else {
                    this.ivZ.ivV = new a();
                    a aVar = this.ivZ.ivV;
                    Context context = this.ivZ.pP;
                    String str = this.ivZ.ivT;
                    int i = blVar.aYU.aYV;
                    int i2 = blVar.aYU.aYW;
                    if (!be.kS(str)) {
                        String[] split = str.split(",");
                        if (split == null || split.length < 2) {
                            v.e("MicroMsg.BarcodeStringHandler", "wrong zbar format");
                        } else {
                            aVar.bij = context;
                            f fVar = new f(q.zb(split[0]), split[1], i, i2);
                            ak.vy().a(1061, aVar);
                            ak.vy().a(fVar, 0);
                            context.getString(2131231164);
                            aVar.dwR = g.a(context, context.getString(2131234280), true, new com.tencent.mm.plugin.scanner.b.a.AnonymousClass1(aVar, fVar));
                        }
                    }
                }
            }
            return false;
        }
    };
    public c ivY = new c<ad>(this) {
        final /* synthetic */ b ivZ;

        {
            this.ivZ = r2;
            this.nhz = ad.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(com.tencent.mm.sdk.c.b bVar) {
            ad adVar = (ad) bVar;
            if (adVar == null || !(adVar instanceof ad)) {
                v.e("MicroMsg.ExternRequestDealQBarStrHandler", "event is null or not a CancelDealQBarStrEvent instance");
            } else {
                v.i("MicroMsg.ExternRequestDealQBarStrHandler", "cancel deal qbar, activity:%s, str:%s", new Object[]{this.ivZ.pP, this.ivZ.ivT});
                if (adVar.aXF.aXH == this.ivZ.pP && adVar.aXF.aXG.equals(this.ivZ.ivT)) {
                    this.ivZ.aKR();
                } else {
                    v.e("MicroMsg.ExternRequestDealQBarStrHandler", "not same as string that are dealing");
                }
            }
            return false;
        }
    };
    Activity pP;

    public final void aKR() {
        if (this.ivU != null) {
            this.ivU.aLS();
            this.ivU = null;
        }
        this.pP = null;
        this.ivT = null;
    }
}
