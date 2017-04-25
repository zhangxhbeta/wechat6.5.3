package com.tencent.mm.modelstat;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.plugin.report.service.g;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashSet;

public final class d {
    private static d dbF;
    private HashSet<String> dbE = new HashSet();

    static /* synthetic */ void a(d dVar, int i, Activity activity) {
        int hashCode = activity.hashCode();
        String className = activity.getComponentName().getClassName();
        v.v("MicroMsg.ClickFlowStatSender", "callback opCode:%d activity:%s hash:%d ignore:%s %s", Integer.valueOf(i), className, Integer.valueOf(hashCode), Boolean.valueOf(dVar.dbE.contains(className)), be.bur());
        if (!dVar.dbE.contains(className)) {
            a(i, className, hashCode);
        }
    }

    public static void b(Application application) {
        application.registerActivityLifecycleCallbacks(new ActivityLifecycleCallbacks() {
            public final void onActivityCreated(Activity activity, Bundle bundle) {
                d.a(d.JY(), 1, activity);
            }

            public final void onActivityStarted(Activity activity) {
                d.a(d.JY(), 2, activity);
            }

            public final void onActivityResumed(Activity activity) {
                d.a(d.JY(), 3, activity);
            }

            public final void onActivityPaused(Activity activity) {
                d.a(d.JY(), 4, activity);
            }

            public final void onActivityStopped(Activity activity) {
                d.a(d.JY(), 5, activity);
            }

            public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
            }

            public final void onActivityDestroyed(Activity activity) {
                d.a(d.JY(), 6, activity);
            }
        });
    }

    public static void a(int i, String str, int i2) {
        Intent intent = new Intent("com.tencent.mm.Intent.ACTION_CLICK_FLOW_REPORT");
        intent.putExtra("opCode", i);
        intent.putExtra("ui", str);
        intent.putExtra("uiHashCode", i2);
        intent.putExtra("nowMilliSecond", be.Ni());
        Context context = aa.getContext();
        if (context == null) {
            return;
        }
        if (aa.bto()) {
            c.JW().n(intent);
            return;
        }
        v.d("MicroMsg.ClickFlowStatSender", "sendBroadcast, Intent: %s, Extra: %s", intent, intent.getExtras());
        context.sendBroadcast(intent);
    }

    private d() {
        this.dbE.add("com.tencent.mm.ui.LauncherUI");
        this.dbE.add("com.tencent.mm.plugin.profile.ui.ContactInfoUI");
        this.dbE.add("com.tencent.mm.plugin.webview.ui.tools.WebViewUI");
        this.dbE.add("com.tencent.mm.ui.conversation.BizConversationUI");
        this.dbE.add("com.tencent.mm.ui.chatting.ChattingUI");
        this.dbE.add("com.tencent.mm.plugin.label.ui.ContactLabelEditUI");
    }

    public static d JY() {
        if (dbF == null) {
            synchronized (d.class) {
                if (dbF == null) {
                    dbF = new d();
                }
            }
        }
        return dbF;
    }

    public static void d(String str, long j, long j2) {
        if (com.tencent.mm.protocal.d.lWk || com.tencent.mm.protocal.d.lWl || com.tencent.mm.protocal.d.lWj) {
            v.i("MicroMsg.ClickFlowStatSender", "kvCheck :%s [%s,%s,%s]", str, Long.valueOf(j), Long.valueOf(j2), Long.valueOf(j2 - j));
            g.iuh.Y(13393, "99999,0,0," + j + "," + j2 + "," + str);
        }
    }
}
