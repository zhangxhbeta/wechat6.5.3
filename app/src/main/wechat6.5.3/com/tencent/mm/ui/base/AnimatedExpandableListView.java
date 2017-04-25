package com.tencent.mm.ui.base;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.Transformation;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import com.tencent.mm.plugin.appbrand.jsapi.br;
import java.util.ArrayList;
import java.util.List;

public class AnimatedExpandableListView extends ExpandableListView {
    private static final String TAG = a.class.getSimpleName();
    private a nSj;

    public static abstract class a extends BaseExpandableListAdapter {
        private SparseArray<d> nSk = new SparseArray();
        private AnimatedExpandableListView nSl;

        public abstract View a(int i, int i2, View view);

        public abstract int rb(int i);

        static /* synthetic */ void a(a aVar, int i) {
            d wb = aVar.wb(i);
            wb.ghd = true;
            wb.nSw = 0;
            wb.nSv = true;
        }

        static /* synthetic */ void a(a aVar, int i, int i2) {
            d wb = aVar.wb(i);
            wb.ghd = true;
            wb.nSw = i2;
            wb.nSv = false;
        }

        final d wb(int i) {
            d dVar = (d) this.nSk.get(i);
            if (dVar != null) {
                return dVar;
            }
            dVar = new d();
            this.nSk.put(i, dVar);
            return dVar;
        }

        public final int getChildType(int i, int i2) {
            if (wb(i).ghd) {
                return 0;
            }
            return 1;
        }

        public final int getChildTypeCount() {
            return 2;
        }

        public final View getChildView(final int i, int i2, boolean z, View view, ViewGroup viewGroup) {
            d wb = wb(i);
            if (!wb.ghd) {
                return a(i, i2, view);
            }
            View view2;
            if (view instanceof b) {
                view2 = view;
            } else {
                view2 = new b(viewGroup.getContext());
                view2.setLayoutParams(new LayoutParams(-1, 0));
            }
            if (i2 < wb.nSw) {
                view2.getLayoutParams().height = 0;
                return view2;
            }
            int i3;
            final ExpandableListView expandableListView = (ExpandableListView) viewGroup;
            final b bVar = (b) view2;
            bVar.nSq.clear();
            Drawable divider = expandableListView.getDivider();
            int measuredWidth = viewGroup.getMeasuredWidth();
            int dividerHeight = expandableListView.getDividerHeight();
            if (divider != null) {
                bVar.nHE = divider;
                bVar.nSr = measuredWidth;
                bVar.dividerHeight = dividerHeight;
                divider.setBounds(0, 0, measuredWidth, dividerHeight);
            }
            measuredWidth = MeasureSpec.makeMeasureSpec(viewGroup.getWidth(), 1073741824);
            int makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
            dividerHeight = 0;
            int height = viewGroup.getHeight();
            int rb = rb(i);
            for (i3 = wb.nSw; i3 < rb; i3++) {
                View a = a(i, i3, null);
                a.measure(measuredWidth, makeMeasureSpec);
                dividerHeight += a.getMeasuredHeight();
                if (dividerHeight >= height) {
                    bVar.cA(a);
                    dividerHeight += ((rb - i3) - 1) * (dividerHeight / (i3 + 1));
                    break;
                }
                bVar.cA(a);
            }
            Object tag = bVar.getTag();
            if (tag == null) {
                i3 = 0;
            } else {
                i3 = ((Integer) tag).intValue();
            }
            Animation cVar;
            if (wb.nSv && r2 != 1) {
                cVar = new c(bVar, 0, dividerHeight, wb);
                br.CTRL_INDEX;
                cVar.setDuration(150);
                cVar.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a nSn;

                    public final void onAnimationEnd(Animation animation) {
                        this.nSn.wb(i).ghd = false;
                        this.nSn.notifyDataSetChanged();
                        bVar.setTag(Integer.valueOf(0));
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(1));
                return view2;
            } else if (wb.nSv || r2 == 2) {
                return view2;
            } else {
                if (wb.nSx == -1) {
                    wb.nSx = dividerHeight;
                }
                cVar = new c(bVar, wb.nSx, 0, wb);
                br.CTRL_INDEX;
                cVar.setDuration(150);
                rb = i;
                final d dVar = wb;
                final b bVar2 = bVar;
                cVar.setAnimationListener(new AnimationListener(this) {
                    final /* synthetic */ a nSn;

                    public final void onAnimationEnd(Animation animation) {
                        this.nSn.wb(rb).ghd = false;
                        expandableListView.collapseGroup(rb);
                        this.nSn.notifyDataSetChanged();
                        dVar.nSx = -1;
                        bVar2.setTag(Integer.valueOf(0));
                    }

                    public final void onAnimationRepeat(Animation animation) {
                    }

                    public final void onAnimationStart(Animation animation) {
                    }
                });
                bVar.startAnimation(cVar);
                bVar.setTag(Integer.valueOf(2));
                return view2;
            }
        }

