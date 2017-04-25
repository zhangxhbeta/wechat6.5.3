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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class lg extends c {
    private final int height = 200;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 200;
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
                g = c.a(g, looper);
                g.setColor(-1);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(103.09051f, 171.0f);
                h.lineTo(18.031914f, 171.0f);
                h.lineTo(18.031914f, 165.72656f);
                h.lineTo(64.613945f, 112.015625f);
                h.cubicTo(73.66347f, 101.5338f, 80.17382f, 92.663445f, 84.145195f, 85.4043f);
                h.cubicTo(88.11657f, 78.14515f, 90.10223f, 71.325554f, 90.10223f, 64.94531f);
                h.cubicTo(90.10223f, 54.398384f, 87.2865f, 46.276722f, 81.65496f, 40.58008f);
                h.cubicTo(76.02342f, 34.883434f, 67.608795f, 32.035156f, 56.41082f, 32.035156f);
                h.cubicTo(44.4967f, 32.035156f, 35.414757f, 35.404263f, 29.164726f, 42.14258f);
                h.cubicTo(22.914696f, 48.880894f, 19.789726f, 57.7838f, 19.789726f, 68.85156f);
                h.lineTo(14.51629f, 68.85156f);
                h.cubicTo(14.51629f, 56.742126f, 18.25974f, 46.69991f, 25.746758f, 38.72461f);
                h.cubicTo(33.233776f, 30.74931f, 43.45503f, 26.761719f, 56.41082f, 26.761719f);
                h.cubicTo(68.390045f, 26.761719f, 77.89516f, 30.03317f, 84.926445f, 36.57617f);
                h.cubicTo(91.95773f, 43.119175f, 95.47332f, 52.57546f, 95.47332f, 64.94531f);
                h.cubicTo(95.47332f, 73.01827f, 92.966835f, 81.042274f, 87.95379f, 89.01758f);
                h.cubicTo(82.94074f, 96.99288f, 75.6817f, 106.54682f, 66.176445f, 117.67969f);
                h.lineTo(24.965508f, 165.72656f);
                h.lineTo(103.09051f, 165.72656f);
                h.lineTo(103.09051f, 171.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
