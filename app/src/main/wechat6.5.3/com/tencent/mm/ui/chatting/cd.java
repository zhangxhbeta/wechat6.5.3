package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.model.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mm.v.e;
import com.tencent.mm.v.n;

final class cd extends b {
    e daB;
    a onG;

    public cd() {
        super(33);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof eb) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903361);
        view.setTag(new eb(this.eKg).cU(view));
        return view;
    }

    public final void a(ad.a aVar, final int i, a aVar2, final at atVar, String str) {
        eb ebVar = (eb) aVar;
        this.onG = aVar2;
        com.tencent.mm.q.a dz = am.bnC().dz(atVar.field_msgId);
        String str2 = atVar.field_content;
        com.tencent.mm.q.a.a aVar3 = null;
        if (!(dz == null || str2 == null)) {
            aVar3 = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        }
        if (aVar3 != null) {
            ebVar.dtZ.setText(aVar3.description);
        }
        v.d("MicroMsg.ChattingItemVoiceRemindsys", "content sys " + atVar.field_content);
        com.tencent.mm.plugin.subapp.c.e Cs = com.tencent.mm.plugin.subapp.c.e.Cs(str2);
        if (Cs != null && Cs.kfD != null && Cs.kfD.length() > 0 && Cs.kfE > 0 && this.daB == null && aVar3 != null && be.kS(atVar.field_imgPath)) {
            str2 = k.lb(com.tencent.mm.model.k.xF());
            String as = h.as(str2, false);
            atVar.cI(str2);
            ak.yW();
            c.wJ().a(atVar.field_msgId, atVar);
            long j = atVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Cs.kfD;
            int i3 = Cs.kfE;
            int i4 = aVar3.type;
            String str5 = aVar3.cop;
            final String a = l.a(as, j, i2, str3, str4, i3, i4, aVar3.cof);
            if (a != null) {
                n vy = ak.vy();
                e anonymousClass1 = new e(this) {
                    final /* synthetic */ cd opX;

                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        v.d("MicroMsg.ChattingItemVoiceRemindsys", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        boolean z = false;
                        if (ab.a.csd != null) {
                            z = ab.a.csd.K(atVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((aa) kVar).getMediaId().equals(a)) {
                            this.opX.onG.onh.oqd.b(i, atVar);
                        }
                        ak.vy().b(221, this.opX.daB);
                        this.opX.daB = null;
                    }
                };
                this.daB = anonymousClass1;
                vy.a(221, anonymousClass1);
                com.tencent.mm.v.k aaVar = new aa(a);
                aaVar.bnv();
                ak.vy().a(aaVar, 0);
            }
        }
        ebVar.dtZ.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        ebVar.dtZ.setOnClickListener(aVar2.onh.oqh);
        ak.yW();
        if (c.isSDCardAvailable()) {
            ebVar.dtZ.setOnLongClickListener(aVar2.onh.oqj);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, this.onG.getString(2131231829));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = atVar.field_content;
                com.tencent.mm.q.a.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str);
                }
                if (aVar2 != null) {
                    l.GB(aVar2.aXa);
                }
                aw.L(atVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return true;
    }
}
