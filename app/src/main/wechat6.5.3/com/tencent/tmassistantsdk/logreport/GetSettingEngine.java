package com.tencent.tmassistantsdk.logreport;

import com.tencent.tmassistantsdk.network.GetSettingHttpRequest;
import com.tencent.tmassistantsdk.network.IGetSettingHttpListener;
import com.tencent.tmassistantsdk.protocol.ProtocolPackage;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.protocol.jce.SettingsCfg;
import com.tencent.tmassistantsdk.protocol.jce.StatCfg;
import com.tencent.tmassistantsdk.util.GlobalUtil;
import com.tencent.tmassistantsdk.util.TMLog;

public class GetSettingEngine implements IGetSettingHttpListener {
    protected static final String TAG = "GetSettingEngine";
    protected static GetSettingEngine mInstance = null;
    protected GetSettingHttpRequest httpRequest = null;

    protected GetSettingEngine() {
    }

    public static synchronized GetSettingEngine getInstance() {
        GetSettingEngine getSettingEngine;
        synchronized (GetSettingEngine.class) {
            if (mInstance == null) {
                mInstance = new GetSettingEngine();
            }
            getSettingEngine = mInstance;
        }
        return getSettingEngine;
    }

    public synchronized void cancleRequest() {
        if (this.httpRequest != null) {
            this.httpRequest.cancleRequest();
            this.httpRequest = null;
        }
    }

    public void sendRequest() {
        if (this.httpRequest == null) {
            this.httpRequest = new GetSettingHttpRequest();
            this.httpRequest.setGetSettingHttpListener(this);
            this.httpRequest.sendSettingRequest();
        }
    }

    public void onSettingHttpRequestFinish(GetSettingsRequest getSettingsRequest, GetSettingsResponse getSettingsResponse, boolean z) {
        this.httpRequest = null;
        if (z) {
            if (getSettingsResponse.settings != null && getSettingsResponse.settings.size() > 0) {
                SettingsCfg settingsCfg = (SettingsCfg) getSettingsResponse.settings.get(0);
                if (!(settingsCfg == null || settingsCfg.cfg == null)) {
                    StatCfg statCfg = (StatCfg) ProtocolPackage.bytes2JceObj(settingsCfg.cfg, StatCfg.class);
                    if (statCfg != null) {
                        GlobalUtil.getInstance().setNetTypeValue(statCfg.netType);
                    } else {
                        TMLog.i(TAG, "response  StatCfg is null !");
                    }
                }
            }
            TMLog.i(TAG, "response.settings is null !");
            return;
        }
        TMLog.i(TAG, "get settings failed!");
    }
}
