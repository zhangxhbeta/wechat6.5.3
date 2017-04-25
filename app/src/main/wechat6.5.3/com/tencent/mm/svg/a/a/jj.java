package com.tencent.mm.svg.a.a;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Cap;
import android.graphics.Paint.Join;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.os.Looper;
import com.tencent.mm.svg.WeChatSVGRenderC2Java;
import com.tencent.mm.svg.c;
import com.tencent.smtt.sdk.WebView;

public final class jj extends c {
    private final int height = 192;
    private final int width = 192;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 192;
            case 1:
                return 192;
            case 2:
                Canvas canvas = (Canvas) objArr[0];
                Looper looper = (Looper) objArr[1];
                c.d(looper);
                c.c(looper);
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
                g2 = c.a(g, looper);
                g2.setColor(-14187817);
                Path h = c.h(looper);
                h.moveTo(0.0f, 0.0f);
                h.lineTo(192.0f, 0.0f);
                h.lineTo(192.0f, 192.0f);
                h.lineTo(0.0f, 192.0f);
                h.lineTo(0.0f, 0.0f);
                h.close();
                canvas.drawPath(h, g2);
                canvas.restore();
                canvas.save();
                Paint a = c.a(g, looper);
                a.setColor(-1);
                Path h2 = c.h(looper);
                h2.moveTo(57.156643f, 93.206894f);
                h2.lineTo(57.156643f, 95.11902f);
                h2.lineTo(57.156643f, 95.11902f);
                h2.lineTo(30.811815f, 142.92213f);
                h2.cubicTo(30.298296f, 145.2748f, 30.921196f, 147.50424f, 32.69359f, 148.65851f);
                h2.lineTo(38.33891f, 152.48276f);
                h2.cubicTo(39.435417f, 152.49355f, 40.410313f, 152.62009f, 42.102455f, 152.48276f);
                h2.cubicTo(42.45778f, 152.0469f, 43.228115f, 151.43279f, 43.98423f, 150.57063f);
                h2.lineTo(65.69183f, 111.18185f);
                h2.lineTo(65.69183f, 111.18185f);
                h2.lineTo(90.23086f, 150.57063f);
                h2.cubicTo(91.16817f, 151.4467f, 93.29706f, 152.75879f, 95.025116f, 152.65048f);
                h2.cubicTo(96.75389f, 152.76245f, 98.885605f, 151.45566f, 99.82381f, 150.63039f);
                h2.lineTo(124.29417f, 111.057236f);
                h2.lineTo(124.29417f, 111.057236f);
                h2.lineTo(146.07043f, 150.57063f);
                h2.cubicTo(146.82886f, 151.43279f, 147.59917f, 152.0469f, 147.95221f, 152.48276f);
                h2.cubicTo(149.64471f, 152.62009f, 150.61957f, 152.49355f, 151.71576f, 152.48276f);
                h2.lineTo(157.36108f, 148.65851f);
                h2.cubicTo(159.13347f, 147.50615f, 159.75635f, 145.27484f, 159.24284f, 142.92213f);
                h2.lineTo(132.89803f, 95.11902f);
                h2.lineTo(132.89803f, 95.11902f);
                h2.lineTo(132.89803f, 93.206894f);
                h2.lineTo(152.09935f, 93.206894f);
                h2.cubicTo(153.16206f, 93.206894f, 155.94975f, 90.2287f, 155.94975f, 89.090515f);
                h2.lineTo(155.94975f, 80.85776f);
                h2.cubicTo(155.94975f, 78.58552f, 154.22476f, 76.74138f, 152.09935f, 76.74138f);
                h2.lineTo(34.662212f, 76.74138f);
                h2.cubicTo(33.599503f, 76.74138f, 30.811815f, 79.71958f, 30.811815f, 80.85776f);
                h2.lineTo(30.811815f, 89.090515f);
                h2.cubicTo(30.811815f, 91.362755f, 32.536793f, 93.206894f, 34.662212f, 93.206894f);
                h2.lineTo(57.156643f, 93.206894f);
                h2.close();
                h2.moveTo(73.62216f, 93.206894f);
                h2.lineTo(73.62216f, 95.34885f);
                h2.lineTo(95.089294f, 129.8068f);
                h2.lineTo(95.089294f, 129.8068f);
                h2.lineTo(116.4325f, 95.29082f);
                h2.lineTo(116.4325f, 93.206894f);
                h2.lineTo(73.62216f, 93.206894f);
                h2.close();
                h2.moveTo(66.26111f, 40.517242f);
                h2.cubicTo(73.57296f, 40.517242f, 80.20837f, 47.15091f, 80.20837f, 56.207912f);
                h2.cubicTo(80.20837f, 63.521507f, 73.57296f, 70.155174f, 66.26111f, 70.155174f);
                h2.cubicTo(57.2041f, 70.155174f, 50.57044f, 63.519764f, 50.57044f, 56.207912f);
                h2.cubicTo(50.57044f, 47.15091f, 57.2041f, 40.517242f, 66.26111f, 40.517242f);
                h2.close();
                h2.moveTo(125.536964f, 40.517242f);
                h2.cubicTo(132.84882f, 40.517242f, 139.48422f, 47.15091f, 139.48422f, 56.207912f);
                h2.cubicTo(139.48422f, 63.521507f, 132.84882f, 70.155174f, 125.536964f, 70.155174f);
                h2.cubicTo(116.479965f, 70.155174f, 109.8463f, 63.519764f, 109.8463f, 56.207912f);
                h2.cubicTo(109.8463f, 47.15091f, 116.479965f, 40.517242f, 125.536964f, 40.517242f);
                h2.close();
                WeChatSVGRenderC2Java.setFillType(h2, 2);
                canvas.drawPath(h2, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
