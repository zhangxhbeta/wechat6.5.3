package com.tencent.mm.plugin.luckymoney.ui;

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
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;

public class LuckyMoneyAutoScrollItem extends ListView {
    public static SparseArray<Integer> hdy;
    private int dTd;
    private a hds;
    private long hdt;
    int hdu;
    private CountDownTimer hdv;
    private int hdw;
    b hdx;
    private Context mContext;

    private class a extends BaseAdapter {
        final /* synthetic */ LuckyMoneyAutoScrollItem hdA;

        class a {
            ImageView hdC;
            final /* synthetic */ a hdD;

            a(a aVar) {
                this.hdD = aVar;
            }
        }

        private a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
            this.hdA = luckyMoneyAutoScrollItem;
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
                view = LayoutInflater.from(this.hdA.mContext).inflate(2130903881, null);
                a aVar2 = new a(this);
                aVar2.hdC = (ImageView) view.findViewById(2131757755);
                view.setTag(aVar2);
                aVar = aVar2;
            } else {
                aVar = (a) view.getTag();
            }
            aVar.hdC.setImageResource(((Integer) LuckyMoneyAutoScrollItem.hdy.get(i % 10)).intValue());
            return view;
        }
    }

    interface b {
        void ayd();
    }

    static /* synthetic */ int a(LuckyMoneyAutoScrollItem luckyMoneyAutoScrollItem) {
        int i = luckyMoneyAutoScrollItem.dTd + 1;
        luckyMoneyAutoScrollItem.dTd = i;
        return i;
    }

    static {
        SparseArray sparseArray = new SparseArray();
        hdy = sparseArray;
        sparseArray.put(0, Integer.valueOf(2130838768));
        hdy.put(1, Integer.valueOf(2130838769));
        hdy.put(2, Integer.valueOf(2130838770));
        hdy.put(3, Integer.valueOf(2130838771));
        hdy.put(4, Integer.valueOf(2130838772));
        hdy.put(5, Integer.valueOf(2130838773));
        hdy.put(6, Integer.valueOf(2130838774));
        hdy.put(7, Integer.valueOf(2130838775));
        hdy.put(8, Integer.valueOf(2130838776));
        hdy.put(9, Integer.valueOf(2130838777));
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.hds = null;
        this.hdt = 900;
        this.hdu = 0;
        this.dTd = 0;
        this.hdx = null;
        this.mContext = context;
        this.hds = new a();
        setAdapter(this.hds);
        this.hdw = (int) ((this.mContext.getResources().getDisplayMetrics().density * 60.0f) + 0.5f);
        v.i("MicroMsg.LuckyMoneyAutoScrollView", "hy: scroll height is: %d", new Object[]{Integer.valueOf(this.hdw)});
    }

    public LuckyMoneyAutoScrollItem(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, -1);
    }

    public final void ayc() {
        if (this.hdv != null) {
            this.hdv.cancel();
        }
        final long j = ((long) (this.hdu * 50)) + this.hdt;
        ad.o(new Runnable(this) {
            final /* synthetic */ LuckyMoneyAutoScrollItem hdA;

            public final void run() {
                this.hdA.hdv = new CountDownTimer(this, j) {
                    final /* synthetic */ AnonymousClass1 hdB;

                    public final void onTick(long j) {
                        this.hdB.hdA.smoothScrollToPosition(LuckyMoneyAutoScrollItem.a(this.hdB.hdA));
                    }

                    public final void onFinish() {
                        if (this.hdB.hdA.hdx != null) {
                            this.hdB.hdA.hdx.ayd();
                        }
                    }
                }.start();
            }
        });
    }
}
