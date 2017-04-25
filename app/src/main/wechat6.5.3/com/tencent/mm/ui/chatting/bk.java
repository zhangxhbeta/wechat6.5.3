package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.graphics.Color;
import android.text.TextUtils.TruncateAt;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.ui.base.NoMeasuredTextView;

public final class bk extends ad {

    final class a extends com.tencent.mm.ui.chatting.ad.a {
        protected ImageView cHH;
        protected NoMeasuredTextView oph;
        final /* synthetic */ bk opi;

        public a(bk bkVar, int i) {
            this.opi = bkVar;
            super(i);
        }

        public final a cP(View view) {
            super.cM(view);
            this.gfb = (CheckBox) view.findViewById(2131755022);
            this.cHH = (ImageView) view.findViewById(2131756236);
            this.oph = (NoMeasuredTextView) view.findViewById(2131756238);
            return this;
        }
    }

    public bk() {
        super(57);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof a) && ((a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903330);
        view.setTag(new a(this, this.eKg).cP(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ad.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a aVar3;
        a aVar4 = (a) aVar;
        com.tencent.mm.q.a dz = am.bnC().dz(atVar.field_msgId);
        String str2 = atVar.field_content;
        if (dz == null || str2 == null) {
            String str3 = "MicrMsg.ChattingItemHardDeviceMsgLike";
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
        if (aVar3 != null && (aVar3.aXx == 2 || aVar3.coW == 2)) {
            b.p(aVar4.cHH, aVar3.cpa);
            aVar4.oph.G(aVar2.getResources().getDimension(2131493169));
            aVar4.oph.setTextColor(Color.parseColor("#BF000000"));
            aVar4.oph.setEllipsize(TruncateAt.END);
            aVar4.oph.bCo();
            aVar4.oph.oaP = true;
            aVar4.oph.setText(e.a(aVar2.nDR.nEl, aVar3.coZ));
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
        v.i("MicrMsg.ChattingItemHardDeviceMsgLike", "hy: user clicked on the like item");
        if (atVar == null) {
            v.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, msg is null.");
            return false;
        }
        String str = atVar.field_content;
        com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
        if (B == null) {
            v.i("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, content is null.");
            return false;
        }
        v.d("MicrMsg.ChattingItemHardDeviceMsgLike", "onItemClick, url is (%s).", B.url);
        if (!t.kS(B.url)) {
            Intent intent = new Intent();
            intent.putExtra("rawUrl", B.url);
            c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
            return true;
        } else if (t.kS(B.coI)) {
            Intent intent2 = new Intent();
            intent2.putExtra("key_is_latest", true);
            intent2.putExtra("app_username", B.appName);
            intent2.putExtra("device_type", B.coX);
            intent2.putExtra("locate_to_username", B.cpa);
            c.b(aVar.nDR.nEl, "exdevice", ".ui.ExdeviceRankInfoUI", intent2);
            return false;
        } else {
            Intent intent3 = new Intent();
            intent3.putExtra("key_rank_info", str);
            intent3.putExtra("key_rank_semi", atVar.field_reserved);
            intent3.putExtra("key_rank_title", B.coT);
            intent3.putExtra("key_champion_info", B.coU);
            intent3.putExtra("key_champion_coverimg", B.coU);
            intent3.putExtra("rank_id", B.coI);
            intent3.putExtra("app_username", B.appName);
            intent3.putExtra("device_type", B.coX);
            intent3.putExtra("key_champioin_username", B.coS);
            intent3.putExtra("locate_to_username", B.cpa);
            c.b(aVar.nDR.nEl, "exdevice", ".ui.ExdeviceRankInfoUI", intent3);
            return false;
        }
    }
}
