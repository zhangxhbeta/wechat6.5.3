package com.tencent.mm.ui.f.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;
import com.tencent.mm.sdk.platformtools.v;

public class b extends a {
    public String oJx;
    a oPA;
    private b oPz;

    public class a extends com.tencent.mm.ui.f.a.a.a {
        public View dtW;
        public TextView eVt;
        public View hBo;
        final /* synthetic */ b oPB;

        public a(b bVar) {
            this.oPB = bVar;
            super(bVar);
        }
    }

    public class b extends com.tencent.mm.ui.f.a.a.b {
        final /* synthetic */ b oPB;

        public b(b bVar) {
            this.oPB = bVar;
            super(bVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130903683, viewGroup, false);
            a aVar = this.oPB.oPA;
            aVar.eVt = (TextView) inflate.findViewById(2131756332);
            aVar.hBo = inflate.findViewById(2131755206);
            aVar.dtW = inflate.findViewById(2131757157);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.f.a.a.a aVar, a aVar2) {
            a aVar3 = (a) aVar;
            h.b(this.oPB.oJx, aVar3.eVt);
            if (this.oPB.position == 0) {
                aVar3.hBo.setVisibility(8);
            } else {
                aVar3.hBo.setVisibility(0);
            }
            aVar3.dtW.setBackgroundResource(2130838472);
        }

        public final boolean a(Context context, a aVar) {
            return false;
        }
    }

    public b(int i) {
        super(0, i);
        this.oPz = new b(this);
        this.oPA = new a(this);
        this.imS = false;
    }

    public void a(Context context, com.tencent.mm.ui.f.a.a.a aVar) {
        int fV = h.fV(this.iHC);
        if (fV < 0) {
            this.oJx = "";
        } else {
            this.oJx = context.getString(fV);
        }
        v.i("MicroMsg.FTS.FTSHeaderDataItem", "fillingDataItem: header=%s", new Object[]{this.oJx});
    }

    public final com.tencent.mm.ui.f.a.a.b YL() {
        return this.oPz;
    }
}
