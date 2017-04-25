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

public final class vg extends c {
    private final int height = 144;
    private final int width = 144;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 144;
            case 1:
                return 144;
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
                g.setColor(-12864012);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(61.0f, 28.0f);
                h.cubicTo(69.75619f, 24.513273f, 80.44056f, 25.540365f, 88.0f, 31.0f);
                h.cubicTo(99.49052f, 38.12475f, 105.527336f, 51.995487f, 104.0f, 65.0f);
                h.cubicTo(110.17489f, 71.84929f, 114.192764f, 81.232735f, 114.0f, 91.0f);
                h.cubicTo(113.86294f, 93.936775f, 113.43317f, 97.58644f, 111.0f, 100.0f);
                h.cubicTo(107.31639f, 98.0252f, 105.30745f, 95.013725f, 103.0f, 92.0f);
                h.cubicTo(102.95869f, 95.35277f, 101.62939f, 98.33433f, 100.0f, 101.0f);
                h.cubicTo(103.068634f, 102.62219f, 106.66673f, 105.61372f, 106.0f, 110.0f);
                h.cubicTo(105.547325f, 114.269226f, 101.06969f, 116.8918f, 97.0f, 118.0f);
                h.cubicTo(89.645706f, 120.112686f, 80.430565f, 118.98587f, 75.0f, 113.0f);
                h.cubicTo(73.86403f, 112.59396f, 72.29485f, 112.59396f, 71.0f, 113.0f);
                h.cubicTo(65.968185f, 118.73658f, 57.23279f, 119.93319f, 50.0f, 118.0f);
                h.cubicTo(45.678883f, 117.26076f, 40.611553f, 114.58832f, 40.0f, 110.0f);
                h.cubicTo(39.50214f, 106.132256f, 42.310658f, 103.459816f, 45.0f, 102.0f);
                h.cubicTo(42.580517f, 98.952576f, 41.071312f, 95.65192f, 41.0f, 92.0f);
                h.cubicTo(38.672577f, 95.00375f, 36.67363f, 98.055115f, 33.0f, 100.0f);
                h.cubicTo(30.556854f, 97.556526f, 30.12708f, 93.91683f, 30.0f, 91.0f);
                h.cubicTo(29.80725f, 81.22276f, 33.815136f, 71.84929f, 40.0f, 65.0f);
                h.cubicTo(37.763058f, 50.021076f, 46.53843f, 33.687305f, 61.0f, 28.0f);
                h.lineTo(61.0f, 28.0f);
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
