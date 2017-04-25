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

public final class ui extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                canvas.saveLayerAlpha(null, 230, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(90.0f, 180.0f);
                h.cubicTo(139.70563f, 180.0f, 180.0f, 139.70563f, 180.0f, 90.0f);
                h.cubicTo(180.0f, 40.294373f, 139.70563f, 0.0f, 90.0f, 0.0f);
                h.cubicTo(40.294373f, 0.0f, 0.0f, 40.294373f, 0.0f, 90.0f);
                h.cubicTo(0.0f, 139.70563f, 40.294373f, 180.0f, 90.0f, 180.0f);
                h.close();
                h.moveTo(44.0f, 67.99653f);
                h.cubicTo(44.0f, 66.34159f, 45.34499f, 65.0f, 46.99624f, 65.0f);
                h.lineTo(104.00376f, 65.0f);
                h.cubicTo(105.65854f, 65.0f, 107.0f, 66.33738f, 107.0f, 67.99653f);
                h.lineTo(107.0f, 112.00347f);
                h.cubicTo(107.0f, 113.65841f, 105.65501f, 115.0f, 104.00376f, 115.0f);
                h.lineTo(46.99624f, 115.0f);
                h.cubicTo(45.34146f, 115.0f, 44.0f, 113.66262f, 44.0f, 112.00347f);
                h.lineTo(44.0f, 67.99653f);
                h.close();
                h.moveTo(131.5f, 116.79712f);
                h.cubicTo(133.91545f, 117.568535f, 136.0f, 116.05244f, 136.0f, 113.73276f);
                h.lineTo(136.0f, 66.235054f);
                h.cubicTo(136.0f, 63.63856f, 133.69482f, 62.548866f, 131.5f, 63.170685f);
                h.cubicTo(130.19809f, 64.306465f, 119.559074f, 74.1768f, 112.0f, 81.05712f);
                h.lineTo(112.0f, 98.72812f);
                h.cubicTo(119.74342f, 105.702545f, 130.61983f, 115.864586f, 131.5f, 116.79712f);
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
