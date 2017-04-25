package android.support.v7.view.menu;

import android.content.Context;
import android.content.res.Resources;
import android.os.Parcelable;
import android.support.v7.a.a.d;
import android.support.v7.a.a.h;
import android.support.v7.widget.ListPopupWindow;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnKeyListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListAdapter;
import android.widget.PopupWindow.OnDismissListener;
import java.util.ArrayList;

public class k implements l, OnKeyListener, OnGlobalLayoutListener, OnItemClickListener, OnDismissListener {
    static final int Qm = h.JU;
    private final LayoutInflater CE;
    public android.support.v7.view.menu.l.a PS;
    public boolean Pn;
    private final a Qn;
    private final boolean Qo;
    private final int Qp;
    private final int Qq;
    private final int Qr;
    public ListPopupWindow Qs;
    private ViewTreeObserver Qt;
    private ViewGroup Qu;
    private boolean Qv;
    private int Qw;
    public int Qx = 8388613;
    private final f dV;
    public View hy;
    private final Context mContext;

    private class a extends BaseAdapter {
        private int Ps = -1;
        private f Qy;
        final /* synthetic */ k Qz;

        public final /* synthetic */ Object getItem(int i) {
            return av(i);
        }

        public a(k kVar, f fVar) {
            this.Qz = kVar;
            this.Qy = fVar;
            dw();
        }

        public final int getCount() {
            ArrayList dG = this.Qz.Qo ? this.Qy.dG() : this.Qy.dE();
            if (this.Ps < 0) {
                return dG.size();
            }
            return dG.size() - 1;
        }

        public final h av(int i) {
            ArrayList dG = this.Qz.Qo ? this.Qy.dG() : this.Qy.dE();
            if (this.Ps >= 0 && i >= this.Ps) {
                i++;
            }
            return (h) dG.get(i);
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View inflate;
            if (view == null) {
                inflate = this.Qz.CE.inflate(k.Qm, viewGroup, false);
            } else {
                inflate = view;
            }
            android.support.v7.view.menu.m.a aVar = (android.support.v7.view.menu.m.a) inflate;
            if (this.Qz.Pn) {
                ListMenuItemView listMenuItemView = (ListMenuItemView) inflate;
                listMenuItemView.Pn = true;
                listMenuItemView.Pl = true;
            }
            aVar.a(av(i));
            return inflate;
        }

        private void dw() {
            h hVar = this.Qz.dV.PO;
            if (hVar != null) {
                ArrayList dG = this.Qz.dV.dG();
                int size = dG.size();
                for (int i = 0; i < size; i++) {
                    if (((h) dG.get(i)) == hVar) {
                        this.Ps = i;
                        return;
                    }
                }
            }
            this.Ps = -1;
        }

        public final void notifyDataSetChanged() {
            dw();
            super.notifyDataSetChanged();
        }
    }

    private k(Context context, f fVar, View view) {
        this(context, fVar, view, false, android.support.v7.a.a.a.popupMenuStyle);
    }

    public k(Context context, f fVar, View view, boolean z, int i) {
        this(context, fVar, view, z, i, (byte) 0);
    }

    private k(Context context, f fVar, View view, boolean z, int i, byte b) {
        this.Qx = 0;
        this.mContext = context;
        this.CE = LayoutInflater.from(context);
        this.dV = fVar;
        this.Qn = new a(this, this.dV);
        this.Qo = z;
        this.Qq = i;
        this.Qr = 0;
        Resources resources = context.getResources();
        this.Qp = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(d.Ia));
        this.hy = view;
        fVar.a((l) this, context);
    }

    public final boolean dQ() {
        int i = 0;
        this.Qs = new ListPopupWindow(this.mContext, null, this.Qq, this.Qr);
        this.Qs.setOnDismissListener(this);
        this.Qs.Xp = this;
        this.Qs.setAdapter(this.Qn);
        this.Qs.fi();
        View view = this.hy;
        if (view == null) {
            return false;
        }
        boolean z = this.Qt == null;
        this.Qt = view.getViewTreeObserver();
        if (z) {
            this.Qt.addOnGlobalLayoutListener(this);
        }
        this.Qs.Xn = view;
        this.Qs.Qx = this.Qx;
        if (!this.Qv) {
            ListAdapter listAdapter = this.Qn;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = listAdapter.getCount();
            int i2 = 0;
            int i3 = 0;
            View view2 = null;
            while (i2 < count) {
                View view3;
                int itemViewType = listAdapter.getItemViewType(i2);
                if (itemViewType != i3) {
                    i3 = itemViewType;
                    view3 = null;
                } else {
                    view3 = view2;
                }
                if (this.Qu == null) {
                    this.Qu = new FrameLayout(this.mContext);
                }
                view2 = listAdapter.getView(i2, view3, this.Qu);
                view2.measure(makeMeasureSpec, makeMeasureSpec2);
                itemViewType = view2.getMeasuredWidth();
                if (itemViewType >= this.Qp) {
                    i = this.Qp;
                    break;
                }
                if (itemViewType <= i) {
                    itemViewType = i;
                }
                i2++;
                i = itemViewType;
            }
            this.Qw = i;
            this.Qv = true;
        }
        this.Qs.setContentWidth(this.Qw);
        this.Qs.fj();
        this.Qs.show();
        this.Qs.Xb.setOnKeyListener(this);
        return true;
    }

    public final void dismiss() {
        if (isShowing()) {
            this.Qs.dismiss();
        }
    }

    public void onDismiss() {
        this.Qs = null;
        this.dV.close();
        if (this.Qt != null) {
            if (!this.Qt.isAlive()) {
                this.Qt = this.hy.getViewTreeObserver();
            }
            this.Qt.removeGlobalOnLayoutListener(this);
            this.Qt = null;
        }
    }

    public final boolean isShowing() {
        return this.Qs != null && this.Qs.Xa.isShowing();
    }

    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        a aVar = this.Qn;
        aVar.Qy.a(aVar.av(i), null, 0);
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 1 || i != 82) {
            return false;
        }
        dismiss();
        return true;
    }

    public void onGlobalLayout() {
        if (isShowing()) {
            View view = this.hy;
            if (view == null || !view.isShown()) {
                dismiss();
            } else if (isShowing()) {
                this.Qs.show();
            }
        }
    }

    public final void a(Context context, f fVar) {
    }

    public final void f(boolean z) {
        this.Qv = false;
        if (this.Qn != null) {
            this.Qn.notifyDataSetChanged();
        }
    }

    public final boolean a(p pVar) {
        if (pVar.hasVisibleItems()) {
            boolean z;
            k kVar = new k(this.mContext, pVar, this.hy);
            kVar.PS = this.PS;
            int size = pVar.size();
            for (int i = 0; i < size; i++) {
                MenuItem item = pVar.getItem(i);
                if (item.isVisible() && item.getIcon() != null) {
                    z = true;
                    break;
                }
            }
            z = false;
            kVar.Pn = z;
            if (kVar.dQ()) {
                if (this.PS == null) {
                    return true;
                }
                this.PS.d(pVar);
                return true;
            }
        }
        return false;
    }

    public final void a(f fVar, boolean z) {
        if (fVar == this.dV) {
            dismiss();
            if (this.PS != null) {
                this.PS.a(fVar, z);
            }
        }
    }

    public final boolean E() {
        return false;
    }

    public final boolean b(h hVar) {
        return false;
    }

    public final boolean c(h hVar) {
        return false;
    }

    public final int getId() {
        return 0;
    }

    public final Parcelable onSaveInstanceState() {
        return null;
    }

    public final void onRestoreInstanceState(Parcelable parcelable) {
    }
}
