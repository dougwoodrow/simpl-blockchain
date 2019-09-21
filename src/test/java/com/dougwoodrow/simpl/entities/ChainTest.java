package com.dougwoodrow.simpl.entities;

import junit.framework.TestCase;
import org.junit.Test;

public class ChainTest extends TestCase {

    @Test
    public void testChainBlockChaining() {
        Chain blockChain = new Chain();
        Block genesisBlock = new Block();

        blockChain.chain(genesisBlock);
    }
}
