package com.tencent.mm.ui.chatting;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ay.c;
import com.tencent.mm.model.aw;
import com.tencent.mm.platformtools.t;
import com.tencent.mm.pluginsdk.model.app.am;
import com.tencent.mm.pluginsdk.model.app.l;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;

public final class bj extends ad {
    private com.tencent.mm.ui.chatting.ChattingUI.a onG;

    final class a extends com.tencent.mm.ui.chatting.ad.a {
        protected TextView ooZ;
        protected TextView opa;
        protected TextView opb;
        protected TextView opc;
        protected TextView opd;
        protected TextView ope;
        protected ImageView opf;
        final /* synthetic */ bj opg;

        public a(bj bjVar, int i) {
            this.opg = bjVar;
            super(i);
        }

        public final a cO(View view) {
            super.cM(view);
            this.ooZ = (TextView) view.findViewById(2131756241);
            this.opb = (TextView) view.findViewById(2131756239);
            this.opa = (TextView) view.findViewById(2131756242);
            this.opc = (TextView) view.findViewById(2131756240);
            this.opd = (TextView) view.findViewById(2131756245);
            this.ope = (TextView) view.findViewById(2131756243);
            this.gfb = (CheckBox) view.findViewById(2131755022);
            this.opf = (ImageView) view.findViewById(2131756244);
            return this;
        }
    }

    public bj() {
        super(52);
    }

    public final View a(LayoutInflater layoutInflater, View view) {
        if (view != null && view.getTag() != null && (view.getTag() instanceof a) && ((a) view.getTag()).type == this.eKg) {
            return view;
        }
        view = new bd(layoutInflater, 2130903331);
        view.setTag(new a(this, this.eKg).cO(view));
        return view;
    }

    public final void a(com.tencent.mm.ui.chatting.ad.a aVar, int i, com.tencent.mm.ui.chatting.ChattingUI.a aVar2, at atVar, String str) {
        com.tencent.mm.q.a.a aVar3;
        this.onG = aVar2;
        a aVar4 = (a) aVar;
        com.tencent.mm.q.a dz = am.bnC().dz(atVar.field_msgId);
        String str2 = atVar.field_content;
        if (dz == null || str2 == null) {
            String str3 = "MicroMsg.ChattingItemHardDeviceMsg";
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
        HardDeviceChattingItemView hardDeviceChattingItemView = (HardDeviceChattingItemView) aVar.onC;
        if (aVar3 != null && (aVar3.aXx == 1 || aVar3.coW == 1)) {
            int i2;
            if (t.kS(aVar3.coR)) {
                str3 = aVar3.coN;
                str2 = aVar3.coO;
                if (be.kS(str3) || be.kS(str2)) {
                    v.e("MicroMsg.HardDeviceChattingItemView", "color is null or highlight color is null, color = %s, highlight color = %s", str3, str2);
                    str3 = "#ffffff";
                    str2 = "#ffffff";
                }
                Drawable stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(new int[]{16842919}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[]{16842908}, new ColorDrawable(Color.parseColor(str2)));
                stateListDrawable.addState(new int[]{16842766}, new ColorDrawable(Color.parseColor(str3)));
                stateListDrawable.addState(new int[0], new ColorDrawable(Color.parseColor(str3)));
                hardDeviceChattingItemView.setBackgroundDrawable(stateListDrawable);
                aVar3.coR = "#ffffff";
                str3 = aVar3.coP;
                str4 = aVar3.coQ;
                int i3 = com.tencent.mm.bi.a.a.white;
                i2 = com.tencent.mm.bi.a.a.white;
                if (!(t.kS(str3) || t.kS(str4))) {
                    try {
                        i3 = Color.parseColor(str3);
                        i2 = Color.parseColor(str4);
                    } catch (IllegalArgumentException e) {
                        v.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: line color given color is incorrect. use default");
                    }
                }
                Drawable stateListDrawable2 = new StateListDrawable();
                stateListDrawable2.addState(new int[]{16842919}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842908}, new ColorDrawable(i2));
                stateListDrawable2.addState(new int[]{16842766}, new ColorDrawable(i3));
                stateListDrawable2.addState(new int[0], new ColorDrawable(i3));
                aVar4.ope.setBackgroundDrawable(stateListDrawable2);
            }
            str2 = aVar3.coR;
            if (aVar4 != null) {
                i2 = com.tencent.mm.bi.a.a.white;
                if (!t.kS(str2)) {
                    try {
                        i2 = Color.parseColor(str2);
                    } catch (IllegalArgumentException e2) {
                        v.w("MicroMsg.ChattingItemHardDeviceMsg", "hy: given color is incorrect.use default");
                    }
                }
                aVar4.opb.setTextColor(i2);
                aVar4.opc.setTextColor(i2);
                aVar4.ooZ.setTextColor(i2);
                aVar4.opa.setTextColor(i2);
                aVar4.opd.setTextColor(i2);
            }
            aVar4.opb.setText(aVar3.coJ);
            aVar4.opc.setText(aVar3.coH);
            aVar4.ooZ.setText(aVar3.coL);
            aVar4.opa.setText(aVar3.coK);
            aVar4.opd.setText(aVar3.coM);
            if (t.kS(aVar3.coS)) {
                aVar4.opf.setVisibility(8);
            } else {
                aVar4.opf.setVisibility(0);
                b.p(aVar4.opf, aVar3.coS);
            }
        }
        aVar.onC.setOnLongClickListener(aVar2.onh.oqj);
        aVar.onC.setTag(dlVar);
        aVar.onC.setOnClickListener(aVar2.onh.oqh);
    }

    public final boolean a(ContextMenu contextMenu, View view, at atVar) {
        contextMenu.add(((dl) view.getTag()).position, 100, 0, this.onG.getString(2131231829));
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
        boolean z = false;
        String str = atVar.field_content;
        com.tencent.mm.q.a.a B = com.tencent.mm.q.a.a.B(str, atVar.field_reserved);
        if (B == null) {
            v.i("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, content is null.");
            return false;
        }
        v.d("MicroMsg.ChattingItemHardDeviceMsg", "onItemClick, url is (%s).", B.url);
        if (t.kS(B.url)) {
            if (!t.kS(B.coI)) {
                if (System.currentTimeMillis() - (((long) B.coY) * 1000) >= 2592000000L) {
                    z = true;
                }
                if (!z) {
                    Intent intent = new Intent();
                    intent.putExtra("key_rank_info", str);
                    intent.putExtra("key_rank_semi", atVar.field_reserved);
                    intent.putExtra("key_rank_title", B.coT);
                    intent.putExtra("key_champion_info", B.coU);
                    intent.putExtra("key_champion_coverimg", B.coU);
                    intent.putExtra("rank_id", B.coI);
                    intent.putExtra("app_username", B.appName);
                    intent.putExtra("device_type", B.coX);
                    intent.putExtra("key_champioin_username", B.coS);
                    c.b(aVar.nDR.nEl, "exdevice", ".ui.ExdeviceRankInfoUI", intent);
                    return true;
                }
            }
            c.w(aVar.nDR.nEl, "exdevice", ".ui.ExdeviceExpireUI");
            return true;
        }
        intent = new Intent();
        intent.putExtra("rawUrl", B.url);
        c.b(aVar.nDR.nEl, "webview", ".ui.tools.WebViewUI", intent);
        return true;
    }
}
