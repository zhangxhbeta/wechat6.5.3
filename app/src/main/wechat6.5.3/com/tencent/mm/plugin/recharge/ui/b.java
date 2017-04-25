package com.tencent.mm.plugin.recharge.ui;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.tencent.mm.plugin.wallet.a.h;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.q;
import java.util.ArrayList;

public final class b extends BaseAdapter {
    ArrayList<h> ini = null;
    a inj = null;

    public interface a {
        void a(h hVar);
    }

    private class b {
        TextView dyN;
        TextView emb;
        final /* synthetic */ b inl;
        TextView inm;

        private b(b bVar) {
            this.inl = bVar;
        }
    }

    public final int getCount() {
        return this.ini == null ? 0 : this.ini.size();
    }

    public final Object getItem(int i) {
        return this.ini.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b bVar;
        final h hVar = (h) getItem(i);
        if (view == null) {
            view = q.em(viewGroup.getContext()).inflate(2130904252, viewGroup, false);
            b bVar2 = new b();
            bVar2.emb = (TextView) view.findViewById(2131757325);
            bVar2.dyN = (TextView) view.findViewById(2131755096);
            bVar2.inm = (TextView) view.findViewById(2131758832);
            view.setTag(bVar2);
            bVar = bVar2;
        } else {
            bVar = (b) view.getTag();
        }
        bVar.dyN.setText(hVar.name);
        if (be.kS(hVar.desc)) {
            bVar.emb.setVisibility(8);
        } else {
            bVar.emb.setVisibility(0);
            bVar.emb.setText(hVar.desc);
        }
        if (be.kS(hVar.kHS)) {
            bVar.inm.setVisibility(8);
        } else {
            bVar.inm.setVisibility(0);
            bVar.inm.setText(hVar.kHS);
        }
        if (hVar.status == 1) {
            view.setEnabled(true);
            bVar.emb.setEnabled(true);
            bVar.dyN.setEnabled(true);
        } else {
            view.setEnabled(false);
            bVar.emb.setEnabled(false);
            bVar.dyN.setEnabled(false);
        }
        view.setOnClickListener(new OnClickListener(this) {
            final /* synthetic */ b inl;

            public final void onClick(View view) {
                if (this.inl.inj != null) {
                    this.inl.inj.a(hVar);
                }
            }
        });
        return view;
    }
}
