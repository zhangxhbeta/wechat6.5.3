package com.tencent.mapsdk.rastercore.f;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import com.tencent.mapsdk.raster.model.BitmapDescriptorFactory;
import com.tencent.mapsdk.raster.model.GeoPoint;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.d.e;
import java.io.File;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Stack;

public final class a {
    private static final int a = Float.floatToRawIntBits(0.0f);
    private static final int b = Float.floatToRawIntBits(-0.0f);

    static {
        Double.doubleToRawLongBits(0.0d);
        Double.doubleToRawLongBits(-0.0d);
        Double.longBitsToDouble(4368491638549381120L);
        Double.longBitsToDouble(4503599627370496L);
    }

    public static int a(Object[] objArr) {
        return Arrays.hashCode(objArr);
    }

    public static Bitmap a(Bitmap bitmap, float f) {
        return bitmap == null ? null : Bitmap.createScaledBitmap(bitmap, (int) (((float) bitmap.getWidth()) * f), (int) (((float) bitmap.getHeight()) * f), true);
    }

    public static Bitmap a(String str) {
        try {
            InputStream resourceAsStream = BitmapDescriptorFactory.class.getResourceAsStream("/assets/" + str);
            Bitmap decodeStream = BitmapFactory.decodeStream(resourceAsStream);
            resourceAsStream.close();
            return decodeStream;
        } catch (Exception e) {
            return null;
        }
    }

    public static GeoPoint a(LatLng latLng) {
        return new GeoPoint((int) (latLng.getLatitude() * 1000000.0d), (int) (latLng.getLongitude() * 1000000.0d));
    }

    public static LatLng a(GeoPoint geoPoint) {
        return new LatLng((((double) geoPoint.getLatitudeE6()) * 1.0d) / 1000000.0d, (((double) geoPoint.getLongitudeE6()) * 1.0d) / 1000000.0d);
    }

    public static String a(Context context) {
        String string;
        Exception e;
        if (context == null) {
            return "";
        }
        String str = "";
        try {
            ApplicationInfo applicationInfo = context.getPackageManager().getApplicationInfo(e.a().getPackageName(), 128);
            string = applicationInfo.metaData.getString("com.tencent.map.api_key");
            try {
                return TextUtils.isEmpty(string) ? applicationInfo.metaData.getString("TencentMapSDK") : string;
            } catch (Exception e2) {
                e = e2;
                new StringBuilder("error get mapkey:").append(e.getMessage());
                return string;
            }
        } catch (Exception e3) {
            Exception exception = e3;
            string = str;
            e = exception;
            new StringBuilder("error get mapkey:").append(e.getMessage());
            return string;
        }
    }

    public static String a(String str, Object obj) {
        return str + "=" + String.valueOf(obj);
    }

    public static String a(String... strArr) {
        int i = 0;
        StringBuilder stringBuilder = new StringBuilder();
        int length = strArr.length;
        int i2 = 0;
        while (i < length) {
            stringBuilder.append(strArr[i]);
            if (i2 != strArr.length - 1) {
                stringBuilder.append(",");
            }
            i2++;
            i++;
        }
        return stringBuilder.toString();
    }

    private static boolean a(double d, double d2, double d3, double d4, double d5, double d6) {
        return Math.abs(((d3 - d) * (d6 - d2)) - ((d5 - d) * (d4 - d2))) < 1.0E-9d && (d - d3) * (d - d5) <= 0.0d && (d2 - d4) * (d2 - d6) <= 0.0d;
    }

    public static boolean a(float f, float f2) {
        boolean z;
        int floatToRawIntBits = Float.floatToRawIntBits(f);
        int floatToRawIntBits2 = Float.floatToRawIntBits(0.0f);
        if (((floatToRawIntBits ^ floatToRawIntBits2) & Integer.MIN_VALUE) == 0) {
            z = Math.abs(floatToRawIntBits - floatToRawIntBits2) <= 1;
        } else {
            int i;
            if (floatToRawIntBits < floatToRawIntBits2) {
                i = floatToRawIntBits2 - a;
                floatToRawIntBits -= b;
            } else {
                i = floatToRawIntBits - a;
                floatToRawIntBits = floatToRawIntBits2 - b;
            }
            z = i <= 1 && floatToRawIntBits <= 1 - i;
        }
        return (!z || Float.isNaN(f) || Float.isNaN(0.0f)) ? false : true;
    }

    public static boolean a(LatLng latLng, List<LatLng> list) {
        double longitude = latLng.getLongitude();
        double latitude = latLng.getLatitude();
        double latitude2 = latLng.getLatitude();
        int i = 0;
        for (int i2 = 0; i2 < list.size() - 1; i2++) {
            double longitude2 = ((LatLng) list.get(i2)).getLongitude();
            double latitude3 = ((LatLng) list.get(i2)).getLatitude();
            double longitude3 = ((LatLng) list.get(i2 + 1)).getLongitude();
            double latitude4 = ((LatLng) list.get(i2 + 1)).getLatitude();
            if (a(longitude, latitude, longitude2, latitude3, longitude3, latitude4)) {
                return true;
            }
            int i3;
            if (Math.abs(latitude4 - latitude3) >= 1.0E-9d) {
                if (a(longitude2, latitude3, longitude, latitude, 180.0d, latitude2)) {
                    if (latitude3 > latitude4) {
                        i3 = i + 1;
                        i = i3;
                    }
                } else if (!a(longitude3, latitude4, longitude, latitude, 180.0d, latitude2)) {
                    Object obj;
                    double d = ((longitude3 - longitude2) * (latitude2 - latitude)) - ((latitude4 - latitude3) * (180.0d - longitude));
                    if (d != 0.0d) {
                        double d2 = (((latitude3 - latitude) * (180.0d - longitude)) - ((longitude2 - longitude) * (latitude2 - latitude))) / d;
                        longitude2 = (((longitude3 - longitude2) * (latitude3 - latitude)) - ((longitude2 - longitude) * (latitude4 - latitude3))) / d;
                        if (d2 >= 0.0d && d2 <= 1.0d && longitude2 >= 0.0d && longitude2 <= 1.0d) {
                            obj = 1;
                            if (obj != null) {
                                i3 = i + 1;
                                i = i3;
                            }
                        }
                    }
                    obj = null;
                    if (obj != null) {
                        i3 = i + 1;
                        i = i3;
                    }
                } else if (latitude4 > latitude3) {
                    i3 = i + 1;
                    i = i3;
                }
            }
            i3 = i;
            i = i3;
        }
        return i % 2 != 0;
    }

    public static final boolean a(Collection<?> collection) {
        return collection == null || collection.size() <= 0;
    }

    public static void b(String str) {
        if (str != null && str.length() > 0) {
            Stack stack = new Stack();
            stack.push(str);
            while (!stack.isEmpty()) {
                File file = new File((String) stack.peek());
                if (!file.exists()) {
                    stack.pop();
                } else if (file.isDirectory()) {
                    File[] listFiles = file.listFiles();
                    if (listFiles == null || listFiles.length == 0) {
                        file.delete();
                        stack.pop();
                    } else {
                        for (File file2 : listFiles) {
                            if (file2.isDirectory()) {
                                stack.push(file2.getAbsolutePath());
                            } else {
                                file2.delete();
                            }
                        }
                    }
                } else {
                    file.delete();
                    stack.pop();
                }
            }
        }
    }
}
