package com.tencent.mm.sdk.platformtools;

import android.content.Context;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

public final class j {
    public static boolean dz(String str, String str2) {
        FileOutputStream fileOutputStream;
        Throwable e;
        FileInputStream fileInputStream = null;
        boolean z = true;
        if (be.kS(str) || be.kS(str2)) {
            v.w("MicroMsg.SDK.FilesCopy", "copy file but src path or dest path is null, return false.");
            return false;
        } else if (str.equals(str2)) {
            return true;
        } else {
            try {
                FileInputStream fileInputStream2 = new FileInputStream(str);
                try {
                    fileOutputStream = new FileOutputStream(str2);
                    try {
                        byte[] bArr = new byte[16384];
                        while (true) {
                            int read = fileInputStream2.read(bArr);
                            if (read != -1) {
                                fileOutputStream.write(bArr, 0, read);
                            } else {
                                try {
                                    break;
                                } catch (Throwable e2) {
                                    v.a("MicroMsg.SDK.FilesCopy", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                                    z = false;
                                }
                            }
                        }
                        fileInputStream2.close();
                        try {
                            fileOutputStream.close();
                            return z;
                        } catch (Throwable e22) {
                            v.a("MicroMsg.SDK.FilesCopy", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            return false;
                        }
                    } catch (Exception e3) {
                        e22 = e3;
                        fileInputStream = fileInputStream2;
                        try {
                            v.a("MicroMsg.SDK.FilesCopy", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e222) {
                                    v.a("MicroMsg.SDK.FilesCopy", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                            if (fileOutputStream != null) {
                                return false;
                            }
                            try {
                                fileOutputStream.close();
                                return false;
                            } catch (Throwable e2222) {
                                v.a("MicroMsg.SDK.FilesCopy", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                                return false;
                            }
                        } catch (Throwable th) {
                            e2222 = th;
                            if (fileInputStream != null) {
                                try {
                                    fileInputStream.close();
                                } catch (Throwable e4) {
                                    v.a("MicroMsg.SDK.FilesCopy", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                            if (fileOutputStream != null) {
                                try {
                                    fileOutputStream.close();
                                } catch (Throwable e5) {
                                    v.a("MicroMsg.SDK.FilesCopy", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
                                }
                            }
                            throw e2222;
                        }
                    } catch (Throwable th2) {
                        e2222 = th2;
                        fileInputStream = fileInputStream2;
                        if (fileInputStream != null) {
                            fileInputStream.close();
                        }
                        if (fileOutputStream != null) {
                            fileOutputStream.close();
                        }
                        throw e2222;
                    }
                } catch (Exception e6) {
                    e2222 = e6;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    v.a("MicroMsg.SDK.FilesCopy", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        return false;
                    }
                    fileOutputStream.close();
                    return false;
                } catch (Throwable th3) {
                    e2222 = th3;
                    fileOutputStream = null;
                    fileInputStream = fileInputStream2;
                    if (fileInputStream != null) {
                        fileInputStream.close();
                    }
                    if (fileOutputStream != null) {
                        fileOutputStream.close();
                    }
                    throw e2222;
                }
            } catch (Exception e7) {
                e2222 = e7;
                fileOutputStream = null;
                v.a("MicroMsg.SDK.FilesCopy", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    return false;
                }
                fileOutputStream.close();
                return false;
            } catch (Throwable th4) {
                e2222 = th4;
                fileOutputStream = null;
                if (fileInputStream != null) {
                    fileInputStream.close();
                }
                if (fileOutputStream != null) {
                    fileOutputStream.close();
                }
                throw e2222;
            }
        }
    }

    public static boolean n(String str, String str2, boolean z) {
        int i = 0;
        File file = new File(str);
        if (!file.exists()) {
            return false;
        }
        File file2 = new File(str2);
        if (file.isFile()) {
            if (!file2.isFile() && file2.exists()) {
                return false;
            }
            dz(str, str2);
            if (z) {
                file.delete();
            }
        } else if (file.isDirectory()) {
            if (!file2.exists()) {
                file2.mkdir();
            }
            if (!file2.isDirectory()) {
                return false;
            }
            String[] list = file.list();
            while (i < list.length) {
                n(str + "/" + list[i], str2 + "/" + list[i], z);
                i++;
            }
        }
        return true;
    }

    public static boolean y(Context context, String str, String str2) {
        int i = 0;
        try {
            return a(context.getAssets().open(str), str2, false);
        } catch (IOException e) {
            v.e("MicroMsg.SDK.FilesCopy", "copy assets file srcpath=%s to=%s failed, try pattern now", str, str2);
            while (true) {
                try {
                    if (!a(context.getAssets().open(str + "." + i), str2, true)) {
                        break;
                    }
                    v.d("MicroMsg.SDK.FilesCopy", "copy pattern %s", str + "." + i);
                    i++;
                } catch (IOException e2) {
                }
            }
            return true;
        }
    }

    private static boolean a(InputStream inputStream, String str, boolean z) {
        FileOutputStream fileOutputStream;
        Throwable e;
        boolean z2 = true;
        try {
            int available = inputStream.available();
            fileOutputStream = new FileOutputStream(str, z);
            try {
                byte[] bArr = new byte[16384];
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    fileOutputStream.write(bArr, 0, read);
                }
                if (!z) {
                    File file = new File(str);
                    if (!(file.exists() && ((long) available) == file.length())) {
                        z2 = false;
                    }
                }
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (Throwable e2) {
                        v.a("MicroMsg.SDK.FilesCopy", e2, SQLiteDatabase.KeyEmpty, new Object[0]);
                        z2 = false;
                    }
                }
                try {
                    fileOutputStream.close();
                    return z2;
                } catch (Throwable e22) {
                    v.a("MicroMsg.SDK.FilesCopy", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    return false;
                }
            } catch (Exception e3) {
                e22 = e3;
                try {
                    v.a("MicroMsg.SDK.FilesCopy", e22, SQLiteDatabase.KeyEmpty, new Object[0]);
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e222) {
                            v.a("MicroMsg.SDK.FilesCopy", e222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    if (fileOutputStream != null) {
                        return false;
                    }
                    try {
                        fileOutputStream.close();
                        return false;
                    } catch (Throwable e2222) {
                        v.a("MicroMsg.SDK.FilesCopy", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
                        return false;
                    }
                } catch (Throwable th) {
                    e2222 = th;
                    if (inputStream != null) {
                        try {
                            inputStream.close();
                        } catch (Throwable e4) {
                            v.a("MicroMsg.SDK.FilesCopy", e4, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    if (fileOutputStream != null) {
                        try {
                            fileOutputStream.close();
                        } catch (Throwable e5) {
                            v.a("MicroMsg.SDK.FilesCopy", e5, SQLiteDatabase.KeyEmpty, new Object[0]);
                        }
                    }
                    throw e2222;
                }
            }
        } catch (Exception e6) {
            e2222 = e6;
            fileOutputStream = null;
            v.a("MicroMsg.SDK.FilesCopy", e2222, SQLiteDatabase.KeyEmpty, new Object[0]);
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                return false;
            }
            fileOutputStream.close();
            return false;
        } catch (Throwable th2) {
            e2222 = th2;
            fileOutputStream = null;
            if (inputStream != null) {
                inputStream.close();
            }
            if (fileOutputStream != null) {
                fileOutputStream.close();
            }
            throw e2222;
        }
    }
}
