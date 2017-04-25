package com.tencent.tmassistantsdk.downloadclient;

import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.util.ParamPair;
import com.tencent.tmassistantsdk.util.TMLog;
import java.util.ArrayList;
import java.util.Iterator;

public class TMAssistantDownloadSDKMessageThread extends Handler {
    private static TMAssistantDownloadSDKMessageThread mInstance = null;
    private static HandlerThread mMessagehandlerThread = null;
    private static final int postActionResult = 4;
    private static final int postSDKServiceInvalidMessage = 3;
    private static final int postTaskProgressChangedMessage = 2;
    private static final int postTaskStateChangedMessage = 1;

    private TMAssistantDownloadSDKMessageThread(Looper looper) {
        super(looper);
    }

    public static synchronized TMAssistantDownloadSDKMessageThread getInstance() {
        TMAssistantDownloadSDKMessageThread tMAssistantDownloadSDKMessageThread;
        synchronized (TMAssistantDownloadSDKMessageThread.class) {
            if (mInstance == null) {
                HandlerThread handlerThread = new HandlerThread("TMAssistantDownloadSDKMessageThread");
                mMessagehandlerThread = handlerThread;
                handlerThread.start();
                mInstance = new TMAssistantDownloadSDKMessageThread(mMessagehandlerThread.getLooper());
            }
            tMAssistantDownloadSDKMessageThread = mInstance;
        }
        return tMAssistantDownloadSDKMessageThread;
    }

    public void handleMessage(Message message) {
        super.handleMessage(message);
        ParamPair paramPair;
        TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient;
        ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener;
        switch (message.what) {
            case 1:
                paramPair = (ParamPair) message.obj;
                tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) paramPair.mFirstParam;
                iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) paramPair.mSecondParam;
                Bundle data = message.getData();
                String string = data.getString("url");
                int i = data.getInt("state");
                int i2 = data.getInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE);
                String string2 = data.getString(OpenSDKTool4Assistant.EXTRA_ERROR_MSG);
                if (iTMAssistantDownloadSDKClientListener != null) {
                    iTMAssistantDownloadSDKClientListener.OnDownloadSDKTaskStateChanged(tMAssistantDownloadSDKClient, string, i, i2, string2);
                    return;
                }
                return;
            case 2:
                paramPair = (ParamPair) message.obj;
                TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient2 = (TMAssistantDownloadSDKClient) paramPair.mFirstParam;
                ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener2 = (ITMAssistantDownloadSDKClientListener) paramPair.mSecondParam;
                Bundle data2 = message.getData();
                String string3 = data2.getString("url");
                long j = data2.getLong("receiveDataLen");
                long j2 = data2.getLong("totalDataLen");
                if (iTMAssistantDownloadSDKClientListener2 != null) {
                    iTMAssistantDownloadSDKClientListener2.OnDownloadSDKTaskProgressChanged(tMAssistantDownloadSDKClient2, string3, j, j2);
                    return;
                }
                return;
            case 3:
                paramPair = (ParamPair) message.obj;
                tMAssistantDownloadSDKClient = (TMAssistantDownloadSDKClient) paramPair.mFirstParam;
                iTMAssistantDownloadSDKClientListener = (ITMAssistantDownloadSDKClientListener) paramPair.mSecondParam;
                if (iTMAssistantDownloadSDKClientListener != null) {
                    iTMAssistantDownloadSDKClientListener.OnDwonloadSDKServiceInvalid(tMAssistantDownloadSDKClient);
                    return;
                }
                return;
            case 4:
                paramPair = (ParamPair) message.obj;
                byte[] bArr = (byte[]) paramPair.mFirstParam;
                ArrayList arrayList = (ArrayList) paramPair.mSecondParam;
                if (arrayList != null) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        IAssistantOnActionListener iAssistantOnActionListener = (IAssistantOnActionListener) it.next();
                        if (iAssistantOnActionListener != null) {
                            iAssistantOnActionListener.onActionResult(bArr);
                        }
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void postTaskStateChangedMessage(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener, String str, int i, int i2, String str2) {
        if (iTMAssistantDownloadSDKClientListener != null && tMAssistantDownloadSDKClient != null) {
            Message obtainMessage = getInstance().obtainMessage();
            obtainMessage.what = 1;
            obtainMessage.obj = new ParamPair(tMAssistantDownloadSDKClient, iTMAssistantDownloadSDKClientListener);
            Bundle bundle = new Bundle();
            bundle.putString("url", str);
            bundle.putInt("state", i);
            bundle.putInt(OpenSDKTool4Assistant.EXTRA_ERROR_CODE, i2);
            bundle.putString(OpenSDKTool4Assistant.EXTRA_ERROR_MSG, str2);
            obtainMessage.setData(bundle);
            obtainMessage.sendToTarget();
        }
    }

    public void postTaskProgressChangedMessage(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener, String str, long j, long j2) {
        if (iTMAssistantDownloadSDKClientListener == null || tMAssistantDownloadSDKClient == null) {
            TMLog.i("TMAssistantDownloadSDKMessageThread", "listenr:" + iTMAssistantDownloadSDKClientListener + " === sdkClient" + tMAssistantDownloadSDKClient);
            return;
        }
        Message obtainMessage = getInstance().obtainMessage();
        obtainMessage.what = 2;
        obtainMessage.obj = new ParamPair(tMAssistantDownloadSDKClient, iTMAssistantDownloadSDKClientListener);
        Bundle bundle = new Bundle();
        bundle.putString("url", str);
        bundle.putLong("receiveDataLen", j);
        bundle.putLong("totalDataLen", j2);
        obtainMessage.setData(bundle);
        obtainMessage.sendToTarget();
    }

    public void postSDKServiceInvalidMessage(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, ITMAssistantDownloadSDKClientListener iTMAssistantDownloadSDKClientListener) {
        if (iTMAssistantDownloadSDKClientListener != null && tMAssistantDownloadSDKClient != null) {
            Message obtainMessage = getInstance().obtainMessage();
            obtainMessage.what = 3;
            obtainMessage.obj = new ParamPair(tMAssistantDownloadSDKClient, iTMAssistantDownloadSDKClientListener);
            obtainMessage.sendToTarget();
        }
    }

    public void postActionResult(byte[] bArr, ArrayList<IAssistantOnActionListener> arrayList) {
        if (bArr != null && arrayList != null) {
            Message obtainMessage = getInstance().obtainMessage();
            obtainMessage.what = 4;
            obtainMessage.obj = new ParamPair(bArr, arrayList);
            obtainMessage.sendToTarget();
        }
    }
}
