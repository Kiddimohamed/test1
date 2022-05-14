package com.example.test1.dao;


import com.example.test1.bean.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TestDao extends JpaRepository<Test,Long> {
public  Test findByCode(String code);
}
