package com.tencent.mm.ui.tools.gridviewheaders;

import android.content.Context;
import android.database.DataSetObserver;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class c extends BaseAdapter {
    private static boolean oVH;
    private DataSetObserver AB = new DataSetObserver(this) {
        final /* synthetic */ c oVM;

        {
            this.oVM = r1;
        }

        public final void onChanged() {
            int i = 0;
            c cVar = this.oVM;
            cVar.mCount = 0;
            int bJB = cVar.oVI.bJB();
            if (bJB == 0) {
                cVar.mCount = cVar.oVI.getCount();
            } else {
                while (i < bJB) {
                    cVar.mCount += cVar.oVI.yg(i) + cVar.eZz;
                    i++;
                }
            }
            this.oVM.notifyDataSetChanged();
        }

        public final void onInvalidated() {
            this.oVM.oVK.clear();
            this.oVM.notifyDataSetInvalidated();
        }
    };
    int eZz = 1;
    private final Context mContext;
    int mCount;
    final b oVI;
    private GridHeadersGridView oVJ;
    private final List<View> oVK = new ArrayList();
    private View[] oVL;

    protected class a extends View {
        final /* synthetic */ c oVM;

        public a(c cVar, Context context) {
            this.oVM = cVar;
            super(context);
        }
    }

    protected class b extends FrameLayout {
        final /* synthetic */ c oVM;
        int oVN;
        int oVO;

        public b(c cVar, Context context) {
            this.oVM = cVar;
            super(context);
        }

        protected final void onMeasure(int i, int i2) {
            View view = (View) getTag();
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(generateDefaultLayoutParams());
            }
            if (view.getVisibility() != 8 && view.getMeasuredHeight() == 0) {
                view.measure(MeasureSpec.makeMeasureSpec(this.oVO, 1073741824), MeasureSpec.makeMeasureSpec(0, 0));
            }
            setMeasuredDimension(MeasureSpec.getSize(i), view.getMeasuredHeight());
        }

        protected final LayoutParams generateDefaultLayoutParams() {
            return new LayoutParams(-1, -1);
        }
    }

    protected class c {
        protected int kB;
        final /* synthetic */ c oVM;
        protected int oVP;

        protected c(c cVar, int i, int i2) {
            this.oVM = cVar;
            this.kB = i;
            this.oVP = i2;
        }
    }

    protected class d extends FrameLayout {
        int eZz;
        int kB;
        View[] oVL;
        final /* synthetic */ c oVM;
        private boolean oVQ;

        public d(c cVar, Context context) {
            this.oVM = cVar;
            super(context);
        }

        public final Object getTag() {
            return getChildAt(0).getTag();
        }

        public final Object getTag(int i) {
            return getChildAt(0).getTag(i);
        }

        public final void setTag(int i, Object obj) {
            getChildAt(0).setTag(i, obj);
        }

        public final void setTag(Object obj) {
            getChildAt(0).setTag(obj);
        }

        protected final LayoutParams generateDefaultLayoutParams() {
            return new LayoutParams(-1, -1);
        }

        protected final void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (this.eZz != 1 && this.oVM.oVL != null) {
                if (this.kB % this.eZz == 0 && !this.oVQ) {
                    this.oVQ = true;
                    for (View measure : this.oVL) {
                        measure.measure(i, i2);
                    }
                    this.oVQ = false;
                }
                int measuredHeight = getMeasuredHeight();
                int i3 = measuredHeight;
                for (View view : this.oVL) {
                    if (view != null) {
                        i3 = Math.max(i3, view.getMeasuredHeight());
                    }
                }
                if (i3 != measuredHeight) {
                    super.onMeasure(i, MeasureSpec.makeMeasureSpec(i3, 1073741824));
                }
            }
        }
    }

    public c(Context context, GridHeadersGridView gridHeadersGridView, b bVar) {
        this.mContext = context;
        this.oVI = bVar;
        this.oVJ = gridHeadersGridView;
        bVar.registerDataSetObserver(this.AB);
    }

    public final boolean areAllItemsEnabled() {
        return false;
    }

    public final int getCount() {
        int i = 0;
        this.mCount = 0;
        int bJB = this.oVI.bJB();
        if (bJB == 0) {
            return this.oVI.getCount();
        }
        while (i < bJB) {
            this.mCount += (this.oVI.yg(i) + yi(i)) + this.eZz;
            i++;
        }
        return this.mCount;
    }

    public final Object getItem(int i) {
        c yj = yj(i);
        if (yj.kB == -1 || yj.kB == -2) {
            return null;
        }
        return this.oVI.getItem(yj.kB);
    }

    public final long getItemId(int i) {
        c yj = yj(i);
        if (yj.kB == -2) {
            return -1;
        }
        if (yj.kB == -1) {
            return -2;
        }
        return this.oVI.getItemId(yj.kB);
    }

    public final int getItemViewType(int i) {
        c yj = yj(i);
        if (yj.kB == -2) {
            return 1;
        }
        if (yj.kB == -1) {
            return 0;
        }
        int itemViewType = this.oVI.getItemViewType(yj.kB);
        return itemViewType != -1 ? itemViewType + 2 : itemViewType;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        View childAt;
        View bVar;
        if (view instanceof d) {
            view = (d) view;
            childAt = view.getChildAt(0);
        } else {
            childAt = view;
            view = null;
        }
        c yj = yj(i);
        if (yj.kB == -2) {
            bVar = new b(this, this.mContext);
            bVar.oVO = this.oVJ.getWidth();
            ((b) bVar).oVN = yj.oVP;
            bVar.setTag(this.oVI.a(yj.oVP, (View) bVar.getTag(), viewGroup));
        } else if (yj.kB == -1) {
            childAt = (a) childAt;
            if (childAt == null) {
                childAt = new a(this, this.mContext);
            }
            bVar = childAt;
        } else {
            bVar = this.oVI.getView(yj.kB, childAt, viewGroup);
        }
        if (view == null) {
            view = new d(this, this.mContext);
        }
        view.removeAllViews();
        view.addView(bVar);
        view.kB = i;
        view.eZz = this.eZz;
        this.oVL[i % this.eZz] = view;
        if (i % this.eZz == 0) {
            oVH = true;
            for (int i2 = 1; i2 < this.oVL.length; i2++) {
                this.oVL[i2] = getView(i + i2, null, viewGroup);
            }
            oVH = false;
        }
        view.oVL = this.oVL;
        if (!oVH && (i % this.eZz == this.eZz - 1 || i == getCount() - 1)) {
            yh(this.eZz);
        }
        return view;
    }

    public final int getViewTypeCount() {
        return this.oVI.getViewTypeCount() + 2;
    }

    public final boolean hasStableIds() {
        return this.oVI.hasStableIds();
    }

    public final boolean isEmpty() {
        return this.oVI.isEmpty();
    }

    public final boolean isEnabled(int i) {
        c yj = yj(i);
        if (yj.kB == -1 || yj.kB == -2) {
            return false;
        }
        return this.oVI.isEnabled(yj.kB);
    }

    public final void registerDataSetObserver(DataSetObserver dataSetObserver) {
        this.oVI.registerDataSetObserver(dataSetObserver);
    }

    public final void setNumColumns(int i) {
        this.eZz = i;
        yh(i);
    }

    public final void unregisterDataSetObserver(DataSetObserver dataSetObserver) {
        this.oVI.unregisterDataSetObserver(dataSetObserver);
    }

    private void yh(int i) {
        this.oVL = new View[i];
        Arrays.fill(this.oVL, null);
    }

    private int yi(int i) {
        int yg = this.oVI.yg(i) % this.eZz;
        return yg == 0 ? 0 : this.eZz - yg;
    }

    protected final long jw(int i) {
        return (long) yj(i).oVP;
    }

    protected final View a(int i, View view, ViewGroup viewGroup) {
        if (this.oVI.bJB() == 0) {
            return null;
        }
        return this.oVI.a(yj(i).oVP, view, viewGroup);
    }

    protected final c yj(int i) {
        int i2 = 0;
        int bJB = this.oVI.bJB();
        if (bJB != 0) {
            int i3 = i;
            while (i2 < bJB) {
                int yg = this.oVI.yg(i2);
                if (i3 == 0) {
                    return new c(this, -2, i2);
                }
                i3 -= this.eZz;
                if (i3 < 0) {
                    return new c(this, -1, i2);
                }
                int i4 = i - this.eZz;
                if (i3 < yg) {
                    return new c(this, i4, i2);
                }
                int yi = yi(i2);
                i = i4 - yi;
                i2++;
                i3 -= yg + yi;
            }
            return new c(this, -1, i2);
        } else if (i >= this.oVI.getCount()) {
            return new c(this, -1, 0);
        } else {
            return new c(this, i, 0);
        }
    }
}
