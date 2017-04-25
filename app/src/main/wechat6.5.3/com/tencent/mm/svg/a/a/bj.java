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

public final class bj extends c {
    private final int height = 180;
    private final int width = 180;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 180;
            case 1:
                return 180;
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
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-12206054);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(180.0f, 0.0f);
                h.lineTo(180.0f, 180.0f);
                h.lineTo(0.0f, 180.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(63.6f, 84.0f);
                h2.lineTo(57.6f, 84.0f);
                h2.lineTo(57.6f, 96.0f);
                h2.cubicTo(57.6f, 113.19757f, 70.20018f, 127.524574f, 86.4f, 129.39359f);
                h2.lineTo(86.4f, 135.6f);
                h2.lineTo(72.30533f, 135.6f);
                h2.cubicTo(71.47396f, 135.6f, 70.8f, 136.26503f, 70.8f, 137.09857f);
                h2.lineTo(70.8f, 140.10143f);
                h2.cubicTo(70.8f, 140.92906f, 71.46651f, 141.6f, 72.30533f, 141.6f);
                h2.lineTo(107.69467f, 141.6f);
                h2.cubicTo(108.52605f, 141.6f, 109.2f, 140.93497f, 109.2f, 140.10143f);
                h2.lineTo(109.2f, 137.09857f);
                h2.cubicTo(109.2f, 136.27094f, 108.53349f, 135.6f, 107.69467f, 135.6f);
                h2.lineTo(93.6f, 135.6f);
                h2.lineTo(93.6f, 135.6f);
                h2.lineTo(93.6f, 129.39359f);
                h2.lineTo(93.6f, 129.39359f);
                h2.cubicTo(109.79982f, 127.524574f, 122.4f, 113.19757f, 122.4f, 96.0f);
                h2.lineTo(122.4f, 84.0f);
                h2.lineTo(116.4f, 84.0f);
                h2.lineTo(116.4f, 96.0f);
                h2.cubicTo(116.4f, 111.41272f, 104.580315f, 123.6f, 90.58667f, 123.6f);
                h2.cubicTo(75.419685f, 123.6f, 63.6f, 111.41272f, 63.6f, 96.0f);
                h2.lineTo(63.6f, 84.0f);
                h2.lineTo(63.6f, 84.0f);
                h2.close();
                h2.moveTo(90.0f, 39.6f);
                h2.cubicTo(79.39613f, 39.6f, 70.8f, 48.198677f, 70.8f, 58.79926f);
                h2.lineTo(70.8f, 96.00074f);
                h2.cubicTo(70.8f, 106.6042f, 79.3938f, 115.2f, 90.0f, 115.2f);
                h2.cubicTo(100.60387f, 115.2f, 109.2f, 106.601326f, 109.2f, 96.00074f);
                h2.lineTo(109.2f, 58.79926f);
                h2.cubicTo(109.2f, 48.1958f, 100.6062f, 39.6f, 90.0f, 39.6f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
