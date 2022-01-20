package com.sam.cookingapp.mappers;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */
public interface BasicMapper<E, D> {

  D toDto(E entity);

  E toEntity(D dto);

}
