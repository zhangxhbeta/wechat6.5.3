package com.tencent.mm.plugin.wenote.b;

import android.content.Context;
import android.content.Intent;
import com.tencent.mm.e.a.kw;
import com.tencent.mm.model.l;
import com.tencent.mm.plugin.wenote.c.e;
import com.tencent.mm.plugin.wenote.c.i;
import com.tencent.mm.plugin.wenote.ui.a.a;
import com.tencent.mm.protocal.b.a.c;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.py;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.base.g;
import java.util.HashMap;

public final class f extends b {
    private static HashMap<String, a> luj = new HashMap();
    public String bjZ;
    private c iqr = null;
    public Long lui;

    class AnonymousClass1 implements Runnable {
        final /* synthetic */ String luk;
        final /* synthetic */ f lul;

        public AnonymousClass1(f fVar, String str) {
            this.lul = fVar;
            this.luk = str;
        }

        public final void run() {
            this.lul.iqr = f.yy(this.luk);
            if (f.luj.containsKey(this.luk)) {
                this.lul.lty = (a) f.luj.get(this.luk);
            } else {
                this.lul.lty = new a();
                this.lul.lty.bao = this.lul.lui.longValue();
                this.lul.lty.lvG = this.luk;
                if (this.lul.iqr != null && this.lul.iqr.cqE != null) {
                    this.lul.lty.ipS = this.lul.iqr.cqE;
                    this.lul.lty.aKG = 0;
                    f.luj.put(this.luk, this.lul.lty);
                } else {
                    return;
                }
            }
            ad.o(new Runnable(this) {
                final /* synthetic */ AnonymousClass1 lum;

                {
                    this.lum = r1;
                }

                public final void run() {
                    this.lum.lul.blW();
                }
            });
        }

        public final String toString() {
            return super.toString() + "|dealWNoteInfo";
        }
    }

    public f() {
        ltA.clear();
        ltB.clear();
    }

    public static c yy(String str) {
        kw kwVar = new kw();
        kwVar.bmf.type = 0;
        kwVar.bmf.bmh = str;
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        return kwVar.bmg.bmp;
    }

    public final String f(pw pwVar) {
        kw kwVar = new kw();
        kwVar.bmf.type = 1;
        kwVar.bmf.bdE = pwVar;
        kwVar.bmf.bao = this.lui.longValue();
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
        return kwVar.bmg.bmq;
    }

    public final void m(pw pwVar) {
        kw kwVar = new kw();
        kwVar.bmf.type = 8;
        kwVar.bmf.bdE = pwVar;
        kwVar.bmf.bao = this.lui.longValue();
        com.tencent.mm.sdk.c.a.nhr.z(kwVar);
    }

    public final boolean blY() {
        return true;
    }

    public final void r(Context context, Intent intent) {
        intent.putExtra("message_id", this.lui);
        com.tencent.mm.ay.c.b(context, "wenote", ".ui.webview.WNNoteMsgWebViewUI", intent);
    }

    public final void FN(String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.lui);
        intent.putExtra("record_xml", this.bjZ);
        intent.putExtra("record_data_id", ((e) this.ltD.get(str)).luu);
        com.tencent.mm.ay.c.b(aa.getContext(), "record", ".ui.RecordMsgFileUI", intent);
    }

    public final void FP(String str) {
        Intent intent = new Intent();
        intent.putExtra("message_id", this.lui);
        intent.putExtra("record_data_id", ((e) this.ltD.get(str)).luu);
        intent.putExtra("record_xml", this.bjZ);
        com.tencent.mm.ay.c.b(aa.getContext(), "record", ".ui.RecordMsgImageUI", intent);
    }

    public final void FO(String str) {
        py pyVar;
        String str2 = null;
        pw pwVar = ((e) this.ltD.get(str)).lus;
        if (pwVar.msM != null) {
            qc qcVar = pwVar.msM.mta;
            pyVar = pwVar.msM.msY;
        } else {
            pyVar = null;
        }
        if (pyVar != null) {
            if (be.kS(pyVar.mtu)) {
                str2 = l.er(pyVar.bhM);
            } else {
                str2 = l.er(pyVar.mtu);
            }
        }
        i iVar = (i) this.ltD.get(str);
        if (iVar == null) {
            g.bf(aa.getContext(), aa.getContext().getString(2131232713));
            return;
        }
        Intent intent = new Intent();
        intent.putExtra("map_view_type", 2);
        intent.putExtra("kwebmap_slat", iVar.lat);
        intent.putExtra("kwebmap_lng", iVar.lng);
        intent.putExtra("kPoiName", iVar.gUr);
        intent.putExtra("Kwebmap_locaion", iVar.cJf);
        if (iVar.lux >= 0.0d) {
            intent.putExtra("kwebmap_scale", iVar.lux);
        }
        intent.putExtra("kisUsername", str2);
        intent.putExtra("kwebmap_from_to", true);
        intent.putExtra("KFavLocSigleView", true);
        intent.putExtra("kFavCanDel", false);
        intent.putExtra("kFavCanRemark", false);
        com.tencent.mm.ay.c.b(aa.getContext(), "location", ".ui.RedirectUI", intent);
    }
}
