package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.c;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.URLDecoder;

final class aj extends c {
    private a onG;

    public aj() {
        super(67);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903338);
        view.setTag(new t(this.eKg).o(view, false));
        return view;
    }

    private static String OJ(String str) {
        try {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
            if (dV != null) {
                return URLDecoder.decode(dV.content, "UTF-8");
            }
        } catch (Exception e) {
            v.e("MicroMsg.ChattingItemTextTo", "getMsgContent error: %s", e.getMessage());
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        int i2 = 8;
        this.onG = aVar2;
        t tVar = (t) aVar;
        if (ad.bEA()) {
            if (tVar.ieT != null) {
                tVar.ieT.setVisibility(8);
            }
            if (atVar.field_status == 1 || atVar.field_status == 5) {
                if (tVar.okm != null) {
                    tVar.okm.setVisibility(8);
                }
                tVar.olH.setBackgroundResource(2130838029);
                atVar.nvD = true;
            } else {
                tVar.olH.setBackgroundResource(2130838028);
                if (tVar.okm != null) {
                    if (ad.a(aVar2.onh, atVar.field_msgId)) {
                        if (atVar.nvD) {
                            Animation alphaAnimation = new AlphaAnimation(0.5f, 1.0f);
                            alphaAnimation.setDuration(300);
                            tVar.olH.startAnimation(alphaAnimation);
                            atVar.nvD = false;
                        }
                        tVar.okm.setVisibility(0);
                    } else {
                        tVar.okm.setVisibility(8);
                    }
                }
            }
        } else if (tVar.ieT != null) {
            ProgressBar progressBar = tVar.ieT;
            if (atVar.field_status < 2) {
                i2 = 0;
            }
            progressBar.setVisibility(i2);
        }
        CharSequence OJ = OJ(atVar.field_content);
        if (be.kS(OJ)) {
            v.e("MicroMsg.ChattingItemTextTo", "[carl] text to, content is null! why?? localid : %s, svrid : %s", Long.valueOf(atVar.field_msgId), Long.valueOf(atVar.field_msgSvrId));
        }
        tVar.olI.jJ(true);
        tVar.olH.setMinWidth(0);
        tVar.olH.setText(OJ);
        TextView textView = tVar.olH;
        int i3 = atVar.field_type;
        Object bEn = aVar2.bEn();
        if (i3 != 301989937) {
            e.a(textView, bEn);
        }
        textView.getText();
        tVar.olH.setTag(dl.a(atVar, aVar2.nQK, i));
        tVar.olH.setOnClickListener(aVar2.onh.oqh);
        tVar.olH.setOnLongClickListener(aVar2.onh.oqj);
        tVar.olH.pdC = aVar2.onh.oql;
        ad.a(i, (ad.a) tVar, atVar, aVar2.onh.cyO, aVar2.nQK, aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        contextMenu.add(((dl) view.getTag()).position, 100, 0, view.getContext().getString(2131231829));
        return false;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }
}
