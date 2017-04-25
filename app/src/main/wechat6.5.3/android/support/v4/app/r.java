package android.support.v4.app;

import android.os.Bundle;
import android.support.v4.content.c;
import android.support.v4.content.c.b;
import android.support.v4.e.j;
import com.tencent.mmdb.FileUtils;
import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.lang.reflect.Modifier;

public final class r extends q {
    public static boolean DEBUG = false;
    final String oI;
    j oU;
    boolean pd;
    final j<a> rk = new j();
    final j<a> rl = new j();
    boolean rm;
    boolean rn;

    final class a implements android.support.v4.content.c.a<Object>, b<Object> {
        final int dW;
        Object mData;
        boolean pd;
        boolean ql;
        boolean rm;
        final Bundle ro;
        android.support.v4.app.q.a<Object> rp;
        c<Object> rq;
        boolean rr;
        boolean rs;
        boolean rt;
        boolean ru;
        boolean rv;
        a rw;
        final /* synthetic */ r rx;

        public a(r rVar, int i, Bundle bundle, android.support.v4.app.q.a<Object> aVar) {
            this.rx = rVar;
            this.dW = i;
            this.ro = bundle;
            this.rp = aVar;
        }

        final void start() {
            if (this.pd && this.rt) {
                this.rm = true;
            } else if (!this.rm) {
                this.rm = true;
                if (r.DEBUG) {
                    new StringBuilder("  Starting: ").append(this);
                }
                if (this.rq == null && this.rp != null) {
                    this.rq = this.rp.K(this.dW);
                }
                if (this.rq == null) {
                    return;
                }
                if (!this.rq.getClass().isMemberClass() || Modifier.isStatic(this.rq.getClass().getModifiers())) {
                    c cVar;
                    if (!this.rv) {
                        cVar = this.rq;
                        int i = this.dW;
                        if (cVar.tj != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.tj = this;
                        cVar.dW = i;
                        cVar = this.rq;
                        if (cVar.tk != null) {
                            throw new IllegalStateException("There is already a listener registered");
                        }
                        cVar.tk = this;
                        this.rv = true;
                    }
                    cVar = this.rq;
                    cVar.rm = true;
                    cVar.tm = false;
                    cVar.tl = false;
                    cVar.onStartLoading();
                    return;
                }
                throw new IllegalArgumentException("Object returned from onCreateLoader must not be a non-static inner member class: " + this.rq);
            }
        }

        final void stop() {
            if (r.DEBUG) {
                new StringBuilder("  Stopping: ").append(this);
            }
            this.rm = false;
            if (!this.pd && this.rq != null && this.rv) {
                this.rv = false;
                this.rq.a((b) this);
                this.rq.a((android.support.v4.content.c.a) this);
                c cVar = this.rq;
                cVar.rm = false;
                cVar.onStopLoading();
            }
        }

        final void destroy() {
            while (true) {
                android.support.v4.content.c.a aVar;
                if (r.DEBUG) {
                    new StringBuilder("  Destroying: ").append(aVar);
                }
                aVar.ql = true;
                boolean z = aVar.rs;
                aVar.rs = false;
                if (aVar.rp != null && aVar.rq != null && aVar.rr && z) {
                    String str;
                    if (r.DEBUG) {
                        new StringBuilder("  Reseting: ").append(aVar);
                    }
                    if (aVar.rx.oU != null) {
                        str = aVar.rx.oU.oT.qm;
                        aVar.rx.oU.oT.qm = "onLoaderReset";
                    } else {
                        str = null;
                    }
                    if (aVar.rx.oU != null) {
                        aVar.rx.oU.oT.qm = str;
                    }
                }
                aVar.rp = null;
                aVar.mData = null;
                aVar.rr = false;
                if (aVar.rq != null) {
                    if (aVar.rv) {
                        aVar.rv = false;
                        aVar.rq.a((b) aVar);
                        aVar.rq.a(aVar);
                    }
                    c cVar = aVar.rq;
                    cVar.onReset();
                    cVar.tm = true;
                    cVar.rm = false;
                    cVar.tl = false;
                    cVar.tn = false;
                    cVar.to = false;
                }
                if (aVar.rw != null) {
                    aVar = aVar.rw;
                } else {
                    return;
                }
            }
        }

        public final void b(c<Object> cVar, Object obj) {
            if (r.DEBUG) {
                new StringBuilder("onLoadComplete: ").append(this);
            }
            if (!this.ql && this.rx.rk.get(this.dW) == this) {
                a aVar = this.rw;
                if (aVar != null) {
                    if (r.DEBUG) {
                        new StringBuilder("  Switching to pending loader: ").append(aVar);
                    }
                    this.rw = null;
                    this.rx.rk.put(this.dW, null);
                    destroy();
                    this.rx.a(aVar);
                    return;
                }
                if (!(this.mData == obj && this.rr)) {
                    this.mData = obj;
                    this.rr = true;
                    if (this.rm) {
                        c(cVar, obj);
                    }
                }
                aVar = (a) this.rx.rl.get(this.dW);
                if (!(aVar == null || aVar == this)) {
                    aVar.rs = false;
                    aVar.destroy();
                    this.rx.rl.remove(this.dW);
                }
                if (this.rx.oU != null && !this.rx.bd()) {
                    this.rx.oU.oT.aY();
                }
            }
        }

        final void c(c<Object> cVar, Object obj) {
            String str;
            if (this.rp != null) {
                if (this.rx.oU != null) {
                    String str2 = this.rx.oU.oT.qm;
                    this.rx.oU.oT.qm = "onLoadFinished";
                    str = str2;
                } else {
                    str = null;
                }
                try {
                    if (r.DEBUG) {
                        StringBuilder append = new StringBuilder("  onLoadFinished in ").append(cVar).append(": ");
                        StringBuilder stringBuilder = new StringBuilder(64);
                        android.support.v4.e.c.a(obj, stringBuilder);
                        stringBuilder.append("}");
                        append.append(stringBuilder.toString());
                    }
                    this.rp.a(cVar, obj);
                    this.rs = true;
                } finally {
                    if (this.rx.oU != null) {
                        this.rx.oU.oT.qm = str;
                    }
                }
            }
        }

        public final String toString() {
            StringBuilder stringBuilder = new StringBuilder(64);
            stringBuilder.append("LoaderInfo{");
            stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
            stringBuilder.append(" #");
            stringBuilder.append(this.dW);
            stringBuilder.append(" : ");
            android.support.v4.e.c.a(this.rq, stringBuilder);
            stringBuilder.append("}}");
            return stringBuilder.toString();
        }

        public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            while (true) {
                printWriter.print(str);
                printWriter.print("mId=");
                printWriter.print(this.dW);
                printWriter.print(" mArgs=");
                printWriter.println(this.ro);
                printWriter.print(str);
                printWriter.print("mCallbacks=");
                printWriter.println(this.rp);
                printWriter.print(str);
                printWriter.print("mLoader=");
                printWriter.println(this.rq);
                if (this.rq != null) {
                    this.rq.dump(str + "  ", fileDescriptor, printWriter, strArr);
                }
                if (this.rr || this.rs) {
                    printWriter.print(str);
                    printWriter.print("mHaveData=");
                    printWriter.print(this.rr);
                    printWriter.print("  mDeliveredData=");
                    printWriter.println(this.rs);
                    printWriter.print(str);
                    printWriter.print("mData=");
                    printWriter.println(this.mData);
                }
                printWriter.print(str);
                printWriter.print("mStarted=");
                printWriter.print(this.rm);
                printWriter.print(" mReportNextStart=");
                printWriter.print(this.ru);
                printWriter.print(" mDestroyed=");
                printWriter.println(this.ql);
                printWriter.print(str);
                printWriter.print("mRetaining=");
                printWriter.print(this.pd);
                printWriter.print(" mRetainingStarted=");
                printWriter.print(this.rt);
                printWriter.print(" mListenerRegistered=");
                printWriter.println(this.rv);
                if (this.rw != null) {
                    printWriter.print(str);
                    printWriter.println("Pending Loader ");
                    printWriter.print(this.rw);
                    printWriter.println(":");
                    this = this.rw;
                    str = str + "  ";
                } else {
                    return;
                }
            }
        }
    }

