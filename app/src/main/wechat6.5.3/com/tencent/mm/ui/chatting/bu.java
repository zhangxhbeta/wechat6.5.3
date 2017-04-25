package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import com.tencent.mars.cdn.CdnLogic;
import com.tencent.mm.storage.at;

final class bu extends ad {
    private bv opI = new bv();
    private br opJ = new br();

    interface a {
        void a(com.tencent.mm.ui.chatting.ad.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar);
    }

    final class b extends com.tencent.mm.ui.chatting.ad.a {
        View kad;
        TextView lts;
        final /* synthetic */ bu opK;

        public b(bu buVar, int i) {
            this.opK = buVar;
            super(i);
        }
    }

    public bu() {
        super(5);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && ((com.tencent.mm.ui.chatting.ad.a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = layoutInflater.inflate(2130903337, null);
        b bVar = new b(this, this.eKg);
        bVar.kad = view;
        bVar.eTg = (TextView) view.findViewById(2131755027);
        bVar.lts = (TextView) view.findViewById(2131755342);
        view.setTag(bVar);
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ad.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, String str) {
        a aVar3;
        if (atVar.field_type == CdnLogic.MediaType_FAVORITE_VIDEO) {
            aVar3 = this.opJ;
        } else {
            aVar3 = this.opI;
        }
        aVar3.a(aVar, i, aVar2, atVar);
    }

    protected final boolean bEy() {
        return false;
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        return false;
    }

    public final boolean a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        return false;
    }
}
