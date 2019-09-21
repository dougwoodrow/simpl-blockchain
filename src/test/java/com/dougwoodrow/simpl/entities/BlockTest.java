package com.dougwoodrow.simpl.entities;

import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class BlockTest extends TestCase {

    @Test
    public void testBlockHashingFunctionWorks() {
        HashMap<String, String> data = new HashMap<>();
        data.put("name", "Allison Nour");
        data.put("age", "25");

        Block block = new Block(data);
        Assert.assertNotNull(block);
    }
}
