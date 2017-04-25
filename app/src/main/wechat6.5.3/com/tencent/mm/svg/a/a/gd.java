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

public final class gd extends c {
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
                g = c.a(g, looper);
                g.setColor(-1);
                canvas.save();
                Paint a = c.a(g, looper);
                Path h = c.h(looper);
                h.moveTo(42.12588f, 36.742393f);
                h.lineTo(42.12f, 36.71424f);
                h.cubicTo(42.007042f, 36.173462f, 41.54885f, 35.48312f, 41.096966f, 35.174065f);
                h.lineTo(39.390366f, 34.00688f);
                h.lineTo(37.95631f, 32.572823f);
                h.lineTo(37.95631f, 20.0f);
                h.lineTo(37.912792f, 20.0f);
                h.lineTo(37.912792f, 20.0f);
                h.cubicTo(37.41485f, 13.43436f, 32.69628f, 8.049876f, 26.46792f, 6.56134f);
                h.lineTo(26.46792f, 6.56134f);
                h.lineTo(26.46792f, 5.1537137f);
                h.cubicTo(26.46792f, 3.4910684f, 25.12673f, 2.1520483f, 23.47229f, 2.1520483f);
                h.cubicTo(21.821215f, 2.1520483f, 20.476658f, 3.4959397f, 20.476658f, 5.1537137f);
                h.lineTo(20.476658f, 6.3603086f);
                h.cubicTo(18.205065f, 6.7427816f, 16.106981f, 7.637334f, 14.30484f, 8.921355f);
                h.lineTo(5.966166f, 0.58268034f);
                h.cubicTo(5.1872334f, -0.19625223f, 3.9198532f, -0.19421177f, 3.1368983f, 0.58874315f);
                h.lineTo(2.4366949f, 1.2889465f);
                h.cubicTo(1.6511122f, 2.0745292f, 1.6510255f, 3.3386078f, 2.430632f, 4.118214f);
                h.lineTo(42.033833f, 43.721416f);
                h.cubicTo(42.812767f, 44.500347f, 44.080147f, 44.49831f, 44.863102f, 43.715355f);
                h.lineTo(45.563305f, 43.01515f);
                h.cubicTo(46.34889f, 42.22957f, 46.348976f, 40.96549f, 45.569366f, 40.185883f);
                h.lineTo(42.12588f, 36.742393f);
                h.close();
                h.moveTo(31.312418f, 40.0f);
                h.lineTo(10.259289f, 40.0f);
                h.lineTo(10.259289f, 40.0f);
                h.cubicTo(10.022975f, 40.098007f, 9.763705f, 40.15205f, 9.491746f, 40.15205f);
                h.lineTo(6.1045136f, 40.15205f);
                h.cubicTo(5.011828f, 40.15205f, 4.2889323f, 39.27863f, 4.513982f, 38.201218f);
                h.lineTo(4.8245792f, 36.71424f);
                h.cubicTo(4.9375367f, 36.173462f, 5.3957276f, 35.48312f, 5.8476124f, 35.174065f);
                h.lineTo(8.0f, 33.701996f);
                h.lineTo(8.0f, 20.0f);
                h.lineTo(8.043519f, 20.0f);
                h.cubicTo(8.116167f, 19.042095f, 8.278654f, 18.109335f, 8.522562f, 17.210144f);
                h.lineTo(31.312418f, 40.0f);
                h.lineTo(31.312418f, 40.0f);
                h.close();
                h.moveTo(28.983171f, 42.0f);
                h.cubicTo(28.984678f, 42.0505f, 28.985437f, 42.101185f, 28.985437f, 42.15205f);
                h.cubicTo(28.985437f, 44.91347f, 26.75012f, 47.15205f, 23.992718f, 47.15205f);
                h.cubicTo(21.235315f, 47.15205f, 19.0f, 44.91347f, 19.0f, 42.15205f);
                h.cubicTo(19.0f, 42.101185f, 19.00076f, 42.0505f, 19.002264f, 42.0f);
                h.lineTo(28.983171f, 42.0f);
                h.lineTo(28.983171f, 42.0f);
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
