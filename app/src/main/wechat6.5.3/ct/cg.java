package ct;

import android.annotation.SuppressLint;
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
import java.util.Collections;
import java.util.List;
import org.eclipse.jdt.annotation.NonNull;
import org.eclipse.jdt.annotation.Nullable;

public final class cg extends cj {
    public int a = 0;
    public int b = 0;
    public int c = 0;
    public int d = 0;
    public int e = 0;
    public int f = 0;
    public int g = Integer.MAX_VALUE;
    public int h = Integer.MAX_VALUE;
    private final long i = System.currentTimeMillis();
    private List<NeighboringCellInfo> j;

    private cg() {
    }

    @Nullable
    public static cg a(bk bkVar, CellLocation cellLocation, SignalStrength signalStrength) {
        if (!bkVar.d() || cellLocation == null) {
            return null;
        }
        TelephonyManager a = bkVar.a();
        cg cgVar = new cg();
        if (cellLocation instanceof CdmaCellLocation) {
            try {
                CdmaCellLocation cdmaCellLocation = (CdmaCellLocation) cellLocation;
                cgVar.a = 2;
                cgVar.a(bkVar, a);
                cgVar.c = cdmaCellLocation.getSystemId();
                cgVar.d = cdmaCellLocation.getNetworkId();
                cgVar.e = cdmaCellLocation.getBaseStationId();
                cgVar.g = cdmaCellLocation.getBaseStationLatitude();
                cgVar.h = cdmaCellLocation.getBaseStationLongitude();
                if (signalStrength == null) {
                    cgVar.f = -1;
                    return cgVar;
                }
                cgVar.f = signalStrength.getCdmaDbm();
                return cgVar;
            } catch (Exception e) {
                return cgVar;
            }
        }
        try {
            GsmCellLocation gsmCellLocation = (GsmCellLocation) cellLocation;
            cgVar.a = 1;
            cgVar.a(bkVar, a);
            cgVar.d = gsmCellLocation.getLac();
            cgVar.e = gsmCellLocation.getCid();
            if (signalStrength == null) {
                cgVar.f = -1;
                return cgVar;
            }
            cgVar.f = (signalStrength.getGsmSignalStrength() * 2) - 113;
            return cgVar;
        } catch (Exception e2) {
            return cgVar;
        }
    }

    @Nullable
    @SuppressLint({"NewApi"})
    public static cg a(bk bkVar, CellInfo cellInfo) {
        int i = -88;
        if (!bkVar.d() || cellInfo == null) {
            return null;
        }
        TelephonyManager a = bkVar.a();
        cg cgVar = new cg();
        int dbm;
        if (cellInfo instanceof CellInfoCdma) {
            try {
                CellInfoCdma cellInfoCdma = (CellInfoCdma) cellInfo;
                CellIdentityCdma cellIdentity = cellInfoCdma.getCellIdentity();
                cgVar.a = 2;
                cgVar.a(bkVar, a);
                cgVar.c = cellIdentity.getSystemId();
                cgVar.d = cellIdentity.getNetworkId();
                cgVar.e = cellIdentity.getBasestationId();
                cgVar.g = cellIdentity.getLatitude();
                cgVar.h = cellIdentity.getLongitude();
                dbm = cellInfoCdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                cgVar.f = i;
                return cgVar;
            } catch (Exception e) {
                return cgVar;
            } catch (Error e2) {
                return cgVar;
            }
        } else if (cellInfo instanceof CellInfoGsm) {
            try {
                CellInfoGsm cellInfoGsm = (CellInfoGsm) cellInfo;
                cgVar.a = 1;
                CellIdentityGsm cellIdentity2 = cellInfoGsm.getCellIdentity();
                cgVar.a(bkVar, a);
                cgVar.d = cellIdentity2.getLac();
                cgVar.e = cellIdentity2.getCid();
                cgVar.b = cellIdentity2.getMcc();
                cgVar.c = cellIdentity2.getMnc();
                dbm = cellInfoGsm.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                cgVar.f = i;
                return cgVar;
            } catch (Exception e3) {
                return cgVar;
            } catch (Error e4) {
                return cgVar;
            }
        } else if (cellInfo instanceof CellInfoWcdma) {
            try {
                CellInfoWcdma cellInfoWcdma = (CellInfoWcdma) cellInfo;
                cgVar.a = 1;
                CellIdentityWcdma cellIdentity3 = cellInfoWcdma.getCellIdentity();
                cgVar.a(bkVar, a);
                cgVar.d = cellIdentity3.getLac();
                cgVar.e = cellIdentity3.getCid();
                cgVar.b = cellIdentity3.getMcc();
                cgVar.c = cellIdentity3.getMnc();
                dbm = cellInfoWcdma.getCellSignalStrength().getDbm();
                if (dbm > -110 && dbm < -40) {
                    i = dbm;
                }
                cgVar.f = i;
                return cgVar;
            } catch (Exception e5) {
                return cgVar;
            } catch (Error e6) {
                return cgVar;
            }
        } else if (!(cellInfo instanceof CellInfoLte)) {
            return cgVar;
        } else {
            try {
                CellInfoLte cellInfoLte = (CellInfoLte) cellInfo;
                cgVar.a = 1;
                CellIdentityLte cellIdentity4 = cellInfoLte.getCellIdentity();
                cgVar.a(bkVar, a);
                cgVar.d = cellIdentity4.getTac();
                cgVar.e = cellIdentity4.getCi();
                cgVar.b = cellIdentity4.getMcc();
                cgVar.c = cellIdentity4.getMnc();
                dbm = cellInfoLte.getCellSignalStrength().getDbm();
                if (dbm <= -110 || dbm >= -40) {
                    dbm = -88;
                }
                cgVar.f = dbm;
                return cgVar;
            } catch (Exception e7) {
                return cgVar;
            } catch (Error e8) {
                return cgVar;
            }
        }
    }

    private void a(bk bkVar, TelephonyManager telephonyManager) {
        bl g = bkVar.g();
        int i = g.k;
        int i2 = g.l;
        if (i <= 0 || i2 < 0) {
            int[] iArr = new int[2];
            ct.a(telephonyManager, iArr);
            g.k = iArr[0];
            g.l = iArr[1];
            return;
        }
        this.b = i;
        this.c = i2;
    }

    @NonNull
    public final synchronized List<NeighboringCellInfo> a() {
        if (this.j == null) {
            this.j = Collections.emptyList();
        }
        return this.j;
    }

    public final synchronized void a(@Nullable List<NeighboringCellInfo> list) {
        if (list != null) {
            this.j = Collections.unmodifiableList(list);
        } else {
            this.j = Collections.emptyList();
        }
    }

    public final String toString() {
        return "TxCellInfo [PhoneType=" + this.a + ", MCC=" + this.b + ", MNC=" + this.c + ", LAC=" + this.d + ", CID=" + this.e + ", RSSI=" + this.f + ", LAT=" + this.g + ", LNG=" + this.h + ", mTime=" + this.i + "]";
    }
}
