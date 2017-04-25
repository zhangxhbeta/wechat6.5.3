package android.support.v7.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.drawable.Drawable;
import android.support.v4.view.d;
import android.support.v4.view.y;
import android.support.v7.a.a.f;
import android.support.v7.a.a.h;
import android.support.v7.a.a.i;
import android.support.v7.a.a.k;
import android.support.v7.widget.d.c;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.PopupWindow.OnDismissListener;
import android.widget.TextView;

public class ActivityChooserView extends ViewGroup {
    private final a SK;
    private final b SL;
    private final LinearLayoutCompat SM;
    private final Drawable SN;
    private final FrameLayout SO;
    private final ImageView SP;
    private final FrameLayout SQ;
    private final ImageView SR;
    private final int SS;
    d ST;
    private final DataSetObserver SU;
    private final OnGlobalLayoutListener SV;
    private ListPopupWindow SW;
    private OnDismissListener SX;
    boolean SY;
    int SZ;
    private int Ta;
    boolean hh;

    public static class InnerLayout extends LinearLayoutCompat {
        private static final int[] Pf = new int[]{16842964};

        public InnerLayout(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            ap a = ap.a(context, attributeSet, Pf);
            setBackgroundDrawable(a.getDrawable(0));
            a.adM.recycle();
        }
    }

    private class a extends BaseAdapter {
        final /* synthetic */ ActivityChooserView Tb;
        d Tc;
        private int Td;
        boolean Te;
        private boolean Tf;
        private boolean Tg;

        private a(ActivityChooserView activityChooserView) {
            this.Tb = activityChooserView;
            this.Td = 4;
        }

        public final int getItemViewType(int i) {
            if (this.Tg && i == getCount() - 1) {
                return 1;
            }
            return 0;
        }

        public final int getViewTypeCount() {
            return 3;
        }

        public final int getCount() {
            int ek = this.Tc.ek();
            if (!(this.Te || this.Tc.el() == null)) {
                ek--;
            }
            ek = Math.min(ek, this.Td);
            if (this.Tg) {
                return ek + 1;
            }
            return ek;
        }

