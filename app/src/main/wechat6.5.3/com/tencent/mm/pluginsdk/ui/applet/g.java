package com.tencent.mm.pluginsdk.ui.applet;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.a.b;
import java.util.List;

public final class g extends BaseAdapter {
    private List<String> dum;
    private List<String> lKK;
    private Context mContext;

    private static class a {
        public ImageView dtX;
        public TextView eVA;

        private a() {
        }
    }

    public g(Context context, List<String> list, List<String> list2) {
        this.mContext = context;
        this.dum = list2;
        this.lKK = list;
    }

    public final int getCount() {
        return this.dum.size();
    }

    public final Object getItem(int i) {
        return this.dum.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a ct;
        if (view == null) {
            view = View.inflate(this.mContext, 2130903274, null);
            ct = ct(view);
        } else {
            a aVar = (a) view.getTag();
            if (aVar == null) {
                ct = ct(view);
            } else {
                ct = aVar;
            }
        }
        int size = this.dum.size() % 4;
        if (i >= 0 && i < this.dum.size() && i < this.lKK.size()) {
            ct.dtX.setVisibility(0);
            ct.eVA.setVisibility(0);
            b.m(ct.dtX, (String) this.lKK.get(i));
            ct.eVA.setText((CharSequence) this.dum.get(i));
            ct.eVA.setText(com.tencent.mm.bf.g.buU().c(this.mContext, (CharSequence) this.dum.get(i), ct.eVA.getTextSize()));
            if (this.dum.size() <= 12 || i < this.dum.size() - size) {
                ct.eVA.setPadding(0, 0, 0, 0);
            } else {
                ct.eVA.setPadding(0, 0, 0, com.tencent.mm.bd.a.N(this.mContext, 2131493017));
            }
        }
        return view;
    }

    private static a ct(View view) {
        a aVar = new a();
        aVar.dtX = (ImageView) view.findViewById(2131756024);
        aVar.eVA = (TextView) view.findViewById(2131756025);
        view.setTag(aVar);
        return aVar;
    }
}
