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

public final class du extends c {
    private final int height = 242;
    private final int width = 245;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 245;
            case 1:
                return 242;
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
                g2 = c.a(g2, looper);
                g2.setStrokeWidth(1.0f);
                canvas.save();
                Paint a = c.a(g2, looper);
                a.setColor(-3552823);
                a.setStrokeWidth(4.0f);
                Path h = c.h(looper);
                h.moveTo(123.0f, 7.0f);
                h.cubicTo(185.96046f, 7.0f, 237.0f, 58.039536f, 237.0f, 121.0f);
                h.cubicTo(237.0f, 183.96046f, 185.96046f, 235.0f, 123.0f, 235.0f);
                h.cubicTo(60.039536f, 235.0f, 9.0f, 183.96046f, 9.0f, 121.0f);
                h.cubicTo(9.0f, 58.039536f, 60.039536f, 7.0f, 123.0f, 7.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-3552823);
                Path h2 = c.h(looper);
                h2.moveTo(117.133484f, 111.829056f);
                h2.lineTo(94.750854f, 89.44642f);
                h2.lineTo(94.750854f, 100.31056f);
                h2.lineTo(116.18076f, 121.74048f);
                h2.lineTo(94.750854f, 143.17038f);
                h2.lineTo(94.750854f, 154.18599f);
                h2.lineTo(117.133484f, 131.80336f);
                h2.lineTo(117.133484f, 165.4863f);
                h2.lineTo(116.812836f, 165.80695f);
                h2.lineTo(117.133484f, 165.80695f);
                h2.lineTo(117.133484f, 176.5019f);
                h2.lineTo(149.46358f, 144.17183f);
                h2.lineTo(148.58734f, 143.2956f);
                h2.lineTo(148.59369f, 143.28926f);
                h2.lineTo(127.12064f, 121.81621f);
                h2.lineTo(148.28012f, 100.65672f);
                h2.lineTo(148.23923f, 100.61583f);
                h2.lineTo(150.24332f, 98.61174f);
                h2.lineTo(117.133484f, 65.501915f);
                h2.lineTo(117.133484f, 75.7257f);
                h2.lineTo(117.133484f, 111.829056f);
                h2.close();
                h2.moveTo(124.9227f, 112.99854f);
                h2.lineTo(139.2686f, 98.65264f);
                h2.lineTo(124.9227f, 84.30673f);
                h2.lineTo(124.9227f, 112.99854f);
                h2.close();
                h2.moveTo(124.9227f, 157.6971f);
                h2.lineTo(138.53004f, 144.08975f);
                h2.lineTo(124.9227f, 130.4824f);
                h2.lineTo(124.9227f, 157.6971f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
