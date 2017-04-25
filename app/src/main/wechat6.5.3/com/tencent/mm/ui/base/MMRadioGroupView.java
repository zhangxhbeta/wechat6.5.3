package com.tencent.mm.ui.base;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewGroup.OnHierarchyChangeListener;
import android.widget.LinearLayout;

public class MMRadioGroupView extends LinearLayout {
    private int nXB = -1;
    private int nXC = -1;
    private com.tencent.mm.ui.base.MMRadioImageButton.a nXD = new a(this);
    private b nXE = new b();
    private MMRadioImageButton nXF;
    private c nXG;

    private class b implements OnHierarchyChangeListener {
        private OnHierarchyChangeListener hq;
        final /* synthetic */ MMRadioGroupView nXH;

        private b(MMRadioGroupView mMRadioGroupView) {
            this.nXH = mMRadioGroupView;
        }

        public final void onChildViewAdded(View view, View view2) {
            if (view == this.nXH && (view2 instanceof MMRadioImageButton)) {
                if (view2.getId() == -1) {
                    int hashCode = view2.hashCode();
                    if (hashCode < 0) {
                        hashCode &= Integer.MAX_VALUE;
                    }
                    view2.setId(hashCode);
                }
                ((MMRadioImageButton) view2).nXM = this.nXH.nXD;
            }
            if (this.hq != null) {
                this.hq.onChildViewAdded(view, view2);
            }
        }

        public final void onChildViewRemoved(View view, View view2) {
            if (view == this.nXH && (view2 instanceof MMRadioImageButton)) {
                ((MMRadioImageButton) view2).nXM = null;
            }
            if (this.hq != null) {
                this.hq.onChildViewRemoved(view, view2);
            }
        }
    }

    public interface c {
        void jX(int i);
    }

    class a implements com.tencent.mm.ui.base.MMRadioImageButton.a {
        final /* synthetic */ MMRadioGroupView nXH;

        a(MMRadioGroupView mMRadioGroupView) {
            this.nXH = mMRadioGroupView;
        }

        public final void a(MMRadioImageButton mMRadioImageButton) {
            if (this.nXH.nXB != -1) {
                this.nXH.W(this.nXH.nXB, false);
            }
            int id = mMRadioImageButton.getId();
            this.nXH.nXF = mMRadioImageButton;
            this.nXH.nXB = id;
        }

        public final void b(MMRadioImageButton mMRadioImageButton) {
            this.nXH.nXC = mMRadioImageButton.getId();
        }
    }

    public MMRadioGroupView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        super.setOnHierarchyChangeListener(this.nXE);
    }

    protected void onFinishInflate() {
        super.onFinishInflate();
        if (this.nXB != -1) {
            W(this.nXB, true);
            this.nXB = this.nXB;
        }
    }

    public void addView(View view, int i, LayoutParams layoutParams) {
        if (view instanceof MMRadioImageButton) {
            MMRadioImageButton mMRadioImageButton = (MMRadioImageButton) view;
            if (mMRadioImageButton.isChecked()) {
                if (this.nXB != -1) {
                    W(this.nXB, false);
                }
                this.nXB = mMRadioImageButton.getId();
                this.nXF = mMRadioImageButton;
            }
        }
        super.addView(view, i, layoutParams);
    }

    private void W(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof MMRadioImageButton)) {
            ((MMRadioImageButton) findViewById).setChecked(z);
        }
    }

    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if ((i > 0 || i2 > 0) && this.nXG != null) {
            this.nXG.jX(i);
        }
    }
}
