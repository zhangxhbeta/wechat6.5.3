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

public final class ael extends c {
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
                a.setColor(-3355444);
                c = c.a(c, 1.0f, 0.0f, 19.0f, 0.0f, 1.0f, 9.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2.358476f, 1.539103f);
                h.cubicTo(3.7269406f, 0.68053156f, 5.494957f, 1.1697177f, 7.0332313f, 1.0f);
                h.cubicTo(20.038641f, 1.0898505f, 33.044052f, 0.9201329f, 46.04946f, 1.0798671f);
                h.cubicTo(48.05721f, 0.9301163f, 49.225895f, 3.126462f, 48.9562f, 4.9035053f);
                h.cubicTo(48.976177f, 15.615682f, 48.976177f, 26.327858f, 48.9562f, 37.040035f);
                h.cubicTo(49.245872f, 38.79711f, 48.077187f, 41.00344f, 46.089417f, 40.903606f);
                h.cubicTo(32.38479f, 41.023407f, 18.670176f, 40.923573f, 4.965551f, 40.95352f);
                h.cubicTo(3.1475906f, 41.253025f, 0.94006723f, 40.08497f, 1.0799104f, 38.02839f);
                h.cubicTo(0.92008966f, 27.33618f, 1.0898992f, 16.633987f, 1.0f, 5.9417777f);
                h.cubicTo(1.0499439f, 4.4043355f, 0.8002241f, 2.4675581f, 2.358476f, 1.539103f);
                h.lineTo(2.358476f, 1.539103f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(52.013893f, 14.44758f);
                h.cubicTo(57.040844f, 10.022178f, 61.738647f, 5.21371f, 66.9551f, 1.0f);
                h.cubicTo(68.35148f, 3.0866935f, 67.92259f, 5.647177f, 67.98244f, 8.006048f);
                h.cubicTo(67.94254f, 17.774193f, 67.96249f, 27.532259f, 67.972466f, 37.29032f);
                h.cubicTo(68.00239f, 38.63105f, 67.65329f, 39.860886f, 66.93516f, 41.0f);
                h.cubicTo(61.728672f, 36.80645f, 57.06079f, 31.997984f, 52.02387f, 27.602823f);
                h.cubicTo(51.98397f, 23.217741f, 52.003918f, 18.83266f, 52.013893f, 14.44758f);
                h.lineTo(52.013893f, 14.44758f);
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
