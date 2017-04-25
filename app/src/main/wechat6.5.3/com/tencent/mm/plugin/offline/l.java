package com.tencent.mm.plugin.offline;

import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import com.tencent.mm.e.a.qv;
import com.tencent.mm.plugin.offline.a.n;
import com.tencent.mm.plugin.offline.a.n.a;
import com.tencent.mm.plugin.offline.a.n.d;
import com.tencent.mm.plugin.wallet_core.model.Bankcard;
import com.tencent.mm.plugin.wallet_core.model.Orders.Commodity;
import com.tencent.mm.plugin.wallet_core.model.k;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.c.c;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.wallet_core.ui.e;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;

public final class l implements a {
    c hcA = new c<qv>(this) {
        final /* synthetic */ l hKl;

        {
            this.hKl = r2;
            this.nhz = qv.class.getName().hashCode();
        }

        public final /* synthetic */ boolean a(b bVar) {
            qv qvVar = (qv) bVar;
            if (qvVar instanceof qv) {
                switch (qvVar.bsq.action) {
                    case 3:
                        if (!com.tencent.mm.pluginsdk.g.a.ati()) {
                            if (!k.bga().bgu()) {
                                if (!k.bga().bgs()) {
                                    if (!k.bga().bgv() || !com.tencent.mm.plugin.offline.b.a.aFk()) {
                                        if (!k.bga().bgv() || com.tencent.mm.plugin.offline.b.a.aFk()) {
                                            if (k.bga().bgw()) {
                                                qvVar.bsr.bss = 3;
                                                break;
                                            }
                                        }
                                        qvVar.bsr.bss = 4;
                                        break;
                                    }
                                    j.aEM();
                                    String cc = j.aEO().cc(5, 0);
                                    Bitmap b = com.tencent.mm.bb.a.a.b(aa.getContext(), cc, 5, 0);
                                    Bitmap b2 = com.tencent.mm.bb.a.a.b(aa.getContext(), cc, 0, 3);
                                    qvVar.bsr.bss = 1;
                                    OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                                    b.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    qvVar.bsr.bsw = byteArrayOutputStream.toByteArray();
                                    byteArrayOutputStream.reset();
                                    b2.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
                                    qvVar.bsr.bsx = byteArrayOutputStream.toByteArray();
                                    qvVar.bsr.bsy = e.PV(cc);
                                    String aFt = com.tencent.mm.plugin.offline.b.a.aFt();
                                    Bankcard bankcard = null;
                                    for (Bankcard bankcard2 : com.tencent.mm.plugin.offline.b.a.eJ(true)) {
                                        Bankcard bankcard22;
                                        if (bankcard22.field_bindSerial == null || !bankcard22.field_bindSerial.equals(aFt)) {
                                            bankcard22 = bankcard;
                                        }
                                        bankcard = bankcard22;
                                    }
                                    if (bankcard == null) {
                                        v.i("MicroMsg.Wear.WearOfflineLogic", "get payway fail");
                                        break;
                                    }
                                    qvVar.bsr.bsz = aa.getContext().getString(2131236520, new Object[]{bankcard.field_desc});
                                    v.i("MicroMsg.Wear.WearOfflineLogic", "payway %s", new Object[]{qvVar.bsr.bsz});
                                    break;
                                }
                                qvVar.bsr.bss = 3;
                                break;
                            }
                            qvVar.bsr.bss = 2;
                            break;
                        }
                        qvVar.bsr.bss = 5;
                        break;
                        break;
                }
            }
            return false;
        }
    };

    public l() {
        com.tencent.mm.sdk.c.a.nhr.e(this.hcA);
        j.aEM();
        j.aEN().a(this);
    }

    private static void U(int i, String str) {
        qv qvVar = new qv();
        qvVar.bsq.bss = i;
        qvVar.bsq.action = 4;
        qvVar.bsq.content = str;
        com.tencent.mm.sdk.c.a.nhr.z(qvVar);
    }

    public final boolean a(n.c cVar) {
        if (cVar.hLc == 6) {
            n.e eVar = (n.e) cVar;
            if (eVar.hLj.kPm == null || eVar.hLj.kPm.size() <= 0) {
                U(9, aa.getContext().getString(2131236513));
            } else {
                Commodity commodity = (Commodity) eVar.hLj.kPm.get(0);
                U(0, aa.getContext().getString(2131236592, new Object[]{e.d(commodity.eWz, commodity.hNg)}));
            }
        } else if (cVar.hLc == 8) {
            U(6, aa.getContext().getString(2131236513));
        } else if (cVar.hLc == 5) {
            U(7, be.ah(((d) cVar).hLg, ""));
        } else if (cVar.hLc == 4) {
            U(8, aa.getContext().getString(2131236514));
        }
        return false;
    }
}
