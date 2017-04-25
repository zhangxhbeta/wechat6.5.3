package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.d;
import com.tencent.mm.ae.e;
import com.tencent.mm.ae.f;
import com.tencent.mm.ae.m;
import com.tencent.mm.ae.n;
import com.tencent.mm.e.a.cp;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.pluginsdk.model.app.g;
import com.tencent.mm.sdk.c.b;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mmdb.FileUtils;

final class bn extends c {
    private a onG;

    public bn() {
        super(3);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903353);
        view.setTag(new dk(this.eKg).o(view, false));
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        boolean z;
        View view;
        this.onG = aVar2;
        aVar = (dk) aVar;
        boolean containsKey = m.Gy().cNQ.containsKey(Long.valueOf(atVar.field_msgId));
        d j = n.GH().j(atVar);
        if (j == null || containsKey) {
            z = false;
        } else {
            boolean z2;
            if (m.Gy().ak(j.cLu)) {
                m.d al = m.Gy().al(j.cLu);
                int i2 = (int) al.cOe;
                z2 = i2 == 0 ? true : ((int) al.cOf) == i2 && i2 != 0;
            } else {
                z2 = e.b(j);
            }
            z = z2;
        }
        f GH = n.GH();
        ImageView imageView = aVar.okl;
        String str2 = atVar.field_imgPath;
        float density = com.tencent.mm.bd.a.getDensity(aVar2.nDR.nEl);
        int i3 = atVar.bNp;
        int i4 = atVar.bNq;
        ImageView imageView2 = aVar.oxM;
        if (z) {
            view = null;
        } else {
            view = aVar.oxN;
        }
        if (!(GH.a(imageView, str2, density, i3, i4, true, 2130837922, imageView2, 2130837924, 0, true, view) || this.lVu)) {
            aVar.okl.setImageDrawable(com.tencent.mm.bd.a.a(aVar2.nDR.nEl, 2130838794));
        }
        if (j != null || containsKey) {
            Object obj = (z || atVar.field_status == 5) ? 1 : null;
            if (containsKey) {
                aVar.oxL.setText("0%");
            } else {
                int i5;
                TextView textView = aVar.oxL;
                StringBuilder stringBuilder = new StringBuilder();
                if (j != null) {
                    i2 = j.cyu;
                    i5 = j.offset;
                    if (m.Gy().ak(j.cLu)) {
                        al = m.Gy().al(j.cLu);
                        i2 = (int) al.cOe;
                        i5 = (int) al.cOf;
                    }
                    if (j.Gp()) {
                        d fC = n.GH().fC(j.cLE);
                        if (m.Gy().ak((long) j.cLE)) {
                            al = m.Gy().al((long) j.cLE);
                            i2 = (int) al.cOe;
                            i5 = (int) al.cOf;
                        } else {
                            i2 = fC.cyu;
                            i5 = fC.offset;
                        }
                    }
                    if (i2 > 0) {
                        i5 = i5 >= i2 ? 100 : (i5 * 100) / i2;
                        textView.setText(stringBuilder.append(i5).append("%").toString());
                    }
                }
                i5 = 0;
                textView.setText(stringBuilder.append(i5).append("%").toString());
            }
            aVar.ieT.setVisibility(obj != null ? 8 : 0);
            aVar.oxL.setVisibility(obj != null ? 8 : 0);
            aVar.oxN.setVisibility(obj != null ? 8 : 0);
        } else {
            aVar.oxN.setVisibility(8);
            aVar.ieT.setVisibility(8);
            aVar.oxL.setVisibility(8);
        }
        aVar.onC.setTag(new dl(atVar, aVar2.nQK, i, atVar.field_talker, 0, (byte) 0));
        aVar.onC.setOnClickListener(aVar2.onh.oqh);
        aVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        aVar.okl.setContentDescription(aVar2.getString(2131231802));
        if (ad.bEA()) {
            aVar.ieT.setVisibility(8);
            v.d("MicroMsg.ContactInfoUI", "[oneliang]%s,%s", Long.valueOf(atVar.field_msgId), Integer.valueOf(atVar.field_status));
            if (ad.bEA()) {
                if (atVar.field_status == 2 && ad.a(aVar2.onh, atVar.field_msgId)) {
                    if (aVar.okm != null) {
                        aVar.okm.setVisibility(0);
                    }
                } else if (aVar.okm != null) {
                    aVar.okm.setVisibility(8);
                }
            }
        }
        ad.a(i, aVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        ak.yW();
        if (com.tencent.mm.model.c.isSDCardAvailable()) {
            int i = ((dl) view.getTag()).position;
            d dVar = null;
            if (atVar.field_msgId > 0) {
                dVar = n.GH().ai(atVar.field_msgId);
            }
            if ((dVar == null || dVar.cLu <= 0) && atVar.field_msgSvrId > 0) {
                dVar = n.GH().ah(atVar.field_msgSvrId);
            }
            if (dVar.Gp() && dVar.cyu == 0) {
                n.GH().fC(dVar.cLE);
            }
            contextMenu.add(i, MMGIFException.D_GIF_ERR_CLOSE_FAILED, 0, view.getContext().getString(2131234555));
            if (atVar.field_status == 5) {
                contextMenu.add(i, MMGIFException.D_GIF_ERR_NOT_GIF_FILE, 0, view.getContext().getString(2131231874));
            }
            if (com.tencent.mm.modelbiz.e.Dg() && !this.onG.bFL()) {
                contextMenu.add(i, 114, 0, view.getContext().getString(2131231825));
            }
            if (com.tencent.mm.ay.c.EH("favorite")) {
                contextMenu.add(i, 116, 0, view.getContext().getString(2131234180));
            }
            b cpVar = new cp();
            cpVar.bay.bao = atVar.field_msgId;
            com.tencent.mm.sdk.c.a.nhr.z(cpVar);
            if (cpVar.baz.aZW || g.G(this.onG.nDR.nEl, atVar.field_type)) {
                contextMenu.add(i, FileUtils.S_IWUSR, 0, view.getContext().getString(2131231834));
            }
            if (!atVar.bvZ() && atVar.bwj() && ((atVar.field_status == 2 || atVar.bNs == 1) && ad.bEz() && ad.OI(atVar.field_talker))) {
                contextMenu.add(i, 123, 0, view.getContext().getString(2131231836));
            }
            if (!this.onG.bFL()) {
                contextMenu.add(i, 100, 0, view.getContext().getString(2131231828));
            }
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }

    public static void a(ad.a aVar, int i, int i2) {
        int i3 = i2 > 0 ? i >= i2 ? 100 : (int) ((((long) i) * 100) / ((long) i2)) : 0;
        dk dkVar = (dk) aVar;
        if (i3 < 100 || dkVar.oxL.getVisibility() == 0) {
            dkVar.oxL.setText(i3 + "%");
            if (ad.bEA()) {
                dkVar.ieT.setVisibility(8);
            } else {
                dkVar.ieT.setVisibility(0);
            }
            dkVar.oxL.setVisibility(0);
            dkVar.oxN.setVisibility(0);
        }
    }
}
