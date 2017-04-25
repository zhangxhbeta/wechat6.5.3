package com.tencent.mm.pluginsdk.ui.d;

import android.content.Context;
import android.os.Looper;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewConfiguration;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;

public final class h implements OnTouchListener {
    private static boolean DEBUG = false;
    private static int hvR = ViewConfiguration.getTapTimeout();
    private static int lRj;
    public String jGE;
    private i lRf = null;
    private boolean lRg = false;
    private View lRh = null;
    private boolean lRi = false;
    private Context lRk = null;
    private ac lRl = new ac(Looper.getMainLooper());
    private b lRm = new b();
    private a lRn = new a(this);
    private View view;

    class a implements Runnable {
        final /* synthetic */ h lRo;

        a(h hVar) {
            this.lRo = hVar;
        }

        public final void run() {
            if (this.lRo.view != null && this.lRo.view.isPressed()) {
                v.d("MicroMsg.PressSpanTouchListener", "long pressed timeout");
                this.lRo.lRi = true;
                this.lRo.auH();
            }
        }
    }

    private class b implements Runnable {
        final /* synthetic */ h lRo;

        private b(h hVar) {
            this.lRo = hVar;
        }

        public final void run() {
            this.lRo.us(h.hvR);
        }
    }

    static {
        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
        lRj = longPressTimeout;
        if (longPressTimeout > hvR * 2) {
            lRj -= hvR;
        }
        v.d("MicroMsg.PressSpanTouchListener", "long press timeout:%d", Integer.valueOf(lRj));
    }

