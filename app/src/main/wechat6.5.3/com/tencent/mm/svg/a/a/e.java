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

public final class e extends c {
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
                h.moveTo(45.0f, 45.0f);
                h.lineTo(45.0f, 20.995752f);
                h.cubicTo(45.0f, 20.45077f, 45.44359f, 20.0f, 45.99078f, 20.0f);
                h.lineTo(50.00922f, 20.0f);
                h.cubicTo(50.549026f, 20.0f, 51.0f, 20.445814f, 51.0f, 20.995752f);
                h.lineTo(51.0f, 45.0f);
                h.lineTo(75.00425f, 45.0f);
                h.cubicTo(75.54923f, 45.0f, 76.0f, 45.44359f, 76.0f, 45.99078f);
                h.lineTo(76.0f, 50.00922f);
                h.cubicTo(76.0f, 50.549026f, 75.554184f, 51.0f, 75.00425f, 51.0f);
                h.lineTo(51.0f, 51.0f);
                h.lineTo(51.0f, 75.00425f);
                h.cubicTo(51.0f, 75.54923f, 50.55641f, 76.0f, 50.00922f, 76.0f);
                h.lineTo(45.99078f, 76.0f);
                h.cubicTo(45.450974f, 76.0f, 45.0f, 75.554184f, 45.0f, 75.00425f);
                h.lineTo(45.0f, 51.0f);
                h.lineTo(20.995752f, 51.0f);
                h.cubicTo(20.45077f, 51.0f, 20.0f, 50.55641f, 20.0f, 50.00922f);
                h.lineTo(20.0f, 45.99078f);
                h.cubicTo(20.0f, 45.450974f, 20.445814f, 45.0f, 20.995752f, 45.0f);
                h.lineTo(45.0f, 45.0f);
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
