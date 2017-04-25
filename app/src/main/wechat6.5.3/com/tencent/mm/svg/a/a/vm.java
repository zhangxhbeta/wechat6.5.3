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

public final class vm extends c {
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 10.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(23.0f, 1.0f);
                h.cubicTo(28.777954f, -1.1186252f, 35.400658f, 0.56103134f, 39.0f, 5.0f);
                h.cubicTo(41.067303f, 8.92932f, 40.778492f, 13.488388f, 41.0f, 18.0f);
                h.cubicTo(40.1212f, 22.556534f, 36.277046f, 26.055819f, 35.0f, 30.0f);
                h.cubicTo(33.618004f, 32.64447f, 35.0023f, 34.973995f, 37.0f, 36.0f);
                h.cubicTo(42.451595f, 39.88299f, 48.875122f, 42.39248f, 54.0f, 47.0f);
                h.cubicTo(56.603268f, 49.061115f, 57.0813f, 55.329834f, 53.0f, 56.0f);
                h.cubicTo(36.585773f, 56.069683f, 20.273008f, 55.959705f, 4.0f, 56.0f);
                h.cubicTo(-0.89972633f, 56.339626f, -0.93956214f, 49.261074f, 2.0f, 47.0f);
                h.cubicTo(7.226779f, 42.172523f, 14.028744f, 39.73302f, 20.0f, 36.0f);
                h.cubicTo(21.796728f, 34.26414f, 22.314592f, 31.33474f, 21.0f, 29.0f);
                h.cubicTo(18.45052f, 24.816072f, 14.805542f, 20.506954f, 15.0f, 15.0f);
                h.cubicTo(14.566527f, 9.139277f, 17.364994f, 2.430649f, 23.0f, 1.0f);
                h.lineTo(23.0f, 1.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(59.0f, 14.0f);
                h.cubicTo(59.550797f, 11.291986f, 64.49609f, 11.311896f, 65.0f, 14.0f);
                h.cubicTo(65.09821f, 17.404175f, 64.91067f, 20.709135f, 65.0f, 24.0f);
                h.cubicTo(68.60236f, 24.073826f, 72.244705f, 23.884686f, 76.0f, 24.0f);
                h.cubicTo(77.397285f, 25.348026f, 77.338066f, 28.59326f, 76.0f, 30.0f);
                h.cubicTo(72.26445f, 30.11633f, 68.612236f, 29.92719f, 65.0f, 30.0f);
                h.cubicTo(64.91067f, 33.321743f, 65.108086f, 36.65657f, 65.0f, 40.0f);
                h.cubicTo(64.357895f, 42.699074f, 59.540924f, 42.66921f, 59.0f, 40.0f);
                h.cubicTo(58.89932f, 36.606796f, 59.106606f, 33.291878f, 59.0f, 30.0f);
                h.cubicTo(55.40504f, 29.92719f, 51.762695f, 30.11633f, 48.0f, 30.0f);
                h.cubicTo(46.659466f, 28.662943f, 46.56076f, 25.20866f, 48.0f, 24.0f);
                h.cubicTo(51.81205f, 23.874731f, 55.43465f, 24.073826f, 59.0f, 24.0f);
                h.cubicTo(59.106606f, 20.709135f, 58.90919f, 17.39422f, 59.0f, 14.0f);
                h.lineTo(59.0f, 14.0f);
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
