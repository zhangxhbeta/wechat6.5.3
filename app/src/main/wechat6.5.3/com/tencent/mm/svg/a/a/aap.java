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

public final class aap extends c {
    private final int height = 44;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 44;
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
                canvas.saveLayerAlpha(null, 217, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-2928046);
                float[] a2 = c.a(c, 1.0f, 0.0f, 12.0f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(10.666615f, 0.0f);
                h.lineTo(12.372898f, 0.0f);
                h.cubicTo(20.305622f, 0.02008788f, 25.773712f, 9.732577f, 21.51299f, 16.52228f);
                h.cubicTo(17.801077f, 23.834269f, 6.1564374f, 23.824224f, 2.4644783f, 16.502193f);
                h.cubicTo(-1.5567636f, 9.973632f, 3.2028701f, 0.87382275f, 10.666615f, 0.0f);
                h.lineTo(10.666615f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-12537567);
                a2 = c.a(a2, 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                a = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(6.1586027f, 2.1373188f);
                h.cubicTo(12.047705f, -1.0015799f, 20.032927f, 2.6871262f, 21.580063f, 9.154857f);
                h.cubicTo(23.476555f, 15.432654f, 18.695402f, 22.130304f, 12.34715f, 23.0f);
                h.lineTo(9.9216385f, 23.0f);
                h.cubicTo(4.6414104f, 22.400211f, 0.359335f, 17.991756f, 0.0f, 12.673622f);
                h.lineTo(0.0f, 10.884251f);
                h.cubicTo(0.61885476f, 7.2355304f, 2.7149756f, 3.7367578f, 6.1586027f, 2.1373188f);
                h.lineTo(6.1586027f, 2.1373188f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-2511616);
                c = c.a(a2, 1.0f, 0.0f, 25.0f, 0.0f, 1.0f, 21.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(1.0697373f, 12.9446945f);
                h.cubicTo(0.27009234f, 6.4077463f, 6.4773364f, 0.22063516f, 13.014434f, 1.0802338f);
                h.cubicTo(18.142157f, 1.4000845f, 22.220346f, 5.75805f, 23.0f, 10.70574f);
                h.lineTo(23.0f, 13.044648f);
                h.cubicTo(22.440248f, 18.152264f, 18.332073f, 22.260345f, 13.284314f, 23.0f);
                h.lineTo(11.015322f, 23.0f);
                h.cubicTo(5.8776026f, 22.440262f, 1.3795997f, 18.192245f, 1.0697373f, 12.9446945f);
                h.lineTo(1.0697373f, 12.9446945f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
