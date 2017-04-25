package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.storage.at;
import com.tencent.mm.storage.at.c;
import com.tencent.mm.ui.chatting.ChattingUI.a;
import com.tencent.mm.ui.chatting.ad.b;

final class bq extends b {
    private a onG;

    public bq() {
        super(8);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = layoutInflater.inflate(2130903322, null);
        dp dpVar = new dp(this.eKg);
        dpVar.eTg = (TextView) view.findViewById(2131755027);
        dpVar.iJL = (TextView) view.findViewById(2131755341);
        dpVar.okl = (ImageView) view.findViewById(2131756216);
        dpVar.ltr = (TextView) view.findViewById(2131756217);
        dpVar.lts = (TextView) view.findViewById(2131755342);
        dpVar.onC = view.findViewById(2131756148);
        view.setTag(dpVar);
        return view;
    }

    public final void a(ad.a aVar, int i, a aVar2, at atVar, String str) {
        this.onG = aVar2;
        dp dpVar = (dp) aVar;
        ak.yW();
        c MS = com.tencent.mm.model.c.wJ().MS(atVar.field_content);
        dpVar.ltr.setText(MS.title);
        dpVar.lts.setText(MS.content);
        ad.a((ad.a) dpVar, MS.cYw);
        dpVar.okl.setVisibility(MS.fPG ? 0 : 8);
        dpVar.onC.setTag(new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0));
        dpVar.onC.setOnClickListener(aVar2.onh.oqh);
        dpVar.onC.setOnLongClickListener(aVar2.onh.oqj);
    }

    protected final boolean bEy() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        int i = ((dl) view.getTag()).position;
        if (!this.onG.bFL()) {
            contextMenu.add(i, 100, 0, view.getContext().getString(2131231829));
        }
        return true;
    }

    public final boolean a(MenuItem menuItem, a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, a aVar, at atVar) {
        return false;
    }
}
