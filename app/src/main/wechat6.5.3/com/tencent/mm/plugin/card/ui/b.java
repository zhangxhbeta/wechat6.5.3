package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.database.Cursor;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.j;

public final class b extends j<CardInfo> {
    private final String TAG = "MicroMsg.CardAdapter";
    private int count = 0;
    c eFW;
    private int eHD;

    public final /* synthetic */ Object a(Object obj, Cursor cursor) {
        obj = (CardInfo) obj;
        if (obj == null) {
            obj = new CardInfo();
        }
        if (cursor.isClosed()) {
            v.e("MicroMsg.CardAdapter", "cursor is closed!");
        } else {
            obj.b(cursor);
        }
        return obj;
    }

    public b(Context context, int i) {
        super(context, new CardInfo());
        this.eHD = i;
        iQ(true);
        this.eFW = new j(context, this);
    }

    public final void Ol() {
        v.v("MicroMsg.CardAdapter", "resetCursor");
        Cursor iU = af.aak().iU(this.eHD);
        if (iU != null) {
            this.count = iU.getCount();
            v.v("MicroMsg.CardAdapter", "card count:" + this.count);
        }
        setCursor(iU);
        notifyDataSetChanged();
    }

    protected final void Om() {
        avc();
        Ol();
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        return this.eFW.a(i, view, (CardInfo) getItem(i));
    }
}
