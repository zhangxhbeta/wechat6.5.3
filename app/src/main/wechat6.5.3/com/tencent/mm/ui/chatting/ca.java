package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.m;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.modelvoice.q;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.u;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.database.SQLiteDatabase;

final class ca extends b {
    private a onG;

    public ca() {
        super(6);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903326);
        view.setTag(new ei(this.eKg).q(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.nQK;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        ImageView imageView;
        int i2;
        boolean z = true;
        this.onG = aVar2;
        ei eiVar = (ei) aVar;
        eiVar.ozs.nSh = true;
        boolean z2 = aVar2.nQK;
        ad.a(aVar2.onh, atVar.field_msgId);
        ei.a(eiVar, atVar, i, aVar2, true);
        if (new n(atVar.field_content).time == 0) {
            imageView = eiVar.oky;
            i2 = 8;
        } else {
            if ((aVar2.onh.oqd == null || aVar2.onh.oqd.olq != atVar.field_msgId) && !q.y(atVar)) {
                z = false;
            }
            imageView = eiVar.oky;
            if (z) {
                i2 = 8;
            } else {
                i2 = 0;
            }
        }
        imageView.setVisibility(i2);
        String str2 = atVar.bNm;
        if (str2 == null || str2.length() == 0) {
            eiVar.oks.setVisibility(8);
            return;
        }
        eiVar.oks.setVisibility(0);
        ad.b(aVar2, eiVar.oks, (Object) dl.Pa(str2));
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        ak.yW();
        if (c.isSDCardAvailable()) {
            int i = ((dl) view.getTag()).position;
            if (!((new n(atVar.field_content).time == 0 && atVar.field_isSend == 0) || (atVar.field_status == 1 && atVar.field_isSend == 1))) {
                boolean z;
                ak.yW();
                Boolean bool = (Boolean) c.vf().get(26, null);
                if (bool == null) {
                    bool = Boolean.valueOf(false);
                }
                if (bool.booleanValue()) {
                    contextMenu.add(i, 120, 0, 2131231732);
                } else {
                    contextMenu.add(i, 119, 0, 2131231731);
                }
                ak.yW();
                u LX = c.wH().LX(atVar.field_talker);
                if (m.eP(atVar.field_talker) || m.fn(atVar.field_talker) || LX == null || LX.bvm()) {
                    z = false;
                } else {
                    z = true;
                }
                if (com.tencent.mm.ay.c.EH("favorite")) {
                    contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
                }
                if (z) {
                    if (com.tencent.mm.modelbiz.u.Dy().fh(2) > 0) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (z && !this.onG.bFL()) {
                        contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
                    }
                }
                if (m.eD(atVar.field_talker) && com.tencent.mm.sdk.platformtools.u.bsU()) {
                    contextMenu.add(i, 121, 0, 2131231842);
                    z = true;
                } else {
                    z = false;
                }
                if (!this.onG.bFL()) {
                    contextMenu.add(i, 100, 0, view.getContext().getString(2131231831));
                }
                if (com.tencent.mm.sdk.platformtools.u.bsU() && !r0) {
                    contextMenu.add(i, 121, 0, 2131231842);
                }
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, final a aVar, final at atVar) {
        switch (menuItem.getItemId()) {
            case 119:
                aVar.jN(true);
                return true;
            case 120:
                aVar.jN(false);
                return true;
            case 121:
                if (a.bGd()) {
                    g.a(aVar.nDR.nEl, aVar.nDR.nEl.getString(2131235847), SQLiteDatabase.KeyEmpty, new OnClickListener(this) {
                        final /* synthetic */ ca opL;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.bGe();
                            aVar.az(atVar);
                        }
                    });
                } else {
                    aVar.az(atVar);
                }
                com.tencent.mm.modelstat.b.daJ.t(atVar);
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }
}
