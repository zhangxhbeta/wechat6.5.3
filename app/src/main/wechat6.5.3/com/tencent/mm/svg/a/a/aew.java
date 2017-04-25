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

public final class aew extends c {
    private final int height = 162;
    private final int width = 162;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 162;
            case 1:
                return 162;
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
                Path h = c.h(looper);
                h.moveTo(13.0f, 37.996094f);
                h.cubicTo(13.0f, 35.789112f, 14.782292f, 34.0f, 17.007507f, 34.0f);
                h.lineTo(145.9925f, 34.0f);
                h.cubicTo(148.20578f, 34.0f, 150.0f, 35.795326f, 150.0f, 37.996094f);
                h.lineTo(150.0f, 123.00391f);
                h.cubicTo(150.0f, 125.21089f, 148.21771f, 127.0f, 145.9925f, 127.0f);
                h.lineTo(17.007507f, 127.0f);
                h.cubicTo(14.794222f, 127.0f, 13.0f, 125.20467f, 13.0f, 123.00391f);
                h.lineTo(13.0f, 37.996094f);
                h.close();
                h.moveTo(23.0f, 52.0f);
                h.lineTo(140.0f, 52.0f);
                h.lineTo(140.0f, 69.0f);
                h.lineTo(23.0f, 69.0f);
                h.lineTo(23.0f, 52.0f);
                h.close();
                g2 = c.g(looper);
                g2.setFlags(385);
                g2.setStyle(Style.FILL);
                Paint g3 = c.g(looper);
                g3.setFlags(385);
                g3.setStyle(Style.STROKE);
                g2.setColor(WebView.NIGHT_MODE_COLOR);
                g3.setStrokeWidth(1.0f);
                g3.setStrokeCap(Cap.BUTT);
                g3.setStrokeJoin(Join.MITER);
                g3.setStrokeMiter(4.0f);
                g3.setPathEffect(null);
                float[] a2 = c.a(c, 150.0f, 0.0f, 13.0f, 0.0f, 127.0f, 34.0f);
                d.reset();
                d.setValues(a2);
                WeChatSVGRenderC2Java.setLinearGradient(a, 0.5f, 0.0f, 0.5f, 1.0f, new int[]{-9919532, -10117428}, new float[]{0.0f, 1.0f}, d, 0);
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
