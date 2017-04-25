package com.tencent.mm.plugin.card.sharecard.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.mm.e.b.cl;
import com.tencent.mm.plugin.card.b.j;
import com.tencent.mm.plugin.card.base.b;
import com.tencent.mm.plugin.card.model.af;
import com.tencent.mm.protocal.c.auu;
import com.tencent.mm.protocal.c.iu;
import com.tencent.mm.protocal.c.iw;
import com.tencent.mm.protocal.c.ix;
import com.tencent.mm.protocal.c.jc;
import com.tencent.mm.sdk.h.c.a;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.tmassistantsdk.downloadservice.DownloadInfo;
import java.lang.reflect.Field;

public class ShareCardInfo extends cl implements Parcelable, b {
    public static final Creator<ShareCardInfo> CREATOR = new Creator<ShareCardInfo>() {
        public final /* synthetic */ Object createFromParcel(Parcel parcel) {
            return new ShareCardInfo(parcel);
        }

        public final /* bridge */ /* synthetic */ Object[] newArray(int i) {
            return new ShareCardInfo[i];
        }
    };
    protected static a chq;
    public String eBP = "";
    public jc eCv;
    public iu eCw;
    public auu eCx;
    public ix eCy;
    public boolean eCz = true;

    static {
        a aVar = new a();
        aVar.ddU = new Field[19];
        aVar.bXK = new String[20];
        StringBuilder stringBuilder = new StringBuilder();
        aVar.bXK[0] = "card_id";
        aVar.nmd.put("card_id", "TEXT PRIMARY KEY ");
        stringBuilder.append(" card_id TEXT PRIMARY KEY ");
        stringBuilder.append(", ");
        aVar.nmc = "card_id";
        aVar.bXK[1] = "card_tp_id";
        aVar.nmd.put("card_tp_id", "TEXT");
        stringBuilder.append(" card_tp_id TEXT");
        stringBuilder.append(", ");
        aVar.bXK[2] = "from_username";
        aVar.nmd.put("from_username", "TEXT");
        stringBuilder.append(" from_username TEXT");
        stringBuilder.append(", ");
        aVar.bXK[3] = "consumer";
        aVar.nmd.put("consumer", "TEXT");
        stringBuilder.append(" consumer TEXT");
        stringBuilder.append(", ");
        aVar.bXK[4] = "app_id";
        aVar.nmd.put("app_id", "TEXT");
        stringBuilder.append(" app_id TEXT");
        stringBuilder.append(", ");
        aVar.bXK[5] = DownloadInfo.STATUS;
        aVar.nmd.put(DownloadInfo.STATUS, "INTEGER");
        stringBuilder.append(" status INTEGER");
        stringBuilder.append(", ");
        aVar.bXK[6] = "share_time";
        aVar.nmd.put("share_time", "LONG");
        stringBuilder.append(" share_time LONG");
        stringBuilder.append(", ");
        aVar.bXK[7] = "local_updateTime";
        aVar.nmd.put("local_updateTime", "LONG");
        stringBuilder.append(" local_updateTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[8] = "updateTime";
        aVar.nmd.put("updateTime", "LONG");
        stringBuilder.append(" updateTime LONG");
        stringBuilder.append(", ");
        aVar.bXK[9] = "begin_time";
        aVar.nmd.put("begin_time", "LONG");
        stringBuilder.append(" begin_time LONG");
        stringBuilder.append(", ");
        aVar.bXK[10] = "end_time";
        aVar.nmd.put("end_time", "LONG");
        stringBuilder.append(" end_time LONG");
        stringBuilder.append(", ");
        aVar.bXK[11] = "updateSeq";
        aVar.nmd.put("updateSeq", "LONG");
        stringBuilder.append(" updateSeq LONG");
        stringBuilder.append(", ");
        aVar.bXK[12] = "block_mask";
        aVar.nmd.put("block_mask", "LONG");
        stringBuilder.append(" block_mask LONG");
        stringBuilder.append(", ");
        aVar.bXK[13] = "dataInfoData";
        aVar.nmd.put("dataInfoData", "BLOB");
        stringBuilder.append(" dataInfoData BLOB");
        stringBuilder.append(", ");
        aVar.bXK[14] = "cardTpInfoData";
        aVar.nmd.put("cardTpInfoData", "BLOB");
        stringBuilder.append(" cardTpInfoData BLOB");
        stringBuilder.append(", ");
        aVar.bXK[15] = "shareInfoData";
        aVar.nmd.put("shareInfoData", "BLOB");
        stringBuilder.append(" shareInfoData BLOB");
        stringBuilder.append(", ");
        aVar.bXK[16] = "shopInfoData";
        aVar.nmd.put("shopInfoData", "BLOB");
        stringBuilder.append(" shopInfoData BLOB");
        stringBuilder.append(", ");
        aVar.bXK[17] = "categoryType";
        aVar.nmd.put("categoryType", "INTEGER default '0' ");
        stringBuilder.append(" categoryType INTEGER default '0' ");
        stringBuilder.append(", ");
        aVar.bXK[18] = "itemIndex";
        aVar.nmd.put("itemIndex", "INTEGER default '0' ");
        stringBuilder.append(" itemIndex INTEGER default '0' ");
        aVar.bXK[19] = "rowid";
        aVar.nme = stringBuilder.toString();
        chq = aVar;
    }

    protected final a tl() {
        return chq;
    }

    public final boolean Zc() {
        return Zv() != null && Zv().eBL == 10;
    }

    public final boolean Zd() {
        return Zv() != null && Zv().eBL == 0;
    }

    public final boolean Ze() {
        return Zv() != null && Zv().eBL == 20;
    }

    public final boolean Zf() {
        return Zv() != null && Zv().eBL == 11;
    }

    public final boolean Zg() {
        return Zv() != null && Zv().eBL == 30;
    }

    public final boolean Zh() {
        return j.iT(Zv().eBL);
    }

    public final boolean Zi() {
        return (Zv().mkU & 2) == 0;
    }

    public final boolean Zj() {
        return (Zv().mkU & 1) == 0;
    }

    public final boolean Zk() {
        return (Zv().mkX & 1) == 0;
    }

    public final boolean Zl() {
        return (Zv().mkX & 16) == 0;
    }

    public final boolean Zm() {
        return (Zv().mkX & 2) > 0;
    }

    public final boolean Zn() {
        return false;
    }

    public final boolean Zo() {
        return (Zv().mkX & 4) > 0;
    }

    public final boolean Zp() {
        return (Zv().mkX & 8) > 0;
    }

    public final boolean Zr() {
        return this.eCw != null && this.eCw.status == 0;
    }

    public final boolean isAcceptable() {
        if (!Zr()) {
            return false;
        }
        if (this.eCv != null) {
            v.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.eCv.mlk);
        }
        v.i("MicroMsg.ShareCardInfo", "stock_num:" + this.eCw.mkp + " limit_num:" + this.eCw.mkq);
        if (this.eCv == null || this.eCv.mlk != 1) {
            return ((this.eCv == null || this.eCv.mlk != 0) && this.eCw.mkp != 0 && this.eCw.mkq == 0) ? false : false;
        } else {
            return true;
        }
    }

