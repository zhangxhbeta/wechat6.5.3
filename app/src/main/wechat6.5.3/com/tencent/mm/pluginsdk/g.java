package com.tencent.mm.pluginsdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import com.tencent.mm.modelbiz.BizInfo;
import com.tencent.mm.protocal.c.ais;
import com.tencent.mm.protocal.c.ars;
import com.tencent.mm.storage.at.a;
import com.tencent.mm.storage.u;
import com.tencent.mm.v.f;
import com.tencent.mm.v.k;

@Deprecated
public interface g {
    Bitmap a(Activity activity, int i, int i2, Intent intent);

    k a(f fVar);

    void a(Context context, a aVar, Bundle bundle);

    void a(Context context, u uVar, a aVar, Bundle bundle, String str);

    void a(Context context, String str, String str2, String str3, int i, int i2, int i3, String str4, String str5);

    void a(Context context, String str, String str2, String str3, long j);

    void a(Intent intent, ars com_tencent_mm_protocal_c_ars, int i);

    void a(Intent intent, String str);

    void a(BizInfo bizInfo, Activity activity, u uVar);

    void a(BizInfo bizInfo, Activity activity, u uVar, boolean z, Runnable runnable);

    void a(ais com_tencent_mm_protocal_c_ais);

    boolean a(Context context, int i, int i2, String str);

    boolean a(u uVar);

    void ah(Context context);

    k ai(boolean z);

    boolean b(Context context, int i, int i2, String str);

    String bn(String str);

    boolean bo(String str);

    boolean bp(String str);

    void bq(String str);

    boolean c(Activity activity);

    void cH(int i);

    void d(Activity activity);

    String e(Context context, String str, String str2);

    String h(String str, int i);

    String n(Context context, String str);

    boolean o(Context context, String str);

    Intent oA();

    boolean oB();

    void oC();

    boolean oD();

    void ow();

    com.tencent.mm.v.g ox();

    void oy();

    void oz();

    String s(String str, String str2);
}
