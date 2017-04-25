package com.tencent.mm.kernel;

import com.tencent.mm.kernel.plugin.ProcessProfile;
import com.tencent.mm.kernel.plugin.b;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import junit.framework.Assert;

public final class c {
    private final HashMap<Class<? extends com.tencent.mm.kernel.plugin.a>, b> cjJ = new HashMap();
    public final ArrayList<b> cjK = new ArrayList();
    private final HashMap<Class<? extends b>, ArrayList<Class<? extends com.tencent.mm.kernel.plugin.a>>> cjL = new HashMap();
    private final HashMap<Class<? extends com.tencent.mm.kernel.plugin.a>, Class<? extends b>> cjM = new HashMap();
    private f<Class<? extends b>> cjN = new f();
    private HashMap<Class<? extends com.tencent.mm.kernel.b.c>, com.tencent.mm.kernel.b.c> cjO = new HashMap();
    private HashMap<Class<? extends com.tencent.mm.kernel.b.a>, Class<? extends com.tencent.mm.kernel.b.a>> cjP = new HashMap();
    protected a cjQ;
    private HashMap<com.tencent.mm.kernel.plugin.a, ArrayList<Object>> cjR = new HashMap();

    public interface a {
        void a(com.tencent.mm.kernel.b.c cVar);

        void b(b bVar);
    }

    public final synchronized void d(Class<? extends b> cls) {
        Assert.assertNotNull(cls);
        if (e(cls)) {
            v.w("MMKernel.CorePlugins", "Plugin %s has been installed.", cls);
        }
        try {
            a((b) cls.newInstance());
        } catch (Throwable e) {
            v.a("MMKernel.CorePlugins", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.a("MMKernel.CorePlugins", e, "Install plugin %s failed.", cls);
        } catch (Throwable e2) {
            v.a("MMKernel.CorePlugins", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            v.a("MMKernel.CorePlugins", e2, "Install plugin %s failed.", cls);
        }
    }

    private synchronized void a(b bVar) {
        boolean z = false;
        synchronized (this) {
            if (e(bVar.getClass())) {
                v.w("MMKernel.CorePlugins", "Plugin %s has been installed.", bVar.getClass());
            }
            Assert.assertNotNull(bVar);
            String[] ofProcesses = bVar.ofProcesses();
            if (ofProcesses != null && ofProcesses.length > 0) {
                g.vx();
                ProcessProfile uZ = g.vt().uZ();
                for (String a : ofProcesses) {
                    z = d.a(uZ, a);
                    if (z) {
                        break;
                    }
                }
                if (!z) {
                    throw new IllegalStateException(String.format("Plugin %s can't install in process %s. It only support process %s.", new Object[]{bVar, uZ.getProcessName(), be.g(ofProcesses)}));
                }
            }
            this.cjJ.put(bVar.getClass(), bVar);
            this.cjK.add(bVar);
            bVar.installed();
            if (this.cjQ != null) {
                this.cjQ.b(bVar);
            }
        }
    }

    private synchronized boolean e(Class<? extends com.tencent.mm.kernel.plugin.a> cls) {
        return this.cjJ.containsKey(cls);
    }

    public final synchronized void a(Class<? extends b> cls, Class<? extends com.tencent.mm.kernel.plugin.a> cls2) {
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        b bVar = (b) this.cjJ.get(cls);
        Assert.assertNotNull(bVar);
        ArrayList arrayList = (ArrayList) this.cjL.get(cls);
        if (arrayList == null) {
            arrayList = new ArrayList();
            this.cjL.put(cls, arrayList);
        }
        this.cjM.put(cls2, cls);
        arrayList.add(cls2);
        this.cjJ.put(cls2, bVar);
    }

    public final <T extends com.tencent.mm.kernel.b.b> T f(Class<T> cls) {
        com.tencent.mm.kernel.b.b bVar;
        if (com.tencent.mm.kernel.b.c.class.isAssignableFrom(cls)) {
            synchronized (this.cjO) {
                bVar = (com.tencent.mm.kernel.b.b) this.cjO.get(cls);
            }
            return bVar;
        }
        if (com.tencent.mm.kernel.b.a.class.isAssignableFrom(cls)) {
            try {
                synchronized (this.cjP) {
                    Class cls2 = (Class) this.cjP.get(cls);
                    if (cls2 == null) {
                        return null;
                    }
                    bVar = (com.tencent.mm.kernel.b.b) cls2.newInstance();
                    return bVar;
                }
            } catch (Throwable e) {
                v.a("MMKernel.CorePlugins", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.a("MMKernel.CorePlugins", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            } catch (Throwable e2) {
                v.a("MMKernel.CorePlugins", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                v.a("MMKernel.CorePlugins", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
            }
        }
        return null;
    }

    public final void a(Class<? extends com.tencent.mm.kernel.b.c> cls, com.tencent.mm.kernel.b.c cVar) {
        synchronized (this.cjO) {
            this.cjO.put(cls, cVar);
        }
        if (this.cjQ != null) {
            this.cjQ.a(cVar);
        }
    }

    public final synchronized <T extends com.tencent.mm.kernel.plugin.a> T g(Class<T> cls) {
        Assert.assertNotNull(cls);
        return (com.tencent.mm.kernel.plugin.a) this.cjJ.get(cls);
    }

    private synchronized void h(Class<? extends com.tencent.mm.kernel.plugin.a> cls) {
        Assert.assertNotNull(cls);
        if (!e(cls)) {
            throw new IllegalAccessError("Plugin " + cls + " must be installed!");
        }
    }

    public final void b(Class<? extends b> cls, Class<? extends com.tencent.mm.kernel.plugin.a> cls2) {
        Object obj;
        Assert.assertNotNull(cls);
        Assert.assertNotNull(cls2);
        h(cls2);
        if (this.cjM.containsKey(cls2)) {
            obj = (Class) this.cjM.get(cls2);
        } else {
            Class<? extends com.tencent.mm.kernel.plugin.a> cls3 = cls2;
        }
        this.cjN.n(cls, obj);
        g.vx();
        g.vt().uZ().boot().a(g(cls), g(cls2));
    }

    public final synchronized void a(ProcessProfile processProfile) {
        com.tencent.mm.kernel.a.b.a("configure chain ... %s", this.cjN.vq());
        ArrayList vp = this.cjN.vp();
        if (vp.size() > 0) {
            throw new RuntimeException("Found cycle dependencies between plugins : " + vp);
        }
        com.tencent.mm.kernel.a.b.a("configure check plugin cycle dependency ok...", new Object[0]);
        Iterator it = r0.iterator();
        while (it.hasNext()) {
            b bVar = (b) g((Class) it.next());
            com.tencent.mm.kernel.a.b.a("configuring plugin [%s]...", bVar);
            bVar.invokeConfigure(processProfile);
            if (this.cjR.containsKey(bVar)) {
                Iterator it2 = ((ArrayList) this.cjR.get(bVar)).iterator();
                while (it2.hasNext()) {
                    it2.next();
                }
            }
        }
    }

    public final synchronized void uY() {
        Iterator it = this.cjK.iterator();
        while (it.hasNext()) {
            com.tencent.mm.kernel.a.b.a("make dependency for plugin %s...", (b) it.next());
            r0.invokeDependency();
        }
    }
}
