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

public final class yp extends c {
    private final int height = 291;
    private final int width = 291;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 291;
            case 1:
                return 291;
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
                float[] a = c.a(c, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.462312f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(145.5f, 290.5377f);
                h.cubicTo(225.85744f, 290.5377f, 291.0f, 225.72247f, 291.0f, 145.76884f);
                h.cubicTo(291.0f, 65.815216f, 225.85744f, 1.0f, 145.5f, 1.0f);
                h.cubicTo(65.14257f, 1.0f, 0.0f, 65.815216f, 0.0f, 145.76884f);
                h.cubicTo(0.0f, 225.72247f, 65.14257f, 290.5377f, 145.5f, 290.5377f);
                h.lineTo(145.5f, 290.5377f);
                h.close();
                h.moveTo(145.5f, 286.3819f);
                h.cubicTo(223.55066f, 286.3819f, 286.82324f, 223.42729f, 286.82324f, 145.76884f);
                h.cubicTo(286.82324f, 68.11039f, 223.55066f, 5.155779f, 145.5f, 5.155779f);
                h.cubicTo(67.44933f, 5.155779f, 4.176768f, 68.11039f, 4.176768f, 145.76884f);
                h.cubicTo(4.176768f, 223.42729f, 67.44933f, 286.3819f, 145.5f, 286.3819f);
                h.lineTo(145.5f, 286.3819f);
                h.close();
                g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.FILL);
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.STROKE);
                g2.setColor(WebView.NIGHT_MODE_COLOR);
                g3.setStrokeWidth(1.0f);
                g3.setStrokeCap(Cap.BUTT);
                g3.setStrokeJoin(Join.MITER);
                g3.setStrokeMiter(4.0f);
                g3.setPathEffect(null);
                float[] a3 = c.a(a, 291.0f, 0.0f, 0.0f, 0.0f, 290.5377f, 1.0f);
                d.reset();
                d.setValues(a3);
                WeChatSVGRenderC2Java.setLinearGradient(a2, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-1, -1}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
