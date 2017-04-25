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

public final class xi extends c {
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
                Paint a = c.a(g, looper);
                a.setColor(-8617594);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 50.0f, 0.0f, 1.0f, 38.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(12.770331f, 24.77644f);
                h.lineTo(7.3576727f, 21.65144f);
                h.lineTo(4.84934f, 25.995998f);
                h.cubicTo(-3.6885855f, 40.78412f, -0.6132603f, 59.150406f, 11.409091f, 69.63418f);
                h.lineTo(5.4629607f, 79.933174f);
                h.lineTo(16.288279f, 86.183174f);
                h.lineTo(22.23441f, 75.88418f);
                h.lineTo(22.23441f, 75.88418f);
                h.cubicTo(37.324795f, 81.053955f, 54.768127f, 74.53412f, 63.306053f, 59.746f);
                h.lineTo(65.814384f, 55.40144f);
                h.lineTo(60.40173f, 52.27644f);
                h.lineTo(57.893394f, 56.621f);
                h.cubicTo(49.83918f, 70.57131f, 32.80783f, 75.44613f, 20.184023f, 68.157776f);
                h.cubicTo(6.501737f, 60.2583f, 2.207783f, 43.07131f, 10.261999f, 29.120998f);
                h.lineTo(12.770331f, 24.77644f);
                h.lineTo(12.770331f, 24.77644f);
                h.close();
                h.moveTo(57.279774f, 2.683821f);
                h.cubicTo(47.713924f, -2.8390265f, 35.48474f, 0.43392453f, 29.959208f, 10.004432f);
                h.lineTo(16.459326f, 33.386913f);
                h.cubicTo(10.936446f, 42.95282f, 14.21182f, 55.18346f, 23.779776f, 60.707523f);
                h.cubicTo(33.345627f, 66.23037f, 45.574806f, 62.95742f, 51.10034f, 53.386913f);
                h.lineTo(64.60023f, 30.00443f);
                h.cubicTo(70.12311f, 20.438522f, 66.84773f, 8.207883f, 57.279774f, 2.683821f);
                h.lineTo(57.279774f, 2.683821f);
                h.close();
                h.moveTo(4.351049f, 83.59714f);
                h.cubicTo(4.272484f, 82.7733f, 4.7908106f, 82.44148f, 5.5145807f, 82.85935f);
                h.lineTo(13.728326f, 87.60156f);
                h.cubicTo(14.4494915f, 88.01793f, 14.420938f, 88.635574f, 13.671152f, 88.9781f);
                h.lineTo(6.5948305f, 92.21079f);
                h.cubicTo(5.8420887f, 92.55467f, 5.167873f, 92.16235f, 5.089617f, 91.34176f);
                h.lineTo(4.351049f, 83.59714f);
                h.lineTo(4.351049f, 83.59714f);
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
