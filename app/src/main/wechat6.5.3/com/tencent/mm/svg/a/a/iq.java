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

public final class iq extends c {
    private final int height = 69;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 69;
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
                g.setColor(-9473160);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(85.0f, 52.0f);
                h.lineTo(54.0f, 52.0f);
                h.lineTo(43.0f, 52.0f);
                h.lineTo(11.0f, 52.0f);
                h.lineTo(11.0f, 6.0f);
                h.lineTo(85.0f, 6.0f);
                h.lineTo(85.0f, 52.0f);
                h.close();
                h.moveTo(56.513f, 63.0f);
                h.lineTo(40.487f, 63.0f);
                h.lineTo(46.0f, 61.162f);
                h.lineTo(46.0f, 55.0f);
                h.lineTo(51.0f, 55.0f);
                h.lineTo(51.0f, 61.162f);
                h.lineTo(56.513f, 63.0f);
                h.close();
                h.moveTo(85.129f, 3.0f);
                h.lineTo(10.871f, 3.0f);
                h.cubicTo(9.289f, 3.0f, 8.0f, 4.285f, 8.0f, 5.87f);
                h.lineTo(8.0f, 52.13f);
                h.cubicTo(8.0f, 53.715f, 9.285f, 55.0f, 10.871f, 55.0f);
                h.lineTo(43.0f, 55.0f);
                h.lineTo(43.0f, 59.0f);
                h.lineTo(31.0f, 63.0f);
                h.lineTo(31.0f, 66.0f);
                h.lineTo(66.0f, 66.0f);
                h.lineTo(66.0f, 63.0f);
                h.lineTo(54.0f, 59.0f);
                h.lineTo(54.0f, 55.0f);
                h.lineTo(85.129f, 55.0f);
                h.cubicTo(86.711f, 55.0f, 88.0f, 53.715f, 88.0f, 52.13f);
                h.lineTo(88.0f, 5.87f);
                h.cubicTo(88.0f, 4.285f, 86.715f, 3.0f, 85.129f, 3.0f);
                h.lineTo(85.129f, 3.0f);
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
