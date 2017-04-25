package com.tencent.mm.compatible.util;

import com.tencent.mm.modelsfs.FileOp;
import com.tencent.mm.sdk.platformtools.v;
import com.tencent.mmdb.database.SQLiteDatabase;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;

public class Exif {
    public static final int PARSE_EXIF_ERROR_CORRUPT = 1985;
    public static final int PARSE_EXIF_ERROR_NO_EXIF = 1983;
    public static final int PARSE_EXIF_ERROR_NO_JPEG = 1982;
    public static final int PARSE_EXIF_ERROR_UNKNOWN_BYTEALIGN = 1984;
    public static final int PARSE_EXIF_SUCCESS = 0;
    private static final String TAG = "MicroMsg.Exif";
    public double altitude = 0.0d;
    public short bitsPerSample;
    public String copyright;
    public String dateTime;
    public String dateTimeDigitized;
    public String dateTimeOriginal;
    public double exposureBiasValue;
    public double exposureTime;
    public double fNumber;
    public byte flash;
    public double focalLength;
    public short focalLengthIn35mm;
    public String imageDescription;
    public int imageHeight;
    public int imageWidth;
    public short isoSpeedRatings;
    public double latitude = -1.0d;
    public double longitude = -1.0d;
    public String make;
    public short meteringMode;
    public String model;
    public short orientation;
    public double shutterSpeedValue;
    public String software;
    public String subSecTimeOriginal;
    public double subjectDistance;

    public static class a {
        public double altitude;
        public double latitude;
        public double longitude;

        public a(double d, double d2, double d3) {
            this.latitude = d;
            this.longitude = d2;
            this.altitude = d3;
        }
    }

    private native int nativeParse(byte[] bArr, int i, int i2);

    private native int nativeParseFile(String str);

    public int parseFromFile(String str) {
        if (new File(str).exists()) {
            v.i(TAG, "parse EXIF from file on real fs, result: %d, path: %s", Integer.valueOf(nativeParseFile(str)), str);
            return nativeParseFile(str);
        }
        InputStream inputStream = null;
        try {
            inputStream = FileOp.openRead(str);
            int parseFromStream = parseFromStream(inputStream);
            if (inputStream == null) {
                return parseFromStream;
            }
            try {
                inputStream.close();
                return parseFromStream;
            } catch (IOException e) {
                return parseFromStream;
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e2) {
                }
            }
        }
    }

    public int parseFromStream(InputStream inputStream) {
        byte[] bArr = new byte[65536];
        int read = inputStream.read(bArr);
        if (read <= 0) {
            return PARSE_EXIF_ERROR_NO_JPEG;
        }
        int nativeParse = nativeParse(bArr, 0, read);
        v.i(TAG, "parse EXIF from Stream, ret = " + nativeParse);
        return nativeParse;
    }

    public int parseFrom(byte[] bArr) {
        return nativeParse(bArr, 0, bArr.length);
    }

    public int parseFrom(byte[] bArr, int i, int i2) {
        return nativeParse(bArr, i, i2);
    }

    public int getOrientationInDegree() {
        switch (this.orientation) {
            case (short) 3:
                return 180;
            case (short) 6:
                return 90;
            case (short) 8:
                return 270;
            default:
                return 0;
        }
    }

    public a getLocation() {
        if (this.latitude < 0.0d || this.longitude < 0.0d) {
            return null;
        }
        return new a(this.latitude, this.longitude, this.altitude);
    }

    public long getUxtimeDatatimeOriginal() {
        long j = 0;
        try {
            if (this.dateTimeOriginal != null) {
                j = new SimpleDateFormat("yyyy:MM:dd HH:mm:ss").parse(this.dateTimeOriginal).getTime() / 1000;
            }
        } catch (Throwable e) {
            v.a(TAG, e, SQLiteDatabase.KeyEmpty, new Object[0]);
        }
        return j;
    }

    public static Exif fromFile(String str) {
        Exif exif = new Exif();
        try {
            v.i(TAG, "parse EXIF, result: " + exif.parseFromFile(str));
        } catch (IOException e) {
            v.w(TAG, "parse EXIF failed: " + e.getMessage());
        }
        return exif;
    }
}
