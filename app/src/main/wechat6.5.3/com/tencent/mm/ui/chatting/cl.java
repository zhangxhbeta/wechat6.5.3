package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.chatting.ad.a;

final class cl extends cg {
    public cl() {
        super(43);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903357);
        view.setTag(new ej(this.eKg).cS(view));
        return view;
    }

    public final void a(a aVar, int i, ChattingUI.a aVar2, at atVar, String str) {
        ej.a((ej) aVar, atVar, false, i, aVar2);
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
