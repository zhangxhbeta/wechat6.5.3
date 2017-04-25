package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.protocal.c.qg;
import com.tencent.mm.protocal.c.qp;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.storage.u;

public final class o extends a {
    private final int fSr;

    public static class a extends b {
        TextView dtY;
        TextView dtZ;
        ImageView eZn;
        TextView fSs;
    }

    public o(g gVar) {
        super(gVar);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 60);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, 2130903600, null), aVar, iVar);
            aVar.eZn = (ImageView) view.findViewById(2131756943);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.dtY.setSingleLine(false);
            aVar.dtY.setMaxLines(2);
            aVar.dtZ = (TextView) view.findViewById(2131755034);
            aVar.fSs = (TextView) view.findViewById(2131755046);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, iVar);
        pw n = v.n(iVar);
        qp qpVar = iVar.field_favProto.mtc;
        qg qgVar = iVar.field_favProto.mtP;
        TextView textView = aVar.dtY;
        pw n2 = v.n(iVar);
        CharSequence charSequence = "";
        if (qpVar != null) {
            charSequence = qpVar.title;
        }
        if (be.kS(charSequence) && n2 != null) {
            charSequence = n2.title;
        }
        if (be.kS(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        TextView textView2 = aVar.dtZ;
        pw n3 = v.n(iVar);
        textView2.setVisibility(8);
        if (!(n3 == null || be.kS(n3.canvasPageXml))) {
            textView2.setVisibility(0);
            CharSequence charSequence2 = n3.desc;
            if (be.kS(charSequence2)) {
                textView2.setVisibility(8);
            } else {
                textView2.setText(charSequence2);
                textView2.setVisibility(0);
            }
        }
        textView = aVar.fSs;
        n2 = v.n(iVar);
        charSequence = "";
        if (qpVar != null) {
            charSequence = be.KI(qpVar.mur);
        }
        if (qgVar != null) {
            if (!be.kS(qgVar.appId)) {
                charSequence = be.ah(c.getAppName(textView.getContext(), qgVar.appId), "");
            } else if (!be.kS(qgVar.aWH)) {
                ak.yW();
                u LX = com.tencent.mm.model.c.wH().LX(qgVar.aWH);
                if (LX == null || !LX.field_username.equals(qgVar.aWH)) {
                    com.tencent.mm.model.ab.a.crZ.a(qgVar.aWH, "", null);
                } else {
                    charSequence = LX.tU();
                }
            }
            if (be.kS(charSequence) || charSequence.equals(qgVar.aWH)) {
                charSequence = be.KI(qgVar.cZp);
            }
        }
        if (be.kS(charSequence) || !(n2 == null || be.kS(n2.canvasPageXml))) {
            textView.setVisibility(8);
        } else {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
        int Ga = com.tencent.mm.pluginsdk.c.Ga(n.msh);
        g gVar = this.fJV;
        ImageView imageView = aVar.eZn;
        if (Ga == 2131165241) {
            Ga = 2131165247;
        }
        gVar.a(imageView, n, iVar, Ga, this.fSr, this.fSr);
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
