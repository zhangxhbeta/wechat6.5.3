package com.tencent.tmassistantsdk.downloadservice;

import android.content.res.Resources.NotFoundException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ByteRange {
    protected static final String BYTES_UNIT = "bytes";
    protected static final Pattern CONTENT_RANGE_HEADER_PATTERN = Pattern.compile("^\\s*bytes\\s+(\\d+)-(\\d+)/(\\d+)\\s*$");
    protected static final String INVALID_RANGE_HEADER_REGEX = "((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)";
    protected static final Pattern RANGE_HEADER_PATTERN = Pattern.compile("^\\s*([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)((?:\\s*,\\s*(?:\\d*)-(?:\\d*))*)\\s*$");
    protected static final String UNIT_REGEX = "([^=\\s]+)";
    protected static final String VALID_CONTENT_RANGE_HEADER_REGEX = "bytes\\s+(\\d+)-(\\d+)/(\\d+)";
    protected static final String VALID_RANGE_HEADER_REGEX = "([^=\\s]+)\\s*=\\s*(\\d*)\\s*-\\s*(\\d*)";
    protected final Long end;
    protected final long start;

    public ByteRange(long j) {
        this(j, null);
    }

    public ByteRange(long j, long j2) {
        this(j, Long.valueOf(j2));
        if (j < 0) {
            throw new IllegalArgumentException("If end is provided, start must be positive.");
        } else if (j2 < j) {
            throw new IllegalArgumentException("end must be >= start.");
        }
    }

    protected ByteRange(long j, Long l) {
        this.start = j;
        this.end = l;
    }

    public boolean hasEnd() {
        return this.end != null;
    }

    public long getStart() {
        return this.start;
    }

    public long getEnd() {
        if (hasEnd()) {
            return this.end.longValue();
        }
        throw new IllegalStateException("Byte-range does not have end.  Check hasEnd() before use");
    }

    public String toString() {
        if (this.end != null) {
            return "bytes=" + this.start + "-" + this.end;
        }
        if (this.start < 0) {
            return "bytes=" + this.start;
        }
        return "bytes=" + this.start + "-";
    }

    public static ByteRange parseContentRange(String str) {
        Matcher matcher = CONTENT_RANGE_HEADER_PATTERN.matcher(str);
        if (matcher.matches()) {
            return new ByteRange(Long.parseLong(matcher.group(1)), Long.parseLong(matcher.group(2)));
        }
        throw new Throwable("Invalid content-range format: " + str);
    }

    public static long getTotalSize(String str) {
        int indexOf = str.indexOf("/");
        if (indexOf != -1) {
            return Long.parseLong(str.substring(indexOf + 1));
        }
        throw new NotFoundException();
    }

    public int hashCode() {
        int hashCode = Long.valueOf(this.start).hashCode() + 629;
        if (this.end != null) {
            return (hashCode * 37) + this.end.hashCode();
        }
        return hashCode;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ByteRange)) {
            return false;
        }
        ByteRange byteRange = (ByteRange) obj;
        if (this.start != byteRange.getStart() || hasEnd() != byteRange.hasEnd()) {
            return false;
        }
        if (hasEnd()) {
            return this.end.equals(Long.valueOf(byteRange.getEnd()));
        }
        return true;
    }
}
