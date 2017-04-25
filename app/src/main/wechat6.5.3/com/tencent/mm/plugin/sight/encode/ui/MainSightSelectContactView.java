package com.tencent.mm.plugin.sight.encode.ui;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AbsListView.LayoutParams;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import com.tencent.mm.e.b.ab;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.model.k;
import com.tencent.mm.plugin.sight.encode.ui.d.a;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMFragmentActivity;
import com.tencent.mm.ui.contact.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class MainSightSelectContactView extends FrameLayout implements OnScrollListener, a, l {
    private ListView Eq;
    private MMFragmentActivity iYA;
    private Animation iYH;
    private boolean iYx = false;
    private int iZk;
    d iZl;
    private c iZm;
    public View iZn;
    public a iZo;
    private LinearLayout iZp;
    private View iZq;
    private int iZr = -1;
    private int iZs = -1;
    private HashSet<String> iZt;
    private HashSet<String> iZu;

    public MainSightSelectContactView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public MainSightSelectContactView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public final void a(MMFragmentActivity mMFragmentActivity, int i, OnItemClickListener onItemClickListener, a aVar) {
        this.iYA = mMFragmentActivity;
        this.iZk = i;
        this.iZo = aVar;
        addView(View.inflate(getContext(), 2130903919, null), -1, -2);
        this.Eq = (ListView) findViewById(2131755207);
        this.iZm = new c(this);
        this.iZp = new LinearLayout(getContext());
        this.iZp.addView(new View(getContext()), -1, this.iZo.aQc() - this.iZk);
        this.iZp.getChildAt(0).setBackgroundColor(0);
        this.Eq.addHeaderView(this.iZp);
        this.Eq.setAdapter(this.iZm);
        this.Eq.setOnItemClickListener(onItemClickListener);
        this.iZt = new HashSet();
        this.iZu = new HashSet();
        this.Eq.setOnScrollListener(this);
        this.iZl = new d();
        this.iZl.iZg = this;
    }

    public final void bZ(View view) {
        Object obj = this.iZl;
        obj.iZc = view;
        obj.iZa = (EditText) view.findViewById(2131755280);
        obj.iZb = (TextView) view.findViewById(2131758002);
        obj.iZa.setOnFocusChangeListener(obj);
        obj.iZa.addTextChangedListener(obj);
        obj.iZb.setOnClickListener(obj);
        obj.iZe = (InputMethodManager) view.getContext().getSystemService("input_method");
    }

    public final void aQp() {
        if (this.iZp != null) {
            this.iZp.getChildAt(0).setVisibility(0);
            this.iZn.setVisibility(8);
            r(true, false);
            this.iZo.aQd();
        }
    }

    public final void aQo() {
        if (this.iZp != null) {
            this.iZp.getChildAt(0).setVisibility(8);
            this.iZn.setVisibility(0);
            List list = this.iZm.iYT;
            list.remove("@search.tencent");
            list.remove("@sns.tencent");
            list.remove("@draft.tencent");
            b(list, false, true);
            this.iZo.aQe();
            if (!this.iZo.tM()) {
                this.iZo.aQf();
            }
            this.iZo.aQg();
        }
    }

    public final void aQq() {
        this.Eq.post(new Runnable(this) {
            final /* synthetic */ MainSightSelectContactView iZv;

            {
                this.iZv = r1;
            }

            public final void run() {
                if (this.iZv.iZr != this.iZv.iZm.getCount() || this.iZv.iZo.aQc() < this.iZv.iZs) {
                    if (this.iZv.iZq != null) {
                        this.iZv.Eq.removeFooterView(this.iZv.iZq);
                    }
                    int d = this.iZv.iZs;
                    if (this.iZv.iZs < 0 || this.iZv.iZs > this.iZv.iZo.aQc()) {
                        d = this.iZv.iZo.aQc();
                    }
                    this.iZv.iZr = this.iZv.iZm.getCount();
                    this.iZv.iZs = d;
                    int i = 0;
                    int i2 = 0;
                    while (i < this.iZv.iZm.getCount()) {
                        View view = this.iZv.iZm.getView(i, null, this.iZv.Eq);
                        view.measure(MeasureSpec.makeMeasureSpec(0, 0), MeasureSpec.makeMeasureSpec(0, 0));
                        i2 += view.getMeasuredHeight();
                        if (i2 < d) {
                            i++;
                        } else {
                            return;
                        }
                    }
                    d -= i2;
                    if (d > 0) {
                        this.iZv.iZq = new View(this.iZv.getContext());
                        this.iZv.iZq.setLayoutParams(new LayoutParams(-1, d));
                        this.iZv.iZq.setBackgroundResource(2131689547);
                        this.iZv.Eq.addFooterView(this.iZv.iZq);
                    }
                }
            }
        });
    }

    public final void show() {
        this.iYx = false;
        this.Eq.clearAnimation();
        this.Eq.clearFocus();
        this.Eq.setAdapter(this.iZm);
        r(false, true);
        setVisibility(0);
        if (this.iYH == null) {
            this.iYH = new TranslateAnimation(0.0f, 0.0f, (float) this.iZk, 0.0f);
            this.iYH.setDuration(300);
        }
        this.Eq.startAnimation(this.iYH);
    }

    private void b(List<String> list, boolean z, boolean z2) {
        if (!this.iYx && list != null) {
            if (z) {
                this.iZu.clear();
                this.iZt.clear();
                c.iYV = true;
                c.iYW = false;
            }
            if (this.iZm != null) {
                c cVar = this.iZm;
                cVar.clearCache();
                cVar.iYT = list;
                cVar.notifyDataSetChanged();
            }
            if (z2) {
                aQq();
            } else if (this.iZq != null) {
                this.Eq.removeFooterView(this.iZq);
            }
        }
    }

    private void r(boolean z, boolean z2) {
        List arrayList = new ArrayList();
        arrayList.add("@search.tencent");
        arrayList.add("@sns.tencent");
        if (this.iZo.aQh()) {
            arrayList.add("@draft.tencent");
        }
        Collection<String> arrayList2 = new ArrayList();
        ak.yW();
        Collection bvJ = c.wK().bvJ();
        bvJ.remove(k.xF());
        arrayList2.addAll(bvJ);
        if (z) {
            arrayList.addAll(this.iZu);
            for (String str : arrayList2) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        } else {
            arrayList.addAll(arrayList2);
        }
        b(arrayList, z2, true);
    }

    public final void dismiss() {
        this.iYx = true;
        be.cw(this);
        this.iZl.aQn();
        this.iZu.clear();
        this.iZt.clear();
        this.Eq.setAdapter(null);
        this.Eq.clearAnimation();
        setVisibility(8);
    }

    public final Activity getActivity() {
        return this.iYA;
    }

    public final boolean b(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.iZt.contains(aVar.euW.field_username);
    }

    public final boolean a(com.tencent.mm.ui.contact.a.a aVar) {
        if (!aVar.oHa || aVar.euW == null) {
            return false;
        }
        return this.iZu.contains(aVar.euW.field_username);
    }

    public final ListView aQr() {
        return this.Eq;
    }

    public final void pG(int i) {
        if (i >= 0 && i <= this.iZm.getCount()) {
            com.tencent.mm.ui.contact.a.a xS = this.iZm.xS(i);
            if (xS != null) {
                if (this.iZu.contains(xS.euW.field_username)) {
                    this.iZu.remove(xS.euW.field_username);
                } else {
                    this.iZu.add(xS.euW.field_username);
                }
                c.iYV = this.iZu.isEmpty();
                c.iYW = !this.iZu.isEmpty();
            }
        }
    }

    public final LinkedList<String> aQs() {
        LinkedList<String> linkedList = new LinkedList();
        linkedList.addAll(this.iZu);
        return linkedList;
    }

    public final boolean aQt() {
        return this.iZu == null ? true : this.iZu.isEmpty();
    }

    public final void notifyDataSetChanged() {
        if (this.iZm != null) {
            this.iZm.notifyDataSetChanged();
        }
    }

    final String fo(int i) {
        com.tencent.mm.ui.contact.a.a xS = this.iZm.xS(i);
        if (xS == null) {
            return null;
        }
        ab abVar = xS.euW;
        if (abVar != null) {
            return abVar.field_username;
        }
        return null;
    }

    public final boolean pH(int i) {
        return c.zG(fo(i));
    }

    public final boolean pI(int i) {
        return c.zH(fo(i));
    }

    public static boolean pJ(int i) {
        return i == -1;
    }

    public final void bk(List<String> list) {
        b(list, false, false);
    }

    public final boolean pK(int i) {
        if (this.iZm.xS(i) == null || this.iZm.xS(i).euW == null) {
            return false;
        }
        return this.iZu.contains(this.iZm.xS(i).euW.field_username);
    }

    public void onScrollStateChanged(AbsListView absListView, int i) {
        if (i == 1) {
            be.cw(absListView);
        }
    }

    public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        if (this.iZp != null && absListView != null && this.iZp.getHeight() > 0 && this.iYA != null) {
            int height = this.iZp.getHeight() - this.iYA.cU().cV().getHeight();
            int i4 = -this.iZp.getTop();
            if (i4 >= 0) {
                this.iZo.X(((float) i4) / ((float) height));
                boolean z = this.iZp.getTop() < 0 && this.iZp.getTop() <= (-height);
                this.iZo.fI(z);
            }
        }
    }
}
