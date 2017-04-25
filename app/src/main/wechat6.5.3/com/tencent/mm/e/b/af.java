package com.tencent.mm.e.b;

import android.content.ContentValues;
import android.database.Cursor;
import com.tencent.mm.sdk.h.c;
import com.tencent.mmdb.database.SQLiteDatabase;

public abstract class af extends c {
    private static final int bDd = "chatmode".hashCode();
    private static final int bDe = "conversationTime".hashCode();
    private static final int bDf = "customNotify".hashCode();
    private static final int bDg = "showTips".hashCode();
    private static final int bDh = "hasTrunc".hashCode();
    private static final int bDi = "parentRef".hashCode();
    private static final int bDj = "attrflag".hashCode();
    private static final int bDk = "sightTime".hashCode();
    private static final int bDl = "unReadMuteCount".hashCode();
    private static final int bDm = "lastSeq".hashCode();
    private static final int bDn = "UnDeliverCount".hashCode();
    private static final int bDo = "UnReadInvite".hashCode();
    private static final int bDp = "firstUnDeliverSeq".hashCode();
    public static final String[] btd = new String[0];
    private static final int btm = "rowid".hashCode();
    private static final int buv = "content".hashCode();
    private static final int bvg = "status".hashCode();
    private static final int bxU = "flag".hashCode();
    private static final int byA = "atCount".hashCode();
    private static final int byB = "editingMsg".hashCode();
    private static final int byD = "isSend".hashCode();
    private static final int byE = "msgType".hashCode();
    private static final int byF = "msgCount".hashCode();
    private static final int byu = "unReadCount".hashCode();
    private static final int byy = "digest".hashCode();
    private static final int byz = "digestUser".hashCode();
    private static final int bzG = "username".hashCode();
    private boolean bCQ = false;
    private boolean bCR = false;
    private boolean bCS = false;
    public boolean bCT = false;
    private boolean bCU = false;
    private boolean bCV = false;
    private boolean bCW = false;
    public boolean bCX = false;
    private boolean bCY = false;
    private boolean bCZ = false;
    private boolean bDa = false;
    private boolean bDb = false;
    private boolean bDc = false;
    private boolean buP = false;
    private boolean bua = false;
    private boolean bxS = false;
    private boolean byg = false;
    private boolean byk = false;
    private boolean byl = false;
    private boolean bym = false;
    private boolean byn = false;
    private boolean byp = false;
    private boolean byq = false;
    private boolean byr = false;
    private boolean bzs = false;
    public int field_UnDeliverCount;
    public int field_UnReadInvite;
    public int field_atCount;
    public int field_attrflag;
    public int field_chatmode;
    public String field_content;
    public long field_conversationTime;
    private String field_customNotify;
    public String field_digest;
    public String field_digestUser;
    public String field_editingMsg;
    public long field_firstUnDeliverSeq;
    public long field_flag;
    private int field_hasTrunc;
    public int field_isSend;
    public long field_lastSeq;
    public int field_msgCount;
    public String field_msgType;
    public String field_parentRef;
    public int field_showTips;
    public long field_sightTime;
    public int field_status;
    public int field_unReadCount;
    public int field_unReadMuteCount;
    public String field_username;

    public final void de(int i) {
        this.field_msgCount = i;
        this.byr = true;
    }

    public final void setUsername(String str) {
        this.field_username = str;
        this.bzs = true;
    }

    public final String getUsername() {
        return this.field_username;
    }

    public final void df(int i) {
        this.field_unReadCount = i;
        this.byg = true;
    }

    public final int pH() {
        return this.field_unReadCount;
    }

    public final void dg(int i) {
        this.field_chatmode = i;
        this.bCQ = true;
    }

    public final void dh(int i) {
        this.field_status = i;
        this.buP = true;
    }

    public final void di(int i) {
        this.field_isSend = i;
        this.byp = true;
    }

    public final void s(long j) {
        this.field_conversationTime = j;
        this.bCR = true;
    }

