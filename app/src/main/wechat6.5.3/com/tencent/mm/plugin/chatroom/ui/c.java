package com.tencent.mm.plugin.chatroom.ui;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import java.util.ArrayList;

public final class c extends TouchDelegate {
    private static final Rect eUk = new Rect();
    ArrayList<TouchDelegate> eUl;
    TouchDelegate eUm;

    public c(View view) {
        super(eUk, view);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
        r4 = this;
        r1 = 0;
        r0 = r5.getAction();
        switch(r0) {
            case 0: goto L_0x000d;
            case 1: goto L_0x0034;
            case 2: goto L_0x0031;
            case 3: goto L_0x0034;
            default: goto L_0x0008;
        };
    L_0x0008:
        r0 = r1;
    L_0x0009:
        if (r0 != 0) goto L_0x0039;
    L_0x000b:
        r0 = 0;
    L_0x000c:
        return r0;
    L_0x000d:
        r0 = r4.eUl;
        if (r0 == 0) goto L_0x0008;
    L_0x0011:
        r0 = r4.eUl;
        r2 = r0.iterator();
    L_0x0017:
        r0 = r2.hasNext();
        if (r0 == 0) goto L_0x002f;
    L_0x001d:
        r0 = r2.next();
        r0 = (android.view.TouchDelegate) r0;
        if (r0 == 0) goto L_0x0017;
    L_0x0025:
        r3 = r0.onTouchEvent(r5);
        if (r3 == 0) goto L_0x0017;
    L_0x002b:
        r4.eUm = r0;
        r0 = 1;
        goto L_0x000c;
    L_0x002f:
        r0 = r1;
        goto L_0x0009;
    L_0x0031:
        r0 = r4.eUm;
        goto L_0x0009;
    L_0x0034:
        r0 = r4.eUm;
        r4.eUm = r1;
        goto L_0x0009;
    L_0x0039:
        r0 = r0.onTouchEvent(r5);
        goto L_0x000c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.chatroom.ui.c.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
