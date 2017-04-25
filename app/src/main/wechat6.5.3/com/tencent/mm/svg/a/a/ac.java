package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ac extends c {
    private final int height = 16;
    private final int width = 28;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 28;
            case 1:
                return 16;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
                Paint g = c.g(looper);
                g.setFlags(385);
                g.setStyle(Style.FILL);
                Paint g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.STROKE);
                g.setColor(WebView.NIGHT_MODE_COLOR);
                g2.setStrokeWidth(1.0f);
                g2.setStrokeCap(Cap.BUTT);
                g2.setStrokeJoin(Join.MITER);
                g2.setStrokeMiter(4.0f);
                g2.setPathEffect(null);
                c.a(g2, looper).setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3355444);
                Path h = c.h(looper);
                h.moveTo(13.962992f, 10.188502f);
                h.cubicTo(13.08834f, 9.283867f, 12.178382f, 8.349955f, 11.50355f, 7.6751227f);
                h.lineTo(3.828427f, 8.881784E-16f);
                h.lineTo(1.0f, 2.828427f);
                h.lineTo(13.9616785f, 15.961207f);
                h.lineTo(13.994814f, 15.928072f);
                h.lineTo(14.008518f, 15.941776f);
                h.lineTo(15.711977f, 14.210909f);
                h.lineTo(16.790106f, 13.13278f);
                h.cubicTo(16.790106f, 13.13278f, 16.787266f, 13.1298f, 16.781706f, 13.123969f);
                h.lineTo(26.914213f, 2.828427f);
                h.lineTo(24.085787f, -5.3290705E-15f);
                h.lineTo(16.410664f, 7.6751227f);
                h.cubicTo(15.7343025f, 8.351483f, 14.829623f, 9.285367f, 13.962992f, 10.188502f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
