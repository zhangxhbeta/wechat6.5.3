package com.tencent.tmassistantsdk.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsRequest;
import com.tencent.tmassistantsdk.protocol.jce.GetSettingsResponse;
import com.tencent.tmassistantsdk.util.TMLog;

public class GetSettingHttpRequest extends PostHttpRequest {
    protected static final String TAG = "GetSettingHttpRequest";
    protected IGetSettingHttpListener mListener = null;

    public void setGetSettingHttpListener(IGetSettingHttpListener iGetSettingHttpListener) {
        this.mListener = iGetSettingHttpListener;
    }

    public void sendSettingRequest() {
        super.sendRequest(new GetSettingsRequest());
    }

    protected void onFinished(JceStruct jceStruct, JceStruct jceStruct2, int i) {
        if (jceStruct2 == null) {
            TMLog.i(TAG, "response is null!");
        } else if (this.mListener != null && i == 0 && (jceStruct2 instanceof GetSettingsResponse)) {
            GetSettingsResponse getSettingsResponse = (GetSettingsResponse) jceStruct2;
            if (getSettingsResponse.ret == 0) {
                this.mListener.onSettingHttpRequestFinish((GetSettingsRequest) jceStruct, getSettingsResponse, true);
            } else {
                this.mListener.onSettingHttpRequestFinish((GetSettingsRequest) jceStruct, getSettingsResponse, false);
            }
        }
    }
}
