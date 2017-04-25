package com.tencent.mm.ui.f.a;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.sdk.platformtools.v;

public final class c extends a {
    public String oPC;
    private b oPD;
    private a oPE;

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public ImageView eZn;
        public TextView ijk;
        final /* synthetic */ c oPF;

        public a(c cVar) {
            this.oPF = cVar;
            super(cVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ c oPF;

        public b(c cVar) {
            this.oPF = cVar;
            super(cVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903688, viewGroup, false);
            a aVar = new a(this.oPF);
            aVar.ijk = (TextView) inflate.findViewById(2131755314);
            aVar.eZn = (ImageView) inflate.findViewById(2131756771);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, a aVar2) {
            a aVar3 = (a) aVar;
            c cVar = (c) aVar2;
            cY(aVar3.dtW);
            aVar3.ijk.setText(cVar.oPC);
            aVar3.eZn.setImageResource(2131165595);
        }

        public final boolean a(Context context, a aVar) {
            Intent intent = new Intent();
            intent.putExtra("detail_query", this.oPF.bkC);
            intent.putExtra("detail_type", this.oPF.iHC);
            intent.putExtra("Search_Scene", this.oPF.iHJ);
            com.tencent.mm.ay.c.b(context, "search", ".ui.FTSDetailUI", intent);
            return true;
        }
    }

    public c(int i) {
        super(12, i);
        this.oPD = new b(this);
        this.oPE = new a(this);
        this.oPt = true;
    }

    public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar) {
        if (h.fV(this.iHC) < 0) {
            this.oPC = "";
        } else {
            this.oPC = context.getResources().getString(2131234809, new Object[]{context.getResources().getString(r0)});
        }
        v.i("MicroMsg.FTS.FTSMoreButtonDataItem", "fillDataItem: tip=%s", new Object[]{this.oPC});
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.oPD;
    }
}
