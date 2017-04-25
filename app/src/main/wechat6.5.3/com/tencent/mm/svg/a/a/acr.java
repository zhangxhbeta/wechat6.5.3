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

public final class acr extends c {
    private final int height = 480;
    private final int width = 480;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 480;
            case 1:
                return 480;
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
                float[] a = c.a(c, 1.0f, 0.0f, 90.0f, 0.0f, 1.0f, 90.0f);
                d.reset();
                d.setValues(a);
                canvas.concat(d);
                Paint a2 = c.a(g, looper);
                a2.setColor(-11286451);
                canvas.save();
                Paint a3 = c.a(a2, looper);
                Path h = c.h(looper);
                h.moveTo(141.2704f, 0.26394463f);
                h.cubicTo(172.25175f, -1.596309f, 203.76312f, 6.414783f, 229.95427f, 23.087057f);
                h.cubicTo(255.80539f, 39.299267f, 276.4263f, 63.632584f, 288.2668f, 91.746414f);
                h.cubicTo(300.64734f, 120.9704f, 303.29745f, 154.15492f, 295.89716f, 185.00912f);
                h.cubicTo(288.77682f, 214.99323f, 272.0561f, 242.57698f, 248.82509f, 262.82974f);
                h.cubicTo(228.12419f, 281.05222f, 202.29306f, 293.39392f, 175.07187f, 297.9045f);
                h.cubicTo(145.15056f, 302.97522f, 113.699196f, 298.80466f, 86.24799f, 285.81287f);
                h.cubicTo(55.996677f, 271.65094f, 30.745575f, 247.05759f, 15.854925f, 217.15352f);
                h.cubicTo(0.8442703f, 187.46947f, -3.6459255f, 152.71472f, 2.9743633f, 120.15029f);
                h.cubicTo(9.454646f, 87.74587f, 27.115416f, 57.74178f, 52.226513f, 36.268852f);
                h.cubicTo(76.867584f, 14.905941f, 108.698975f, 2.034186f, 141.2704f, 0.26394463f);
                h.lineTo(141.2704f, 0.26394463f);
                h.close();
                h.moveTo(215.60826f, 93.22582f);
                h.cubicTo(185.5484f, 123.492424f, 155.53864f, 153.80917f, 125.4888f, 184.0858f);
                h.cubicTo(112.05204f, 170.58717f, 98.685425f, 157.00833f, 85.22863f, 143.52975f);
                h.cubicTo(82.7036f, 140.73175f, 77.964165f, 140.75182f, 75.429115f, 143.52975f);
                h.cubicTo(70.55942f, 148.38365f, 65.69974f, 153.24756f, 60.910202f, 158.18169f);
                h.cubicTo(58.33507f, 160.72897f, 58.375153f, 165.2519f, 60.9603f, 167.77914f);
                h.cubicTo(80.74971f, 187.80646f, 100.58922f, 207.77359f, 120.4187f, 227.77081f);
                h.cubicTo(122.963776f, 230.69919f, 127.88357f, 230.75935f, 130.46872f, 227.85103f);
                h.cubicTo(165.9594f, 192.11879f, 201.37993f, 156.31635f, 236.86058f, 120.5841f);
                h.cubicTo(239.075f, 118.25745f, 242.1912f, 115.96088f, 241.9908f, 112.3706f);
                h.cubicTo(242.06094f, 109.64279f, 240.06697f, 107.617f, 238.26338f, 105.86198f);
                h.cubicTo(233.83456f, 101.54964f, 229.62617f, 97.01666f, 225.14726f, 92.75447f);
                h.cubicTo(222.53204f, 90.17709f, 218.00304f, 90.5281f, 215.60826f, 93.22582f);
                h.lineTo(215.60826f, 93.22582f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a3);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-1);
                c = c.a(a, 1.0f, 0.0f, 58.0f, 0.0f, 1.0f, 90.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a4 = c.a(g, looper);
                h = c.h(looper);
                h.moveTo(157.60826f, 3.225819f);
                h.cubicTo(160.00304f, 0.5280999f, 164.53204f, 0.17709555f, 167.14726f, 2.7544703f);
                h.cubicTo(171.62617f, 7.0166664f, 175.83456f, 11.549637f, 180.26338f, 15.861977f);
                h.cubicTo(182.06697f, 17.616999f, 184.06094f, 19.642794f, 183.9908f, 22.3706f);
                h.cubicTo(184.1912f, 25.960873f, 181.075f, 28.257444f, 178.86058f, 30.584103f);
                h.cubicTo(143.37993f, 66.316345f, 107.95939f, 102.11879f, 72.46872f, 137.85103f);
                h.cubicTo(69.88357f, 140.75935f, 64.963776f, 140.69919f, 62.418705f, 137.77081f);
                h.cubicTo(42.58922f, 117.77358f, 22.749708f, 97.80645f, 2.9603012f, 77.779144f);
                h.cubicTo(0.37515315f, 75.251915f, 0.33507332f, 70.72897f, 2.9102013f, 68.18169f);
                h.cubicTo(7.699739f, 63.247566f, 12.559417f, 58.383648f, 17.429113f, 53.52976f);
                h.cubicTo(19.964163f, 50.75181f, 24.7036f, 50.731754f, 27.228628f, 53.52976f);
                h.cubicTo(40.685425f, 67.00832f, 54.052044f, 80.58718f, 67.4888f, 94.08581f);
                h.cubicTo(97.53864f, 63.809174f, 127.5484f, 33.492424f, 157.60826f, 3.225819f);
                h.lineTo(157.60826f, 3.225819f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a4);
                canvas.restore();
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