    public final boolean Zs() {
        if (!Zr()) {
            return false;
        }
        if (this.eCv != null) {
            v.i("MicroMsg.ShareCardInfo", "is_acceptable:" + this.eCv.mlk);
        }
        v.i("MicroMsg.ShareCardInfo", "avail_num:" + this.eCw.mkm);
        if (this.eCv != null && this.eCv.mlk == 1) {
            return true;
        }
        if (this.eCw.mkm > 0) {
            return true;
        }
        return ((this.eCv == null || this.eCv.mlk != 0) && this.eCw.mkm == 0) ? false : false;
    }

    public final boolean Zt() {
        if (this.eCv == null || this.eCv.mlb == null || TextUtils.isEmpty(this.eCv.mlb.text)) {
            return false;
        }
        iw iwVar = this.eCv.mlb;
        int currentTimeMillis = iwVar.iOT - ((int) (System.currentTimeMillis() / 1000));
        if (iwVar.iOT <= 0 || currentTimeMillis <= 0) {
            return false;
        }
        return true;
    }

    public final boolean Zu() {
        return this.eCv != null && this.eCv.mlo == 1;
    }

    public final jc Zv() {
        if (this.eCv != null) {
            return this.eCv;
        }
        try {
            this.eCv = (jc) new jc().az(this.field_cardTpInfoData);
            return this.eCv;
        } catch (Throwable e) {
            v.e("MicroMsg.ShareCardInfo", "getCardTpInfo fail, ex = %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return new jc();
        }
    }

    public final iu Zw() {
        if (this.eCw != null) {
            return this.eCw;
        }
        try {
            this.eCw = (iu) new iu().az(this.field_dataInfoData);
            return this.eCw;
        } catch (Throwable e) {
            v.e("MicroMsg.ShareCardInfo", "getDataInfo fail, ex = %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return new iu();
        }
    }

    public final void a(iu iuVar) {
        this.eCw = iuVar;
        if (this.eCw != null) {
            try {
                this.field_dataInfoData = iuVar.toByteArray();
            } catch (Throwable e) {
                v.e("MicroMsg.ShareCardInfo", "setDataInfo fail, ex = %s", new Object[]{e.getMessage()});
                v.a("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            }
        }
    }

    public final auu Zx() {
        if (this.eCx != null) {
            return this.eCx;
        }
        try {
            this.eCx = (auu) new auu().az(this.field_shareInfoData);
            return this.eCx;
        } catch (Throwable e) {
            v.e("MicroMsg.ShareCardInfo", "getShareInfo fail, ex = %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return new auu();
        }
    }

    public final ix Zy() {
        if (this.eCy != null) {
            return this.eCy;
        }
        try {
            this.eCy = (ix) new ix().az(this.field_shopInfoData);
            return this.eCy;
        } catch (Throwable e) {
            v.e("MicroMsg.ShareCardInfo", "getShopInfo fail ex = %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.ShareCardInfo", e, "", new Object[0]);
            return null;
        }
    }

    public final void a(ix ixVar) {
        this.eCy = ixVar;
        try {
            this.field_shopInfoData = ixVar.toByteArray();
        } catch (Throwable e) {
            v.e("MicroMsg.ShareCardInfo", "setShopInfo fail, ex = %s", new Object[]{e.getMessage()});
            v.a("MicroMsg.ShareCardInfo", e, "", new Object[0]);
        }
    }

    public ShareCardInfo(Parcel parcel) {
        int i;
        int i2 = 0;
        this.field_card_id = parcel.readString();
        this.field_card_tp_id = parcel.readString();
        this.field_from_username = parcel.readString();
        this.field_status = parcel.readInt();
        this.field_share_time = parcel.readLong();
        this.field_local_updateTime = parcel.readLong();
        this.field_updateTime = parcel.readLong();
        this.field_updateSeq = parcel.readLong();
        this.field_block_mask = parcel.readLong();
        this.field_end_time = parcel.readLong();
        this.field_categoryType = parcel.readInt();
        this.field_itemIndex = parcel.readInt();
        int readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_dataInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_dataInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_cardTpInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_cardTpInfoData[i] = parcel.readByte();
            }
        }
        readInt = parcel.readInt();
        if (readInt > 0) {
            this.field_shareInfoData = new byte[readInt];
            for (i = 0; i < readInt; i++) {
                this.field_shareInfoData[i] = parcel.readByte();
            }
        }
        i = parcel.readInt();
        if (i > 0) {
            this.field_shopInfoData = new byte[i];
            while (i2 < i) {
                this.field_shopInfoData[i2] = parcel.readByte();
                i2++;
            }
        }
    }

    public int describeContents() {
        return 0;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int i2 = 0;
        parcel.writeString(this.field_card_id);
        parcel.writeString(this.field_card_tp_id);
        parcel.writeString(this.field_from_username);
        parcel.writeInt(this.field_status);
        parcel.writeLong(this.field_share_time);
        parcel.writeLong(this.field_local_updateTime);
        parcel.writeLong(this.field_updateTime);
        parcel.writeLong(this.field_updateSeq);
        parcel.writeLong(this.field_block_mask);
        parcel.writeLong(this.field_end_time);
        parcel.writeInt(this.field_categoryType);
        parcel.writeInt(this.field_itemIndex);
        if (this.field_dataInfoData != null) {
            parcel.writeInt(this.field_dataInfoData.length);
            for (byte writeByte : this.field_dataInfoData) {
                parcel.writeByte(writeByte);
            }
        }
        if (this.field_cardTpInfoData != null) {
            parcel.writeInt(this.field_cardTpInfoData.length);
            for (byte writeByte2 : this.field_cardTpInfoData) {
                parcel.writeByte(writeByte2);
            }
        }
        if (this.field_shareInfoData != null) {
            parcel.writeInt(this.field_shareInfoData.length);
            for (byte writeByte22 : this.field_shareInfoData) {
                parcel.writeByte(writeByte22);
            }
        }
        if (this.field_shopInfoData != null) {
            parcel.writeInt(this.field_shopInfoData.length);
            while (i2 < this.field_shopInfoData.length) {
                parcel.writeByte(this.field_shopInfoData[i2]);
                i2++;
            }
        }
    }

    public final long getEndTime() {
        return this.field_end_time;
    }

    public final String Zz() {
        return this.field_card_id;
    }

    public final String ZA() {
        return this.field_card_tp_id;
    }

    public final String ZB() {
        return this.field_from_username;
    }

    public final void pE(String str) {
        this.field_from_username = str;
    }

    public final long ZC() {
        return this.field_local_updateTime;
    }

    public final boolean Za() {
        return Zv() != null && Zv().mle == 0;
    }

    public final boolean Zb() {
        return Zv() != null && Zv().mle == 1;
    }

    public final String iR(int i) {
        if (i == 10) {
            return (String) af.aap().getValue("key_share_card_local_city");
        }
        if (i != 0) {
            return "";
        }
        if (com.tencent.mm.plugin.card.sharecard.a.b.aaD()) {
            return aa.getResources().getString(2131231671);
        }
        return "";
    }

    public final String ZD() {
        return "";
    }

    public final int ZE() {
        return this.field_categoryType;
    }

    public final String ZF() {
        v.d("MicroMsg.ShareCardInfo", "encrypt_code:" + this.eBP);
        return this.eBP;
    }

    public final boolean Zq() {
        return Zv() != null && Zv().mlj == 1;
    }
}
