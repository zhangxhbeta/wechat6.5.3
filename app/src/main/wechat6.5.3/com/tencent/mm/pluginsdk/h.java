package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.ui.MMActivity;
import com.tencent.mm.ui.MMWizardActivity;
import com.tencent.mm.ui.tools.a.a;

@Deprecated
public interface h {
    void a(Activity activity, Intent intent, int i);

    void a(Activity activity, Intent intent, Intent intent2, String str, int i, a aVar);

    void a(Context context, Intent intent, Intent intent2);

    void a(Intent intent, int i, Activity activity);

    void a(Intent intent, int i, MMActivity mMActivity, Intent intent2);

    void a(Intent intent, Activity activity);

    void a(Intent intent, Activity activity, int i);

    void a(Intent intent, Context context);

    void a(Intent intent, MMActivity.a aVar, MMActivity mMActivity);

    void a(Intent intent, MMActivity mMActivity);

    void a(MMActivity mMActivity, String str, WXMediaMessage wXMediaMessage, String str2, String str3);

    void a(MMWizardActivity mMWizardActivity, Intent intent);

    void a(String str, Intent intent, Context context);

    void a(boolean z, boolean z2, Context context, String str, int i, int i2);

    boolean a(Context context, String str, Object... objArr);

    com.tencent.mm.ui.base.h aj(Context context);

    Intent ak(Context context);

    void al(Context context);

    void am(Context context);

    void b(Intent intent, Activity activity);

    void b(Intent intent, Context context);

    void b(MMWizardActivity mMWizardActivity, Intent intent);

    boolean b(Context context, String str, Bundle bundle);

    void c(Context context, Intent intent);

    void c(Intent intent, Context context);

    void cancelNotification(String str);

    void d(Context context, Intent intent);

    void d(Intent intent, Context context);

    void e(Context context, Intent intent);

    void e(Intent intent, Context context);

    void f(Context context, Intent intent);

    void f(Intent intent, Context context);

    void g(Context context, Intent intent);

    void g(Intent intent, Context context);

    void h(Context context, Intent intent);

    void h(Intent intent, Context context);

    void i(Context context, Intent intent);

    void i(Intent intent, Context context);

    void j(Context context, Intent intent);

    void j(Intent intent, Context context);

    void k(Context context, Intent intent);

    void k(Intent intent, Context context);

    void l(Intent intent, Context context);

    void m(Intent intent, Context context);

    void n(Intent intent, Context context);

    void o(Intent intent, Context context);

    void oz();

    void p(Context context, String str);

    void p(Intent intent, Context context);

    void q(Intent intent, Context context);

    void r(Intent intent, Context context);

    void s(Intent intent, Context context);

    void t(Intent intent, Context context);

    void u(Intent intent, Context context);

    void v(Intent intent, Context context);

    void w(Intent intent, Context context);

    void x(Intent intent, Context context);

    void y(Intent intent, Context context);
}
