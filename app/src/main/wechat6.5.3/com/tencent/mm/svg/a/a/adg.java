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

public final class adg extends c {
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
                c = c.a(c, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 24.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Paint a = c.a(g, looper);
                a.setColor(-9473160);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(51.0f, 45.0f);
                h.lineTo(51.0f, 20.995752f);
                h.cubicTo(51.0f, 20.45077f, 50.55641f, 20.0f, 50.00922f, 20.0f);
                h.lineTo(45.99078f, 20.0f);
                h.cubicTo(45.450974f, 20.0f, 45.0f, 20.445814f, 45.0f, 20.995752f);
                h.lineTo(45.0f, 45.0f);
                h.lineTo(20.995752f, 45.0f);
                h.cubicTo(20.45077f, 45.0f, 20.0f, 45.44359f, 20.0f, 45.99078f);
                h.lineTo(20.0f, 50.00922f);
                h.cubicTo(20.0f, 50.549026f, 20.445814f, 51.0f, 20.995752f, 51.0f);
                h.lineTo(45.0f, 51.0f);
                h.lineTo(45.0f, 75.00425f);
                h.cubicTo(45.0f, 75.54923f, 45.44359f, 76.0f, 45.99078f, 76.0f);
                h.lineTo(50.00922f, 76.0f);
                h.cubicTo(50.549026f, 76.0f, 51.0f, 75.554184f, 51.0f, 75.00425f);
                h.lineTo(51.0f, 51.0f);
                h.lineTo(75.00425f, 51.0f);
                h.cubicTo(75.54923f, 51.0f, 76.0f, 50.55641f, 76.0f, 50.00922f);
                h.lineTo(76.0f, 45.99078f);
                h.cubicTo(76.0f, 45.450974f, 75.554184f, 45.0f, 75.00425f, 45.0f);
                h.lineTo(51.0f, 45.0f);
                h.close();
                h.moveTo(48.551723f, 2.2325583f);
                h.cubicTo(22.886942f, 2.2325583f, 2.2325583f, 22.56116f, 2.2325583f, 47.448277f);
                h.cubicTo(2.2325583f, 73.27646f, 22.723429f, 93.76744f, 48.551723f, 93.76744f);
                h.cubicTo(73.43785f, 93.76744f, 93.76744f, 73.112335f, 93.76744f, 47.448277f);
                h.cubicTo(93.76744f, 22.722431f, 73.277176f, 2.2325583f, 48.551723f, 2.2325583f);
                h.lineTo(48.551723f, 0.0f);
                h.cubicTo(74.50971f, 5.9487298E-15f, 96.0f, 21.488955f, 96.0f, 47.448277f);
                h.cubicTo(96.0f, 74.50933f, 74.50971f, 96.0f, 48.551723f, 96.0f);
                h.cubicTo(21.490286f, 96.0f, 0.0f, 74.50933f, 0.0f, 47.448277f);
                h.cubicTo(0.0f, 21.488955f, 21.490286f, 5.9487298E-15f, 48.551723f, 5.9487298E-15f);
                h.lineTo(48.551723f, 2.2325583f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(419430400);
                h = c.h(looper);
                h.moveTo(48.0f, 0.0f);
                h.cubicTo(74.509674f, 0.0f, 96.0f, 21.49033f, 96.0f, 48.0f);
                h.cubicTo(96.0f, 74.509674f, 74.509674f, 96.0f, 48.0f, 96.0f);
                h.cubicTo(21.49033f, 96.0f, 0.0f, 74.509674f, 0.0f, 48.0f);
                h.cubicTo(0.0f, 21.49033f, 21.49033f, 0.0f, 48.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
