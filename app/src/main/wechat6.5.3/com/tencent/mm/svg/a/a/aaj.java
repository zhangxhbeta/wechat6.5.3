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

public final class aaj extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                g2 = c.a(g, looper);
                g2.setColor(-16896);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(22.7f, 0.0f);
                h.lineTo(25.07f, 0.0f);
                h.cubicTo(36.94f, 0.34f, 47.3f, 10.5f, 48.0f, 22.33f);
                h.lineTo(48.0f, 25.39f);
                h.cubicTo(47.47f, 37.15f, 37.36f, 47.34f, 25.6f, 48.0f);
                h.lineTo(22.61f, 48.0f);
                h.cubicTo(10.79f, 47.47f, 0.57f, 37.25f, 0.0f, 25.44f);
                h.lineTo(0.0f, 22.47f);
                h.cubicTo(0.61f, 10.66f, 10.88f, 0.5f, 22.7f, 0.0f);
                h.lineTo(22.7f, 0.0f);
                h.close();
                h.moveTo(23.290903f, 13.335449f);
                h.cubicTo(20.390598f, 14.737528f, 22.898153f, 19.267319f, 25.697754f, 17.65934f);
                h.cubicTo(28.628271f, 16.237654f, 26.080433f, 11.747081f, 23.290903f, 13.335449f);
                h.lineTo(23.290903f, 13.335449f);
                h.close();
                h.moveTo(20.0f, 20.0f);
                h.lineTo(20.00998f, 20.98f);
                h.cubicTo(20.758484f, 20.99f, 22.25549f, 21.01f, 23.003992f, 21.02f);
                h.lineTo(23.003992f, 34.98f);
                h.cubicTo(22.25549f, 34.99f, 20.758484f, 35.01f, 20.00998f, 35.02f);
                h.lineTo(20.00998f, 36.0f);
                h.lineTo(30.0f, 36.0f);
                h.lineTo(29.99002f, 35.02f);
                h.cubicTo(29.241516f, 35.01f, 27.74451f, 34.99f, 26.996008f, 34.98f);
                h.cubicTo(26.996008f, 29.99f, 27.005987f, 24.99f, 26.996008f, 20.0f);
                h.lineTo(20.0f, 20.0f);
                h.lineTo(20.0f, 20.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                float[] a2 = c.a(c, 1.0f, 0.0f, 20.0f, 0.0f, 1.0f, 13.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(3.290903f, 0.33544943f);
                h.cubicTo(6.080433f, -1.2529188f, 8.628271f, 3.2376533f, 5.697754f, 4.659341f);
                h.cubicTo(2.8981533f, 6.2673187f, 0.39059758f, 1.7375276f, 3.290903f, 0.33544943f);
                h.lineTo(3.290903f, 0.33544943f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(0.0f, 7.0f);
                h.lineTo(6.996008f, 7.0f);
                h.cubicTo(7.005988f, 11.99f, 6.996008f, 16.99f, 6.996008f, 21.98f);
                h.cubicTo(7.744511f, 21.99f, 9.241517f, 22.01f, 9.99002f, 22.02f);
                h.lineTo(10.0f, 23.0f);
                h.lineTo(0.00998004f, 23.0f);
                h.lineTo(0.00998004f, 22.02f);
                h.cubicTo(0.75848305f, 22.01f, 2.255489f, 21.99f, 3.003992f, 21.98f);
                h.lineTo(3.003992f, 8.02f);
                h.cubicTo(2.255489f, 8.01f, 0.75848305f, 7.99f, 0.00998004f, 7.98f);
                h.lineTo(0.0f, 7.0f);
                h.lineTo(0.0f, 7.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
