package com.tencent.mm.plugin.sns.ui;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.k;
import com.tencent.mm.ui.base.l;
import com.tencent.mm.ui.base.m;
import com.tencent.mm.ui.base.n.c;
import com.tencent.mm.ui.base.n.d;
import java.util.HashMap;

public final class ax implements OnItemClickListener {
    private LayoutInflater CE;
    private k jXm;
    c jXn;
    d jXo;
    private l jXp;
    private a jXq;
    private HashMap<Integer, CharSequence> jXr = new HashMap();
    private HashMap<Integer, Integer> jXs = new HashMap();
    private Context mContext;

    private class a extends BaseAdapter {
        final /* synthetic */ ax jXt;

        private class a {
            TextView dID;
            TextView jXu;
            final /* synthetic */ a jXv;

            private a(a aVar) {
                this.jXv = aVar;
            }
        }

        private a(ax axVar) {
            this.jXt = axVar;
        }

        public final int getCount() {
            return this.jXt.jXp.size();
        }

        public final Object getItem(int i) {
            return null;
        }

        public final long getItemId(int i) {
            return 0;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null) {
                view = this.jXt.CE.inflate(2130904513, viewGroup, false);
                aVar = new a();
                aVar.dID = (TextView) view.findViewById(2131755226);
                aVar.jXu = (TextView) view.findViewById(2131759501);
                view.setTag(aVar);
            } else {
                aVar = (a) view.getTag();
            }
            MenuItem item = this.jXt.jXp.getItem(i);
            aVar.dID.setText(item.getTitle());
            if (this.jXt.jXr.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.jXu.setText((CharSequence) this.jXt.jXr.get(Integer.valueOf(item.getItemId())));
                aVar.jXu.setVisibility(0);
            } else {
                aVar.jXu.setVisibility(4);
            }
            if (this.jXt.jXs.get(Integer.valueOf(item.getItemId())) != null) {
                aVar.jXu.setTextColor(((Integer) this.jXt.jXs.get(Integer.valueOf(item.getItemId()))).intValue());
            }
            return view;
        }
    }

    public ax(Context context) {
        this.mContext = context;
        this.CE = LayoutInflater.from(context);
        this.jXm = new k(context);
        this.jXp = new l();
    }

    public final void b(int i, CharSequence charSequence) {
        this.jXr.put(Integer.valueOf(i), charSequence);
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        m mVar = (m) this.jXp.nWF.get(i);
        if (mVar.performClick()) {
            v.i("MicroMsg.SnsTimelineListMenu", "onItemClick menu item has listener");
            dismiss();
            return;
        }
        if (this.jXo != null) {
            this.jXo.c(mVar, i);
        }
        dismiss();
    }

    private void dismiss() {
        if (this.jXm.isShowing()) {
            this.jXm.dismiss();
        }
    }

    public final Dialog aXZ() {
        if (this.jXn != null) {
            this.jXp.clear();
            this.jXp = new l();
            this.jXn.a(this.jXp);
        }
        if (this.jXp.bCl()) {
            v.w("MicroMsg.SnsTimelineListMenu", "show, menu empty");
            return null;
        }
        if (this.jXq == null) {
            this.jXq = new a();
        }
        this.jXm.eGK = this.jXq;
        this.jXm.lSE = this;
        this.jXm.setTitle(this.jXp.PF);
        this.jXm.show();
        return this.jXm;
    }
}
