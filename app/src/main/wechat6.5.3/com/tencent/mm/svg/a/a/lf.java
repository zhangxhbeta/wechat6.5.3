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
import com.tencent.mmdb.FileUtils;
import com.tencent.smtt.sdk.WebView;

public final class lf extends c {
    private final int height = 200;
    private final int width = 120;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 120;
            case 1:
                return 200;
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
                g.setColor(-1);
                canvas.saveLayerAlpha(null, FileUtils.S_IWUSR, 4);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(43.813164f, 95.70703f);
                h.lineTo(54.653008f, 95.70703f);
                h.cubicTo(66.827545f, 95.70703f, 76.267555f, 92.79365f, 82.97332f, 86.9668f);
                h.cubicTo(89.679085f, 81.139946f, 93.03191f, 73.79952f, 93.03191f, 64.94531f);
                h.cubicTo(93.03191f, 55.244743f, 90.151085f, 47.334667f, 84.389336f, 41.214844f);
                h.cubicTo(78.62759f, 35.09502f, 69.88744f, 32.035156f, 58.168633f, 32.035156f);
                h.cubicTo(47.42639f, 32.035156f, 38.621143f, 35.078747f, 31.752617f, 41.166016f);
                h.cubicTo(24.884094f, 47.253284f, 21.449883f, 55.53771f, 21.449883f, 66.01953f);
                h.lineTo(16.176445f, 66.01953f);
                h.cubicTo(16.176445f, 53.9752f, 20.164036f, 44.42126f, 28.139336f, 37.35742f);
                h.cubicTo(36.114635f, 30.293585f, 46.124302f, 26.761719f, 58.168633f, 26.761719f);
                h.cubicTo(70.66869f, 26.761719f, 80.48305f, 30.163378f, 87.61199f, 36.966797f);
                h.cubicTo(94.74094f, 43.770218f, 98.30535f, 53.2265f, 98.30535f, 65.33594f);
                h.cubicTo(98.30535f, 73.018265f, 95.9779f, 79.756485f, 91.32293f, 85.55078f);
                h.cubicTo(86.66796f, 91.34508f, 80.30409f, 95.47916f, 72.23113f, 97.953125f);
                h.lineTo(72.32879f, 98.24609f);
                h.cubicTo(81.63873f, 100.52475f, 88.81639f, 104.61f, 93.86199f, 110.50195f);
                h.cubicTo(98.90759f, 116.39391f, 101.43035f, 123.99474f, 101.43035f, 133.30469f);
                h.cubicTo(101.43035f, 145.93495f, 97.556694f, 155.71677f, 89.80926f, 162.65039f);
                h.cubicTo(82.06182f, 169.58401f, 71.80802f, 173.05078f, 59.04754f, 173.05078f);
                h.cubicTo(46.74279f, 173.05078f, 36.016987f, 169.53519f, 26.869804f, 162.5039f);
                h.cubicTo(17.722624f, 155.47263f, 13.149102f, 145.12115f, 13.149102f, 131.44922f);
                h.lineTo(18.422539f, 131.44922f);
                h.cubicTo(18.422539f, 142.19147f, 22.214819f, 150.93161f, 29.799492f, 157.66992f);
                h.cubicTo(37.384167f, 164.40823f, 47.13342f, 167.77734f, 59.04754f, 167.77734f);
                h.cubicTo(71.026764f, 167.77734f, 80.20636f, 164.81514f, 86.5866f, 158.89062f);
                h.cubicTo(92.96684f, 152.96611f, 96.15691f, 144.56776f, 96.15691f, 133.69531f);
                h.cubicTo(96.15691f, 122.367134f, 92.49484f, 114.11526f, 85.170586f, 108.93945f);
                h.cubicTo(77.84633f, 103.76365f, 67.673904f, 101.17578f, 54.653008f, 101.17578f);
                h.lineTo(43.813164f, 101.17578f);
                h.lineTo(43.813164f, 95.70703f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
