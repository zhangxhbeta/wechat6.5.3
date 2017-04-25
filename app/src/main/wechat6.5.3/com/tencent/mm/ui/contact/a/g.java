package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.content.res.Resources;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;

public final class g extends a {
    public int kCd;
    public boolean oJB;
    private b oJC = new b(this);
    com.tencent.mm.ui.contact.a.a.a oJD = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView oJE;
        public ImageView oJF;
        final /* synthetic */ g oJG;

        public a(g gVar) {
            this.oJG = gVar;
            super(gVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ g oJG;

        public b(g gVar) {
            this.oJG = gVar;
            super(gVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130904341, viewGroup, false);
            a aVar = (a) this.oJG.oJD;
            aVar.oJE = (TextView) inflate.findViewById(2131759054);
            aVar.oJF = (ImageView) inflate.findViewById(2131759055);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar;
            g gVar = (g) aVar2;
            Resources resources = context.getResources();
            if (this.oJG.oJB) {
                h.a(resources.getString(2131234857, new Object[]{resources.getString(gVar.kCd)}), aVar3.oJE);
                aVar3.oJF.setRotation(0.0f);
                return;
            }
            h.a(resources.getString(2131234858), aVar3.oJE);
            aVar3.oJF.setRotation(180.0f);
        }

        public final boolean NG() {
            return false;
        }
    }

    public g(int i) {
        super(1, i);
    }

    public final void bo(Context context) {
    }

    public final com.tencent.mm.ui.contact.a.a.b NE() {
        return this.oJC;
    }

    protected final com.tencent.mm.ui.contact.a.a.a NF() {
        return this.oJD;
    }
}
