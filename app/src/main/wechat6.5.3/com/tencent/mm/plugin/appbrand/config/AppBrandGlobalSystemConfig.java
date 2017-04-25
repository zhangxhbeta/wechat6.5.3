package com.tencent.mm.plugin.appbrand.config;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.a.e;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

public final class AppBrandGlobalSystemConfig implements Parcelable {
    public static final Creator<AppBrandGlobalSystemConfig> CREATOR = new Creator<AppBrandGlobalSystemConfig>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new AppBrandGlobalSystemConfig(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new AppBrandGlobalSystemConfig[i];
        }
    };
    private static volatile AppBrandGlobalSystemConfig dCY;
    private static volatile int dCZ;
    public static final AppBrandGlobalSystemConfig dYV;
    public int dDa;
    public int dDb;
    public int dDc;
    public int dDd;
    public String dDe;
    public HttpSetting dDf;
    public int nPE;

    public static final class HttpSetting implements Parcelable {
        public static final Creator<HttpSetting> CREATOR = new Creator<HttpSetting>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new HttpSetting(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new HttpSetting[i];
            }
        };
        public ArrayList<String> dDg;
        public ArrayList<String> dDh;
        public int dDi;
        public int dDj;
        public int dDk;
        public int dDl;
        public String dDm;
        public int mode;

        public final int describeContents() {
            return 0;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeInt(this.mode);
            parcel.writeStringList(this.dDg);
            parcel.writeStringList(this.dDh);
            parcel.writeInt(this.dDi);
            parcel.writeInt(this.dDj);
            parcel.writeInt(this.dDk);
            parcel.writeInt(this.dDl);
            parcel.writeString(this.dDm);
        }

        HttpSetting(Parcel parcel) {
            this.mode = parcel.readInt();
            this.dDg = parcel.createStringArrayList();
            this.dDh = parcel.createStringArrayList();
            this.dDi = parcel.readInt();
            this.dDj = parcel.readInt();
            this.dDk = parcel.readInt();
            this.dDl = parcel.readInt();
            this.dDm = parcel.readString();
        }
    }

    static {
        AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
        dYV = appBrandGlobalSystemConfig;
        appBrandGlobalSystemConfig.dDb = 5;
        dYV.dDc = 300;
        dYV.dDd = 10;
        dYV.nPE = 1048576;
    }

    public static AppBrandGlobalSystemConfig Py() {
        String aV;
        try {
            aV = e.aV(f.Pz());
        } catch (IOException e) {
            v.e("MicroMsg.AppBrandGlobalSystemConfig", "read config file, exp = %s", new Object[]{e});
            aV = null;
        }
        if (be.kS(aV)) {
            return null;
        }
        int hashCode = aV.hashCode();
        if (dCZ == hashCode && dCY != null) {
            return dCY;
        }
        dCY = na(aV);
        dCZ = hashCode;
        return dCY;
    }

    private static AppBrandGlobalSystemConfig na(String str) {
        v.d("MicroMsg.AppBrandGlobalSystemConfig", "parse json = %s", new Object[]{str});
        try {
            JSONObject jSONObject = new JSONObject(str);
            AppBrandGlobalSystemConfig appBrandGlobalSystemConfig = new AppBrandGlobalSystemConfig();
            JSONObject optJSONObject = jSONObject.optJSONObject("HTTPSetting");
            if (optJSONObject != null) {
                int i;
                appBrandGlobalSystemConfig.dDf = new HttpSetting();
                String optString = optJSONObject.optString("HTTPHeaderMode", "");
                if (optString.equals("BlackList")) {
                    appBrandGlobalSystemConfig.dDf.mode = 1;
                } else if (optString.equals("WhiteList")) {
                    appBrandGlobalSystemConfig.dDf.mode = 2;
                }
                JSONArray optJSONArray = optJSONObject.optJSONArray("HeaderBlackList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.dDf.dDg = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.dDf.dDg.add(optJSONArray.getString(i));
                    }
                }
                optJSONArray = optJSONObject.optJSONArray("HeaderWhiteList");
                if (optJSONArray != null) {
                    appBrandGlobalSystemConfig.dDf.dDh = new ArrayList();
                    for (i = 0; i < optJSONArray.length(); i++) {
                        appBrandGlobalSystemConfig.dDf.dDh.add(optJSONArray.getString(i));
                    }
                }
                appBrandGlobalSystemConfig.dDf.dDi = optJSONObject.optInt("WebsocketMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.dDf.dDj = optJSONObject.optInt("UploadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.dDf.dDk = optJSONObject.optInt("DownloadMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.dDf.dDl = optJSONObject.optInt("RequestMaxTimeoutMS", -1);
                appBrandGlobalSystemConfig.dDf.dDm = optJSONObject.optString("HTTPHeaderReferer");
            }
            appBrandGlobalSystemConfig.dDe = jSONObject.optString("CDNBaseURL");
            appBrandGlobalSystemConfig.dDb = jSONObject.optInt("AppMaxRunningCount", 5);
            appBrandGlobalSystemConfig.dDc = jSONObject.optInt("TempFileSizeLimitTotal", 300);
            appBrandGlobalSystemConfig.dDd = jSONObject.optInt("DownloadFileSizeLimit", 10);
            appBrandGlobalSystemConfig.nPE = jSONObject.optInt("MaxLocalStorageItemSize", 1048576);
            return appBrandGlobalSystemConfig;
        } catch (Throwable e) {
            v.e("MicroMsg.AppBrandGlobalSystemConfig", "parse exception = %s", new Object[]{be.e(e)});
            return null;
        }
    }

    private AppBrandGlobalSystemConfig() {
        this.dDa = Integer.MAX_VALUE;
    }

    public final int describeContents() {
        return 0;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.dDa);
        parcel.writeInt(this.dDb);
        parcel.writeInt(this.dDc);
        parcel.writeInt(this.dDd);
        parcel.writeInt(this.nPE);
        parcel.writeString(this.dDe);
        parcel.writeParcelable(this.dDf, i);
    }

    private AppBrandGlobalSystemConfig(Parcel parcel) {
        this.dDa = Integer.MAX_VALUE;
        this.dDa = parcel.readInt();
        this.dDb = parcel.readInt();
        this.dDc = parcel.readInt();
        this.dDd = parcel.readInt();
        this.nPE = parcel.readInt();
        this.dDe = parcel.readString();
        this.dDf = (HttpSetting) parcel.readParcelable(HttpSetting.class.getClassLoader());
    }
}
