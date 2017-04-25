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

public final class ge extends c {
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
                c = c.a(c, 1.0f, 0.0f, 26.0f, 0.0f, 1.0f, 28.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(0.660553f, 11.363595f);
                h.cubicTo(3.7094238f, 1.7767347f, 17.910477f, -2.88089f, 25.122423f, 4.975708f);
                h.cubicTo(30.733967f, 9.834526f, 27.685097f, 20.839798f, 19.895788f, 21.030931f);
                h.cubicTo(17.940865f, 21.38302f, 17.64712f, 19.27049f, 17.778797f, 17.862139f);
                h.cubicTo(20.078112f, 17.379274f, 23.187757f, 16.986948f, 23.846151f, 14.270838f);
                h.cubicTo(24.909712f, 10.176555f, 21.688646f, 5.991734f, 17.63699f, 5.2976174f);
                h.cubicTo(11.073308f, 3.7584887f, 3.223225f, 9.341602f, 4.013298f, 16.353188f);
                h.cubicTo(4.013298f, 20.356936f, 6.586099f, 23.50561f, 8.22702f, 26.925896f);
                h.cubicTo(8.996835f, 30.748568f, 9.594454f, 35.818638f, 13.86895f, 37.34771f);
                h.cubicTo(17.464794f, 38.564926f, 20.128757f, 34.691956f, 19.28804f, 31.452745f);
                h.cubicTo(19.672947f, 28.525383f, 16.69498f, 27.620012f, 14.537474f, 26.80518f);
                h.cubicTo(10.354139f, 25.336468f, 7.274881f, 20.84986f, 8.257407f, 16.393427f);
                h.cubicTo(8.905672f, 11.776041f, 14.567861f, 8.989514f, 18.761324f, 10.729836f);
                h.cubicTo(18.862616f, 11.434012f, 19.055069f, 12.842365f, 19.15636f, 13.546542f);
                h.cubicTo(17.008984f, 13.818152f, 14.182954f, 13.405706f, 12.80539f, 15.488057f);
                h.cubicTo(10.901113f, 18.304764f, 12.633195f, 22.328629f, 15.783358f, 23.344654f);
                h.cubicTo(18.092802f, 24.592052f, 21.860842f, 24.511576f, 22.478718f, 27.640131f);
                h.cubicTo(23.238403f, 30.849165f, 23.116854f, 34.400227f, 21.688646f, 37.418125f);
                h.cubicTo(19.308298f, 41.80414f, 12.633195f, 41.924854f, 9.017093f, 39.06791f);
                h.cubicTo(5.2186656f, 35.899117f, 6.474679f, 30.235525f, 3.4865828f, 26.573807f);
                h.cubicTo(0.4579702f, 22.228033f, -0.91959274f, 16.504084f, 0.660553f, 11.363595f);
                h.lineTo(0.660553f, 11.363595f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(35.989487f, 8.295734f);
                h.cubicTo(37.424026f, 7.2782207f, 38.27263f, 9.143662f, 39.0f, 10.011541f);
                h.cubicTo(34.807507f, 13.43318f, 31.66566f, 18.660406f, 32.706207f, 24.206854f);
                h.cubicTo(33.05979f, 28.207079f, 36.019794f, 31.10001f, 38.424164f, 34.052795f);
                h.cubicTo(38.54539f, 36.247433f, 35.83795f, 36.606552f, 34.756992f, 35.030403f);
                h.cubicTo(26.654873f, 28.276907f, 27.139788f, 14.191328f, 35.989487f, 8.295734f);
                h.lineTo(35.989487f, 8.295734f);
                h.close();
                WeChatSVGRenderC2Java.setFillType(h, 2);
                canvas.drawPath(h, a2);
                canvas.restore();
                canvas.save();
                a2 = c.a(a, looper);
                h = c.h(looper);
                h.moveTo(39.88163f, 15.777096f);
                h.cubicTo(40.299755f, 15.582822f, 41.14596f, 15.194274f, 41.574043f, 15.0f);
                h.cubicTo(45.52633f, 16.635992f, 39.951317f, 19.846626f, 40.488907f, 22.607363f);
                h.cubicTo(40.110603f, 25.143148f, 45.26749f, 29.417177f, 40.61833f, 30.0f);
                h.cubicTo(36.0289f, 26.96319f, 35.829792f, 19.396729f, 39.88163f, 15.777096f);
                h.lineTo(39.88163f, 15.777096f);
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
