package com.lamba;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.function.Predicate;

public class PredicateUtil {
    public static final Predicate isObjectOk  = o -> {
        boolean oIsNotOk = false;
        boolean oDataIsNull = false;
        if (o == null || oIsNotOk || oDataIsNull) {
            return false;
        }
        return true;
    };

    public static final Predicate isListOk  = o -> {
        boolean oIsNotOk = false;
        boolean oDataIsNull = false;
        if (o == null || oIsNotOk || oDataIsNull) {
            return false;
        }
        return true;
    };

    public static  <T,R> R mapListFirstObjectToOneValue(List<T> list,Function<T,R> function,R defaultValue) {
        Optional<List<T>> optional = Optional.ofNullable(list).filter(isListOk);
        return optional.map(list1 -> list1.get(0)).map(function).orElse(defaultValue);
    }

    public static <T, R> R mapObjectToOneValue(T object, Function<T, R> function, R defaultValue) {
        Optional<T> optionalT = Optional.ofNullable(object).filter(isObjectOk);
        return optionalT.map(function).orElse(defaultValue);
    }

}
