package com.tencent.mm.wallet_core;

import android.app.Activity;
import android.os.Bundle;
import android.util.SparseArray;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mm.ui.base.s;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static Map<String, Class<?>> pil = new HashMap();
    private static SparseArray<b> pim = new SparseArray();

    public static void b(String str, Class<?> cls) {
        if (pil.containsKey(str)) {
            throw new IllegalArgumentException("register process fail, exist process=" + str);
        }
        pil.put(str, cls);
    }

    private static String Y(Bundle bundle) {
        return bundle == null ? "" : bundle.toString();
    }

    public static void remove(int i) {
        pim.remove(i);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle) {
        a(activity, (Class) cls, bundle, null);
    }

    public static void a(Activity activity, Class<?> cls, Bundle bundle, com.tencent.mm.wallet_core.b.a aVar) {
        v.i("MicroMsg.ProcessManager", "startProcess to1 context:%s proc name: %s bundle %s", new Object[]{activity, cls.getSimpleName(), Y(bundle)});
        if (bundle == null) {
            try {
                bundle = new Bundle();
            } catch (Throwable e) {
                v.a("MicroMsg.ProcessManager", e, "", new Object[0]);
                return;
            }
        }
        if (bundle.getLong("key_SessionId", 0) == 0) {
            bundle.putLong("key_SessionId", System.currentTimeMillis());
        }
        b bVar = (b) cls.newInstance();
        bVar.Z(bundle);
        bVar.a(aVar);
        bVar.c(activity, bundle);
        pim.put(cls.hashCode(), bVar);
    }

    public static void b(Activity activity, String str, Bundle bundle) {
        a(activity, str, bundle, null);
    }

    public static void a(Activity activity, String str, Bundle bundle, com.tencent.mm.wallet_core.b.a aVar) {
        try {
            v.i("MicroMsg.ProcessManager", "startProcess to2 context:%s proc name: %s bundle %s", new Object[]{activity, str, Y(bundle)});
            Class cls = (Class) pil.get(str);
            if (cls == null) {
                CharSequence format = String.format("start process=%s fail, process not register or plugin no import", new Object[]{str});
                v.e("MicroMsg.ProcessManager", format);
                s.makeText(activity, format, 1).show();
                return;
            }
            a(activity, cls, bundle, aVar);
        } catch (Throwable e) {
            v.e("MicroMsg.ProcessManager", "plugin load failed : " + e.toString());
            v.a("MicroMsg.ProcessManager", e, "", new Object[0]);
        }
    }

    public static void k(Activity activity, Bundle bundle) {
        b ae = ae(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "forwardProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Y(bundle);
        objArr[2] = ae == null ? "" : ae.anS();
        v.i(str, str2, objArr);
        if (ae != null) {
            ae.a(activity, 0, bundle);
        }
    }

    public static void ab(Activity activity) {
        b ae = ae(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s procname %s";
        Object[] objArr = new Object[2];
        objArr[0] = activity;
        objArr[1] = ae == null ? "" : ae.anS();
        v.i(str, str2, objArr);
        if (ae != null) {
            ae.d(activity, 0);
        }
    }

    public static void i(Activity activity, int i) {
        if (activity == null) {
            v.w("MicroMsg.ProcessManager", "hy: back context is null");
        }
        b ae = ae(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "backProcess to1 context: %s errCode %s procname %s ";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Integer.valueOf(i);
        objArr[2] = ae == null ? "" : ae.anS();
        v.i(str, str2, objArr);
        if (ae != null) {
            ae.d(activity, i);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static void b(Activity activity, Bundle bundle, int i) {
        v.i("MicroMsg.ProcessManager", "endProcess with errCode : " + i);
        if (activity == null) {
            v.w("MicroMsg.ProcessManager", "hy: end context is null");
        }
        b ae = ae(activity);
        String str = "MicroMsg.ProcessManager";
        String str2 = "endProcess to1 context: %s bundle: %s procName %s";
        Object[] objArr = new Object[3];
        objArr[0] = activity;
        objArr[1] = Y(bundle);
        objArr[2] = ae == null ? "" : ae.anS();
        v.i(str, str2, objArr);
        if (ae != null) {
            ae.d(activity, bundle);
        } else if (!activity.isFinishing()) {
            activity.finish();
        }
    }

    public static boolean ac(Activity activity) {
        return ae(activity) != null;
    }

    public static Bundle ad(Activity activity) {
        b ae = ae(activity);
        if (ae != null) {
            return ae.fNM;
        }
        return new Bundle();
    }

    public static boolean l(Activity activity, Bundle bundle) {
        b ae = ae(activity);
        if (ae == null) {
            return false;
        }
        ae.Z(bundle);
        return true;
    }

    public static b ae(Activity activity) {
        if (activity == null) {
            v.w("MicroMsg.ProcessManager", "hy: ac is null");
            return null;
        } else if (activity.getIntent() != null) {
            return (b) pim.get(activity.getIntent().getIntExtra("process_id", 0));
        } else {
            v.w("MicroMsg.ProcessManager", "hy: get intent is null");
            return null;
        }
    }
}
