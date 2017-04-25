package com.tencent.mm.plugin.webview.ui.tools.widget.input;

import android.content.Context;
import android.support.v4.view.t;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mm.compatible.util.d;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.CustomViewPager;
import java.lang.ref.SoftReference;

public class WebViewSmileyViewPager extends CustomViewPager {
    private int fmE = 0;
    private int fmF = 0;
    c lse;
    a lss;

    public interface a {
        void blM();
    }

    static class b extends t {
        c lse;
        SparseArray<SoftReference<View>> lst = new SparseArray();
        private boolean lsu = false;

        b() {
        }

        public final int j(Object obj) {
            if (this.lsu) {
                return -2;
            }
            return super.j(obj);
        }

        public final void notifyDataSetChanged() {
            this.lsu = true;
            super.notifyDataSetChanged();
            this.lsu = false;
        }

        public final int getCount() {
            return this.lse.blQ().getPageCount();
        }

        public final boolean a(View view, Object obj) {
            return view == obj;
        }

        public final void a(ViewGroup viewGroup, int i, Object obj) {
            viewGroup.removeView((View) obj);
        }

        public final Object b(ViewGroup viewGroup, int i) {
            View view = null;
            if (this.lst.get(i) != null) {
                view = (View) ((SoftReference) this.lst.get(i)).get();
            }
            if (view == null) {
                Object tn = this.lse.blQ().tn(i);
                if (tn != null) {
                    viewGroup.addView(tn, 0);
                    this.lst.put(i, new SoftReference(tn));
                    return tn;
                }
                v.e("MicroMsg.WebViewSmileyViewPagerAdapter", "contentView == null!");
                return tn;
            }
            if (view.getParent() != null) {
                ((ViewGroup) view.getParent()).removeView(view);
            }
            viewGroup.addView(view, 0);
            return view;
        }
    }

    public WebViewSmileyViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        if (d.dW(9)) {
            setOverScrollMode(2);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.lse != null && (((i > 0 && i3 != i) || (i2 > 0 && i4 != i2)) && ((i2 > 0 && i2 != this.fmE) || (i > 0 && i != this.fmF)))) {
            this.lse.fmc = i2;
            this.lse.fmd = i;
            if (this.lss != null) {
                this.lss.blM();
            }
        }
        if (i2 > 0) {
            this.fmE = i2;
        }
        if (i > 0) {
            this.fmF = i;
        }
    }
}
