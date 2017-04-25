package com.tencent.tmassistantsdk.downloadservice;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Message;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class NetworkMonitorReceiver extends BroadcastReceiver {
    protected static final int MSG_DELAY_TIME = 3500;
    protected static final int MSG_resumeDownloadTime = 67;
    protected static final String TAG = "NetworkMonitorReceiver";
    protected static NetworkMonitorReceiver mInstance = null;
    protected boolean isRegisterReceiver = false;
    protected final ac mNetworkChangedHandler = new ac() {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            switch (message.what) {
                case 67:
                    NetworkMonitorReceiver.this.notifyNetworkChanged();
                    return;
                default:
                    return;
            }
        }
    };
    ArrayList<INetworkChangedObserver> mObs = new ArrayList();

    public interface INetworkChangedObserver {
        void onNetworkChanged();
    }

    public static synchronized NetworkMonitorReceiver getInstance() {
        NetworkMonitorReceiver networkMonitorReceiver;
        synchronized (NetworkMonitorReceiver.class) {
            if (mInstance == null) {
                mInstance = new NetworkMonitorReceiver();
            }
            networkMonitorReceiver = mInstance;
        }
        return networkMonitorReceiver;
    }

    public void onReceive(Context context, Intent intent) {
        TMLog.i(TAG, "network changed!");
        this.mNetworkChangedHandler.removeMessages(67);
        Message obtain = Message.obtain();
        obtain.what = 67;
        this.mNetworkChangedHandler.sendMessageDelayed(obtain, 3500);
    }

    public void registerReceiver() {
        Context context = GlobalUtil.getInstance().getContext();
        if (context != null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            try {
                context.registerReceiver(this, intentFilter);
                this.isRegisterReceiver = true;
            } catch (Throwable th) {
                this.isRegisterReceiver = false;
                v.a(TAG, th, "", new Object[0]);
            }
        }
    }

    public void unregisterReceiver() {
        if (mInstance != null) {
            Context context = GlobalUtil.getInstance().getContext();
            if (context != null) {
                try {
                    if (this.isRegisterReceiver) {
                        context.unregisterReceiver(this);
                        this.isRegisterReceiver = false;
                    }
                } catch (Throwable th) {
                    v.a(TAG, th, "", new Object[0]);
                }
            }
        }
    }

    public void addNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        if (!this.mObs.contains(iNetworkChangedObserver) && iNetworkChangedObserver != null) {
            this.mObs.add(iNetworkChangedObserver);
        }
    }

    public void removeNetworkChangedObserver(INetworkChangedObserver iNetworkChangedObserver) {
        if (iNetworkChangedObserver != null) {
            this.mObs.remove(iNetworkChangedObserver);
        }
    }

    public void notifyNetworkChanged() {
        Iterator it = this.mObs.iterator();
        while (it.hasNext()) {
            ((INetworkChangedObserver) it.next()).onNetworkChanged();
        }
    }
}
