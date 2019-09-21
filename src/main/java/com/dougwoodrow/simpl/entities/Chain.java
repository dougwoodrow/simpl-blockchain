package com.dougwoodrow.simpl.entities;

import java.util.ArrayList;
import java.util.List;

public class Chain {
    private List<Block> blocks;

    public Chain() {
        this.blocks = new ArrayList<>();
    }

    /**
     *
     * @param blocks
     */
    public Chain(List<Block> blocks) {
        this.blocks = blocks;
    }

    public void chain(Block block) {
    }

    public Block dechain(String hashId) {
        return null;
    }
}
