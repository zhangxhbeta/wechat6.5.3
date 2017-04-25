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

public final class adt extends c {
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
                g.setColor(-9318371);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(47.999f, 15.0f);
                h.cubicTo(29.773f, 15.0f, 15.0f, 29.774f, 15.0f, 48.0f);
                h.cubicTo(15.0f, 66.226f, 29.773f, 81.0f, 47.999f, 81.0f);
                h.cubicTo(66.225f, 81.0f, 81.0f, 66.226f, 81.0f, 48.0f);
                h.cubicTo(81.0f, 29.774f, 66.225f, 15.0f, 47.999f, 15.0f);
                h.lineTo(47.999f, 15.0f);
                h.close();
                h.moveTo(62.0f, 31.0f);
                h.cubicTo(64.762f, 31.0f, 67.0f, 33.462f, 67.0f, 36.5f);
                h.cubicTo(67.0f, 39.538f, 64.762f, 42.0f, 62.0f, 42.0f);
                h.cubicTo(59.238f, 42.0f, 57.0f, 39.538f, 57.0f, 36.5f);
                h.cubicTo(57.0f, 33.462f, 59.238f, 31.0f, 62.0f, 31.0f);
                h.lineTo(62.0f, 31.0f);
                h.close();
                h.moveTo(35.0f, 31.0f);
                h.cubicTo(37.762f, 31.0f, 40.0f, 33.462f, 40.0f, 36.5f);
                h.cubicTo(40.0f, 39.538f, 37.762f, 42.0f, 35.0f, 42.0f);
                h.cubicTo(32.238f, 42.0f, 30.0f, 39.538f, 30.0f, 36.5f);
                h.cubicTo(30.0f, 33.462f, 32.238f, 31.0f, 35.0f, 31.0f);
                h.lineTo(35.0f, 31.0f);
                h.close();
                h.moveTo(48.0f, 71.0f);
                h.cubicTo(28.667f, 71.0f, 26.0f, 53.0f, 26.0f, 53.0f);
                h.cubicTo(26.0f, 53.0f, 40.361f, 51.0f, 48.0f, 51.0f);
                h.cubicTo(55.639f, 51.0f, 70.0f, 53.0f, 70.0f, 53.0f);
                h.cubicTo(70.0f, 53.0f, 67.333f, 71.0f, 48.0f, 71.0f);
                h.lineTo(48.0f, 71.0f);
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
