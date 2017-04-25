package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class kx extends c {
    private final int height = 98;
    private final int width = 98;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 98;
            case 1:
                return 98;
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
                g = c.a(g2, looper);
                g.setStrokeWidth(1.0f);
                g = c.a(g, looper);
                g.setColor(-7368817);
                g.setStrokeWidth(4.0f);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(3.0004194f, 12.0f);
                h.cubicTo(2.4479032f, 12.0f, 2.0f, 12.455173f, 2.0f, 13.00042f);
                h.lineTo(2.0f, 46.99958f);
                h.cubicTo(2.0f, 47.552097f, 2.455173f, 48.0f, 3.0004194f, 48.0f);
                h.lineTo(36.99958f, 48.0f);
                h.cubicTo(37.552097f, 48.0f, 38.0f, 47.544827f, 38.0f, 46.99958f);
                h.lineTo(38.0f, 13.00042f);
                h.cubicTo(38.0f, 12.447903f, 37.544827f, 12.0f, 36.99958f, 12.0f);
                h.lineTo(3.0004194f, 12.0f);
                h.close();
                h.moveTo(3.0004194f, 60.0f);
                h.cubicTo(2.4479032f, 60.0f, 2.0f, 60.455173f, 2.0f, 61.00042f);
                h.lineTo(2.0f, 94.99958f);
                h.cubicTo(2.0f, 95.55209f, 2.455173f, 96.0f, 3.0004194f, 96.0f);
                h.lineTo(36.99958f, 96.0f);
                h.cubicTo(37.552097f, 96.0f, 38.0f, 95.54483f, 38.0f, 94.99958f);
                h.lineTo(38.0f, 61.00042f);
                h.cubicTo(38.0f, 60.447903f, 37.544827f, 60.0f, 36.99958f, 60.0f);
                h.lineTo(3.0004194f, 60.0f);
                h.close();
                h.moveTo(60.902344f, 60.0f);
                h.lineTo(50.999195f, 60.0f);
                h.cubicTo(50.447353f, 60.0f, 50.0f, 60.455173f, 50.0f, 61.00042f);
                h.lineTo(50.0f, 94.99958f);
                h.cubicTo(50.0f, 95.55209f, 50.455173f, 96.0f, 51.00042f, 96.0f);
                h.lineTo(84.99958f, 96.0f);
                h.cubicTo(85.55209f, 96.0f, 86.0f, 95.54483f, 86.0f, 94.99958f);
                h.lineTo(86.0f, 61.00042f);
                h.cubicTo(86.0f, 60.447903f, 85.55397f, 60.0f, 85.00935f, 60.0f);
                h.lineTo(60.902344f, 60.0f);
                h.close();
                h.moveTo(47.142284f, 45.904037f);
                h.cubicTo(47.142284f, 45.904037f, 51.363903f, 20.459272f, 61.107952f, 15.374091f);
                h.cubicTo(70.852005f, 10.288909f, 86.702644f, 11.313487f, 93.393394f, 3.1734254f);
                h.cubicTo(95.04211f, 1.1675812f, 96.99486f, 16.993193f, 90.43264f, 30.96363f);
                h.cubicTo(83.87043f, 44.93407f, 68.47119f, 42.520203f, 60.54587f, 42.00791f);
                h.cubicTo(52.620552f, 41.495625f, 47.142284f, 45.904037f, 47.142284f, 45.904037f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
