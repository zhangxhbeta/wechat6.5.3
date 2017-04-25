package com.tencent.mm.ui.chatting;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.aw;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;

public final class bl extends ad {

    final class a extends com.tencent.mm.ui.chatting.ad.a {
        protected ImageView cHH;
        protected TextView opj;
        final /* synthetic */ bl opk;

        public a(bl blVar, int i) {
            this.opk = blVar;
            super(i);
        }

        public final a cQ(View view) {
            super.cM(view);
            this.gfb = (CheckBox) view.findViewById(2131755022);
            this.cHH = (ImageView) view.findViewById(2131756246);
            this.opj = (TextView) view.findViewById(2131756238);
            return this;
        }
    }

    public bl() {
        super(58);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof a) && ((a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903332);
        view.setTag(new a(this, this.eKg).cQ(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ad.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a aVar3;
        a aVar4 = (a) aVar;
        com.tencent.mm.q.a dz = am.bnC().dz(atVar.field_msgId);
        String str2 = atVar.field_content;
        if (dz == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsgPush";
            String str4 = "amessage:%b, %s, %d, %s";
            Object[] objArr = new Object[4];
            objArr[0] = Boolean.valueOf(dz == null);
            objArr[1] = str2;
            objArr[2] = Long.valueOf(atVar.field_msgId);
            objArr[3] = str;
            v.e(str3, str4, objArr);
            aVar3 = null;
        } else {
            aVar3 = com.tencent.mm.q.a.a.B(str2, atVar.field_reserved);
        }
        dl dlVar = new dl(atVar, aVar2.nQK, i, null, 0, (byte) 0);
        if (aVar3 != null && (aVar3.aXx == 3 || aVar3.coW == 3)) {
            aVar4.cHH.setImageResource(2130838362);
            aVar4.opj.setText(aVar3.cpb);
        }
        aVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        aVar.onC.setTag(dlVar);
        aVar.onC.setOnClickListener(aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        contextMenu.add(((dl) view.getTag()).position, 100, 0, view.getContext().getString(2131231829));
        return false;
    }

    public final boolean a(MenuItem menuItem, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        switch (menuItem.getItemId()) {
            case 100:
                String str = atVar.field_content;
                com.tencent.mm.q.a.a aVar2 = null;
                if (str != null) {
                    aVar2 = com.tencent.mm.q.a.a.dV(str);
                }
                if (aVar2 != null) {
                    l.GB(aVar2.aXa);
                }
                aw.L(atVar.field_msgId);
                break;
        }
        return false;
    }

    public final boolean a(View view, com.tencent.mm.ui.chatting.ChattingUI.a aVar, at atVar) {
        return false;
    }
}
