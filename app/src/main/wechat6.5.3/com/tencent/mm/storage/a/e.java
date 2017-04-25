package com.tencent.mm.storage.a;

import android.content.SharedPreferences;
import android.database.Cursor;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import com.tencent.mm.bg.f.a;
import com.tencent.mm.sdk.h.c;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;

public final class e extends f<d> implements a {
    public static final String[] cic = new String[]{f.a(d.chq, "EmojiInfoDesc")};
    public d cie;
    public SharedPreferences nxi;

    public final /* synthetic */ boolean b(c cVar) {
        d dVar = (d) cVar;
        if (dVar != null) {
            if (dVar.EB().length() == 32) {
                dVar.field_md5_lang = dVar.field_md5 + dVar.field_lang;
                long replace = this.cie.replace("EmojiInfoDesc", "md5_lang", dVar.py());
                if (replace != -1) {
                    Lf(dVar.EB());
                }
                return replace >= 0;
            }
        }
        return false;
    }

    public e(d dVar) {
        this(dVar, d.chq, "EmojiInfoDesc");
    }

    private e(d dVar, c.a aVar, String str) {
        super(dVar, aVar, str, null);
        this.cie = dVar;
        this.nxi = PreferenceManager.getDefaultSharedPreferences(aa.getContext());
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final boolean NC(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery(String.format("select %s from %s where %s=?", new Object[]{"click_flag", "EmojiInfoDesc", "groupId"}), new String[]{str});
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("click_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            v.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean ND(String str) {
        boolean z = true;
        boolean z2 = false;
        Cursor cursor = null;
        try {
            cursor = this.cie.rawQuery(String.format("select %s from %s where %s=?", new Object[]{"download_flag", "EmojiInfoDesc", "groupId"}), new String[]{str});
            if (cursor != null && cursor.moveToFirst()) {
                if ((cursor.getInt(cursor.getColumnIndex("download_flag")) & 1) != 1) {
                    z = false;
                }
                z2 = z;
            }
            if (cursor != null) {
                cursor.close();
            }
        } catch (Exception e) {
            v.w("MicroMsg.emoji.EmojiInfoDescStorage", "[isPurChase] Exception:%s", new Object[]{e.toString()});
            if (cursor != null) {
                cursor.close();
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
        }
        return z2;
    }

    public final boolean NE(String str) {
        boolean z = false;
        if (!TextUtils.isEmpty(str)) {
            Cursor cursor = null;
            try {
                cursor = this.cie.rawQuery(String.format("select %s from %s where %s=?", new Object[]{"desc", "EmojiInfoDesc", "groupId"}), new String[]{str});
                if (cursor != null && cursor.moveToFirst()) {
                    z = true;
                }
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Exception e) {
                v.w("MicroMsg.emoji.EmojiInfoDescStorage", e.toString());
                if (cursor != null) {
                    cursor.close();
                }
            } catch (Throwable th) {
                if (cursor != null) {
                    cursor.close();
                }
            }
        }
        return z;
    }
}
