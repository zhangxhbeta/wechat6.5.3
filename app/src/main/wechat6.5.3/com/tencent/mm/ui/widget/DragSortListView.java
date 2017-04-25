package com.tencent.mm.ui.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.Checkable;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.WebView;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DragSortListView extends ListView {
    private int DU = 0;
    private DataSetObserver Xm;
    private int dOx;
    private int dOy;
    private int oZA;
    private boolean oZB = false;
    private float oZC = 1.0f;
    private float oZD = 1.0f;
    private int oZE;
    private int oZF;
    private int oZG;
    private boolean oZH = false;
    private int oZI;
    private int oZJ;
    private int oZK;
    private int oZL;
    private int oZM;
    private b oZN;
    public g oZO;
    public l oZP;
    boolean oZQ = true;
    private int oZR = 1;
    private int oZS;
    private int oZT;
    private int oZU = 0;
    private View[] oZV = new View[1];
    private d oZW;
    private float oZX = 0.33333334f;
    private float oZY = 0.33333334f;
    private int oZZ;
    private View oZx;
    private Point oZy = new Point();
    private Point oZz = new Point();
    private f paA;
    boolean paB;
    private float paC = 0.0f;
    boolean paD = false;
    private boolean paE = false;
    private int paa;
    private float pab;
    private float pac;
    private float pad;
    private float pae;
    private float paf = 0.5f;
    private c pag = new c(this) {
        final /* synthetic */ DragSortListView paF;

        {
            this.paF = r1;
        }

        public final float aj(float f) {
            return this.paF.paf * f;
        }
    };
    private int pah;
    private int pai;
    private int paj;
    private int pak = 0;
    private boolean pal = false;
    boolean pam = false;
    h pan = null;
    private MotionEvent pao;
    private int pap = 0;
    private float paq = 0.25f;
    private float par = 0.0f;
    private a pas;
    private boolean pat = false;
    private e pau;
    private boolean pav = false;
    private boolean paw = false;
    private i pax = new i(this);
    private k pay;
    private j paz;

    private class a extends BaseAdapter {
        private ListAdapter EK;
        final /* synthetic */ DragSortListView paF;

        public a(final DragSortListView dragSortListView, ListAdapter listAdapter) {
            this.paF = dragSortListView;
            this.EK = listAdapter;
            this.EK.registerDataSetObserver(new DataSetObserver(this) {
                final /* synthetic */ a paH;

                public final void onChanged() {
                    this.paH.notifyDataSetChanged();
                }

                public final void onInvalidated() {
                    this.paH.notifyDataSetInvalidated();
                }
            });
        }

        public final long getItemId(int i) {
            return this.EK.getItemId(i);
        }

        public final Object getItem(int i) {
            return this.EK.getItem(i);
        }

        public final int getCount() {
            return this.EK.getCount();
        }

        public final boolean areAllItemsEnabled() {
            return this.EK.areAllItemsEnabled();
        }

        public final boolean isEnabled(int i) {
            return this.EK.isEnabled(i);
        }

        public final int getItemViewType(int i) {
            return this.EK.getItemViewType(i);
        }

        public final int getViewTypeCount() {
            return this.EK.getViewTypeCount();
        }

        public final boolean hasStableIds() {
            return this.EK.hasStableIds();
        }

        public final boolean isEmpty() {
            return this.EK.isEmpty();
        }

        public final View getView(int i, View view, ViewGroup viewGroup) {
            View childAt;
            View view2;
            if (view != null) {
                view = (b) view;
                childAt = view.getChildAt(0);
                view2 = this.EK.getView(i, childAt, this.paF);
                if (view2 != childAt) {
                    if (childAt != null) {
                        view.removeViewAt(0);
                    }
                    view.addView(view2);
                }
            } else {
                view2 = this.EK.getView(i, null, this.paF);
                if (view2 instanceof Checkable) {
                    childAt = new c(this.paF.getContext());
                } else {
                    childAt = new b(this.paF.getContext());
                }
                childAt.setLayoutParams(new LayoutParams(-1, -2));
                childAt.addView(view2);
                view = childAt;
            }
            this.paF.a(this.paF.getHeaderViewsCount() + i, view, true);
            return view;
        }
    }

    public interface b {
    }

    public interface c {
        float aj(float f);
    }

    private class d implements Runnable {
        final /* synthetic */ DragSortListView paF;
        private boolean paI;
        private long paJ;
        private long paK;
        private int paL;
        private float paM;
        private long paN;
        int paO;
        private float paP;
        boolean paQ = false;

        public d(DragSortListView dragSortListView) {
            this.paF = dragSortListView;
        }

        public final void yt(int i) {
            if (!this.paQ) {
                this.paI = false;
                this.paQ = true;
                this.paN = SystemClock.uptimeMillis();
                this.paJ = this.paN;
                this.paO = i;
                this.paF.post(this);
            }
        }

        public final void bKd() {
            this.paF.removeCallbacks(this);
            this.paQ = false;
        }

        public final void run() {
            if (this.paI) {
                this.paQ = false;
                return;
            }
            View childAt;
            int firstVisiblePosition = this.paF.getFirstVisiblePosition();
            int lastVisiblePosition = this.paF.getLastVisiblePosition();
            int count = this.paF.getCount();
            int paddingTop = this.paF.getPaddingTop();
            int height = (this.paF.getHeight() - paddingTop) - this.paF.getPaddingBottom();
            int min = Math.min(this.paF.pai, this.paF.oZA + this.paF.oZT);
            int max = Math.max(this.paF.pai, this.paF.oZA - this.paF.oZT);
            if (this.paO == 0) {
                childAt = this.paF.getChildAt(0);
                if (childAt == null) {
                    this.paQ = false;
                    return;
                } else if (firstVisiblePosition == 0 && childAt.getTop() == paddingTop) {
                    this.paQ = false;
                    return;
                } else {
                    this.paP = this.paF.pag.aj((this.paF.pac - ((float) max)) / this.paF.pad);
                }
            } else {
                View childAt2 = this.paF.getChildAt(lastVisiblePosition - firstVisiblePosition);
                if (childAt2 == null) {
                    this.paQ = false;
                    return;
                } else if (lastVisiblePosition != count - 1 || childAt2.getBottom() > height + paddingTop) {
                    this.paP = -this.paF.pag.aj((((float) min) - this.paF.pab) / this.paF.pae);
                } else {
                    this.paQ = false;
                    return;
                }
            }
            this.paK = SystemClock.uptimeMillis();
            this.paM = (float) (this.paK - this.paJ);
            this.paL = Math.round(this.paP * this.paM);
            if (this.paL >= 0) {
                this.paL = Math.min(height, this.paL);
                lastVisiblePosition = firstVisiblePosition;
            } else {
                this.paL = Math.max(-height, this.paL);
            }
            childAt = this.paF.getChildAt(lastVisiblePosition - firstVisiblePosition);
            firstVisiblePosition = childAt.getTop() + this.paL;
            if (lastVisiblePosition == 0 && firstVisiblePosition > paddingTop) {
                firstVisiblePosition = paddingTop;
            }
            this.paF.pav = true;
            this.paF.setSelectionFromTop(lastVisiblePosition, firstVisiblePosition - paddingTop);
            this.paF.layoutChildren();
            this.paF.invalidate();
            this.paF.pav = false;
            this.paF.c(lastVisiblePosition, childAt, false);
            this.paJ = this.paK;
            this.paF.post(this);
        }
    }

    private class e {
        File dAr = new File(Environment.getExternalStorageDirectory(), "dslv_state.txt");
        final /* synthetic */ DragSortListView paF;
        int paR = 0;
        int paS = 0;
        boolean paT = false;
        StringBuilder vA = new StringBuilder();

        public e(DragSortListView dragSortListView) {
            this.paF = dragSortListView;
            if (!this.dAr.exists()) {
                try {
                    this.dAr.createNewFile();
                    v.d("mobeta", "file created");
                } catch (IOException e) {
                    v.w("mobeta", "Could not create dslv_state.txt");
                    v.d("mobeta", e.getMessage());
                }
            }
        }

        public final void flush() {
            FileWriter fileWriter;
            Throwable th;
            if (this.paT) {
                FileWriter fileWriter2 = null;
                boolean z = true;
                try {
                    if (this.paS == 0) {
                        z = false;
                    }
                    fileWriter = new FileWriter(this.dAr, z);
                    try {
                        fileWriter.write(this.vA.toString());
                        this.vA.delete(0, this.vA.length());
                        fileWriter.flush();
                        this.paS++;
                        try {
                            fileWriter.close();
                        } catch (IOException e) {
                        }
                    } catch (IOException e2) {
                        if (fileWriter != null) {
                            try {
                                fileWriter.close();
                            } catch (IOException e3) {
                            }
                        }
                    } catch (Throwable th2) {
                        Throwable th3 = th2;
                        fileWriter2 = fileWriter;
                        th = th3;
                        if (fileWriter2 != null) {
                            try {
                                fileWriter2.close();
                            } catch (IOException e4) {
                            }
                        }
                        throw th;
                    }
                } catch (IOException e5) {
                    fileWriter = null;
                    if (fileWriter != null) {
                        fileWriter.close();
                    }
                } catch (Throwable th4) {
                    th = th4;
                    if (fileWriter2 != null) {
                        fileWriter2.close();
                    }
                    throw th;
                }
            }
        }
    }

    public interface g {
        void bz(int i, int i2);
    }

    public interface h {
        void d(Point point);

        void dc(View view);

        View yu(int i);
    }

    private class i {
        int jqO = 3;
        final /* synthetic */ DragSortListView paF;
        SparseIntArray paY = new SparseIntArray(3);
        ArrayList<Integer> paZ = new ArrayList(3);

        public i(DragSortListView dragSortListView) {
            this.paF = dragSortListView;
        }
    }

    public interface l {
        void remove(int i);
    }

    private class m implements Runnable {
        boolean QK;
        private float mAlpha = 0.5f;
        protected long mStartTime;
        final /* synthetic */ DragSortListView paF;
        private float pbi;
        private float pbj;
        private float pbk;
        private float pbl;
        private float pbm;

        public m(DragSortListView dragSortListView, float f, int i) {
            this.paF = dragSortListView;
            this.pbi = (float) i;
            float f2 = 1.0f / ((this.mAlpha * 2.0f) * (1.0f - this.mAlpha));
            this.pbm = f2;
            this.pbj = f2;
            this.pbk = this.mAlpha / ((this.mAlpha - 1.0f) * 2.0f);
            this.pbl = 1.0f / (1.0f - this.mAlpha);
        }

        public final void start() {
            this.mStartTime = SystemClock.uptimeMillis();
            this.QK = false;
            onStart();
            this.paF.post(this);
        }

        public void onStart() {
        }

        public void ak(float f) {
        }

        public void onStop() {
        }

        public void run() {
            if (!this.QK) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / this.pbi;
                if (uptimeMillis >= 1.0f) {
                    ak(1.0f);
                    onStop();
                    return;
                }
                if (uptimeMillis < this.mAlpha) {
                    uptimeMillis *= this.pbj * uptimeMillis;
                } else if (uptimeMillis < 1.0f - this.mAlpha) {
                    uptimeMillis = (uptimeMillis * this.pbl) + this.pbk;
                } else {
                    uptimeMillis = 1.0f - ((uptimeMillis - 1.0f) * (this.pbm * (uptimeMillis - 1.0f)));
                }
                ak(uptimeMillis);
                this.paF.post(this);
            }
        }
    }

    private class f extends m {
        final /* synthetic */ DragSortListView paF;
        private int paU;
        private int paV;
        private float paW;
        private float paX;

        public f(DragSortListView dragSortListView, int i) {
            this.paF = dragSortListView;
            super(dragSortListView, 0.5f, i);
        }

        public final void onStart() {
            this.paU = this.paF.oZE;
            this.paV = this.paF.oZI;
            this.paF.DU = 2;
            this.paW = (float) (this.paF.oZy.y - bKe());
            this.paX = (float) (this.paF.oZy.x - this.paF.getPaddingLeft());
        }

        private int bKe() {
            int j = (this.paF.oZR + this.paF.getDividerHeight()) / 2;
            View childAt = this.paF.getChildAt(this.paU - this.paF.getFirstVisiblePosition());
            if (childAt == null) {
                this.QK = true;
                return -1;
            } else if (this.paU == this.paV) {
                return childAt.getTop();
            } else {
                if (this.paU < this.paV) {
                    return childAt.getTop() - j;
                }
                return (childAt.getBottom() + j) - this.paF.oZS;
            }
        }

        public final void ak(float f) {
            int bKe = bKe();
            float paddingLeft = (float) (this.paF.oZy.x - this.paF.getPaddingLeft());
            float f2 = 1.0f - f;
            if (f2 < Math.abs(((float) (this.paF.oZy.y - bKe)) / this.paW) || f2 < Math.abs(paddingLeft / this.paX)) {
                this.paF.oZy.y = bKe + ((int) (this.paW * f2));
                this.paF.oZy.x = this.paF.getPaddingLeft() + ((int) (this.paX * f2));
                this.paF.kp(true);
            }
        }

        public final void onStop() {
            this.paF.bJW();
        }
    }

    private class j extends m {
        final /* synthetic */ DragSortListView paF;
        private float pba;
        private float pbb;

        public final void onStart() {
            this.pba = (float) this.paF.oZK;
            this.pbb = (float) this.paF.oZT;
        }

        public final void ak(float f) {
            if (this.paF.DU != 4) {
                this.QK = true;
                return;
            }
            this.paF.oZK = (int) ((this.pbb * f) + ((1.0f - f) * this.pba));
            this.paF.oZy.y = this.paF.pai - this.paF.oZK;
            this.paF.kp(true);
        }
    }

    private class k extends m {
        private int eSy;
        final /* synthetic */ DragSortListView paF;
        private int paV;
        private float pbc;
        private float pbd;
        private float pbe;
        private int pbf = -1;
        private int pbg = -1;
        private int pbh;

        public k(DragSortListView dragSortListView, int i) {
            this.paF = dragSortListView;
            super(dragSortListView, 0.5f, i);
        }

        public final void onStart() {
            int i = -1;
            this.pbf = -1;
            this.pbg = -1;
            this.eSy = this.paF.oZF;
            this.pbh = this.paF.oZG;
            this.paV = this.paF.oZI;
            this.paF.DU = 1;
            this.pbc = (float) this.paF.oZy.x;
            if (this.paF.paB) {
                float width = ((float) this.paF.getWidth()) * 2.0f;
                if (this.paF.paC == 0.0f) {
                    DragSortListView dragSortListView = this.paF;
                    if (this.pbc >= 0.0f) {
                        i = 1;
                    }
                    dragSortListView.paC = ((float) i) * width;
                    return;
                }
                float f = width * 2.0f;
                if (this.paF.paC < 0.0f && this.paF.paC > (-f)) {
                    this.paF.paC = -f;
                    return;
                } else if (this.paF.paC > 0.0f && this.paF.paC < f) {
                    this.paF.paC = f;
                    return;
                } else {
                    return;
                }
            }
            this.paF.bKc();
        }

        public final void ak(float f) {
            float f2 = 1.0f - f;
            int firstVisiblePosition = this.paF.getFirstVisiblePosition();
            View childAt = this.paF.getChildAt(this.eSy - firstVisiblePosition);
            if (this.paF.paB) {
                float uptimeMillis = ((float) (SystemClock.uptimeMillis() - this.mStartTime)) / 1000.0f;
                if (uptimeMillis != 0.0f) {
                    float p = this.paF.paC * uptimeMillis;
                    int width = this.paF.getWidth();
                    DragSortListView.b(this.paF, (((float) (this.paF.paC > 0.0f ? 1 : -1)) * uptimeMillis) * ((float) width));
                    this.pbc += p;
                    this.paF.oZy.x = (int) this.pbc;
                    if (this.pbc < ((float) width) && this.pbc > ((float) (-width))) {
                        this.mStartTime = SystemClock.uptimeMillis();
                        this.paF.kp(true);
                        return;
                    }
                }
                return;
            }
            if (childAt != null) {
                if (this.pbf == -1) {
                    this.pbf = this.paF.b(this.eSy, childAt, false);
                    this.pbd = (float) (childAt.getHeight() - this.pbf);
                }
                int max = Math.max((int) (this.pbd * f2), 1);
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                layoutParams.height = max + this.pbf;
                childAt.setLayoutParams(layoutParams);
            }
            if (this.pbh != this.eSy) {
                View childAt2 = this.paF.getChildAt(this.pbh - firstVisiblePosition);
                if (childAt2 != null) {
                    if (this.pbg == -1) {
                        this.pbg = this.paF.b(this.pbh, childAt2, false);
                        this.pbe = (float) (childAt2.getHeight() - this.pbg);
                    }
                    int max2 = Math.max((int) (this.pbe * f2), 1);
                    ViewGroup.LayoutParams layoutParams2 = childAt2.getLayoutParams();
                    layoutParams2.height = max2 + this.pbg;
                    childAt2.setLayoutParams(layoutParams2);
                }
            }
        }

        public final void onStop() {
            this.paF.yr(this.paF.oZI - this.paF.getHeaderViewsCount());
        }
    }

    static /* synthetic */ float b(DragSortListView dragSortListView, float f) {
        float f2 = dragSortListView.paC + f;
        dragSortListView.paC = f2;
        return f2;
    }

    public DragSortListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i = 150;
        int i2 = 150;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.tencent.mm.bi.a.g.aPc, 0, 0);
            this.oZR = Math.max(1, obtainStyledAttributes.getDimensionPixelSize(com.tencent.mm.bi.a.g.pfs, 1));
            this.pat = obtainStyledAttributes.getBoolean(com.tencent.mm.bi.a.g.pfH, false);
            if (this.pat) {
                this.pau = new e(this);
            }
            this.oZC = obtainStyledAttributes.getFloat(com.tencent.mm.bi.a.g.pfz, this.oZC);
            this.oZD = this.oZC;
            this.oZQ = obtainStyledAttributes.getBoolean(com.tencent.mm.bi.a.g.pft, this.oZQ);
            this.paq = Math.max(0.0f, Math.min(1.0f, 1.0f - obtainStyledAttributes.getFloat(com.tencent.mm.bi.a.g.pfF, 0.75f)));
            this.oZH = this.paq > 0.0f;
            float f = obtainStyledAttributes.getFloat(com.tencent.mm.bi.a.g.pfv, this.oZX);
            if (f > 0.5f) {
                this.oZY = 0.5f;
            } else {
                this.oZY = f;
            }
            if (f > 0.5f) {
                this.oZX = 0.5f;
            } else {
                this.oZX = f;
            }
            if (getHeight() != 0) {
                bJZ();
            }
            this.paf = obtainStyledAttributes.getFloat(com.tencent.mm.bi.a.g.pfB, this.paf);
            int i3 = obtainStyledAttributes.getInt(com.tencent.mm.bi.a.g.pfC, 150);
            int i4 = obtainStyledAttributes.getInt(com.tencent.mm.bi.a.g.pfx, 150);
            if (obtainStyledAttributes.getBoolean(com.tencent.mm.bi.a.g.pfI, true)) {
                boolean z = obtainStyledAttributes.getBoolean(com.tencent.mm.bi.a.g.pfD, false);
                int i5 = obtainStyledAttributes.getInt(com.tencent.mm.bi.a.g.pfE, 1);
                boolean z2 = obtainStyledAttributes.getBoolean(com.tencent.mm.bi.a.g.pfG, true);
                int i6 = obtainStyledAttributes.getInt(com.tencent.mm.bi.a.g.pfw, 0);
                int resourceId = obtainStyledAttributes.getResourceId(com.tencent.mm.bi.a.g.pfu, 0);
                int resourceId2 = obtainStyledAttributes.getResourceId(com.tencent.mm.bi.a.g.pfy, 0);
                int resourceId3 = obtainStyledAttributes.getResourceId(com.tencent.mm.bi.a.g.pfr, 0);
                int color = obtainStyledAttributes.getColor(com.tencent.mm.bi.a.g.pfA, WebView.NIGHT_MODE_COLOR);
                Object aVar = new a(this, resourceId, i6, i5, resourceId3, resourceId2);
                aVar.oZb = z;
                aVar.oZa = z2;
                aVar.peo = color;
                this.pan = aVar;
                setOnTouchListener(aVar);
            }
            obtainStyledAttributes.recycle();
            i2 = i4;
            i = i3;
        }
        this.oZW = new d(this);
        if (i > 0) {
            this.pay = new k(this, i);
        }
        if (i2 > 0) {
            this.paA = new f(this, i2);
        }
        this.pao = MotionEvent.obtain(0, 0, 3, 0.0f, 0.0f, 0.0f, 0.0f, 0, 0.0f, 0.0f, 0, 0);
        this.Xm = new DataSetObserver(this) {
            final /* synthetic */ DragSortListView paF;

            {
                this.paF = r1;
            }

            private void cancel() {
                if (this.paF.DU == 4) {
                    this.paF.bJU();
                }
            }

            public final void onChanged() {
                cancel();
            }

            public final void onInvalidated() {
                cancel();
            }
        };
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            this.pas = new a(this, listAdapter);
            listAdapter.registerDataSetObserver(this.Xm);
            if (listAdapter instanceof g) {
                this.oZO = (g) listAdapter;
            }
            if (listAdapter instanceof b) {
                this.oZN = (b) listAdapter;
            }
            if (listAdapter instanceof l) {
                this.oZP = (l) listAdapter;
            }
        } else {
            this.pas = null;
        }
        super.setAdapter(this.pas);
    }

    private void a(int i, Canvas canvas) {
        Drawable divider = getDivider();
        int dividerHeight = getDividerHeight();
        if (divider != null && dividerHeight != 0) {
            ViewGroup viewGroup = (ViewGroup) getChildAt(i - getFirstVisiblePosition());
            if (viewGroup != null) {
                int i2;
                int paddingLeft = getPaddingLeft();
                int width = getWidth() - getPaddingRight();
                int height = viewGroup.getChildAt(0).getHeight();
                if (i > this.oZI) {
                    height += viewGroup.getTop();
                    i2 = height + dividerHeight;
                } else {
                    i2 = viewGroup.getBottom() - height;
                    height = i2 - dividerHeight;
                }
                canvas.save();
                canvas.clipRect(paddingLeft, height, width, i2);
                divider.setBounds(paddingLeft, height, width, i2);
                divider.draw(canvas);
                canvas.restore();
            }
        }
    }

    protected void dispatchDraw(Canvas canvas) {
        super.dispatchDraw(canvas);
        if (this.DU != 0) {
            if (this.oZF != this.oZI) {
                a(this.oZF, canvas);
            }
            if (!(this.oZG == this.oZF || this.oZG == this.oZI)) {
                a(this.oZG, canvas);
            }
        }
        if (this.oZx != null) {
            float f;
            int width = this.oZx.getWidth();
            int height = this.oZx.getHeight();
            int i = this.oZy.x;
            int width2 = getWidth();
            if (i < 0) {
                i = -i;
            }
            if (i < width2) {
                f = ((float) (width2 - i)) / ((float) width2);
                f *= f;
            } else {
                f = 0.0f;
            }
            int i2 = (int) (f * (255.0f * this.oZD));
            canvas.save();
            canvas.translate((float) this.oZy.x, (float) this.oZy.y);
            canvas.clipRect(0, 0, width, height);
            canvas.saveLayerAlpha(0.0f, 0.0f, (float) width, (float) height, i2, 31);
            this.oZx.draw(canvas);
            canvas.restore();
            canvas.restore();
        }
    }

    private int yq(int i) {
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return childAt.getHeight();
        }
        return dy(i, ys(i));
    }

    private int dx(int i, int i2) {
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        if (i <= headerViewsCount || i >= getCount() - footerViewsCount) {
            return i2;
        }
        headerViewsCount = getDividerHeight();
        footerViewsCount = this.oZS - this.oZR;
        int ys = ys(i);
        int yq = yq(i);
        if (this.oZG <= this.oZI) {
            if (i != this.oZG || this.oZF == this.oZG) {
                if (i > this.oZG && i <= this.oZI) {
                    i2 -= footerViewsCount;
                }
            } else if (i == this.oZI) {
                i2 = (i2 + yq) - this.oZS;
            } else {
                i2 = ((yq - ys) + i2) - footerViewsCount;
            }
        } else if (i > this.oZI && i <= this.oZF) {
            i2 += footerViewsCount;
        } else if (i == this.oZG && this.oZF != this.oZG) {
            i2 += yq - ys;
        }
        if (i <= this.oZI) {
            return (((this.oZS - headerViewsCount) - ys(i - 1)) / 2) + i2;
        }
        return (((ys - headerViewsCount) - this.oZS) / 2) + i2;
    }

    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.pat) {
            e eVar = this.pau;
            if (eVar.paT) {
                int i;
                eVar.vA.append("<DSLVState>\n");
                int childCount = eVar.paF.getChildCount();
                int firstVisiblePosition = eVar.paF.getFirstVisiblePosition();
                eVar.vA.append("    <Positions>");
                for (i = 0; i < childCount; i++) {
                    eVar.vA.append(firstVisiblePosition + i).append(",");
                }
                eVar.vA.append("</Positions>\n");
                eVar.vA.append("    <Tops>");
                for (i = 0; i < childCount; i++) {
                    eVar.vA.append(eVar.paF.getChildAt(i).getTop()).append(",");
                }
                eVar.vA.append("</Tops>\n");
                eVar.vA.append("    <Bottoms>");
                for (i = 0; i < childCount; i++) {
                    eVar.vA.append(eVar.paF.getChildAt(i).getBottom()).append(",");
                }
                eVar.vA.append("</Bottoms>\n");
                eVar.vA.append("    <FirstExpPos>").append(eVar.paF.oZF).append("</FirstExpPos>\n");
                eVar.vA.append("    <FirstExpBlankHeight>").append(eVar.paF.yq(eVar.paF.oZF) - eVar.paF.ys(eVar.paF.oZF)).append("</FirstExpBlankHeight>\n");
                eVar.vA.append("    <SecondExpPos>").append(eVar.paF.oZG).append("</SecondExpPos>\n");
                eVar.vA.append("    <SecondExpBlankHeight>").append(eVar.paF.yq(eVar.paF.oZG) - eVar.paF.ys(eVar.paF.oZG)).append("</SecondExpBlankHeight>\n");
                eVar.vA.append("    <SrcPos>").append(eVar.paF.oZI).append("</SrcPos>\n");
                eVar.vA.append("    <SrcHeight>").append(eVar.paF.oZS + eVar.paF.getDividerHeight()).append("</SrcHeight>\n");
                eVar.vA.append("    <ViewHeight>").append(eVar.paF.getHeight()).append("</ViewHeight>\n");
                eVar.vA.append("    <LastY>").append(eVar.paF.dOy).append("</LastY>\n");
                eVar.vA.append("    <FloatY>").append(eVar.paF.oZA).append("</FloatY>\n");
                eVar.vA.append("    <ShuffleEdges>");
                for (i = 0; i < childCount; i++) {
                    eVar.vA.append(eVar.paF.dx(firstVisiblePosition + i, eVar.paF.getChildAt(i).getTop())).append(",");
                }
                eVar.vA.append("</ShuffleEdges>\n");
                eVar.vA.append("</DSLVState>\n");
                eVar.paR++;
                if (eVar.paR > 1000) {
                    eVar.flush();
                    eVar.paR = 0;
                }
            }
        }
    }

    public final void i(int i, float f) {
        if (this.DU == 0 || this.DU == 4) {
            if (this.DU == 0) {
                this.oZI = getHeaderViewsCount() + i;
                this.oZF = this.oZI;
                this.oZG = this.oZI;
                this.oZE = this.oZI;
                View childAt = getChildAt(this.oZI - getFirstVisiblePosition());
                if (childAt != null) {
                    childAt.setVisibility(4);
                }
            }
            this.DU = 1;
            this.paC = f;
            if (this.pam) {
                switch (this.pap) {
                    case 1:
                        super.onTouchEvent(this.pao);
                        break;
                    case 2:
                        super.onInterceptTouchEvent(this.pao);
                        break;
                }
            }
            if (this.pay != null) {
                this.pay.start();
            } else {
                yr(i);
            }
        }
    }

    public final void bJU() {
        if (this.DU == 4) {
            this.oZW.bKd();
            bKc();
            bJV();
            bKa();
            if (this.pam) {
                this.DU = 3;
            } else {
                this.DU = 0;
            }
        }
    }

    private void bJV() {
        this.oZI = -1;
        this.oZF = -1;
        this.oZG = -1;
        this.oZE = -1;
    }

    private void bJW() {
        this.DU = 2;
        if (this.oZO != null && this.oZE >= 0 && this.oZE < getCount()) {
            int headerViewsCount = getHeaderViewsCount();
            this.oZO.bz(this.oZI - headerViewsCount, this.oZE - headerViewsCount);
        }
        bKc();
        bJX();
        bJV();
        bKa();
        if (this.pam) {
            this.DU = 3;
        } else {
            this.DU = 0;
        }
    }

    private void yr(int i) {
        this.DU = 1;
        if (this.oZP != null) {
            this.oZP.remove(i);
        }
        bKc();
        bJX();
        bJV();
        if (this.pam) {
            this.DU = 3;
        } else {
            this.DU = 0;
        }
    }

    private void bJX() {
        int i = 0;
        int firstVisiblePosition = getFirstVisiblePosition();
        if (this.oZI < firstVisiblePosition) {
            View childAt = getChildAt(0);
            if (childAt != null) {
                i = childAt.getTop();
            }
            setSelectionFromTop(firstVisiblePosition - 1, i - getPaddingTop());
        }
    }

    public final boolean ai(float f) {
        this.paB = true;
        return b(true, f);
    }

    private boolean b(boolean z, float f) {
        if (this.oZx == null) {
            return false;
        }
        this.oZW.bKd();
        if (z) {
            i(this.oZI - getHeaderViewsCount(), f);
        } else if (this.paA != null) {
            this.paA.start();
        } else {
            bJW();
        }
        if (this.pat) {
            e eVar = this.pau;
            if (eVar.paT) {
                eVar.vA.append("</DSLVStates>\n");
                eVar.flush();
                eVar.paT = false;
            }
        }
        return true;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.paw) {
            this.paw = false;
            return false;
        } else if (!this.oZQ) {
            return super.onTouchEvent(motionEvent);
        } else {
            boolean z = this.pal;
            this.pal = false;
            if (!z) {
                y(motionEvent);
            }
            if (this.DU != 4) {
                if (this.DU == 0 && super.onTouchEvent(motionEvent)) {
                    z = true;
                } else {
                    z = false;
                }
                switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
                    case 1:
                    case 3:
                        bJY();
                        break;
                    default:
                        if (z) {
                            this.pap = 1;
                            break;
                        }
                        break;
                }
            }
            motionEvent.getAction();
            switch (motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA) {
                case 1:
                    if (this.DU == 4) {
                        this.paB = false;
                        b(false, 0.0f);
                    }
                    bJY();
                    break;
                case 2:
                    int y = (int) motionEvent.getY();
                    this.oZy.x = ((int) motionEvent.getX()) - this.oZJ;
                    this.oZy.y = y - this.oZK;
                    kp(true);
                    int min = Math.min(y, this.oZA + this.oZT);
                    y = Math.max(y, this.oZA - this.oZT);
                    d dVar = this.oZW;
                    int i = dVar.paQ ? dVar.paO : -1;
                    if (min <= this.dOy || min <= this.paa || i == 1) {
                        if (y >= this.dOy || y >= this.oZZ || i == 0) {
                            if (y >= this.oZZ && min <= this.paa && this.oZW.paQ) {
                                this.oZW.bKd();
                                break;
                            }
                        }
                        if (i != -1) {
                            this.oZW.bKd();
                        }
                        this.oZW.yt(0);
                        break;
                    }
                    if (i != -1) {
                        this.oZW.bKd();
                    }
                    this.oZW.yt(1);
                    break;
                    break;
                case 3:
                    if (this.DU == 4) {
                        bJU();
                    }
                    bJY();
                    break;
            }
            z = true;
            return z;
        }
    }

    private void bJY() {
        this.pap = 0;
        this.pam = false;
        if (this.DU == 3) {
            this.DU = 0;
        }
        this.oZD = this.oZC;
        this.paD = false;
        i iVar = this.pax;
        iVar.paY.clear();
        iVar.paZ.clear();
    }

    private void y(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        if (action != 0) {
            this.dOx = this.pah;
            this.dOy = this.pai;
        }
        this.pah = (int) motionEvent.getX();
        this.pai = (int) motionEvent.getY();
        if (action == 0) {
            this.dOx = this.pah;
            this.dOy = this.pai;
        }
        this.oZL = ((int) motionEvent.getRawX()) - this.pah;
        this.oZM = ((int) motionEvent.getRawY()) - this.pai;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.oZQ) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        boolean z;
        y(motionEvent);
        this.pal = true;
        int action = motionEvent.getAction() & WebView.NORMAL_MODE_ALPHA;
        if (action == 0) {
            if (this.DU != 0) {
                this.paw = true;
                return true;
            }
            this.pam = true;
        }
        if (this.oZx == null) {
            if (super.onInterceptTouchEvent(motionEvent)) {
                this.paD = true;
                z = true;
            } else {
                z = false;
            }
            switch (action) {
                case 1:
                case 3:
                    bJY();
                    break;
                default:
                    if (!z) {
                        this.pap = 2;
                        break;
                    }
                    this.pap = 1;
                    break;
            }
        }
        z = true;
        if (action == 1 || action == 3) {
            this.pam = false;
        }
        return z;
    }

    private void bJZ() {
        int paddingTop = getPaddingTop();
        int height = (getHeight() - paddingTop) - getPaddingBottom();
        float f = (float) height;
        this.pac = ((float) paddingTop) + (this.oZX * f);
        this.pab = (f * (1.0f - this.oZY)) + ((float) paddingTop);
        this.oZZ = (int) this.pac;
        this.paa = (int) this.pab;
        this.pad = this.pac - ((float) paddingTop);
        this.pae = ((float) (paddingTop + height)) - this.pab;
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        bJZ();
    }

    private void bKa() {
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        lastVisiblePosition = Math.min(lastVisiblePosition - firstVisiblePosition, ((getCount() - 1) - getFooterViewsCount()) - firstVisiblePosition);
        for (int max = Math.max(0, getHeaderViewsCount() - firstVisiblePosition); max <= lastVisiblePosition; max++) {
            View childAt = getChildAt(max);
            if (childAt != null) {
                a(firstVisiblePosition + max, childAt, false);
            }
        }
    }

    private void a(int i, View view, boolean z) {
        int dy;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (i == this.oZI || i == this.oZF || i == this.oZG) {
            dy = dy(i, b(i, view, z));
        } else {
            dy = -2;
        }
        if (dy != layoutParams.height) {
            layoutParams.height = dy;
            view.setLayoutParams(layoutParams);
        }
        if (i == this.oZF || i == this.oZG) {
            if (i < this.oZI) {
                ((b) view).tD = 80;
            } else if (i > this.oZI) {
                ((b) view).tD = 48;
            }
        }
        int visibility = view.getVisibility();
        dy = 0;
        if (i == this.oZI && this.oZx != null) {
            dy = 4;
        }
        if (dy != visibility) {
            view.setVisibility(dy);
        }
    }

    private int ys(int i) {
        if (i == this.oZI) {
            return 0;
        }
        View childAt = getChildAt(i - getFirstVisiblePosition());
        if (childAt != null) {
            return b(i, childAt, false);
        }
        int i2 = this.pax.paY.get(i, -1);
        if (i2 != -1) {
            return i2;
        }
        ListAdapter adapter = getAdapter();
        int itemViewType = adapter.getItemViewType(i);
        int viewTypeCount = adapter.getViewTypeCount();
        if (viewTypeCount != this.oZV.length) {
            this.oZV = new View[viewTypeCount];
        }
        if (itemViewType < 0) {
            childAt = adapter.getView(i, null, this);
        } else if (this.oZV[itemViewType] == null) {
            childAt = adapter.getView(i, null, this);
            this.oZV[itemViewType] = childAt;
        } else {
            childAt = adapter.getView(i, this.oZV[itemViewType], this);
        }
        itemViewType = b(i, childAt, true);
        i iVar = this.pax;
        i2 = iVar.paY.get(i, -1);
        if (i2 != itemViewType) {
            if (i2 != -1) {
                iVar.paZ.remove(Integer.valueOf(i));
            } else if (iVar.paY.size() == iVar.jqO) {
                iVar.paY.delete(((Integer) iVar.paZ.remove(0)).intValue());
            }
            iVar.paY.put(i, itemViewType);
            iVar.paZ.add(Integer.valueOf(i));
        }
        return itemViewType;
    }

    private int b(int i, View view, boolean z) {
        if (i == this.oZI) {
            return 0;
        }
        if (i >= getHeaderViewsCount() && i < getCount() - getFooterViewsCount()) {
            view = ((ViewGroup) view).getChildAt(0);
        }
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null && layoutParams.height > 0) {
            return layoutParams.height;
        }
        int height = view.getHeight();
        if (height != 0 && !z) {
            return height;
        }
        db(view);
        return view.getMeasuredHeight();
    }

    private int dy(int i, int i2) {
        getDividerHeight();
        Object obj = (!this.oZH || this.oZF == this.oZG) ? null : 1;
        int i3 = this.oZS - this.oZR;
        int i4 = (int) (this.par * ((float) i3));
        if (i == this.oZI) {
            if (this.oZI == this.oZF) {
                if (obj != null) {
                    return i4 + this.oZR;
                }
                return this.oZS;
            } else if (this.oZI == this.oZG) {
                return this.oZS - i4;
            } else {
                return this.oZR;
            }
        } else if (i == this.oZF) {
            if (obj != null) {
                return i2 + i4;
            }
            return i2 + i3;
        } else if (i == this.oZG) {
            return (i2 + i3) - i4;
        } else {
            return i2;
        }
    }

    public void requestLayout() {
        if (!this.pav) {
            super.requestLayout();
        }
    }

    private void db(View view) {
        int makeMeasureSpec;
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new LayoutParams(-1, -2);
            view.setLayoutParams(layoutParams);
        }
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(this.oZU, getListPaddingLeft() + getListPaddingRight(), layoutParams.width);
        if (layoutParams.height > 0) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        view.measure(childMeasureSpec, makeMeasureSpec);
    }

    private void bKb() {
        if (this.oZx != null) {
            db(this.oZx);
            this.oZS = this.oZx.getMeasuredHeight();
            this.oZT = this.oZS / 2;
        }
    }

    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.oZx != null) {
            if (this.oZx.isLayoutRequested()) {
                bKb();
            }
            this.oZB = true;
        }
        this.oZU = i;
    }

    protected void layoutChildren() {
        super.layoutChildren();
        if (this.oZx != null) {
            if (this.oZx.isLayoutRequested() && !this.oZB) {
                bKb();
            }
            this.oZx.layout(0, 0, this.oZx.getMeasuredWidth(), this.oZx.getMeasuredHeight());
            this.oZB = false;
        }
    }

    public final boolean a(int i, View view, int i2, int i3, int i4) {
        if (this.DU != 0 || !this.pam || this.oZx != null || view == null || !this.oZQ) {
            return false;
        }
        if (getParent() != null) {
            getParent().requestDisallowInterceptTouchEvent(true);
        }
        int headerViewsCount = getHeaderViewsCount() + i;
        this.oZF = headerViewsCount;
        this.oZG = headerViewsCount;
        this.oZI = headerViewsCount;
        this.oZE = headerViewsCount;
        this.DU = 4;
        this.pak = 0;
        this.pak |= i2;
        this.oZx = view;
        bKb();
        this.oZJ = i3;
        this.oZK = i4;
        this.paj = this.pai;
        this.oZy.x = this.pah - this.oZJ;
        this.oZy.y = this.pai - this.oZK;
        View childAt = getChildAt(this.oZI - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setVisibility(4);
        }
        if (this.pat) {
            e eVar = this.pau;
            eVar.vA.append("<DSLVStates>\n");
            eVar.paS = 0;
            eVar.paT = true;
        }
        switch (this.pap) {
            case 1:
                super.onTouchEvent(this.pao);
                break;
            case 2:
                super.onInterceptTouchEvent(this.pao);
                break;
        }
        requestLayout();
        if (this.paz == null) {
            return true;
        }
        this.paz.start();
        return true;
    }

    private void kp(boolean z) {
        int firstVisiblePosition = getFirstVisiblePosition() + (getChildCount() / 2);
        View childAt = getChildAt(getChildCount() / 2);
        if (childAt != null) {
            c(firstVisiblePosition, childAt, true);
        }
    }

    private void c(int i, View view, boolean z) {
        int count;
        Object obj;
        Object obj2;
        this.pav = true;
        if (this.pan != null) {
            this.oZz.set(this.pah, this.pai);
            this.pan.d(this.oZy);
        }
        int i2 = this.oZy.x;
        int i3 = this.oZy.y;
        int paddingLeft = getPaddingLeft();
        if ((this.pak & 1) == 0 && i2 > paddingLeft) {
            this.oZy.x = paddingLeft;
        } else if ((this.pak & 2) == 0 && i2 < paddingLeft) {
            this.oZy.x = paddingLeft;
        }
        paddingLeft = getHeaderViewsCount();
        int footerViewsCount = getFooterViewsCount();
        int firstVisiblePosition = getFirstVisiblePosition();
        int lastVisiblePosition = getLastVisiblePosition();
        i2 = getPaddingTop();
        if (firstVisiblePosition < paddingLeft) {
            i2 = getChildAt((paddingLeft - firstVisiblePosition) - 1).getBottom();
        }
        if ((this.pak & 8) == 0 && firstVisiblePosition <= this.oZI) {
            i2 = Math.max(getChildAt(this.oZI - firstVisiblePosition).getTop(), i2);
        }
        paddingLeft = getHeight() - getPaddingBottom();
        if (lastVisiblePosition >= (getCount() - footerViewsCount) - 1) {
            paddingLeft = getChildAt(((getCount() - footerViewsCount) - 1) - firstVisiblePosition).getBottom();
        }
        if ((this.pak & 4) == 0 && lastVisiblePosition >= this.oZI) {
            paddingLeft = Math.min(getChildAt(this.oZI - firstVisiblePosition).getBottom(), paddingLeft);
        }
        if (i3 < i2) {
            this.oZy.y = i2;
        } else if (this.oZS + i3 > paddingLeft) {
            this.oZy.y = paddingLeft - this.oZS;
        }
        this.oZA = this.oZy.y + this.oZT;
        int i4 = this.oZF;
        int i5 = this.oZG;
        i3 = getFirstVisiblePosition();
        paddingLeft = this.oZF;
        View childAt = getChildAt(paddingLeft - i3);
        if (childAt == null) {
            paddingLeft = i3 + (getChildCount() / 2);
            childAt = getChildAt(paddingLeft - i3);
        }
        footerViewsCount = childAt.getTop();
        i2 = childAt.getHeight();
        i3 = dx(paddingLeft, footerViewsCount);
        lastVisiblePosition = getDividerHeight();
        if (this.oZA >= i3) {
            count = getCount();
            firstVisiblePosition = footerViewsCount;
            footerViewsCount = i2;
            i2 = paddingLeft;
            paddingLeft = i3;
            while (i2 < count) {
                if (i2 != count - 1) {
                    firstVisiblePosition += lastVisiblePosition + footerViewsCount;
                    footerViewsCount = yq(i2 + 1);
                    i3 = dx(i2 + 1, firstVisiblePosition);
                    if (this.oZA < i3) {
                        break;
                    }
                    i2++;
                    paddingLeft = i3;
                } else {
                    i3 = (firstVisiblePosition + lastVisiblePosition) + footerViewsCount;
                    break;
                }
            }
        }
        i2 = paddingLeft;
        paddingLeft = i3;
        while (i2 >= 0) {
            i2--;
            i3 = yq(i2);
            if (i2 != 0) {
                footerViewsCount -= i3 + lastVisiblePosition;
                i3 = dx(i2, footerViewsCount);
                if (this.oZA >= i3) {
                    break;
                }
                paddingLeft = i3;
            } else {
                i3 = (footerViewsCount - lastVisiblePosition) - i3;
                break;
            }
        }
        footerViewsCount = getHeaderViewsCount();
        lastVisiblePosition = getFooterViewsCount();
        count = this.oZF;
        int i6 = this.oZG;
        float f = this.par;
        if (this.oZH) {
            int abs = Math.abs(i3 - paddingLeft);
            if (this.oZA >= i3) {
                int i7 = i3;
                i3 = paddingLeft;
                paddingLeft = i7;
            }
            abs = (int) (((float) abs) * (0.5f * this.paq));
            float f2 = (float) abs;
            paddingLeft += abs;
            abs = i3 - abs;
            if (this.oZA < paddingLeft) {
                this.oZF = i2 - 1;
                this.oZG = i2;
                this.par = (((float) (paddingLeft - this.oZA)) * 0.5f) / f2;
            } else if (this.oZA >= abs) {
                this.oZF = i2;
                this.oZG = i2 + 1;
                this.par = 0.5f * ((((float) (i3 - this.oZA)) / f2) + 1.0f);
            }
            if (this.oZF < footerViewsCount) {
                this.oZF = footerViewsCount;
                this.oZG = footerViewsCount;
                i2 = footerViewsCount;
            } else if (this.oZG >= getCount() - lastVisiblePosition) {
                i2 = (getCount() - lastVisiblePosition) - 1;
                this.oZF = i2;
                this.oZG = i2;
            }
            if (this.oZF != count && this.oZG == i6 && this.par == f) {
                obj = null;
            } else {
                obj = 1;
            }
            if (i2 == this.oZE) {
                this.oZE = i2;
                obj2 = 1;
            } else {
                obj2 = obj;
            }
            if (obj2 != null) {
                bKa();
                i3 = ys(i);
                paddingLeft = view.getHeight();
                footerViewsCount = dy(i, i3);
                if (i == this.oZI) {
                    i2 = paddingLeft - i3;
                    i3 = footerViewsCount - i3;
                } else {
                    i2 = paddingLeft;
                    i3 = footerViewsCount;
                }
                lastVisiblePosition = this.oZS;
                if (!(this.oZI == this.oZF || this.oZI == this.oZG)) {
                    lastVisiblePosition -= this.oZR;
                }
                if (i <= i4) {
                    if (i > this.oZF) {
                        i2 = (lastVisiblePosition - i3) + 0;
                    }
                    i2 = 0;
                } else if (i != i5) {
                    i2 = i > this.oZF ? (i2 - lastVisiblePosition) + 0 : i != this.oZG ? (paddingLeft - footerViewsCount) + 0 : i2 + 0;
                } else if (i > this.oZF) {
                    i2 = 0 - lastVisiblePosition;
                } else {
                    if (i == this.oZG) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                }
                setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
                layoutChildren();
            }
            if (obj2 != null || z) {
                invalidate();
            }
            this.pav = false;
        }
        this.oZF = i2;
        this.oZG = i2;
        if (this.oZF < footerViewsCount) {
            this.oZF = footerViewsCount;
            this.oZG = footerViewsCount;
            i2 = footerViewsCount;
        } else if (this.oZG >= getCount() - lastVisiblePosition) {
            i2 = (getCount() - lastVisiblePosition) - 1;
            this.oZF = i2;
            this.oZG = i2;
        }
        if (this.oZF != count) {
        }
        obj = 1;
        if (i2 == this.oZE) {
            obj2 = obj;
        } else {
            this.oZE = i2;
            obj2 = 1;
        }
        if (obj2 != null) {
            bKa();
            i3 = ys(i);
            paddingLeft = view.getHeight();
            footerViewsCount = dy(i, i3);
            if (i == this.oZI) {
                i2 = paddingLeft;
                i3 = footerViewsCount;
            } else {
                i2 = paddingLeft - i3;
                i3 = footerViewsCount - i3;
            }
            lastVisiblePosition = this.oZS;
            lastVisiblePosition -= this.oZR;
            if (i <= i4) {
                if (i > this.oZF) {
                    i2 = (lastVisiblePosition - i3) + 0;
                }
                i2 = 0;
            } else if (i != i5) {
                if (i > this.oZF) {
                    if (i == this.oZG) {
                        i2 = 0 - i3;
                    }
                    i2 = 0;
                } else {
                    i2 = 0 - lastVisiblePosition;
                }
            } else if (i > this.oZF) {
                if (i != this.oZG) {
                }
            }
            setSelectionFromTop(i, (i2 + view.getTop()) - getPaddingTop());
            layoutChildren();
        }
        invalidate();
        this.pav = false;
    }

    private void bKc() {
        if (this.oZx != null) {
            this.oZx.setVisibility(8);
            if (this.pan != null) {
                this.pan.dc(this.oZx);
            }
            this.oZx = null;
            invalidate();
        }
    }
}
