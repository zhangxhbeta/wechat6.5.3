package com.tencent.mm.plugin.appbrand.task;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.mm.plugin.appbrand.config.AppBrandInitConfig;
import com.tencent.mm.plugin.appbrand.ipc.MainProcessTask;
import com.tencent.mm.plugin.appbrand.k.a;
import com.tencent.mm.plugin.appbrand.report.AppBrandStatObject;
import com.tencent.mm.plugin.appbrand.ui.AppBrandUI;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONArray;

public final class AppBrandTaskManager {
    private static LinkedList<b> dQr = new LinkedList();

    public static class GetTaskSource extends MainProcessTask {
        public static final Creator<GetTaskSource> CREATOR = new Creator<GetTaskSource>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                GetTaskSource getTaskSource = new GetTaskSource();
                getTaskSource.f(parcel);
                return getTaskSource;
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new GetTaskSource[i];
            }
        };
        public String appId;
        public int bbT;

        public final void OL() {
            this.bbT = AppBrandTaskManager.or(this.appId);
            PP();
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.appId);
            parcel.writeInt(this.bbT);
        }

        public final void f(Parcel parcel) {
            this.appId = parcel.readString();
            this.bbT = parcel.readInt();
        }
    }

    static /* synthetic */ int or(String str) {
        b op = op(str);
        if (op == null) {
            return 0;
        }
        int i = op.dQp;
        op.dQp = 0;
        return i;
    }

    static {
        for (int i = 0; i < 5; i++) {
            dQr.add(new b(i));
        }
        RW();
    }

    public static void a(Context context, AppBrandInitConfig appBrandInitConfig, AppBrandStatObject appBrandStatObject) {
        int i = 0;
        b op = op(appBrandInitConfig.appId);
        if (op == null) {
            for (int i2 = 0; i2 < dQr.size(); i2++) {
                if (((b) dQr.get(i2)).dzg == null) {
                    op = (b) dQr.get(i2);
                    break;
                }
            }
            op = null;
            if (op == null) {
                op = (b) dQr.getFirst();
            }
            a(op);
        }
        op.dzg = appBrandInitConfig.appId;
        op.dQp = appBrandStatObject.scene;
        if (context == null) {
            context = aa.getContext();
        }
        Intent intent = new Intent(context, op.dQn);
        intent.addFlags(268435456);
        intent.putExtra("key_appbrand_init_config", appBrandInitConfig);
        intent.putExtra("key_appbrand_stat_object", appBrandStatObject);
        context.startActivity(intent);
        if (appBrandStatObject != null) {
            i = appBrandStatObject.scene;
        }
        if (i == 1023) {
            a.bt(context);
        } else {
            a.hG(context);
        }
        RV();
    }

    public static void ab(String str, int i) {
        b op = op(str);
        if (op != null && op.dQq != null) {
            AppBrandRemoteTaskController appBrandRemoteTaskController = op.dQq;
            if (appBrandRemoteTaskController.dQc.dzx == i) {
                appBrandRemoteTaskController.RR();
                appBrandRemoteTaskController.lql = b.lqs;
                appBrandRemoteTaskController.PP();
            }
        }
    }

    public static void hb(int i) {
        Iterator it = dQr.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.dQq != null) {
                AppBrandRemoteTaskController appBrandRemoteTaskController = bVar.dQq;
                appBrandRemoteTaskController.lql = b.lqt;
                appBrandRemoteTaskController.lqm = i;
                appBrandRemoteTaskController.PP();
            }
        }
    }

    static void ol(String str) {
        final b on = on(str);
        ad.g(new Runnable() {
            public final void run() {
                b bVar = on;
                Intent intent = new Intent();
                intent.setClass(aa.getContext(), bVar.dQo);
                aa.getContext().sendBroadcast(intent);
            }
        }, 500);
    }

    public static void hn(int i) {
        b bVar;
        Iterator it = dQr.iterator();
        while (it.hasNext()) {
            bVar = (b) it.next();
            if (bVar.dW == i) {
                break;
            }
        }
        bVar = new b(-1);
        if (bVar.dQq != null) {
            AppBrandRemoteTaskController appBrandRemoteTaskController = bVar.dQq;
            appBrandRemoteTaskController.lql = b.lqw;
            appBrandRemoteTaskController.PP();
        }
    }

    static b on(String str) {
        Iterator it = dQr.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.dQm.equals(str)) {
                return bVar;
            }
        }
        return new b(-1);
    }

    public static boolean oo(String str) {
        b op = op(str);
        if (!(op == null || op.dQq == null)) {
            AppBrandRemoteTaskController appBrandRemoteTaskController = op.dQq;
            appBrandRemoteTaskController.lql = b.lqx;
            if (appBrandRemoteTaskController.PP()) {
                return true;
            }
        }
        return false;
    }

    static b op(String str) {
        Iterator it = dQr.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            if (bVar.dzg != null && bVar.dzg.equals(str)) {
                return bVar;
            }
        }
        return null;
    }

    static void oq(String str) {
        b op = op(str);
        if (op != null) {
            op.dzg = null;
            dQr.remove(op);
            dQr.addFirst(op);
        }
    }

    static void a(b bVar) {
        dQr.remove(bVar);
        dQr.addLast(bVar);
    }

    static void RV() {
        SharedPreferences btk = aa.btk();
        if (btk != null) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = dQr.iterator();
            while (it.hasNext()) {
                b bVar = (b) it.next();
                jSONArray.put(new JSONArray(Arrays.asList(new Object[]{Integer.valueOf(bVar.dW), bVar.dzg})));
            }
            btk.edit().putString("app_brand_task_list_state", jSONArray.toString()).apply();
        }
    }

    private static void RW() {
        SharedPreferences btk = aa.btk();
        if (btk != null) {
            JSONArray jSONArray;
            String string = btk.getString("app_brand_task_list_state", "");
            JSONArray jSONArray2 = new JSONArray();
            try {
                jSONArray = new JSONArray(string);
            } catch (Exception e) {
                v.e("MicroMsg.AppBrandTaskManager", e.getMessage());
                jSONArray = jSONArray2;
            }
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONArray optJSONArray = jSONArray.optJSONArray(i);
                if (optJSONArray != null) {
                    int optInt = optJSONArray.optInt(0);
                    string = optJSONArray.isNull(1) ? null : optJSONArray.optString(1);
                    b on = on(AppBrandUI.class.getName() + (optInt == 0 ? "" : Integer.valueOf(optInt)));
                    on.dzg = string;
                    a(on);
                }
            }
        }
    }
}
