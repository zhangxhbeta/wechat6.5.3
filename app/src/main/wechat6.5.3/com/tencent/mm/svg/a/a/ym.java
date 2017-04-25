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

public final class ym extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                Paint a = c.a(g, looper);
                a.setColor(-10653805);
                c = c.a(c, 0.70710677f, -0.70710677f, 48.0f, 0.70710677f, 0.70710677f, -19.882248f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h = c.h(looper);
                h.moveTo(62.0f, 28.517904f);
                h.lineTo(62.0f, 66.0f);
                h.lineTo(67.0f, 66.0f);
                h.lineTo(67.0f, 28.517904f);
                h.cubicTo(66.99998f, 28.51194f, 67.0f, 28.505972f, 67.0f, 28.5f);
                h.cubicTo(67.0f, 27.119287f, 65.880714f, 26.0f, 64.5f, 26.0f);
                h.cubicTo(63.11929f, 26.0f, 62.0f, 27.119287f, 62.0f, 28.5f);
                h.cubicTo(62.0f, 28.505972f, 62.00002f, 28.51194f, 62.00006f, 28.517904f);
                h.close();
                h.moveTo(40.0f, 39.482143f);
                h.lineTo(40.0f, 66.0f);
                h.lineTo(45.0f, 66.0f);
                h.lineTo(45.0f, 39.482143f);
                h.cubicTo(44.990337f, 38.10965f, 43.874756f, 37.0f, 42.5f, 37.0f);
                h.cubicTo(41.125244f, 37.0f, 40.009663f, 38.10965f, 40.00006f, 39.482143f);
                h.lineTo(40.0f, 39.482143f);
                h.close();
                h.moveTo(55.99748f, 24.0f);
                h.cubicTo(55.857f, 16.7968f, 49.867767f, 11.0f, 42.5f, 11.0f);
                h.cubicTo(35.132233f, 11.0f, 29.143f, 16.7968f, 29.002523f, 24.0f);
                h.lineTo(34.01446f, 24.0f);
                h.cubicTo(34.27327f, 19.538311f, 37.973427f, 16.0f, 42.5f, 16.0f);
                h.cubicTo(47.026573f, 16.0f, 50.72673f, 19.538311f, 50.98554f, 24.0f);
                h.lineTo(55.99748f, 24.0f);
                h.lineTo(55.99748f, 24.0f);
                h.close();
                h.moveTo(67.0f, 66.0f);
                h.cubicTo(67.0f, 76.49341f, 58.493412f, 85.0f, 48.0f, 85.0f);
                h.cubicTo(37.506588f, 85.0f, 29.0f, 76.49341f, 29.0f, 66.0f);
                h.lineTo(34.0f, 66.0f);
                h.cubicTo(34.0f, 73.73199f, 40.268013f, 80.0f, 48.0f, 80.0f);
                h.cubicTo(55.731987f, 80.0f, 62.0f, 73.73199f, 62.0f, 66.0f);
                h.lineTo(67.0f, 66.0f);
                h.lineTo(67.0f, 66.0f);
                h.close();
                h.moveTo(56.0f, 66.0f);
                h.cubicTo(56.0f, 70.41828f, 52.418278f, 74.0f, 48.0f, 74.0f);
                h.cubicTo(43.581722f, 74.0f, 40.0f, 70.41828f, 40.0f, 66.0f);
                h.lineTo(45.0f, 66.0f);
                h.cubicTo(45.0f, 67.65685f, 46.343147f, 69.0f, 48.0f, 69.0f);
                h.cubicTo(49.656853f, 69.0f, 51.0f, 67.65685f, 51.0f, 66.0f);
                h.lineTo(56.0f, 66.0f);
                h.lineTo(56.0f, 66.0f);
                h.close();
                h.moveTo(29.0f, 24.0f);
                h.lineTo(34.0f, 24.0f);
                h.lineTo(34.0f, 66.0f);
                h.lineTo(29.0f, 66.0f);
                h.lineTo(29.0f, 24.0f);
                h.close();
                h.moveTo(51.0f, 24.0f);
                h.lineTo(56.0f, 24.0f);
                h.lineTo(56.0f, 66.0f);
                h.lineTo(51.0f, 66.0f);
                h.lineTo(51.0f, 24.0f);
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
