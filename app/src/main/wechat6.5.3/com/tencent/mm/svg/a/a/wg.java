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

public final class wg extends c {
    private final int height = 96;
    private final int width = 96;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 96;
            case 1:
                return 96;
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
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(47.999f, 33.0f);
                h.cubicTo(48.731f, 33.0f, 49.446f, 33.07f, 50.15f, 33.172f);
                h.lineTo(35.518f, 18.54f);
                h.cubicTo(28.743f, 21.415f, 23.158f, 26.549f, 19.726f, 33.009f);
                h.lineTo(47.836f, 33.009f);
                h.cubicTo(47.892f, 33.009f, 47.944f, 33.0f, 47.999f, 33.0f);
                h.lineTo(47.999f, 33.0f);
                h.close();
                h.moveTo(62.999f, 19.75f);
                h.lineTo(62.999f, 48.0f);
                h.cubicTo(62.999f, 48.715f, 62.932f, 49.413f, 62.835f, 50.101f);
                h.lineTo(77.455f, 35.48f);
                h.cubicTo(74.58f, 28.725f, 69.44f, 23.178f, 62.999f, 19.75f);
                h.lineTo(62.999f, 19.75f);
                h.close();
                h.moveTo(58.624f, 37.414f);
                h.cubicTo(59.124f, 37.915f, 59.574f, 38.462f, 59.999f, 39.029f);
                h.lineTo(59.999f, 18.337f);
                h.cubicTo(56.292f, 16.836f, 52.245f, 16.0f, 47.999f, 16.0f);
                h.cubicTo(44.737f, 16.0f, 41.595f, 16.501f, 38.63f, 17.409f);
                h.lineTo(58.63f, 37.409f);
                h.lineTo(58.624f, 37.414f);
                h.lineTo(58.624f, 37.414f);
                h.close();
                h.moveTo(39.023f, 36.009f);
                h.lineTo(18.331f, 36.009f);
                h.cubicTo(16.832f, 39.713f, 16.0f, 43.758f, 16.0f, 48.0f);
                h.cubicTo(16.0f, 51.279f, 16.507f, 54.437f, 17.424f, 57.416f);
                h.lineTo(36.871f, 37.969f);
                h.cubicTo(37.521f, 37.247f, 38.245f, 36.594f, 39.023f, 36.009f);
                h.lineTo(39.023f, 36.009f);
                h.close();
                h.moveTo(32.999f, 76.267f);
                h.lineTo(32.999f, 47.999f);
                h.cubicTo(32.999f, 47.292f, 33.065f, 46.602f, 33.16f, 45.921f);
                h.lineTo(18.557f, 60.524f);
                h.cubicTo(21.435f, 67.277f, 26.558f, 72.842f, 32.999f, 76.267f);
                h.lineTo(32.999f, 76.267f);
                h.close();
                h.moveTo(35.999f, 56.976f);
                h.lineTo(35.999f, 77.664f);
                h.cubicTo(39.706f, 79.165f, 43.754f, 79.999f, 47.999f, 79.999f);
                h.cubicTo(51.291f, 79.999f, 54.459f, 79.488f, 57.447f, 78.564f);
                h.lineTo(38.434f, 59.552f);
                h.cubicTo(37.521f, 58.797f, 36.711f, 57.926f, 35.999f, 56.976f);
                h.lineTo(35.999f, 56.976f);
                h.close();
                h.moveTo(78.59f, 38.589f);
                h.lineTo(58.948f, 58.231f);
                h.cubicTo(58.341f, 58.88f, 57.669f, 59.466f, 56.957f, 60.001f);
                h.lineTo(77.665f, 60.001f);
                h.cubicTo(79.166f, 56.294f, 80.0f, 52.246f, 80.0f, 48.001f);
                h.cubicTo(79.999f, 44.724f, 79.505f, 41.564f, 78.59f, 38.589f);
                h.lineTo(78.59f, 38.589f);
                h.close();
                h.moveTo(45.971f, 62.847f);
                h.lineTo(60.554f, 77.43f);
                h.cubicTo(67.293f, 74.55f, 72.846f, 69.431f, 76.267f, 63.0f);
                h.lineTo(47.999f, 63.0f);
                h.cubicTo(47.31f, 63.0f, 46.636f, 62.937f, 45.971f, 62.847f);
                h.lineTo(45.971f, 62.847f);
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
