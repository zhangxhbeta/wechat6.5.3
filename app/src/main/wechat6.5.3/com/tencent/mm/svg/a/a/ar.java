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

public final class ar extends c {
    private final int height = 90;
    private final int width = 90;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 90;
            case 1:
                return 90;
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
                g2 = c.a(g, looper);
                g2.setColor(-16743362);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.18904878f, 4.0f);
                h.cubicTo(0.18904878f, 1.7908609f, 1.9799097f, 0.0f, 4.189049f, 0.0f);
                h.lineTo(86.18905f, 0.0f);
                h.cubicTo(88.398186f, 0.0f, 90.18905f, 1.7908609f, 90.18905f, 4.0f);
                h.lineTo(90.18905f, 86.0f);
                h.cubicTo(90.18905f, 88.20914f, 88.398186f, 90.0f, 86.18905f, 90.0f);
                h.lineTo(4.189049f, 90.0f);
                h.cubicTo(1.9799097f, 90.0f, 0.18904878f, 88.20914f, 0.18904878f, 86.0f);
                h.lineTo(0.18904878f, 4.0f);
                h.close();
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                h = c.h(looper);
                h.moveTo(25.0f, 67.0f);
                h.lineTo(42.296875f, 44.069576f);
                h.lineTo(27.0439f, 23.0f);
                h.lineTo(34.090775f, 23.0f);
                h.lineTo(42.205357f, 34.28513f);
                h.cubicTo(43.89336f, 36.626205f, 45.09325f, 38.427006f, 45.80506f, 39.687584f);
                h.cubicTo(46.801594f, 38.08685f, 47.981144f, 36.416107f, 49.34375f, 34.67531f);
                h.lineTo(58.343006f, 23.0f);
                h.lineTo(64.77976f, 23.0f);
                h.lineTo(49.069195f, 43.739426f);
                h.lineTo(66.0f, 67.0f);
                h.lineTo(58.67857f, 67.0f);
                h.lineTo(47.421875f, 51.302864f);
                h.cubicTo(46.791416f, 50.40245f, 46.14063f, 49.422016f, 45.469494f, 48.361526f);
                h.cubicTo(44.47296f, 49.962265f, 43.76116f, 51.06275f, 43.334076f, 51.66303f);
                h.lineTo(32.107887f, 67.0f);
                h.lineTo(25.0f, 67.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
