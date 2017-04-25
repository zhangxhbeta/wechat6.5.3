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

public final class am extends c {
    private final int height = 45;
    private final int width = 45;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 45;
            case 1:
                return 45;
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
                a.setColor(-11184811);
                c = c.a(c, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 4.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(14.634262f, 3.4369836f);
                h.cubicTo(15.279194f, 1.8675201f, 16.155897f, -0.3917077f, 18.31239f, 0.058138534f);
                h.cubicTo(20.186722f, 0.08812828f, 20.589804f, 2.1574209f, 21.315353f, 3.4469802f);
                h.cubicTo(24.09662f, 4.796519f, 26.817427f, 6.6258936f, 28.07706f, 9.564889f);
                h.cubicTo(31.13041f, 15.372904f, 29.185537f, 22.17058f, 31.251333f, 28.218513f);
                h.cubicTo(32.138115f, 30.637686f, 33.831062f, 32.656998f, 35.0f, 34.93622f);
                h.cubicTo(23.673386f, 35.026188f, 12.336693f, 35.01619f, 1.0f, 34.93622f);
                h.cubicTo(2.1487849f, 32.647f, 3.861885f, 30.657679f, 4.7486663f, 28.22851f);
                h.cubicTo(6.8144636f, 22.190573f, 4.8595138f, 15.372904f, 7.9229403f, 9.564889f);
                h.cubicTo(9.182572f, 6.6558833f, 11.873148f, 4.8065157f, 14.634262f, 3.4369836f);
                h.lineTo(14.634262f, 3.4369836f);
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
