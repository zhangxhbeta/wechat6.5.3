package com.tencent.mm.pluginsdk.model.app;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.model.ak;
import com.tencent.mm.sdk.a.a.a;
import com.tencent.mm.sdk.modelmsg.b.b;
import com.tencent.mm.sdk.modelmsg.c;
import com.tencent.mm.sdk.platformtools.r;

public final class ReportUtil {

    public static class ReportArgs implements Parcelable {
        public static final Creator<ReportArgs> CREATOR = new Creator<ReportArgs>() {
            public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                return new ReportArgs(parcel);
            }

            public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
                return new ReportArgs[i];
            }
        };
        public String bfm;
        public int errCode;
        public String lBj;
        public int of;
        public String tX;

        public int describeContents() {
            return 0;
        }

        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.tX);
            parcel.writeInt(this.errCode);
            parcel.writeString(this.lBj);
            parcel.writeString(this.bfm);
        }

        private ReportArgs(Parcel parcel) {
            this.tX = parcel.readString();
            this.errCode = parcel.readInt();
            this.lBj = parcel.readString();
            this.bfm = parcel.readString();
        }
    }

    public static void a(Context context, ReportArgs reportArgs) {
        if (reportArgs.of == 1) {
            b bVar = new b();
            bVar.lBj = reportArgs.lBj;
            bVar.errCode = reportArgs.errCode;
            bVar.bfm = reportArgs.bfm;
            Bundle bundle = new Bundle();
            bVar.t(bundle);
            p.R(bundle);
            a aVar = new a();
            aVar.nhj = reportArgs.tX;
            aVar.nhl = bundle;
            com.tencent.mm.sdk.a.a.a(context, aVar);
            return;
        }
        c.b bVar2 = new c.b();
        bVar2.errCode = reportArgs.errCode;
        bVar2.lBj = reportArgs.lBj;
        bVar2.bfm = reportArgs.bfm;
        bundle = new Bundle();
        bVar2.t(bundle);
        p.R(bundle);
        aVar = new a();
        aVar.nhj = reportArgs.tX;
        aVar.nhl = bundle;
        com.tencent.mm.sdk.a.a.a(context, aVar);
    }

    public static ReportArgs a(Bundle bundle, int i) {
        String string = bundle.getString("SendAppMessageWrapper_AppId");
        if (string == null) {
            String string2 = bundle.getString("_mmessage_content");
            if (string2 != null) {
                string = Uri.parse(string2).getQueryParameter("appid");
            }
        }
        if (string == null) {
            string = r.c(bundle, "_wxapi_payreq_appid");
            if (string == null) {
                return null;
            }
        }
        com.tencent.mm.sdk.h.c fVar = new f();
        fVar.field_appId = string;
        if (ak.uN() && ak.uz()) {
            am.bnB().b(fVar, new String[0]);
        } else {
            fVar.field_packageName = bundle.getString("_mmessage_appPackage");
        }
        ReportArgs reportArgs = new ReportArgs();
        reportArgs.tX = fVar.field_packageName;
        reportArgs.errCode = i;
        c.a aVar = new c.a();
        aVar.u(bundle);
        reportArgs.lBj = aVar.lBj;
        reportArgs.bfm = fVar.field_openId;
        reportArgs.of = bundle.getInt("_wxapi_command_type");
        return reportArgs;
    }
}
