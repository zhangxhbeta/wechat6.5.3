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

public final class ts extends c {
    private final int height = 240;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 240;
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 48.0f, 0.0f, 1.0f, 54.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-1);
                a2.setStrokeWidth(4.0f);
                Path h = c.h(looper);
                h.moveTo(14.0f, 46.0f);
                h.lineTo(36.0f, 61.0f);
                h.lineTo(36.0f, 11.0f);
                h.lineTo(14.0f, 26.0f);
                h.lineTo(0.0f, 26.0f);
                h.lineTo(0.0f, 46.0f);
                h.lineTo(14.0f, 46.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                Paint a3 = c.a(g, looper);
                a3.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(75.00751f, 72.117966f);
                h2.cubicTo(80.96203f, 61.445175f, 84.35507f, 49.148323f, 84.35507f, 36.058983f);
                h2.cubicTo(84.35507f, 22.969645f, 80.96203f, 10.672792f, 75.00751f, 0.0f);
                h2.lineTo(75.00751f, 0.0f);
                h2.lineTo(71.0f, 2.9665983f);
                h2.cubicTo(76.36485f, 12.796429f, 79.413895f, 24.071636f, 79.413895f, 36.058983f);
                h2.cubicTo(79.413895f, 48.046333f, 76.36485f, 59.321537f, 71.0f, 69.15137f);
                h2.lineTo(75.00751f, 72.117966f);
                h2.close();
                h2.moveTo(62.93931f, 63.29133f);
                h2.cubicTo(67.135056f, 55.157722f, 69.50414f, 45.92836f, 69.50414f, 36.145664f);
                h2.cubicTo(69.50414f, 26.36297f, 67.135056f, 17.133606f, 62.93931f, 9.0f);
                h2.lineTo(62.93931f, 9.0f);
                h2.lineTo(59.0f, 11.916111f);
                h2.cubicTo(62.71647f, 19.272243f, 64.81003f, 27.587996f, 64.81003f, 36.392723f);
                h2.cubicTo(64.81003f, 45.053913f, 62.784172f, 53.241943f, 59.180466f, 60.50881f);
                h2.lineTo(62.93931f, 63.29133f);
                h2.lineTo(62.93931f, 63.29133f);
                h2.close();
                h2.moveTo(51.07929f, 54.336704f);
                h2.cubicTo(53.565243f, 48.789673f, 54.94784f, 42.640472f, 54.94784f, 36.16835f);
                h2.cubicTo(54.94784f, 29.69623f, 53.565243f, 23.547031f, 51.07929f, 18.0f);
                h2.lineTo(51.07929f, 18.0f);
                h2.lineTo(47.0f, 21.019733f);
                h2.cubicTo(48.937286f, 25.685192f, 50.006668f, 30.801888f, 50.006668f, 36.16835f);
                h2.cubicTo(50.006668f, 41.534813f, 48.937286f, 46.651512f, 47.0f, 51.316967f);
                h2.lineTo(51.07929f, 54.336704f);
                h2.lineTo(51.07929f, 54.336704f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
