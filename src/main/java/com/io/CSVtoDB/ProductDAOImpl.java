package com.io.CSVtoDB;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductDAOImpl implements ProductDAO{

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public ProductDAOImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    final String INSERT_QUERY = "insert into product (Pid,Pname, Pprice) values (?, ?,?)";
    final String select_QUERY2 = "select * from product ";

    @Override
    public int save(Product product) {
        int test;
        test= jdbcTemplate.update(INSERT_QUERY,product.getPid(), product.getPname(), product.getPprice());
        return test;
    }

    @Override
    public void findall_1() {
        List products = jdbcTemplate.queryForList(select_QUERY2);
        System.out.println(products);

    }
}
