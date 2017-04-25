package com.tencent.mm.plugin.sns.lucky.view;

import android.content.Context;
import android.os.CountDownTimer;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.v;

public class SnsLuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> hdy;
    private int dTd;
    private long hdt;
    public int hdu;
    CountDownTimer hdv;
    private int hdw;
    private a jis;
    public b jit;
    private Context mContext;

    private class a extends BaseAdapter {
        final /* synthetic */ SnsLuckyMoneyAutoScrollItem jiu;

        class a {
            ImageView hdC;
            final /* synthetic */ a jiw;

            a(a aVar) {
                this.jiw = aVar;
            }
        }

        private a(SnsLuckyMoneyAutoScrollItem snsLuckyMoneyAutoScrollItem) {
            this.jiu = snsLuckyMoneyAutoScrollItem;
        }

        public final int getCount() {
            return 2147483646;
        }

        public final Object getItem(int i) {
            return Integer.valueOf(i % 10);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            a aVar;
            if (view == null || view.getTag() == null) {
                view = LayoutInflater.from(this.jiu.mContext).inflate(2130904461, null);
                a aVar2 = new a(this);
                aVar2.hdC = (ImageView) view.findViewById(2131757755);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hdC.setImageResource(((Integer) SnsLuckyMoneyAutoScrollItem.hdy.get(i % 10)).intValue());
            return view;
        }
    }

    interface b {
        void ayd();
    }

    static /* synthetic */ int a(SnsLuckyMoneyAutoScrollItem snsLuckyMoneyAutoScrollItem) {
        int i = snsLuckyMoneyAutoScrollItem.dTd + 1;
        snsLuckyMoneyAutoScrollItem.dTd = i;
        return i;
    }

    static {
        SparseArray sparseArray = new SparseArray();
        hdy = sparseArray;
        sparseArray.put(0, Integer.valueOf(2130838779));
        hdy.put(1, Integer.valueOf(2130838780));
        hdy.put(2, Integer.valueOf(2130838781));
        hdy.put(3, Integer.valueOf(2130838782));
        hdy.put(4, Integer.valueOf(2130838783));
        hdy.put(5, Integer.valueOf(2130838784));
        hdy.put(6, Integer.valueOf(2130838785));
        hdy.put(7, Integer.valueOf(2130838786));
        hdy.put(8, Integer.valueOf(2130838787));
        hdy.put(9, Integer.valueOf(2130838788));
    }

    public SnsLuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.jis = null;
        this.hdt = 900;
        this.hdu = 0;
        this.dTd = 0;
        this.jit = null;
        this.mContext = context;
        this.jis = new a();
        setAdapter(this.jis);
        this.hdw = (int) ((this.mContext.getResources().getDisplayMetrics().density * 44.0f) + 0.5f);
        v.i("MicroMsg.SnsLuckyMoneyAutoScrollItem", "hy: scroll height is: %d", new Object[]{Integer.valueOf(this.hdw)});
    }

    public SnsLuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }
}
