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

public final class xm extends c {
    private final int height = 168;
    private final int width = 168;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 168;
            case 1:
                return 168;
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
                Paint a = c.a(g, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                Paint a2 = c.a(a, looper);
                a2.setColor(-1728053248);
                Path h = c.h(looper);
                h.moveTo(0.0f, 36.0f);
                h.cubicTo(0.0f, 16.117748f, 16.117748f, 0.0f, 36.0f, 0.0f);
                h.lineTo(132.0f, 0.0f);
                h.cubicTo(151.88225f, 0.0f, 168.0f, 16.117748f, 168.0f, 36.0f);
                h.lineTo(168.0f, 132.0f);
                h.cubicTo(168.0f, 151.88225f, 151.88225f, 168.0f, 132.0f, 168.0f);
                h.lineTo(36.0f, 168.0f);
                h.cubicTo(16.117748f, 168.0f, 0.0f, 151.88225f, 0.0f, 132.0f);
                h.lineTo(0.0f, 36.0f);
                h.close();
                canvas.saveLayerAlpha(null, 25, 4);
                canvas.drawPath(h, c.a(a2, looper));
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                a.setColor(503316480);
                h = c.h(looper);
                h.moveTo(0.0f, 36.00155f);
                h.cubicTo(0.0f, 16.118443f, 16.108547f, 0.0f, 36.00155f, 0.0f);
                h.lineTo(131.99844f, 0.0f);
                h.cubicTo(151.88156f, 0.0f, 168.0f, 16.108547f, 168.0f, 36.00155f);
                h.lineTo(168.0f, 131.99844f);
                h.cubicTo(168.0f, 151.88156f, 151.89145f, 168.0f, 131.99844f, 168.0f);
                h.lineTo(36.00155f, 168.0f);
                h.cubicTo(16.118443f, 168.0f, 0.0f, 151.89145f, 0.0f, 131.99844f);
                h.lineTo(0.0f, 36.00155f);
                h.close();
                h.moveTo(2.0f, 37.00608f);
                h.cubicTo(2.0f, 17.672756f, 17.66928f, 2.0f, 37.00608f, 2.0f);
                h.lineTo(130.99391f, 2.0f);
                h.cubicTo(150.32724f, 2.0f, 166.0f, 17.66928f, 166.0f, 37.00608f);
                h.lineTo(166.0f, 130.99391f);
                h.cubicTo(166.0f, 150.32724f, 150.33072f, 166.0f, 130.99391f, 166.0f);
                h.lineTo(37.00608f, 166.0f);
                h.cubicTo(17.672756f, 166.0f, 2.0f, 150.33072f, 2.0f, 130.99391f);
                h.lineTo(2.0f, 37.00608f);
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
