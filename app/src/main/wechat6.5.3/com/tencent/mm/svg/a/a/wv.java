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

public final class wv extends c {
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
                h.moveTo(57.0f, 48.0f);
                h.cubicTo(57.0f, 50.762f, 59.238f, 53.0f, 62.0f, 53.0f);
                h.cubicTo(64.762f, 53.0f, 67.0f, 50.762f, 67.0f, 48.0f);
                h.cubicTo(67.0f, 45.239f, 64.762f, 43.0f, 62.0f, 43.0f);
                h.cubicTo(59.238f, 43.0f, 57.0f, 45.239f, 57.0f, 48.0f);
                h.close();
                h.moveTo(77.0f, 25.0f);
                h.lineTo(19.0f, 25.0f);
                h.cubicTo(17.344f, 25.0f, 16.0f, 26.343f, 16.0f, 28.0f);
                h.lineTo(16.0f, 68.0f);
                h.cubicTo(16.0f, 69.657f, 17.344f, 71.0f, 19.0f, 71.0f);
                h.lineTo(77.0f, 71.0f);
                h.cubicTo(78.656f, 71.0f, 80.0f, 69.657f, 80.0f, 68.0f);
                h.lineTo(80.0f, 58.0f);
                h.lineTo(62.0f, 58.0f);
                h.cubicTo(56.477f, 58.0f, 52.0f, 53.523f, 52.0f, 48.0f);
                h.cubicTo(52.0f, 42.478f, 56.477f, 38.0f, 62.0f, 38.0f);
                h.lineTo(80.0f, 38.0f);
                h.lineTo(80.0f, 28.0f);
                h.cubicTo(80.0f, 26.344f, 78.656f, 25.0f, 77.0f, 25.0f);
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
