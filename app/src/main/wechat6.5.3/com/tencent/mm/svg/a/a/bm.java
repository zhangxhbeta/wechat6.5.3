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

public final class bm extends c {
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
                c = c.a(c, 1.0f, 0.0f, 6.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                g = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(5.773585f, 0.0f);
                h.lineTo(21.169811f, 47.908745f);
                h.lineTo(15.396226f, 47.908745f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.save();
                g = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(30.792452f, 0.0f);
                h.lineTo(36.566036f, 0.0f);
                h.lineTo(51.962265f, 47.908745f);
                h.lineTo(46.18868f, 47.908745f);
                h.lineTo(30.792452f, 0.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.save();
                Paint a2 = c.a(a, looper);
                c = c.a(c, -1.0f, 0.0f, 51.962265f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h2 = c.h(looper);
                h2.moveTo(15.396226f, 0.0f);
                h2.lineTo(21.169811f, 0.0f);
                h2.lineTo(36.566036f, 47.908745f);
                h2.lineTo(30.792452f, 47.908745f);
                h2.lineTo(15.396226f, 0.0f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a2);
                canvas.restore();
                canvas.save();
                a = c.a(a, looper);
                c = c.a(c, -1.0f, 0.0f, 113.54717f, 0.0f, 1.0f, 0.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                Path h3 = c.h(looper);
                h3.moveTo(46.18868f, 0.0f);
                h3.lineTo(51.962265f, 0.0f);
                h3.lineTo(67.35849f, 47.908745f);
                h3.lineTo(61.584908f, 47.908745f);
                h3.lineTo(46.18868f, 0.0f);
                h3.close();
                WeChatSVGRenderC2Java.setFillType(h3, 2);
                canvas.drawPath(h3, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
