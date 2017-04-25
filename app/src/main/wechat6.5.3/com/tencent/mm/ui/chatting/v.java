package com.tencent.mm.ui.chatting;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.text.TextPaint;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.e;
import com.tencent.mm.ui.base.MMListPopupWindow;
import java.util.List;

public final class v implements OnKeyListener, OnItemClickListener, OnDismissListener {
    private LayoutInflater CE;
    private int height;
    private Context mContext = null;
    private int mCount;
    OnItemClickListener olZ = null;
    private ViewGroup oma = null;
    private b omb = null;
    private MMListPopupWindow omc;
    private int omd = 2131559111;
    private int ome;
    com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a omf = null;
    private boolean omg = true;

    public static class a {
        private static DisplayMetrics omh = null;

        public static class a {
            public int omi;
            public int omj;

            public final String toString() {
                return " marginLeft:" + this.omi + " marginRight:" + this.omj;
            }
        }

        public static a a(Context context, TextPaint textPaint, List<com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a> list, int i) {
            a aVar = new a();
            if (omh == null) {
                omh = context.getResources().getDisplayMetrics();
            }
            DisplayMetrics displayMetrics = omh;
            float f = 0.0f;
            for (com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar2 : list) {
                float measureText = textPaint.measureText(aVar2.name);
                if (f >= measureText) {
                    measureText = f;
                }
                f = measureText;
            }
            int fromDPToPix = (com.tencent.mm.bd.a.fromDPToPix(context, 30) * 2) + ((int) f);
            int fromDPToPix2 = com.tencent.mm.bd.a.fromDPToPix(context, 95);
            if (fromDPToPix >= fromDPToPix2) {
                fromDPToPix2 = fromDPToPix;
            }
            if (i - (fromDPToPix2 / 2) < 0) {
                aVar.omi = 0;
                aVar.omj = displayMetrics.widthPixels - (fromDPToPix2 + 0);
            } else if (displayMetrics.widthPixels - ((fromDPToPix2 / 2) + i) < 0) {
                aVar.omi = displayMetrics.widthPixels - (fromDPToPix2 + 0);
                aVar.omj = 0;
            } else {
                aVar.omi = i - (fromDPToPix2 / 2);
                aVar.omj = displayMetrics.widthPixels - ((fromDPToPix2 / 2) + i);
            }
            return aVar;
        }
    }

    private class b extends BaseAdapter {
        final /* synthetic */ v omk;

        private b(v vVar) {
            this.omk = vVar;
        }

        public final /* synthetic */ Object getItem(int i) {
            return wW(i);
        }

        public final int getCount() {
            return this.omk.mCount;
        }

        private com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a wW(int i) {
            return (com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a) this.omk.omf.cCk.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View view2;
            if (view == null) {
                view2 = (TextView) this.omk.CE.inflate(2130903288, viewGroup, false);
            } else {
                view2 = (TextView) view;
            }
            com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a wW = wW(i);
            view2.setTag(wW);
            view2.setText(e.a(this.omk.mContext, wW.name));
            return view2;
        }
    }

    public v(Context context, ViewGroup viewGroup) {
        this.mContext = context;
        this.oma = viewGroup;
        this.CE = (LayoutInflater) context.getSystemService("layout_inflater");
        bEd();
        this.omb = new b();
    }

    @SuppressLint({"WrongCall"})
    public final boolean a(com.tencent.mm.modelbiz.BizInfo.ExtInfo.b.a aVar, int i, int i2, boolean z) {
        if (isShowing() || aVar == null || aVar.cCk == null || aVar.cCk.size() <= 0) {
            return false;
        }
        if (this.omf == null || this.omf.id != aVar.id || !this.omf.apU.equals(aVar.apU) || this.omg) {
            this.omg = false;
            this.omf = aVar;
            this.mCount = aVar.cCk.size();
            this.omb.notifyDataSetChanged();
        }
        this.height = ((WindowManager) this.mContext.getSystemService("window")).getDefaultDisplay().getHeight();
        a a = a.a(this.mContext, ((TextView) ((LayoutInflater) this.mContext.getSystemService("layout_inflater")).inflate(2130903288, null)).getPaint(), aVar.cCk, i);
        this.ome = (i2 - (this.omb.getCount() * this.mContext.getResources().getDimensionPixelSize(2131493198))) - this.mContext.getResources().getDimensionPixelSize(2131493078);
        new StringBuilder("showPointY=").append(i2).append("verticalOffset=").append(this.ome);
        this.omc = new MMListPopupWindow(this.mContext, null, 0);
        this.omc.setOnDismissListener(this);
        this.omc.Xp = this.olZ;
        this.omc.setAdapter(this.omb);
        this.omc.fi();
        this.omc.setBackgroundDrawable(this.mContext.getResources().getDrawable(2130839257));
        this.omc.setAnimationStyle(this.omd);
        this.omc.Xd = a.omj;
        this.omc.setVerticalOffset(this.ome);
        this.omc.Xn = this.oma;
        this.omc.setContentWidth(b(this.omb));
        this.omc.fj();
        this.omc.show();
        this.omc.nWt.setOnKeyListener(this);
        this.omc.nWt.setDivider(new ColorDrawable(this.mContext.getResources().getColor(2131690016)));
        this.omc.nWt.setSelector(this.mContext.getResources().getDrawable(2130837991));
        this.omc.nWt.setDividerHeight(1);
        this.omc.nWt.setVerticalScrollBarEnabled(false);
        this.omc.nWt.setHorizontalScrollBarEnabled(false);
        return true;
    }

    public final boolean isShowing() {
        return this.omc != null && this.omc.eLp.isShowing();
    }

    public final boolean bEd() {
        if (!isShowing()) {
            return false;
        }
        this.omc.dismiss();
        return true;
    }

    private int b(ListAdapter listAdapter) {
        int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
        int count = listAdapter.getCount();
        int i = 0;
        int i2 = 0;
        View view = null;
        int i3 = 0;
        while (i < count) {
            View view2;
            int itemViewType = listAdapter.getItemViewType(i);
            if (itemViewType != i2) {
                view2 = null;
            } else {
                itemViewType = i2;
                view2 = view;
            }
            if (this.oma == null) {
                this.oma = new FrameLayout(this.mContext);
            }
            view = listAdapter.getView(i, view2, this.oma);
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i3 = Math.max(i3, view.getMeasuredWidth());
            i++;
            i2 = itemViewType;
        }
        return i3;
    }

    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        return false;
    }

    public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
    }

    public final void onDismiss() {
    }
}
