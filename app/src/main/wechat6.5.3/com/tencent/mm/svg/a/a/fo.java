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

public final class fo extends c {
    private final int height = MMGIFException.D_GIF_ERR_READ_FAILED;
    private final int width = MMGIFException.D_GIF_ERR_READ_FAILED;

    protected final int j(int i, Object... objArr) {
        switch (i) {
            case 0:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
            case 1:
                return MMGIFException.D_GIF_ERR_READ_FAILED;
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
                c = c.a(c, 1.0f, 0.0f, -2644.0f, 0.0f, 1.0f, -1766.0f);
                d.reset();
                d.setValues(c);
                canvas.concat(d);
                canvas.save();
                Paint a2 = c.a(a, looper);
                Path h = c.h(looper);
                h.moveTo(2716.0f, 1819.1445f);
                h.lineTo(2716.0f, 1793.4993f);
                h.cubicTo(2716.0f, 1792.396f, 2715.1057f, 1791.5f, 2714.0024f, 1791.5f);
                h.lineTo(2675.9976f, 1791.5f);
                h.cubicTo(2674.8967f, 1791.5f, 2674.0f, 1792.3951f, 2674.0f, 1793.4993f);
                h.lineTo(2674.0f, 1840.5007f);
                h.cubicTo(2674.0f, 1841.604f, 2674.8943f, 1842.5f, 2675.9976f, 1842.5f);
                h.lineTo(2714.0024f, 1842.5f);
                h.cubicTo(2715.1033f, 1842.5f, 2716.0f, 1841.6049f, 2716.0f, 1840.5007f);
                h.lineTo(2716.0f, 1821.9503f);
                h.lineTo(2694.9534f, 1833.2782f);
                h.lineTo(2694.801f, 1833.36f);
                h.cubicTo(2694.6123f, 1833.4487f, 2694.3997f, 1833.5f, 2694.1743f, 1833.5f);
                h.cubicTo(2693.6523f, 1833.5f, 2693.1985f, 1833.2317f, 2692.96f, 1832.836f);
                h.lineTo(2692.8687f, 1832.6495f);
                h.lineTo(2689.067f, 1824.8727f);
                h.cubicTo(2689.0254f, 1824.7877f, 2689.0f, 1824.692f, 2689.0f, 1824.5991f);
                h.cubicTo(2689.0f, 1824.241f, 2689.3118f, 1823.9498f, 2689.6965f, 1823.9498f);
                h.cubicTo(2689.8528f, 1823.9498f, 2689.9968f, 1823.9979f, 2690.113f, 1824.0787f);
                h.lineTo(2694.5994f, 1827.0565f);
                h.cubicTo(2694.9272f, 1827.2567f, 2695.3188f, 1827.3739f, 2695.74f, 1827.3739f);
                h.cubicTo(2695.991f, 1827.3739f, 2696.2307f, 1827.3301f, 2696.4539f, 1827.2546f);
                h.lineTo(2716.0f, 1819.1445f);
                h.close();
                h.moveTo(2695.0f, 1868.0f);
                h.cubicTo(2666.8335f, 1868.0f, 2644.0f, 1845.1665f, 2644.0f, 1817.0f);
                h.cubicTo(2644.0f, 1788.8335f, 2666.8335f, 1766.0f, 2695.0f, 1766.0f);
                h.cubicTo(2723.1665f, 1766.0f, 2746.0f, 1788.8335f, 2746.0f, 1817.0f);
                h.cubicTo(2746.0f, 1845.1665f, 2723.1665f, 1868.0f, 2695.0f, 1868.0f);
                h.close();
                h.moveTo(2695.0f, 1865.0f);
                h.cubicTo(2668.4902f, 1865.0f, 2647.0f, 1843.5096f, 2647.0f, 1817.0f);
                h.cubicTo(2647.0f, 1790.4904f, 2668.4902f, 1769.0f, 2695.0f, 1769.0f);
                h.cubicTo(2721.5098f, 1769.0f, 2743.0f, 1790.4904f, 2743.0f, 1817.0f);
                h.cubicTo(2743.0f, 1843.5096f, 2721.5098f, 1865.0f, 2695.0f, 1865.0f);
                h.close();
                h.moveTo(2681.5f, 1799.0f);
                h.lineTo(2696.5f, 1799.0f);
                h.lineTo(2696.5f, 1802.0f);
                h.lineTo(2681.5f, 1802.0f);
                h.lineTo(2681.5f, 1799.0f);
                h.close();
                h.moveTo(2681.5f, 1806.5f);
                h.lineTo(2696.5f, 1806.5f);
                h.lineTo(2696.5f, 1809.5f);
                h.lineTo(2681.5f, 1809.5f);
                h.lineTo(2681.5f, 1806.5f);
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
