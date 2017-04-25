package com.tencent.mm.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils.TruncateAt;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mm.bd.a;
import com.tencent.mm.sdk.platformtools.BackwardSupportUtil.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.ui.tools.s;

public class MMTabView extends ViewGroup {
    private TextView dtY;
    public int iJK;
    private int index;
    private TextView nDv;
    private ImageView nFS;
    private int padding;

    public MMTabView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.iJK = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.iJK = 3;
        this.padding = 0;
        init();
    }

    private MMTabView(Context context) {
        super(context);
        this.iJK = 3;
        this.padding = 0;
        init();
    }

    public MMTabView(Context context, int i) {
        this(context);
        this.index = i;
        bAt();
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void bAt() {
        /*
        r10 = this;
        r9 = 2;
        r8 = 1;
        r1 = 0;
        r0 = "MicroMsg.MMTabView";
        r2 = "jacks build : %d desc, unread: %s";
        r3 = new java.lang.Object[r9];
        r4 = r10.index;
        r4 = java.lang.Integer.valueOf(r4);
        r3[r1] = r4;
        r4 = r10.bAu();
        r3[r8] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r0, r2, r3);
        r2 = com.tencent.mm.ui.a.a.a.bAK();
        r0 = r10.dtY;
        r0 = r0.getText();
        r0 = r0.toString();
        r3 = r10.bAu();
        r4 = r10.index;
        r5 = r2.bAJ();
        if (r5 == 0) goto L_0x0042;
    L_0x0036:
        if (r10 == 0) goto L_0x0042;
    L_0x0038:
        r5 = com.tencent.mm.sdk.platformtools.be.kS(r0);
        if (r5 != 0) goto L_0x0042;
    L_0x003e:
        r5 = r2.aHq;
        if (r5 != 0) goto L_0x0043;
    L_0x0042:
        return;
    L_0x0043:
        r5 = new com.tencent.mm.ui.a.b;
        r5.<init>();
        r5.Of(r0);
        r0 = com.tencent.mm.sdk.platformtools.be.kS(r3);
        if (r0 != 0) goto L_0x0099;
    L_0x0051:
        r0 = 0;
        r0 = com.tencent.mm.sdk.platformtools.be.getInt(r3, r0);	 Catch:{ Exception -> 0x0098 }
        if (r0 <= 0) goto L_0x0099;
    L_0x0058:
        if (r0 <= 0) goto L_0x0072;
    L_0x005a:
        r3 = r2.aHq;
        r3 = r3.getResources();
        r6 = 2131361821; // 0x7f0a001d float:1.8343405E38 double:1.0530326546E-314;
        r7 = new java.lang.Object[r8];
        r0 = java.lang.Integer.valueOf(r0);
        r7[r1] = r0;
        r0 = r3.getQuantityString(r6, r8, r7);
        r5.Of(r0);
    L_0x0072:
        r0 = r2.aHq;
        r0 = r0.getResources();
        r2 = 2131361822; // 0x7f0a001e float:1.8343407E38 double:1.053032655E-314;
        r3 = 5;
        r6 = new java.lang.Object[r9];
        r7 = 3;
        r7 = java.lang.Integer.valueOf(r7);
        r6[r1] = r7;
        r1 = r4 + 1;
        r1 = java.lang.Integer.valueOf(r1);
        r6[r8] = r1;
        r0 = r0.getQuantityString(r2, r3, r6);
        r5.Of(r0);
        r5.cy(r10);
        goto L_0x0042;
    L_0x0098:
        r0 = move-exception;
    L_0x0099:
        r0 = r1;
        goto L_0x0058;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.ui.MMTabView.bAt():void");
    }

    private void init() {
        int a;
        this.padding = getResources().getDimensionPixelSize(2131493203);
        String bsY = u.bsY();
        boolean bsU = u.bsU();
        boolean equalsIgnoreCase = bsY.equalsIgnoreCase("en");
        if (bsU) {
            a = b.a(getContext(), 2.0f);
        } else {
            a = 0;
        }
        this.dtY = new TextView(getContext());
        this.dtY.setSingleLine();
        this.dtY.setEllipsize(TruncateAt.END);
        this.dtY.setTextColor(getResources().getColorStateList(2131690123));
        this.dtY.setTextSize(0, a.ds(getContext()) * ((float) getResources().getDimensionPixelSize(2131493128)));
        this.dtY.setText(2131233727);
        if (bsU) {
            this.dtY.setTextSize(0, (((float) a) + this.dtY.getTextSize()) * a.ds(getContext()));
            this.dtY.setTypeface(null, 0);
        } else if (equalsIgnoreCase) {
            this.dtY.setTypeface(null, 1);
        }
        addView(this.dtY);
        this.nFS = new ImageView(getContext());
        this.nFS.setBackgroundResource(2130839358);
        this.nFS.setVisibility(4);
        addView(this.nFS);
        this.nDv = new TextView(getContext());
        this.nDv.setTextColor(getResources().getColor(2131690127));
        this.nDv.setTextSize(1, 11.0f);
        this.nDv.setBackgroundResource(s.eN(getContext()));
        this.nDv.setTypeface(Typeface.DEFAULT_BOLD);
        this.nDv.setGravity(17);
        this.nDv.setVisibility(4);
        addView(this.nDv);
        setBackgroundResource(2130838472);
    }

    public final void setText(int i) {
        this.dtY.setText(i);
    }

    public final void setTextColor(ColorStateList colorStateList) {
        this.dtY.setTextColor(colorStateList);
    }

    private String bAu() {
        return this.nDv.getText().toString();
    }

    public final void Ob(final String str) {
        if (be.kS(str)) {
            this.nDv.setVisibility(4);
            return;
        }
        this.nDv.setVisibility(0);
        this.nDv.post(new Runnable(this) {
            final /* synthetic */ MMTabView nFU;

            public final void run() {
                this.nFU.nDv.setText(str);
                this.nFU.bAt();
            }
        });
    }

    public final void iZ(boolean z) {
        this.nFS.setVisibility(z ? 0 : 4);
    }

    protected void onMeasure(int i, int i2) {
        int makeMeasureSpec;
        int size = (MeasureSpec.getSize(i) - getPaddingLeft()) - getPaddingRight();
        int size2 = (MeasureSpec.getSize(i2) - getPaddingTop()) - getPaddingBottom();
        if (MeasureSpec.getMode(i2) == Integer.MIN_VALUE) {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(size2, Integer.MIN_VALUE);
        } else {
            makeMeasureSpec = MeasureSpec.makeMeasureSpec(0, 0);
        }
        this.dtY.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.nFS.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        this.nDv.measure(MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE), makeMeasureSpec);
        setMeasuredDimension(size, size2);
    }

    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5 = i3 - i;
        int i6 = i4 - i2;
        int measuredWidth = (i5 - this.dtY.getMeasuredWidth()) / 2;
        int measuredWidth2 = this.dtY.getMeasuredWidth() + measuredWidth;
        int measuredHeight = (i6 - this.dtY.getMeasuredHeight()) / 2;
        this.dtY.layout(measuredWidth, measuredHeight, measuredWidth2, this.dtY.getMeasuredHeight() + measuredHeight);
        measuredHeight = this.padding + measuredWidth2;
        int measuredHeight2 = (i6 - this.nFS.getMeasuredHeight()) / 2;
        this.nFS.layout(measuredHeight, measuredHeight2, this.nFS.getMeasuredWidth() + measuredHeight, this.nFS.getMeasuredHeight() + measuredHeight2);
        if (measuredWidth - this.padding < this.nDv.getMeasuredWidth()) {
            i5 -= this.nDv.getMeasuredWidth();
            i6 = (i6 - this.nDv.getMeasuredHeight()) / 2;
            this.nDv.layout(i5, i6, this.nDv.getMeasuredWidth() + i5, this.nDv.getMeasuredHeight() + i6);
            return;
        }
        i5 = this.padding + measuredWidth2;
        i6 = (i6 - this.nDv.getMeasuredHeight()) / 2;
        this.nDv.layout(i5, i6, this.nDv.getMeasuredWidth() + i5, this.nDv.getMeasuredHeight() + i6);
    }
}
