package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.product.b.n;
import java.util.List;

public final class k extends BaseAdapter {
    OnItemClickListener hSM;
    List<n> hST;
    private Context mContext;

    class a {
        public TextView hSN = null;
        public MaxGridView hSO = null;
        public l hSU = null;
        final /* synthetic */ k hSV;

        a(k kVar) {
            this.hSV = kVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return oe(i);
    }

    public k(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.hST != null ? this.hST.size() : 0;
    }

    private n oe(int i) {
        return (n) this.hST.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        n oe = oe(i);
        if (view == null || view.getTag() == null) {
            a aVar2 = new a(this);
            view = View.inflate(this.mContext, 2130904192, null);
            aVar2.hSN = (TextView) view.findViewById(2131758627);
            aVar2.hSO = (MaxGridView) view.findViewById(2131758628);
            aVar2.hSU = new l(this.mContext);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hSN.setText(oe.name);
        aVar.hSO.setOnItemClickListener(this.hSM);
        aVar.hSU.hSW = oe.hQN;
        aVar.hSU.notifyDataSetChanged();
        aVar.hSO.setAdapter(aVar.hSU);
        return view;
    }
}
