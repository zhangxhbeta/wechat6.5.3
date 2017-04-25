package com.tencent.tmassistantsdk.openSDK.opensdktomsdk;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mm.sdk.platformtools.ac;
import com.tencent.mm.sdk.platformtools.ac.a;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannel;
import com.tencent.tmassistantsdk.channel.TMAssistantSDKChannelDataItem;
import com.tencent.tmassistantsdk.downloadclient.ITMAssistantDownloadSDKClientListener;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKClient;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadSDKManager;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.logreport.TipsInfoReportManager;
import com.tencent.tmassistantsdk.network.GetAuthorizedHttpRequest;
import com.tencent.tmassistantsdk.network.IGetAuthorizedHttpRequestListenner;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.AuthorizedResult;
import com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo;
import com.tencent.tmassistantsdk.protocol.jce.TipsInfoLog;
import com.tencent.tmassistantsdk.util.Res;
import com.tencent.tmassistantsdk.util.TMLog;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public class TMOpenSDKToMsdkManager {
    protected static final String CLIENT_NAME = "downloadSDKClient";
    protected static final String TAG = "OpensdkToMsdkManager";
    protected static TMOpenSDKToMsdkManager mInstance = null;
    protected int authorizedState = 0;
    protected PopDialog dialog = null;
    protected boolean hasNotify = false;
    protected long insertActionId = -1;
    protected boolean isInstallFinished = false;
    protected TMOpenSDKAuthorizedInfo mAuthorizedInfo = null;
    protected TMAssistantDownloadSDKClient mClient = null;
    protected Context mContext = null;
    protected ITMAssistantDownloadSDKClientListener mDownloadSDKListener = new ITMAssistantDownloadSDKClientListener() {
        public void OnDwonloadSDKServiceInvalid(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient) {
        }

        public void OnDownloadSDKTaskStateChanged(final TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, final String str, int i, int i2, String str2) {
            TMLog.i(TMOpenSDKToMsdkManager.TAG, "OnDownloadSDKTaskStateChanged client:" + tMAssistantDownloadSDKClient + " | state:" + i + " | errorcode:" + i2 + " | errorMsg:" + str2);
            if (tMAssistantDownloadSDKClient != null && !TextUtils.isEmpty(str)) {
                if (4 == i) {
                    TMOpenSDKToMsdkManager.this.mSubMessageHandler.post(new Runnable() {
                        public void run() {
                            try {
                                CharSequence charSequence = tMAssistantDownloadSDKClient.getDownloadTaskState(str).mSavePath;
                                if (!TextUtils.isEmpty(charSequence)) {
                                    Message message = new Message();
                                    message.what = 0;
                                    message.obj = charSequence;
                                    TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                                }
                            } catch (Throwable e) {
                                v.a(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                            }
                        }
                    });
                } else if (5 == i) {
                    Message message = new Message();
                    message.what = 3;
                    TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                }
            }
        }

        public void OnDownloadSDKTaskProgressChanged(TMAssistantDownloadSDKClient tMAssistantDownloadSDKClient, String str, long j, long j2) {
            Message message = new Message();
            message.what = 1;
            Bundle bundle = new Bundle();
            bundle.putLong("receiveDataLen", j);
            bundle.putLong("totalDataLen", j2);
            message.setData(bundle);
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
        }
    };
    protected String mDownloadUrl = null;
    protected GetAuthorizedHttpRequest mHttpRequest = null;
    protected ac mMainMessageHandler = null;
    protected TMQQDownloaderOpenSDK mOpenSDK = null;
    protected IGetAuthorizedHttpRequestListenner mRequestListener = new IGetAuthorizedHttpRequestListenner() {
        public void onGetAuthorizedRequestFinished(AuthorizedResult authorizedResult, int i) {
            Message message = new Message();
            if (i != 0) {
                message.what = 5;
                message.obj = Integer.valueOf(i);
            } else if (authorizedResult != null) {
                message.what = 4;
                message.obj = authorizedResult;
            } else {
                return;
            }
            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
        }
    };
    protected ac mSubMessageHandler = null;
    protected HandlerThread mSubMessagehandlerThread = null;
    protected int mSupportVersionCode = 0;
    protected ITMOpenSDKToMsdkListener mToMsdkListener = null;
    protected OnClickListener negativeBtnListenner = new OnClickListener() {
        public void onClick(View view) {
            if (TMOpenSDKToMsdkManager.this.dialog.isShowing()) {
                TMOpenSDKToMsdkManager.this.dialog.dismiss();
                TMOpenSDKToMsdkManager.this.mHttpRequest = null;
            }
            TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            createTipsInfoLog.cancelBtnClickCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
            try {
                if (TMOpenSDKToMsdkManager.this.mClient != null) {
                    TMOpenSDKToMsdkManager.this.pauseDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl);
                }
            } catch (Throwable e) {
                v.a(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
            }
            if (TMOpenSDKToMsdkManager.this.authorizedState == 2) {
                TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(true, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            } else {
                TMOpenSDKToMsdkManager.this.notifyAuthorizedFinished(false, TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
            }
        }
    };
    protected OnClickListener positiveBtnListener = new OnClickListener() {
        public void onClick(View view) {
            if (TMOpenSDKToMsdkManager.this.mContext != null) {
                ActionButton actionButton = (ActionButton) view.getTag();
                try {
                    switch (TMOpenSDKToMsdkManager.this.mOpenSDK.checkQQDownloaderInstalled(TMOpenSDKToMsdkManager.this.mSupportVersionCode)) {
                        case 0:
                            try {
                                TMOpenSDKToMsdkManager.this.startToQQDownloaderAuthorized(actionButton.jumpUrl);
                                return;
                            } catch (Throwable e) {
                                v.a(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                                return;
                            }
                        case 1:
                            TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, actionButton.jumpUrl);
                            return;
                        case 2:
                            TMOpenSDKToMsdkManager.this.startDownloadTask(TMOpenSDKToMsdkManager.this.mDownloadUrl, actionButton.jumpUrl);
                            return;
                        default:
                            return;
                    }
                } catch (Throwable e2) {
                    v.a(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
                }
                v.a(TMOpenSDKToMsdkManager.TAG, e2, "", new Object[0]);
            }
        }
    };
    protected OnClickListener retryBtnListener = new OnClickListener() {
        public void onClick(View view) {
            if (TMOpenSDKToMsdkManager.this.mAuthorizedInfo != null) {
                if (TMOpenSDKToMsdkManager.this.mContext != null) {
                    TMOpenSDKToMsdkManager.this.getUserAuthorizedInfo(TMOpenSDKToMsdkManager.this.mAuthorizedInfo, TMOpenSDKToMsdkManager.this.mContext);
                }
                TMOpenSDKToMsdkManager.this.dialog.dismiss();
            }
        }
    };
    protected TMAssistantSDKChannel sdkChannel = null;

    private TMOpenSDKToMsdkManager(Context context) {
        this.mContext = context;
    }

    public static synchronized TMOpenSDKToMsdkManager getInstance(Context context) {
        TMOpenSDKToMsdkManager tMOpenSDKToMsdkManager;
        synchronized (TMOpenSDKToMsdkManager.class) {
            if (mInstance == null) {
                mInstance = new TMOpenSDKToMsdkManager(context);
            }
            tMOpenSDKToMsdkManager = mInstance;
        }
        return tMOpenSDKToMsdkManager;
    }

    public void initOpenSDK(ITMOpenSDKToMsdkListener iTMOpenSDKToMsdkListener) {
        this.mOpenSDK = TMQQDownloaderOpenSDK.getInstance();
        this.mOpenSDK.initQQDownloaderOpenSDK(this.mContext);
        this.mToMsdkListener = iTMOpenSDKToMsdkListener;
        this.sdkChannel = new TMAssistantSDKChannel();
        this.mSubMessagehandlerThread = new HandlerThread("OpenSDKToMsdkManager");
        this.mSubMessagehandlerThread.start();
        this.mSubMessageHandler = new ac(this.mSubMessagehandlerThread.getLooper());
        this.mMainMessageHandler = new ac(Looper.getMainLooper(), new a() {
            public boolean handleMessage(Message message) {
                Bundle data;
                switch (message.what) {
                    case 0:
                        int i = message.arg1;
                        TMOpenSDKToMsdkManager.this.handleInstall(message.obj.toString(), i);
                        break;
                    case 1:
                        data = message.getData();
                        if (data != null) {
                            TMOpenSDKToMsdkManager.this.handleDownloading(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                            break;
                        }
                        break;
                    case 3:
                        TMOpenSDKToMsdkManager.this.handleDownloadFailed();
                        break;
                    case 4:
                        AuthorizedResult authorizedResult = (AuthorizedResult) message.obj;
                        if (authorizedResult != null) {
                            TMOpenSDKToMsdkManager.this.onNetworkFinishedSuccess(authorizedResult);
                            break;
                        }
                        break;
                    case 5:
                        TMOpenSDKToMsdkManager.this.onNetworkFinishedFailed(((Integer) message.obj).intValue());
                        break;
                    case 6:
                        data = message.getData();
                        if (data != null) {
                            TMOpenSDKToMsdkManager.this.handleDownloadContinue(data.getLong("receiveDataLen"), data.getLong("totalDataLen"));
                            break;
                        }
                        break;
                }
                return false;
            }
        });
    }

    public void onDestroy() {
        if (this.dialog != null && this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        if (this.mOpenSDK != null) {
            this.mOpenSDK.destroyQQDownloaderOpenSDK();
        }
        this.mToMsdkListener = null;
        this.hasNotify = false;
        this.isInstallFinished = false;
        this.authorizedState = 0;
        this.mHttpRequest = null;
        this.mAuthorizedInfo = null;
        this.sdkChannel = null;
        this.insertActionId = -1;
        if (this.mContext != null) {
            TMAssistantDownloadSDKManager.closeAllService(this.mContext);
        }
        this.mClient = null;
    }

    public void onResume() {
        tryToCloseDialog();
        if (!this.hasNotify && this.authorizedState != 2) {
            if ((this.authorizedState == 3 || this.authorizedState == 0) && this.mContext != null) {
                getUserAuthorizedInfo(this.mAuthorizedInfo, this.mContext);
            }
        }
    }

    public void getUserAuthorizedInfo(TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo, Context context) {
        if (context != null) {
            this.mContext = context;
        }
        TMLog.i(TAG, "getUserAuthorizedInfo method called!");
        this.hasNotify = false;
        if (this.mHttpRequest != null) {
            TMLog.i(TAG, "mHttpRequest != null, request didn't finish!");
        } else if (tMOpenSDKAuthorizedInfo != null) {
            this.mAuthorizedInfo = tMOpenSDKAuthorizedInfo;
            if (this.mHttpRequest == null) {
                this.authorizedState = 1;
                this.mHttpRequest = new GetAuthorizedHttpRequest();
                this.mHttpRequest.setListenner(this.mRequestListener);
                this.mHttpRequest.sendRequest(tMOpenSDKAuthorizedInfo);
            }
        } else {
            TMLog.i(TAG, "AuthorizedInfo object is null!");
        }
    }

    protected void onNetworkFinishedSuccess(AuthorizedResult authorizedResult) {
        this.mDownloadUrl = authorizedResult.downloadUrl;
        this.mSupportVersionCode = authorizedResult.versionCode;
        this.mHttpRequest = null;
        TMLog.i(TAG, "onNetworkFinishedSuccess! authorizedResult.hasAuthoried=" + authorizedResult.hasAuthoried + "  listenner:" + this.mToMsdkListener + "  authroizedinfo:" + this.mAuthorizedInfo);
        if (authorizedResult.hasAuthoried == 1) {
            this.authorizedState = 2;
            if (authorizedResult.tipsInfo != null) {
                showDialog(authorizedResult.tipsInfo);
                return;
            } else {
                notifyAuthorizedFinished(true, this.mAuthorizedInfo);
                return;
            }
        }
        this.authorizedState = 3;
        if (authorizedResult.tipsInfo != null) {
            showDialog(authorizedResult.tipsInfo);
            return;
        }
        onServerException(authorizedResult.errorCode);
        TMLog.i(TAG, "not in white list and no tips!");
    }

    protected void onNetworkFinishedFailed(int i) {
        if (i == 606 || i == 602 || i == 601 || i == 704) {
            onServerException(i);
        } else {
            onNetworkException(i);
        }
    }

    protected void onServerException(int i) {
        if (this.mContext != null) {
            Res res = new Res(this.mContext);
            TipsInfo tipsInfo = new TipsInfo();
            tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
            if (i == 602 || i == 601) {
                tipsInfo.content = this.mContext.getString(res.string("white_list_network_error"));
            } else {
                tipsInfo.content = this.mContext.getString(res.string("white_list_server_error"));
            }
            ArrayList arrayList = new ArrayList();
            ActionButton actionButton = new ActionButton();
            actionButton.jumpType = 4;
            String string = this.mContext.getString(res.string("white_list_positive_retry_again"));
            actionButton.textInstalled = string;
            actionButton.textUninstalled = string;
            ActionButton actionButton2 = new ActionButton();
            actionButton2.jumpType = 3;
            String string2 = this.mContext.getString(res.string("white_list_negtive"));
            actionButton2.textInstalled = string2;
            actionButton2.textUninstalled = string2;
            arrayList.add(actionButton);
            arrayList.add(actionButton2);
            tipsInfo.actionButton = arrayList;
            showDialog(tipsInfo);
            this.mHttpRequest = null;
            this.mDownloadUrl = "";
            this.authorizedState = 3;
            TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
            createTipsInfoLog.networkErrorTipsCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        }
    }

    protected void onNetworkException(int i) {
        if (this.mContext != null) {
            String string;
            Res res = new Res(this.mContext);
            if (1 == i) {
                string = this.mContext.getString(res.string("white_list_network_not_connected"));
            } else {
                string = this.mContext.getString(res.string("white_list_network_error"));
            }
            TipsInfo tipsInfo = new TipsInfo();
            tipsInfo.title = this.mContext.getString(res.string("white_list_dlg_title"));
            tipsInfo.content = string;
            ArrayList arrayList = new ArrayList();
            ActionButton actionButton = new ActionButton();
            actionButton.jumpType = 3;
            arrayList.add(actionButton);
            String string2 = this.mContext.getString(res.string("white_list_negtive_known"));
            actionButton.textInstalled = string2;
            actionButton.textUninstalled = string2;
            tipsInfo.actionButton = arrayList;
            showDialog(tipsInfo);
            this.mHttpRequest = null;
            this.mDownloadUrl = "";
            this.authorizedState = 3;
            TMLog.i(TAG, "network error happened!");
            TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
            createTipsInfoLog.networkErrorTipsCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
        }
    }

    protected void notifyAuthorizedFinished(boolean z, TMOpenSDKAuthorizedInfo tMOpenSDKAuthorizedInfo) {
        TMLog.i(TAG, "before realy notifyAuthorizedFinished: TMOpenSDKAuthorizedInfo:" + this.mAuthorizedInfo);
        if (this.mToMsdkListener == null) {
            TMLog.i(TAG, "before notifyAuthorizedFinished: mToMsdkListener = null !");
        }
        if (this.mToMsdkListener != null && this.mAuthorizedInfo != null) {
            TMLog.i(TAG, "notifyAuthorizedFinished: result:" + z);
            this.mToMsdkListener.onAuthorizedFinished(z, this.mAuthorizedInfo);
            this.mHttpRequest = null;
            this.hasNotify = true;
        }
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    protected void showDialog(com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo r10) {
        /*
        r9 = this;
        r2 = 0;
        r0 = r9.mContext;
        if (r0 != 0) goto L_0x0006;
    L_0x0005:
        return;
    L_0x0006:
        r0 = r9.dialog;
        if (r0 == 0) goto L_0x0012;
    L_0x000a:
        r0 = r9.dialog;
        r0 = r0.isShowing();
        if (r0 != 0) goto L_0x0005;
    L_0x0012:
        r0 = r9.mContext;
        r0 = r0 instanceof android.app.Activity;
        if (r0 == 0) goto L_0x003b;
    L_0x0018:
        r0 = r9.mContext;
        r0 = (android.app.Activity) r0;
        r0 = r0.isFinishing();
        if (r0 == 0) goto L_0x003b;
    L_0x0022:
        r0 = "OpensdkToMsdkManager";
        r1 = new java.lang.StringBuilder;
        r2 = "context is finishing!  context";
        r1.<init>(r2);
        r2 = r9.mContext;
        r1 = r1.append(r2);
        r1 = r1.toString();
        com.tencent.tmassistantsdk.util.TMLog.i(r0, r1);
        goto L_0x0005;
    L_0x003b:
        r4 = new com.tencent.tmassistantsdk.util.Res;
        r0 = r9.mContext;
        r4.<init>(r0);
        if (r10 == 0) goto L_0x0005;
    L_0x0044:
        r5 = r10.actionButton;
        if (r5 == 0) goto L_0x0005;
    L_0x0048:
        r0 = r5.size();
        if (r0 <= 0) goto L_0x0005;
    L_0x004e:
        r0 = new com.tencent.tmassistantsdk.openSDK.opensdktomsdk.component.PopDialog;
        r1 = r9.mContext;
        r3 = "while_list_dialog";
        r3 = r4.style(r3);
        r6 = r5.size();
        r0.<init>(r1, r3, r6);
        r9.dialog = r0;
        r0 = r9.dialog;
        r0.show();
        r0 = r9.dialog;
        r1 = r10.title;
        r0.setTitle(r1);
        r0 = r9.dialog;
        r1 = r10.content;
        r0.setContent(r1);
        r1 = r2;
    L_0x0076:
        r0 = r5.size();
        if (r1 >= r0) goto L_0x0005;
    L_0x007c:
        r0 = r5.get(r1);
        r0 = (com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.ActionButton) r0;
        r3 = r0.jumpType;
        r6 = 3;
        if (r3 != r6) goto L_0x0099;
    L_0x0087:
        r3 = r9.dialog;
        r0 = r0.textInstalled;
        r3.setNegativeBtnText(r0);
        r0 = r9.dialog;
        r3 = r9.negativeBtnListenner;
        r0.setNegativeBtnClickListener(r3);
    L_0x0095:
        r0 = r1 + 1;
        r1 = r0;
        goto L_0x0076;
    L_0x0099:
        r3 = r0.jumpType;
        r6 = 4;
        if (r3 != r6) goto L_0x00ad;
    L_0x009e:
        r3 = r9.dialog;
        r0 = r0.textUninstalled;
        r3.setPositiveBtnText(r0);
        r0 = r9.dialog;
        r3 = r9.retryBtnListener;
        r0.setPositiveBtnClickListener(r3);
        goto L_0x0095;
    L_0x00ad:
        r3 = r9.mOpenSDK;	 Catch:{ Exception -> 0x00e4 }
        r6 = r9.mSupportVersionCode;	 Catch:{ Exception -> 0x00e4 }
        r3 = r3.checkQQDownloaderInstalled(r6);	 Catch:{ Exception -> 0x00e4 }
        switch(r3) {
            case 0: goto L_0x00c5;
            case 1: goto L_0x0107;
            case 2: goto L_0x00f1;
            default: goto L_0x00b8;
        };
    L_0x00b8:
        r3 = r9.dialog;
        r3.setPositiveBtnTag(r0);
        r0 = r9.dialog;
        r3 = r9.positiveBtnListener;
        r0.setPositiveBtnClickListener(r3);
        goto L_0x0095;
    L_0x00c5:
        r3 = r9.dialog;	 Catch:{ Exception -> 0x00e4 }
        r6 = r0.textInstalled;	 Catch:{ Exception -> 0x00e4 }
        r3.setPositiveBtnText(r6);	 Catch:{ Exception -> 0x00e4 }
        r3 = com.tencent.tmassistantsdk.logreport.TipsInfoReportManager.getInstance();	 Catch:{ Exception -> 0x00e4 }
        r6 = r9.mAuthorizedInfo;	 Catch:{ Exception -> 0x00e4 }
        r3 = r3.createTipsInfoLog(r6);	 Catch:{ Exception -> 0x00e4 }
        r6 = r3.authorizedTipsCount;	 Catch:{ Exception -> 0x00e4 }
        r6 = r6 + 1;
        r3.authorizedTipsCount = r6;	 Catch:{ Exception -> 0x00e4 }
        r6 = com.tencent.tmassistantsdk.logreport.TipsInfoReportManager.getInstance();	 Catch:{ Exception -> 0x00e4 }
        r6.addLogData(r3);	 Catch:{ Exception -> 0x00e4 }
        goto L_0x00b8;
    L_0x00e4:
        r3 = move-exception;
        r6 = "OpensdkToMsdkManager";
        r7 = "";
        r8 = new java.lang.Object[r2];
        com.tencent.mm.sdk.platformtools.v.a(r6, r3, r7, r8);
        goto L_0x00b8;
    L_0x00f1:
        r3 = r9.dialog;	 Catch:{ Exception -> 0x00e4 }
        r6 = r9.mContext;	 Catch:{ Exception -> 0x00e4 }
        r7 = "white_list_positive_update";
        r7 = r4.string(r7);	 Catch:{ Exception -> 0x00e4 }
        r6 = r6.getString(r7);	 Catch:{ Exception -> 0x00e4 }
        r3.setPositiveBtnText(r6);	 Catch:{ Exception -> 0x00e4 }
        r9.continueDownload();	 Catch:{ Exception -> 0x00e4 }
        goto L_0x00b8;
    L_0x0107:
        r3 = r9.dialog;	 Catch:{ Exception -> 0x00e4 }
        r6 = r0.textUninstalled;	 Catch:{ Exception -> 0x00e4 }
        r3.setPositiveBtnText(r6);	 Catch:{ Exception -> 0x00e4 }
        r9.continueDownload();	 Catch:{ Exception -> 0x00e4 }
        goto L_0x00b8;
        */
        throw new UnsupportedOperationException("Method not decompiled: com.tencent.tmassistantsdk.openSDK.opensdktomsdk.TMOpenSDKToMsdkManager.showDialog(com.tencent.tmassistantsdk.openSDK.opensdktomsdk.data.TipsInfo):void");
    }

    protected void continueDownload() {
        this.mSubMessageHandler.post(new Runnable() {
            public void run() {
                try {
                    TMAssistantDownloadTaskInfo downloadTaskState = TMOpenSDKToMsdkManager.this.getClient().getDownloadTaskState(TMOpenSDKToMsdkManager.this.mDownloadUrl);
                    if (downloadTaskState != null) {
                        Message message;
                        if (downloadTaskState.mState == 3) {
                            message = new Message();
                            message.what = 6;
                            Bundle bundle = new Bundle();
                            bundle.putLong("receiveDataLen", downloadTaskState.mReceiveDataLen);
                            bundle.putLong("totalDataLen", downloadTaskState.mTotalDataLen);
                            message.setData(bundle);
                            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                        } else if (downloadTaskState.mState == 4) {
                            message = new Message();
                            message.what = 0;
                            message.arg1 = 1;
                            message.obj = downloadTaskState.mSavePath;
                            TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                        }
                    }
                    TipsInfoLog createTipsInfoLog;
                    if (downloadTaskState == null || downloadTaskState.mState != 4) {
                        createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                        createTipsInfoLog.downloadTipsCount++;
                        TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                        return;
                    }
                    createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                    createTipsInfoLog.installTipsCount++;
                    TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                } catch (Throwable e) {
                    v.a(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                }
            }
        });
    }

    protected void tryToCloseDialog() {
        if (this.mOpenSDK != null && this.mContext != null) {
            try {
                int checkQQDownloaderInstalled = this.mOpenSDK.checkQQDownloaderInstalled(this.mSupportVersionCode);
                if (this.isInstallFinished && checkQQDownloaderInstalled == 0) {
                    this.mHttpRequest = null;
                    this.isInstallFinished = false;
                    this.mDownloadUrl = null;
                    if (this.dialog.isShowing()) {
                        this.dialog.dismiss();
                    }
                    TMAssistantDownloadSDKManager.closeAllService(this.mContext);
                    this.mClient = null;
                    if (isExitsAction(this.insertActionId)) {
                        this.mOpenSDK.startQQDownloader(this.mContext);
                    }
                }
            } catch (Throwable e) {
                v.a(TAG, e, "", new Object[0]);
            }
        }
    }

    protected boolean isExitsAction(long j) {
        if (j < 0) {
            return false;
        }
        if (this.sdkChannel == null) {
            return false;
        }
        Iterator it = this.sdkChannel.getChannelDataItemList().iterator();
        while (it.hasNext()) {
            TMAssistantSDKChannelDataItem tMAssistantSDKChannelDataItem = (TMAssistantSDKChannelDataItem) it.next();
            if (((long) tMAssistantSDKChannelDataItem.mDBIdentity) == j && tMAssistantSDKChannelDataItem.mDataItemEndTime - tMAssistantSDKChannelDataItem.mDataItemStartTime <= 300000) {
                return true;
            }
        }
        return false;
    }

    protected void handleInstall(String str, int i) {
        if (this.mContext != null) {
            Res res = new Res(this.mContext);
            this.dialog.setPositiveBtnEnable(true);
            this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_install")));
            if (this.mContext == null) {
                TMLog.i(TAG, "handleDownloading context = null!");
                return;
            }
            this.isInstallFinished = true;
            if (i != 1) {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setDataAndType(Uri.fromFile(new File(str)), "application/vnd.android.package-archive");
                this.mContext.startActivity(intent);
            }
        }
    }

    protected void handleDownloadFailed() {
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        Res res = new Res(this.mContext);
        this.dialog.setPositiveBtnEnable(true);
        this.dialog.downloadText.setText(this.mContext.getString(res.string("white_list_positive_retry")));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
    }

    protected void handleDownloading(long j, long j2) {
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        String string = this.mContext.getString(new Res(this.mContext).string("white_list_positive_downloading"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j)) + 0.0f) / ((float) j2))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j) + 0.0f) / ((float) j2)) * ((float) this.dialog.downloadProgressBar.getMax())));
        TMLog.i(TAG, "handleDownloading : receivedlen:" + j + " | totalLen:" + j2);
    }

    protected void handleDownloadContinue(long j, long j2) {
        if (this.mContext == null) {
            TMLog.i(TAG, "handleDownloading context = null!");
            return;
        }
        Res res = new Res(this.mContext);
        String string = this.mContext.getString(res.string("white_list_positive_continue"));
        this.dialog.downloadText.setText(string + ("(" + ((int) ((((float) (100 * j)) + 0.0f) / ((float) j2))) + "%)"));
        this.dialog.downloadProgressBar.setProgress((int) (((((float) j) + 0.0f) / ((float) j2)) * ((float) this.dialog.downloadProgressBar.getMax())));
        if (this.dialog.downloadProgressBar.getProgress() > 0) {
            this.dialog.setPositiveBtnBgResource(res.drawable("com_tencent_tmassistant_sdk_button_bg"));
        }
    }

    protected void startToQQDownloaderAuthorized(String str) {
        if (this.dialog.isShowing()) {
            this.dialog.dismiss();
        }
        this.mHttpRequest = null;
        this.isInstallFinished = false;
        if (!TextUtils.isEmpty(str)) {
            TipsInfoLog createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(this.mAuthorizedInfo);
            createTipsInfoLog.authorizedBtnClickCount++;
            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
            if (this.mContext != null && this.mOpenSDK != null) {
                this.mOpenSDK.startToAuthorized(this.mContext, str);
            }
        }
    }

    protected void startDownloadTask(final String str, final String str2) {
        if (!TextUtils.isEmpty(str)) {
            this.dialog.setPositiveBtnEnable(false);
            this.mSubMessageHandler.post(new Runnable() {
                public void run() {
                    if (!(TMOpenSDKToMsdkManager.this.mContext == null || TMOpenSDKToMsdkManager.this.mOpenSDK == null || TextUtils.isEmpty(str2))) {
                        TMOpenSDKToMsdkManager.this.insertActionId = TMOpenSDKToMsdkManager.this.mOpenSDK.addDownloadTaskFromAuthorize(str2);
                    }
                    TMAssistantDownloadSDKClient client = TMOpenSDKToMsdkManager.this.getClient();
                    if (client != null) {
                        try {
                            int startDownloadTask = client.startDownloadTask(str, "application/vnd.android.package-archive");
                            if (4 == startDownloadTask) {
                                String str = client.getDownloadTaskState(str).mSavePath;
                                Message message = new Message();
                                message.what = 0;
                                message.obj = str;
                                TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(message);
                            } else if (startDownloadTask == 0) {
                                TMLog.i(TMOpenSDKToMsdkManager.TAG, "start success!");
                            } else if (1 == startDownloadTask) {
                                r0 = new Message();
                                r0.what = 5;
                                r0.obj = Integer.valueOf(1);
                                TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(r0);
                            } else {
                                r0 = new Message();
                                r0.what = 3;
                                TMOpenSDKToMsdkManager.this.mMainMessageHandler.sendMessage(r0);
                            }
                            TipsInfoLog createTipsInfoLog;
                            if (startDownloadTask == 4) {
                                createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                                createTipsInfoLog.installBtnClickCount++;
                                TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                                return;
                            }
                            createTipsInfoLog = TipsInfoReportManager.getInstance().createTipsInfoLog(TMOpenSDKToMsdkManager.this.mAuthorizedInfo);
                            createTipsInfoLog.downloadBtnClickCount++;
                            TipsInfoReportManager.getInstance().addLogData(createTipsInfoLog);
                        } catch (Throwable e) {
                            v.a(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                        }
                    }
                }
            });
        }
    }

    protected void pauseDownloadTask(final String str) {
        if (!TextUtils.isEmpty(str) && this.mAuthorizedInfo != null) {
            this.mSubMessageHandler.post(new Runnable() {
                public void run() {
                    TMAssistantDownloadSDKClient client = TMOpenSDKToMsdkManager.this.getClient();
                    try {
                        if (client.getDownloadTaskState(str) != null) {
                            client.pauseDownloadTask(str);
                        } else {
                            TMLog.i(TMOpenSDKToMsdkManager.TAG, "getDownloadTaskState taskinfo is null!");
                        }
                    } catch (Throwable e) {
                        v.a(TMOpenSDKToMsdkManager.TAG, e, "", new Object[0]);
                    }
                }
            });
        }
    }

    protected TMAssistantDownloadSDKClient getClient() {
        if (this.mContext == null) {
            return null;
        }
        if (this.mClient != null) {
            return this.mClient;
        }
        TMAssistantDownloadSDKClient downloadSDKClient = TMAssistantDownloadSDKManager.getInstance(this.mContext).getDownloadSDKClient(CLIENT_NAME);
        downloadSDKClient.registerDownloadTaskListener(this.mDownloadSDKListener);
        this.mClient = downloadSDKClient;
        return downloadSDKClient;
    }

    public static String about() {
        return "TMOpenSDKToMsdkManager_2014_04_01_19_51_release_25434";
    }
}
