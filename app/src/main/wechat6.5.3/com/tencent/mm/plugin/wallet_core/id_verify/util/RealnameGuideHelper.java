package com.tencent.mm.plugin.wallet_core.id_verify.util;

import android.app.Activity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.ui.MMActivity;

public class RealnameGuideHelper implements Parcelable {
    public static final Creator<RealnameGuideHelper> CREATOR = new Creator<RealnameGuideHelper>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new RealnameGuideHelper(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new RealnameGuideHelper[i];
        }
    };
    private int cKI;
    private String hck;
    private String hcl;
    private String hcm = "";
    private String hcn = "";
    private String hco = "";
    private boolean kMC = false;

    public RealnameGuideHelper(Parcel parcel) {
        this.hck = parcel.readString();
        this.hcl = parcel.readString();
        this.hcm = parcel.readString();
        this.hcn = parcel.readString();
        this.hco = parcel.readString();
        this.cKI = parcel.readInt();
    }

    public final void a(String str, String str2, String str3, String str4, String str5, int i) {
        this.hck = str;
        this.hcl = str2;
        this.hcm = str3;
        this.hcn = str4;
        this.hco = str5;
        this.cKI = i;
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener) {
        return a(mMActivity, bundle, onClickListener, false);
    }

    public final boolean a(MMActivity mMActivity, Bundle bundle, OnClickListener onClickListener, boolean z) {
        if (!this.kMC) {
            this.kMC = true;
            if ("1".equals(this.hck)) {
                return a.a((Activity) mMActivity, this.hcl, this.hcm, this.hcn, bundle, z, onClickListener, this.cKI, 1);
            } else if ("2".equals(this.hck) && !be.kS(this.hco)) {
                return a.a((Activity) mMActivity, this.hcl, this.hco, this.hcm, this.hcn, z, onClickListener);
            }
        }
        return false;
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.hck);
        parcel.writeString(this.hcl);
        parcel.writeString(this.hcm);
        parcel.writeString(this.hcn);
        parcel.writeString(this.hco);
        parcel.writeInt(this.cKI);
    }
}
