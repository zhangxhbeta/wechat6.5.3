package com.tencent.mm.modelcdntran;

import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;

public class h {
    public boolean cFQ;
    public a cFR;
    public int field_advideoflag = 0;
    public String field_aesKey = SQLiteDatabase.KeyEmpty;
    public int field_appType = 0;
    public int field_arg = 0;
    public boolean field_autostart = false;
    public int field_bzScene = 0;
    public int field_chattype = 0;
    public boolean field_enable_hitcheck = true;
    public String field_fake_bigfile_signature = SQLiteDatabase.KeyEmpty;
    public String field_fake_bigfile_signature_aeskey = SQLiteDatabase.KeyEmpty;
    public String field_fileId = SQLiteDatabase.KeyEmpty;
    public int field_fileType = 0;
    public String field_filemd5 = SQLiteDatabase.KeyEmpty;
    public boolean field_force_aeskeycdn = false;
    public String field_fullpath = SQLiteDatabase.KeyEmpty;
    public boolean field_isSilentTask = false;
    public boolean field_isStreamMedia = false;
    public boolean field_largesvideo = false;
    public long field_lastProgressCallbackTime = 0;
    public int field_limitrate = 0;
    public String field_mediaId = SQLiteDatabase.KeyEmpty;
    public int field_midFileLength = 0;
    public String field_midimgpath = SQLiteDatabase.KeyEmpty;
    public boolean field_needStorage = false;
    public boolean field_onlycheckexist = false;
    public int field_priority = 0;
    public boolean field_sendmsg_viacdn = false;
    public int field_smallVideoFlag = 0;
    public long field_startTime = 0;
    public String field_svr_signature = SQLiteDatabase.KeyEmpty;
    public String field_talker = SQLiteDatabase.KeyEmpty;
    public String field_thumbpath = SQLiteDatabase.KeyEmpty;
    public int field_totalLen = 0;
    public boolean field_trysafecdn = false;
    public String field_videoFileId = SQLiteDatabase.KeyEmpty;
    public String field_wxmsgparam = SQLiteDatabase.KeyEmpty;

    public interface a {
        int a(String str, int i, keep_ProgressInfo com_tencent_mm_modelcdntran_keep_ProgressInfo, keep_SceneResult com_tencent_mm_modelcdntran_keep_SceneResult, boolean z);

        void a(String str, ByteArrayOutputStream byteArrayOutputStream);

        byte[] i(String str, byte[] bArr);
    }
}
