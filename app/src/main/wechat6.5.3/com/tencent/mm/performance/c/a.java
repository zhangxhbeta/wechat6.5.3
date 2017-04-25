package com.tencent.mm.performance.c;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import com.tencent.mm.performance.d.b;
import com.tencent.mm.performance.d.d;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.i.e;
import com.tencent.mm.sdk.platformtools.v;
import java.io.File;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public final class a {
    private static a dnE = new a();

    private static class a extends BroadcastReceiver {
        private a() {
        }

        public final void onReceive(Context context, Intent intent) {
            v.i("MicroMsg.HARespReceiver", "received cmd: %s", intent.getAction());
            if ("ha_resp_action_send_result".equals(intent.getAction())) {
                final String string = intent.getExtras().getString("ha_hprof_filepath");
                String string2 = intent.getExtras().getString("ha_obj_class");
                String string3 = intent.getExtras().getString("ha_obj_key");
                String string4 = intent.getExtras().getString("ha_refchain_str");
                if (string4 == null || string4.length() == 0) {
                    v.e("MicroMsg.HARespReceiver", "object '%s' with key '%s' is not leaked, sometimes his method may hit this wrong case.", string2, string3);
                } else {
                    v.i("MicroMsg.HARespReceiver", "analyse result: key:%s, class:%s, ref:%s", string3, string2, string4);
                    Map hashMap = new HashMap();
                    hashMap.put("reference_chain", string4);
                    g.iuh.c("UILeaks", string2, hashMap);
                }
                e.a(new Runnable(this) {
                    final /* synthetic */ a dnG;

                    public final void run() {
                        new File(string).delete();
                    }
                }, "del_hprof_file");
                return;
            }
            v.e("MicroMsg.HARespReceiver", "unknown command: %s", string);
        }
    }

    public static void h(Context context, String str, String str2) {
        Intent intent = new Intent();
        intent.putExtra("ha_hprof_filepath", str);
        intent.putExtra("ha_obj_key", str2);
        intent.putExtra("ha_weakref_with_key_class", d.class.getName());
        String str3 = "mKey";
        for (Field field : d.class.getDeclaredFields()) {
            if (field.getAnnotation(b.class) != null) {
                str3 = field.getName();
            }
        }
        v.i("MicroMsg.HprofAnalyzerComm", "weakRef key field name: %s", str3);
        intent.putExtra("ha_weakref_key_attr_name", str3);
        intent.setClassName("com.tencent.mm.coolassist", "com.tencent.mm.coolassist.hprofanalyzer.BroadcastCmdReceiver");
        intent.setAction("ha_action_analyze_hprof");
        try {
            context.sendBroadcast(intent, "com.tencent.mm.debug.RECV_CMD");
        } catch (Throwable e) {
            v.a("MicroMsg.HprofAnalyzerComm", e, "Failed to wake up hprof analyzer app.", new Object[0]);
        }
    }

    public static void bh(Context context) {
        v.i("MicroMsg.HprofAnalyzerComm", "register receiver is called.");
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("ha_resp_action_send_result");
        context.registerReceiver(dnE, intentFilter, "com.tencent.mm.debug.RECV_CMD", null);
    }

    public static boolean isEnabled() {
        return com.tencent.mm.sdk.b.b.bsG();
    }
}
