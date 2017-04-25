package com.tencent.mm.ui.chatting;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.m;
import com.tencent.mm.modelstat.b;
import com.tencent.mm.modelvoice.n;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.g;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mmdb.database.SQLiteDatabase;

final class ce extends c {
    private a onG;

    public ce() {
        super(7);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903356);
        view.setTag(new ei(this.eKg).q(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        ei eiVar = (ei) aVar;
        eiVar.ozs.nSh = false;
        boolean z = aVar2.nQK;
        ad.a(aVar2.onh, atVar.field_msgId);
        ei.a(eiVar, atVar, i, aVar2, false);
        if (ad.bEA()) {
            if (eiVar.ozx != null) {
                eiVar.ozx.setVisibility(8);
            }
            if (eiVar.okm != null) {
                eiVar.okm.setVisibility(8);
            }
            if (atVar.field_status == 1 || atVar.field_status == 5) {
                eiVar.ozy.setBackgroundResource(2130838029);
                atVar.nvD = true;
            } else {
                eiVar.ozy.setBackgroundResource(2130838028);
                if (eiVar.okm != null && ad.a(aVar2.onh, atVar.field_msgId)) {
                    if (atVar.nvD) {
                        Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                        alphaAnimation.setDuration(300);
                        eiVar.ozy.startAnimation(alphaAnimation);
                        atVar.nvD = false;
                    }
                    eiVar.okm.setVisibility(0);
                }
            }
        } else if (eiVar.ozx != null) {
            eiVar.ozx.setVisibility(0);
            if (atVar.field_status >= 2) {
                eiVar.ozx.setVisibility(8);
            }
        }
        ad.a(i, (ad.a) eiVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            int i = ((dl) view.getTag()).position;
            n nVar = new n(atVar.field_content);
            if (!((nVar.time == 0 && atVar.field_isSend == 0) || (atVar.field_status == 1 && atVar.field_isSend == 1))) {
                if (this.onG.evz) {
                    contextMenu.add(i, 120, 0, 2131231732);
                } else {
                    contextMenu.add(i, 119, 0, 2131231731);
                }
            }
            if (atVar.field_status == 5) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, view.getContext().getString(2131231874));
            }
            if (com.tencent.mm.ay.c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            if (!atVar.bvZ() && atVar.bwb() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
            }
            boolean z;
            if (m.eD(atVar.field_talker) && u.bsU()) {
                contextMenu.add(i, 121, 0, 2131231842);
                z = true;
            } else {
                z = false;
            }
            if (!((nVar.time == 0 && atVar.field_isSend == 0) || ((atVar.field_status == 1 && atVar.field_isSend == 1) || this.onG.bFL()))) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231831));
            }
            if (u.bsU() && !r0) {
                contextMenu.add(i, 121, 0, 2131231842);
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
                        final /* synthetic */ ce opY;

                        public final void onClick(DialogInterface dialogInterface, int i) {
                            a.bGe();
                            aVar.az(atVar);
                        }
                    });
                } else {
                    aVar.az(atVar);
                }
                b.daJ.t(atVar);
                return true;
            default:
                return false;
        }
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }
}
