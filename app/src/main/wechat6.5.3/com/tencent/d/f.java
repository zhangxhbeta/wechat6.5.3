package com.tencent.d;

import com.tencent.d.b.b;
import com.tencent.d.b.c;
import com.tencent.d.b.d;
import java.util.HashMap;

public final class f {
    private static f pHk;
    private HashMap<String, g> pHl = new HashMap();
    HashMap<String, Object> pHm = new HashMap();
    private Object pHn = new Object();
    Object pHo = new Object();
    private a pHp = new a(this);

    class a {
        private final Object mLock = new Object();
        private final HashMap<String, Object> pHq = new HashMap();
        final /* synthetic */ f pHr;

        a(f fVar) {
            this.pHr = fVar;
        }

        final void em(String str, String str2) {
            String str3 = str + str2;
            synchronized (this.mLock) {
                while (this.pHq.get(str3) != null) {
                    try {
                        this.mLock.wait();
                    } catch (InterruptedException e) {
                        throw new c("install fail,lock interrupted!");
                    }
                }
                this.pHq.put(str3, str2);
            }
        }

        final void en(String str, String str2) {
            String str3 = str + str2;
            synchronized (this.mLock) {
                this.pHq.remove(str3);
                this.mLock.notifyAll();
            }
        }
    }

    static f bPf() {
        if (pHk == null) {
            synchronized (f.class) {
                if (pHk == null) {
                    pHk = new f();
                }
            }
        }
        return pHk;
    }

    public static Object QG(String str) {
        return bPf().QH(str);
    }

    public static b a(d dVar) {
        return bPf().b(dVar);
    }

    private Object QH(String str) {
        if (str == null) {
            throw new h("TpfServiceCenter|getService|service name should not be null");
        }
        Object obj;
        synchronized (this.pHo) {
            obj = this.pHm.get(str);
        }
        if (obj == null) {
            g gVar;
            synchronized (this.pHn) {
                gVar = (g) this.pHl.get(str);
            }
            if (gVar != null) {
                if (gVar.pHt.pHF) {
                    return c(gVar);
                }
                Object obj2;
                if (4 == gVar.mState) {
                    try {
                        a(gVar);
                    } catch (c e) {
                        com.tencent.pb.common.c.c.i("service", e);
                        return null;
                    }
                }
                synchronized (this.pHo) {
                    obj2 = this.pHm.get(str);
                }
                return obj2;
            }
        }
        return obj;
    }

    private b b(d dVar) {
        Object obj = 1;
        if (dVar == null || dVar.pHD == null) {
            return null;
        }
        String str = dVar.pHD;
        this.pHp.em("install_", str);
        try {
            b bVar;
            Object obj2;
            synchronized (this.pHn) {
                bVar = (g) this.pHl.get(str);
                if (bVar == null) {
                    bVar = new g(this, dVar);
                    bVar.mState = 2;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] installed!");
                    this.pHl.put(str, bVar);
                    obj2 = 1;
                } else {
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] had been installed!");
                    obj2 = null;
                }
            }
            if (obj2 != null) {
                if (dVar.pHC == null) {
                    obj = null;
                }
                if (obj != null) {
                    bVar.mState = 4;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] resolved!");
                } else {
                    throw new c("resolve service [" + str + "] failed.");
                }
            }
            this.pHp.en("install_", str);
            return bVar;
        } catch (Throwable th) {
            this.pHp.en("install_", str);
        }
    }

    final boolean a(g gVar) {
        boolean z = false;
        d dVar = gVar.pHt;
        String str = dVar.pHD;
        this.pHp.em("service_", str);
        try {
            if (gVar.mState == 32) {
                z = true;
            } else if (gVar.mState == 4) {
                gVar.mState = 8;
                com.tencent.pb.common.c.c.d("service", "service [", str, "] starting...");
                if (dVar.pHE != null) {
                    I(dVar.pHE);
                }
                if (b(gVar)) {
                    gVar.mState = 32;
                    com.tencent.pb.common.c.c.d("service", "service [", str, "] active...");
                    z = true;
                }
            }
            this.pHp.en("service_", str);
            if (z) {
                return true;
            }
            throw new c("startService [" + str + "] failed");
        } catch (Throwable th) {
            this.pHp.en("service_", str);
        }
    }

    private boolean I(String[] strArr) {
        if (strArr != null) {
            for (Object obj : strArr) {
                if (obj != null) {
                    g gVar;
                    synchronized (this.pHn) {
                        gVar = (g) this.pHl.get(obj);
                    }
                    if (gVar == null) {
                        return false;
                    }
                    a(gVar);
                    if (gVar.mState != 32) {
                        return false;
                    }
                    gVar.mReferenceCount++;
                    com.tencent.pb.common.c.c.d("reference_count", "addReferenceCount|", gVar.pHt.pHD, "|refcount=", Integer.valueOf(gVar.mReferenceCount));
                }
            }
        }
        return true;
    }

    private static boolean b(g gVar) {
        if (!gVar.pHt.pHF) {
            try {
                b bVar = (b) Class.forName(gVar.pHt.pHC).newInstance();
                gVar.pHu = bVar;
                com.tencent.d.b.a aVar = new a(gVar);
                gVar.pHv = aVar;
                bVar.a(aVar);
                return true;
            } catch (Exception e) {
                com.tencent.pb.common.c.c.i("service", e);
            }
        }
        return false;
    }

    private static Object c(g gVar) {
        try {
            c cVar = (c) Class.forName(gVar.pHt.pHC).newInstance();
            gVar.pHv = new a(gVar);
            gVar.mState = 32;
            return cVar.bPc();
        } catch (Exception e) {
            com.tencent.pb.common.c.c.i("service", e);
            return null;
        }
    }
}
