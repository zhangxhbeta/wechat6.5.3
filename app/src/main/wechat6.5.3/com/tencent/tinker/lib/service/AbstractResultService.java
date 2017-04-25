package com.tencent.tinker.lib.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.tinker.lib.e.a;
import com.tencent.tinker.loader.TinkerRuntimeException;
import com.tencent.tinker.loader.shareutil.ShareIntentUtil;

public abstract class AbstractResultService extends IntentService {
    public abstract void a(a aVar);

    public AbstractResultService() {
        super(AbstractResultService.class.getSimpleName());
    }

    public static void a(Context context, a aVar, String str) {
        if (str == null) {
            throw new TinkerRuntimeException("resultServiceClass is null.");
        }
        Intent intent = new Intent();
        intent.setClassName(context, str);
        intent.putExtra("result_extra", aVar);
        context.startService(intent);
    }

    protected void onHandleIntent(Intent intent) {
        if (intent == null) {
            a.e("Tinker.AbstractResultService", "AbstractResultService received a null intent, ignoring.", new Object[0]);
        } else {
            a((a) ShareIntentUtil.m(intent, "result_extra"));
        }
    }
}
