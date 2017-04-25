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

public final class io extends c {
    private final int height = 67;
    private final int width = 84;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 84;
            case 1:
                return 67;
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
                a.setColor(-9538696);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 2.0f, 0.0f, 1.0f, 2.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(77.0f, 50.5601f);
                h.cubicTo(77.0f, 51.3551f, 76.36f, 52.0001f, 75.555f, 52.0001f);
                h.lineTo(49.0f, 52.0001f);
                h.lineTo(32.0f, 52.0001f);
                h.lineTo(4.445f, 52.0001f);
                h.cubicTo(3.647f, 52.0001f, 3.0f, 51.3621f, 3.0f, 50.5601f);
                h.lineTo(3.0f, 43.0001f);
                h.lineTo(77.0f, 43.0001f);
                h.lineTo(77.0f, 50.5601f);
                h.close();
                h.moveTo(33.232f, 60.0001f);
                h.lineTo(35.0f, 55.5781f);
                h.lineTo(35.0f, 55.0001f);
                h.lineTo(46.0f, 55.0001f);
                h.lineTo(46.0f, 55.5781f);
                h.lineTo(47.769f, 60.0001f);
                h.lineTo(33.232f, 60.0001f);
                h.close();
                h.moveTo(3.0f, 4.4401f);
                h.cubicTo(3.0f, 3.6451f, 3.64f, 3.0001f, 4.445f, 3.0001f);
                h.lineTo(75.555f, 3.0001f);
                h.cubicTo(76.353f, 3.0001f, 77.0f, 3.6371f, 77.0f, 4.4401f);
                h.lineTo(77.0f, 40.0001f);
                h.lineTo(3.0f, 40.0001f);
                h.lineTo(3.0f, 4.4401f);
                h.close();
                h.moveTo(75.685f, 1.0E-4f);
                h.lineTo(4.315f, 1.0E-4f);
                h.cubicTo(1.938f, 1.0E-4f, 0.0f, 1.9321f, 0.0f, 4.3161f);
                h.lineTo(0.0f, 50.6841f);
                h.cubicTo(0.0f, 53.0751f, 1.932f, 55.0001f, 4.315f, 55.0001f);
                h.lineTo(32.0f, 55.0001f);
                h.lineTo(30.0f, 60.0001f);
                h.lineTo(26.0f, 62.0001f);
                h.lineTo(26.0f, 63.0001f);
                h.lineTo(55.0f, 63.0001f);
                h.lineTo(55.0f, 62.0001f);
                h.lineTo(51.0f, 60.0001f);
                h.lineTo(49.0f, 55.0001f);
                h.lineTo(75.685f, 55.0001f);
                h.cubicTo(78.062f, 55.0001f, 80.0f, 53.0681f, 80.0f, 50.6841f);
                h.lineTo(80.0f, 4.3161f);
                h.cubicTo(80.0f, 1.9251f, 78.068f, 1.0E-4f, 75.685f, 1.0E-4f);
                h.lineTo(75.685f, 1.0E-4f);
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
