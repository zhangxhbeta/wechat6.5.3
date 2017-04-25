package com.tencent.mm.plugin.sns.ui;

import android.view.View.OnTouchListener;
import android.widget.TextView;
import com.tencent.mm.pluginsdk.ui.d.j;

public final class y implements OnTouchListener {
    private static j jHa;
    private static TextView jHb;

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r10, android.view.MotionEvent r11) {
        /*
        r9 = this;
        r8 = 2;
        r5 = 1;
        r4 = 0;
        r10 = (android.widget.TextView) r10;
        r10.getTag();
        r1 = r10.getText();
        r0 = r10.getLayout();
        if (r0 != 0) goto L_0x001f;
    L_0x0012:
        r2 = r10 instanceof com.tencent.mm.kiss.widget.textview.SysTextView;
        if (r2 == 0) goto L_0x001f;
    L_0x0016:
        r0 = r10;
        r0 = (com.tencent.mm.kiss.widget.textview.SysTextView) r0;
        r0 = r0.cmr;
        r0 = r0.vQ();
    L_0x001f:
        r2 = r1 instanceof android.text.Spannable;
        if (r2 == 0) goto L_0x0163;
    L_0x0023:
        if (r0 == 0) goto L_0x0163;
    L_0x0025:
        r0 = r1;
        r0 = (android.text.Spannable) r0;
        r3 = r11.getAction();
        r1 = r10.getLayout();
        if (r1 != 0) goto L_0x0166;
    L_0x0032:
        r2 = r10 instanceof com.tencent.mm.kiss.widget.textview.SysTextView;
        if (r2 == 0) goto L_0x0166;
    L_0x0036:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.SysTextView) r1;
        r1 = r1.cmr;
        r1 = r1.vQ();
        r2 = r1;
    L_0x0040:
        r10.invalidate();
        if (r3 == r5) goto L_0x0049;
    L_0x0045:
        if (r3 == 0) goto L_0x0049;
    L_0x0047:
        if (r3 != r8) goto L_0x015d;
    L_0x0049:
        r1 = r11.getX();
        r3 = (int) r1;
        r1 = r11.getY();
        r6 = (int) r1;
        r1 = r10 instanceof com.tencent.mm.kiss.widget.textview.PLSysTextView;
        if (r1 == 0) goto L_0x0089;
    L_0x0057:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.vI();
        if (r3 < r1) goto L_0x006e;
    L_0x0060:
        r7 = r2.getWidth();
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.vI();
        r1 = r1 + r7;
        if (r3 <= r1) goto L_0x0070;
    L_0x006e:
        r0 = r4;
    L_0x006f:
        return r0;
    L_0x0070:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.vJ();
        if (r6 < r1) goto L_0x0087;
    L_0x0079:
        r7 = r2.getHeight();
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.vJ();
        r1 = r1 + r7;
        if (r6 <= r1) goto L_0x00b3;
    L_0x0087:
        r0 = r4;
        goto L_0x006f;
    L_0x0089:
        r1 = r10 instanceof android.widget.TextView;
        if (r1 == 0) goto L_0x00b3;
    L_0x008d:
        r1 = r10.getTotalPaddingLeft();
        if (r3 < r1) goto L_0x009e;
    L_0x0093:
        r1 = r2.getWidth();
        r7 = r10.getTotalPaddingLeft();
        r1 = r1 + r7;
        if (r3 <= r1) goto L_0x00a0;
    L_0x009e:
        r0 = r4;
        goto L_0x006f;
    L_0x00a0:
        r1 = r10.getTotalPaddingTop();
        if (r6 < r1) goto L_0x00b1;
    L_0x00a6:
        r1 = r2.getHeight();
        r7 = r10.getTotalPaddingTop();
        r1 = r1 + r7;
        if (r6 <= r1) goto L_0x00b3;
    L_0x00b1:
        r0 = r4;
        goto L_0x006f;
    L_0x00b3:
        r1 = r10 instanceof com.tencent.mm.kiss.widget.textview.PLSysTextView;
        if (r1 == 0) goto L_0x0123;
    L_0x00b7:
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.vI();
        r3 = r3 - r1;
        r1 = r10;
        r1 = (com.tencent.mm.kiss.widget.textview.PLSysTextView) r1;
        r1 = r1.vJ();
        r1 = r6 - r1;
    L_0x00c8:
        r6 = r10.getScrollX();
        r3 = r3 + r6;
        r6 = r10.getScrollY();
        r1 = r1 + r6;
        r1 = r2.getLineForVertical(r1);
        r3 = (float) r3;
        r1 = r2.getOffsetForHorizontal(r1, r3);
        r2 = r11.getAction();
        r3 = com.tencent.mm.pluginsdk.ui.d.j.class;
        r0 = r0.getSpans(r1, r1, r3);
        r0 = (com.tencent.mm.pluginsdk.ui.d.j[]) r0;
        r1 = r0.length;
        r1 = r1 + -1;
        r3 = "MicroMsg.MMOnTouchListener";
        r6 = new java.lang.StringBuilder;
        r7 = " action span Len: ";
        r6.<init>(r7);
        r7 = r0.length;
        r6 = r6.append(r7);
        r6 = r6.toString();
        com.tencent.mm.sdk.platformtools.v.d(r3, r6);
        r10.getLayout();
        r3 = r0.length;
        if (r3 == 0) goto L_0x0158;
    L_0x0107:
        if (r2 != r5) goto L_0x013f;
    L_0x0109:
        r0 = r0[r1];
        r0.onClick(r10);
        r0 = new com.tencent.mm.sdk.platformtools.ac;
        r0.<init>();
        r1 = new com.tencent.mm.plugin.sns.ui.y$1;
        r1.<init>(r9);
        r2 = 300; // 0x12c float:4.2E-43 double:1.48E-321;
        r0.postDelayed(r1, r2);
        r0 = r5;
    L_0x011e:
        if (r0 == 0) goto L_0x015d;
    L_0x0120:
        r0 = r5;
        goto L_0x006f;
    L_0x0123:
        r1 = r10 instanceof android.widget.TextView;
        if (r1 == 0) goto L_0x0133;
    L_0x0127:
        r1 = r10.getTotalPaddingLeft();
        r3 = r3 - r1;
        r1 = r10.getTotalPaddingTop();
        r1 = r6 - r1;
        goto L_0x00c8;
    L_0x0133:
        r1 = r10.getPaddingLeft();
        r3 = r3 - r1;
        r1 = r10.getPaddingTop();
        r1 = r6 - r1;
        goto L_0x00c8;
    L_0x013f:
        if (r2 == 0) goto L_0x0146;
    L_0x0141:
        if (r2 == r8) goto L_0x0146;
    L_0x0143:
        r3 = 3;
        if (r2 != r3) goto L_0x015b;
    L_0x0146:
        aVR();
        r2 = r0[r1];
        jHa = r2;
        jHb = r10;
        r0 = r0[r1];
        r0.hsl = r5;
        r10.invalidate();
        r0 = r5;
        goto L_0x011e;
    L_0x0158:
        aVR();
    L_0x015b:
        r0 = r4;
        goto L_0x011e;
    L_0x015d:
        aVR();
        r0 = r4;
        goto L_0x006f;
    L_0x0163:
        r0 = r4;
        goto L_0x006f;
    L_0x0166:
        r2 = r1;
        goto L_0x0040;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.y.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    public static void aVR() {
        if (jHa != null) {
            jHa.hsl = false;
            jHb.invalidate();
            jHb = null;
            jHa = null;
        }
    }
}
