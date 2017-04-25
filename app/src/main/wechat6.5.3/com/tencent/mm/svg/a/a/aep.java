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

public final class aep extends c {
    private final int height = 60;
    private final int width = MMGIFException.D_GIF_ERR_DATA_TOO_BIG;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_DATA_TOO_BIG;
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
                a.setColor(-8534461);
                c = c.a(c, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 16.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(11.019414f, 3.995966f);
                h.cubicTo(27.591017f, -1.7228311f, 46.26551f, -1.3263807f, 62.484955f, 5.333986f);
                h.cubicTo(65.40285f, 6.5431595f, 68.52197f, 8.347009f, 69.34703f, 11.587991f);
                h.cubicTo(70.634926f, 16.315662f, 69.80987f, 21.370405f, 68.662834f, 26.04852f);
                h.cubicTo(68.330795f, 26.286388f, 67.65666f, 26.76213f, 67.31457f, 27.0f);
                h.cubicTo(61.639774f, 26.276478f, 55.94486f, 25.384464f, 50.35056f, 24.205025f);
                h.cubicTo(48.680317f, 23.640083f, 49.12303f, 21.717299f, 49.42488f, 20.448658f);
                h.cubicTo(50.109077f, 17.55457f, 51.13537f, 14.749682f, 52.181786f, 11.964619f);
                h.cubicTo(46.335945f, 8.852483f, 39.53424f, 8.35692f, 33.02433f, 8.5155f);
                h.cubicTo(27.79225f, 8.674081f, 22.449493f, 9.45707f, 17.821115f, 11.994352f);
                h.cubicTo(19.068766f, 15.35427f, 20.447216f, 18.734009f, 20.87987f, 22.311974f);
                h.cubicTo(21.141474f, 24.175291f, 18.837347f, 24.47263f, 17.499142f, 24.72041f);
                h.cubicTo(12.538729f, 25.42411f, 7.6286244f, 26.514349f, 2.6380265f, 27.0f);
                h.cubicTo(0.70618194f, 26.246744f, 0.93760085f, 23.986977f, 0.53513324f, 22.35162f);
                h.cubicTo(-0.038383055f, 17.901463f, -0.7728864f, 12.816987f, 2.034325f, 8.931773f);
                h.cubicTo(4.338452f, 6.3052893f, 7.8298583f, 5.195228f, 11.019414f, 3.995966f);
                h.lineTo(11.019414f, 3.995966f);
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
