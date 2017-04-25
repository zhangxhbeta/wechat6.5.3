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

public final class rp extends c {
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
                g = c.a(g, looper);
                g.setColor(-12206054);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(172.1131f, 158.48434f);
                h.cubicTo(170.05316f, 158.1662f, 167.92174f, 158.0f, 165.72351f, 158.0f);
                h.cubicTo(140.01566f, 158.0f, 123.447014f, 180.72963f, 123.447014f, 203.41473f);
                h.cubicTo(123.447014f, 225.27332f, 130.86368f, 230.84035f, 139.55563f, 243.80075f);
                h.cubicTo(151.07164f, 260.9691f, 133.30182f, 268.42276f, 124.72742f, 273.15573f);
                h.cubicTo(93.9516f, 290.1507f, 80.0f, 296.73767f, 80.0f, 305.5781f);
                h.lineTo(80.0f, 316.63174f);
                h.cubicTo(80.0f, 320.7442f, 82.90328f, 324.0f, 87.454994f, 324.0f);
                h.lineTo(106.0f, 324.0f);
                h.lineTo(106.0f, 313.84015f);
                h.cubicTo(106.0f, 303.6577f, 139.99591f, 281.85004f, 175.02455f, 261.5621f);
                h.cubicTo(180.41614f, 258.4394f, 185.67838f, 257.80884f, 188.21204f, 255.71149f);
                h.cubicTo(187.972f, 253.70976f, 188.22223f, 251.50589f, 189.12248f, 249.07043f);
                h.cubicTo(188.03903f, 245.9484f, 185.5458f, 241.54929f, 181.16434f, 235.14435f);
                h.cubicTo(168.40218f, 216.4851f, 167.3978f, 205.0813f, 167.39778f, 191.28004f);
                h.cubicTo(167.39778f, 184.88632f, 167.8619f, 171.26468f, 172.1131f, 158.48434f);
                h.lineTo(172.1131f, 158.48434f);
                h.close();
                h.moveTo(307.8869f, 158.48434f);
                h.cubicTo(309.94684f, 158.1662f, 312.07825f, 158.0f, 314.2765f, 158.0f);
                h.cubicTo(339.98434f, 158.0f, 356.55298f, 180.72963f, 356.55298f, 203.41473f);
                h.cubicTo(356.55298f, 225.27332f, 349.13632f, 230.84035f, 340.44437f, 243.80075f);
                h.cubicTo(328.92834f, 260.9691f, 346.69818f, 268.42276f, 355.27258f, 273.15573f);
                h.cubicTo(386.0484f, 290.1507f, 400.0f, 296.73767f, 400.0f, 305.5781f);
                h.lineTo(400.0f, 316.63174f);
                h.cubicTo(400.0f, 320.7442f, 397.0967f, 324.0f, 392.545f, 324.0f);
                h.lineTo(374.0f, 324.0f);
                h.lineTo(374.0f, 313.84015f);
                h.cubicTo(374.0f, 303.6577f, 340.0041f, 281.85004f, 304.97543f, 261.5621f);
                h.cubicTo(299.58386f, 258.4394f, 294.32162f, 257.80884f, 291.78796f, 255.71149f);
                h.cubicTo(292.028f, 253.70976f, 291.77777f, 251.50589f, 290.8775f, 249.07043f);
                h.cubicTo(291.96097f, 245.9484f, 294.4542f, 241.54929f, 298.83566f, 235.14435f);
                h.cubicTo(311.59784f, 216.4851f, 312.6022f, 205.0813f, 312.6022f, 191.28004f);
                h.cubicTo(312.6022f, 184.88632f, 312.13812f, 171.26468f, 307.8869f, 158.48434f);
                h.lineTo(307.8869f, 158.48434f);
                h.close();
                h.moveTo(281.31888f, 388.0f);
                h.lineTo(444.008f, 388.0f);
                h.cubicTo(455.05103f, 388.0f, 464.0f, 379.04703f, 464.0f, 368.00302f);
                h.lineTo(464.0f, 97.996994f);
                h.cubicTo(464.0f, 86.9641f, 455.04926f, 78.0f, 444.008f, 78.0f);
                h.lineTo(35.992016f, 78.0f);
                h.cubicTo(24.948969f, 78.0f, 16.0f, 86.95296f, 16.0f, 97.996994f);
                h.lineTo(16.0f, 368.00302f);
                h.cubicTo(16.0f, 379.0359f, 24.950731f, 388.0f, 35.992016f, 388.0f);
                h.lineTo(196.66887f, 388.0f);
                h.cubicTo(199.28546f, 390.60144f, 232.7567f, 422.68564f, 234.85847f, 424.65842f);
                h.cubicTo(236.74309f, 426.43124f, 241.24739f, 426.46307f, 243.132f, 424.65842f);
                h.cubicTo(246.00592f, 421.9054f, 279.603f, 389.66174f, 281.26654f, 388.0517f);
                h.cubicTo(281.28433f, 388.03445f, 281.30176f, 388.01724f, 281.31885f, 388.0f);
                h.lineTo(281.31888f, 388.0f);
                h.close();
                h.moveTo(185.27148f, 181.28253f);
                h.cubicTo(185.27148f, 210.77846f, 195.04807f, 218.29059f, 206.50572f, 235.77933f);
                h.cubicTo(221.68604f, 258.94623f, 198.26201f, 269.00418f, 186.9593f, 275.39087f);
                h.cubicTo(146.39088f, 298.32385f, 128.0f, 307.21228f, 128.0f, 319.1415f);
                h.lineTo(128.0f, 334.05728f);
                h.cubicTo(128.0f, 339.60663f, 131.82709f, 344.0f, 137.82712f, 344.0f);
                h.lineTo(344.17288f, 344.0f);
                h.cubicTo(350.1729f, 344.0f, 354.0f, 339.60663f, 354.0f, 334.05728f);
                h.lineTo(354.0f, 319.1415f);
                h.cubicTo(354.0f, 307.21228f, 335.60913f, 298.32385f, 295.04068f, 275.39087f);
                h.cubicTo(283.738f, 269.00418f, 260.31396f, 258.94623f, 275.49426f, 235.77933f);
                h.cubicTo(286.95193f, 218.29059f, 296.72852f, 210.77846f, 296.72852f, 181.28253f);
                h.cubicTo(296.72852f, 150.67131f, 274.88788f, 120.0f, 241.0f, 120.0f);
                h.cubicTo(207.11212f, 120.0f, 185.27148f, 150.67131f, 185.27148f, 181.28253f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
