package com.tencent.mm.plugin.product.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.platformtools.j;
import com.tencent.mm.plugin.product.b.n.a;
import java.util.List;

public final class l extends BaseAdapter {
    List<a> hSW;
    private Context mContext;

    public final /* synthetic */ Object getItem(int i) {
        return of(i);
    }

    public l(Context context) {
        this.mContext = context;
    }

    public final int getCount() {
        return this.hSW != null ? this.hSW.size() : 0;
    }

    private a of(int i) {
        return (a) this.hSW.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        m mVar;
        a of = of(i);
        if (view == null || view.getTag() == null) {
            m mVar2 = new m();
            view = View.inflate(this.mContext, 2130904191, null);
            mVar2.dtB = (TextView) view.findViewById(2131758626);
            mVar2.hEP = (ImageView) view.findViewById(2131758625);
            view.setTag(mVar2);
            mVar = mVar2;
        } else {
            mVar = (m) view.getTag();
        }
        mVar.hSX = of;
        mVar.dtB.setText(of.title);
        mVar.hEP.setImageBitmap(j.a(new c(of.iconUrl)));
        j.a(mVar);
        return view;
    }
}
