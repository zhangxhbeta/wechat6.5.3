package com.tencent.mm.ui.contact.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.modelsearch.h;

public final class f extends a {
    public String oJx;
    private b oJy = new b(this);
    a oJz = new a(this);

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public TextView eVt;
        final /* synthetic */ f oJA;

        public a(f fVar) {
            this.oJA = fVar;
            super(fVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ f oJA;

        public b(f fVar) {
            this.oJA = fVar;
            super(fVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130904340, viewGroup, false);
            a aVar = this.oJA.oJz;
            aVar.eVt = (TextView) inflate.findViewById(2131756332);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, a aVar2, boolean z, boolean z2) {
            h.a(((f) aVar2).oJx, ((a) aVar).eVt);
        }

        public final boolean NG() {
            return false;
        }
    }

    public f(int i) {
        super(0, i);
    }

    public final void bo(Context context) {
    }

    public final com.tencent.mm.ui.contact.a.a.b NE() {
        return this.oJy;
    }

    protected final com.tencent.mm.ui.contact.a.a.a NF() {
        return this.oJz;
    }
}
