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

public final class jz extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(WebView.NIGHT_MODE_COLOR);
                canvas.saveLayerAlpha(null, 51, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(29.73f, 4.822f);
                h.cubicTo(15.804f, 4.822f, 4.514f, 16.111f, 4.514f, 30.038f);
                h.cubicTo(4.514f, 43.965f, 15.804f, 55.253f, 29.73f, 55.253f);
                h.cubicTo(43.656f, 55.253f, 54.946f, 43.963997f, 54.946f, 30.036999f);
                h.cubicTo(54.946f, 16.11f, 43.656f, 4.822f, 29.73f, 4.822f);
                h.close();
                h.moveTo(29.73f, 53.27f);
                h.cubicTo(16.898998f, 53.27f, 6.4969997f, 42.868f, 6.4969997f, 30.037f);
                h.cubicTo(6.4969997f, 17.206001f, 16.899f, 6.805f, 29.73f, 6.805f);
                h.cubicTo(42.561f, 6.805f, 52.962997f, 17.207f, 52.962997f, 30.038f);
                h.cubicTo(52.962997f, 42.869f, 42.561f, 53.27f, 29.73f, 53.27f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(31.23f, 15.037f);
                h2.lineTo(28.23f, 15.037f);
                h2.lineTo(28.23f, 28.537f);
                h2.lineTo(14.73f, 28.537f);
                h2.lineTo(14.73f, 31.537f);
                h2.lineTo(28.23f, 31.537f);
                h2.lineTo(28.23f, 45.037f);
                h2.lineTo(31.23f, 45.037f);
                h2.lineTo(31.23f, 31.537f);
                h2.lineTo(44.73f, 31.537f);
                h2.lineTo(44.73f, 28.537f);
                h2.lineTo(31.23f, 28.537f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
