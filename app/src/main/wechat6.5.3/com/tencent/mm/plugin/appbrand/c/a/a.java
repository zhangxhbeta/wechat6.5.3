package com.tencent.mm.plugin.appbrand.c.a;

import android.graphics.Paint;
import android.graphics.Shader;
import com.tencent.mm.plugin.appbrand.k.i;
import java.io.Serializable;

public final class a extends Paint implements Serializable {
    protected final Object clone() {
        return super.clone();
    }

    public final a Pt() {
        a aVar = new a();
        aVar.setColor(getColor());
        aVar.setFlags(getFlags());
        aVar.setDither(isDither());
        Shader shader = getShader();
        if (shader != null) {
            Shader shader2;
            Object a = i.a(Shader.class, "copy", shader, new Class[0], new Object[0]);
            if (a == null || !(a instanceof Shader)) {
                shader2 = shader;
            } else {
                shader2 = (Shader) a;
            }
            aVar.setShader(shader2);
        }
        aVar.setStrokeJoin(getStrokeJoin());
        aVar.setStrokeMiter(getStrokeMiter());
        aVar.setStrokeWidth(getStrokeWidth());
        aVar.setStrokeCap(getStrokeCap());
        aVar.setStyle(getStyle());
        aVar.setTextSize(getTextSize());
        aVar.setTextAlign(getTextAlign());
        aVar.setTypeface(getTypeface());
        return aVar;
    }
}
