package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import android.provider.Settings.Global;
import android.provider.Settings.System;
import android.telephony.CellIdentityCdma;
import android.telephony.CellIdentityGsm;
import android.telephony.CellIdentityLte;
import android.telephony.CellIdentityWcdma;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.CellLocation;
import android.telephony.NeighboringCellInfo;
import android.telephony.SignalStrength;
import android.telephony.TelephonyManager;
import android.telephony.cdma.CdmaCellLocation;
import android.telephony.gsm.GsmCellLocation;
import ct.b.a;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;

public final class ct {
    public static boolean a = false;

    @SuppressLint({"NewApi"})
    public static boolean a(Context context) {
        boolean z = true;
        if (VERSION.SDK_INT >= 17) {
            try {
                if (Global.getInt(context.getContentResolver(), "airplane_mode_on") != 1) {
                    z = false;
                }
                return z;
            } catch (Exception e) {
                return false;
            } catch (Error e2) {
                return false;
            }
        }
        try {
            if (System.getInt(context.getContentResolver(), "airplane_mode_on") != 1) {
                z = false;
            }
            return z;
        } catch (Exception e3) {
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static CellInfo a(bk bkVar) {
        try {
            TelephonyManager a = bkVar.a();
            if (a != null) {
                CellInfo cellInfo;
                List<CellInfo> allCellInfo = a.getAllCellInfo();
                if (allCellInfo != null) {
                    CellInfo cellInfo2 = null;
                    for (CellInfo cellInfo3 : allCellInfo) {
                        if (!cellInfo3.isRegistered()) {
                            cellInfo3 = cellInfo2;
                        }
                        cellInfo2 = cellInfo3;
                    }
                    cellInfo3 = cellInfo2;
                } else {
                    cellInfo3 = null;
                }
                if (cellInfo3 != null || allCellInfo == null || allCellInfo.size() <= 0) {
                    return cellInfo3;
                }
                return (CellInfo) allCellInfo.get(0);
            }
        } catch (Throwable e) {
            a.a("Cells", "cannot get cell location", e);
        } catch (Throwable e2) {
            a.a("Cells", "cannot get cell location", e2);
        }
        return null;
    }

    /* JADX WARNING: inconsistent code. */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.telephony.CellLocation b(ct.bk r6) {
        /*
        r2 = 0;
        r1 = 1;
        r3 = r6.a();
        if (r3 == 0) goto L_0x005e;
    L_0x0008:
        r4 = r3.getCellLocation();	 Catch:{ Exception -> 0x0052 }
        r0 = r3.getSimState();	 Catch:{ Exception -> 0x0052 }
        r5 = 5;
        if (r0 != r5) goto L_0x004b;
    L_0x0013:
        r0 = r1;
    L_0x0014:
        r3 = r3.getSubscriberId();	 Catch:{ Exception -> 0x004f }
        r3 = android.text.TextUtils.isEmpty(r3);	 Catch:{ Exception -> 0x004f }
        if (r3 != 0) goto L_0x004d;
    L_0x001e:
        r3 = r1;
    L_0x001f:
        if (r0 == 0) goto L_0x003c;
    L_0x0021:
        if (r3 == 0) goto L_0x003c;
    L_0x0023:
        if (r4 == 0) goto L_0x0031;
    L_0x0025:
        r0 = b(r4);	 Catch:{ Exception -> 0x0052 }
        if (r0 != 0) goto L_0x0031;
    L_0x002b:
        r0 = a(r4);	 Catch:{ Exception -> 0x0052 }
        if (r0 >= 0) goto L_0x003a;
    L_0x0031:
        r0 = r6.a;	 Catch:{ Exception -> 0x0052 }
        r0 = a(r0);	 Catch:{ Exception -> 0x0052 }
        if (r0 != 0) goto L_0x003a;
    L_0x0039:
        r2 = r1;
    L_0x003a:
        a = r2;	 Catch:{ Exception -> 0x0052 }
    L_0x003c:
        r0 = a;	 Catch:{ Exception -> 0x0052 }
        if (r0 == 0) goto L_0x0049;
    L_0x0040:
        r0 = "Cells";
        r2 = "location permission denied!";
        ct.b.a.b(r0, r2);	 Catch:{ Exception -> 0x0052 }
    L_0x0049:
        r0 = r4;
    L_0x004a:
        return r0;
    L_0x004b:
        r0 = r2;
        goto L_0x0014;
    L_0x004d:
        r3 = r2;
        goto L_0x001f;
    L_0x004f:
        r3 = move-exception;
        r3 = r1;
        goto L_0x001f;
    L_0x0052:
        r0 = move-exception;
        r2 = "Cells";
        r3 = "cannot get cell location";
        ct.b.a.a(r2, r3, r0);
        a = r1;
    L_0x005e:
        r0 = android.telephony.CellLocation.getEmpty();
        goto L_0x004a;
        */
        throw new UnsupportedOperationException("Method not decompiled: ct.ct.b(ct.bk):android.telephony.CellLocation");
    }

    public static List<NeighboringCellInfo> c(bk bkVar) {
        TelephonyManager a = bkVar.a();
        if (a != null) {
            try {
                return a.getNeighboringCellInfo();
            } catch (Throwable e) {
                a.a("Cells", "cannot get NeighboringCellInfo", e);
            }
        }
        return Collections.emptyList();
    }

    public static int a(CellLocation cellLocation) {
        if (cellLocation instanceof CdmaCellLocation) {
            return ((CdmaCellLocation) cellLocation).getBaseStationId();
        }
        try {
            return ((GsmCellLocation) cellLocation).getCid();
        } catch (Exception e) {
            return -1;
        }
    }

    private static boolean b(CellLocation cellLocation) {
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            if (gsmCellLocation.getCid() == 0 && gsmCellLocation.getLac() == 0) {
                return true;
            }
        } catch (ClassCastException e) {
        }
        return false;
    }

    @SuppressLint({"NewApi"})
    public static boolean a(CellInfo cellInfo, CellInfo cellInfo2) {
        if (a.a((Object) cellInfo, (Object) cellInfo2) || cellInfo.getClass() != cellInfo2.getClass()) {
            return false;
        }
        try {
            if (cellInfo instanceof CellInfoGsm) {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo2;
                if (((CellInfoGsm) cellInfo).getCellIdentity().getCid() == cellInfoGsm.getCellIdentity().getCid()) {
                    return true;
                }
                return false;
            } else if (cellInfo instanceof CellInfoCdma) {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo2;
                if (((CellInfoCdma) cellInfo).getCellIdentity().getBasestationId() == cellInfoCdma.getCellIdentity().getBasestationId()) {
                    return true;
                }
                return false;
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo2;
                if (((CellInfoWcdma) cellInfo).getCellIdentity().getCid() == cellInfoWcdma.getCellIdentity().getCid()) {
                    return true;
                }
                return false;
            } else if (!(cellInfo instanceof CellInfoLte)) {
                return false;
            } else {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo2;
                if (((CellInfoLte) cellInfo).getCellIdentity().getCi() == cellInfoLte.getCellIdentity().getCi()) {
                    return true;
                }
                return false;
            }
        } catch (Exception e) {
            return false;
        } catch (Error e2) {
            return false;
        }
    }

    public static boolean a(CellLocation cellLocation, CellLocation cellLocation2) {
        if (a.a((Object) cellLocation, (Object) cellLocation2) || cellLocation.getClass() != cellLocation2.getClass()) {
            return false;
        }
        if (cellLocation instanceof GsmCellLocation) {
            if (((GsmCellLocation) cellLocation).getCid() == ((GsmCellLocation) cellLocation2).getCid()) {
                return true;
            }
            return false;
        } else if (!(cellLocation instanceof CdmaCellLocation)) {
            return false;
        } else {
            if (((CdmaCellLocation) cellLocation).getBaseStationId() == ((CdmaCellLocation) cellLocation2).getBaseStationId()) {
                return true;
            }
            return false;
        }
    }

    @SuppressLint({"NewApi"})
    public static boolean a(CellInfo cellInfo) {
        if (cellInfo == null) {
            return false;
        }
        try {
            int mcc;
            int mnc;
            int lac;
            int cid;
            if (cellInfo instanceof CellInfoGsm) {
                CellIdentityGsm cellIdentity = ((CellInfoGsm) cellInfo).getCellIdentity();
                mcc = cellIdentity.getMcc();
                mnc = cellIdentity.getMnc();
                lac = cellIdentity.getLac();
                cid = cellIdentity.getCid();
                if (mcc < 0 || mnc < 0 || lac <= 0 || lac >= 65535 || cid == 268435455 || cid == Integer.MAX_VALUE || cid == 50594049 || cid == 65535 || cid == 8 || cid == 10 || cid == 33 || cid <= 0) {
                    return false;
                }
            } else if (cellInfo instanceof CellInfoCdma) {
                CellIdentityCdma cellIdentity2 = ((CellInfoCdma) cellInfo).getCellIdentity();
                mcc = cellIdentity2.getSystemId();
                mnc = cellIdentity2.getNetworkId();
                cid = cellIdentity2.getBasestationId();
                if (mcc < 0 || mnc < 0 || mnc > 65535 || cid < 0 || cid > 65535) {
                    return false;
                }
                if (mcc == 0 && mnc == 0 && cid == 0) {
                    return false;
                }
            } else if (cellInfo instanceof CellInfoWcdma) {
                CellIdentityWcdma cellIdentity3 = ((CellInfoWcdma) cellInfo).getCellIdentity();
                mcc = cellIdentity3.getMcc();
                mnc = cellIdentity3.getMnc();
                lac = cellIdentity3.getLac();
                cid = cellIdentity3.getCid();
                if (mcc < 0 || mnc < 0 || lac <= 0 || lac >= 65535 || cid == 268435455 || cid == Integer.MAX_VALUE || cid == 50594049 || cid == 65535 || cid == 8 || cid == 10 || cid == 33) {
                    return false;
                }
                if (cid <= 0) {
                    return false;
                }
            } else if (cellInfo instanceof CellInfoLte) {
                CellIdentityLte cellIdentity4 = ((CellInfoLte) cellInfo).getCellIdentity();
                mcc = cellIdentity4.getMcc();
                mnc = cellIdentity4.getMnc();
                lac = cellIdentity4.getTac();
                cid = cellIdentity4.getCi();
                if (mcc < 0 || mnc < 0 || lac <= 0 || lac >= 65535 || cid == 268435455 || cid == Integer.MAX_VALUE || cid == 50594049 || cid == 65535 || cid == 8 || cid == 10 || cid == 33) {
                    return false;
                }
                if (cid <= 0) {
                    return false;
                }
            }
            return true;
        } catch (Exception e) {
            return false;
        } catch (Error e2) {
            return false;
        }
    }

    public static boolean a(cg cgVar) {
        if (a.a((Object) cgVar)) {
            return false;
        }
        return a(cgVar.a, cgVar.b, cgVar.c, cgVar.d, cgVar.e);
    }

    public static boolean a(int i, int i2, int i3, int i4, int i5) {
        if (b(i)) {
            if (i2 < 0 || i3 < 0 || i4 < 0 || i4 > 65535 || i5 < 0 || i5 > 65535 || (i3 == 0 && i4 == 0 && i5 == 0)) {
                return false;
            }
            return true;
        } else if (i2 < 0 || i3 < 0 || i4 <= 0 || i4 >= 65535) {
            return false;
        } else {
            if (i5 == 268435455 || i5 == Integer.MAX_VALUE || i5 == 50594049 || i5 == 65535 || i5 <= 0) {
                return false;
            }
            if (i5 == 65535 || i5 <= 0) {
                return false;
            }
            return true;
        }
    }

    public static boolean a(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        if (signalStrength == null || signalStrength2 == null) {
            return true;
        }
        int b = b(i, signalStrength, signalStrength2);
        if (a(i)) {
            if (b <= 3) {
                return false;
            }
            return true;
        } else if (!b(i)) {
            return false;
        } else {
            if (b <= 6) {
                return false;
            }
            return true;
        }
    }

    private static int b(int i, SignalStrength signalStrength, SignalStrength signalStrength2) {
        try {
            if (a(i)) {
                return signalStrength.getGsmSignalStrength() - signalStrength2.getGsmSignalStrength();
            }
            if (b(i)) {
                return signalStrength.getCdmaDbm() - signalStrength2.getCdmaDbm();
            }
            return 0;
        } catch (NoSuchMethodError e) {
        }
    }

    private static boolean a(int i) {
        return i == 1;
    }

    private static boolean b(int i) {
        return i == 2;
    }

    public static void a(@NonNull TelephonyManager telephonyManager, @NonNull int[] iArr) {
        String networkOperator = telephonyManager.getNetworkOperator();
        if (networkOperator != null && networkOperator.length() >= 5) {
            try {
                iArr[0] = Integer.parseInt(networkOperator.substring(0, 3));
                iArr[1] = Integer.parseInt(networkOperator.substring(3, 5));
                return;
            } catch (Throwable e) {
                a.a("Cells", "getMccMnc: ", e);
            } catch (Throwable e2) {
                a.a("Cells", "getMccMnc: ", e2);
            }
        }
        Arrays.fill(iArr, 0);
    }
}
