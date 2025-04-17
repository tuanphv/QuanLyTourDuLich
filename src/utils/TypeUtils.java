package utils;

import java.lang.reflect.Field;

public class TypeUtils {

    public static Class<?>[] getTypes(Object obj) {
        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        Class<?>[] types = new Class<?>[fields.length];

        for (int i = 0; i < fields.length; i++) {
            types[i] = fields[i].getType();
        }
        return types;
    }
}
