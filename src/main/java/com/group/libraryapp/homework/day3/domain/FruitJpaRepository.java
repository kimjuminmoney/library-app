package com.group.libraryapp.homework.day3.domain;

import com.group.libraryapp.homework.day3.dto.response.FruitUnSoldOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FruitJpaRepository extends JpaRepository<Fruit,Long> {


    List<Fruit>  findByNameAndIsSold(String name, boolean is_Sold);


    long countByName(String name);

    List<FruitUnSoldOption> findByPriceGreaterThanEqualAndIsSold(final long price, boolean is_Sold);

    List<FruitUnSoldOption> findByPriceLessThanEqualAndIsSold(final long price, boolean is_Sold);

}
