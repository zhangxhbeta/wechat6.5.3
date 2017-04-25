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

public final class ds extends c {
    private final int height = 48;
    private final int width = 48;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return 48;
            case 1:
                return 48;
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
                Paint a = c.a(g, looper);
                a.setColor(-16336124);
                Path h = c.h(looper);
                h.moveTo(24.0f, 4.0f);
                h.cubicTo(24.0f, 4.0f, 16.25142f, 8.95561f, 7.0f, 11.0f);
                h.cubicTo(7.039861f, 42.419357f, 24.0f, 44.0f, 24.0f, 44.0f);
                h.lineTo(24.0f, 4.0f);
                h.close();
                h.moveTo(24.0f, 4.0f);
                h.cubicTo(24.0f, 4.0f, 31.74858f, 8.95561f, 41.0f, 11.0f);
                h.cubicTo(40.96014f, 42.419357f, 24.0f, 44.0f, 24.0f, 44.0f);
                h.lineTo(24.0f, 4.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                a = c.a(g, looper);
                a.setColor(-1315349);
                h = c.h(looper);
                h.moveTo(24.0f, 6.0f);
                h.cubicTo(24.0f, 6.0f, 17.163017f, 10.46005f, 9.0f, 12.3f);
                h.cubicTo(9.0351715f, 40.577423f, 24.0f, 42.0f, 24.0f, 42.0f);
                h.lineTo(24.0f, 6.0f);
                h.close();
                h.moveTo(24.0f, 6.0f);
                h.cubicTo(24.0f, 6.0f, 30.836983f, 10.46005f, 39.0f, 12.3f);
                h.cubicTo(38.96483f, 40.577423f, 24.0f, 42.0f, 24.0f, 42.0f);
                h.lineTo(24.0f, 6.0f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a);
                canvas.restore();
                canvas.save();
                g = c.a(g, looper);
                g.setColor(-16336124);
                h = c.h(looper);
                h.moveTo(20.410254f, 18.501059f);
                h.lineTo(20.410254f, 23.028254f);
                h.lineTo(24.400131f, 23.028254f);
                h.cubicTo(25.192776f, 23.028254f, 25.787249f, 22.936796f, 26.18357f, 22.753878f);
                h.cubicTo(26.884756f, 22.433771f, 27.235344f, 21.80119f, 27.235344f, 20.856113f);
                h.cubicTo(27.235344f, 19.834824f, 26.896189f, 19.148891f, 26.217869f, 18.798298f);
                h.cubicTo(25.83679f, 18.600138f, 25.265179f, 18.501059f, 24.503021f, 18.501059f);
                h.lineTo(20.410254f, 18.501059f);
                h.close();
                h.moveTo(29.578968f, 17.186342f);
                h.cubicTo(29.944803f, 17.613152f, 30.234419f, 18.085682f, 30.447824f, 18.603949f);
                h.cubicTo(30.661228f, 19.122217f, 30.76793f, 19.71288f, 30.76793f, 20.375957f);
                h.cubicTo(30.76793f, 21.176224f, 30.56596f, 21.963139f, 30.162016f, 22.736729f);
                h.cubicTo(29.758072f, 23.51032f, 29.091194f, 24.05716f, 28.161362f, 24.377266f);
                h.cubicTo(28.938763f, 24.68975f, 29.489414f, 25.133701f, 29.81333f, 25.709131f);
                h.cubicTo(30.137247f, 26.28456f, 30.078083f, 26.648375f, 30.447823f, 28.688023f);
                h.cubicTo(30.817564f, 30.72767f, 31.030872f, 32.425613f, 31.030872f, 32.425613f);
                h.lineTo(27.155317f, 32.425613f);
                h.cubicTo(27.075876f, 32.147568f, 26.471811f, 27.43906f, 26.471811f, 27.43906f);
                h.cubicTo(26.471811f, 27.43906f, 26.282516f, 25.70913f, 24.045729f, 25.817738f);
                h.lineTo(20.410254f, 25.817738f);
                h.lineTo(20.410254f, 32.425613f);
                h.lineTo(16.969128f, 32.425613f);
                h.lineTo(16.969128f, 15.574387f);
                h.lineTo(25.23469f, 15.574387f);
                h.cubicTo(26.416035f, 15.597251f, 27.324894f, 15.742059f, 27.961296f, 16.008814f);
                h.cubicTo(27.961296f, 16.008814f, 29.136917f, 16.668076f, 29.578968f, 17.186342f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, g);
                canvas.restore();
                c.f(looper);
                break;
        }
        return 0;
    }
}
