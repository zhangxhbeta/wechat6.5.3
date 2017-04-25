package com.tencent.mm.storage.a;

import android.database.Cursor;
import com.tencent.mm.protocal.c.vj;
import com.tencent.mm.protocal.c.vl;
import com.tencent.mm.sdk.h.d;
import com.tencent.mm.sdk.h.f;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import java.io.IOException;

public final class j extends f<i> implements com.tencent.mm.bg.f.a {
    public static final String[] cic = new String[]{f.a(i.chq, "EmotionDesignerInfo")};
    public d cie;

    public enum a {
        DesignerSimpleInfo(0),
        PersonalDesigner(1),
        DesignerEmojiList(2);
        
        public int value;

        private a(int i) {
            this.value = i;
        }
    }

    public j(d dVar) {
        super(dVar, i.chq, "EmotionDesignerInfo", null);
        this.cie = dVar;
    }

    public final int a(com.tencent.mm.bg.f fVar) {
        if (fVar != null) {
            this.cie = fVar;
        }
        return 0;
    }

    public final vl NI(String str) {
        Cursor query;
        vl vlVar;
        Throwable e;
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerSimpleInfoResponseByID failed. Designer ID is null.");
            return null;
        }
        try {
            query = this.cie.query("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.DesignerSimpleInfo.value}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        vlVar = new vl();
                        vlVar.az(query.getBlob(0));
                        if (query != null) {
                            query.close();
                        }
                        return vlVar;
                    }
                } catch (Exception e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{be.e(e)});
                        if (query == null) {
                            vlVar = null;
                        } else {
                            query.close();
                            vlVar = null;
                        }
                        return vlVar;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            vlVar = null;
            if (query != null) {
                query.close();
            }
        } catch (Exception e3) {
            e = e3;
            query = null;
            v.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{be.e(e)});
            if (query == null) {
                query.close();
                vlVar = null;
            } else {
                vlVar = null;
            }
            return vlVar;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return vlVar;
    }

    public final vj NJ(String str) {
        Cursor query;
        Throwable e;
        if (be.kS(str)) {
            v.w("MicroMsg.emoji.EmotionDesignerInfo", "getDesignerEmojiListResponseByUIN failed. Designer UIN is null.");
            return null;
        }
        vj vjVar;
        try {
            query = this.cie.query("EmotionDesignerInfo", new String[]{"content"}, "designerIDAndType=? ", new String[]{str + a.DesignerEmojiList.value}, null, null, null);
            if (query != null) {
                try {
                    if (query.moveToFirst()) {
                        vjVar = new vj();
                        vjVar.az(query.getBlob(0));
                        if (query != null) {
                            query.close();
                        }
                        return vjVar;
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        v.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{be.e(e)});
                        if (query == null) {
                            query.close();
                            vjVar = null;
                        } else {
                            vjVar = null;
                        }
                        return vjVar;
                    } catch (Throwable th) {
                        e = th;
                        if (query != null) {
                            query.close();
                        }
                        throw e;
                    }
                }
            }
            vjVar = null;
            if (query != null) {
                query.close();
            }
        } catch (IOException e3) {
            e = e3;
            query = null;
            v.e("MicroMsg.emoji.EmotionDesignerInfo", "exception:%s", new Object[]{be.e(e)});
            if (query == null) {
                vjVar = null;
            } else {
                query.close();
                vjVar = null;
            }
            return vjVar;
        } catch (Throwable th2) {
            e = th2;
            query = null;
            if (query != null) {
                query.close();
            }
            throw e;
        }
        return vjVar;
    }
}
