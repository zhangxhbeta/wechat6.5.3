package com.tencent.mm.vending.base;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

public final class c {
    private Handler mVendingHandler;
    private Looper mVendingLooper;
    private Looper pgP;
    private Handler pgQ;
    byte[] pgR = new byte[0];
    a pgS = new a(this) {
        final /* synthetic */ Vending pgx;

        {
            this.pgx = r1;
        }

        public final void bKC() {
            com.tencent.mm.vending.f.a.i(Vending.TAG, "%s beforeSynchronize", new Object[]{this.pgx});
            this.pgx.mLoader.bKE();
        }

        public final void synchronizing(int i, Object obj) {
            com.tencent.mm.vending.f.a.i(Vending.TAG, "%s synchronizing", new Object[]{this.pgx});
            this.pgx.mVendingDeferring.clear();
            this.pgx.mLoader.bKE();
            this.pgx.mSubscriberHandler.removeCallbacksAndMessages(null);
            if (i == 2) {
                obj = this.pgx.prepareVendingDataAsynchronous();
            }
            if (i == 2 || i == 1) {
                this.pgx.applyChangeSynchronized(obj);
            }
            this.pgx.synchronizing(i, obj);
            this.pgx.mArray.clear();
        }

        public final void bKD() {
            com.tencent.mm.vending.f.a.i(Vending.TAG, "%s afterSynchronize", new Object[]{this.pgx});
            if (this.pgx.mDataChangedCallback != null) {
                this.pgx.mDataChangedCallback.bKG();
            }
        }
    };

    public interface a {
        void bKC();

        void bKD();

        void synchronizing(int i, Object obj);
    }

    public c(Looper looper, Looper looper2) {
        this.pgP = looper;
        this.mVendingLooper = looper2;
        this.pgQ = new Handler(this, this.pgP) {
            final /* synthetic */ c pgT;

            public final void handleMessage(Message message) {
                this.pgT.h(message.what, message.obj);
            }
        };
        this.mVendingHandler = new Handler(this, this.mVendingLooper) {
            final /* synthetic */ c pgT;

            public final void handleMessage(Message message) {
                synchronized (this.pgT.pgR) {
                    if (this.pgT.pgS != null) {
                        this.pgT.pgS.synchronizing(message.what, message.obj);
                    }
                    this.pgT.pgR.notify();
                }
            }
        };
    }

    public final void h(int i, Object obj) {
        if (Looper.myLooper() == this.pgP) {
            if (this.pgS == null) {
                com.tencent.mm.vending.f.a.w("Vending.VendingSync", "This call is pointless.", new Object[0]);
                return;
            }
            this.pgS.bKC();
            synchronized (this.pgR) {
                this.mVendingHandler.sendMessageAtFrontOfQueue(this.mVendingHandler.obtainMessage(i, obj));
                try {
                    this.pgR.wait();
                } catch (InterruptedException e) {
                }
            }
            this.pgS.bKD();
        } else if (Looper.myLooper() == this.mVendingLooper) {
            this.pgQ.sendMessageAtFrontOfQueue(this.pgQ.obtainMessage(i, obj));
        }
    }
}
