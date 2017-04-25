package com.tencent.mm.plugin.appbrand.jsapi.a;

import com.tencent.mm.plugin.appbrand.jsapi.e;
import com.tencent.mm.plugin.appbrand.k.d;
import com.tencent.mm.plugin.appbrand.page.h;
import com.tencent.mm.plugin.appbrand.widget.input.c;
import com.tencent.mm.plugin.appbrand.widget.input.c.f;
import com.tencent.mm.sdk.platformtools.be;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class b extends d {
    private static final int CTRL_INDEX = 110;
    private static final String NAME = "insertTextArea";

    private static final class a extends e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onKeyboardShow";

        private a() {
        }
    }

    private static final class b extends e {
        private static final int CTRL_INDEX = -2;
        private static final String NAME = "onTextAreaHeightChange";

        private b() {
        }
    }

    public final void a(h hVar, JSONObject jSONObject, int i) {
        super.a(hVar, jSONObject, i);
    }

    protected final boolean a(com.tencent.mm.plugin.appbrand.widget.input.c.b bVar, JSONObject jSONObject, h hVar, int i) {
        if (!super.a(bVar, jSONObject, hVar, i)) {
            return false;
        }
        bVar.dXw = Boolean.valueOf(true);
        bVar.dWY = "emoji";
        bVar.dWZ = false;
        bVar.dXa = false;
        bVar.lqJ = Boolean.valueOf(false);
        bVar.dXx = Boolean.valueOf(true);
        return true;
    }

    protected final void a(final c cVar) {
        super.a(cVar);
        cVar.dWC = new f(this) {
            final /* synthetic */ b dJW;

            public final void c(int i, int i2, float f) {
                String str = cVar.dWK;
                if (!be.kS(str)) {
                    h nG = a.nG(str);
                    if (nG != null && nG.ZO) {
                        b bVar = new b();
                        Map hashMap = new HashMap();
                        hashMap.put("height", Integer.valueOf(d.hs((int) (((float) i) * (((float) i2) + f)))));
                        hashMap.put("lineCount", Integer.valueOf(i));
                        hashMap.put("inputId", str);
                        bVar.aa(nG.dzg, 0).o(hashMap).k(new int[]{nG.hashCode()});
                    }
                }
            }
        };
        cVar.dWD = new c.d(this) {
            final /* synthetic */ b dJW;

            public final void bw(boolean z) {
                if (z) {
                    String str = cVar.dWK;
                    if (!be.kS(str)) {
                        h nG = a.nG(str);
                        if (nG != null && nG.ZO) {
                            a aVar = new a();
                            Map hashMap = new HashMap();
                            hashMap.put("inputId", cVar.dWK);
                            aVar.aa(nG.dzg, 0).o(hashMap).k(new int[]{nG.hashCode()});
                        }
                    }
                }
            }
        };
    }

    protected final boolean Qs() {
        return false;
    }
}
