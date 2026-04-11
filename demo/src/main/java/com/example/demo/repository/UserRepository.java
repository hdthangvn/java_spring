package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.user.UserEntity;

import jakarta.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

// annatation
// @RepositoryDefinition(domainClass = UserEntity.class, idClass = Long.class)
public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaSpecificationExecutor<UserEntity> {

    UserEntity findByUserNameAndEmail(String userName, String userEmail);

    UserEntity findByUserName(String userName);

    List<UserEntity> findByUserNameStartingWith(String userName);

    List<UserEntity> findByUserNameEndingWith(String userEmail);

    List<UserEntity> findByIdLessThan(Long id);

    // RAW JPQL
    @Query("SELECT u FROM UserEntity u WHERE u.id = (SELECT MAX(id) FROM UserEntity p)")
    UserEntity findMaxIdUser();

    @Query("SELECT u FROM UserEntity u WHERE u.userName = ?1 AND u.userEmail = ?2")
    List<UserEntity> getUserEntityBy(String userName, String userEmail);

    @Modifying
    @Query("UPDATE UserEntity u SET u.userEmail = :userName")
    @Transactional
    int updateUserName(@Param("userName") String userName);

    // native query, example: get count user use native query
    @Query(value = "SELECT COUNT(id) FROM java_user_001", nativeQuery = true)
    long getTotalUser();

}