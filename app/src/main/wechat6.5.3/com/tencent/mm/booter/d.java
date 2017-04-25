package com.tencent.mm.booter;

import android.content.Context;
import android.content.Intent;
import android.os.Process;
import com.tencent.mm.compatible.d.r;
import com.tencent.mm.pluginsdk.l;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.ad;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.smtt.sdk.QbSdk;

public final class d {

    public static class a implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            v.i("MicroMsg.ExdeviceProcessReceiver", "[hakon][Step] onReceive, save rebootTime = %s", Long.valueOf(System.currentTimeMillis()));
            aa.btm();
            r.i(205, r0);
        }
    }

    public static class b implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                v.i("MicroMsg.SandBoxProcessReceiver", "onReceive");
                QbSdk.reset(context);
                ad.g(new Runnable(this) {
                    final /* synthetic */ b bXN;

                    {
                        this.bXN = r1;
                    }

                    public final void run() {
                        int myPid = Process.myPid();
                        com.tencent.recovery.b.yH(13);
                        Process.killProcess(myPid);
                    }
                }, 5000);
            }
        }
    }

    public static class c implements com.tencent.mm.booter.MMReceivers.a {
        public final void onReceive(Context context, Intent intent) {
            if (context != null && intent != null) {
                String stringExtra = intent.getStringExtra("tools_process_action_code_key");
                v.i("MicroMsg.ToolsProcessReceiver", "onReceive, action = " + stringExtra);
                if (stringExtra.equals("com.tencent.mm.intent.ACTION_KILL_TOOLS_PROCESS")) {
                    v.btb();
                    v.i("MicroMsg.ToolsProcessReceiver", "onReceive, ACTION_KILL_TOOLS_PROCESS, x5 kernel video isLocked = %b", Boolean.valueOf(l.isLocked()));
                    if (!l.isLocked()) {
                        int myPid = Process.myPid();
                        com.tencent.recovery.b.yH(13);
                        Process.killProcess(myPid);
                    }
                } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_TOOLS_REMOVE_COOKIE")) {
                    try {
                        QbSdk.clearAllWebViewCache(context.getApplicationContext(), true);
                    } catch (Exception e) {
                        v.i("MicroMsg.ToolsProcessReceiver", "clear cookie faild : " + e.getMessage());
                    }
                } else if (!stringExtra.equals("com.tencent.mm.intent.ACIONT_TOOLS_LOAD_DEX")) {
                    if (stringExtra.equals("com.tencent.mm.intent.ACTION_CLEAR_WEBVIEW_CACHE")) {
                        v.i("MicroMsg.ToolsProcessReceiver", "WebViewCacheClearTask, clearAllWebViewCache, includeCookie = %b", Boolean.valueOf(intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)));
                        if (intent.getBooleanExtra("tools_clean_webview_cache_ignore_cookie", true)) {
                            QbSdk.clearAllWebViewCache(context.getApplicationContext(), true);
                        } else {
                            QbSdk.clearAllWebViewCache(context.getApplicationContext(), false);
                        }
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS")) {
                        v.i("MicroMsg.ToolsProcessReceiver", "start tools process task, try to pre load tbs");
                        com.tencent.mm.pluginsdk.model.v.bmY();
                        com.tencent.mm.pluginsdk.model.v.a.bna();
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_LOCK_TOOLS_PROCESS")) {
                        l.lock();
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_UNLOCK_TOOLS_PROCESS")) {
                        l.unlock();
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_START_TOOLS_PROCESS_DO_NOTHING")) {
                        v.i("MicroMsg.ToolsProcessReceiver", "start tools process and do nothing");
                    } else if (stringExtra.equals("com.tencent.mm.intent.ACTION_CHECK_MINIQB_CAN_OPEN_FILE")) {
                        com.tencent.mm.pluginsdk.model.v.P(intent);
                    }
                }
            }
        }
    }
}
