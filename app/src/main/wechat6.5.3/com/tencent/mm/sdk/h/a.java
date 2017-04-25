package com.tencent.mm.sdk.h;

import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

public final class a {
    private String filePath;
    private Properties nlZ;

    public a(String str) {
        Exception e;
        Throwable th;
        this.nlZ = null;
        this.filePath = null;
        this.nlZ = new Properties();
        this.filePath = str;
        FileInputStream fileInputStream;
        try {
            fileInputStream = new FileInputStream(str);
            try {
                this.nlZ.load(fileInputStream);
                try {
                    fileInputStream.close();
                } catch (IOException e2) {
                    v.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e2.getLocalizedMessage());
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e22) {
                            v.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e22.getLocalizedMessage());
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileInputStream != null) {
                        try {
                            fileInputStream.close();
                        } catch (IOException e4) {
                            v.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", str, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileInputStream = null;
            v.e("MicroMsg.ReadConfig", "Read File: %s Failed. [%s]", str, e.getLocalizedMessage());
            if (fileInputStream != null) {
                fileInputStream.close();
            }
        } catch (Throwable th3) {
            th = th3;
            fileInputStream = null;
            if (fileInputStream != null) {
                fileInputStream.close();
            }
            throw th;
        }
    }

    public final boolean dD(String str, String str2) {
        FileOutputStream fileOutputStream;
        Exception e;
        Throwable th;
        try {
            fileOutputStream = new FileOutputStream(this.filePath);
            try {
                this.nlZ.setProperty(str, str2);
                this.nlZ.store(fileOutputStream, SQLiteDatabase.KeyEmpty);
                try {
                    fileOutputStream.close();
                    return true;
                } catch (IOException e2) {
                    v.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e2.getLocalizedMessage());
                    return true;
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    v.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (IOException e22) {
                        v.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e22.getLocalizedMessage());
                        return false;
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (IOException e4) {
                            v.e("MicroMsg.ReadConfig", "Close File: %s Failed. [%s]", this.filePath, e4.getLocalizedMessage());
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            fileOutputStream = null;
            v.e("MicroMsg.ReadConfig", "Write File: %s Failed. [%s]", this.filePath, e.getLocalizedMessage());
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th3) {
            th = th3;
            fileOutputStream = null;
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw th;
        }
    }

    public final boolean H(String str, long j) {
        return dD(str, String.valueOf(j));
    }

    public final boolean bH(String str, int i) {
        return dD(str, String.valueOf(i));
    }

    public final String getValue(String str) {
        if (this.nlZ == null || !this.nlZ.containsKey(str)) {
            return null;
        }
        return this.nlZ.getProperty(str);
    }

    public final Long Lb(String str) {
        Long l = null;
        String value = getValue(str);
        if (value != null) {
            try {
                l = Long.valueOf(Long.parseLong(value));
            } catch (Exception e) {
                v.e("MicroMsg.ReadConfig", "getLongValue ParseLong : %s Failed. [%s]", value, e.getLocalizedMessage());
            }
        }
        return l;
    }

    public final Integer Lc(String str) {
        Integer num = null;
        String value = getValue(str);
        if (value != null) {
            try {
                num = Integer.valueOf(Integer.parseInt(value));
            } catch (Exception e) {
                v.e("MicroMsg.ReadConfig", "getIntegerValue ParseInteger : %s Failed. [%s]", value, e.getLocalizedMessage());
            }
        }
        return num;
    }

    public static String getValue(String str, String str2) {
        return new a(str).getValue(str2);
    }

    public static Long dE(String str, String str2) {
        return new a(str).Lb(str2);
    }

    public static boolean X(String str, String str2, String str3) {
        return new a(str).dD(str2, str3);
    }

    public static boolean g(String str, String str2, long j) {
        return new a(str).H(str2, j);
    }
}
