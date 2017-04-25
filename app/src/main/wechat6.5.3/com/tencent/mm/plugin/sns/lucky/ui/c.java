package com.tencent.mm.plugin.sns.lucky.ui;

import android.content.Context;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.model.ak;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.pluginsdk.j.n;
import com.tencent.mm.pluginsdk.ui.a.b;
import com.tencent.mm.protocal.c.acc;
import com.tencent.mm.protocal.c.avx;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.u;
import com.tencent.mm.wallet_core.ui.e;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedList;
import java.util.List;

public final class c extends BaseAdapter {
    private LayoutInflater CE;
    private final String TAG = "SnsLuckyMoneyReceivedRecordListAdapter";
    List<avx> hen = new LinkedList();
    private int hht = 1;
    private Context mContext;

    class a {
        ImageView eXC;
        TextView hea;
        TextView hfA;
        TextView hfz;
        TextView hhz;
        final /* synthetic */ c jgT;

        a(c cVar) {
            this.jgT = cVar;
        }
    }

    public final /* synthetic */ Object getItem(int i) {
        return pW(i);
    }

    public c(Context context) {
        this.mContext = context;
        this.CE = LayoutInflater.from(context);
    }

    public final int getCount() {
        return this.hen.size();
    }

    private avx pW(int i) {
        return (avx) this.hen.get(i);
    }

    public final long getItemId(int i) {
        return 0;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        a aVar;
        CharSequence charSequence;
        if (view == null) {
            view = this.CE.inflate(2130904466, viewGroup, false);
            a aVar2 = new a(this);
            aVar2.eXC = (ImageView) view.findViewById(2131757930);
            aVar2.hfz = (TextView) view.findViewById(2131757931);
            aVar2.hfA = (TextView) view.findViewById(2131757934);
            aVar2.hea = (TextView) view.findViewById(2131757935);
            aVar2.hhz = (TextView) view.findViewById(2131757937);
            view.setTag(aVar2);
            aVar = aVar2;
        } else {
            aVar = (a) view.getTag();
        }
        avx pW = pW(i);
        ak.yW();
        u LX = com.tencent.mm.model.c.wH().LX(pW.mdw);
        if (pW.mdw != null) {
            b.o(aVar.eXC, pW.mdw);
        } else {
            v.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{pW.mdw});
        }
        TextView textView = aVar.hfA;
        Context context = this.mContext;
        long j = ((long) pW.hNS) * 1000;
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        if (j < 3600000) {
            charSequence = "";
        } else {
            long timeInMillis = j - new GregorianCalendar(gregorianCalendar.get(1), gregorianCalendar.get(2), gregorianCalendar.get(5)).getTimeInMillis();
            if (timeInMillis <= 0 || timeInMillis > 86400000) {
                Time time = new Time();
                time.set(j);
                charSequence = n.a(context.getString(2131232868, new Object[]{" "}), time).toString();
            } else {
                charSequence = new SimpleDateFormat("HH:mm").format(new Date(j));
            }
        }
        textView.setText(charSequence);
        aVar.hfA.setVisibility(0);
        if (LX != null) {
            com.tencent.mm.plugin.luckymoney.c.n.a(this.mContext, aVar.hfz, LX.tU());
        } else {
            v.e("SnsLuckyMoneyReceivedRecordListAdapter", "the contact is null,by username:%s", new Object[]{pW.mdw});
        }
        acc com_tencent_mm_protocal_c_acc = new acc();
        try {
            if (pW.mSR == null || pW.mSR.mQu <= 0) {
                aVar.hea.setVisibility(8);
                aVar.hhz.setVisibility(0);
                return view;
            }
            com_tencent_mm_protocal_c_acc.az(m.a(pW.mSR));
            if (com_tencent_mm_protocal_c_acc.bst > 0) {
                aVar.hea.setText(this.mContext.getString(2131233647, new Object[]{e.m(((double) com_tencent_mm_protocal_c_acc.bst) / 100.0d)}));
                aVar.hhz.setVisibility(8);
            } else {
                aVar.hea.setVisibility(8);
                aVar.hhz.setVisibility(0);
            }
            return view;
        } catch (Exception e) {
            v.e("SnsLuckyMoneyReceivedRecordListAdapter", e.getMessage() + "hbBuffer is error");
            aVar.hea.setVisibility(8);
            aVar.hhz.setVisibility(8);
            aVar.eXC.setVisibility(8);
            aVar.hfz.setVisibility(8);
            aVar.hfA.setVisibility(8);
        }
    }
}
