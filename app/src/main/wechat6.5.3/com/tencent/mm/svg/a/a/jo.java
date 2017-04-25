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

public final class jo extends c {
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
                g2.setColor(-15158035);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(192.0f, 0.0f);
                h.lineTo(192.0f, 192.0f);
                h.lineTo(0.0f, 192.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(142.54546f, 100.831314f);
                h2.cubicTo(139.21634f, 92.18106f, 135.36592f, 85.41221f, 136.1254f, 75.06431f);
                h2.cubicTo(134.93721f, 54.305878f, 117.50597f, 36.5975f, 97.60502f, 36.41379f);
                h2.cubicTo(74.49456f, 36.5975f, 57.06332f, 54.305878f, 55.874607f, 75.06431f);
                h2.cubicTo(56.631752f, 85.41221f, 52.78132f, 92.18106f, 49.454544f, 100.831314f);
                h2.cubicTo(40.531776f, 114.37079f, 42.792137f, 131.66068f, 46.244514f, 133.04007f);
                h2.cubicTo(48.937344f, 131.66068f, 53.50395f, 128.93271f, 59.08464f, 123.37745f);
                h2.cubicTo(59.046963f, 129.886f, 62.21491f, 134.8965f, 65.5047f, 139.48183f);
                h2.cubicTo(60.41336f, 140.68864f, 56.32277f, 143.90248f, 55.874607f, 145.92358f);
                h2.cubicTo(56.75219f, 152.38712f, 65.80511f, 156.04285f, 75.134796f, 155.58621f);
                h2.cubicTo(85.191315f, 155.14914f, 92.27135f, 152.36159f, 94.39498f, 149.14445f);
                h2.cubicTo(95.27298f, 148.79735f, 95.62354f, 148.81863f, 97.60502f, 149.14445f);
                h2.cubicTo(96.38775f, 148.81863f, 96.74691f, 148.79735f, 97.60502f, 149.14445f);
                h2.cubicTo(99.75284f, 152.36159f, 106.82212f, 155.14914f, 116.865204f, 155.58621f);
                h2.cubicTo(126.196144f, 156.04285f, 135.2462f, 152.38712f, 136.1254f, 145.92358f);
                h2.cubicTo(135.67705f, 143.90106f, 131.58717f, 140.68864f, 126.4953f, 139.48183f);
                h2.cubicTo(129.78922f, 134.8965f, 132.94926f, 129.89098f, 132.91536f, 123.37745f);
                h2.cubicTo(138.50232f, 128.93483f, 143.06104f, 131.66068f, 145.7555f, 133.04007f);
                h2.cubicTo(149.20982f, 131.66068f, 151.46875f, 114.37079f, 142.54546f, 100.831314f);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-15158035);
                h2 = c.h(looper);
                h2.moveTo(176.66667f, 125.333336f);
                h2.cubicTo(176.66667f, 141.90233f, 163.23567f, 155.33333f, 146.66667f, 155.33333f);
                h2.cubicTo(130.09767f, 155.33333f, 116.666664f, 141.90233f, 116.666664f, 125.333336f);
                h2.cubicTo(116.666664f, 108.764336f, 130.09767f, 95.333336f, 146.66667f, 95.333336f);
                h2.cubicTo(163.23567f, 95.333336f, 176.66667f, 108.764336f, 176.66667f, 125.333336f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h2 = c.h(looper);
                h2.moveTo(144.0f, 128.0f);
                h2.lineTo(133.33333f, 128.0f);
                h2.lineTo(133.33333f, 122.666664f);
                h2.lineTo(144.0f, 122.666664f);
                h2.lineTo(144.0f, 112.0f);
                h2.lineTo(149.33333f, 112.0f);
                h2.lineTo(149.33333f, 122.666664f);
                h2.lineTo(160.0f, 122.666664f);
                h2.lineTo(160.0f, 128.0f);
                h2.lineTo(149.33333f, 128.0f);
                h2.lineTo(149.33333f, 138.66667f);
                h2.lineTo(144.0f, 138.66667f);
                h2.lineTo(144.0f, 128.0f);
                h2.close();
                h2.moveTo(122.666664f, 125.33551f);
                h2.cubicTo(122.666664f, 126.548035f, 122.7566f, 127.739555f, 122.93015f, 128.90376f);
                h2.cubicTo(124.65374f, 140.46556f, 134.62491f, 149.33333f, 146.66667f, 149.33333f);
                h2.cubicTo(159.92313f, 149.33333f, 170.66667f, 138.5898f, 170.66667f, 125.33551f);
                h2.cubicTo(170.66667f, 112.07905f, 159.92313f, 101.333336f, 146.66667f, 101.333336f);
                h2.cubicTo(133.41238f, 101.333336f, 122.666664f, 112.07905f, 122.666664f, 125.33551f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