        public final Object getItem(int i) {
            switch (getItemViewType(i)) {
                case 0:
                    if (!(this.Te || this.Tc.el() == null)) {
                        i++;
                    }
                    return this.Tc.aA(i);
                case 1:
                    return null;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final long getItemId(int i) {
            return (long) i;
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            switch (getItemViewType(i)) {
                case 0:
                    if (view == null || view.getId() != f.Jn) {
                        view = LayoutInflater.from(this.Tb.getContext()).inflate(h.JN, viewGroup, false);
                    }
                    PackageManager packageManager = this.Tb.getContext().getPackageManager();
                    ResolveInfo resolveInfo = (ResolveInfo) getItem(i);
                    ((ImageView) view.findViewById(f.icon)).setImageDrawable(resolveInfo.loadIcon(packageManager));
                    ((TextView) view.findViewById(f.title)).setText(resolveInfo.loadLabel(packageManager));
                    if (this.Te && i == 0 && this.Tf) {
                        y.b(view, true);
                        return view;
                    }
                    y.b(view, false);
                    return view;
                case 1:
                    if (view != null && view.getId() == 1) {
                        return view;
                    }
                    view = LayoutInflater.from(this.Tb.getContext()).inflate(h.JN, viewGroup, false);
                    view.setId(1);
                    ((TextView) view.findViewById(f.title)).setText(this.Tb.getContext().getString(i.Kc));
                    return view;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final int ev() {
            int i = 0;
            int i2 = this.Td;
            this.Td = Integer.MAX_VALUE;
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            int makeMeasureSpec2 = MeasureSpec.makeMeasureSpec(0, 0);
            int count = getCount();
            View view = null;
            int i3 = 0;
            while (i < count) {
                view = getView(i, view, null);
                view.measure(makeMeasureSpec, makeMeasureSpec2);
                i3 = Math.max(i3, view.getMeasuredWidth());
                i++;
            }
            this.Td = i2;
            return i3;
        }

        public final void aD(int i) {
            if (this.Td != i) {
                this.Td = i;
                notifyDataSetChanged();
            }
        }

        public final void L(boolean z) {
            if (this.Tg != z) {
                this.Tg = z;
                notifyDataSetChanged();
            }
        }

        public final void c(boolean z, boolean z2) {
            if (this.Te != z || this.Tf != z2) {
                this.Te = z;
                this.Tf = z2;
                notifyDataSetChanged();
            }
        }
    }

    private class b implements OnClickListener, OnLongClickListener, OnItemClickListener, OnDismissListener {
        final /* synthetic */ ActivityChooserView Tb;

        private b(ActivityChooserView activityChooserView) {
            this.Tb = activityChooserView;
        }

        public final void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
            switch (((a) adapterView.getAdapter()).getItemViewType(i)) {
                case 0:
                    this.Tb.es();
                    if (!this.Tb.SY) {
                        if (!this.Tb.SK.Te) {
                            i++;
                        }
                        Intent aB = this.Tb.SK.Tc.aB(i);
                        if (aB != null) {
                            aB.addFlags(524288);
                            this.Tb.getContext().startActivity(aB);
                            return;
                        }
                        return;
                    } else if (i > 0) {
                        d dVar = this.Tb.SK.Tc;
                        synchronized (dVar.Sx) {
                            dVar.em();
                            android.support.v7.widget.d.a aVar = (android.support.v7.widget.d.a) dVar.Sy.get(i);
                            android.support.v7.widget.d.a aVar2 = (android.support.v7.widget.d.a) dVar.Sy.get(0);
                            dVar.a(new c(new ComponentName(aVar.resolveInfo.activityInfo.packageName, aVar.resolveInfo.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.weight - aVar.weight) + 5.0f : 1.0f));
                        }
                        return;
                    } else {
                        return;
                    }
                case 1:
                    this.Tb.aC(Integer.MAX_VALUE);
                    return;
                default:
                    throw new IllegalArgumentException();
            }
        }

        public final void onClick(View view) {
            if (view == this.Tb.SQ) {
                this.Tb.es();
                Intent aB = this.Tb.SK.Tc.aB(this.Tb.SK.Tc.a(this.Tb.SK.Tc.el()));
                if (aB != null) {
                    aB.addFlags(524288);
                    this.Tb.getContext().startActivity(aB);
                }
            } else if (view == this.Tb.SO) {
                this.Tb.SY = false;
                this.Tb.aC(this.Tb.SZ);
            } else {
                throw new IllegalArgumentException();
            }
        }

        public final boolean onLongClick(View view) {
            if (view == this.Tb.SQ) {
                if (this.Tb.SK.getCount() > 0) {
                    this.Tb.SY = true;
                    this.Tb.aC(this.Tb.SZ);
                }
                return true;
            }
            throw new IllegalArgumentException();
        }

        public final void onDismiss() {
            if (this.Tb.SX != null) {
                this.Tb.SX.onDismiss();
            }
            if (this.Tb.ST != null) {
                this.Tb.ST.p(false);
            }
        }
    }

    static /* synthetic */ void c(ActivityChooserView activityChooserView) {
        if (activityChooserView.SK.getCount() > 0) {
            activityChooserView.SO.setEnabled(true);
        } else {
            activityChooserView.SO.setEnabled(false);
        }
        int ek = activityChooserView.SK.Tc.ek();
        int historySize = activityChooserView.SK.Tc.getHistorySize();
        if (ek == 1 || (ek > 1 && historySize > 0)) {
            activityChooserView.SQ.setVisibility(0);
            ResolveInfo el = activityChooserView.SK.Tc.el();
            PackageManager packageManager = activityChooserView.getContext().getPackageManager();
            activityChooserView.SR.setImageDrawable(el.loadIcon(packageManager));
            if (activityChooserView.Ta != 0) {
                CharSequence loadLabel = el.loadLabel(packageManager);
                activityChooserView.SQ.setContentDescription(activityChooserView.getContext().getString(activityChooserView.Ta, new Object[]{loadLabel}));
            }
        } else {
            activityChooserView.SQ.setVisibility(8);
        }
        if (activityChooserView.SQ.getVisibility() == 0) {
            activityChooserView.SM.setBackgroundDrawable(activityChooserView.SN);
        } else {
            activityChooserView.SM.setBackgroundDrawable(null);
        }
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActivityChooserView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.SU = new DataSetObserver(this) {
            final /* synthetic */ ActivityChooserView Tb;

            {
                this.Tb = r1;
            }

            public final void onChanged() {
                super.onChanged();
                this.Tb.SK.notifyDataSetChanged();
            }

            public final void onInvalidated() {
                super.onInvalidated();
                this.Tb.SK.notifyDataSetInvalidated();
            }
        };
        this.SV = new OnGlobalLayoutListener(this) {
            final /* synthetic */ ActivityChooserView Tb;

            {
                this.Tb = r1;
            }

            public final void onGlobalLayout() {
                if (!this.Tb.et()) {
                    return;
                }
                if (this.Tb.isShown()) {
                    this.Tb.eu().show();
                    if (this.Tb.ST != null) {
                        this.Tb.ST.p(true);
                        return;
                    }
                    return;
                }
                this.Tb.eu().dismiss();
            }
        };
        this.SZ = 4;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, k.ba, i, 0);
        this.SZ = obtainStyledAttributes.getInt(k.KG, 4);
        Drawable drawable = obtainStyledAttributes.getDrawable(k.KF);
        obtainStyledAttributes.recycle();
        LayoutInflater.from(getContext()).inflate(h.JM, this, true);
        this.SL = new b();
        this.SM = (LinearLayoutCompat) findViewById(f.Jd);
        this.SN = this.SM.getBackground();
        this.SQ = (FrameLayout) findViewById(f.Jj);
        this.SQ.setOnClickListener(this.SL);
        this.SQ.setOnLongClickListener(this.SL);
        this.SR = (ImageView) this.SQ.findViewById(f.Jm);
        FrameLayout frameLayout = (FrameLayout) findViewById(f.Jl);
        frameLayout.setOnClickListener(this.SL);
        frameLayout.setOnTouchListener(new android.support.v7.widget.ListPopupWindow.b(this, frameLayout) {
            final /* synthetic */ ActivityChooserView Tb;

            public final ListPopupWindow dt() {
                return this.Tb.eu();
            }

            protected final boolean du() {
                ActivityChooserView activityChooserView = this.Tb;
                if (!activityChooserView.et() && activityChooserView.hh) {
                    activityChooserView.SY = false;
                    activityChooserView.aC(activityChooserView.SZ);
                }
                return true;
            }

            protected final boolean ef() {
                this.Tb.es();
                return true;
            }
        });
        this.SO = frameLayout;
        this.SP = (ImageView) frameLayout.findViewById(f.Jm);
        this.SP.setImageDrawable(drawable);
        this.SK = new a();
        this.SK.registerDataSetObserver(new DataSetObserver(this) {
            final /* synthetic */ ActivityChooserView Tb;

            {
                this.Tb = r1;
            }

            public final void onChanged() {
                super.onChanged();
                ActivityChooserView.c(this.Tb);
            }
        });
        Resources resources = context.getResources();
        this.SS = Math.max(resources.getDisplayMetrics().widthPixels / 2, resources.getDimensionPixelSize(android.support.v7.a.a.d.Ia));
    }

    final void aC(int i) {
        if (this.SK.Tc == null) {
            throw new IllegalStateException("No data model. Did you call #setDataModel?");
        }
        getViewTreeObserver().addOnGlobalLayoutListener(this.SV);
        boolean z = this.SQ.getVisibility() == 0;
        int ek = this.SK.Tc.ek();
        int i2;
        if (z) {
            i2 = 1;
        } else {
            i2 = 0;
        }
        if (i == Integer.MAX_VALUE || ek <= r3 + i) {
            this.SK.L(false);
            this.SK.aD(i);
        } else {
            this.SK.L(true);
            this.SK.aD(i - 1);
        }
        ListPopupWindow eu = eu();
        if (!eu.Xa.isShowing()) {
            if (this.SY || !z) {
                this.SK.c(true, z);
            } else {
                this.SK.c(false, false);
            }
            eu.setContentWidth(Math.min(this.SK.ev(), this.SS));
            eu.show();
            if (this.ST != null) {
                this.ST.p(true);
            }
            eu.Xb.setContentDescription(getContext().getString(i.Kd));
        }
    }

    public final boolean es() {
        if (eu().Xa.isShowing()) {
            eu().dismiss();
            ViewTreeObserver viewTreeObserver = getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeGlobalOnLayoutListener(this.SV);
            }
        }
        return true;
    }

