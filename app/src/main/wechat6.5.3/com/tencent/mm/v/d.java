package com.tencent.mm.v;

import com.tencent.mm.protocal.c.bm;
import com.tencent.mm.storage.at;
import java.util.HashMap;

public interface d {

    public static class a {
        public bm czu;
        public boolean czv = false;
        public boolean czw = false;
        public boolean czx = false;

        public a(bm bmVar, boolean z, boolean z2, boolean z3) {
            this.czu = bmVar;
            this.czv = z;
            this.czw = z2;
            this.czx = z3;
        }

        public final String toString() {
            return String.format("AddMsgInfo(%d), get[%b], fault[%b], up[%b]", new Object[]{Integer.valueOf(hashCode()), Boolean.valueOf(this.czv), Boolean.valueOf(this.czw), Boolean.valueOf(this.czx)});
        }
    }

    public static class b {
        public at aXd;
        public boolean czy;

        public b(at atVar, boolean z) {
            this.aXd = atVar;
            this.czy = z;
        }
    }

    public static class c {
        private static HashMap<Object, d> czz = new HashMap();

        public static void a(Object obj, d dVar) {
            czz.put(obj, dVar);
        }

        public static void aw(Object obj) {
            czz.remove(obj);
        }

        public static d ax(Object obj) {
            return (d) czz.get(obj);
        }
    }

    b b(a aVar);

    void d(at atVar);
}
