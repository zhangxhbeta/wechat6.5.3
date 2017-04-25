package com.tencent.mm.plugin.game.c;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import com.tencent.tmassistantsdk.openSDK.QQDownloader.AssistantStore.DownloadInfos.DownloadInfoColumns;
import com.tencent.tmassistantsdk.storage.table.DownloadSettingTable.Columns;
import java.util.LinkedList;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class f {
    JSONObject ghN = new JSONObject();

    protected f(String str) {
        if (be.kS(str)) {
            v.e("MicroMsg.GameServerData", "Null or nil json string");
            return;
        }
        try {
            this.ghN = new JSONObject(str);
        } catch (JSONException e) {
            v.e("MicroMsg.GameServerData", "Json parsing error");
        }
    }

    protected final JSONArray optJSONArray(String str) {
        return this.ghN.optJSONArray(str);
    }

    private static String b(JSONObject jSONObject, String str) {
        if (jSONObject == null || jSONObject.isNull(str)) {
            return null;
        }
        return jSONObject.optString(str);
    }

    protected static LinkedList<c> l(JSONArray jSONArray) {
        LinkedList<c> linkedList = new LinkedList();
        if (jSONArray == null || jSONArray.length() == 0) {
            v.i("MicroMsg.GameServerData", "Null or empty json array");
            return linkedList;
        }
        v.i("MicroMsg.GameServerData", "Parsing json AppInfo, size: %d", new Object[]{Integer.valueOf(jSONArray.length())});
        for (int i = 0; i < jSONArray.length(); i++) {
            Object obj;
            JSONObject optJSONObject = jSONArray.optJSONObject(i);
            if (optJSONObject == null) {
                v.e("MicroMsg.GameServerData", "Invalid json object");
                obj = null;
            } else {
                JSONObject optJSONObject2 = optJSONObject.optJSONObject("YYB");
                String b = b(optJSONObject, "appID");
                if (be.kS(b)) {
                    v.e("MicroMsg.GameServerData", "No AppID field, abort");
                    obj = null;
                } else {
                    v.i("MicroMsg.GameServerData", "Parsing AppID: %s", new Object[]{b});
                    obj = new c();
                    obj.field_appId = b;
                    obj.field_appName = b(optJSONObject, "name");
                    obj.field_appIconUrl = b(optJSONObject, "iconURL");
                    obj.field_appType = ",1,";
                    obj.field_packageName = b(optJSONObject, "AndroidPackageName");
                    obj.bE(b(optJSONObject, "downloadURL"));
                    obj.bH(b(optJSONObject, "AndroidApkMd5"));
                    b = b(optJSONObject, "GooglePlayDownloadUrl");
                    int optInt = optJSONObject.optInt("GooglePlayDownloadFlag");
                    obj.bI(b);
                    if (!be.kS(b)) {
                        v.i("MicroMsg.GameServerData", "GooglePlay URL: %s, Download Flag: %d", new Object[]{b, Integer.valueOf(optInt)});
                        obj.cN(optInt);
                    }
                    if (optJSONObject2 != null) {
                        obj.cN(optJSONObject2.optInt("AndroidDownloadFlag"));
                    }
                    if (optJSONObject2 != null) {
                        obj.bN(b(optJSONObject2, "DownloadUrl"));
                        obj.bO(b(optJSONObject2, "ApkMd5"));
                        obj.bL(b(optJSONObject2, "PreemptiveUrl"));
                        obj.bM(b(optJSONObject2, "ExtInfo"));
                        obj.cO(optJSONObject2.optInt("SupportedVersionCode"));
                    }
                    obj.ghn = b(optJSONObject, "desc");
                    obj.ghm = b(optJSONObject, "brief");
                    obj.type = optJSONObject.optInt(Columns.TYPE, 0);
                    obj.status = optJSONObject.optInt(DownloadInfo.STATUS);
                    obj.ghp = b(optJSONObject, "webURL");
                    obj.ghq = b(optJSONObject, "adUrl");
                    obj.bln = b(optJSONObject, "noticeid");
                    obj.ghr = optJSONObject.optBoolean("isSubscribed");
                    obj.versionCode = optJSONObject.optInt(DownloadInfoColumns.VERSIONCODE);
                    if (optJSONObject2 != null) {
                        obj.ghs = b(optJSONObject2, "DownloadTipsWording");
                        obj.ght = b(optJSONObject2, "BackBtnWording");
                        obj.ghu = b(optJSONObject2, "DownloadBtnWording");
                    }
                }
            }
            if (obj != null) {
                linkedList.add(obj);
            }
        }
        return linkedList;
    }
}
