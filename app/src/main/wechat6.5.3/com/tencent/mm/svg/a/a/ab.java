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

public final class ab extends c {
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
                a.setColor(-1);
                c = c.a(c, 1.0f, 0.0f, 18.0f, 0.0f, 1.0f, 18.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(1.8112956f, 10.179302f);
                h.cubicTo(4.1568093f, 5.8457093f, 8.318849f, 2.8101974f, 12.401041f, 0.24399146f);
                h.cubicTo(14.297414f, -0.7745027f, 15.375352f, 1.65191f, 16.3435f, 2.8101974f);
                h.cubicTo(18.96848f, 6.844233f, 22.212275f, 10.468874f, 24.487923f, 14.702615f);
                h.cubicTo(24.34819f, 15.102024f, 24.068724f, 15.920814f, 23.91901f, 16.330208f);
                h.cubicTo(21.05449f, 18.586872f, 17.680943f, 20.064688f, 14.36728f, 21.522532f);
                h.cubicTo(15.724684f, 27.084309f, 19.487488f, 31.617607f, 23.36008f, 35.66163f);
                h.cubicTo(27.63191f, 39.965263f, 32.48263f, 44.08917f, 38.451214f, 45.706776f);
                h.cubicTo(40.13799f, 42.261868f, 41.445488f, 38.407566f, 44.240143f, 35.69158f);
                h.cubicTo(47.543823f, 35.581745f, 49.819473f, 38.9268f, 52.584183f, 40.4146f);
                h.cubicTo(54.96962f, 42.581398f, 58.80229f, 43.74967f, 60.0f, 46.795166f);
                h.cubicTo(58.423016f, 50.669437f, 55.338917f, 53.914642f, 52.23485f, 56.700523f);
                h.cubicTo(49.48012f, 59.23677f, 45.42787f, 59.61621f, 42.064304f, 58.12841f);
                h.cubicTo(24.398094f, 51.348434f, 9.915794f, 36.989666f, 2.5099592f, 19.61535f);
                h.cubicTo(1.3122501f, 16.669706f, 0.18440735f, 13.194844f, 1.8112956f, 10.179302f);
                h.lineTo(1.8112956f, 10.179302f);
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
