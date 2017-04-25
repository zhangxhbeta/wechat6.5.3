package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.net.URLDecoder;

final class ai extends b {
    private a onG;

    public ai() {
        super(66);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903307);
        view.setTag(new t(this.eKg).o(view, true));
        return view;
    }

    protected final boolean a(a aVar) {
        return aVar.nQK;
    }

    private static String OJ(String str) {
        try {
            com.tencent.mm.q.a.a dV = com.tencent.mm.q.a.a.dV(str);
            if (dV != null) {
                return URLDecoder.decode(dV.content, "UTF-8");
            }
        } catch (Exception e) {
            v.e("MicroMsg.ChattingItemTextFrom", "getMsgContent error: %s", e.getMessage());
        }
        return SQLiteDatabase.KeyEmpty;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        String trim;
        CharSequence OJ;
        TextView textView;
        int i2;
        Object bEn;
        this.onG = aVar2;
        t tVar = (t) aVar;
        String str2 = atVar.field_content;
        String str3 = aVar2.onh.bdo;
        tVar.olI.jJ(true);
        if (aVar2.nQK && !aVar2.lKa) {
            int fK = aw.fK(str2);
            if (fK != -1) {
                trim = str2.substring(0, fK).trim();
                if (trim == null || trim.length() <= 0) {
                    trim = str3;
                }
                str3 = trim;
                trim = str2.substring(fK + 1).trim();
                OJ = OJ(trim);
                a((ad.a) tVar, aVar2, atVar, str3);
                ad.a((ad.a) tVar, aVar2, str3, atVar);
                tVar.olH.setText(OJ);
                textView = tVar.olH;
                i2 = atVar.field_type;
                bEn = aVar2.bEn();
                if (i2 != 301989937) {
                    e.a(textView, bEn);
                }
                textView.getText();
                tVar.olH.setTag(dl.a(atVar, aVar2.nQK, i));
                tVar.olH.setOnClickListener(aVar2.onh.oqh);
                tVar.olH.setOnLongClickListener(aVar2.onh.oqj);
                tVar.olH.pdC = aVar2.onh.oql;
            }
        }
        trim = str2;
        OJ = OJ(trim);
        a((ad.a) tVar, aVar2, atVar, str3);
        ad.a((ad.a) tVar, aVar2, str3, atVar);
        tVar.olH.setText(OJ);
        textView = tVar.olH;
        i2 = atVar.field_type;
        bEn = aVar2.bEn();
        if (i2 != 301989937) {
            e.a(textView, bEn);
        }
        textView.getText();
        tVar.olH.setTag(dl.a(atVar, aVar2.nQK, i));
        tVar.olH.setOnClickListener(aVar2.onh.oqh);
        tVar.olH.setOnLongClickListener(aVar2.onh.oqj);
        tVar.olH.pdC = aVar2.onh.oql;
    }

    protected final boolean bEy() {
        return false;
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
