package com.tencent.mm.plugin.favorite.ui.c;

import android.content.Context;
import android.text.SpannableString;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.b.i;
import com.tencent.mm.plugin.favorite.c.g;
import com.tencent.mm.plugin.favorite.ui.c.a.b;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class m extends a {
    private HashMap<String, SpannableString> fSH = new HashMap();

    public static class a extends b {
        TextView eTf;
    }

    public m(g gVar) {
        super(gVar);
    }

    public final View a(View view, ViewGroup viewGroup, i iVar) {
        b bVar;
        Context context = viewGroup.getContext();
        if (view == null) {
            b aVar = new a();
            view = a(View.inflate(context, 2130903608, null), aVar, iVar);
            aVar.eTf = (TextView) view.findViewById(2131756960);
            bVar = aVar;
        } else {
            a aVar2 = (a) view.getTag();
        }
        a(bVar, iVar);
        if (iVar.field_favProto.desc == null || iVar.field_favProto.desc.length() <= 0) {
            bVar.eTf.setText("");
        } else {
            v.d("MicroMsg.FavBaseListItem", "desc %s", new Object[]{iVar.field_favProto.desc});
            bVar.eTf.setText(e.a(bVar.eTf.getContext(), iVar.field_favProto.desc, bVar.eTf.getTextSize()));
        }
        return view;
    }

    public final void bS(View view) {
        e.b(view.getContext(), ((a) view.getTag()).fLP);
    }
}
