package com.tencent.tmassistantsdk.protocol.jce;

import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceOutputStream;
import com.qq.taf.jce.JceStruct;
import java.util.ArrayList;

public final class GetAppSimpleDetailRequest extends JceStruct {
    static ArrayList<AppDetailParam> cache_appReqList;
    public ArrayList<AppDetailParam> appReqList = null;

    public GetAppSimpleDetailRequest(ArrayList<AppDetailParam> arrayList) {
        this.appReqList = arrayList;
    }

    public final void writeTo(JceOutputStream jceOutputStream) {
        if (this.appReqList != null) {
            jceOutputStream.write(this.appReqList, 0);
        }
    }

    public final void readFrom(JceInputStream jceInputStream) {
        if (cache_appReqList == null) {
            cache_appReqList = new ArrayList();
            cache_appReqList.add(new AppDetailParam());
        }
        this.appReqList = (ArrayList) jceInputStream.read(cache_appReqList, 0, false);
    }
}
