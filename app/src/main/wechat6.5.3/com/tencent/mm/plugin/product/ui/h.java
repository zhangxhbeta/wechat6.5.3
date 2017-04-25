package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filter.FilterResults;
import android.widget.Filterable;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public final class h extends BaseAdapter implements Filterable {
    private List<String> hQu = null;
    private List<String> hSn = null;
    Filter hSo = new Filter(this) {
        final /* synthetic */ h hSp;

        {
            this.hSp = r1;
        }

        protected final synchronized void publishResults(CharSequence charSequence, FilterResults filterResults) {
            this.hSp.hQu = (List) filterResults.values;
            this.hSp.notifyDataSetChanged();
        }

        protected final FilterResults performFiltering(CharSequence charSequence) {
            FilterResults filterResults = new FilterResults();
            ArrayList arrayList = new ArrayList();
            for (String str : this.hSp.hSn) {
                if (!(str == null || charSequence == null || !str.contains(charSequence))) {
                    arrayList.add(str);
                }
            }
            filterResults.values = arrayList;
            filterResults.count = arrayList.size();
            return filterResults;
        }
    };
    private Context mContext;

    class a {
        TextView hRT;
        final /* synthetic */ h hSp;

        a(h hVar) {
            this.hSp = hVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return hd(i);
    }

    public h(Context context) {
        this.mContext = context;
        this.hSn = com.tencent.mm.plugin.product.a.a.aFW().aFY().hQu;
    }

    public final int getCount() {
        return this.hQu != null ? this.hQu.size() : 0;
    }

    private String hd(int i) {
        return (String) this.hQu.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        if (view == null) {
            a aVar2 = new a(this);
            view = LayoutInflater.from(this.mContext).inflate(17367043, null);
            aVar2.hRT = (TextView) view.findViewById(16908308);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        aVar.hRT.setText(hd(i));
        return view;
    }

    public final Filter getFilter() {
        return this.hSo;
    }
}
