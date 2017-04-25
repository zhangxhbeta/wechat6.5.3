package android.support.v7.widget;

import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.h;
import android.view.View;

public abstract class ab {
    protected final h XX;
    int XY;

    static class AnonymousClass1 extends ab {
        AnonymousClass1(h hVar) {
            super(hVar);
        }

        public final int fo() {
            return this.XX.Zx - this.XX.getPaddingRight();
        }

        public final int getEnd() {
            return this.XX.Zx;
        }

        public final void aW(int i) {
            this.XX.aY(i);
        }

        public final int fn() {
            return this.XX.getPaddingLeft();
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bf(view) + layoutParams.leftMargin);
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bg(view) + layoutParams.topMargin);
        }

        public final int aV(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + h.bj(view);
        }

        public final int aU(View view) {
            return h.bh(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
        }

        public final int fp() {
            return (this.XX.Zx - this.XX.getPaddingLeft()) - this.XX.getPaddingRight();
        }

        public final int getEndPadding() {
            return this.XX.getPaddingRight();
        }

        public final int getMode() {
            return this.XX.Zv;
        }

        public final int fq() {
            return this.XX.Zw;
        }
    }

    static class AnonymousClass2 extends ab {
        AnonymousClass2(h hVar) {
            super(hVar);
        }

        public final int fo() {
            return this.XX.QW - this.XX.getPaddingBottom();
        }

        public final int getEnd() {
            return this.XX.QW;
        }

        public final void aW(int i) {
            this.XX.aZ(i);
        }

        public final int fn() {
            return this.XX.getPaddingTop();
        }

        public final int aW(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + (h.bg(view) + layoutParams.topMargin);
        }

        public final int aX(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.rightMargin + (h.bf(view) + layoutParams.leftMargin);
        }

        public final int aV(View view) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            return layoutParams.bottomMargin + h.bk(view);
        }

        public final int aU(View view) {
            return h.bi(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
        }

        public final int fp() {
            return (this.XX.QW - this.XX.getPaddingTop()) - this.XX.getPaddingBottom();
        }

        public final int getEndPadding() {
            return this.XX.getPaddingBottom();
        }

        public final int getMode() {
            return this.XX.Zw;
        }

        public final int fq() {
            return this.XX.Zv;
        }
    }

    public abstract int aU(View view);

    public abstract int aV(View view);

    public abstract int aW(View view);

    public abstract void aW(int i);

    public abstract int aX(View view);

    public abstract int fn();

    public abstract int fo();

    public abstract int fp();

    public abstract int fq();

    public abstract int getEnd();

    public abstract int getEndPadding();

    public abstract int getMode();

    private ab(h hVar) {
        this.XY = Integer.MIN_VALUE;
        this.XX = hVar;
    }

    public final int fm() {
        return Integer.MIN_VALUE == this.XY ? 0 : fp() - this.XY;
    }
}
