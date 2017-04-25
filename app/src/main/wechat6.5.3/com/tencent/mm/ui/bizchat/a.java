package com.tencent.mm.ui.bizchat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.a.a.c;
import com.tencent.mm.ae.n;
import com.tencent.mm.modelbiz.a.e;
import com.tencent.mm.modelsearch.h;
import java.util.HashMap;
import java.util.Map;

public final class a extends com.tencent.mm.ui.contact.a.a {
    private static Map<String, c> ohd = new HashMap();
    public CharSequence dtS;
    public long ezh = -1;
    public String ohc;
    private b ohe = new b(this);
    a ohf = new a(this);
    public String username;

    public class a extends com.tencent.mm.ui.contact.a.a.a {
        public ImageView dtX;
        public TextView dtZ;
        public TextView euh;
        final /* synthetic */ a ohg;

        public a(a aVar) {
            this.ohg = aVar;
            super(aVar);
        }
    }

    public class b extends com.tencent.mm.ui.contact.a.a.b {
        final /* synthetic */ a ohg;

        public b(a aVar) {
            this.ohg = aVar;
            super(aVar);
        }

        public final View a(Context context, ViewGroup viewGroup) {
            View inflate = LayoutInflater.from(context).inflate(2130904338, viewGroup, false);
            a aVar = this.ohg.ohf;
            aVar.dtX = (ImageView) inflate.findViewById(2131755508);
            aVar.euh = (TextView) inflate.findViewById(2131755456);
            aVar.dtZ = (TextView) inflate.findViewById(2131755458);
            aVar.dtZ.setVisibility(8);
            inflate.setTag(aVar);
            return inflate;
        }

        public final void a(Context context, com.tencent.mm.ui.contact.a.a.a aVar, com.tencent.mm.ui.contact.a.a aVar2, boolean z, boolean z2) {
            a aVar3 = (a) aVar2;
            a aVar4 = (a) aVar;
            h.a(aVar3.dtS, aVar4.euh);
            n.GL().a(aVar3.ohc, aVar4.dtX, a.OD(aVar3.username));
        }

        public final boolean NG() {
            return false;
        }
    }

    static /* synthetic */ c OD(String str) {
        if (str == null) {
            return null;
        }
        if (ohd.containsKey(str) && ohd.get(str) != null) {
            return (c) ohd.get(str);
        }
        com.tencent.mm.ae.a.a.c.a aVar = new com.tencent.mm.ae.a.a.c.a();
        aVar.cPv = e.ib(str);
        aVar.cPs = true;
        aVar.cPO = true;
        aVar.cPH = 2131165440;
        c GU = aVar.GU();
        ohd.put(str, GU);
        return GU;
    }

    public a(int i) {
        super(4, i);
    }

    public final void bo(Context context) {
        this.dtS = com.tencent.mm.pluginsdk.ui.d.e.a(context, this.dtS, com.tencent.mm.bd.a.N(context, 2131493169));
    }

    public final com.tencent.mm.ui.contact.a.a.b NE() {
        return this.ohe;
    }

    protected final com.tencent.mm.ui.contact.a.a.a NF() {
        return this.ohf;
    }
}
