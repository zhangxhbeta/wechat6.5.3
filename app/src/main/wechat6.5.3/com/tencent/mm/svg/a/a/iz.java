package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
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

public final class iz extends c {
    private final int height = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
            case 1:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
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
                g2 = c.a(g, looper);
                g2.setColor(-14187817);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(108.0f, 0.0f);
                h.lineTo(108.0f, 108.0f);
                h.lineTo(0.0f, 108.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(59.0f, 27.0f);
                h2.lineTo(80.0f, 27.0f);
                h2.cubicTo(81.327415f, 27.113115f, 82.9685f, 28.671097f, 83.0f, 30.0f);
                h2.lineTo(83.0f, 51.0f);
                h2.cubicTo(82.946f, 51.277657f, 82.61898f, 52.063435f, 81.5f, 52.5f);
                h2.lineTo(48.5f, 85.5f);
                h2.cubicTo(47.35823f, 87.322365f, 45.247627f, 87.3284f, 44.0f, 85.5f);
                h2.lineTo(24.5f, 66.0f);
                h2.cubicTo(23.321037f, 65.400536f, 22.99702f, 64.616264f, 23.0f, 63.0f);
                h2.cubicTo(23.00152f, 62.774742f, 23.328537f, 61.988964f, 24.5f, 61.5f);
                h2.lineTo(57.5f, 28.5f);
                h2.cubicTo(57.912754f, 27.405708f, 59.0f, 27.0f, 59.0f, 27.0f);
                h2.close();
                h2.moveTo(67.77778f, 36.0f);
                h2.cubicTo(70.865555f, 36.0f, 74.0f, 39.134445f, 74.0f, 43.77778f);
                h2.cubicTo(74.0f, 46.865555f, 70.865555f, 50.0f, 67.77778f, 50.0f);
                h2.cubicTo(63.134445f, 50.0f, 60.0f, 46.865555f, 60.0f, 43.77778f);
                h2.cubicTo(60.0f, 39.134445f, 63.134445f, 36.0f, 67.77778f, 36.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
