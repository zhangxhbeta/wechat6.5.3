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

public final class ji extends c {
    private final int height = 140;
    private final int width = 140;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 140;
            case 1:
                return 140;
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
                g2 = c.a(g, looper);
                g2.setColor(-1118482);
                canvas.save();
                Paint a = c.a(g2, looper);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(140.0f, 0.0f);
                h.lineTo(140.0f, 140.0f);
                h.lineTo(0.0f, 140.0f);
                h.lineTo(0.0f, 0.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                h.moveTo(57.01697f, 36.70791f);
                h.cubicTo(52.47772f, 42.007774f, 52.327744f, 49.61193f, 53.287586f, 56.18417f);
                h.cubicTo(54.177437f, 62.365677f, 58.826675f, 66.90413f, 61.326267f, 72.38433f);
                h.cubicTo(62.965996f, 75.5903f, 60.956326f, 79.227066f, 58.146786f, 80.93024f);
                h.cubicTo(50.34807f, 85.88947f, 41.699486f, 89.496185f, 34.320694f, 95.106636f);
                h.cubicTo(29.991405f, 98.26251f, 30.801273f, 104.32379f, 31.761116f, 108.90232f);
                h.cubicTo(56.97698f, 109.04258f, 82.21284f, 109.01252f, 107.4287f, 108.93237f);
                h.cubicTo(111.00812f, 109.022545f, 109.668335f, 104.48409f, 109.95829f, 102.1798f);
                h.cubicTo(110.32823f, 98.77346f, 108.188576f, 95.89811f, 105.47903f, 94.13483f);
                h.cubicTo(98.66014f, 89.41604f, 91.11138f, 85.89949f, 84.00255f, 81.6616f);
                h.cubicTo(81.18301f, 79.998505f, 78.07352f, 76.83261f, 79.4333f, 73.25595f);
                h.cubicTo(81.55295f, 67.455154f, 86.57213f, 63.016888f, 87.64195f, 56.75523f);
                h.cubicTo(88.63179f, 50.182995f, 88.71178f, 42.598877f, 84.292496f, 37.168766f);
                h.cubicTo(77.66359f, 29.10375f, 63.935837f, 28.943453f, 57.01697f, 36.70791f);
                h.lineTo(57.01697f, 36.70791f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-4934220);
                float[] a2 = c.a(c, 1.0f, 0.0f, 30.0f, 0.0f, 1.0f, 30.0f);
                d.reset();
                d.setValues(a2);
                canvas.concat(d);
                canvas.save();
                Paint a3 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(27.016973f, 6.7079077f);
                h.cubicTo(33.935837f, -1.056548f, 47.663586f, -0.8962496f, 54.2925f, 7.1687655f);
                h.cubicTo(58.711773f, 12.598875f, 58.631786f, 20.182995f, 57.64195f, 26.755232f);
                h.cubicTo(56.572124f, 33.016888f, 51.552948f, 37.45515f, 49.433296f, 43.25595f);
                h.cubicTo(48.073517f, 46.83261f, 51.18301f, 49.998505f, 54.002544f, 51.661602f);
                h.cubicTo(61.11138f, 55.89949f, 68.66014f, 59.41604f, 75.47903f, 64.13483f);
                h.cubicTo(78.188576f, 65.89811f, 80.328224f, 68.77346f, 79.95829f, 72.1798f);
                h.cubicTo(79.668335f, 74.48409f, 81.00812f, 79.022545f, 77.4287f, 78.93237f);
                h.cubicTo(52.21284f, 79.01252f, 26.976978f, 79.04258f, 1.7611154f, 78.90232f);
                h.cubicTo(0.8012729f, 74.32379f, -0.008594216f, 68.26251f, 4.3206954f, 65.106636f);
                h.cubicTo(11.699485f, 59.49619f, 20.348066f, 55.889473f, 28.146788f, 50.93024f);
                h.cubicTo(30.956327f, 49.22707f, 32.965996f, 45.590298f, 31.326265f, 42.38433f);
                h.cubicTo(28.826675f, 36.904125f, 24.177439f, 32.365677f, 23.287584f, 26.184168f);
                h.cubicTo(22.327742f, 19.611933f, 22.477716f, 12.007775f, 27.016973f, 6.7079077f);
                h.lineTo(27.016973f, 6.7079077f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
