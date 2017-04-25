package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.plugin.gif.MMGIFException;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class ti extends c {
    private final int height = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
            case 1:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
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
                c = c.a(c, 1.0f, 0.0f, 24.0f, 0.0f, 1.0f, 20.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-499359);
                Path h = c.h(looper);
                h.moveTo(31.785f, 36.737f);
                h.lineTo(31.785f, 67.704f);
                h.lineTo(59.785f, 52.121f);
                h.lineTo(59.785f, 19.704f);
                h.lineTo(31.785f, 36.737f);
                h.lineTo(31.785f, 36.737f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-16384);
                h = c.h(looper);
                h.moveTo(-0.215f, 51.722668f);
                h.lineTo(28.785f, 67.704f);
                h.lineTo(28.785f, 36.736355f);
                h.lineTo(-0.215f, 19.704f);
                h.lineTo(-0.215f, 51.722668f);
                h.lineTo(-0.215f, 51.722668f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-12799249);
                Path h2 = c.h(looper);
                h2.moveTo(30.079521f, -0.296f);
                h2.lineTo(1.785f, 15.418f);
                h2.cubicTo(1.785f, 15.418f, 28.857569f, 31.506f, 30.285f, 32.704f);
                h2.cubicTo(31.01162f, 32.435f, 58.785f, 15.418f, 58.785f, 15.418f);
                h2.lineTo(30.079521f, -0.296f);
                h2.lineTo(30.079521f, -0.296f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
