package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.c;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMImageView;

public final class i extends a {
    private final String fSA;
    private final int fSr;

    public static class a extends b {
        TextView dtY;
        TextView dtZ;
        MMImageView fQG;
        TextView fSs;
    }

    public i(g gVar) {
        super(gVar);
        this.fSr = com.tencent.mm.bd.a.fromDPToPix(gVar.context, 60);
        this.fSA = gVar.context.getString(2131232706);
    }

    public final View a(View view, ViewGroup viewGroup, com.tencent.mm.plugin.favorite.b.i iVar) {
        b aVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            aVar = new a();
            view = a(View.inflate(context, 2130903600, null), aVar, iVar);
            aVar.fQG = (MMImageView) view.findViewById(2131756943);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.dtZ = (TextView) view.findViewById(2131755034);
            aVar.dtZ.setVisibility(8);
            aVar.fSs = (TextView) view.findViewById(2131755046);
            aVar.fSs.setVisibility(0);
        } else {
            aVar = (a) view.getTag();
        }
        a(aVar, iVar);
        aVar.dtY.setText(be.ma(iVar.field_favProto.mte.title));
        aVar.fSs.setText(be.ah(c.getAppName(context, iVar.field_favProto.mtP.appId), this.fSA));
        this.fJV.a(aVar.fQG, null, iVar, 2131165241, this.fSr, this.fSr);
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
