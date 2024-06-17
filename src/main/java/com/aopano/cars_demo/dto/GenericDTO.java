package com.aopano.cars_demo.dto;

public interface GenericDTO<E, D> {

    D map(E entity);

    E extract();
}
