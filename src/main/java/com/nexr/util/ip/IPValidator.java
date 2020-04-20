package com.nexr.util.ip;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * Create by lucy on 2020-04-20
 **/
public class IPValidator {
    private IPValidator() {
    }

    private static IPValidator instance = new IPValidator();

    public static IPValidator getInstance() { return instance; }

    public void validate(String address) throws RuntimeException {
        try {
            validateIPv4(address);
        } catch (RuntimeException e) {
            validateIPv6(address);
        }
    }

    public void validateIPv4(String address) throws RuntimeException {
        if (address == null) throw new IllegalArgumentException("empty ipv4 address");
        List<String> pieces = Arrays.asList(address.split("\\."));
        if (pieces.size() != 4) throw new RuntimeException(address);
        for (String piece : pieces) {
            try {
                int num = Integer.parseInt(piece);
                if (num < 0 || num > 255 || !Integer.toString(num).equals(piece)) throw new RuntimeException(address);
            } catch (NumberFormatException e) {
                throw new RuntimeException(address);
            }
        }
    }

    public void validateIPv6(String address) throws RuntimeException {
        if (address == null) throw new IllegalArgumentException("empty ipv6 address");
        try {
            int doubleColonPosition = address.indexOf("::");
            if (doubleColonPosition == -1) {
                List<String> pieces = Arrays.asList(address.split(":"));
                if (pieces.size() == 7) { //possibility of ipv4 on end
                    for (Iterator iterator = pieces.iterator(); iterator.hasNext();) {
                        String piece = (String) iterator.next();
                        if (!validateHEX4(piece)) {
                            if (!iterator.hasNext())
                                validateIPv4(piece);
                            else
                                throw new RuntimeException(address);
                        }
                    }
                } else {
                    if (pieces.size() != 8)
                        throw new RuntimeException(address);

                    for (String piece : pieces)
                        if (!validateHEX4(piece)) throw new RuntimeException(address);
                }
            } else {
                if (address.indexOf("::", doubleColonPosition + 1) != -1) throw new RuntimeException(address);
                List<String> pieces = Arrays.asList(address.split("::"));
                if (pieces.size() != 0)   // if not "::" address
                    for (Iterator piecesIterator = pieces.iterator(); piecesIterator.hasNext();) {
                        List<String> parts = Arrays.asList(((String) piecesIterator.next()).split(":"));
                        for (Iterator partsIterator = parts.iterator(); partsIterator.hasNext();) {
                            String part = (String) partsIterator.next();
                            if (!validateHEX4(part))
                                if (!partsIterator.hasNext() && !piecesIterator.hasNext())
                                    validateIPv4(part);
                                else
                                    throw new RuntimeException(address);
                        }
                    }
            }
        } catch (RuntimeException e) {
            throw new RuntimeException(address);
        }
    }

    private boolean validateHEX4(String hex4) {
        if (hex4.length()>4) return false;
        try {
            if (hex4.length() != 0) Integer.parseInt(hex4, 16);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

}
