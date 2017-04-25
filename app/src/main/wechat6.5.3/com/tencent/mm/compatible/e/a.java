package com.tencent.mm.compatible.e;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningServiceInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.util.SparseArray;
import com.tencent.mm.a.e;
import com.tencent.mm.pointers.PBool;
import com.tencent.mm.pointers.PInt;
import com.tencent.mm.sdk.platformtools.aa;
import com.tencent.mm.sdk.platformtools.be;
import com.tencent.mm.sdk.platformtools.bf;
import com.tencent.mm.sdk.platformtools.u;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class a {
    public static Boolean cfL;

    private static class a {
        public String aRm;
        public int cfM;
        public int cfN;
        public int cfO;
        public SparseArray<String> cfP;

        private a() {
        }

        public final String toString() {
            return String.format(Locale.US, "pkgname: %s, minCode:%d, maxCode: %d, value: %s, chkExp: %d", new Object[]{this.aRm, Integer.valueOf(this.cfM), Integer.valueOf(this.cfN), this.cfP, Integer.valueOf(this.cfO)});
        }
    }

    private static class b {
        public int cfO;
        public SparseArray<String> cfP;
        public String cfQ;
        public String model;
        public String version;

        private b() {
        }

        public final String toString() {
            return String.format(Locale.US, "manufacture: %s, model: %s, version: %s, value: %s, chkExp: %d", new Object[]{this.cfQ, this.model, this.version, this.cfP, Integer.valueOf(this.cfO)});
        }
    }

    public static boolean a(String str, String str2, PInt pInt, PBool pBool) {
        if (str == null) {
            pBool.value = false;
            return false;
        } else if (str2 == null) {
            pBool.value = true;
            return false;
        } else if (str.equals(str2)) {
            pInt.value++;
            pBool.value = true;
            return true;
        } else {
            pBool.value = false;
            return false;
        }
    }

    public static List<PackageInfo> ay(boolean z) {
        Set hashSet = new HashSet();
        if (z) {
            ActivityManager activityManager = (ActivityManager) aa.getContext().getSystemService("activity");
            if (activityManager != null) {
                try {
                    List<RunningServiceInfo> runningServices = activityManager.getRunningServices(32767);
                    if (runningServices != null) {
                        for (RunningServiceInfo runningServiceInfo : runningServices) {
                            hashSet.add(runningServiceInfo.service.getPackageName());
                        }
                    }
                } catch (SecurityException e) {
                    v.e("MicroMsg.PermissionConfig", "getRunningServices failed");
                }
            }
        }
        PackageManager packageManager = aa.getContext().getPackageManager();
        if (packageManager == null) {
            return null;
        }
        List<PackageInfo> installedPackages = packageManager.getInstalledPackages(0);
        if (installedPackages == null || !z) {
            return installedPackages;
        }
        List<PackageInfo> arrayList = new ArrayList();
        for (PackageInfo packageInfo : installedPackages) {
            if (hashSet.contains(packageInfo.packageName)) {
                arrayList.add(packageInfo);
            }
        }
        return arrayList;
    }

    public static void a(String str, List<b> list, List<a> list2) {
        BufferedReader bufferedReader;
        Throwable th;
        if (e.aR(str)) {
            String str2 = ".perm.values.";
            String str3 = SQLiteDatabase.KeyEmpty;
            String bsY = u.bsY();
            if (bsY.equals("zh_CN")) {
                bsY = "zh_CN";
            } else if (bsY.equals("zh_TW") || bsY.equals("zh_HK")) {
                bsY = str3 + "zh_TW";
            } else {
                bsY = str3 + "en";
            }
            BufferedReader bufferedReader2 = null;
            try {
                bufferedReader = new BufferedReader(new FileReader(str));
                while (true) {
                    try {
                        str3 = bufferedReader.readLine();
                        if (str3 != null) {
                            String trim = str3.trim();
                            if (trim.length() != 0) {
                                Map q = bf.q(trim, "perm");
                                if (q == null) {
                                    v.e("MicroMsg.PermissionConfig", "unable to parse xml, " + trim);
                                } else {
                                    str3 = (String) q.get(".perm.type");
                                    if (str3 == null) {
                                        v.e("MicroMsg.PermissionConfig", "invalid config, " + trim);
                                    } else if (str3.equals("1")) {
                                        b bVar = new b();
                                        bVar.cfP = new SparseArray();
                                        bVar.cfQ = (String) q.get(".perm.manufacture");
                                        bVar.model = (String) q.get(".perm.model");
                                        bVar.version = (String) q.get(".perm.version_release");
                                        bVar.cfP.append(1, q.get(str2 + bsY));
                                        bVar.cfP.append(2, q.get(str2 + "camera." + bsY));
                                        bVar.cfO = be.KL((String) q.get(".perm.check_exception"));
                                        list.add(bVar);
                                    } else if (str3.equals("2")) {
                                        a aVar = new a();
                                        aVar.cfP = new SparseArray();
                                        aVar.aRm = (String) q.get(".perm.package");
                                        aVar.cfM = be.KL((String) q.get(".perm.min_versioncode"));
                                        aVar.cfN = be.KL((String) q.get(".perm.max_versioncode"));
                                        aVar.cfP.append(1, q.get(str2 + bsY));
                                        aVar.cfP.append(2, q.get(str2 + "camera." + bsY));
                                        aVar.cfO = be.KL((String) q.get(".perm.check_exception"));
                                        list2.add(aVar);
                                    }
                                }
                            }
                        } else {
                            try {
                                bufferedReader.close();
                                return;
                            } catch (IOException e) {
                                return;
                            }
                        }
                    } catch (FileNotFoundException e2) {
                        bufferedReader2 = bufferedReader;
                    } catch (IOException e3) {
                    }
                }
            } catch (FileNotFoundException e4) {
                try {
                    v.e("MicroMsg.PermissionConfig", "file not found exception");
                    if (bufferedReader2 != null) {
                        try {
                            bufferedReader2.close();
                            return;
                        } catch (IOException e5) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th2) {
                    bufferedReader = bufferedReader2;
                    th = th2;
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                        } catch (IOException e6) {
                        }
                    }
                    throw th;
                }
            } catch (IOException e7) {
                bufferedReader = null;
                try {
                    v.e("MicroMsg.PermissionConfig", "read permission config file failed");
                    if (bufferedReader != null) {
                        try {
                            bufferedReader.close();
                            return;
                        } catch (IOException e8) {
                            return;
                        }
                    }
                    return;
                } catch (Throwable th3) {
                    th = th3;
                    if (bufferedReader != null) {
                        bufferedReader.close();
                    }
                    throw th;
                }
            } catch (Throwable th22) {
                bufferedReader = null;
                th = th22;
                if (bufferedReader != null) {
                    bufferedReader.close();
                }
                throw th;
            }
        }
        v.i("MicroMsg.PermissionConfig", "file is not exists");
    }
}
