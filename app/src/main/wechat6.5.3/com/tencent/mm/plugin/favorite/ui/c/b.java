package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.b.v;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.protocal.c.pw;
import com.tencent.mm.sdk.platformtools.be;

public final class b extends a {
    private final int fSr;

    public static class a extends com.tencent.mm.plugin.favorite.ui.c.a.b {
        TextView dtY;
        TextView dtZ;
        ImageView eZn;
        TextView fSs;
    }

    public b(g gVar) {
        super(gVar);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 60);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        com.tencent.mm.plugin.favorite.ui.c.a.b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            com.tencent.mm.plugin.favorite.ui.c.a.b aVar = new a();
            view = a(View.inflate(context, 2130903600, null), aVar, iVar);
            aVar.eZn = (ImageView) view.findViewById(2131756943);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.dtY.setSingleLine(false);
            aVar.dtY.setMaxLines(2);
            aVar.dtZ = (TextView) view.findViewById(2131755034);
            aVar.fSs = (TextView) view.findViewById(2131755046);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, iVar);
        pw n = v.n(iVar);
        ak.yW();
        com.tencent.mm.storage.at.a MU = c.wJ().MU(n.desc);
        if (MU.lct == null || MU.lct.length() <= 0) {
            com.tencent.mm.sdk.platformtools.v.e("MicroMsg.FavCardListItem", "parse possible friend msg failed");
        }
        if (be.kS(a(MU))) {
            bVar.dtZ.setVisibility(8);
        } else {
            bVar.dtZ.setText(a(MU));
        }
        bVar.fSs.setText(2131232671);
        bVar.fSs.setVisibility(0);
        ImageView imageView = bVar.eZn;
        String str = MU.lct;
        if (be.kS(str)) {
            imageView.setImageResource(2130838080);
        } else {
            com.tencent.mm.pluginsdk.ui.a.b.m(imageView, str);
        }
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String a(com.tencent.mm.storage.at.a r4) {
        /*
        r1 = 1;
        r0 = 0;
        r2 = r4.bLc;
        r3 = com.tencent.mm.sdk.platformtools.be.kS(r2);
        if (r3 == 0) goto L_0x0019;
    L_0x000a:
        r2 = r4.lct;
        r3 = com.tencent.mm.storage.u.LL(r2);
        if (r3 != 0) goto L_0x0018;
    L_0x0012:
        r3 = com.tencent.mm.model.m.eB(r2);
        if (r3 == 0) goto L_0x0019;
    L_0x0018:
        r0 = r1;
    L_0x0019:
        if (r0 != 0) goto L_0x0038;
    L_0x001b:
        com.tencent.mm.model.ak.yW();
        r3 = com.tencent.mm.model.c.wH();
        r3 = r3.LT(r2);
        if (r3 != 0) goto L_0x0038;
    L_0x0028:
        r0 = r4.ldy;
        r0 = com.tencent.mm.model.m.eG(r0);
        if (r1 != 0) goto L_0x0032;
    L_0x0030:
        if (r0 == 0) goto L_0x0036;
    L_0x0032:
        r0 = "";
    L_0x0035:
        return r0;
    L_0x0036:
        r0 = r2;
        goto L_0x0035;
    L_0x0038:
        r1 = r0;
        goto L_0x0028;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.favorite.ui.c.b.a(com.tencent.mm.storage.at$a):java.lang.String");
    }
}
