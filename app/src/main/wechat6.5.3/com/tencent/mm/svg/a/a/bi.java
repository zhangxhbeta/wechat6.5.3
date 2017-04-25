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

public final class bi extends c {
    private final int height = 80;
    private final int width = 80;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 80;
            case 1:
                return 80;
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
                a.setColor(-1);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 5.0f, 0.0f, 1.0f, 19.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.6294041f);
                h.lineTo(44.081802f, 0.6294054f);
                h.lineTo(44.081802f, 41.746845f);
                h.lineTo(0.0f, 41.74684f);
                h.lineTo(0.0f, 0.6294041f);
                h.close();
                h.moveTo(5.0f, 5.629404f);
                h.lineTo(39.0f, 5.6294045f);
                h.lineTo(39.0f, 36.629406f);
                h.lineTo(5.0f, 36.629402f);
                h.lineTo(5.0f, 5.629404f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 47.88276f, 0.0f, 1.0f, 1.922839f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h2 = c.h(looper);
                h2.moveTo(17.238659f, 3.8456779f);
                h2.lineTo(21.276552f, 3.8456774f);
                h2.lineTo(21.276552f, 34.611103f);
                h2.lineTo(17.238659f, 34.611107f);
                h2.lineTo(17.238659f, 3.8456779f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(0.2687733f, 13.459874f);
                h2.lineTo(4.221509f, 13.459874f);
                h2.lineTo(4.221509f, 24.99691f);
                h2.lineTo(0.2687733f, 24.99691f);
                h2.lineTo(0.2687733f, 13.459874f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(0.0f, 13.459874f);
                h2.lineTo(21.388449f, 0.0f);
                h2.lineTo(21.388449f, 5.171436f);
                h2.lineTo(0.0f, 18.63131f);
                h2.lineTo(0.0f, 13.459874f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h2 = c.h(looper);
                h2.moveTo(21.388449f, 33.285347f);
                h2.lineTo(0.0f, 19.825474f);
                h2.lineTo(0.0f, 24.99691f);
                h2.lineTo(21.388449f, 38.456783f);
                h2.lineTo(21.388449f, 33.285347f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
