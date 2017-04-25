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

public final class hj extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(60.0f, 0.0f);
                h.lineTo(60.0f, 60.0f);
                h.lineTo(0.0f, 60.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(9.0f, 14.380721f);
                h.cubicTo(9.0f, 11.409031f, 11.404006f, 9.0f, 14.380721f, 9.0f);
                h.lineTo(46.619278f, 9.0f);
                h.cubicTo(49.59097f, 9.0f, 52.0f, 11.404006f, 52.0f, 14.380721f);
                h.lineTo(52.0f, 46.619278f);
                h.cubicTo(52.0f, 49.59097f, 49.595993f, 52.0f, 46.619278f, 52.0f);
                h.lineTo(14.380721f, 52.0f);
                h.cubicTo(11.409031f, 52.0f, 9.0f, 49.595993f, 9.0f, 46.619278f);
                h.lineTo(9.0f, 14.380721f);
                h.lineTo(9.0f, 14.380721f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-964550);
                h = c.h(looper);
                h.moveTo(6.0f, 12.006387f);
                h.cubicTo(6.0f, 8.689151f, 8.683541f, 6.0f, 12.006387f, 6.0f);
                h.lineTo(47.993614f, 6.0f);
                h.cubicTo(51.31085f, 6.0f, 54.0f, 8.683541f, 54.0f, 12.006387f);
                h.lineTo(54.0f, 47.993614f);
                h.cubicTo(54.0f, 51.31085f, 51.31646f, 54.0f, 47.993614f, 54.0f);
                h.lineTo(12.006387f, 54.0f);
                h.cubicTo(8.689151f, 54.0f, 6.0f, 51.31646f, 6.0f, 47.993614f);
                h.lineTo(6.0f, 12.006387f);
                h.lineTo(6.0f, 12.006387f);
                h.close();
                h.moveTo(12.0f, 32.576923f);
                h.lineTo(16.2f, 28.538462f);
                h.lineTo(25.0f, 36.923077f);
                h.lineTo(43.8f, 19.0f);
                h.lineTo(48.0f, 23.038462f);
                h.lineTo(25.0f, 45.0f);
                h.lineTo(12.0f, 32.576923f);
                h.lineTo(12.0f, 32.576923f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
