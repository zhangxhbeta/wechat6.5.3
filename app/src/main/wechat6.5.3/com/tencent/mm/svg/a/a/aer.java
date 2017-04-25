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

public final class aer extends c {
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
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-12863723);
                c = c.a(c, 1.0f, 0.0f, 22.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(12.334797f, 4.3112025f);
                h.cubicTo(21.186792f, -1.572559f, 33.55958f, -1.422463f, 42.261543f, 4.6914454f);
                h.cubicTo(48.87303f, 9.174312f, 53.184006f, 17.00932f, 52.99396f, 25.054462f);
                h.cubicTo(52.903942f, 31.708717f, 50.01329f, 37.97272f, 46.38247f, 43.416203f);
                h.cubicTo(40.95125f, 51.47135f, 33.95967f, 58.28571f, 27.008104f, 65.0f);
                h.cubicTo(20.046535f, 58.315727f, 13.094969f, 51.481358f, 7.6637444f, 43.456226f);
                h.cubicTo(3.8228788f, 37.70255f, 0.7821936f, 31.028282f, 1.0122454f, 23.973772f);
                h.cubicTo(1.2122905f, 16.068718f, 5.713305f, 8.543908f, 12.334797f, 4.3112025f);
                h.lineTo(12.334797f, 4.3112025f);
                h.close();
                h.moveTo(23.398994f, 14.60051f);
                h.cubicTo(19.540892f, 15.836599f, 16.380636f, 19.116222f, 15.413617f, 23.063734f);
                h.cubicTo(13.429734f, 29.89213f, 18.853012f, 37.448223f, 25.90128f, 37.91674f);
                h.cubicTo(33.079147f, 38.83384f, 39.858246f, 32.02538f, 38.911163f, 24.848087f);
                h.cubicTo(38.442608f, 17.531237f, 30.3376f, 12.148268f, 23.398994f, 14.60051f);
                h.lineTo(23.398994f, 14.60051f);
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
