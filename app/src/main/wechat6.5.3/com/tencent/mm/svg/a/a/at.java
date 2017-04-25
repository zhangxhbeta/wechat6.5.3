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

public final class at extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                g2.setColor(-13917627);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(180.0f, 0.0f);
                h.lineTo(180.0f, 180.0f);
                h.lineTo(0.0f, 180.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(49.799175f, 34.8f);
                h2.cubicTo(48.142776f, 34.8f, 46.8f, 36.136326f, 46.8f, 37.79583f);
                h2.lineTo(46.8f, 142.20418f);
                h2.cubicTo(46.8f, 143.85872f, 48.139797f, 145.2f, 49.799175f, 145.2f);
                h2.lineTo(130.20082f, 145.2f);
                h2.cubicTo(131.85722f, 145.2f, 133.2f, 143.86368f, 133.2f, 142.20418f);
                h2.lineTo(133.2f, 37.79583f);
                h2.cubicTo(133.2f, 36.141277f, 131.8602f, 34.8f, 130.20082f, 34.8f);
                h2.lineTo(49.799175f, 34.8f);
                h2.close();
                h2.moveTo(88.8f, 84.0f);
                h2.lineTo(88.8f, 90.0f);
                h2.lineTo(57.6f, 90.0f);
                h2.lineTo(57.6f, 84.0f);
                h2.lineTo(88.8f, 84.0f);
                h2.close();
                h2.moveTo(108.0f, 67.2f);
                h2.lineTo(108.0f, 73.2f);
                h2.lineTo(57.6f, 73.2f);
                h2.lineTo(57.6f, 67.2f);
                h2.lineTo(108.0f, 67.2f);
                h2.close();
                h2.moveTo(122.4f, 51.6f);
                h2.lineTo(122.4f, 57.6f);
                h2.lineTo(57.6f, 57.6f);
                h2.lineTo(57.6f, 51.6f);
                h2.lineTo(122.4f, 51.6f);
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
