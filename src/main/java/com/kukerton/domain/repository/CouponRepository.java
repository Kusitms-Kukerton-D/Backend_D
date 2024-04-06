package com.kukerton.domain.repository;

import com.kukerton.domain.entity.Coupon;
import java.time.LocalDate;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("select c from Coupon c where c.member.id = :memberId and c.endDate >= :endDate")
    List<Coupon> getcoupons(@Param("memberId") Long memberId,
        @Param("endDate") LocalDate localDate);

    @Query("select count(c) from Coupon c where c.member.id = :memberId")
    Integer getCouponCount(@Param("memberId") Long memberId);

    Coupon findByStoreId(Long store_id);
}