        public final int getChildrenCount(int i) {
            d wb = wb(i);
            if (wb.ghd) {
                return wb.nSw + 1;
            }
            return rb(i);
        }
    }

    private static class b extends View {
        int dividerHeight;
        Drawable nHE;
        List<View> nSq = new ArrayList();
        int nSr;

        public b(Context context) {
            super(context);
        }

        public final void cA(View view) {
            view.layout(0, 0, getWidth(), getHeight());
            this.nSq.add(view);
        }

        protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
            super.onLayout(z, i, i2, i3, i4);
            int size = this.nSq.size();
            for (int i5 = 0; i5 < size; i5++) {
                ((View) this.nSq.get(i5)).layout(i, i2, i3, i4);
            }
        }

        public final void dispatchDraw(Canvas canvas) {
            canvas.save();
            if (this.nHE != null) {
                this.nHE.setBounds(0, 0, this.nSr, this.dividerHeight);
            }
            int size = this.nSq.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.nSq.get(i);
                view.draw(canvas);
                canvas.translate(0.0f, (float) view.getMeasuredHeight());
                if (this.nHE != null) {
                    this.nHE.draw(canvas);
                    canvas.translate(0.0f, (float) this.dividerHeight);
                }
            }
            canvas.restore();
        }
    }

    private static class c extends Animation {
        private int nSs;
        private int nSt;
        private d nSu;
        private View view;

        private c(View view, int i, int i2, d dVar) {
            this.nSs = i;
            this.nSt = i2 - i;
            this.view = view;
            this.nSu = dVar;
            this.view.getLayoutParams().height = i;
            this.view.requestLayout();
        }

        protected final void applyTransformation(float f, Transformation transformation) {
            super.applyTransformation(f, transformation);
            if (f < 1.0f) {
                int i = this.nSs + ((int) (((float) this.nSt) * f));
                this.view.getLayoutParams().height = i;
                this.nSu.nSx = i;
                this.view.requestLayout();
                return;
            }
            i = this.nSs + this.nSt;
            this.view.getLayoutParams().height = i;
            this.nSu.nSx = i;
            this.view.requestLayout();
        }
    }

    private static class d {
        boolean ghd;
        boolean nSv;
        int nSw;
        int nSx;

        private d() {
            this.ghd = false;
            this.nSv = false;
            this.nSx = -1;
        }
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AnimatedExpandableListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setAdapter(ExpandableListAdapter expandableListAdapter) {
        super.setAdapter(expandableListAdapter);
        if (expandableListAdapter instanceof a) {
            this.nSj = (a) expandableListAdapter;
            this.nSj.nSl = this;
            return;
        }
        throw new ClassCastException(expandableListAdapter.toString() + " must implement AnimatedExpandableListAdapter");
    }

    @SuppressLint({"NewApi"})
    public final boolean vZ(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < getChildCount() && getChildAt(flatListPosition).getBottom() >= getBottom()) {
                this.nSj.wb(i).nSx = -1;
                return expandGroup(i);
            }
        }
        a.a(this.nSj, i);
        return expandGroup(i);
    }

    public final boolean wa(int i) {
        int flatListPosition = getFlatListPosition(getPackedPositionForGroup(i));
        if (flatListPosition != -1) {
            flatListPosition -= getFirstVisiblePosition();
            if (flatListPosition < 0 || flatListPosition >= getChildCount()) {
                return collapseGroup(i);
            }
            if (getChildAt(flatListPosition).getBottom() >= getBottom()) {
                return collapseGroup(i);
            }
        }
        long expandableListPosition = getExpandableListPosition(getFirstVisiblePosition());
        flatListPosition = getPackedPositionChild(expandableListPosition);
        int packedPositionGroup = getPackedPositionGroup(expandableListPosition);
        if (flatListPosition == -1 || packedPositionGroup != i) {
            flatListPosition = 0;
        }
        a.a(this.nSj, i, flatListPosition);
        this.nSj.notifyDataSetChanged();
        return isGroupExpanded(i);
    }
}
