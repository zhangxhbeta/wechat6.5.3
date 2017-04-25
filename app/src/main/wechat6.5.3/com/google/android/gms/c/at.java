package com.google.android.gms.c;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class at {

    public static class a {
        public final Map<String, com.google.android.gms.c.b.a> azX;
        public final com.google.android.gms.c.b.a azY;

        public final String toString() {
            return "Properties: " + Collections.unmodifiableMap(this.azX) + " pushAfterEvaluate: " + this.azY;
        }
    }

    public static class b {
        public final List<a> aAa;
        public final List<a> aAb;
        public final List<a> aAc;
        private final List<a> aAd;
        private final List<a> aAe;
        public final List<a> azZ;

        public final String toString() {
            return "Positive predicates: " + this.azZ + "  Negative predicates: " + this.aAa + "  Add tags: " + this.aAb + "  Remove tags: " + this.aAc + "  Add macros: " + this.aAd + "  Remove macros: " + this.aAe;
        }
    }

    public static com.google.android.gms.c.b.a a(com.google.android.gms.c.b.a aVar) {
        com.google.android.gms.c.b.a aVar2 = new com.google.android.gms.c.b.a();
        aVar2.type = aVar.type;
        aVar2.awV = (int[]) aVar.awV.clone();
        if (aVar.awW) {
            aVar2.awW = aVar.awW;
        }
        return aVar2;
    }
}