    r(String str, j jVar, boolean z) {
        this.oI = str;
        this.oU = jVar;
        this.rm = z;
    }

    private a a(int i, Bundle bundle, android.support.v4.app.q.a<Object> aVar) {
        a aVar2 = new a(this, i, bundle, aVar);
        aVar2.rq = aVar.K(i);
        return aVar2;
    }

    private a b(int i, Bundle bundle, android.support.v4.app.q.a<Object> aVar) {
        try {
            this.rn = true;
            a a = a(i, null, aVar);
            a(a);
            return a;
        } finally {
            this.rn = false;
        }
    }

    final void a(a aVar) {
        this.rk.put(aVar.dW, aVar);
        if (this.rm) {
            aVar.start();
        }
    }

    public final <D> c<D> a(int i, android.support.v4.app.q.a<D> aVar) {
        if (this.rn) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.rk.get(i);
        if (DEBUG) {
            new StringBuilder("initLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 == null) {
            aVar2 = b(i, null, aVar);
            if (DEBUG) {
                new StringBuilder("  Created new loader ").append(aVar2);
            }
        } else {
            if (DEBUG) {
                new StringBuilder("  Re-using existing loader ").append(aVar2);
            }
            aVar2.rp = aVar;
        }
        if (aVar2.rr && this.rm) {
            aVar2.c(aVar2.rq, aVar2.mData);
        }
        return aVar2.rq;
    }

    public final <D> c<D> b(int i, android.support.v4.app.q.a<D> aVar) {
        if (this.rn) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar2 = (a) this.rk.get(i);
        if (DEBUG) {
            new StringBuilder("restartLoader in ").append(this).append(": args=").append(null);
        }
        if (aVar2 != null) {
            a aVar3 = (a) this.rl.get(i);
            if (aVar3 != null) {
                if (aVar2.rr) {
                    if (DEBUG) {
                        new StringBuilder("  Removing last inactive loader: ").append(aVar2);
                    }
                    aVar3.rs = false;
                    aVar3.destroy();
                } else if (aVar2.rm) {
                    if (DEBUG) {
                        new StringBuilder("  Canceling: ").append(aVar2);
                    }
                    if (aVar2.rm && aVar2.rq != null && aVar2.rv) {
                        if (DEBUG) {
                            new StringBuilder("onLoadCanceled: ").append(aVar2);
                        }
                        if (!aVar2.ql && aVar2.rx.rk.get(aVar2.dW) == aVar2) {
                            aVar3 = aVar2.rw;
                            if (aVar3 != null) {
                                if (DEBUG) {
                                    new StringBuilder("  Switching to pending loader: ").append(aVar3);
                                }
                                aVar2.rw = null;
                                aVar2.rx.rk.put(aVar2.dW, null);
                                aVar2.destroy();
                                aVar2.rx.a(aVar3);
                            }
                        }
                    }
                    if (aVar2.rw != null) {
                        if (DEBUG) {
                            new StringBuilder("  Removing pending loader: ").append(aVar2.rw);
                        }
                        aVar2.rw.destroy();
                        aVar2.rw = null;
                    }
                    aVar2.rw = a(i, null, aVar);
                    return aVar2.rw.rq;
                } else {
                    this.rk.put(i, null);
                    aVar2.destroy();
                }
            } else if (DEBUG) {
                new StringBuilder("  Making last loader inactive: ").append(aVar2);
            }
            aVar2.rq.tl = true;
            this.rl.put(i, aVar2);
        }
        return b(i, null, aVar).rq;
    }

    public final void destroyLoader(int i) {
        if (this.rn) {
            throw new IllegalStateException("Called while creating a loader");
        }
        if (DEBUG) {
            new StringBuilder("destroyLoader in ").append(this).append(" of ").append(i);
        }
        int indexOfKey = this.rk.indexOfKey(i);
        if (indexOfKey >= 0) {
            a aVar = (a) this.rk.valueAt(indexOfKey);
            this.rk.removeAt(indexOfKey);
            aVar.destroy();
        }
        indexOfKey = this.rl.indexOfKey(i);
        if (indexOfKey >= 0) {
            aVar = (a) this.rl.valueAt(indexOfKey);
            this.rl.removeAt(indexOfKey);
            aVar.destroy();
        }
        if (this.oU != null && !bd()) {
            this.oU.oT.aY();
        }
    }

    public final <D> c<D> J(int i) {
        if (this.rn) {
            throw new IllegalStateException("Called while creating a loader");
        }
        a aVar = (a) this.rk.get(i);
        if (aVar == null) {
            return null;
        }
        if (aVar.rw != null) {
            return aVar.rw.rq;
        }
        return aVar.rq;
    }

    final void be() {
        if (DEBUG) {
            new StringBuilder("Starting in ").append(this);
        }
        if (this.rm) {
            new RuntimeException("here").fillInStackTrace();
            new StringBuilder("Called doStart when already started: ").append(this);
            return;
        }
        this.rm = true;
        for (int size = this.rk.size() - 1; size >= 0; size--) {
            ((a) this.rk.valueAt(size)).start();
        }
    }

    final void bf() {
        if (DEBUG) {
            new StringBuilder("Stopping in ").append(this);
        }
        if (this.rm) {
            for (int size = this.rk.size() - 1; size >= 0; size--) {
                ((a) this.rk.valueAt(size)).stop();
            }
            this.rm = false;
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doStop when not started: ").append(this);
    }

    final void bg() {
        if (DEBUG) {
            new StringBuilder("Retaining in ").append(this);
        }
        if (this.rm) {
            this.pd = true;
            this.rm = false;
            for (int size = this.rk.size() - 1; size >= 0; size--) {
                a aVar = (a) this.rk.valueAt(size);
                if (DEBUG) {
                    new StringBuilder("  Retaining: ").append(aVar);
                }
                aVar.pd = true;
                aVar.rt = aVar.rm;
                aVar.rm = false;
                aVar.rp = null;
            }
            return;
        }
        new RuntimeException("here").fillInStackTrace();
        new StringBuilder("Called doRetain when not started: ").append(this);
    }

    final void bh() {
        for (int size = this.rk.size() - 1; size >= 0; size--) {
            ((a) this.rk.valueAt(size)).ru = true;
        }
    }

    final void bi() {
        for (int size = this.rk.size() - 1; size >= 0; size--) {
            a aVar = (a) this.rk.valueAt(size);
            if (aVar.rm && aVar.ru) {
                aVar.ru = false;
                if (aVar.rr) {
                    aVar.c(aVar.rq, aVar.mData);
                }
            }
        }
    }

    final void bj() {
        int size;
        if (!this.pd) {
            if (DEBUG) {
                new StringBuilder("Destroying Active in ").append(this);
            }
            for (size = this.rk.size() - 1; size >= 0; size--) {
                ((a) this.rk.valueAt(size)).destroy();
            }
            this.rk.clear();
        }
        if (DEBUG) {
            new StringBuilder("Destroying Inactive in ").append(this);
        }
        for (size = this.rl.size() - 1; size >= 0; size--) {
            ((a) this.rl.valueAt(size)).destroy();
        }
        this.rl.clear();
    }

    public final String toString() {
        StringBuilder stringBuilder = new StringBuilder(FileUtils.S_IWUSR);
        stringBuilder.append("LoaderManager{");
        stringBuilder.append(Integer.toHexString(System.identityHashCode(this)));
        stringBuilder.append(" in ");
        android.support.v4.e.c.a(this.oU, stringBuilder);
        stringBuilder.append("}}");
        return stringBuilder.toString();
    }

    public final void dump(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        int i = 0;
        if (this.rk.size() > 0) {
            printWriter.print(str);
            printWriter.println("Active Loaders:");
            String str2 = str + "    ";
            for (int i2 = 0; i2 < this.rk.size(); i2++) {
                a aVar = (a) this.rk.valueAt(i2);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.rk.keyAt(i2));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str2, fileDescriptor, printWriter, strArr);
            }
        }
        if (this.rl.size() > 0) {
            printWriter.print(str);
            printWriter.println("Inactive Loaders:");
            String str3 = str + "    ";
            while (i < this.rl.size()) {
                aVar = (a) this.rl.valueAt(i);
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.rl.keyAt(i));
                printWriter.print(": ");
                printWriter.println(aVar.toString());
                aVar.dump(str3, fileDescriptor, printWriter, strArr);
                i++;
            }
        }
    }

    public final boolean bd() {
        int size = this.rk.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            int i2;
            a aVar = (a) this.rk.valueAt(i);
            if (!aVar.rm || aVar.rs) {
                i2 = 0;
            } else {
                i2 = 1;
            }
            z |= i2;
        }
        return z;
    }
}
