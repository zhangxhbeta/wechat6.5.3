package com.google.android.gms.tagmanager;

import android.os.Handler;
import android.os.Message;
import com.google.android.gms.common.api.Status;

final class am implements b {
    private a aDA;
    private a aDB;
    private Status aDC;
    private b aDD;
    a aDE;
    boolean aDF;
    private d aDG;

    public interface a {
        String mq();
    }

    private class b extends Handler {
        public final void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    Object obj = message.obj;
                    return;
                default:
                    m.lL();
                    return;
            }
        }
    }

    public final synchronized void ao(String str) {
        if (!this.aDF) {
            this.aDA.lF().ao(str);
        }
    }

    public final Status jo() {
        return this.aDC;
    }

    final String mo() {
        if (!this.aDF) {
            return this.aDA.aBV;
        }
        m.lL();
        return "";
    }

    final void mp() {
        if (this.aDF) {
            m.lL();
        }
    }

    public final synchronized void refresh() {
        if (this.aDF) {
            m.lL();
        }
    }

    public final synchronized void release() {
        if (this.aDF) {
            m.lL();
        } else {
            this.aDF = true;
            this.aDG.aCm.remove(this);
            this.aDA.aBW = null;
            this.aDA = null;
            this.aDB = null;
            this.aDE = null;
            this.aDD = null;
        }
    }
}
