package com.tencent.mm.plugin.luckymoney.ui;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.plugin.luckymoney.c.m;
import com.tencent.mm.plugin.luckymoney.c.n;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.wallet_core.ui.e;
import java.util.LinkedList;
import java.util.List;

public final class i extends BaseAdapter {
    private LayoutInflater CE;
    private List<m> hen = new LinkedList();
    String hhq;
    boolean hhr;
    OnClickListener hhs;
    int hht = 1;
    b hhu = null;
    private Context mContext;

    interface b {
        void a(c cVar, Context context);
    }

    class c {
        ImageView eXC;
        View eYV;
        TextView hea;
        TextView hfA;
        TextView hfz;
        final /* synthetic */ i hhv;
        TextView hhw;
        TextView hhx;
        ImageView hhy;
        TextView hhz;

        c(i iVar) {
            this.hhv = iVar;
        }
    }

    final class a implements b {
        final /* synthetic */ i hhv;

        a(i iVar) {
            this.hhv = iVar;
        }

        public final void a(c cVar, Context context) {
            int color = context.getResources().getColor(2131689836);
            int color2 = context.getResources().getColor(2131689837);
            int color3 = context.getResources().getColor(2131689847);
            cVar.eYV.setBackgroundResource(2131690078);
            cVar.eYV.setPadding(0, context.getResources().getDimensionPixelOffset(2131493152), 0, context.getResources().getDimensionPixelOffset(2131493152));
            cVar.hfz.setTextColor(color);
            cVar.hfA.setTextColor(color2);
            cVar.hea.setTextColor(color);
            cVar.hhw.setTextColor(color);
            cVar.hhx.setTextColor(color3);
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return mK(i);
    }

    public i(Context context) {
        this.mContext = context;
        this.CE = LayoutInflater.from(context);
    }

    public final void aJ(List<m> list) {
        if (list == null) {
            LinkedList linkedList = new LinkedList();
        } else {
            this.hen = list;
        }
        notifyDataSetChanged();
    }

    public final int getCount() {
        return this.hen.size();
    }

    private m mK(int i) {
        return (m) this.hen.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        c cVar;
        if (view == null) {
            view = this.CE.inflate(2130903901, viewGroup, false);
            c cVar2 = new c(this);
            cVar2.eYV = view.findViewById(2131755452);
            cVar2.eXC = (ImageView) view.findViewById(2131757930);
            cVar2.hfz = (TextView) view.findViewById(2131757931);
            cVar2.hfA = (TextView) view.findViewById(2131757934);
            cVar2.hea = (TextView) view.findViewById(2131757935);
            cVar2.hhw = (TextView) view.findViewById(2131757932);
            cVar2.hhx = (TextView) view.findViewById(2131757933);
            cVar2.hhy = (ImageView) view.findViewById(2131757936);
            cVar2.hhz = (TextView) view.findViewById(2131757937);
            if (this.hhu != null) {
                this.hhu.a(cVar2, this.mContext);
            }
            view.setTag(cVar2);
            cVar = cVar2;
        } else {
            cVar = (c) view.getTag();
        }
        m mK = mK(i);
        n.h(cVar.eXC, mK.hbv);
        if (be.ma(mK.haI).equals(this.hhq) && this.hhr) {
            cVar.hhx.setOnClickListener(this.hhs);
            cVar.hhx.setVisibility(0);
            cVar.hhw.setVisibility(8);
            cVar.hfA.setVisibility(8);
        } else {
            if (be.kS(mK.hbw)) {
                cVar.hhw.setVisibility(8);
            } else {
                n.a(this.mContext, cVar.hhw, mK.hbw);
                cVar.hhw.setVisibility(0);
            }
            cVar.hfA.setText(n.h(this.mContext, be.getLong(mK.hbi, 0) * 1000));
            cVar.hfA.setVisibility(0);
            cVar.hhx.setVisibility(8);
        }
        n.a(this.mContext, cVar.hfz, mK.hbu);
        cVar.hea.setText(this.mContext.getString(2131233647, new Object[]{e.m(((double) mK.hbh) / 100.0d)}));
        if (be.kS(mK.hbx)) {
            cVar.hhy.setVisibility(8);
            cVar.hhz.setVisibility(8);
        } else {
            cVar.hhz.setText(mK.hbx);
            if (this.hht == 2) {
                cVar.hhy.setImageResource(2130838538);
            } else {
                cVar.hhy.setImageResource(2130838524);
            }
            cVar.hhy.setVisibility(0);
            cVar.hhz.setVisibility(0);
        }
        return view;
    }
}
