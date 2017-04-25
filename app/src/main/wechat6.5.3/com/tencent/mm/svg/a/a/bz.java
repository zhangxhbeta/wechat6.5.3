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

public final class bz extends c {
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
                c = c.a(c, 1.0f, 0.0f, -251.0f, 0.0f, 1.0f, -198.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                float[] a = c.a(c, 1.0f, 0.0f, 251.0f, 0.0f, 1.0f, 198.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(g, looper);
                a2.setColor(-1686720);
                Path h = c.h(looper);
                h.moveTo(30.0f, 60.0f);
                h.cubicTo(46.568542f, 60.0f, 60.0f, 46.568542f, 60.0f, 30.0f);
                h.cubicTo(60.0f, 13.4314575f, 46.568542f, 0.0f, 30.0f, 0.0f);
                h.cubicTo(13.4314575f, 0.0f, 0.0f, 13.4314575f, 0.0f, 30.0f);
                h.cubicTo(0.0f, 46.568542f, 13.4314575f, 60.0f, 30.0f, 60.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a, 0.70710677f, -0.70710677f, 30.0f, 0.70710677f, 0.70710677f, -12.426407f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                h = c.h(looper);
                h.moveTo(31.5f, 28.5f);
                h.lineTo(31.5f, 16.508265f);
                h.cubicTo(31.5f, 15.668654f, 30.828426f, 15.0f, 30.0f, 15.0f);
                h.cubicTo(29.165796f, 15.0f, 28.5f, 15.675273f, 28.5f, 16.508265f);
                h.lineTo(28.5f, 28.5f);
                h.lineTo(16.508265f, 28.5f);
                h.cubicTo(15.668654f, 28.5f, 15.0f, 29.171574f, 15.0f, 30.0f);
                h.cubicTo(15.0f, 30.834204f, 15.675273f, 31.5f, 16.508265f, 31.5f);
                h.lineTo(28.5f, 31.5f);
                h.lineTo(28.5f, 43.491737f);
                h.cubicTo(28.5f, 44.331345f, 29.171574f, 45.0f, 30.0f, 45.0f);
                h.cubicTo(30.834204f, 45.0f, 31.5f, 44.324726f, 31.5f, 43.491737f);
                h.lineTo(31.5f, 31.5f);
                h.lineTo(43.491737f, 31.5f);
                h.cubicTo(44.331345f, 31.5f, 45.0f, 30.828426f, 45.0f, 30.0f);
                h.cubicTo(45.0f, 29.165796f, 44.324726f, 28.5f, 43.491737f, 28.5f);
                h.lineTo(31.5f, 28.5f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