    public final boolean et() {
        return eu().Xa.isShowing();
    }

    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        d dVar = this.SK.Tc;
        if (dVar != null) {
            dVar.registerObserver(this.SU);
        }
        this.hh = true;
    }

    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        d dVar = this.SK.Tc;
        if (dVar != null) {
            dVar.unregisterObserver(this.SU);
        }
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            viewTreeObserver.removeGlobalOnLayoutListener(this.SV);
        }
        if (et()) {
            es();
        }
        this.hh = false;
    }

    protected void onMeasure(int i, int i2) {
        LinearLayoutCompat linearLayoutCompat = this.SM;
        if (this.SQ.getVisibility() != 0) {
            i2 = MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(i2), 1073741824);
        }
        measureChild(linearLayoutCompat, i, i2);
        setMeasuredDimension(linearLayoutCompat.getMeasuredWidth(), linearLayoutCompat.getMeasuredHeight());
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        this.SM.layout(0, 0, i3 - i, i4 - i2);
        if (!et()) {
            es();
        }
    }

    private ListPopupWindow eu() {
        if (this.SW == null) {
            this.SW = new ListPopupWindow(getContext());
            this.SW.setAdapter(this.SK);
            this.SW.Xn = this;
            this.SW.fi();
            this.SW.Xp = this.SL;
            this.SW.setOnDismissListener(this.SL);
        }
        return this.SW;
    }
}
