package com.dougwoodrow.simpl.entities;

import javax.persistence.Entity;
import java.util.HashMap;

@Entity
public class Block {

    private String id;

    private String hash;

    private HashMap<String, ?> data;

    /**
     *
     * @param data
     */
    public Block(HashMap<String, ?> data) {
        this.data = data;
    }

    /**
     *
     * @param id
     * @param hash
     * @param data
     */
    public Block(String id, String hash, HashMap<String, ?> data) {
        this.id = id;
        this.hash = hash;
        this.data = data;
    }



    public String getHash() {
        // TODO: Take ID and Data as string
        return "";
    }
}
