package com.tencent.mm.plugin.aa.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.l;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.protocal.c.k;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.q;
import java.util.ArrayList;
import java.util.List;

public final class b extends BaseAdapter {
    private Context context;
    List<k> dataList = new ArrayList();

    private class a {
        public TextView dtA;
        public TextView dtB;
        public TextView dtC;
        public TextView dtD;
        public TextView dtE;
        final /* synthetic */ b dtF;
        public ImageView dtz;

        public a(b bVar, View view) {
            this.dtF = bVar;
            this.dtz = (ImageView) view.findViewById(2131755197);
            this.dtA = (TextView) view.findViewById(2131755199);
            this.dtB = (TextView) view.findViewById(2131755200);
            this.dtC = (TextView) view.findViewById(2131755201);
            this.dtD = (TextView) view.findViewById(2131755202);
            this.dtE = (TextView) view.findViewById(2131755203);
        }
    }

    public b(Context context) {
        this.context = context;
    }

    public final int getCount() {
        return this.dataList.size();
    }

    public final Object getItem(int i) {
        return this.dataList.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = q.em(this.context).inflate(2130903041, viewGroup, false);
            view.setTag(new a(this, view));
        }
        a aVar = (a) view.getTag();
        k kVar = (k) getItem(i);
        aVar.dtz.setImageResource(2131165184);
        com.tencent.mm.pluginsdk.ui.a.b.d(aVar.dtz, kVar.lYx, 2131165184);
        aVar.dtB.setText(e.a(this.context, kVar.title, aVar.dtB.getTextSize()));
        CharSequence er = l.er(kVar.lYx);
        if (be.kS(er) || er.endsWith("@chatroom")) {
            er = this.context.getString(2131231879);
        }
        aVar.dtA.setText(e.a(this.context, er, aVar.dtA.getTextSize()));
        aVar.dtC.setText(kVar.lYF);
        aVar.dtD.setText(String.format("%s%s", new Object[]{Float.valueOf(((float) kVar.bst) / 100.0f), this.context.getString(2131230786)}));
        aVar.dtE.setVisibility(0);
        switch (kVar.state) {
            case 1:
                aVar.dtE.setText(2131230767);
                aVar.dtE.setTextColor(this.context.getResources().getColor(2131689486));
                break;
            case 2:
                aVar.dtE.setText(2131230766);
                aVar.dtE.setTextColor(this.context.getResources().getColor(2131689486));
                break;
            case 3:
                aVar.dtE.setText(2131230764);
                aVar.dtE.setTextColor(this.context.getResources().getColor(2131689960));
                break;
            case 4:
                aVar.dtE.setText(2131230765);
                aVar.dtE.setTextColor(this.context.getResources().getColor(2131689960));
                break;
            default:
                aVar.dtE.setVisibility(4);
                break;
        }
        return view;
    }
}
