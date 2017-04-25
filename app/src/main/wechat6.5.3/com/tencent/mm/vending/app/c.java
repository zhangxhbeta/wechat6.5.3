package com.tencent.mm.vending.app;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Looper;
import com.tencent.mm.vending.e.b;
import com.tencent.mm.vending.f.a;
import junit.framework.Assert;

public final class c implements b {
    private com.tencent.mm.vending.e.c pfZ = new com.tencent.mm.vending.e.c();
    private b pgr = b.bKz();
    private a pgs;
    private com.tencent.mm.vending.c.b<? extends a> pgt;
    private int pgu = 0;

    private synchronized <T extends com.tencent.mm.vending.c.b<? extends a>> T w(Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        T t;
        if (this.pgt == null) {
            try {
                this.pgt = (com.tencent.mm.vending.c.b) cls.newInstance();
                if (this.pgs == null) {
                    this.pgs = (a) this.pgt.Nr();
                }
                bKA();
                t = this.pgt;
            } catch (IllegalAccessException e) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            } catch (InstantiationException e2) {
                throw new InternalError("Could not create interactor api instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.pgt)) {
            t = this.pgt;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    public final synchronized <T extends a> T x(Class<? extends a> cls) {
        T t;
        if (this.pgt != null) {
            t = (a) this.pgt.Nr();
        } else if (this.pgs == null) {
            try {
                this.pgs = (a) cls.newInstance();
                bKA();
                t = this.pgs;
            } catch (InstantiationException e) {
                throw new InternalError("Could not create interactor instance : " + cls.toString());
            } catch (IllegalAccessException e2) {
                throw new InternalError("Could not create interactor instance : " + cls.toString());
            }
        } else if (cls.isInstance(this.pgs)) {
            t = this.pgs;
        } else {
            throw new IllegalAccessError("Only one interactor pair with one presenter! duplicate pairWith : " + cls.toString());
        }
        return t;
    }

    private void bKA() {
        if (this.pgr != null) {
            b bVar = this.pgr;
            a aVar = this.pgs;
            if (bVar.pgn.containsKey(this)) {
                a.e("Vending.InteractorManager", "duplicate activity and interactor.", new Object[0]);
                return;
            }
            bVar.pgn.put(this, aVar);
            a.i("Vending.InteractorManager", "presenter %s hash %s interactor %s looper %s", new Object[]{this, Integer.valueOf(hashCode()), aVar, Looper.myLooper()});
            int i = bVar.pgo.get(hashCode(), 0);
            if (i > 0 && i < 4) {
                if (i > 0) {
                    bVar.pgp.sendMessage(bVar.pgp.obtainMessage(1, aVar));
                }
                if (i >= 2) {
                    bVar.pgp.sendMessage(bVar.pgp.obtainMessage(2, aVar));
                }
                if (i >= 3) {
                    bVar.pgp.sendMessage(bVar.pgp.obtainMessage(3, aVar));
                }
                if (i >= 4) {
                    bVar.pgp.sendMessage(bVar.pgp.obtainMessage(4, aVar));
                }
            }
        }
    }

    private synchronized void A(Intent intent, Context context) {
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.pgs);
        this.pgs.mContext = context;
        this.pgs.pgh = new com.tencent.mm.vending.d.a(intent);
    }

    public final synchronized a vF() {
        if (this.pgs == null && this.pgr != null) {
            this.pgs = (a) this.pgr.pgn.get(this);
        }
        Assert.assertNotNull("You must pair this presenter with a interactor!", this.pgs);
        return this.pgs;
    }

    public final <T extends com.tencent.mm.vending.c.b<? extends a>> T a(Activity activity, Class<? extends com.tencent.mm.vending.c.b<? extends a>> cls) {
        if (!activity.isFinishing() && (VERSION.SDK_INT < 17 || !activity.isDestroyed())) {
            return w(cls);
        }
        a.e("Vending.Presenter", "Activity %s is finished! This is invalid!", new Object[]{activity});
        return null;
    }

    public final void yw(int i) {
        this.pgu = i;
        b bVar = this.pgr;
        a aVar = (a) bVar.pgn.get(this);
        if (aVar != null) {
            switch (i) {
                case 1:
                    a.i("Vending.InteractorManager", "onCreate interactor %s presenter %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    break;
                case 2:
                case 3:
                    break;
                case 4:
                    a.i("Vending.InteractorManager", "onDestroy interactor %s activity %s %s %s", new Object[]{aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    bVar.pgn.remove(this);
                    break;
                default:
                    a.i("Vending.InteractorManager", "Unknow phase %s, interactor %s activity %s %s %s", new Object[]{Integer.valueOf(i), aVar, this, Integer.valueOf(hashCode()), Looper.myLooper()});
                    return;
            }
            bVar.pgp.sendMessage(bVar.pgp.obtainMessage(i, aVar));
        }
        bVar.pgo.put(hashCode(), i);
    }

    public final void B(Intent intent, Context context) {
        A(intent, context);
        yw(1);
    }

    public final void a(com.tencent.mm.vending.e.a aVar) {
        Assert.assertTrue("target must be a ILifeCycle", aVar instanceof com.tencent.mm.vending.e.a);
        this.pfZ.a(aVar);
    }

    public final void onDestroy() {
        this.pfZ.dead();
        yw(4);
    }
}
