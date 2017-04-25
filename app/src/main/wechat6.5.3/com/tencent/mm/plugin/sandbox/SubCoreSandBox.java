package com.tencent.mm.plugin.sandbox;

import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.mm.bg.g.c;
import com.tencent.mm.model.ag;
import com.tencent.mm.pluginsdk.j.ad;
import com.tencent.mm.pluginsdk.j.ae;
import com.tencent.mm.pluginsdk.j.af;
import com.tencent.mm.sandbox.a.a;
import com.tencent.mm.sandbox.monitor.ExceptionMonitorService;
import com.tencent.mm.sandbox.updater.Updater;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import java.util.HashMap;

public class SubCoreSandBox implements ag, af {
    public static boolean ivt = false;
    public static boolean ivu = false;

    public SubCoreSandBox() {
        v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox constructor at: " + System.currentTimeMillis());
    }

    public final HashMap<Integer, c> ti() {
        v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox getBaseDBFactories at: " + System.currentTimeMillis());
        return null;
    }

    public final void ed(int i) {
        v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox clearPluginData at: " + System.currentTimeMillis());
    }

    public final void aG(boolean z) {
        v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountPostReset at: " + System.currentTimeMillis());
    }

    public final void aH(boolean z) {
        v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onSdcardMount at: " + System.currentTimeMillis());
    }

    public final void th() {
        v.i("MicroMsg.SubCoreSandBox", "SubCoreSandBox onAccountRelease at: " + System.currentTimeMillis());
    }

    public final void aKN() {
        Updater.uT(16);
    }

    public final ad a(Context context, OnCancelListener onCancelListener) {
        return Updater.c(context, onCancelListener);
    }

    public final ad b(Context context, OnCancelListener onCancelListener) {
        return Updater.d(context, onCancelListener);
    }

    public final ad cs(Context context) {
        return Updater.dB(context);
    }

    public final void ct(Context context) {
        Updater.ct(context);
    }

    public final void c(String str, int i, String str2, String str3) {
        Updater.c(str, i, str2, str3);
    }

    public final ae aKO() {
        return new a(2);
    }

    public final String yO(String str) {
        return com.tencent.mm.sandbox.monitor.c.yO(str);
    }

    public final void o(Context context, Intent intent) {
        if (context != null) {
            intent.setClass(context, ExceptionMonitorService.class);
            aa.getContext().startService(intent);
        }
    }

    public final void fg(boolean z) {
        ivt = true;
        ivu = z;
    }
}
