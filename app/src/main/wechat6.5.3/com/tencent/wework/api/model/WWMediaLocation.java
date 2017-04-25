package com.tencent.wework.api.model;

import android.os.Bundle;
import com.tencent.wework.api.model.WWMediaMessage.WWMediaObject;

public class WWMediaLocation extends WWMediaObject {
    public String cJf;
    public double latitude;
    public double longitude;
    public double pKa;

    public final boolean checkArgs() {
        if (super.checkArgs() && this.cJf != null && this.cJf.length() != 0 && this.cJf.length() <= 10240) {
            return true;
        }
        return false;
    }

    public final void t(Bundle bundle) {
        bundle.putString("_wwlocobject_address", this.cJf);
        bundle.putDouble("_wwlocobject_longitude", this.longitude);
        bundle.putDouble("_wwlocobject_latitude", this.latitude);
        bundle.putDouble("_wwlocobject_zoom", this.pKa);
        super.t(bundle);
    }
}
