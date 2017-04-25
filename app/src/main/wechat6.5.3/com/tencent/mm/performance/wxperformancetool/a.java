package com.tencent.mm.performance.wxperformancetool;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public final class a extends com.tencent.mm.performance.a.a.a {
    private HashMap<Integer, Long> dnV = new HashMap();
    private HashMap<Integer, Long> dnW = new HashMap();
    private HashMap<Integer, Long> dnX = new HashMap();
    private HashMap<Integer, Long> dnY = new HashMap();
    private HashMap<Integer, Long> dnZ = new HashMap();
    private HashMap<Integer, Long> doa = new HashMap();
    private HashMap<Integer, Long> dob = new HashMap();

    private static void a(HashMap<Integer, Long> hashMap, Activity activity) {
        if (activity != null) {
            hashMap.put(Integer.valueOf(activity.hashCode()), Long.valueOf(System.currentTimeMillis()));
        }
    }

    private static void a(HashMap<Integer, Long> hashMap, Activity activity, String str) {
        if (activity != null) {
            int hashCode = activity.hashCode();
            Long l = (Long) hashMap.get(Integer.valueOf(hashCode));
            if (l != null) {
                v.i("MicroMsg.WxPerformace", str + "  activity: " + hashCode + " classname:" + activity.getComponentName().getShortClassName() + " use time: " + (System.currentTimeMillis() - l.longValue()) + " taskid:" + activity.getTaskId());
            }
        }
    }

    public final void a(Activity activity, Bundle bundle) {
        super.a(activity, bundle);
        a(this.dnV, activity);
    }

    public final void b(Activity activity, Bundle bundle) {
        super.b(activity, bundle);
        a(this.dnV, activity, "onActivityCreate");
    }

    public final void o(Activity activity) {
        super.o(activity);
        a(this.dnW, activity);
    }

    public final void p(Activity activity) {
        super.p(activity);
        a(this.dnW, activity, "onActivityDestroy");
    }

    public final void c(Activity activity, Intent intent) {
        super.c(activity, intent);
        a(this.dnX, activity);
    }

    public final void d(Activity activity, Intent intent) {
        super.d(activity, intent);
        a(this.dnX, activity, "onActivityNewIntent");
    }

    public final void i(Activity activity) {
        super.i(activity);
        a(this.dnY, activity);
    }

    public final void j(Activity activity) {
        super.j(activity);
        a(this.dnY, activity, "onActivityPause");
    }

    public final void g(Activity activity) {
        super.g(activity);
        a(this.dnZ, activity);
    }

    public final void h(Activity activity) {
        super.h(activity);
        a(this.dnZ, activity, "onActivityResume");
    }

    public final void k(Activity activity) {
        super.k(activity);
        a(this.doa, activity);
    }

    public final void l(Activity activity) {
        super.l(activity);
        a(this.doa, activity, "onActivityStart");
    }

    public final void m(Activity activity) {
        super.m(activity);
        a(this.dob, activity);
    }

    public final void n(Activity activity) {
        super.n(activity);
        a(this.dob, activity, "onActivityStop");
    }
}
