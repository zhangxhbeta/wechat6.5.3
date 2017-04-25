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

public final class wp extends c {
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
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(68.0f, 71.0f);
                h.lineTo(22.0f, 71.0f);
                h.lineTo(22.0f, 37.0f);
                h.lineTo(31.521f, 37.0f);
                h.cubicTo(32.823f, 34.063f, 34.368f, 31.769f, 36.079f, 30.0f);
                h.lineTo(18.0f, 30.0f);
                h.cubicTo(16.343f, 30.0f, 15.0f, 31.343f, 15.0f, 33.0f);
                h.lineTo(15.0f, 75.0f);
                h.cubicTo(15.0f, 76.657f, 16.343f, 78.0f, 18.0f, 78.0f);
                h.lineTo(72.0f, 78.0f);
                h.cubicTo(73.656f, 78.0f, 75.0f, 76.657f, 75.0f, 75.0f);
                h.lineTo(75.0f, 53.22f);
                h.lineTo(68.0f, 59.13f);
                h.lineTo(68.0f, 71.0f);
                h.lineTo(68.0f, 71.0f);
                h.close();
                h.moveTo(60.0f, 19.0f);
                h.lineTo(60.0f, 30.019f);
                h.cubicTo(58.325f, 30.008f, 56.583f, 30.0f, 55.0f, 30.0f);
                h.cubicTo(41.334f, 30.0f, 32.055f, 43.333f, 32.055f, 61.0f);
                h.cubicTo(36.721f, 50.16f, 41.284f, 45.0f, 60.0f, 45.0f);
                h.lineTo(60.0f, 56.0f);
                h.lineTo(74.452f, 43.848f);
                h.lineTo(75.0f, 44.357f);
                h.lineTo(75.0f, 43.386f);
                h.lineTo(82.0f, 37.5f);
                h.lineTo(60.0f, 19.0f);
                h.lineTo(60.0f, 19.0f);
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
