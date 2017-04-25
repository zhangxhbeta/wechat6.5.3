package com.tencent.mm.plugin.sns.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

public class KeyboardLinearLayout extends LinearLayout {
    private int QW;
    private boolean gvW;
    private boolean jGq;
    private a jGr;

    public interface a {
    }

    public KeyboardLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.gvW = false;
        this.gvW = false;
        this.QW = 0;
        this.jGq = false;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void onLayout(boolean r7, int r8, int r9, int r10, int r11) {
        /*
        r6 = this;
        r5 = 0;
        r4 = 1;
        super.onLayout(r7, r8, r9, r10, r11);
        r0 = r6.gvW;
        if (r0 != 0) goto L_0x0056;
    L_0x0009:
        r6.gvW = r4;
        r6.QW = r11;
        r0 = "MicroMsg.KeyboardLinearLayout";
        r1 = "init height:%d";
        r2 = new java.lang.Object[r4];
        r3 = r6.QW;
        r3 = java.lang.Integer.valueOf(r3);
        r2[r5] = r3;
        com.tencent.mm.sdk.platformtools.v.i(r0, r1, r2);
        r0 = r6.jGr;
        if (r0 == 0) goto L_0x0024;
    L_0x0024:
        r0 = r6.gvW;
        if (r0 == 0) goto L_0x0061;
    L_0x0028:
        r0 = r6.jGq;
        if (r0 != 0) goto L_0x0061;
    L_0x002c:
        r0 = r6.QW;
        if (r0 <= r11) goto L_0x0061;
    L_0x0030:
        r6.jGq = r4;
        r0 = "MicroMsg.KeyboardLinearLayout";
        r1 = new java.lang.StringBuilder;
        r2 = "show keyboard!! mHeight: ";
        r1.<init>(r2);
        r2 = r6.QW;
        r1 = r1.append(r2);
        r2 = " b: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
    L_0x0055:
        return;
    L_0x0056:
        r0 = r6.QW;
        if (r0 >= r11) goto L_0x005e;
    L_0x005a:
        r0 = r11;
    L_0x005b:
        r6.QW = r0;
        goto L_0x0024;
    L_0x005e:
        r0 = r6.QW;
        goto L_0x005b;
    L_0x0061:
        r0 = r6.gvW;
        if (r0 == 0) goto L_0x0055;
    L_0x0065:
        r0 = r6.jGq;
        if (r0 == 0) goto L_0x0055;
    L_0x0069:
        r0 = r6.QW;
        r0 = r0 - r11;
        r0 = java.lang.Math.abs(r0);
        r1 = 100;
        if (r0 >= r1) goto L_0x0055;
    L_0x0074:
        r6.jGq = r5;
        r0 = "MicroMsg.KeyboardLinearLayout";
        r1 = new java.lang.StringBuilder;
        r2 = "hide keyboard!! mHeight: ";
        r1.<init>(r2);
        r2 = r6.QW;
        r1 = r1.append(r2);
        r2 = " b: ";
        r1 = r1.append(r2);
        r1 = r1.append(r11);
        r1 = r1.toString();
        com.tencent.mm.sdk.platformtools.v.w(r0, r1);
        goto L_0x0055;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.sns.ui.KeyboardLinearLayout.onLayout(boolean, int, int, int, int):void");
    }
}
