package com.simpl.app.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.nio.charset.StandardCharsets;
import java.math.BigInteger;

@Service
public class HashService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    public String getHashForString(String stringToHash) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            md.update(stringToHash.getBytes(StandardCharsets.UTF_8));
            byte[] digest = md.digest();
            return String.format("%064x", new BigInteger(1, digest));
        } catch (NoSuchAlgorithmException nsae) {
            log.error("SHA-256 Hashing Algorithm does not exist");
        }

        return null;
    }

    public String getHashForObject(Object objectToHash) {
        byte[] bytes;
        ByteArrayOutputStream b = new ByteArrayOutputStream();
        try (ObjectOutputStream o = new ObjectOutputStream(b)) {
            o.writeObject(objectToHash);
            bytes = b.toByteArray();
            try {
                MessageDigest md = MessageDigest.getInstance("SHA-256");
                md.update(bytes);
                byte[] digest = md.digest();
                return String.format("%064x", new BigInteger(1, digest));
            } catch (NoSuchAlgorithmException nsae) {
                log.error("SHA-256 Hashing Algorithm does not exist");
            }
        } catch (IOException ioe) {
            log.error("Issue converting Object into bytes");
        }

        return null;
    }

    public String getHashForObjectAndString(Object objectToHash, String stringToHash) {
        String objectHash = this.getHashForObject(objectToHash);
        String stringHash = this.getHashForString(stringToHash);
        return this.getHashForString(objectHash + stringHash);
    }
}