    public h(Context context) {
        this.lRk = context;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouch(android.view.View r12, android.view.MotionEvent r13) {
        /*
        r11 = this;
        r0 = r12 instanceof android.widget.TextView;
        if (r0 != 0) goto L_0x000a;
    L_0x0004:
        r0 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r0 != 0) goto L_0x000a;
    L_0x0008:
        r0 = 0;
    L_0x0009:
        return r0;
    L_0x000a:
        r11.view = r12;
        r0 = r12 instanceof android.widget.TextView;
        if (r0 == 0) goto L_0x0117;
    L_0x0010:
        r0 = r12;
        r0 = (android.widget.TextView) r0;
        r2 = r0.getLayout();
        r0 = r12;
        r0 = (android.widget.TextView) r0;
        r1 = r0.getText();
        r3 = r2;
    L_0x001f:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0071;
    L_0x0023:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "ontouch action: %d, isLongPress:%b ";
        r2.<init>(r4);
        r2 = r2.append(r3);
        r4 = " ";
        r2 = r2.append(r4);
        r4 = r1 instanceof android.text.Spanned;
        r2 = r2.append(r4);
        r4 = " ";
        r2 = r2.append(r4);
        r4 = new com.tencent.mm.sdk.platformtools.af;
        r4.<init>();
        r4 = r4.toString();
        r2 = r2.append(r4);
        r2 = r2.toString();
        r4 = 2;
        r4 = new java.lang.Object[r4];
        r5 = 0;
        r6 = r13.getAction();
        r6 = java.lang.Integer.valueOf(r6);
        r4[r5] = r6;
        r5 = 1;
        r6 = r11.lRi;
        r6 = java.lang.Boolean.valueOf(r6);
        r4[r5] = r6;
        com.tencent.mm.sdk.platformtools.v.d(r0, r2, r4);
    L_0x0071:
        r5 = android.view.MotionEvent.obtain(r13);
        r0 = r1 instanceof android.text.Spanned;
        if (r0 == 0) goto L_0x00b8;
    L_0x0079:
        if (r3 == 0) goto L_0x00b8;
    L_0x007b:
        r0 = r1;
        r0 = (android.text.Spanned) r0;
        r2 = r5.getAction();
        r12.invalidate();
        r4 = 1;
        if (r2 == r4) goto L_0x0090;
    L_0x0088:
        if (r2 == 0) goto L_0x0090;
    L_0x008a:
        r4 = 2;
        if (r2 == r4) goto L_0x0090;
    L_0x008d:
        r4 = 3;
        if (r2 != r4) goto L_0x0251;
    L_0x0090:
        r2 = r5.getX();
        r4 = (int) r2;
        r2 = r5.getY();
        r6 = (int) r2;
        r2 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r2 == 0) goto L_0x0144;
    L_0x009e:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vI();
        if (r4 < r2) goto L_0x00b5;
    L_0x00a7:
        r7 = r3.getWidth();
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vI();
        r2 = r2 + r7;
        if (r4 <= r2) goto L_0x0128;
    L_0x00b5:
        r11.w(r5);
    L_0x00b8:
        r5.recycle();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0114;
    L_0x00bf:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "ontouch action2: %d, isLongPress:%b ";
        r2.<init>(r4);
        r2 = r2.append(r3);
        r3 = " ";
        r2 = r2.append(r3);
        r1 = r1 instanceof android.text.Spanned;
        r1 = r2.append(r1);
        r2 = " processResult: false";
        r1 = r1.append(r2);
        r2 = " ";
        r1 = r1.append(r2);
        r2 = new com.tencent.mm.sdk.platformtools.af;
        r2.<init>();
        r2 = r2.toString();
        r1 = r1.append(r2);
        r1 = r1.toString();
        r2 = 2;
        r2 = new java.lang.Object[r2];
        r3 = 0;
        r4 = r13.getAction();
        r4 = java.lang.Integer.valueOf(r4);
        r2[r3] = r4;
        r3 = 1;
        r4 = r11.lRi;
        r4 = java.lang.Boolean.valueOf(r4);
        r2[r3] = r4;
        com.tencent.mm.sdk.platformtools.v.d(r0, r1, r2);
    L_0x0114:
        r0 = 0;
        goto L_0x0009;
    L_0x0117:
        r0 = r12;
        r0 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r0;
        r2 = r0.vQ();
        r0 = r12;
        r0 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r0;
        r1 = r0.getText();
        r3 = r2;
        goto L_0x001f;
    L_0x0128:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vJ();
        if (r6 < r2) goto L_0x013f;
    L_0x0131:
        r7 = r3.getHeight();
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vJ();
        r2 = r2 + r7;
        if (r6 <= r2) goto L_0x0180;
    L_0x013f:
        r11.w(r5);
        goto L_0x00b8;
    L_0x0144:
        r2 = r12 instanceof android.widget.TextView;
        if (r2 == 0) goto L_0x0180;
    L_0x0148:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        if (r4 < r2) goto L_0x015f;
    L_0x0151:
        r7 = r3.getWidth();
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        r2 = r2 + r7;
        if (r4 <= r2) goto L_0x0164;
    L_0x015f:
        r11.w(r5);
        goto L_0x00b8;
    L_0x0164:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        if (r6 < r2) goto L_0x017b;
    L_0x016d:
        r7 = r3.getHeight();
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        r2 = r2 + r7;
        if (r6 <= r2) goto L_0x0180;
    L_0x017b:
        r11.w(r5);
        goto L_0x00b8;
    L_0x0180:
        r2 = r12 instanceof android.widget.TextView;
        if (r2 == 0) goto L_0x0271;
    L_0x0184:
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingLeft();
        r4 = r4 - r2;
        r2 = r12;
        r2 = (android.widget.TextView) r2;
        r2 = r2.getTotalPaddingTop();
        r2 = r6 - r2;
    L_0x0195:
        r6 = r12.getScrollX();
        r4 = r4 + r6;
        r6 = r12.getScrollY();
        r2 = r2 + r6;
        r2 = r3.getLineForVertical(r2);
        r4 = (float) r4;
        r2 = r3.getOffsetForHorizontal(r2, r4);
        r4 = r12 instanceof android.widget.TextView;
        if (r4 == 0) goto L_0x01ae;
    L_0x01ac:
        r2 = r2 + 1;
    L_0x01ae:
        r4 = r5.getAction();
        r6 = com.tencent.mm.pluginsdk.ui.d.i.class;
        r0 = r0.getSpans(r2, r2, r6);
        r0 = (com.tencent.mm.pluginsdk.ui.d.i[]) r0;
        r2 = r0.length;
        r2 = r2 + -1;
        r6 = DEBUG;
        if (r6 == 0) goto L_0x0210;
    L_0x01c1:
        r6 = "MicroMsg.PressSpanTouchListener";
        r7 = new java.lang.StringBuilder;
        r8 = "processPress action: %d, isLongPress:%b ";
        r7.<init>(r8);
        r8 = r0.length;
        r7 = r7.append(r8);
        r8 = " ";
        r7 = r7.append(r8);
        r8 = r11.lRf;
        r7 = r7.append(r8);
        r8 = " ";
        r7 = r7.append(r8);
        r8 = new com.tencent.mm.sdk.platformtools.af;
        r8.<init>();
        r8 = r8.toString();
        r7 = r7.append(r8);
        r7 = r7.toString();
        r8 = 2;
        r8 = new java.lang.Object[r8];
        r9 = 0;
        r10 = r5.getAction();
        r10 = java.lang.Integer.valueOf(r10);
        r8[r9] = r10;
        r9 = 1;
        r10 = r11.lRi;
        r10 = java.lang.Boolean.valueOf(r10);
        r8[r9] = r10;
        com.tencent.mm.sdk.platformtools.v.d(r6, r7, r8);
    L_0x0210:
        r6 = r0.length;
        if (r6 == 0) goto L_0x03ad;
    L_0x0213:
        r6 = 1;
        if (r4 != r6) goto L_0x02ee;
    L_0x0216:
        r0 = r11.lRl;
        r2 = r11.lRm;
        r0.removeCallbacks(r2);
        r0 = r11.lRl;
        r2 = r11.lRn;
        r0.removeCallbacks(r2);
        r0 = r11.lRi;
        if (r0 == 0) goto L_0x0295;
    L_0x0228:
        r11.auH();
        r0 = 0;
        r11.lRi = r0;
        r0 = r11.lRg;
        r12.setClickable(r0);
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0251;
    L_0x0237:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action1 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
    L_0x0251:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x00b8;
    L_0x0255:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processTouch action2 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        goto L_0x00b8;
    L_0x0271:
        r2 = r12 instanceof com.tencent.mm.kiss.widget.textview.StaticTextView;
        if (r2 == 0) goto L_0x0288;
    L_0x0275:
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vI();
        r4 = r4 - r2;
        r2 = r12;
        r2 = (com.tencent.mm.kiss.widget.textview.StaticTextView) r2;
        r2 = r2.vJ();
        r2 = r6 - r2;
        goto L_0x0195;
    L_0x0288:
        r2 = r12.getPaddingLeft();
        r4 = r4 - r2;
        r2 = r12.getPaddingTop();
        r2 = r6 - r2;
        goto L_0x0195;
    L_0x0295:
        r0 = 0;
        r11.lRi = r0;
        r0 = r11.lRf;
        if (r0 == 0) goto L_0x02e4;
    L_0x029c:
        r0 = r11.lRf;
        r2 = r11.jGE;
        r0.jGE = r2;
        r2 = r0.lRq;
        if (r2 == 0) goto L_0x02ac;
    L_0x02a6:
        r2 = r0.lRq;
        r0 = r0.jGE;
        r2.jGE = r0;
    L_0x02ac:
        r0 = r11.lRk;
        if (r0 == 0) goto L_0x02b7;
    L_0x02b0:
        r0 = r11.lRf;
        r2 = r11.lRk;
        r0.setContext(r2);
    L_0x02b7:
        r0 = r11.lRf;
        r0.onClick(r12);
    L_0x02bc:
        r0 = r11.lRg;
        r12.setClickable(r0);
        r11.auH();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0251;
    L_0x02c8:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action2 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        goto L_0x0251;
    L_0x02e4:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = "ACTION_UP error, lastClickSpan is null";
        com.tencent.mm.sdk.platformtools.v.e(r0, r2);
        goto L_0x02bc;
    L_0x02ee:
        if (r4 == 0) goto L_0x02f3;
    L_0x02f0:
        r6 = 2;
        if (r4 != r6) goto L_0x0374;
    L_0x02f3:
        if (r4 != 0) goto L_0x02fd;
    L_0x02f5:
        r6 = lRj;
        if (r6 <= 0) goto L_0x02fd;
    L_0x02f9:
        r6 = 0;
        r11.us(r6);
    L_0x02fd:
        if (r4 != 0) goto L_0x0305;
    L_0x02ff:
        r4 = r12.isClickable();
        r11.lRg = r4;
    L_0x0305:
        r11.auH();
        r4 = r0[r2];
        r11.lRf = r4;
        r11.lRh = r12;
        r4 = r0[r2];
        r6 = 0;
        r4.setContext(r6);
        r4 = r0[r2];
        r6 = 1;
        r4.hsl = r6;
        r4 = r0[r2];
        r6 = 1;
        r4.hVC = r6;
        r12.invalidate();
        r4 = r11.lRi;
        if (r4 == 0) goto L_0x0354;
    L_0x0325:
        r4 = r0[r2];
        r6 = 0;
        r4.hsl = r6;
        r0 = r0[r2];
        r2 = 0;
        r0.hVC = r2;
        r0 = r11.lRg;
        r12.setClickable(r0);
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0251;
    L_0x0338:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action3 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        goto L_0x0251;
    L_0x0354:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0251;
    L_0x0358:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action4 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        goto L_0x0251;
    L_0x0374:
        r0 = 3;
        if (r4 != r0) goto L_0x03b0;
    L_0x0377:
        r0 = r11.lRl;
        r2 = r11.lRm;
        r0.removeCallbacks(r2);
        r0 = r11.lRl;
        r2 = r11.lRn;
        r0.removeCallbacks(r2);
        r0 = r11.lRg;
        r12.setClickable(r0);
        r11.auH();
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0251;
    L_0x0391:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action5 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        goto L_0x0251;
    L_0x03ad:
        r11.auH();
    L_0x03b0:
        r0 = DEBUG;
        if (r0 == 0) goto L_0x0251;
    L_0x03b4:
        r0 = "MicroMsg.PressSpanTouchListener";
        r2 = new java.lang.StringBuilder;
        r4 = "processPress action6 ";
        r2.<init>(r4);
        r4 = r5.getAction();
        r2 = r2.append(r4);
        r2 = r2.toString();
        com.tencent.mm.sdk.platformtools.v.i(r0, r2);
        goto L_0x0251;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.pluginsdk.ui.d.h.onTouch(android.view.View, android.view.MotionEvent):boolean");
    }

    private void w(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 3 || motionEvent.getAction() == 1) {
            auH();
        }
    }

    public final void auH() {
        if (this.lRf != null) {
            this.lRf.hsl = false;
            this.lRf.setContext(null);
            this.lRh.invalidate();
            this.lRh = null;
            this.lRf = null;
        }
    }

    private void us(int i) {
        if (this.view != null) {
            this.lRl.postDelayed(this.lRn, (long) (lRj - i));
        }
    }
}
