package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.aw;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.plugin.subapp.c.h;
import com.tencent.mm.plugin.subapp.c.k;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.pluginsdk.model.app.aa;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;

final class cc extends b {
    e daB;
    a onG;

    public cc() {
        super(35);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof dv) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903360);
        view.setTag(new dv(this.eKg).cT(view));
        return view;
    }

    protected final String a(a aVar, at atVar) {
        return aVar.onh.bdo;
    }

    protected final boolean a(a aVar) {
        return false;
    }

    public final void a(ad.a aVar, final int i, a aVar2, final at atVar, String str) {
        String H;
        dv dvVar = (dv) aVar;
        this.onG = aVar2;
        com.tencent.mm.q.a dz = am.bnC().dz(atVar.field_msgId);
        String str2 = atVar.field_content;
        com.tencent.mm.q.a.a aVar3 = null;
        if (!(dz == null || str2 == null)) {
            aVar3 = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        }
        com.tencent.mm.plugin.subapp.c.e Cs = com.tencent.mm.plugin.subapp.c.e.Cs(str2);
        if (!(Cs == null || Cs.kfB == 0)) {
            try {
                H = o.H(aVar2.nDR.nEl, Cs.kfB);
                CharSequence charSequence = SQLiteDatabase.KeyEmpty;
                if (H != null && H.length() > 0) {
                    String[] split = H.split(";");
                    charSequence = charSequence + split[0].replace(" ", SQLiteDatabase.KeyEmpty);
                    if (split.length > 1) {
                        charSequence = charSequence + split[1];
                    }
                }
                if (!(aVar3 == null || aVar3.description == null)) {
                    charSequence = charSequence + " " + aVar3.description;
                }
                dvVar.dtZ.setText(charSequence);
            } catch (Throwable e) {
                v.a("MicroMsg.ChattingItemVoiceRemindRemind", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        v.d("MicroMsg.ChattingItemVoiceRemindRemind", "content remind " + atVar.field_content);
        if (t.kS(atVar.field_imgPath) && Cs.kfH > 0) {
            ak.yW();
            bx S = c.wJ().S(atVar.field_talker, (long) Cs.kfH);
            if (!t.kS(S.field_imgPath)) {
                H = k.lb(com.tencent.mm.model.k.xF());
                if (j.n(h.as(S.field_imgPath, false), h.as(H, false), false)) {
                    atVar.cI(H);
                    ak.yW();
                    c.wJ().a(atVar.field_msgId, atVar);
                }
            }
        }
        if (t.kS(atVar.field_imgPath) && Cs != null && Cs.aXa != null && Cs.aXa.length() > 0 && Cs.cob > 0 && this.daB == null) {
            str2 = k.lb(com.tencent.mm.model.k.xF());
            String as = h.as(str2, false);
            if (t.kS(atVar.field_imgPath)) {
                atVar.cI(str2);
                ak.yW();
                c.wJ().a(atVar.field_msgId, atVar);
                v.d("MicroMsg.ChattingItemVoiceRemindRemind", "content.attachid " + aVar3.aXa);
                com.tencent.mm.pluginsdk.model.app.b a = l.a(as, atVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.aXa, aVar3.cob);
                v.d("MicroMsg.ChattingItemVoiceRemindRemind", "ainfo.field_mediaSvrId " + a.field_mediaSvrId);
                if (a.field_mediaSvrId != null) {
                    n vy = ak.vy();
                    e anonymousClass1 = new e(this) {
                        final /* synthetic */ cc opU;

                        {
                            this.opU = r1;
                        }

                        public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                            v.d("MicroMsg.ChattingItemVoiceRemindRemind", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                            ak.vy().b(221, this.opU.daB);
                            this.opU.daB = null;
                        }
                    };
                    this.daB = anonymousClass1;
                    vy.a(221, anonymousClass1);
                    v.d("MicroMsg.ChattingItemVoiceRemindRemind", "doscene");
                    ak.vy().a(new aa(a), 0);
                }
            }
        }
        dvVar.oyN.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ cc opU;

            public final void onClick(View view) {
                if (t.kS(atVar.field_imgPath)) {
                    v.d("MicroMsg.ChattingItemVoiceRemindRemind", "filename is null");
                } else {
                    this.opU.onG.onh.oqd.d(i, atVar);
                }
            }
        });
        Object obj = (this.onG.onh.oqd.isPlaying() && this.onG.onh.oqd.olq == atVar.field_msgId) ? 1 : null;
        if (obj != null) {
            dvVar.oyN.setImageResource(2130838733);
        } else {
            dvVar.oyN.setImageResource(2130838735);
        }
        dvVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        dvVar.onC.setOnClickListener(aVar2.onh.oqh);
        ak.yW();
        if (c.isSDCardAvailable()) {
            dvVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        }
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        int GC = l.GC(this.onG.cf(atVar.field_content, atVar.field_isSend));
        com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(this.onG.cf(atVar.field_content, atVar.field_isSend));
        if (dV.cob <= 0 || (dV.cob > 0 && GC >= 100)) {
            contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_READABLE, 0, this.onG.getString(2131234555));
        }
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
            case MMGIFException.D_GIF_ERR_NOT_READABLE /*111*/:
                Intent intent = new Intent(aVar.nDR.nEl, MsgRetransmitUI.class);
                intent.putExtra("Retr_Msg_content", aVar.cf(atVar.field_content, atVar.field_isSend));
                intent.putExtra("Retr_Msg_Type", 2);
                intent.putExtra("Retr_Msg_Id", atVar.field_msgId);
                aVar.startActivity(intent);
                break;
        }
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return true;
    }
}
