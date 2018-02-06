package com.laoning.githubaio.repository.local.base;

import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.util.StringUtil;
import android.support.annotation.Nullable;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by laoning on 06/02/2018.
 */

public class IntegerListConverter {
    private static List<Long> splitToLongList(@Nullable String input) {
        if (input == null) {
            return null;
        }
        List<Long> result = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        while (tokenizer.hasMoreElements()) {
            final String item = tokenizer.nextToken();
            try {
                result.add(Long.parseLong(item));
            } catch (NumberFormatException ex) {
                Log.e("ROOM", "Malformed integer list", ex);
            }
        }
        return result;
    }

    @Nullable
    private static String joinIntoString(@Nullable List<Long> input) {
        if (input == null) {
            return null;
        }

        final int size = input.size();
        if (size == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(Long.toString(input.get(i)));
            if (i < size - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    @TypeConverter
    public static List<Long> stringToIntList(String data) {
        if (data == null) {
            return Collections.emptyList();
        }
        return splitToLongList(data);
    }

    @TypeConverter
    public static String intListToString(List<Long> ints) {
        return joinIntoString(ints);
    }
}
