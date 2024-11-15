package com.fiap.vehicle.sales.domain.entity.usuario.validator;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class CpfValidator {

    public static boolean isValid(String cpf) {
        return cpf == null || cpf.isEmpty() || isCPF(cpf);
    }

    public static String sanitizar(String cpf) {
        if (!isValid(cpf)) {
            throw new IllegalArgumentException("O CPF informado é inválido");
        }
        return cpf.replaceAll("[^0-9]", "");
    }

    private static String format(final String value) {
        final var val = extractNumbers(value);
        if (val.length() == 11) {
            return val.replaceAll("(\\d{3})(\\d{3})(\\d{3})(\\d{2})", "$1.$2.$3-$4");
        } else if (val.length() == 14) {
            return val.replaceAll("(\\d{2})(\\d{3})(\\d{3})(\\d{4})(\\d{2})", "$1.$2.$3/$4-$5");
        }
        return val;
    }

    private static boolean isCPF(final String cnpjCpf) {
        return isCpfValid(cnpjCpf);
    }

    private static boolean isCpfValid(final String cpf) {
        final List<Integer> digits = extractNumbersToList(cpf);
        if (digits.size() == 11 && digits.stream().distinct().count() > 1) {
            return getCpfValid(digits.subList(0, 9)).equals(extractNumbers(cpf));
        }
        return false;
    }

    private static String getCpfValid(final List<Integer> digits) {
        digits.add(mod11(digits, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        digits.add(mod11(digits, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        return listToString(digits);
    }

    private static int mod11(final List<Integer> digits, final int... multipliers) {
        final var i = new AtomicInteger(0);
        final var rest = digits.stream().reduce(0, (p, e) -> p + e * multipliers[i.getAndIncrement()]) % 11;
        return rest > 9 ? 0 : rest;
    }

    private static String extractNumbers(final String s) {
        return Objects.nonNull(s) ? s.replaceAll("\\D+", "") : "";
    }

    private static List<Integer> extractNumbersToList(final String value) {
        final var digits = new ArrayList<Integer>();
        for (char item : extractNumbers(value).toCharArray()) {
            digits.add(Integer.parseInt(String.valueOf(item)));
        }
        return digits;
    }

    private static String listToString(final List<Integer> list) {
        return list.stream().map(Object::toString).reduce("", (p, e) -> p.concat(e));
    }
}