    public final void setContent(String str) {
        this.field_content = str;
        this.bua = true;
    }

    public final void ct(String str) {
        this.field_msgType = str;
        this.byq = true;
    }

    public final void t(long j) {
        this.field_flag = j;
        this.bxS = true;
    }

    public final void cu(String str) {
        this.field_digest = str;
        this.byk = true;
    }

    public final void cv(String str) {
        this.field_digestUser = str;
        this.byl = true;
    }

    public final void dj(int i) {
        this.field_hasTrunc = i;
        this.bCU = true;
    }

    public final void cw(String str) {
        this.field_parentRef = str;
        this.bCV = true;
    }

    public final void dk(int i) {
        this.field_attrflag = i;
        this.bCW = true;
    }

    public final void cx(String str) {
        this.field_editingMsg = str;
        this.byn = true;
    }

    public final void dl(int i) {
        this.field_atCount = i;
        this.bym = true;
    }

    public final void dm(int i) {
        this.field_unReadMuteCount = i;
        this.bCY = true;
    }

    public final int pI() {
        return this.field_unReadMuteCount;
    }

    public final void u(long j) {
        this.field_lastSeq = j;
        this.bCZ = true;
    }

    public final void dn(int i) {
        this.field_UnDeliverCount = i;
        this.bDa = true;
    }

    public final void do(int i) {
        this.field_UnReadInvite = i;
        this.bDb = true;
    }

    public final void v(long j) {
        this.field_firstUnDeliverSeq = j;
        this.bDc = true;
    }

    public final void b(Cursor cursor) {
        String[] columnNames = cursor.getColumnNames();
        if (columnNames != null) {
            int length = columnNames.length;
            for (int i = 0; i < length; i++) {
                int hashCode = columnNames[i].hashCode();
                if (byF == hashCode) {
                    this.field_msgCount = cursor.getInt(i);
                } else if (bzG == hashCode) {
                    this.field_username = cursor.getString(i);
                    this.bzs = true;
                } else if (byu == hashCode) {
                    this.field_unReadCount = cursor.getInt(i);
                } else if (bDd == hashCode) {
                    this.field_chatmode = cursor.getInt(i);
                } else if (bvg == hashCode) {
                    this.field_status = cursor.getInt(i);
                } else if (byD == hashCode) {
                    this.field_isSend = cursor.getInt(i);
                } else if (bDe == hashCode) {
                    this.field_conversationTime = cursor.getLong(i);
                } else if (buv == hashCode) {
                    this.field_content = cursor.getString(i);
                } else if (byE == hashCode) {
                    this.field_msgType = cursor.getString(i);
                } else if (bDf == hashCode) {
                    this.field_customNotify = cursor.getString(i);
                } else if (bDg == hashCode) {
                    this.field_showTips = cursor.getInt(i);
                } else if (bxU == hashCode) {
                    this.field_flag = cursor.getLong(i);
                } else if (byy == hashCode) {
                    this.field_digest = cursor.getString(i);
                } else if (byz == hashCode) {
                    this.field_digestUser = cursor.getString(i);
                } else if (bDh == hashCode) {
                    this.field_hasTrunc = cursor.getInt(i);
                } else if (bDi == hashCode) {
                    this.field_parentRef = cursor.getString(i);
                } else if (bDj == hashCode) {
                    this.field_attrflag = cursor.getInt(i);
                } else if (byB == hashCode) {
                    this.field_editingMsg = cursor.getString(i);
                } else if (byA == hashCode) {
                    this.field_atCount = cursor.getInt(i);
                } else if (bDk == hashCode) {
                    this.field_sightTime = cursor.getLong(i);
                } else if (bDl == hashCode) {
                    this.field_unReadMuteCount = cursor.getInt(i);
                } else if (bDm == hashCode) {
                    this.field_lastSeq = cursor.getLong(i);
                } else if (bDn == hashCode) {
                    this.field_UnDeliverCount = cursor.getInt(i);
                } else if (bDo == hashCode) {
                    this.field_UnReadInvite = cursor.getInt(i);
                } else if (bDp == hashCode) {
                    this.field_firstUnDeliverSeq = cursor.getLong(i);
                } else if (btm == hashCode) {
                    this.nmb = cursor.getLong(i);
                }
            }
        }
    }

