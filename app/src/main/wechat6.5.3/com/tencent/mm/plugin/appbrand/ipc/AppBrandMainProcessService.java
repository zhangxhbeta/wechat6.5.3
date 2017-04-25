package com.tencent.mm.plugin.appbrand.ipc;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.os.Parcel;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class AppBrandMainProcessService extends Service {
    private static c dEf;
    private static ServiceConnection dEg;
    private static Map<String, WeakReference<MainProcessTask>> dEj = new ConcurrentHashMap();
    private static Handler dEk = new Handler() {
        public final void handleMessage(Message message) {
            MainProcessTask b = AppBrandMainProcessService.a(message.getData(), false);
            MainProcessTask Rf = AppBrandMainProcessService.Rf(b.lpS);
            if (Rf == null) {
                v.e("MicroMsg.AppBrandMainProcessService", "receive client msg, get null task by id %s", new Object[]{b.lpS});
                return;
            }
            AppBrandMainProcessService.a(b, Rf);
            Rf.OM();
        }
    };
    private static Messenger dEl = new Messenger(dEk);
    private static final LinkedList<Parcel> dWI = new LinkedList();
    private static Set<a> hvQ = new HashSet();
    private final Messenger dEd = new Messenger(this.mHandler);
    private final com.tencent.mm.plugin.appbrand.ipc.c.a dEe = new com.tencent.mm.plugin.appbrand.ipc.c.a(this) {
        final /* synthetic */ AppBrandMainProcessService dEm;

        {
            this.dEm = r1;
        }

        public final void p(Bundle bundle) {
            Message obtain = Message.obtain();
            obtain.setData(bundle);
            this.dEm.dEd.send(obtain);
        }

        public final void q(Bundle bundle) {
            AppBrandMainProcessService.a(bundle, false).OL();
        }
    };
    private final Handler mHandler = new Handler(this, com.tencent.mm.plugin.appbrand.k.a.vA().htb.getLooper()) {
        final /* synthetic */ AppBrandMainProcessService dEm;

        public final void handleMessage(Message message) {
            AppBrandMainProcessService.a(message.getData(), true).OL();
        }
    };

    public static class a {
        public void onServiceConnected() {
        }

        public void Rh() {
        }
    }

    static /* synthetic */ void Iq() {
        for (a onServiceConnected : hvQ) {
            onServiceConnected.onServiceConnected();
        }
    }

    static /* synthetic */ void PI() {
        if (dEf != null) {
            synchronized (dWI) {
                Iterator it = dWI.iterator();
                while (it.hasNext()) {
                    Parcel parcel = (Parcel) it.next();
                    Bundle bundle = new Bundle();
                    bundle.setClassLoader(MainProcessTask.class.getClassLoader());
                    parcel.setDataPosition(0);
                    bundle.readFromParcel(parcel);
                    o(bundle);
                    parcel.recycle();
                }
                dWI.clear();
            }
        }
    }

    static /* synthetic */ void QA() {
        for (a Rh : hvQ) {
            Rh.Rh();
        }
    }

    static /* synthetic */ MainProcessTask Rf(String str) {
        if (dEj.containsKey(str)) {
            return ((WeakReference) dEj.get(str)).get() == null ? null : (MainProcessTask) ((WeakReference) dEj.get(str)).get();
        } else {
            return null;
        }
    }

    public IBinder onBind(Intent intent) {
        return this.dEe;
    }

    public static void a(MainProcessTask mainProcessTask) {
        dEj.put(mainProcessTask.lpS, new WeakReference(mainProcessTask));
        o(a(mainProcessTask, true));
    }

    public static boolean b(MainProcessTask mainProcessTask) {
        Bundle a = a(mainProcessTask, false);
        if (!n(a)) {
            return false;
        }
        a(a(a, false), mainProcessTask);
        mainProcessTask.OM();
        return true;
    }

    private static boolean n(Bundle bundle) {
        try {
            dEf.q(bundle);
            return true;
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
            return false;
        }
    }

    private static void o(Bundle bundle) {
        if (dEf == null) {
            PH();
            synchronized (dWI) {
                LinkedList linkedList = dWI;
                Parcel obtain = Parcel.obtain();
                bundle.writeToParcel(obtain, 0);
                linkedList.add(obtain);
            }
            return;
        }
        try {
            dEf.p(bundle);
        } catch (Exception e) {
            v.e("MicroMsg.AppBrandMainProcessService", e.getMessage());
        }
    }

    private static void PH() {
        if (dEg == null) {
            dEg = new ServiceConnection() {
                public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                    AppBrandMainProcessService.dEf = com.tencent.mm.plugin.appbrand.ipc.c.a.F(iBinder);
                    AppBrandMainProcessService.PI();
                    AppBrandMainProcessService.Iq();
                    v.i("MicroMsg.AppBrandMainProcessService", "onServiceConnected(%s)", new Object[]{aa.getProcessName()});
                }

                public final void onServiceDisconnected(ComponentName componentName) {
                    AppBrandMainProcessService.dEf = null;
                    AppBrandMainProcessService.QA();
                    AppBrandMainProcessService.PH();
                    v.i("MicroMsg.AppBrandMainProcessService", "onServiceDisconnected(%s)", new Object[]{aa.getProcessName()});
                }
            };
        }
        v.i("MicroMsg.AppBrandMainProcessService", "tryBindService");
        Context context = aa.getContext();
        context.bindService(new Intent(context, AppBrandMainProcessService.class), dEg, 1);
    }

    public static void a(a aVar) {
        hvQ.add(aVar);
    }

    public static void b(a aVar) {
        hvQ.remove(aVar);
    }

    private static void a(MainProcessTask mainProcessTask, MainProcessTask mainProcessTask2) {
        Parcel obtain = Parcel.obtain();
        mainProcessTask.writeToParcel(obtain, 0);
        obtain.setDataPosition(0);
        mainProcessTask2.f(obtain);
        obtain.recycle();
    }

    static Bundle a(MainProcessTask mainProcessTask, boolean z) {
        Bundle bundle = new Bundle(3);
        bundle.putParcelable("task_object", mainProcessTask);
        if (z) {
            bundle.putParcelable("task_client", dEl);
        }
        bundle.putString("task_id", mainProcessTask.lpS);
        return bundle;
    }

    private static MainProcessTask a(Bundle bundle, boolean z) {
        bundle.setClassLoader(MainProcessTask.class.getClassLoader());
        MainProcessTask mainProcessTask = (MainProcessTask) bundle.getParcelable("task_object");
        if (z) {
            mainProcessTask.dEH = (Messenger) bundle.getParcelable("task_client");
        }
        mainProcessTask.lpS = bundle.getString("task_id");
        return mainProcessTask;
    }
}
