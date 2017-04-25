package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.pluginsdk.j.o;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;

final class ck extends ad {
    public ck() {
        super(25);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = layoutInflater.inflate(2130903362, null);
        view.setTag(new ej(this.eKg).cS(view));
        return view;
    }

    protected final boolean bEy() {
        return false;
    }

    public final void a(a aVar, int i, ChattingUI.a aVar2, at atVar, String str) {
        aVar.eTg.setVisibility(0);
        aVar.eTg.setText(o.m(aVar2.nDR.nEl, atVar.field_createTime));
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, ChattingUI.a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, ChattingUI.a aVar, at atVar) {
        return false;
    }
}
