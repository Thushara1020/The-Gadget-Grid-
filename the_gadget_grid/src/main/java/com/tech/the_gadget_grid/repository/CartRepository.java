package com.tech.the_gadget_grid.repository;

import com.tech.the_gadget_grid.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    @Query("SELECT c FROM Cart c JOIN FETCH c.user JOIN FETCH c.product WHERE c.user.userId = :userId")
    List<Cart> findByUser_UserId(@Param("userId") Long userId);
}