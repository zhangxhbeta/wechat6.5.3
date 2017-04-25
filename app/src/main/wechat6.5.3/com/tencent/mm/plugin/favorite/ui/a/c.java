package com.tencent.mm.plugin.favorite.ui.a;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.favorite.h;
import com.tencent.mm.plugin.favorite.ui.base.FavTagPanel;
import com.tencent.mm.protocal.c.qk;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public abstract class c extends BaseAdapter implements com.tencent.mm.plugin.favorite.b.r.a, com.tencent.mm.ui.base.MMTagPanel.a {
    private Context context;
    private int fPA = 2130839272;
    private Set<String> fPB = new HashSet();
    private int fPz = 2131689909;

    public static class a {
        TextView exF;
        FavTagPanel fPC;
    }

    public abstract void th(String str);

    public abstract void ti(String str);

    public /* synthetic */ Object getItem(int i) {
        return h.aln().kE(i);
    }

    public c(Context context) {
        this.context = context;
    }

    public int getCount() {
        h.aln();
        return 1;
    }

    public long getItemId(int i) {
        return (long) i;
    }

    public View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            view = View.inflate(this.context, 2130903618, null);
            a aVar2 = new a();
            aVar2.exF = (TextView) view.findViewById(2131756991);
            aVar2.fPC = (FavTagPanel) view.findViewById(2131756992);
            aVar2.fPC.nYp = this;
            aVar2.fPC.fPA = this.fPA;
            aVar2.fPC.fPz = this.fPz;
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        FavTagPanel favTagPanel = aVar.fPC;
        Collection collection = this.fPB;
        List<qk> kE = h.aln().kE(i);
        if (!(kE == null || kE.isEmpty())) {
            List linkedList = new LinkedList();
            for (qk qkVar : kE) {
                linkedList.add(qkVar.lnP);
            }
            favTagPanel.a(collection, linkedList);
        }
        return view;
    }

    public final void rU(String str) {
    }

    public final void rV(String str) {
    }

    public final void rW(String str) {
    }

    public final void aii() {
    }

    public final void tj(String str) {
        this.fPB.add(str);
        notifyDataSetChanged();
    }

    public final void tk(String str) {
        this.fPB.remove(str);
        notifyDataSetChanged();
    }

    public final void au(List<String> list) {
        this.fPB.clear();
        if (list != null) {
            this.fPB.addAll(list);
        }
    }

    public final void rT(String str) {
        tj(str);
        th(str);
    }

    public final void rS(String str) {
        tk(str);
        ti(str);
    }

    public final void alK() {
        v.d("MicroMsg.FavoriteTagPanelAdapter", "on addtag callback");
        notifyDataSetChanged();
    }

    public final void alL() {
        v.d("MicroMsg.FavoriteTagPanelAdapter", "on removetag callback");
        notifyDataSetChanged();
    }

    public final void f(boolean z, int i) {
    }
}
