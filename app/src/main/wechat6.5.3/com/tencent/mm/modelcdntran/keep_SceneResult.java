package com.tencent.mm.modelcdntran;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mmdb.database.SQLiteDatabase;
import com.tencent.smtt.sdk.WebView;

public class keep_SceneResult {
    protected static final char[] hexArray = "0123456789ABCDEF".toCharArray();
    public String dummyvalue;
    public int field_UploadHitCacheType;
    public String field_aesKey;
    public String field_arg;
    public String field_argInfo;
    public int field_averageConnectCost;
    public int field_averageSpeed;
    public boolean field_convert2baseline;
    public long field_enQueueTime;
    public long field_endTime;
    public boolean field_exist_whencheck;
    public String field_fileId;
    public int field_fileLength;
    public String field_fileUrl;
    public int field_filecrc;
    public String field_filemd5;
    public int field_firstConnectCost;
    public boolean field_firstRequestCompleted;
    public int field_firstRequestCost;
    public int field_firstRequestDownloadSize;
    public int field_firstRequestSize;
    public int field_httpStatusCode;
    public boolean field_isVideoReduced;
    public int field_midimgLength;
    public boolean field_moovCompleted;
    public int field_moovCost;
    public int field_moovFailReason;
    public int field_moovRequestTimes;
    public int field_moovSize;
    public String field_mp4identifymd5;
    public boolean field_needSendMsgField;
    public int field_netConnectTimes;
    public int field_recvedBytes;
    public int field_retCode;
    public byte[] field_sKeyrespbuf;
    public long field_startTime;
    public String field_thumbUrl;
    public String field_thumbfilemd5;
    public int field_thumbimgLength;
    public String field_toUser;
    public String field_transInfo;
    public boolean field_upload_by_safecdn;
    public String[] field_usedSvrIps;
    public String field_videoFileId;
    public String mediaId;
    public String report_Part2;

    public boolean isUploadBySafeCDNWithMD5() {
        return this.field_upload_by_safecdn && (2 == this.field_UploadHitCacheType || 3 == this.field_UploadHitCacheType);
    }

    keep_SceneResult() {
        this.report_Part2 = SQLiteDatabase.KeyEmpty;
        this.dummyvalue = ",,,,,,";
        this.field_thumbUrl = SQLiteDatabase.KeyEmpty;
        this.field_fileUrl = SQLiteDatabase.KeyEmpty;
        this.field_filemd5 = SQLiteDatabase.KeyEmpty;
        this.field_thumbfilemd5 = SQLiteDatabase.KeyEmpty;
        this.field_mp4identifymd5 = SQLiteDatabase.KeyEmpty;
        this.field_exist_whencheck = false;
        this.field_recvedBytes = 0;
        this.field_startTime = 0;
        this.field_endTime = 0;
        this.field_enQueueTime = 0;
        this.field_firstRequestCost = 0;
        this.field_firstRequestSize = 0;
        this.field_firstRequestDownloadSize = 0;
        this.field_firstRequestCompleted = false;
        this.field_averageSpeed = 0;
        this.field_averageConnectCost = 0;
        this.field_firstConnectCost = 0;
        this.field_netConnectTimes = 0;
        this.field_moovRequestTimes = 0;
        this.field_moovCost = 0;
        this.field_moovSize = 0;
        this.field_moovCompleted = false;
        this.field_moovFailReason = 0;
        this.field_httpStatusCode = 0;
        this.field_isVideoReduced = false;
        this.field_UploadHitCacheType = 0;
        this.field_needSendMsgField = true;
        this.field_convert2baseline = false;
        this.field_exist_whencheck = false;
    }

    private String bytesToHex(byte[] bArr) {
        char[] cArr = new char[(bArr.length * 2)];
        for (int i = 0; i < bArr.length; i++) {
            int i2 = bArr[i] & WebView.NORMAL_MODE_ALPHA;
            cArr[i * 2] = hexArray[i2 >>> 4];
            cArr[(i * 2) + 1] = hexArray[i2 & 15];
        }
        return new String(cArr);
    }

    public String toString() {
        String format = String.format("id:%s file:%s filelen:%d midlen:%d thlen:%d transInfo:%s retCode:%d toUser:%s arg:%s videoFileId:%s argInfo:%s hitcache:%d needsend:%b msgid:%d convert2baseline:%b thumbUrl:%s fileUrl:%s filemd5:%s thumbfilemd5:%s,mp4identifymd5:%s, exist_whencheck[%b], aesKey[%s], crc[%s], safecdn:%b", new Object[]{this.mediaId, this.field_fileId, Integer.valueOf(this.field_fileLength), Integer.valueOf(this.field_midimgLength), Integer.valueOf(this.field_thumbimgLength), this.field_transInfo, Integer.valueOf(this.field_retCode), this.field_toUser, this.field_arg, this.field_videoFileId, this.field_argInfo, Integer.valueOf(this.field_UploadHitCacheType), Boolean.valueOf(this.field_needSendMsgField), Integer.valueOf(0), Boolean.valueOf(this.field_convert2baseline), this.field_thumbUrl, this.field_fileUrl, this.field_filemd5, this.field_thumbfilemd5, this.field_mp4identifymd5, Boolean.valueOf(this.field_exist_whencheck), be.KW(this.field_aesKey), Integer.valueOf(this.field_filecrc), Boolean.valueOf(this.field_upload_by_safecdn)});
        if (this.field_sKeyrespbuf == null) {
            return format;
        }
        return format + String.format("skeyrespbuf:%s", new Object[]{bytesToHex(this.field_sKeyrespbuf)});
    }
}
