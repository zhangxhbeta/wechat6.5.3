package com.tencent.mm.plugin.qqmail.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.ScrollView;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.widget.MMWebView;

public class EmbedWebView extends MMWebView {
    private float[] ieA = new float[2];
    private GestureDetector iev = new GestureDetector(new SimpleOnGestureListener(this) {
        final /* synthetic */ EmbedWebView ieB;

        {
            this.ieB = r1;
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            EmbedWebView embedWebView = this.ieB;
            v.d("MicroMsg.EmbedWebView", "onDoubleTapm, before scale:" + embedWebView.getScale());
            int i = 10;
            while (embedWebView.getScale() != 1.0f) {
                i--;
                if (i <= 0) {
                    break;
                } else if (embedWebView.getScale() > 1.0f) {
                    embedWebView.zoomOut();
                } else {
                    embedWebView.zoomIn();
                }
            }
            v.d("MicroMsg.EmbedWebView", "onDoubleTapm, after scale:" + this.ieB.getScale());
            return true;
        }
    });
    private boolean iew = false;
    private float[] iex = new float[2];
    private float[] iey = new float[2];
    private float[] iez = new float[2];

    public EmbedWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        postDelayed(new Runnable(this) {
            final /* synthetic */ EmbedWebView ieB;

            {
                this.ieB = r1;
            }

            public final void run() {
                View view = (View) this.ieB.getParent();
                if (view != null) {
                    view = (View) view.getParent();
                    if (view != null && (view instanceof ScrollView)) {
                        this.ieB.iew = true;
                        view.setOnTouchListener(new OnTouchListener(this) {
                            final /* synthetic */ AnonymousClass2 ieC;

                            {
                                this.ieC = r1;
                            }

                            public final boolean onTouch(View view, MotionEvent motionEvent) {
                                if (motionEvent.getPointerCount() == 2) {
                                    this.ieC.ieB.onTouchEvent(motionEvent);
                                }
                                return false;
                            }
                        });
                    }
                }
            }
        }, 100);
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r12) {
        /*
        r11 = this;
        r10 = 1184645120; // 0x469c4000 float:20000.0 double:5.852924563E-315;
        r8 = 4611686018427387904; // 0x4000000000000000 float:0.0 double:2.0;
        r0 = 1;
        r1 = 0;
        r2 = r11.iev;
        r2.onTouchEvent(r12);
        r2 = r11.iew;
        if (r2 == 0) goto L_0x001f;
    L_0x0010:
        r2 = r12.getAction();
        r2 = r2 & 255;
        r3 = r12.getPointerCount();
        r4 = 2;
        if (r3 == r4) goto L_0x0024;
    L_0x001d:
        if (r1 != 0) goto L_0x0023;
    L_0x001f:
        r0 = super.onTouchEvent(r12);
    L_0x0023:
        return r0;
    L_0x0024:
        switch(r2) {
            case 2: goto L_0x003e;
            case 3: goto L_0x0027;
            case 4: goto L_0x0027;
            case 5: goto L_0x0029;
            default: goto L_0x0027;
        };
    L_0x0027:
        r1 = r0;
        goto L_0x001d;
    L_0x0029:
        if (r1 >= r3) goto L_0x0027;
    L_0x002b:
        r2 = r11.iex;
        r4 = r12.getX(r1);
        r2[r1] = r4;
        r2 = r11.iey;
        r4 = r12.getY(r1);
        r2[r1] = r4;
        r1 = r1 + 1;
        goto L_0x0029;
    L_0x003e:
        r2 = r1;
    L_0x003f:
        if (r2 >= r3) goto L_0x0054;
    L_0x0041:
        r4 = r11.iez;
        r5 = r12.getX(r2);
        r4[r2] = r5;
        r4 = r11.ieA;
        r5 = r12.getY(r2);
        r4[r2] = r5;
        r2 = r2 + 1;
        goto L_0x003f;
    L_0x0054:
        r2 = r11.iex;
        r2 = r2[r0];
        r3 = r11.iex;
        r3 = r3[r1];
        r2 = r2 - r3;
        r2 = (double) r2;
        r2 = java.lang.Math.pow(r2, r8);
        r4 = r11.iey;
        r4 = r4[r0];
        r5 = r11.iey;
        r5 = r5[r1];
        r4 = r4 - r5;
        r4 = (double) r4;
        r4 = java.lang.Math.pow(r4, r8);
        r2 = r2 + r4;
        r2 = (float) r2;
        r3 = r11.iez;
        r3 = r3[r0];
        r4 = r11.iez;
        r4 = r4[r1];
        r3 = r3 - r4;
        r4 = (double) r3;
        r4 = java.lang.Math.pow(r4, r8);
        r3 = r11.ieA;
        r3 = r3[r0];
        r6 = r11.ieA;
        r6 = r6[r1];
        r3 = r3 - r6;
        r6 = (double) r3;
        r6 = java.lang.Math.pow(r6, r8);
        r4 = r4 + r6;
        r3 = (float) r4;
        r4 = r2 - r3;
        r4 = (r4 > r10 ? 1 : (r4 == r10 ? 0 : -1));
        if (r4 <= 0) goto L_0x00bb;
    L_0x0096:
        r11.zoomOut();
    L_0x0099:
        r2 = r11.iex;
        r3 = r11.iez;
        r3 = r3[r1];
        r2[r1] = r3;
        r2 = r11.iex;
        r3 = r11.iez;
        r3 = r3[r0];
        r2[r0] = r3;
        r2 = r11.iey;
        r3 = r11.ieA;
        r3 = r3[r1];
        r2[r1] = r3;
        r1 = r11.iey;
        r2 = r11.ieA;
        r2 = r2[r0];
        r1[r0] = r2;
        goto L_0x0027;
    L_0x00bb:
        r2 = r3 - r2;
        r2 = (r2 > r10 ? 1 : (r2 == r10 ? 0 : -1));
        if (r2 <= 0) goto L_0x0099;
    L_0x00c1:
        r11.zoomIn();
        goto L_0x0099;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mm.plugin.qqmail.ui.EmbedWebView.onTouchEvent(android.view.MotionEvent):boolean");
    }
}
