package com.tencent.mm.plugin.wallet_core.model;

import android.content.Context;
import android.database.Cursor;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.mm.e.b.da;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.v;
import java.lang.reflect.Field;

public class Bankcard extends da implements Parcelable {
    public static final Creator<Bankcard> CREATOR = new Creator<Bankcard>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new Bankcard(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new Bankcard[i];
        }
    };
    public static a chq;
    public static int kNl = 1;
    public static int kNm = 2;
    public static int kNn = 4;
    public static int kNo = 8;
    public static int kNp = 22;
    public int kMU;
    public String kMW;
    public String kNA;
    public String kNB;
    public boolean kNC;
    public d kND;
    public String kNq;
    public String kNr;
    public String kNs;
    public String kNt;
    public String kNu;
    public double kNv;
    public String kNw;
    public double kNx;
    public String kNy;
    public String kNz;

    static {
        a aVar = new a();
        aVar.ddU = new Field[34];
        aVar.bXK = new String[35];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "bindSerial";
        aVar.nmd.put("bindSerial", "TEXT PRIMARY KEY ");
        stringBuilder.append(" bindSerial TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "bindSerial";
        aVar.bXK[1] = "cardType";
        aVar.nmd.put("cardType", "INTEGER");
        stringBuilder.append(" cardType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[2] = "bankcardState";
        aVar.nmd.put("bankcardState", "INTEGER");
        stringBuilder.append(" bankcardState INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[3] = "forbidWord";
        aVar.nmd.put("forbidWord", "TEXT");
        stringBuilder.append(" forbidWord TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "bankName";
        aVar.nmd.put("bankName", "TEXT");
        stringBuilder.append(" bankName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = "bankcardType";
        aVar.nmd.put("bankcardType", "TEXT");
        stringBuilder.append(" bankcardType TEXT");
        stringBuilder.append(", ");
        aVar.bXK[6] = "bankcardTypeName";
        aVar.nmd.put("bankcardTypeName", "TEXT");
        stringBuilder.append(" bankcardTypeName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[7] = "bankcardTag";
        aVar.nmd.put("bankcardTag", "INTEGER");
        stringBuilder.append(" bankcardTag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[8] = "bankcardTail";
        aVar.nmd.put("bankcardTail", "TEXT");
        stringBuilder.append(" bankcardTail TEXT");
        stringBuilder.append(", ");
        aVar.bXK[9] = "supportTag";
        aVar.nmd.put("supportTag", "INTEGER");
        stringBuilder.append(" supportTag INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[10] = "mobile";
        aVar.nmd.put("mobile", "TEXT");
        stringBuilder.append(" mobile TEXT");
        stringBuilder.append(", ");
        aVar.bXK[11] = "trueName";
        aVar.nmd.put("trueName", "TEXT");
        stringBuilder.append(" trueName TEXT");
        stringBuilder.append(", ");
        aVar.bXK[12] = "desc";
        aVar.nmd.put("desc", "TEXT");
        stringBuilder.append(" desc TEXT");
        stringBuilder.append(", ");
        aVar.bXK[13] = "bankPhone";
        aVar.nmd.put("bankPhone", "TEXT");
        stringBuilder.append(" bankPhone TEXT");
        stringBuilder.append(", ");
        aVar.bXK[14] = "bizUsername";
        aVar.nmd.put("bizUsername", "TEXT");
        stringBuilder.append(" bizUsername TEXT");
        stringBuilder.append(", ");
        aVar.bXK[15] = "onceQuotaKind";
        aVar.nmd.put("onceQuotaKind", "DOUBLE");
        stringBuilder.append(" onceQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.bXK[16] = "onceQuotaVirtual";
        aVar.nmd.put("onceQuotaVirtual", "DOUBLE");
        stringBuilder.append(" onceQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.bXK[17] = "dayQuotaKind";
        aVar.nmd.put("dayQuotaKind", "DOUBLE");
        stringBuilder.append(" dayQuotaKind DOUBLE");
        stringBuilder.append(", ");
        aVar.bXK[18] = "dayQuotaVirtual";
        aVar.nmd.put("dayQuotaVirtual", "DOUBLE");
        stringBuilder.append(" dayQuotaVirtual DOUBLE");
        stringBuilder.append(", ");
        aVar.bXK[19] = "fetchArriveTime";
        aVar.nmd.put("fetchArriveTime", "LONG");
        stringBuilder.append(" fetchArriveTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[20] = "fetchArriveTimeWording";
        aVar.nmd.put("fetchArriveTimeWording", "TEXT");
        stringBuilder.append(" fetchArriveTimeWording TEXT");
        stringBuilder.append(", ");
        aVar.bXK[21] = "repay_url";
        aVar.nmd.put("repay_url", "TEXT");
        stringBuilder.append(" repay_url TEXT");
        stringBuilder.append(", ");
        aVar.bXK[22] = "wxcreditState";
        aVar.nmd.put("wxcreditState", "INTEGER");
        stringBuilder.append(" wxcreditState INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[23] = "bankcardClientType";
        aVar.nmd.put("bankcardClientType", "INTEGER");
        stringBuilder.append(" bankcardClientType INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[24] = "ext_msg";
        aVar.nmd.put("ext_msg", "TEXT");
        stringBuilder.append(" ext_msg TEXT");
        stringBuilder.append(", ");
        aVar.bXK[25] = "support_micropay";
        aVar.nmd.put("support_micropay", "INTEGER");
        stringBuilder.append(" support_micropay INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[26] = "arrive_type";
        aVar.nmd.put("arrive_type", "TEXT");
        stringBuilder.append(" arrive_type TEXT");
        stringBuilder.append(", ");
        aVar.bXK[27] = "avail_save_wording";
        aVar.nmd.put("avail_save_wording", "TEXT");
        stringBuilder.append(" avail_save_wording TEXT");
        stringBuilder.append(", ");
        aVar.bXK[28] = "fetch_charge_rate";
        aVar.nmd.put("fetch_charge_rate", "DOUBLE");
        stringBuilder.append(" fetch_charge_rate DOUBLE");
        stringBuilder.append(", ");
        aVar.bXK[29] = "full_fetch_charge_fee";
        aVar.nmd.put("full_fetch_charge_fee", "DOUBLE");
        stringBuilder.append(" full_fetch_charge_fee DOUBLE");
        stringBuilder.append(", ");
        aVar.bXK[30] = "fetch_charge_info";
        aVar.nmd.put("fetch_charge_info", "TEXT");
        stringBuilder.append(" fetch_charge_info TEXT");
        stringBuilder.append(", ");
        aVar.bXK[31] = "tips";
        aVar.nmd.put("tips", "TEXT");
        stringBuilder.append(" tips TEXT");
        stringBuilder.append(", ");
        aVar.bXK[32] = "forbid_title";
        aVar.nmd.put("forbid_title", "TEXT");
        stringBuilder.append(" forbid_title TEXT");
        stringBuilder.append(", ");
        aVar.bXK[33] = "forbid_url";
        aVar.nmd.put("forbid_url", "TEXT");
        stringBuilder.append(" forbid_url TEXT");
        aVar.bXK[34] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    public Bankcard() {
        this.kNu = null;
        this.kNB = null;
        this.kNC = false;
    }

    public Bankcard(byte b) {
        this.kNu = null;
        this.kNB = null;
        this.kNC = false;
        this.field_bankcardTag = 1;
    }

    public static boolean cI(int i, int i2) {
        v.d("MicroMsg.Bankcard", "supportBankcardTag : " + i + ", bankcardTag : " + i2);
        return (i & i2) > 0;
    }

    public static boolean sm(int i) {
        return (i & 2) > 0;
    }

    public final int a(int i, Orders orders) {
        if (this.field_bankcardState != 0) {
            v.d("MicroMsg.Bankcard", " bankcardState : " + this.field_bankcardState);
            return this.field_bankcardState;
        } else if (orders != null && orders.fTG.equals(this.kNu)) {
            return 4;
        } else {
            int i2;
            if ((this.field_bankcardTag & i) > 0) {
                i2 = 1;
            } else {
                i2 = 0;
            }
            if (i2 == 0) {
                if (bfI()) {
                    return 5;
                }
                return 6;
            } else if (orders == null || orders.kPj.isEmpty() || orders.kPj.contains(this.field_bankcardType)) {
                return 0;
            } else {
                return 7;
            }
        }
    }

    public static String D(Context context, int i) {
        switch (i) {
            case 1:
                return context.getString(2131236330);
            case 2:
                return context.getString(2131236336);
            case 3:
                return context.getString(2131236341);
            case 4:
                return context.getString(2131236332);
            case 5:
                return context.getString(2131236328);
            case 6:
                return context.getString(2131236334);
            case 7:
                return context.getString(2131236339);
            default:
                return context.getString(2131236337);
        }
    }

    public final boolean bfF() {
        boolean z = (this.field_cardType & kNn) > 0;
        v.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bfG() {
        boolean z = (this.field_cardType & kNo) > 0;
        v.d("MicroMsg.Bankcard", "isWXCredit, ret = " + z);
        return z;
    }

    public final boolean bfH() {
        boolean z = (this.field_cardType & kNm) > 0;
        v.d("MicroMsg.Bankcard", "isCredit, ret = " + z);
        return z;
    }

    public final boolean bfI() {
        boolean z = (this.field_cardType & kNl) <= 0;
        v.d("MicroMsg.Bankcard", "isDomestic, ret = " + z);
        return z;
    }

    protected final a tl() {
        return chq;
    }

    public int describeContents() {
        return 0;
    }

    public Bankcard(Parcel parcel) {
        boolean z = true;
        this.kNu = null;
        this.kNB = null;
        this.kNC = false;
        this.field_bankName = parcel.readString();
        this.field_desc = parcel.readString();
        this.field_bankcardType = parcel.readString();
        this.field_bindSerial = parcel.readString();
        this.field_cardType = parcel.readInt();
        this.kNC = parcel.readInt() == 1;
        this.field_mobile = parcel.readString();
        this.field_onceQuotaKind = parcel.readDouble();
        this.field_onceQuotaVirtual = parcel.readDouble();
        this.field_dayQuotaKind = parcel.readDouble();
        this.field_dayQuotaVirtual = parcel.readDouble();
        this.field_bankcardTail = parcel.readString();
        this.field_bankPhone = parcel.readString();
        this.field_bankcardTag = parcel.readInt();
        this.field_bankcardState = parcel.readInt();
        this.kNu = parcel.readString();
        this.kMU = parcel.readInt();
        this.kNB = parcel.readString();
        this.field_bankcardClientType = parcel.readInt();
        this.field_ext_msg = parcel.readString();
        if (parcel.readInt() != 1) {
            z = false;
        }
        this.field_support_micropay = z;
        this.field_arrive_type = parcel.readString();
        this.field_fetch_charge_rate = parcel.readDouble();
        this.field_full_fetch_charge_fee = parcel.readDouble();
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 1;
        parcel.writeString(this.field_bankName);
        parcel.writeString(this.field_desc);
        parcel.writeString(this.field_bankcardType);
        parcel.writeString(this.field_bindSerial);
        parcel.writeInt(this.field_cardType);
        parcel.writeInt(this.kNC ? 1 : 0);
        parcel.writeString(this.field_mobile);
        parcel.writeDouble(this.field_onceQuotaKind);
        parcel.writeDouble(this.field_onceQuotaVirtual);
        parcel.writeDouble(this.field_dayQuotaKind);
        parcel.writeDouble(this.field_dayQuotaVirtual);
        parcel.writeString(this.field_bankcardTail);
        parcel.writeString(this.field_bankPhone);
        parcel.writeInt(this.field_bankcardTag);
        parcel.writeInt(this.field_bankcardState);
        parcel.writeString(this.kNu);
        parcel.writeInt(this.kMU);
        parcel.writeString(this.kNB);
        parcel.writeInt(this.field_bankcardClientType);
        parcel.writeString(this.field_ext_msg);
        if (!this.field_support_micropay) {
            i2 = 0;
        }
        parcel.writeInt(i2);
        parcel.writeString(this.field_arrive_type);
        parcel.writeDouble(this.field_fetch_charge_rate);
        parcel.writeDouble(this.field_full_fetch_charge_fee);
    }

    public final void b(Cursor cursor) {
        super.b(cursor);
    }
}
