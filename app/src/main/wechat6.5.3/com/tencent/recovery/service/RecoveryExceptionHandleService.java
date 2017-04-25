package com.tencent.recovery.service;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import com.tencent.recovery.a;
import com.tencent.recovery.c.b;
import com.tencent.recovery.model.RecoveryHandleInfo;

public abstract class RecoveryExceptionHandleService extends IntentService {
    private static final String TAG = (a.ptH + "Recovery.RecoveryService");

    public abstract boolean a(Context context, int i, RecoveryHandleInfo recoveryHandleInfo);

    public RecoveryExceptionHandleService() {
        super(RecoveryExceptionHandleService.class.getName());
    }

    protected final void onHandleIntent(Intent intent) {
        RecoveryHandleInfo recoveryHandleInfo = (RecoveryHandleInfo) intent.getParcelableExtra("KeyRecoveryTransformInfo");
        if (recoveryHandleInfo == null || recoveryHandleInfo.processName == null) {
            b.i(TAG, "processInfo is null", new Object[0]);
            return;
        }
        boolean a;
        b.i(TAG, "start to handle %s's exception uuid: %d threadId: %d", new Object[]{recoveryHandleInfo.processName, Integer.valueOf(com.tencent.recovery.e.a.eU(this)), Long.valueOf(Thread.currentThread().getId())});
        try {
            a = a(getApplicationContext(), com.tencent.recovery.e.a.eU(this), recoveryHandleInfo);
        } catch (Throwable e) {
            b.a(TAG, e, "handle", new Object[0]);
            a = false;
        }
        b.i(TAG, "handle result %b", new Object[]{Boolean.valueOf(a)});
        stopSelf();
    }
}
