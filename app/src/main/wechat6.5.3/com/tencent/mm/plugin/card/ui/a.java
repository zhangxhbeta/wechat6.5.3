package com.tencent.mm.plugin.card.ui;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.b.k;
import com.tencent.mm.plugin.card.model.CardInfo;
import com.tencent.mm.protocal.c.ld;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public final class a extends BaseAdapter {
    List<CardInfo> eGh = new ArrayList();
    HashMap<String, Integer> eHg = new HashMap();
    Context mContext;

    public class a {
        public RelativeLayout eGW;
        public ImageView eGX;
        public TextView eGY;
        public TextView eGZ;
        public TextView eHa;
        public TextView eHc;
        public LinearLayout eHh;
        public ImageView eHi;
        public TextView eHj;
        public TextView eHk;
        final /* synthetic */ a eHl;

        public a(a aVar) {
            this.eHl = aVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return jc(i);
    }

    public a(Context context) {
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
        a aVar;
        CardInfo jc = jc(i);
        if (view == null) {
            view = View.inflate(this.mContext, 2130903199, null);
            aVar = new a(this);
            aVar.eGW = (RelativeLayout) view.findViewById(2131755711);
            aVar.eHh = (LinearLayout) view.findViewById(2131755712);
            aVar.eGX = (ImageView) view.findViewById(2131755713);
            aVar.eGY = (TextView) view.findViewById(2131755714);
            aVar.eGZ = (TextView) view.findViewById(2131755716);
            aVar.eHa = (TextView) view.findViewById(2131755719);
            aVar.eHc = (TextView) view.findViewById(2131755720);
            aVar.eHi = (ImageView) view.findViewById(2131755715);
            aVar.eHj = (TextView) view.findViewById(2131755717);
            aVar.eHk = (TextView) view.findViewById(2131755718);
            view.setTag(aVar);
        } else {
            aVar = (a) view.getTag();
        }
        if (jc.Zh()) {
            aVar.eGX.setVisibility(0);
            aVar.eGZ.setVisibility(0);
            aVar.eHa.setVisibility(0);
            aVar.eHc.setVisibility(8);
            aVar.eGY.setVisibility(0);
            aVar.eGY.setText(jc.Zv().eCD);
            if (!jc.Ze()) {
                aVar.eGZ.setText(jc.Zv().title);
            } else if (jc.Zv().mkN != null && jc.Zv().mkN.size() == 1) {
                aVar.eGZ.setText(((ld) jc.Zv().mkN.get(0)).title);
            } else if (jc.Zv().mkN != null && jc.Zv().mkN.size() == 2) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append(((ld) jc.Zv().mkN.get(0)).title);
                stringBuilder.append("-");
                stringBuilder.append(((ld) jc.Zv().mkN.get(1)).title);
                aVar.eGZ.setText(stringBuilder.toString());
            }
            if (jc.Zv().mlm == 1) {
                aVar.eHi.setVisibility(0);
            } else {
                aVar.eHi.setVisibility(8);
            }
            long j = jc.field_begin_time;
            if (jc.getEndTime() > 0 && j > 0) {
                aVar.eHa.setText(this.mContext.getString(2131231720, new Object[]{j.ao(j) + "  -  " + j.ao(jc.getEndTime())}));
                aVar.eHa.setVisibility(0);
            } else if (jc.getEndTime() > 0) {
                aVar.eHa.setText(this.mContext.getString(2131231719, new Object[]{j.ao(jc.getEndTime())}));
                aVar.eHa.setVisibility(0);
            } else {
                aVar.eHa.setText("");
                aVar.eHa.setVisibility(8);
            }
            k.a(aVar.eGX, jc.Zv().eBM, this.mContext.getResources().getDimensionPixelSize(2131493362), 2130838736, true);
            if (jc.Zv().mlk == 1) {
                aVar.eGX.setAlpha(255);
                aVar.eHk.setVisibility(8);
                aVar.eGZ.setTextColor(this.mContext.getResources().getColor(2131689589));
                aVar.eGY.setTextColor(this.mContext.getResources().getColor(2131689589));
                aVar.eHa.setTextColor(this.mContext.getResources().getColor(2131689769));
            } else {
                aVar.eHk.setText(jc.Zv().mll);
                aVar.eGX.setAlpha(90);
                aVar.eHk.setVisibility(0);
                aVar.eGZ.setTextColor(this.mContext.getResources().getColor(2131689769));
                aVar.eGY.setTextColor(this.mContext.getResources().getColor(2131689769));
                aVar.eHa.setTextColor(this.mContext.getResources().getColor(2131689769));
            }
            int intValue = ((Integer) this.eHg.get(jc.ZA())).intValue();
            if (intValue == 1) {
                aVar.eHj.setText("");
                aVar.eHj.setVisibility(8);
            } else {
                aVar.eHj.setText("x" + intValue);
                aVar.eHj.setVisibility(0);
            }
        } else {
            aVar.eGX.setVisibility(8);
            aVar.eGZ.setVisibility(8);
            aVar.eGY.setVisibility(8);
            aVar.eHa.setVisibility(8);
            aVar.eHk.setVisibility(8);
            aVar.eHj.setVisibility(8);
            aVar.eHc.setVisibility(0);
            aVar.eGW.setBackgroundColor(this.mContext.getResources().getColor(2131689599));
            aVar.eHc.setText(this.mContext.getResources().getString(2131231661));
        }
        return view;
    }
}
