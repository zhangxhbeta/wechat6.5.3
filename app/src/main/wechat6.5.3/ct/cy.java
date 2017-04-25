package ct;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.LocationManager;
import android.net.wifi.WifiManager;
import android.os.Build.VERSION;
import android.telephony.TelephonyManager;
import java.util.List;

public final class cy {
    private static cy a = null;

    public static cy a() {
        if (a == null) {
            a = new cy();
        }
        return a;
    }

    @SuppressLint({"NewApi"})
    public static int a(Context context) {
        Object obj;
        Object obj2;
        List allProviders;
        boolean z;
        if (context == null) {
            return -1;
        }
        int i;
        Object obj3;
        boolean isProviderEnabled;
        boolean b = b(context);
        LocationManager locationManager;
        try {
            Object obj4;
            WifiManager wifiManager = (WifiManager) context.getSystemService("wifi");
            if (wifiManager != null) {
                if (wifiManager.isWifiEnabled()) {
                    obj = 1;
                } else {
                    obj = null;
                }
                try {
                    if (VERSION.SDK_INT <= 17 || !wifiManager.isScanAlwaysAvailable()) {
                        i = 1;
                    } else {
                        obj3 = 1;
                        obj2 = 1;
                        locationManager = (LocationManager) context.getSystemService("location");
                        if (locationManager == null) {
                            isProviderEnabled = locationManager.isProviderEnabled("gps");
                            allProviders = locationManager.getAllProviders();
                            if (allProviders != null) {
                                z = false;
                            } else {
                                z = allProviders.contains("gps");
                            }
                        } else {
                            isProviderEnabled = false;
                            z = false;
                        }
                        if (b) {
                            i = 1;
                        } else {
                            i = 0;
                        }
                        if (obj2 == null) {
                            i |= 2;
                        }
                        if (!isProviderEnabled) {
                            i |= 4;
                        }
                        if (obj3 == null) {
                            i |= 8;
                        }
                        if (z) {
                            return i | 16;
                        }
                        return i;
                    }
                } catch (Exception e) {
                    obj3 = null;
                    obj2 = obj;
                    locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager == null) {
                        isProviderEnabled = locationManager.isProviderEnabled("gps");
                        allProviders = locationManager.getAllProviders();
                        if (allProviders != null) {
                            z = false;
                        } else {
                            z = allProviders.contains("gps");
                        }
                    } else {
                        isProviderEnabled = false;
                        z = false;
                    }
                    if (b) {
                        i = 1;
                    } else {
                        i = 0;
                    }
                    if (obj2 == null) {
                        i |= 2;
                    }
                    if (isProviderEnabled) {
                        i |= 4;
                    }
                    if (obj3 == null) {
                        i |= 8;
                    }
                    if (z) {
                        return i | 16;
                    }
                    return i;
                } catch (Error e2) {
                    obj3 = null;
                    obj2 = obj;
                    locationManager = (LocationManager) context.getSystemService("location");
                    if (locationManager == null) {
                        isProviderEnabled = false;
                        z = false;
                    } else {
                        isProviderEnabled = locationManager.isProviderEnabled("gps");
                        allProviders = locationManager.getAllProviders();
                        if (allProviders != null) {
                            z = allProviders.contains("gps");
                        } else {
                            z = false;
                        }
                    }
                    if (b) {
                        i = 0;
                    } else {
                        i = 1;
                    }
                    if (obj2 == null) {
                        i |= 2;
                    }
                    if (isProviderEnabled) {
                        i |= 4;
                    }
                    if (obj3 == null) {
                        i |= 8;
                    }
                    if (z) {
                        return i;
                    }
                    return i | 16;
                }
            }
            obj4 = null;
            obj = null;
            obj3 = obj4;
            obj2 = obj;
            try {
                locationManager = (LocationManager) context.getSystemService("location");
                if (locationManager == null) {
                    isProviderEnabled = false;
                    z = false;
                } else {
                    isProviderEnabled = locationManager.isProviderEnabled("gps");
                    allProviders = locationManager.getAllProviders();
                    if (allProviders != null) {
                        z = allProviders.contains("gps");
                    } else {
                        z = false;
                    }
                }
            } catch (Exception e3) {
                isProviderEnabled = false;
                z = false;
            }
        } catch (Exception e4) {
            obj = null;
            obj3 = null;
            obj2 = obj;
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
                allProviders = locationManager.getAllProviders();
                if (allProviders != null) {
                    z = false;
                } else {
                    z = allProviders.contains("gps");
                }
            } else {
                isProviderEnabled = false;
                z = false;
            }
            if (b) {
                i = 1;
            } else {
                i = 0;
            }
            if (obj2 == null) {
                i |= 2;
            }
            if (isProviderEnabled) {
                i |= 4;
            }
            if (obj3 == null) {
                i |= 8;
            }
            if (z) {
                return i | 16;
            }
            return i;
        } catch (Error e5) {
            obj = null;
            obj3 = null;
            obj2 = obj;
            locationManager = (LocationManager) context.getSystemService("location");
            if (locationManager == null) {
                isProviderEnabled = false;
                z = false;
            } else {
                isProviderEnabled = locationManager.isProviderEnabled("gps");
                allProviders = locationManager.getAllProviders();
                if (allProviders != null) {
                    z = allProviders.contains("gps");
                } else {
                    z = false;
                }
            }
            if (b) {
                i = 0;
            } else {
                i = 1;
            }
            if (obj2 == null) {
                i |= 2;
            }
            if (isProviderEnabled) {
                i |= 4;
            }
            if (obj3 == null) {
                i |= 8;
            }
            if (z) {
                return i;
            }
            return i | 16;
        }
        if (b) {
            i = 0;
        } else {
            i = 1;
        }
        if (obj2 == null) {
            i |= 2;
        }
        if (isProviderEnabled) {
            i |= 4;
        }
        if (obj3 == null) {
            i |= 8;
        }
        if (z) {
            return i;
        }
        return i | 16;
    }

    private static boolean b(Context context) {
        try {
            TelephonyManager telephonyManager = (TelephonyManager) context.getSystemService("phone");
            if (telephonyManager == null) {
                return false;
            }
            return telephonyManager.getSimState() == 5;
        } catch (Exception e) {
            return false;
        }
    }
}
