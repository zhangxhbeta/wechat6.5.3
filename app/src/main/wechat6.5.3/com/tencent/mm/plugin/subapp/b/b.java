package com.tencent.mm.plugin.subapp.b;

import com.tencent.mm.model.ak;
import com.tencent.mm.model.c;
import com.tencent.mm.platformtools.m;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.storage.at;
import com.tencent.mm.v.d;
import com.tencent.mm.v.e;
import com.tencent.mm.v.k;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

public final class b implements d, e {
    private Queue<a> kfo = null;
    private boolean kfp = false;

    static class a {
        public String dvW;
        public Queue<String> kfq = new LinkedList();

        a(String str) {
            this.dvW = str;
            v.d("MicroMsg.PushMessageExtension", "DoSceneStruct:" + str);
            ArrayList aR = com.tencent.mm.pluginsdk.m.a.a.aR(aa.getContext(), str);
            if (aR == null || aR.size() <= 0) {
                v.e("MicroMsg.PushMessageExtension", "Parse Message Failed !");
                return;
            }
            for (int i = 0; i < aR.size(); i++) {
                Map map = ((com.tencent.mm.pluginsdk.m.a.a) aR.get(i)).lFi;
                if (map != null) {
                    for (Entry value : map.entrySet()) {
                        this.kfq.offer(value.getValue());
                    }
                }
            }
        }
    }

    public final com.tencent.mm.v.d.b b(com.tencent.mm.v.d.a aVar) {
        String a = m.a(aVar.czu.mbW);
        if (this.kfo == null) {
            this.kfo = new LinkedList();
        }
        a aVar2 = new a(a);
        if (aVar2.dvW != null) {
            this.kfo.offer(aVar2);
            aZt();
        }
        return null;
    }

    private void aZt() {
        if (!this.kfp && this.kfo.size() != 0) {
            a aVar = (a) this.kfo.peek();
            if (aVar.kfq.size() == 0) {
                this.kfo.poll();
                ak.yW();
                c.vf().set(8193, aVar.dvW);
                ak.yW();
                c.vf().set(8449, Long.valueOf(be.Nh()));
                return;
            }
            String str = (String) aVar.kfq.peek();
            if (str != null && str.length() > 0) {
                this.kfp = true;
                k aVar2 = new a(str);
                ak.vy().a(141, (e) this);
                ak.vy().a(aVar2, 0);
            }
        }
    }

    public final void a(int i, int i2, String str, k kVar) {
        if (kVar.getType() != 141) {
            this.kfp = false;
            return;
        }
        ak.vy().b(141, (e) this);
        String str2 = ((a) kVar).url;
        a aVar = (a) this.kfo.peek();
        if (aVar == null || aVar.kfq.size() == 0) {
            v.e("MicroMsg.PushMessageExtension", "getDoSceneQueue failed ! reset queue!");
            this.kfo = new LinkedList();
            this.kfp = false;
        } else if (aVar.kfq.size() == 0) {
            v.e("MicroMsg.PushMessageExtension", "get imgQueue failed ! ignore this message");
            this.kfo.poll();
            this.kfp = false;
        } else if (!((String) aVar.kfq.peek()).equals(str2)) {
            v.e("MicroMsg.PushMessageExtension", "check img url failed ! ignore this message");
            this.kfo.poll();
            this.kfp = false;
        } else if (i == 0 && i2 == 0) {
            aVar.kfq.poll();
            this.kfp = false;
            aZt();
        } else {
            v.e("MicroMsg.PushMessageExtension", "down failed [" + i + "," + i2 + "] ignore this message : img:[" + str2 + "] ");
            this.kfo.poll();
            this.kfp = false;
        }
    }

    public final void d(at atVar) {
    }
}
