package com.b.a;

import android.os.Handler;
import android.os.IBinder.DeathRecipient;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;

public final class a {
    public c aGH;
    public b aGI;
    public a aGJ;
    private int aGK;
    b aGL;
    int aGM = -1;
    public DeathRecipient aGN = new DeathRecipient(this) {
        final /* synthetic */ a aGO;

        {
            this.aGO = r1;
        }

        public final void binderDied() {
            if (this.aGO.aGL != null) {
                this.aGO.aGL.ap(2101, -1);
            }
        }
    };

    private class a extends Handler {
        final /* synthetic */ a aGO;
        private final int aGP = 2001;
        private final int aGQ = 2002;
        private final int aGR = 2003;
        private final int aGS = 2004;
        private final int aGT = 2005;
        private final int aGU = 2006;

        public a(a aVar, Looper looper) {
            this.aGO = aVar;
            super(looper);
        }

        public final void handleMessage(Message message) {
            int i = 2005;
            new StringBuilder("what = ").append(message.what);
            switch (message.what) {
                case 1:
                    if (this.aGO.aGL == null) {
                        return;
                    }
                    return;
                case 2:
                    if (this.aGO.aGL == null) {
                        return;
                    }
                    return;
                case 3:
                    if (this.aGO.aGL == null) {
                        return;
                    }
                    return;
                case 6:
                    if (this.aGO.aGL != null) {
                        this.aGO.aGL.ap(0, message.arg1);
                    }
                    removeMessages(8);
                    return;
                case 7:
                    if (this.aGO.aGL != null) {
                        switch (message.arg1) {
                            case 2001:
                                i = 2002;
                                break;
                            case 2002:
                                i = 2003;
                                break;
                            case 2003:
                            case 2006:
                                break;
                            case 2004:
                                i = 2000;
                                break;
                            case 2005:
                                i = 2006;
                                break;
                            default:
                                i = 2020;
                                break;
                        }
                        this.aGO.aGL.ap(i, -1);
                    }
                    removeMessages(8);
                    return;
                case 8:
                    if (this.aGO.aGL != null) {
                        this.aGO.aGL.ap(2001, -1);
                    }
                    removeMessages(8);
                    this.aGO.abort();
                    return;
                default:
                    return;
            }
        }
    }

    public interface b {
        void ap(int i, int i2);
    }

    public static a mV() {
        c mY = mY();
        if (mY == null) {
            return null;
        }
        try {
            return new a(mY, Looper.getMainLooper(), 1);
        } catch (Exception e) {
            return null;
        }
    }

    private a(c cVar, Looper looper, int i) {
        this.aGH = cVar;
        a aVar = new a(this, looper);
        this.aGK = 1;
        this.aGI = new com.b.a.b.a(this) {
            final /* synthetic */ a aGO;

            {
                this.aGO = r1;
            }

            public final void a(int i, int i2, int i3, byte[] bArr) {
                this.aGO.aGJ.sendMessage(this.aGO.aGJ.obtainMessage(i, i2, i3, bArr));
            }
        };
        if (this.aGH.a(this.aGI, 1)) {
            this.aGJ = aVar;
            cVar.asBinder().linkToDeath(this.aGN, 0);
            return;
        }
        throw new RuntimeException();
    }

    public final int[] mW() {
        try {
            return this.aGH.c(this.aGI);
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    public final int a(b bVar, int i, int[] iArr) {
        int i2 = -1;
        if (!(iArr == null || bVar == null)) {
            if (i > 0) {
                new StringBuilder("startIdentify send message timeout after ").append(i).append(" ms");
                this.aGJ.sendMessageDelayed(this.aGJ.obtainMessage(8), (long) i);
            }
            this.aGL = bVar;
            this.aGM = 0;
            try {
                i2 = this.aGH.a(this.aGI, iArr, null);
            } catch (RemoteException e) {
            }
        }
        return i2;
    }

    public final void abort() {
        if (this.aGJ != null) {
            this.aGJ.removeMessages(8);
        }
        try {
            this.aGH.a(this.aGI);
        } catch (RemoteException e) {
        }
    }

    public static int[] mX() {
        c mY = mY();
        if (mY == null) {
            return new int[0];
        }
        try {
            return mY.mZ();
        } catch (RemoteException e) {
            return new int[0];
        }
    }

    private static c mY() {
        return com.b.a.c.a.x(ServiceManager.getService("authentication_service"));
    }
}
