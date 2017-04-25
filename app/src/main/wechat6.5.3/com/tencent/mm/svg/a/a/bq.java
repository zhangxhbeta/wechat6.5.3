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

public final class bq extends c {
    private final int height = 279;
    private final int width = 279;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 279;
            case 1:
                return 279;
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
                c = c.a(c, 1.0f, 0.0f, -144.0f, 0.0f, 1.0f, -69.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 144.0f, 0.0f, 1.0f, 69.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-3552823);
                Path h = c.h(looper);
                h.moveTo(279.0f, 141.1269f);
                h.cubicTo(279.0f, 62.751225f, 216.54533f, 0.60727614f, 137.77777f, 0.60727614f);
                h.cubicTo(62.454666f, 0.60727614f, 0.0f, 62.751225f, 0.0f, 141.1269f);
                h.cubicTo(0.0f, 216.07527f, 62.454666f, 278.2192f, 137.77777f, 278.2192f);
                h.cubicTo(216.54533f, 278.2192f, 279.0f, 216.07527f, 279.0f, 141.1269f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(131.70822f, 71.3711f);
                h.cubicTo(128.45819f, 71.3711f, 125.94605f, 74.00451f, 126.09674f, 77.24315f);
                h.lineTo(130.2428f, 166.35248f);
                h.cubicTo(130.31987f, 168.00896f, 131.72324f, 169.35179f, 133.37312f, 169.35179f);
                h.lineTo(145.62688f, 169.35179f);
                h.cubicTo(147.27864f, 169.35179f, 148.68036f, 168.004f, 148.7572f, 166.35248f);
                h.lineTo(152.90326f, 77.24315f);
                h.cubicTo(153.05415f, 74.00011f, 150.54134f, 71.3711f, 147.29178f, 71.3711f);
                h.lineTo(131.70822f, 71.3711f);
                h.close();
                h.moveTo(139.5f, 212.89876f);
                h.cubicTo(147.0533f, 212.89876f, 153.17647f, 206.80606f, 153.17647f, 199.29033f);
                h.cubicTo(153.17647f, 191.7746f, 147.0533f, 185.6819f, 139.5f, 185.6819f);
                h.cubicTo(131.9467f, 185.6819f, 125.82353f, 191.7746f, 125.82353f, 199.29033f);
                h.cubicTo(125.82353f, 206.80606f, 131.9467f, 212.89876f, 139.5f, 212.89876f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
