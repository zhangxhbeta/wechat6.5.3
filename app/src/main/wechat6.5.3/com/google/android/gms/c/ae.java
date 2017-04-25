package com.google.android.gms.c;

import com.google.android.gms.common.internal.w;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ae {
    public final v agn;
    public final ag ayK;
    public boolean ayL;
    public long ayM;
    public long ayN;
    public long ayO;
    private long ayP;
    private long ayQ;
    public boolean ayR;
    final Map<Class<? extends af>, af> ayS;
    final List<ai> ayT;

    private ae(ae aeVar) {
        this.ayK = aeVar.ayK;
        this.agn = aeVar.agn;
        this.ayM = aeVar.ayM;
        this.ayN = aeVar.ayN;
        this.ayO = aeVar.ayO;
        this.ayP = aeVar.ayP;
        this.ayQ = aeVar.ayQ;
        this.ayT = new ArrayList(aeVar.ayT);
        this.ayS = new HashMap(aeVar.ayS.size());
        for (Entry entry : aeVar.ayS.entrySet()) {
            af c = c((Class) entry.getKey());
            ((af) entry.getValue()).a(c);
            this.ayS.put(entry.getKey(), c);
        }
    }

    ae(ag agVar, v vVar) {
        w.Z(agVar);
        w.Z(vVar);
        this.ayK = agVar;
        this.agn = vVar;
        this.ayP = 1800000;
        this.ayQ = 3024000000L;
        this.ayS = new HashMap();
        this.ayT = new ArrayList();
    }

    private static <T extends af> T c(Class<T> cls) {
        try {
            return (af) cls.newInstance();
        } catch (Throwable e) {
            throw new IllegalArgumentException("dataType doesn't have default constructor", e);
        } catch (Throwable e2) {
            throw new IllegalArgumentException("dataType default constructor is not accessible", e2);
        }
    }

    public final <T extends af> T a(Class<T> cls) {
        return (af) this.ayS.get(cls);
    }

    public final <T extends af> T b(Class<T> cls) {
        af afVar = (af) this.ayS.get(cls);
        if (afVar != null) {
            return afVar;
        }
        T c = c(cls);
        this.ayS.put(cls, c);
        return c;
    }

    public final void b(af afVar) {
        w.Z(afVar);
        Class cls = afVar.getClass();
        if (cls.getSuperclass() != af.class) {
            throw new IllegalArgumentException();
        }
        afVar.a(b(cls));
    }

    public final ae kW() {
        return new ae(this);
    }
}
