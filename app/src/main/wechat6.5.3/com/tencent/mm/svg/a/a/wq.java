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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class wq extends c {
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
                a.setColor(-8355712);
                c = c.a(c, 1.0f, 0.0f, 15.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(45.0f, -3.5527137E-15f);
                h.cubicTo(52.34879f, 6.1744103f, 59.68439f, 12.328806f, 67.0f, 19.0f);
                h.cubicTo(59.704376f, 24.717655f, 52.3388f, 30.832024f, 45.0f, 37.0f);
                h.cubicTo(45.003197f, 33.33381f, 45.023186f, 29.661186f, 45.0f, 26.0f);
                h.cubicTo(38.3272f, 26.168692f, 31.08155f, 26.34882f, 25.0f, 30.0f);
                h.cubicTo(21.237457f, 33.02359f, 19.078753f, 37.666904f, 17.0f, 42.0f);
                h.cubicTo(17.209873f, 31.952824f, 20.138117f, 20.87491f, 29.0f, 15.0f);
                h.cubicTo(33.270237f, 11.037884f, 39.36658f, 10.717655f, 45.0f, 11.0f);
                h.cubicTo(45.023186f, 7.345247f, 45.003197f, 3.6726234f, 45.0f, -3.5527137E-15f);
                h.lineTo(45.0f, -3.5527137E-15f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(-3.5527137E-15f, 15.0f);
                h.cubicTo(-0.25992802f, 13.123616f, 0.9487858f, 10.94681f, 3.0f, 11.0f);
                h.cubicTo(8.960261f, 10.916854f, 14.983851f, 11.076619f, 21.0f, 11.0f);
                h.cubicTo(19.209354f, 13.133601f, 17.690971f, 15.480158f, 16.0f, 18.0f);
                h.cubicTo(13.345594f, 18.00645f, 10.198943f, 18.00645f, 7.0f, 18.0f);
                h.cubicTo(7.0423017f, 29.31985f, 7.0423017f, 40.63325f, 7.0f, 52.0f);
                h.cubicTo(22.356007f, 51.956635f, 37.669712f, 51.956635f, 53.0f, 52.0f);
                h.cubicTo(53.003395f, 48.002438f, 52.983418f, 44.058224f, 53.0f, 40.0f);
                h.cubicTo(55.32093f, 38.126926f, 57.658443f, 36.1698f, 60.0f, 34.0f);
                h.cubicTo(59.92603f, 41.49199f, 60.085857f, 48.79128f, 60.0f, 56.0f);
                h.cubicTo(59.985966f, 58.057682f, 57.85823f, 59.275894f, 56.0f, 59.0f);
                h.cubicTo(38.348988f, 58.916424f, 20.617857f, 59.016273f, 3.0f, 59.0f);
                h.cubicTo(0.89883894f, 58.996304f, -0.25992802f, 56.779556f, -3.5527137E-15f, 55.0f);
                h.cubicTo(0.049742464f, 41.64177f, 0.039753094f, 28.271389f, -3.5527137E-15f, 15.0f);
                h.lineTo(-3.5527137E-15f, 15.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
