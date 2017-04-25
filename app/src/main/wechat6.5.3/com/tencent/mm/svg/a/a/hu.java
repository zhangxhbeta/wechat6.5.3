package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class hu extends c {
    private final int height = 162;
    private final int width = 162;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 162;
            case 1:
                return 162;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                Matrix d = c.d(looper);
                float[] c = c.c(looper);
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
                c = c.a(c, 1.0f, 0.0f, 0.333333f, 0.0f, 1.0f, 0.333333f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h = c.h(looper);
                h.moveTo(0.6666667f, 80.666664f);
                h.cubicTo(0.6666667f, 36.554592f, 36.554333f, 0.6666667f, 80.666664f, 0.6666667f);
                h.cubicTo(124.779f, 0.6666667f, 160.66667f, 36.554592f, 160.66667f, 80.666664f);
                h.cubicTo(160.66667f, 124.77874f, 124.779f, 160.66667f, 80.666664f, 160.66667f);
                h.cubicTo(36.554333f, 160.66667f, 0.6666667f, 124.77874f, 0.6666667f, 80.666664f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-11711155);
                h = c.h(looper);
                h.moveTo(106.666664f, 96.666664f);
                h.cubicTo(106.666664f, 101.28787f, 104.28978f, 103.666664f, 99.666664f, 103.666664f);
                h.lineTo(60.666668f, 103.666664f);
                h.cubicTo(56.043552f, 103.666664f, 53.666668f, 101.28787f, 53.666668f, 96.666664f);
                h.lineTo(53.666668f, 57.666668f);
                h.lineTo(71.666664f, 57.666668f);
                h.lineTo(77.666664f, 64.666664f);
                h.lineTo(106.666664f, 64.666664f);
                h.lineTo(106.666664f, 98.666664f);
                h.lineTo(106.666664f, 96.666664f);
                h.close();
                h.moveTo(79.666664f, 61.666668f);
                h.lineTo(73.666664f, 54.666668f);
                h.lineTo(53.666668f, 54.666668f);
                h.cubicTo(52.0857f, 54.666668f, 50.666668f, 56.086094f, 50.666668f, 57.666668f);
                h.lineTo(50.666668f, 96.666664f);
                h.cubicTo(50.666668f, 102.8492f, 54.57398f, 106.666664f, 60.666668f, 106.666664f);
                h.lineTo(99.666664f, 106.666664f);
                h.cubicTo(105.75935f, 106.666664f, 109.666664f, 102.8492f, 109.666664f, 96.666664f);
                h.lineTo(109.666664f, 64.666664f);
                h.cubicTo(109.666664f, 62.701645f, 108.24101f, 61.27891f, 106.666664f, 61.666668f);
                h.lineTo(79.666664f, 61.666668f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-11711155);
                Path h2 = c.h(looper);
                h2.moveTo(59.666668f, 78.666664f);
                h2.lineTo(100.666664f, 78.666664f);
                h2.lineTo(100.666664f, 75.666664f);
                h2.lineTo(59.666668f, 75.666664f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 1);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
