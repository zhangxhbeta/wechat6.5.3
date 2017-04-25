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

public final class lq extends c {
    private final int height = 135;
    private final int width = 135;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 135;
            case 1:
                return 135;
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
                g.setColor(-1758450);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(53.0f, 90.9f);
                h.lineTo(53.0f, 45.0f);
                h.lineTo(68.38789f, 45.0f);
                h.cubicTo(82.714066f, 45.0f, 90.05337f, 52.5208f, 90.05337f, 66.18516f);
                h.cubicTo(90.05337f, 79.84951f, 82.67495f, 90.9f, 68.38789f, 90.9f);
                h.lineTo(53.0f, 90.9f);
                h.lineTo(53.0f, 90.9f);
                h.close();
                h.moveTo(60.2f, 83.7f);
                h.lineTo(60.2f, 52.2f);
                h.cubicTo(60.2f, 52.2f, 58.222076f, 52.2f, 67.96531f, 52.2f);
                h.cubicTo(77.708534f, 52.2f, 82.7f, 57.361336f, 82.7f, 66.73883f);
                h.cubicTo(82.7f, 76.11633f, 77.68194f, 83.7f, 67.96531f, 83.7f);
                h.lineTo(60.2f, 83.7f);
                h.close();
                h.moveTo(14.0f, 90.9f);
                h.lineTo(14.0f, 45.0f);
                h.lineTo(33.15862f, 45.0f);
                h.cubicTo(40.12882f, 45.0f, 44.965256f, 49.947903f, 46.131035f, 52.06154f);
                h.cubicTo(47.296814f, 54.17517f, 47.9f, 56.000126f, 47.9f, 58.534615f);
                h.cubicTo(47.9f, 62.1786f, 46.66678f, 65.48174f, 44.36207f, 67.95f);
                h.cubicTo(41.733814f, 70.88791f, 38.46552f, 72.65769f, 31.979311f, 72.9f);
                h.cubicTo(25.493103f, 72.65769f, 21.8f, 72.9f, 21.8f, 72.9f);
                h.lineTo(21.8f, 90.9f);
                h.lineTo(14.0f, 90.9f);
                h.close();
                h.moveTo(21.8f, 67.5f);
                h.lineTo(29.591892f, 67.5f);
                h.cubicTo(38.38185f, 67.5f, 40.1f, 61.555866f, 40.1f, 58.96552f);
                h.cubicTo(40.1f, 56.375168f, 38.091534f, 51.0f, 29.591892f, 51.0f);
                h.lineTo(21.8f, 51.0f);
                h.lineTo(21.8f, 67.5f);
                h.close();
                h.moveTo(95.0f, 45.0f);
                h.lineTo(95.0f, 90.9f);
                h.lineTo(102.2f, 90.9f);
                h.lineTo(102.2f, 69.3f);
                h.lineTo(123.8f, 69.3f);
                h.lineTo(123.8f, 63.0f);
                h.lineTo(102.2f, 63.0f);
                h.lineTo(102.2f, 52.2f);
                h.lineTo(126.5f, 52.2f);
                h.lineTo(126.5f, 45.0f);
                h.lineTo(95.0f, 45.0f);
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
