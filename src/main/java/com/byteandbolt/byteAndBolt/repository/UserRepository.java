package com.byteandbolt.byteAndBolt.repository;

import com.byteandbolt.byteAndBolt.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
}
