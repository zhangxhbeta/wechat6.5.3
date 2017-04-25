package com.google.android.gms.tagmanager;

final class ae extends ad {
    private static final Object aDc = new Object();
    private static ae aDl;
    private j aDd;
    private volatile i aDe;
    private int aDf = 1800000;
    private boolean aDg = true;
    private boolean aDh = false;
    private boolean aDi = true;
    private k aDj = new k(this) {
        final /* synthetic */ ae aDm;

        {
            this.aDm = r1;
        }
    };
    private boolean aDk = false;
    private boolean connected = true;

    private ae() {
    }

    public static ae mk() {
        if (aDl == null) {
            aDl = new ae();
        }
        return aDl;
    }

    public final synchronized void mj() {
        if (this.aDh) {
            i iVar = this.aDe;
            AnonymousClass2 anonymousClass2 = new Runnable(this) {
                final /* synthetic */ ae aDm;

                {
                    this.aDm = r1;
                }

                public final void run() {
                    this.aDm.aDd;
                }
            };
        } else {
            m.lP();
            this.aDg = true;
        }
    }
}
