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

public final class xc extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 51.0f, 0.0f, 1.0f, 39.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(31.624044f, 90.34997f);
                h.cubicTo(32.383965f, 91.14044f, 33.629753f, 91.13373f, 34.386406f, 90.3389f);
                h.cubicTo(34.386406f, 90.3389f, 66.0f, 58.57656f, 66.0f, 33.461914f);
                h.cubicTo(66.0f, 14.90092f, 51.225395f, 0.0f, 33.47826f, 0.0f);
                h.cubicTo(14.774603f, 0.0f, 0.0f, 14.90092f, 0.0f, 33.461914f);
                h.cubicTo(0.0f, 58.57656f, 31.624044f, 90.34997f, 31.624044f, 90.34997f);
                h.close();
                h.moveTo(33.0f, 44.30819f);
                h.cubicTo(39.07513f, 44.30819f, 44.0f, 39.348827f, 44.0f, 33.231144f);
                h.cubicTo(44.0f, 27.113459f, 39.07513f, 22.154095f, 33.0f, 22.154095f);
                h.cubicTo(26.924868f, 22.154095f, 22.0f, 27.113459f, 22.0f, 33.231144f);
                h.cubicTo(22.0f, 39.348827f, 26.924868f, 44.30819f, 33.0f, 44.30819f);
                h.close();
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
