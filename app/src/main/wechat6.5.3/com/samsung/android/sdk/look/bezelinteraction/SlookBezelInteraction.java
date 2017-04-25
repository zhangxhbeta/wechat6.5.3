package com.samsung.android.sdk.look.bezelinteraction;

import android.content.ComponentName;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.os.ServiceManager;
import com.samsung.android.bezelinteraction.BezelEvent;
import com.samsung.android.bezelinteraction.IBezelCallback.Stub;
import com.samsung.android.bezelinteraction.IBezelManager;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public final class SlookBezelInteraction {
    public static final String SERVICE_NAME = "BezelInteractionService";
    private static final String TAG = "SlookBezelInteraction";
    private static Context mContext = null;
    private static IBezelManager mService = null;
    private final CopyOnWriteArrayList<BezelListenerDelegate> mListenerDelegates = new CopyOnWriteArrayList();

    public interface BezelListener {
        void onItemSelected(BezelEvent bezelEvent);
    }

    private static class BezelListenerDelegate extends Stub {
        public Handler mHandler;
        public BezelListener mListener;

        static class ListenerHandler extends Handler {
            public BezelListener mListener = null;

            public ListenerHandler(Looper looper, BezelListener bezelListener) {
                super(looper);
                this.mListener = bezelListener;
            }

            public void handleMessage(Message message) {
                if (this.mListener != null) {
                    BezelEvent bezelEvent = (BezelEvent) message.obj;
                    if (bezelEvent != null) {
                        this.mListener.onItemSelected(bezelEvent);
                    }
                }
            }
        }

        BezelListenerDelegate(BezelListener bezelListener, Handler handler) {
            this.mListener = bezelListener;
            this.mHandler = new ListenerHandler(handler == null ? SlookBezelInteraction.mContext.getMainLooper() : handler.getLooper(), this.mListener);
        }

        public BezelListener getListener() {
            return this.mListener;
        }

        public void onBezelCallback(BezelEvent bezelEvent) {
            Message obtain = Message.obtain();
            obtain.what = 0;
            obtain.obj = bezelEvent;
            this.mHandler.sendMessage(obtain);
        }

        public String getListenerInfo() {
            return this.mListener.toString();
        }
    }

    public SlookBezelInteraction(Context context) {
        mContext = context;
        getService();
    }

    private synchronized IBezelManager getService() {
        if (mService == null) {
            mService = IBezelManager.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        } else if (!mService.asBinder().isBinderAlive()) {
            mService = IBezelManager.Stub.asInterface(ServiceManager.getService(SERVICE_NAME));
        }
        return mService;
    }

    public final void registerListener(BezelListener bezelListener) {
        if (bezelListener != null) {
            synchronized (this.mListenerDelegates) {
                IBinder iBinder;
                Iterator it = this.mListenerDelegates.iterator();
                while (it.hasNext()) {
                    iBinder = (BezelListenerDelegate) it.next();
                    if (iBinder.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                iBinder = null;
                if (iBinder == null) {
                    iBinder = new BezelListenerDelegate(bezelListener, null);
                    this.mListenerDelegates.add(iBinder);
                }
                try {
                    IBezelManager service = getService();
                    if (service != null) {
                        service.registerCallback(iBinder, new ComponentName(mContext.getPackageName(), mContext.getClass().getCanonicalName()));
                    }
                } catch (RemoteException e) {
                }
            }
        }
    }

    public final void unregisterListener(BezelListener bezelListener) {
        if (bezelListener != null) {
            synchronized (this.mListenerDelegates) {
                IBinder iBinder;
                Iterator it = this.mListenerDelegates.iterator();
                while (it.hasNext()) {
                    iBinder = (BezelListenerDelegate) it.next();
                    if (iBinder.getListener().equals(bezelListener)) {
                        break;
                    }
                }
                iBinder = null;
                if (iBinder == null) {
                    return;
                }
                try {
                    IBezelManager service = getService();
                    if (service != null && service.unregisterCallback(iBinder)) {
                        this.mListenerDelegates.remove(iBinder);
                        iBinder.mHandler = null;
                        iBinder.mListener = null;
                    }
                } catch (RemoteException e) {
                }
            }
        }
    }

    public final void enableBezelInteraction(boolean z) {
        try {
            IBezelManager service = getService();
            if (service != null) {
                service.enableBezelInteraction(z);
            }
        } catch (RemoteException e) {
        }
    }
}
