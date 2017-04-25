package com.tencent.mmdb.support;

import com.tencent.mmdb.support.ICancellationSignal.Stub;

public final class CancellationSignal {
    private boolean mCancelInProgress;
    private boolean mIsCanceled;
    private OnCancelListener mOnCancelListener;
    private ICancellationSignal mRemote;

    public interface OnCancelListener {
        void onCancel();
    }

    private static final class Transport extends Stub {
        final CancellationSignal mCancellationSignal;

        private Transport() {
            this.mCancellationSignal = new CancellationSignal();
        }

        public final void cancel() {
            this.mCancellationSignal.cancel();
        }
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this) {
            z = this.mIsCanceled;
        }
        return z;
    }

    public final void throwIfCanceled() {
        if (isCanceled()) {
            throw new OperationCanceledException();
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void cancel() {
        /*
        r2 = this;
        monitor-enter(r2);
        r0 = r2.mIsCanceled;	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0007;
    L_0x0005:
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
    L_0x0006:
        return;
    L_0x0007:
        r0 = 1;
        r2.mIsCanceled = r0;	 Catch:{ all -> 0x0028 }
        r0 = 1;
        r2.mCancelInProgress = r0;	 Catch:{ all -> 0x0028 }
        r0 = r2.mOnCancelListener;	 Catch:{ all -> 0x0028 }
        r1 = r2.mRemote;	 Catch:{ all -> 0x0028 }
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        if (r0 == 0) goto L_0x0017;
    L_0x0014:
        r0.onCancel();	 Catch:{ all -> 0x002b }
    L_0x0017:
        if (r1 == 0) goto L_0x001c;
    L_0x0019:
        r1.cancel();	 Catch:{ RemoteException -> 0x0038 }
    L_0x001c:
        monitor-enter(r2);
        r0 = 0;
        r2.mCancelInProgress = r0;	 Catch:{ all -> 0x0025 }
        r2.notifyAll();	 Catch:{ all -> 0x0025 }
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        goto L_0x0006;
    L_0x0025:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0025 }
        throw r0;
    L_0x0028:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0028 }
        throw r0;
    L_0x002b:
        r0 = move-exception;
        monitor-enter(r2);
        r1 = 0;
        r2.mCancelInProgress = r1;	 Catch:{ all -> 0x0035 }
        r2.notifyAll();	 Catch:{ all -> 0x0035 }
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0035:
        r0 = move-exception;
        monitor-exit(r2);	 Catch:{ all -> 0x0035 }
        throw r0;
    L_0x0038:
        r0 = move-exception;
        goto L_0x001c;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmdb.support.CancellationSignal.cancel():void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setOnCancelListener(com.tencent.mmdb.support.CancellationSignal.OnCancelListener r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r1.waitForCancelFinishedLocked();	 Catch:{ all -> 0x0014 }
        r0 = r1.mOnCancelListener;	 Catch:{ all -> 0x0014 }
        if (r0 != r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
    L_0x0009:
        return;
    L_0x000a:
        r1.mOnCancelListener = r2;	 Catch:{ all -> 0x0014 }
        r0 = r1.mIsCanceled;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        if (r2 != 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0009;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        r2.onCancel();
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmdb.support.CancellationSignal.setOnCancelListener(com.tencent.mmdb.support.CancellationSignal$OnCancelListener):void");
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRemote(com.tencent.mmdb.support.ICancellationSignal r2) {
        /*
        r1 = this;
        monitor-enter(r1);
        r1.waitForCancelFinishedLocked();	 Catch:{ all -> 0x0014 }
        r0 = r1.mRemote;	 Catch:{ all -> 0x0014 }
        if (r0 != r2) goto L_0x000a;
    L_0x0008:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
    L_0x0009:
        return;
    L_0x000a:
        r1.mRemote = r2;	 Catch:{ all -> 0x0014 }
        r0 = r1.mIsCanceled;	 Catch:{ all -> 0x0014 }
        if (r0 == 0) goto L_0x0012;
    L_0x0010:
        if (r2 != 0) goto L_0x0017;
    L_0x0012:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        goto L_0x0009;
    L_0x0014:
        r0 = move-exception;
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        throw r0;
    L_0x0017:
        monitor-exit(r1);	 Catch:{ all -> 0x0014 }
        r2.cancel();	 Catch:{ RemoteException -> 0x001c }
        goto L_0x0009;
    L_0x001c:
        r0 = move-exception;
        goto L_0x0009;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.mmdb.support.CancellationSignal.setRemote(com.tencent.mmdb.support.ICancellationSignal):void");
    }

    private void waitForCancelFinishedLocked() {
        while (this.mCancelInProgress) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }
    }

    public static ICancellationSignal createTransport() {
        return new Transport();
    }

    public static CancellationSignal fromTransport(ICancellationSignal iCancellationSignal) {
        if (iCancellationSignal instanceof Transport) {
            return ((Transport) iCancellationSignal).mCancellationSignal;
        }
        return null;
    }
}
