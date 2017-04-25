package com.tencent.mm.plugin.backup.g;

import com.tencent.mm.plugin.backup.f.f;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public final class k {
    private static String END = "img";
    private static String ejA = "s60v5";
    private static String ejw = "icon_";
    private static String ejx = "iphone";
    private static String ejy = "android";
    private static String ejz = "s60v3";
    Map<String, f> ejB = null;

    public k() {
        VV();
    }

    final void VV() {
        int i;
        Throwable e;
        Throwable e2;
        this.ejB = new HashMap();
        InputStream open;
        BufferedReader bufferedReader;
        try {
            open = aa.getContext().getAssets().open("emojiconf");
            try {
                bufferedReader = new BufferedReader(new InputStreamReader(open, "utf-8"));
                i = 0;
                while (true) {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        try {
                            break;
                        } catch (Exception e3) {
                        }
                    } else if (readLine.contains(ejw)) {
                        f fVar = new f();
                        while (true) {
                            String readLine2 = bufferedReader.readLine();
                            if (readLine2 != null && !readLine2.contains(END)) {
                                int indexOf = readLine2.indexOf("=");
                                if (indexOf + 1 >= readLine2.length()) {
                                    break;
                                }
                                String substring = readLine2.substring(indexOf + 1);
                                if (readLine2.startsWith(ejx)) {
                                    fVar.ehJ = substring;
                                } else if (readLine2.startsWith(ejy)) {
                                    fVar.ehI = substring;
                                } else {
                                    try {
                                        if (readLine2.startsWith(ejz)) {
                                            fVar.ehK = substring;
                                        } else if (readLine2.startsWith(ejA)) {
                                            fVar.ehL = substring;
                                        }
                                    } catch (IOException e4) {
                                        e = e4;
                                    }
                                }
                                this.ejB.put(fVar.ehI, fVar);
                            } else {
                                break;
                            }
                        }
                        v.d("MicroMsg.EmojiCovertMap", "emojiValue " + fVar.toString());
                        i++;
                    }
                }
                bufferedReader.close();
                if (open != null) {
                    open.close();
                }
            } catch (Throwable e22) {
                bufferedReader = null;
                e = e22;
                i = 0;
                try {
                    v.a("MicroMsg.EmojiCovertMap", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e5) {
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    v.d("MicroMsg.EmojiCovertMap", "id " + i);
                } catch (Throwable th) {
                    e22 = th;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (Exception e6) {
                            throw e22;
                        }
                    }
                    if (open != null) {
                        open.close();
                    }
                    throw e22;
                }
            } catch (Throwable th2) {
                e22 = th2;
                bufferedReader = null;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (open != null) {
                    open.close();
                }
                throw e22;
            }
        } catch (Throwable e222) {
            bufferedReader = null;
            open = null;
            e = e222;
            i = 0;
            v.a("MicroMsg.EmojiCovertMap", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            v.d("MicroMsg.EmojiCovertMap", "id " + i);
        } catch (Throwable th3) {
            e222 = th3;
            bufferedReader = null;
            open = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (open != null) {
                open.close();
            }
            throw e222;
        }
        v.d("MicroMsg.EmojiCovertMap", "id " + i);
    }
}
