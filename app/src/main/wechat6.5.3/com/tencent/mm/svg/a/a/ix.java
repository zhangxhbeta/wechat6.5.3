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

public final class ix extends c {
    private final int height = 192;
    private final int width = 192;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 192;
            case 1:
                return 192;
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
                h.lineTo(192.0f, 0.0f);
                h.lineTo(192.0f, 192.0f);
                h.lineTo(0.0f, 192.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(56.891357f, 44.8f);
                h2.cubicTo(54.926315f, 44.8f, 53.333332f, 46.40846f, 53.333332f, 48.354576f);
                h2.lineTo(53.333332f, 143.64542f);
                h2.cubicTo(53.333332f, 145.60857f, 54.924335f, 147.2f, 56.891357f, 147.2f);
                h2.lineTo(135.10864f, 147.2f);
                h2.cubicTo(137.07368f, 147.2f, 138.66667f, 145.59154f, 138.66667f, 143.64542f);
                h2.lineTo(138.66667f, 48.354576f);
                h2.cubicTo(138.66667f, 46.391438f, 137.07567f, 44.8f, 135.10864f, 44.8f);
                h2.lineTo(56.891357f, 44.8f);
                h2.lineTo(56.891357f, 44.8f);
                h2.close();
                h2.moveTo(64.0f, 76.8f);
                h2.lineTo(64.0f, 83.2f);
                h2.lineTo(108.8f, 83.2f);
                h2.lineTo(108.8f, 76.8f);
                h2.lineTo(64.0f, 76.8f);
                h2.lineTo(64.0f, 76.8f);
                h2.close();
                h2.moveTo(64.0f, 89.6f);
                h2.lineTo(64.0f, 96.0f);
                h2.lineTo(87.46667f, 96.0f);
                h2.lineTo(87.46667f, 89.6f);
                h2.lineTo(64.0f, 89.6f);
                h2.lineTo(64.0f, 89.6f);
                h2.close();
                h2.moveTo(64.0f, 102.4f);
                h2.lineTo(64.0f, 108.8f);
                h2.lineTo(91.73333f, 108.8f);
                h2.lineTo(91.73333f, 102.4f);
                h2.lineTo(64.0f, 102.4f);
                h2.lineTo(64.0f, 102.4f);
                h2.close();
                h2.moveTo(70.4f, 55.466667f);
                h2.cubicTo(73.93463f, 55.466667f, 76.8f, 58.33163f, 76.8f, 61.865753f);
                h2.cubicTo(76.8f, 65.39988f, 73.93463f, 68.26667f, 70.4f, 68.26667f);
                h2.cubicTo(66.86537f, 68.26667f, 64.0f, 65.39988f, 64.0f, 61.865753f);
                h2.cubicTo(64.0f, 58.33163f, 66.86537f, 55.466667f, 70.4f, 55.466667f);
                h2.lineTo(70.4f, 55.466667f);
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
