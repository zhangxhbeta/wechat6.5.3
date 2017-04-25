package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class fr extends c {
    private final int height = MMGIFException.D_GIF_ERR_READ_FAILED;
    private final int width = MMGIFException.D_GIF_ERR_READ_FAILED;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
            case 1:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
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
                Paint a = c.a(g, looper);
                a.setColor(-1);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(51.0f, 102.0f);
                h.cubicTo(79.16652f, 102.0f, 102.0f, 79.16652f, 102.0f, 51.0f);
                h.cubicTo(102.0f, 22.833477f, 79.16652f, 0.0f, 51.0f, 0.0f);
                h.cubicTo(22.833477f, 0.0f, 0.0f, 22.833477f, 0.0f, 51.0f);
                h.cubicTo(0.0f, 79.16652f, 22.833477f, 102.0f, 51.0f, 102.0f);
                h.close();
                h.moveTo(51.0f, 98.0f);
                h.cubicTo(76.95738f, 98.0f, 98.0f, 76.95738f, 98.0f, 51.0f);
                h.cubicTo(98.0f, 25.042616f, 76.95738f, 4.0f, 51.0f, 4.0f);
                h.cubicTo(25.042616f, 4.0f, 4.0f, 25.042616f, 4.0f, 51.0f);
                h.cubicTo(4.0f, 76.95738f, 25.042616f, 98.0f, 51.0f, 98.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                float[] a3 = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 14.0f);
                d.reset();
                d.setValues(a3);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(39.52522f, 40.28733f);
                h.lineTo(9.866667f, 40.28733f);
                h.lineTo(9.866667f, 44.853653f);
                h.cubicTo(9.866667f, 45.975304f, 10.76179f, 46.86199f, 11.865981f, 46.86199f);
                h.lineTo(37.883682f, 46.86199f);
                h.lineTo(36.885212f, 57.796623f);
                h.cubicTo(36.735928f, 59.43152f, 37.682396f, 59.961784f, 39.00135f, 58.95761f);
                h.lineTo(58.255604f, 44.29855f);
                h.cubicTo(61.15963f, 42.087593f, 60.55669f, 40.28733f, 56.896053f, 40.28733f);
                h.lineTo(39.52522f, 40.28733f);
                h.close();
                h.moveTo(32.008507f, 33.71267f);
                h.lineTo(61.99695f, 33.71267f);
                h.lineTo(61.99695f, 29.146349f);
                h.cubicTo(61.99695f, 28.024696f, 61.104416f, 27.138008f, 60.003418f, 27.138008f);
                h.lineTo(33.649654f, 27.138008f);
                h.lineTo(34.64812f, 16.203377f);
                h.cubicTo(34.797405f, 14.5684805f, 33.850937f, 14.038217f, 32.531982f, 15.04239f);
                h.lineTo(13.277731f, 29.701452f);
                h.cubicTo(10.373704f, 31.912409f, 10.9766445f, 33.71267f, 14.637279f, 33.71267f);
                h.lineTo(32.008507f, 33.71267f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
