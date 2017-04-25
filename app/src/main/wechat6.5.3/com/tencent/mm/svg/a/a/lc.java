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

public final class lc extends c {
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
                Paint a = c.a(g2, looper);
                a.setStrokeWidth(1.0f);
                canvas.save();
                c = c.a(c, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, 1.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                a2.setColor(-12171633);
                a2.setStrokeWidth(2.0f);
                Path h = c.h(looper);
                h.moveTo(47.0f, 0.0f);
                h.cubicTo(72.95738f, 0.0f, 94.0f, 21.042616f, 94.0f, 47.0f);
                h.cubicTo(94.0f, 72.95738f, 72.95738f, 94.0f, 47.0f, 94.0f);
                h.cubicTo(21.042616f, 94.0f, 0.0f, 72.95738f, 0.0f, 47.0f);
                h.cubicTo(0.0f, 21.042616f, 21.042616f, 0.0f, 47.0f, 0.0f);
                h.close();
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(g, looper);
                a2.setColor(-12171633);
                h = c.h(looper);
                h.moveTo(35.712845f, 1.4918383f);
                h.cubicTo(39.59065f, 0.51665163f, 43.672325f, 0.0f, 47.89976f, 0.0f);
                h.cubicTo(72.8354f, 0.0f, 93.87802f, 21.042616f, 93.87802f, 48.02174f);
                h.cubicTo(93.87802f, 72.95738f, 72.8354f, 94.0f, 47.89976f, 94.0f);
                h.cubicTo(43.53743f, 94.0f, 39.33031f, 93.44985f, 35.342255f, 92.42205f);
                h.cubicTo(35.231018f, 92.2769f, 35.11696f, 92.136086f, 35.0f, 92.0f);
                h.cubicTo(31.734863f, 88.07245f, 27.908354f, 84.393814f, 27.0f, 81.0f);
                h.cubicTo(26.385204f, 77.56834f, 28.204039f, 76.99266f, 30.0f, 76.0f);
                h.cubicTo(32.047943f, 74.46021f, 38.535614f, 78.69645f, 42.0f, 78.0f);
                h.cubicTo(45.579872f, 78.51316f, 48.111828f, 72.87775f, 49.0f, 68.0f);
                h.cubicTo(47.883232f, 66.16327f, 48.715622f, 63.586937f, 50.0f, 63.0f);
                h.cubicTo(50.33816f, 61.738583f, 49.96048f, 63.984592f, 49.0f, 64.0f);
                h.cubicTo(45.03323f, 62.748055f, 44.22515f, 59.399746f, 44.0f, 59.0f);
                h.cubicTo(44.22515f, 59.399746f, 47.42107f, 55.604942f, 49.0f, 56.0f);
                h.cubicTo(50.005207f, 55.297745f, 50.936985f, 55.47587f, 52.0f, 55.0f);
                h.cubicTo(51.374302f, 53.712704f, 50.464886f, 51.730114f, 51.0f, 52.0f);
                h.cubicTo(50.218895f, 50.947918f, 54.54981f, 50.219936f, 56.0f, 49.0f);
                h.cubicTo(57.53399f, 49.027283f, 57.08425f, 46.303802f, 56.0f, 45.0f);
                h.cubicTo(55.002033f, 42.65098f, 52.281235f, 38.092056f, 52.0f, 35.0f);
                h.cubicTo(50.030056f, 31.994555f, 47.89814f, 21.32264f, 48.0f, 21.0f);
                h.cubicTo(47.89814f, 21.32264f, 49.731884f, 19.18774f, 50.0f, 17.0f);
                h.cubicTo(49.42515f, 15.206513f, 49.310837f, 8.117379f, 35.712845f, 1.4918383f);
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