    public final ContentValues py() {
        ContentValues contentValues = new ContentValues();
        if (this.byr) {
            contentValues.put("msgCount", Integer.valueOf(this.field_msgCount));
        }
        if (this.field_username == null) {
            this.field_username = SQLiteDatabase.KeyEmpty;
        }
        if (this.bzs) {
            contentValues.put("username", this.field_username);
        }
        if (this.byg) {
            contentValues.put("unReadCount", Integer.valueOf(this.field_unReadCount));
        }
        if (this.bCQ) {
            contentValues.put("chatmode", Integer.valueOf(this.field_chatmode));
        }
        if (this.buP) {
            contentValues.put("status", Integer.valueOf(this.field_status));
        }
        if (this.byp) {
            contentValues.put("isSend", Integer.valueOf(this.field_isSend));
        }
        if (this.bCR) {
            contentValues.put("conversationTime", Long.valueOf(this.field_conversationTime));
        }
        if (this.field_content == null) {
            this.field_content = SQLiteDatabase.KeyEmpty;
        }
        if (this.bua) {
            contentValues.put("content", this.field_content);
        }
        if (this.field_msgType == null) {
            this.field_msgType = SQLiteDatabase.KeyEmpty;
        }
        if (this.byq) {
            contentValues.put("msgType", this.field_msgType);
        }
        if (this.field_customNotify == null) {
            this.field_customNotify = SQLiteDatabase.KeyEmpty;
        }
        if (this.bCS) {
            contentValues.put("customNotify", this.field_customNotify);
        }
        if (this.bCT) {
            contentValues.put("showTips", Integer.valueOf(this.field_showTips));
        }
        if (this.bxS) {
            contentValues.put("flag", Long.valueOf(this.field_flag));
        }
        if (this.field_digest == null) {
            this.field_digest = SQLiteDatabase.KeyEmpty;
        }
        if (this.byk) {
            contentValues.put("digest", this.field_digest);
        }
        if (this.field_digestUser == null) {
            this.field_digestUser = SQLiteDatabase.KeyEmpty;
        }
        if (this.byl) {
            contentValues.put("digestUser", this.field_digestUser);
        }
        if (this.bCU) {
            contentValues.put("hasTrunc", Integer.valueOf(this.field_hasTrunc));
        }
        if (this.bCV) {
            contentValues.put("parentRef", this.field_parentRef);
        }
        if (this.bCW) {
            contentValues.put("attrflag", Integer.valueOf(this.field_attrflag));
        }
        if (this.field_editingMsg == null) {
            this.field_editingMsg = SQLiteDatabase.KeyEmpty;
        }
        if (this.byn) {
            contentValues.put("editingMsg", this.field_editingMsg);
        }
        if (this.bym) {
            contentValues.put("atCount", Integer.valueOf(this.field_atCount));
        }
        if (this.bCX) {
            contentValues.put("sightTime", Long.valueOf(this.field_sightTime));
        }
        if (this.bCY) {
            contentValues.put("unReadMuteCount", Integer.valueOf(this.field_unReadMuteCount));
        }
        if (this.bCZ) {
            contentValues.put("lastSeq", Long.valueOf(this.field_lastSeq));
        }
        if (this.bDa) {
            contentValues.put("UnDeliverCount", Integer.valueOf(this.field_UnDeliverCount));
        }
        if (this.bDb) {
            contentValues.put("UnReadInvite", Integer.valueOf(this.field_UnReadInvite));
        }
        if (this.bDc) {
            contentValues.put("firstUnDeliverSeq", Long.valueOf(this.field_firstUnDeliverSeq));
        }
        if (this.nmb > 0) {
            contentValues.put("rowid", Long.valueOf(this.nmb));
        }
        return contentValues;
    }
}
