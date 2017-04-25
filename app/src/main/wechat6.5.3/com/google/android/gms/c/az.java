package com.google.android.gms.c;

import java.lang.reflect.Array;

public final class az<M extends ay<M>, T> {
    protected final Class<T> aAL;
    protected final boolean aAM;
    public final int tag;
    protected final int type;

    private int ae(Object obj) {
        int cj = bh.cj(this.tag);
        switch (this.type) {
            case 10:
                return (ax.cc(cj) * 2) + ((be) obj).lC();
            case 11:
                return ax.b(cj, (be) obj);
            default:
                throw new IllegalArgumentException("Unknown type " + this.type);
        }
    }

    private void b(Object obj, ax axVar) {
        try {
            axVar.cd(this.tag);
            switch (this.type) {
                case 10:
                    be beVar = (be) obj;
                    int cj = bh.cj(this.tag);
                    beVar.a(axVar);
                    axVar.ag(cj, 4);
                    return;
                case 11:
                    axVar.b((be) obj);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown type " + this.type);
            }
        } catch (Throwable e) {
            throw new IllegalStateException(e);
        }
        throw new IllegalStateException(e);
    }

    final void a(Object obj, ax axVar) {
        if (this.aAM) {
            int length = Array.getLength(obj);
            for (int i = 0; i < length; i++) {
                Object obj2 = Array.get(obj, i);
                if (obj2 != null) {
                    b(obj2, axVar);
                }
            }
            return;
        }
        b(obj, axVar);
    }

    final int ad(Object obj) {
        int i = 0;
        if (!this.aAM) {
            return ae(obj);
        }
        int length = Array.getLength(obj);
        for (int i2 = 0; i2 < length; i2++) {
            if (Array.get(obj, i2) != null) {
                i += ae(Array.get(obj, i2));
            }
        }
        return i;
    }
}
