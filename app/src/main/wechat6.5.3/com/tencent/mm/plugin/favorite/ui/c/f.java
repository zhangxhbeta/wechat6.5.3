package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.qc;
import com.tencent.mm.sdk.platformtools.be;

public final class f extends a {

    public static class a extends b {
        TextView dtY;
        TextView dtZ;
        ImageView eZn;
    }

    public f(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, 2130903601, null), aVar, iVar);
            aVar.eZn = (ImageView) view.findViewById(2131756943);
            aVar.dtY = (TextView) view.findViewById(2131755050);
            aVar.dtZ = (TextView) view.findViewById(2131755035);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, iVar);
        bVar.eZn.setImageResource(2131165511);
        qc qcVar = iVar.field_favProto.mta;
        CharSequence charSequence = iVar.field_favProto.gxy;
        if (!be.kS(charSequence)) {
            bVar.dtY.setText(e.a(bVar.dtY.getContext(), charSequence, bVar.dtY.getTextSize()));
            if (be.kS(qcVar.bkV)) {
                bVar.dtZ.setText(qcVar.label);
            } else {
                bVar.dtZ.setText(qcVar.bkV);
            }
        } else if (be.kS(qcVar.bkV)) {
            bVar.dtY.setText(qcVar.label);
            bVar.dtZ.setText(2131232684);
        } else {
            bVar.dtY.setText(qcVar.bkV);
            bVar.dtZ.setText(qcVar.label);
        }
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
