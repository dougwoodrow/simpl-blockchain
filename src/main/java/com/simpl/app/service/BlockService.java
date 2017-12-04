package com.simpl.app.service;

import com.simpl.app.domain.Block;
import com.simpl.app.repository.BlockRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

@Service
public class BlockService {
    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Inject
    private BlockRepository blockRepository;

    @Inject
    private HashService hashService;

    @PostConstruct
    private void createStartupBlock() {
        Block mostRecentBlock = this.blockRepository.findFirstByCreatedDateDesc();
        if (mostRecentBlock == null) {
            Block genesisBlock = new Block();
            genesisBlock.setHash(this.hashService.getHashForObject(genesisBlock));
            this.blockRepository.save(genesisBlock);
        }
    }

    public Block createBlock(HashMap<String, Object> data) {
        Block mostRecentBlock = this.blockRepository.findFirstByCreatedDateDesc();
        Block block = new Block();
        block.setData(data);
        block.setHash(this.hashService.getHashForObjectAndString(block, mostRecentBlock.getHash()));
        log.info("Block being created with hash: {}", block.getHash());
        return this.blockRepository.save(block);
    }
}
