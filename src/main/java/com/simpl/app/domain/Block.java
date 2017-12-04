package com.simpl.app.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.HashMap;

@Entity
@Table(name = "block")
public class Block extends AbstractAuditingEntity implements Serializable {

    @Id
    private String hash;

    private HashMap<String, Object> data;

    public Block() {
    }

    public Block(String hash, HashMap<String, Object> data) {
        this.hash = hash;
        this.data = data;
    }

    public String getHash() {
        return hash;
    }

    public void setHash(String hash) {
        if (hash == null) {
            this.hash = hash;
        }
    }

    public HashMap<String, Object> getData() {
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }
}
