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

public final class ct extends c {
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
                c = c.a(c, 1.0f, 0.0f, 37.0f, 0.0f, 1.0f, 57.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(64.0f, 39.599926f);
                h.lineTo(64.0f, 49.099926f);
                h.cubicTo(64.0f, 51.073624f, 62.65501f, 52.407425f, 61.0f, 52.099926f);
                h.lineTo(3.0f, 52.099926f);
                h.cubicTo(1.3414615f, 52.407425f, 0.0f, 51.07877f, 0.0f, 49.099926f);
                h.lineTo(0.0f, 5.0999255f);
                h.cubicTo(0.0f, 3.094035f, 1.3449905f, 1.760234f, 3.0f, 2.0999255f);
                h.lineTo(61.0f, 2.0999255f);
                h.cubicTo(62.65854f, 1.760234f, 64.0f, 3.0888903f, 64.0f, 5.0999255f);
                h.lineTo(64.0f, 14.099925f);
                h.lineTo(64.0f, 39.599926f);
                h.close();
                h.moveTo(70.0f, 35.62607f);
                h.cubicTo(77.765816f, 42.808117f, 88.73977f, 53.013004f, 90.0f, 54.099926f);
                h.cubicTo(91.91545f, 54.66846f, 94.0f, 53.152363f, 94.0f, 51.099926f);
                h.lineTo(94.0f, 3.0999255f);
                h.cubicTo(94.0f, 0.7384861f, 91.694824f, -0.35120907f, 90.0f, 0.09992552f);
                h.cubicTo(88.3209f, 1.3646963f, 77.58243f, 11.272879f, 70.0f, 17.971575f);
                h.lineTo(70.0f, 35.62607f);
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
