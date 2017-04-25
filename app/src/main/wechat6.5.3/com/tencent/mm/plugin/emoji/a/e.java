package com.tencent.mm.plugin.emoji.a;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.ae.n;
import com.tencent.mm.plugin.emoji.model.g;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.a.b;
import java.util.List;

public final class e extends ArrayAdapter<com.tencent.mm.storage.a.a> {
    private final String TAG = "MicroMsg.emoji.EmojiSortAdapter";
    private int eZj;
    public List<com.tencent.mm.storage.a.a> eZk;
    private Context mContext;

    class a {
        TextView dtY;
        View eZl;
        ImageView eZm;
        ImageView eZn;
        final /* synthetic */ e eZo;

        public a(e eVar, View view) {
            this.eZo = eVar;
            this.eZm = (ImageView) view.findViewById(2131756657);
            this.eZn = (ImageView) view.findViewById(2131756659);
            this.dtY = (TextView) view.findViewById(2131756660);
            this.eZl = view.findViewById(2131756658);
            LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.height = eVar.eZj;
                view.setLayoutParams(layoutParams);
            }
        }
    }

    public e(Context context, List<com.tencent.mm.storage.a.a> list) {
        super(context, 2130903482, list);
        this.eZj = context.getResources().getDimensionPixelSize(2131493431);
        this.mContext = context;
        this.eZk = list;
    }

    public final void aeL() {
        if (this.eZk != null) {
            int size = this.eZk.size();
            for (int i = 0; i < size; i++) {
                ((com.tencent.mm.storage.a.a) this.eZk.get(i)).field_idx = i;
            }
            g.afx().fci.ch(this.eZk);
            com.tencent.mm.storage.a.a aI = g.afx().fci.aI(com.tencent.mm.storage.a.a.nwK, false);
            aI.field_sort = this.eZk.size() + 2;
            b bVar = g.afx().fci;
            if (!b.bxt()) {
                bVar = g.afx().fci;
                if (aI != null) {
                    v.d("MicroMsg.emoji.EmojiGroupInfoStorage", "jacks updateEmojiGroupInfo: packname: %s, lasttime: %d, sort: %d", new Object[]{aI.field_packName, Long.valueOf(aI.field_lastUseTime), Integer.valueOf(aI.field_sort)});
                    bVar.a(aI);
                    bVar.a("event_update_group", 0, be.bur().toString());
                }
            }
        }
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null || view.getTag() == null) {
            view = LayoutInflater.from(this.mContext).inflate(2130903482, null);
            a aVar2 = new a(this, view);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        com.tencent.mm.storage.a.a aVar3 = (com.tencent.mm.storage.a.a) getItem(i);
        if (com.tencent.mm.plugin.emoji.h.a.b(aVar3)) {
            aVar.dtY.setText(2131232422);
        } else {
            aVar.dtY.setText(aVar3.field_packName);
        }
        if (com.tencent.mm.plugin.emoji.h.a.b(aVar3)) {
            aVar.eZn.setImageResource(2130838375);
        } else {
            n.GL().a(aVar3.field_packIconUrl, aVar.eZn, com.tencent.mm.plugin.emoji.d.g.bl(aVar3.field_productID, aVar3.field_packIconUrl));
        }
        if (i + 1 == getCount()) {
            aVar.eZl.setBackgroundResource(2130838048);
        }
        view.setVisibility(0);
        return view;
    }
}
