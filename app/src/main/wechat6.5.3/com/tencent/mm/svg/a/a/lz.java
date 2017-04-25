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

public final class lz extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                g.setColor(-7645398);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(39.00101f, 27.0f);
                h.cubicTo(37.343597f, 27.0f, 36.0f, 28.337994f, 36.0f, 29.991224f);
                h.lineTo(36.0f, 106.00877f);
                h.cubicTo(36.0f, 107.66078f, 37.33673f, 109.0f, 39.00101f, 109.0f);
                h.lineTo(96.998985f, 109.0f);
                h.cubicTo(98.6564f, 109.0f, 100.0f, 107.66201f, 100.0f, 106.00877f);
                h.lineTo(100.0f, 29.991224f);
                h.cubicTo(100.0f, 28.339216f, 98.66327f, 27.0f, 96.998985f, 27.0f);
                h.lineTo(39.00101f, 27.0f);
                h.close();
                h.moveTo(41.0f, 32.0f);
                h.lineTo(41.0f, 104.0f);
                h.lineTo(95.0f, 104.0f);
                h.lineTo(95.0f, 32.0f);
                h.lineTo(41.0f, 32.0f);
                h.close();
                h.moveTo(67.0f, 32.0f);
                h.lineTo(67.0f, 38.0f);
                h.lineTo(74.0f, 38.0f);
                h.lineTo(74.0f, 32.0f);
                h.lineTo(67.0f, 32.0f);
                h.close();
                h.moveTo(60.0f, 38.0f);
                h.lineTo(60.0f, 44.0f);
                h.lineTo(67.0f, 44.0f);
                h.lineTo(67.0f, 38.0f);
                h.lineTo(60.0f, 38.0f);
                h.close();
                h.moveTo(67.0f, 44.0f);
                h.lineTo(67.0f, 50.0f);
                h.lineTo(74.0f, 50.0f);
                h.lineTo(74.0f, 44.0f);
                h.lineTo(67.0f, 44.0f);
                h.close();
                h.moveTo(60.0f, 50.0f);
                h.lineTo(60.0f, 56.0f);
                h.lineTo(67.0f, 56.0f);
                h.lineTo(67.0f, 50.0f);
                h.lineTo(60.0f, 50.0f);
                h.close();
                h.moveTo(67.0f, 56.0f);
                h.lineTo(67.0f, 62.0f);
                h.lineTo(74.0f, 62.0f);
                h.lineTo(74.0f, 56.0f);
                h.lineTo(67.0f, 56.0f);
                h.close();
                h.moveTo(60.0f, 62.0f);
                h.lineTo(60.0f, 68.0f);
                h.lineTo(67.0f, 68.0f);
                h.lineTo(67.0f, 62.0f);
                h.lineTo(60.0f, 62.0f);
                h.close();
                h.moveTo(67.0f, 68.0f);
                h.lineTo(67.0f, 83.0f);
                h.lineTo(74.0f, 83.0f);
                h.lineTo(74.0f, 68.0f);
                h.lineTo(67.0f, 68.0f);
                h.close();
                h.moveTo(60.0f, 77.0f);
                h.lineTo(60.0f, 83.0f);
                h.lineTo(67.0f, 83.0f);
                h.lineTo(67.0f, 77.0f);
                h.lineTo(60.0f, 77.0f);
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
