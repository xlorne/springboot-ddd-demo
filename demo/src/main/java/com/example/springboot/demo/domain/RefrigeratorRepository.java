package com.example.springboot.demo.domain;

public interface RefrigeratorRepository {

    Refrigerator loadSpace();

    void update(Refrigerator refrigerator);

    void truncate();

    void save(Refrigerator refrigerator);

}
