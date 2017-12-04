package com.simpl.app.repository;

import com.simpl.app.domain.Block;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlockRepository extends CrudRepository<Block, String> {
    Block findFirstByCreatedDateDesc();
}
