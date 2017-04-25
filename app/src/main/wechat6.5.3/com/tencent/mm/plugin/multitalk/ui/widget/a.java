package com.tencent.mm.plugin.multitalk.ui.widget;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.ui.contact.a.d;
import com.tencent.mm.ui.contact.a.d.b;

public final class a extends d {
    private a hAT = new a(this);

    public class a extends b {
        final /* synthetic */ a hAU;

        public a(a aVar) {
            this.hAU = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130904098, viewGroup, false);
            com.tencent.mm.ui.contact.a.d.a aVar = (com.tencent.mm.ui.contact.a.d.a) this.hAU.NF();
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.dtY = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtW = inflate.findViewById(2131758337);
            aVar.dua = (CheckBox) inflate.findViewById(2131755510);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            com.tencent.mm.ui.contact.a.d.a aVar3 = (com.tencent.mm.ui.contact.a.d.a) aVar;
            d dVar = (d) aVar2;
            if (dVar.username == null || dVar.username.length() <= 0) {
                aVar3.dtX.setImageResource(2130838080);
            } else {
                com.tencent.mm.pluginsdk.ui.a.b.m(aVar3.dtX, dVar.username);
            }
            h.a(dVar.dtS, aVar3.dtY);
            if (this.hAU.oHa) {
                if (z) {
                    aVar3.dua.setChecked(true);
                    aVar3.dua.setEnabled(false);
                } else {
                    aVar3.dua.setChecked(z2);
                    aVar3.dua.setEnabled(true);
                }
                aVar3.dua.setVisibility(0);
                return;
            }
            aVar3.dua.setVisibility(8);
        }
    }

    public a(int i) {
        super(i);
    }

    public final com.tencent.mm.ui.contact.a.a.b NE() {
        return this.hAT;
    }
}
