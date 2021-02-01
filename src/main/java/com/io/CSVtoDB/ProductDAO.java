package com.io.CSVtoDB;

import org.springframework.stereotype.Repository;

@Repository
public interface ProductDAO {

    public int save(Product product);

    void findall_1();
}
