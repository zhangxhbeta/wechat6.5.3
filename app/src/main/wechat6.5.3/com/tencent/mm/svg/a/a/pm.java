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

public final class pm extends c {
    private final int height = 24;
    private final int width = 24;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 24;
            case 1:
                return 24;
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
                canvas.saveLayerAlpha(null, 153, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(0.5f, 0.0f);
                h.lineTo(1.32f, 0.0f);
                h.cubicTo(5.04f, 3.33f, 8.42f, 7.02f, 12.0f, 10.5f);
                h.cubicTo(15.57f, 7.02f, 18.96f, 3.36f, 22.63f, 0.0f);
                h.lineTo(23.38f, 0.0f);
                h.lineTo(23.52f, 0.52f);
                h.lineTo(24.0f, 0.5f);
                h.lineTo(24.0f, 1.32f);
                h.cubicTo(20.67f, 5.04f, 16.98f, 8.42f, 13.5f, 12.0f);
                h.cubicTo(16.99f, 15.56f, 20.63f, 18.96f, 24.0f, 22.63f);
                h.lineTo(24.0f, 23.38f);
                h.lineTo(23.48f, 23.52f);
                h.lineTo(23.5f, 24.0f);
                h.lineTo(22.67f, 24.0f);
                h.cubicTo(18.96f, 20.66f, 15.58f, 16.98f, 12.0f, 13.51f);
                h.cubicTo(8.43f, 16.98f, 5.04f, 20.65f, 1.35f, 24.0f);
                h.lineTo(0.55f, 24.0f);
                h.lineTo(0.56f, 23.47f);
                h.lineTo(0.0f, 23.48f);
                h.lineTo(0.0f, 22.69f);
                h.cubicTo(3.32f, 18.96f, 7.02f, 15.59f, 10.48f, 12.0f);
                h.cubicTo(7.02f, 8.43f, 3.36f, 5.04f, 0.0f, 1.37f);
                h.lineTo(0.0f, 0.62f);
                h.lineTo(0.52f, 0.48f);
                h.lineTo(0.5f, 0.0f);
                h.lineTo(0.5f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
