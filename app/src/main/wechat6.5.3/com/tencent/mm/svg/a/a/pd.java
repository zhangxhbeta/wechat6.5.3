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

public final class pd extends c {
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
                a.setColor(-1150121);
                Path h = c.h(looper);
                h.moveTo(23.357143f, 31.267857f);
                h.cubicTo(25.82522f, 35.67271f, 21.368435f, 37.603485f, 19.517857f, 38.94643f);
                h.cubicTo(11.49915f, 43.23181f, 8.0f, 44.938072f, 8.0f, 46.625f);
                h.lineTo(8.0f, 50.464287f);
                h.cubicTo(8.0f, 51.156628f, 8.728162f, 52.0f, 9.535714f, 52.0f);
                h.lineTo(49.464287f, 52.0f);
                h.cubicTo(50.27184f, 52.0f, 51.0f, 51.156628f, 51.0f, 50.464287f);
                h.lineTo(51.0f, 46.625f);
                h.cubicTo(51.0f, 44.938072f, 47.50085f, 43.23181f, 39.482143f, 38.94643f);
                h.cubicTo(37.631565f, 37.603485f, 33.17478f, 35.67271f, 35.642857f, 31.267857f);
                h.cubicTo(38.24307f, 27.868282f, 40.103214f, 26.426222f, 40.25f, 20.517857f);
                h.cubicTo(40.103214f, 14.887795f, 35.947693f, 9.0f, 29.5f, 9.0f);
                h.cubicTo(23.052307f, 9.0f, 18.896786f, 14.887795f, 18.75f, 20.517857f);
                h.cubicTo(18.896786f, 26.426222f, 20.756931f, 27.868282f, 23.357143f, 31.267857f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1150121);
                h = c.h(looper);
                h.moveTo(43.0f, 35.0f);
                h.lineTo(43.0f, 24.87092f);
                h.lineTo(43.0f, 20.50185f);
                h.cubicTo(43.0f, 13.046129f, 36.955845f, 7.0f, 29.5f, 7.0f);
                h.cubicTo(24.75873f, 7.0f, 29.5f, 7.0f, 29.5f, 7.0f);
                h.cubicTo(22.040064f, 7.0f, 16.0f, 13.045625f, 16.0f, 20.50328f);
                h.cubicTo(16.0f, 20.50328f, 16.0f, 26.211f, 16.0f, 24.426191f);
                h.lineTo(16.0f, 35.0f);
                h.lineTo(43.0f, 35.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1);
                h = c.h(looper);
                h.moveTo(22.200684f, 38.115723f);
                h.cubicTo(22.200684f, 38.115723f, 21.690918f, 42.961914f, 23.961914f, 45.899902f);
                h.cubicTo(26.230072f, 48.83422f, 29.463587f, 44.642944f, 29.58355f, 43.118626f);
                h.cubicTo(26.589844f, 42.558025f, 22.200684f, 38.115723f, 22.200684f, 38.115723f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                float[] a2 = c.a(c, -1.0f, 0.0f, 66.79199f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                h = c.h(looper);
                h.moveTo(29.706408f, 38.115723f);
                h.cubicTo(29.706408f, 38.115723f, 29.196642f, 42.961914f, 31.467638f, 45.899902f);
                h.cubicTo(33.738636f, 48.83789f, 37.022217f, 44.632446f, 37.13452f, 43.112915f);
                h.cubicTo(34.14038f, 42.558025f, 29.706408f, 38.115723f, 29.706408f, 38.115723f);
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
