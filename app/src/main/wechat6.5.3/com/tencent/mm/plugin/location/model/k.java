package com.tencent.mm.plugin.location.model;

import com.tencent.mm.a.g;
import com.tencent.mm.h.j;
import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.pluginsdk.location.b;
import com.tencent.mm.sdk.platformtools.ap;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.v.e;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public final class k implements e {
    List<com.tencent.mm.pluginsdk.location.a> bXt = new ArrayList();
    ap cJw = new ap(1, "location_worker");
    LinkedList<b> gSr = new LinkedList();
    b gSs = null;
    int h = 300;
    int w = 300;

    public class a implements com.tencent.mm.sdk.platformtools.ap.a {
        private String aVL;
        private byte[] data;
        boolean gSt = true;
        private int gSu;
        private int gSv;
        final /* synthetic */ k gSw;
        String url = "";

        public a(k kVar, boolean z, String str, String str2) {
            this.gSw = kVar;
            this.gSt = z;
            this.gSu = kVar.w;
            this.gSv = kVar.h;
            this.url = str;
            while (this.gSu * this.gSv > 270000) {
                this.gSu = (int) (((double) this.gSu) / 1.2d);
                this.gSv = (int) (((double) this.gSv) / 1.2d);
            }
            this.aVL = str2;
            v.i("MicroMsg.StaticMapServer", "get url %s %s", new Object[]{str, be.ah(this.aVL, "")});
        }

        public final boolean AZ() {
            this.data = be.KO(this.url);
            if (this.data != null) {
                com.tencent.mm.a.e.b(this.aVL, this.data, this.data.length);
            }
            return true;
        }

        public final boolean Ba() {
            v.i("MicroMsg.StaticMapServer", "http onPostExecute " + (this.data == null) + " isGoole: " + this.gSt);
            if (this.data != null) {
                this.gSw.dU(true);
            } else if (!this.gSt) {
                this.gSw.dU(false);
            } else if (this.gSw.gSs == null) {
                this.gSw.dU(false);
            } else {
                this.url = String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(this.gSu), Integer.valueOf(this.gSv), Float.valueOf(this.gSw.gSs.cJr), Float.valueOf(this.gSw.gSs.cJq), Integer.valueOf(this.gSw.gSs.bhu)});
                this.gSw.cJw.c(new a(this.gSw, false, this.url, k.b(this.gSw.gSs)));
            }
            return false;
        }
    }

    public final void a(com.tencent.mm.pluginsdk.location.a aVar) {
        this.bXt.remove(aVar);
        v.i("MicroMsg.StaticMapServer", "removeCallback " + this.bXt.size());
        if (this.bXt.size() == 0) {
            v.i("MicroMsg.StaticMapServer", "clean task");
            this.gSr.clear();
            this.gSs = null;
            stop();
        }
    }

    public k() {
        start();
    }

    public final void start() {
        ak.vy().a(648, this);
    }

    public final void stop() {
        v.i("MicroMsg.StaticMapServer", "stop static map server");
        ak.vy().b(648, this);
    }

    final void FX() {
        if (this.gSs == null && this.gSr.size() > 0) {
            int intValue;
            this.gSs = (b) this.gSr.removeFirst();
            try {
                intValue = Integer.valueOf(be.ah(j.sU().getValue("StaticMapGetClient"), "")).intValue();
            } catch (Exception e) {
                intValue = 0;
            }
            v.i("MicroMsg.StaticMapServer", "run local %d", new Object[]{Integer.valueOf(intValue)});
            if (intValue == 0) {
                ak.vy().a(new g(this.gSs.cJq, this.gSs.cJr, this.gSs.bhu + 1, this.w, this.h, b(this.gSs), u.bsY()), 0);
                return;
            }
            int i = this.w;
            for (intValue = this.h; i * intValue > 270000; intValue = (int) (((double) intValue) / 1.2d)) {
                i = (int) (((double) i) / 1.2d);
            }
            if (be.He()) {
                this.cJw.c(new a(this, true, String.format("https://maps.googleapis.com/maps/api/staticmap?size=%dx%d&center=%f,%f&zoom=%d&format=jpg&language=%s&sensor=true", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.gSs.cJq), Float.valueOf(this.gSs.cJr), Integer.valueOf(this.gSs.bhu), u.bsY()}), b(this.gSs)));
                return;
            }
            this.cJw.c(new a(this, false, String.format("http://st.map.qq.com/api?size=%d*%d&center=%f,%f&zoom=%d&referer=weixin", new Object[]{Integer.valueOf(i), Integer.valueOf(intValue), Float.valueOf(this.gSs.cJr), Float.valueOf(this.gSs.cJq), Integer.valueOf(this.gSs.bhu)}), b(this.gSs)));
        }
    }

    public static String b(b bVar) {
        String m = g.m((bVar.toString()).getBytes());
        StringBuilder stringBuilder = new StringBuilder();
        ak.yW();
        String stringBuilder2 = stringBuilder.append(c.wQ()).append(m.charAt(0)).append(m.charAt(1)).append("/").append(m.charAt(3)).append(m.charAt(4)).append("/").toString();
        if (!com.tencent.mm.a.e.aR(stringBuilder2)) {
            new File(stringBuilder2).mkdirs();
        }
        return stringBuilder2 + "static_map_" + m;
    }

    private void dU(boolean z) {
        v.i("MicroMsg.StaticMapServer", "httpgetStaticmapDone %b", new Object[]{Boolean.valueOf(z)});
        if (z) {
            if (this.gSs != null) {
                for (com.tencent.mm.pluginsdk.location.a aVar : this.bXt) {
                    if (aVar != null) {
                        aVar.a(b(this.gSs), this.gSs);
                    }
                }
            }
        } else if (this.gSs != null) {
            for (com.tencent.mm.pluginsdk.location.a aVar2 : this.bXt) {
                if (aVar2 != null) {
                    aVar2.a(this.gSs);
                }
            }
        }
        this.gSs = null;
        FX();
    }

    public final void a(int i, int i2, String str, com.tencent.mm.v.k kVar) {
        if (kVar.getType() != 648) {
            return;
        }
        if (i == 0 && i2 == 0 && this.gSs != null) {
            dU(true);
        } else {
            dU(false);
        }
    }
}
