package com.tencent.mm.ui.chatting;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Toast;
import com.tencent.mm.e.b.bx;
import com.tencent.mm.model.ab;
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
import com.tencent.mm.pluginsdk.model.app.b;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.protocal.c.bdz;
import com.tencent.mm.sdk.platformtools.j;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.transmit.MsgRetransmitUI;
import com.tencent.mm.v.e;
import com.tencent.mm.v.n;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.LinkedList;

final class cb extends ad {
    e daB;
    ProgressDialog iKE;
    a onG;

    public cb() {
        super(34);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof da) && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903359);
        view.setTag(new da(this.eKg).cR(view));
        return view;
    }

    protected final boolean bEy() {
        return false;
    }

    public final void a(ad.a aVar, final int i, a aVar2, final at atVar, String str) {
        String H;
        da daVar = (da) aVar;
        this.onG = aVar2;
        com.tencent.mm.q.a dz = am.bnC().dz(atVar.field_msgId);
        String str2 = atVar.field_content;
        com.tencent.mm.q.a.a aVar3 = null;
        if (!(dz == null || str2 == null)) {
            aVar3 = com.tencent.mm.q.a.a.dV(str2);
        }
        boolean z = false;
        final com.tencent.mm.plugin.subapp.c.e Cs = com.tencent.mm.plugin.subapp.c.e.Cs(str2);
        if (!(Cs == null || Cs.kfB == 0)) {
            try {
                H = o.H(this.onG.nDR.nEl, Cs.kfB);
                if (!(aVar3 == null || aVar3.description == null)) {
                    int indexOf = aVar3.description.indexOf(124);
                    if (indexOf <= 0 || aVar3.description.length() <= indexOf + 1) {
                        daVar.dtZ.setText(SQLiteDatabase.KeyEmpty);
                    } else {
                        daVar.dtZ.setText(aVar3.description.substring(indexOf + 1));
                    }
                }
                if (H != null && H.length() > 0) {
                    String[] split = H.split(";");
                    daVar.oxq.setText(split[0]);
                    if (split.length > 1) {
                        daVar.oxr.setText(split[1]);
                    }
                }
            } catch (Throwable e) {
                v.a("MicroMsg.ChattingItemVoiceRemindConfirm", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
            z = t.gI(Cs.kfB);
        }
        if (z) {
            daVar.oxu.setVisibility(0);
            daVar.dtZ.setTextColor(this.onG.getResources().getColor(2131690092));
            daVar.oxr.setTextColor(this.onG.getResources().getColor(2131690092));
            daVar.oxq.setTextColor(this.onG.getResources().getColor(2131690092));
        } else {
            daVar.oxu.setVisibility(8);
            daVar.dtZ.setTextColor(this.onG.getResources().getColor(2131690091));
            daVar.oxr.setTextColor(this.onG.getResources().getColor(2131690091));
            daVar.oxq.setTextColor(this.onG.getResources().getColor(2131690091));
        }
        daVar.oxs.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ cb opO;

            public final void onClick(View view) {
                if (t.kS(atVar.field_imgPath)) {
                    v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "filename is null");
                } else {
                    this.opO.onG.onh.oqd.c(i, atVar);
                }
            }
        });
        Object obj = (this.onG.onh.oqd != null && this.onG.onh.oqd.isPlaying() && this.onG.onh.oqd.olq == atVar.field_msgId) ? 1 : null;
        if (obj != null) {
            daVar.oxs.setBackgroundResource(2130839394);
        } else {
            daVar.oxs.setBackgroundResource(2130839395);
        }
        if (Cs != null && !t.kS(Cs.kfD) && Cs.kfE > 0 && t.kS(atVar.field_reserved)) {
            str2 = k.lb(com.tencent.mm.model.k.xF());
            H = h.as(str2, false);
            atVar.cJ(str2);
            ak.yW();
            c.wJ().a(atVar.field_msgId, atVar);
            long j = atVar.field_msgId;
            int i2 = aVar3.sdkVer;
            String str3 = aVar3.appId;
            String str4 = Cs.kfD;
            int i3 = Cs.kfE;
            int i4 = aVar3.type;
            String str5 = aVar3.cop;
            H = l.a(H, j, i2, str3, str4, i3, i4, aVar3.cof);
            if (H != null) {
                n vy = ak.vy();
                e anonymousClass2 = new e(this) {
                    final /* synthetic */ cb opO;

                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        boolean z = false;
                        if (ab.a.csd != null) {
                            z = ab.a.csd.K(atVar.field_msgId);
                        }
                        if (!z && i == 0 && i2 == 0 && ((aa) kVar).getMediaId().equals(H)) {
                            at O = at.O(atVar);
                            O.cI(atVar.field_reserved);
                            O.x(-1);
                            this.opO.onG.onh.oqd.c(i, O);
                        }
                        ak.vy().b(221, this.opO.daB);
                        this.opO.daB = null;
                    }
                };
                this.daB = anonymousClass2;
                vy.a(221, anonymousClass2);
                com.tencent.mm.v.k aaVar = new aa(H);
                aaVar.bnv();
                ak.vy().a(aaVar, 0);
            }
        }
        if (t.kS(atVar.field_imgPath) && Cs.kfH > 0) {
            ak.yW();
            bx S = c.wJ().S(atVar.field_talker, (long) Cs.kfH);
            if (!t.kS(S.field_imgPath)) {
                str2 = k.lb(com.tencent.mm.model.k.xF());
                if (j.n(h.as(S.field_imgPath, false), h.as(str2, false), false)) {
                    atVar.cI(str2);
                    ak.yW();
                    c.wJ().a(atVar.field_msgId, atVar);
                }
            }
        }
        if (t.kS(atVar.field_imgPath) && Cs != null && !t.kS(Cs.aXa) && Cs.cob > 0 && this.daB == null) {
            str2 = k.lb(com.tencent.mm.model.k.xF());
            H = h.as(str2, false);
            atVar.cI(str2);
            ak.yW();
            c.wJ().a(atVar.field_msgId, atVar);
            final b a = l.a(H, atVar.field_msgId, aVar3.sdkVer, aVar3.appId, aVar3.aXa, aVar3.cob);
            v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "mediaId  " + a.field_mediaSvrId);
            if (a.field_mediaSvrId != null) {
                n vy2 = ak.vy();
                e anonymousClass3 = new e(this) {
                    final /* synthetic */ cb opO;

                    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                        v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                        if (((aa) kVar).getMediaId().equals(a.field_mediaSvrId)) {
                            ak.vy().b(221, this.opO.daB);
                            this.opO.daB = null;
                        }
                    }
                };
                this.daB = anonymousClass3;
                vy2.a(221, anonymousClass3);
                ak.vy().a(new aa(a), 0);
            }
        }
        daVar.oxt.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ cb opO;

            public final void onClick(View view) {
                g.a(this.opO.onG.nDR.nEl, 2131235833, 2131235835, new DialogInterface.OnClickListener(this) {
                    final /* synthetic */ AnonymousClass4 opR;

                    {
                        this.opR = r1;
                    }

                    public final void onClick(DialogInterface dialogInterface, int i) {
                        n vy = ak.vy();
                        cb cbVar = this.opR.opO;
                        e anonymousClass1 = new e(this) {
                            final /* synthetic */ AnonymousClass1 opS;

                            {
                                this.opS = r1;
                            }

                            public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
                                v.d("MicroMsg.ChattingItemVoiceRemindConfirm", "errType " + i + " errCode " + i2 + "  scene " + kVar.getType());
                                if (i == 0 && i2 == 0) {
                                    com.tencent.mm.q.a.a dV;
                                    String str2 = atVar.field_content;
                                    if (str2 != null) {
                                        dV = com.tencent.mm.q.a.a.dV(str2);
                                    } else {
                                        dV = null;
                                    }
                                    if (dV != null) {
                                        l.GB(dV.aXa);
                                    }
                                    aw.L(atVar.field_msgId);
                                    Toast.makeText(this.opS.opR.opO.onG.nDR.nEl, this.opS.opR.opO.onG.getString(2131231817), 0).show();
                                }
                                ak.vy().b(331, this.opS.opR.opO.daB);
                                this.opS.opR.opO.daB = null;
                                if (this.opS.opR.opO.iKE != null) {
                                    this.opS.opR.opO.iKE.dismiss();
                                }
                            }
                        };
                        cbVar.daB = anonymousClass1;
                        vy.a(331, anonymousClass1);
                        LinkedList linkedList = new LinkedList();
                        bdz com_tencent_mm_protocal_c_bdz = new bdz();
                        com_tencent_mm_protocal_c_bdz.mcQ = Cs.kfC;
                        linkedList.add(com_tencent_mm_protocal_c_bdz);
                        final com.tencent.mm.v.k aVar = new com.tencent.mm.plugin.subapp.c.a(linkedList, linkedList.size());
                        ak.vy().a(aVar, 0);
                        cb cbVar2 = this.opR.opO;
                        Context context = this.opR.opO.onG.nDR.nEl;
                        this.opR.opO.onG.getString(2131231164);
                        cbVar2.iKE = g.a(context, this.opR.opO.onG.getString(2131231818), true, new OnCancelListener(this) {
                            final /* synthetic */ AnonymousClass1 opS;

                            public final void onCancel(DialogInterface dialogInterface) {
                                ak.vy().c(aVar);
                                ak.vy().b(331, this.opS.opR.opO.daB);
                                this.opS.opR.opO.daB = null;
                                if (this.opS.opR.opO.iKE != null) {
                                    this.opS.opR.opO.iKE.dismiss();
                                }
                            }
                        });
                    }
                }, null);
            }
        });
        daVar.onC.setTag(new dl(atVar, this.onG.nQK, i, null, 0, (byte) 0));
        daVar.onC.setOnClickListener(this.onG.onh.oqh);
        ak.yW();
        if (c.isSDCardAvailable()) {
            daVar.onC.setOnLongClickListener(this.onG.onh.oqj);
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
