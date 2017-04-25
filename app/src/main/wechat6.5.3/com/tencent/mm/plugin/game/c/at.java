package com.tencent.mm.plugin.game.c;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.tencent.mm.pluginsdk.model.app.p;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadclient.TMAssistantDownloadTaskInfo;
import com.tencent.tmassistantsdk.openSDK.ITMQQDownloaderOpenSDKListener;
import com.tencent.tmassistantsdk.openSDK.OpenSDKTool4Assistant;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDK;
import com.tencent.tmassistantsdk.openSDK.TMQQDownloaderOpenSDKParam;
import org.json.JSONObject;

public class at {
    private static at gjV;
    private static TMQQDownloaderOpenSDK gjW;

    private static final class a {
        public String SNGAppId;
        public String actionFlag;
        public String gjX;
        public String taskApkId;
        public String taskAppId;
        public String taskPackageName;
        public int taskVersion;
        public String uin;
        public String uinType;
        public String via;

        private a() {
        }

        public final TMQQDownloaderOpenSDKParam uk(String str) {
            v.i("MicroMsg.QQDownloaderSDKWrapper", "params is : [%s]", new Object[]{str});
            if (be.kS(str)) {
                v.e("MicroMsg.QQDownloaderSDKWrapper", "params is null or nil");
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(str);
                    this.taskApkId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APKID);
                    this.via = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_VIA);
                    this.taskVersion = jSONObject.optInt(OpenSDKTool4Assistant.EXTRA_TASK_VERSION);
                    this.gjX = jSONObject.optString("channelID");
                    this.uin = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UIN);
                    this.SNGAppId = jSONObject.optString("SNGAppId");
                    this.taskAppId = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_APPID);
                    this.uinType = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_UINTYPE);
                    this.taskPackageName = jSONObject.optString(OpenSDKTool4Assistant.EXTRA_TASK_PACKAGENAME);
                    this.actionFlag = jSONObject.optString("actionFlag");
                } catch (Exception e) {
                    v.e("MicroMsg.QQDownloaderSDKWrapper", "parse parms failed:[%s]", new Object[]{e.getMessage()});
                }
            }
            return new TMQQDownloaderOpenSDKParam(this.SNGAppId, this.taskAppId, this.taskApkId, this.taskVersion, this.via, this.taskPackageName, this.uin, this.uinType, this.gjX, this.actionFlag);
        }
    }

    private at() {
    }

    public static at arX() {
        if (gjV == null) {
            synchronized (at.class) {
                if (gjV == null) {
                    gjV = new at();
                }
            }
        }
        return gjV;
    }

    private static TMQQDownloaderOpenSDK arY() {
        if (gjW == null) {
            TMQQDownloaderOpenSDK instance = TMQQDownloaderOpenSDK.getInstance();
            gjW = instance;
            instance.initQQDownloaderOpenSDK(aa.getContext());
        }
        return gjW;
    }

    public static void arZ() {
        boolean z = false;
        String str = "MicroMsg.QQDownloaderSDKWrapper";
        String str2 = "destroyQQDownloader, sdk is null : [%b], instance is null : [%b]";
        Object[] objArr = new Object[2];
        objArr[0] = Boolean.valueOf(gjW == null);
        if (gjV == null) {
            z = true;
        }
        objArr[1] = Boolean.valueOf(z);
        v.i(str, str2, objArr);
        if (gjW != null) {
            gjW.destroyQQDownloaderOpenSDK();
        }
        gjW = null;
        gjV = null;
    }

    public static void V(Context context, String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, params is null or nil");
        } else if (context == null) {
            v.e("MicroMsg.QQDownloaderSDKWrapper", "add download task failed, context is null");
        } else {
            v.i("MicroMsg.QQDownloaderSDKWrapper", "add download task to qqdownloader:[%s]", new Object[]{str});
            TMQQDownloaderOpenSDKParam uk = new a().uk(str);
            try {
                arX();
                arY().startToDownloadTaskList(context, uk, true, true);
            } catch (Throwable e) {
                v.a("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
            }
        }
    }

    public static void startToDownloadTaskList(Context context) {
        try {
            arX();
            arY().startToDownloadTaskList(context);
        } catch (Throwable e) {
            v.a("MicroMsg.QQDownloaderSDKWrapper", e, "", new Object[0]);
        }
    }

    public static int uj(String str) {
        if (!be.kS(str)) {
            return a(new a().uk(str));
        }
        v.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
        return -1;
    }

    private static int a(TMQQDownloaderOpenSDKParam tMQQDownloaderOpenSDKParam) {
        try {
            arX();
            TMAssistantDownloadTaskInfo downloadTaskState = arY().getDownloadTaskState(tMQQDownloaderOpenSDKParam);
            if (downloadTaskState != null) {
                return downloadTaskState.mState;
            }
        } catch (Exception e) {
            v.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus failed : %s", new Object[]{e.getMessage()});
        }
        return -1;
    }

    public static int e(Context context, String str, int i) {
        int i2 = -1;
        if (be.kS(str)) {
            v.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, packageName is null");
        } else {
            try {
                PackageInfo av = p.av(context, str);
                if (av == null) {
                    i2 = 1;
                } else {
                    v.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, installed versionCode = %d", new Object[]{Integer.valueOf(av.versionCode)});
                    i2 = av.versionCode >= i ? 0 : 2;
                }
            } catch (Exception e) {
                v.e("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState fail, ex = %s", new Object[]{e.getMessage()});
            }
            v.d("MicroMsg.QQDownloaderSDKWrapper", "getAppInstallState, ret = %d", new Object[]{Integer.valueOf(i2)});
        }
        return i2;
    }

    public static void startToAuthorized(Context context, String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.QQDownloaderSDKWrapper", "queryQQDownloadTaskStatus, params is null or nil");
            return;
        }
        TMQQDownloaderOpenSDKParam uk = new a().uk(str);
        try {
            arX();
            arY().startToAuthorized(context, uk, "1");
        } catch (Exception e) {
            v.e("MicroMsg.QQDownloaderSDKWrapper", "startToAuthorized fail, ex = %s", new Object[]{e.getMessage()});
        }
    }

    public static boolean registerListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        arX();
        return arY().registerListener(iTMQQDownloaderOpenSDKListener);
    }

    public static boolean unregisterListener(ITMQQDownloaderOpenSDKListener iTMQQDownloaderOpenSDKListener) {
        arX();
        return arY().unregisterListener(iTMQQDownloaderOpenSDKListener);
    }
}
