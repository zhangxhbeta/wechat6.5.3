package com.tencent.mm.plugin.card.ui;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.base.c;
import com.tencent.mm.plugin.card.model.CardInfo;
import java.util.ArrayList;
import java.util.List;

@SuppressLint({"UseValueOf"})
public final class f extends BaseAdapter {
    private boolean eCz = true;
    c eFW;
    private OnClickListener eFl = new OnClickListener(this) {
        final /* synthetic */ f eKm;

        {
            this.eKm = r1;
        }

        public final void onClick(View view) {
            int intValue = ((Integer) view.getTag()).intValue();
            f fVar = this.eKm;
            if (((Boolean) fVar.eKk.get(intValue)).booleanValue()) {
                fVar.eKk.set(intValue, Boolean.valueOf(false));
            } else {
                fVar.eKk.set(intValue, Boolean.valueOf(true));
            }
            fVar.notifyDataSetChanged();
        }
    };
    List<CardInfo> eGh = new ArrayList();
    private boolean eKj = false;
    List<Boolean> eKk = new ArrayList();
    a eKl;
    Context mContext;

    public interface a {
    }

    public final /* synthetic */ Object getItem(int i) {
        return jc(i);
    }

    public f(Context context) {
        this.eFW = new j(context, this);
        this.mContext = context;
    }

    public final int getCount() {
        return this.eGh.size();
    }

    public final CardInfo jc(int i) {
        return (CardInfo) this.eGh.get(i);
    }

    public final long getItemId(int i) {
        return (long) i;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        b jc = jc(i);
        jc.eCz = this.eCz;
        View a = this.eFW.a(i, view, jc);
        if (this.eKj && jc.Zh()) {
            this.eFW.r(a, 0);
            if (((Boolean) this.eKk.get(i)).booleanValue()) {
                this.eFW.q(a, 2130837830);
            } else {
                this.eFW.q(a, 2130837831);
            }
            this.eFW.a(a, i, this.eFl);
        } else {
            this.eFW.r(a, 8);
        }
        return a;
    }
}
