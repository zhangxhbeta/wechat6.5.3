package com.tencent.mm.compatible.d;

import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;

public final class l {
    static int cen = 0;
    static String ceo = null;

    public static int rx() {
        int i;
        int i2 = 15;
        int i3 = m.rE() ? 7 : m.rF() ? 3 : 1;
        if (p.cez.ceq && p.cez.ces == 0) {
            v.d("MicroMsg.CpuChecker", "disable armv6 by server ");
            i3 &= -3;
        }
        if (p.cez.ceq && p.cez.cer == 0) {
            v.d("MicroMsg.CpuChecker", "disable armv7 by server ");
            i3 &= -5;
        }
        int rG = m.rG();
        if (rG > 16) {
            rG = 15;
        } else if (rG <= 0) {
            rG = 1;
        }
        int i4 = be.getInt(ry(), 0) / 1000;
        if (rG > 4) {
            i = i4 * 4;
        } else if (rG > 2) {
            i = i4 * 2;
        } else if (rG > 1) {
            i = (i4 * 3) >> 1;
        } else {
            i = i4;
        }
        i /= 100;
        if (i > 30) {
            i = 30;
        } else if (i < 5) {
            i = 5;
        }
        if (i > 5 || rG < 4) {
            i2 = i;
        }
        i3 = ((i3 + (rG << 4)) << 8) + i2;
        cen = i3;
        return i3;
    }

    public static String ry() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_max_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            str = SQLiteDatabase.KeyEmpty;
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Throwable e) {
            v.a("MicroMsg.CpuChecker", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            str = "0";
        }
        if (str.length() == 0) {
            return "0";
        }
        return str.trim();
    }

    public static String rz() {
        String str;
        try {
            InputStream inputStream = new ProcessBuilder(new String[]{"/system/bin/cat", "/sys/devices/system/cpu/cpu0/cpufreq/cpuinfo_min_freq"}).start().getInputStream();
            byte[] bArr = new byte[24];
            str = SQLiteDatabase.KeyEmpty;
            while (inputStream.read(bArr) != -1) {
                str = str + new String(bArr);
            }
            inputStream.close();
        } catch (Throwable e) {
            v.a("MicroMsg.CpuChecker", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            str = "0";
        }
        if (str.length() == 0) {
            return "0";
        }
        return str.trim();
    }

    public static String rA() {
        BufferedReader bufferedReader;
        String readLine;
        Throwable e;
        Reader reader;
        FileReader fileReader = null;
        try {
            Reader fileReader2 = new FileReader("/sys/devices/system/cpu/cpu0/cpufreq/scaling_cur_freq");
            try {
                bufferedReader = new BufferedReader(fileReader2);
                try {
                    readLine = bufferedReader.readLine();
                    try {
                        bufferedReader.close();
                        fileReader2.close();
                    } catch (Exception e2) {
                    }
                } catch (Exception e3) {
                    e = e3;
                    reader = fileReader2;
                    try {
                        v.a("MicroMsg.CpuChecker", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                        readLine = "0";
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e4) {
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        if (readLine.length() != 0) {
                            return "0";
                        }
                        return readLine.trim();
                    } catch (Throwable th) {
                        e = th;
                        if (bufferedReader != null) {
                            try {
                                bufferedReader.close();
                            } catch (Exception e5) {
                                throw e;
                            }
                        }
                        if (fileReader != null) {
                            fileReader.close();
                        }
                        throw e;
                    }
                } catch (Throwable th2) {
                    e = th2;
                    reader = fileReader2;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    if (fileReader != null) {
                        fileReader.close();
                    }
                    throw e;
                }
            } catch (Exception e6) {
                e = e6;
                bufferedReader = null;
                reader = fileReader2;
                v.a("MicroMsg.CpuChecker", e, SQLiteDatabase.KeyEmpty, new Object[0]);
                readLine = "0";
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                if (readLine.length() != 0) {
                    return readLine.trim();
                }
                return "0";
            } catch (Throwable th3) {
                e = th3;
                bufferedReader = null;
                reader = fileReader2;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                if (fileReader != null) {
                    fileReader.close();
                }
                throw e;
            }
        } catch (Exception e7) {
            e = e7;
            bufferedReader = null;
            v.a("MicroMsg.CpuChecker", e, SQLiteDatabase.KeyEmpty, new Object[0]);
            readLine = "0";
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            if (readLine.length() != 0) {
                return readLine.trim();
            }
            return "0";
        } catch (Throwable th4) {
            e = th4;
            bufferedReader = null;
            if (bufferedReader != null) {
                bufferedReader.close();
            }
            if (fileReader != null) {
                fileReader.close();
            }
            throw e;
        }
        if (readLine.length() != 0) {
            return "0";
        }
        return readLine.trim();
    }
}
