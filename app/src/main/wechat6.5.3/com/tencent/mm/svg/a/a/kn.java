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

public final class kn extends c {
    private final int height = 60;
    private final int width = 60;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 60;
            case 1:
                return 60;
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
                Paint a = c.a(g, looper);
                a.setColor(-16139513);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(27.52f, 0.0f);
                h.lineTo(32.07f, 0.0f);
                h.cubicTo(46.45f, 0.9f, 58.83f, 13.19f, 60.0f, 27.52f);
                h.lineTo(60.0f, 32.08f);
                h.cubicTo(59.09f, 46.46f, 46.8f, 58.83f, 32.48f, 60.0f);
                h.lineTo(27.93f, 60.0f);
                h.cubicTo(13.55f, 59.1f, 1.17f, 46.81f, 0.0f, 32.48f);
                h.lineTo(0.0f, 27.93f);
                h.cubicTo(0.9f, 13.55f, 13.2f, 1.17f, 27.52f, 0.0f);
                h.lineTo(27.52f, 0.0f);
                h.close();
                h.moveTo(24.383501f, 3.6703784f);
                h.cubicTo(11.597891f, 6.255954f, 1.8089068f, 19.054052f, 3.117434f, 32.111706f);
                h.cubicTo(3.9265237f, 46.387276f, 17.730988f, 58.336826f, 32.024902f, 56.879322f);
                h.cubicTo(46.738342f, 56.09067f, 58.884674f, 41.515614f, 56.75707f, 26.890642f);
                h.cubicTo(55.318687f, 11.726592f, 39.286728f, 0.026614152f, 24.383501f, 3.6703784f);
                h.lineTo(24.383501f, 3.6703784f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g2 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(25.0f, 15.0f);
                h2.lineTo(36.0f, 15.0f);
                h2.lineTo(36.0f, 31.0f);
                h2.lineTo(25.0f, 31.0f);
                h2.lineTo(25.0f, 15.0f);
                h2.close();
                canvas.drawPath(h2, g2);
                canvas.restore();
                canvas.save();
                g2 = c.a(g, looper);
                g2.setColor(-16139513);
                h2 = c.h(looper);
                h2.moveTo(14.176433f, 30.047743f);
                h2.lineTo(30.5319f, 46.112846f);
                h2.lineTo(46.914062f, 30.035374f);
                h2.lineTo(14.176433f, 30.047743f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, g2);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
