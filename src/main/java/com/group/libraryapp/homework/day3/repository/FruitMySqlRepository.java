package com.group.libraryapp.homework.day3.repository;

import com.group.libraryapp.homework.day3.dto.request.FruitCreateRequest;
import com.group.libraryapp.homework.day3.dto.response.FruitSalesStatusResponse;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.concurrent.atomic.AtomicLong;

@Repository
@Primary
@Qualifier("name")
public class FruitMySqlRepository implements FruitRepository{

    private final JdbcTemplate jdbcTemplate;

    public FruitMySqlRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void saveFruit(FruitCreateRequest request) {
        String sql = "insert into fruit(name, warehousingDate,price)values(?,?,?)";
        jdbcTemplate.update(sql, request.getName(), request.getWarehousingDate(), request.getPrice());
    }

    @Override
    public void saveSoldFruit(FruitCreateRequest request) {
        String readSql = "select * from fruit where id = ?";
        boolean isFruitNotExist = jdbcTemplate.query(readSql, (rs, rowNum) -> 0, request.getId()).isEmpty();
        if (isFruitNotExist) {
            throw new IllegalArgumentException();
        }
        String sql = "update fruit set is_sold = true where id = ?";
        jdbcTemplate.update(sql, request.getId());
    }

    @Override
    public FruitSalesStatusResponse readFruitStatus(String name) {
        String sql = "SELECT SUM(price) totalprice, is_sold FROM fruit where name = ? GROUP BY is_sold";
        AtomicLong totalAmount = new AtomicLong(0l);
        AtomicLong notSalesAmount = new AtomicLong(0l);
        jdbcTemplate.query(sql, new Object[]{name}, (rs, rowNum) -> {
            boolean is_sold = rs.getBoolean("is_sold");
            long totalprice = rs.getLong("totalprice");

            if (is_sold) {
                totalAmount.addAndGet(totalprice);
            } else {
                notSalesAmount.addAndGet(totalprice);
            }
            return null;
        });
        return new FruitSalesStatusResponse(totalAmount.get(), notSalesAmount.get());
    }
}
