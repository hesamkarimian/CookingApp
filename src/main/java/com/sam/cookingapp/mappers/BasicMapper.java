package com.sam.cookingapp.mappers;

import org.mapstruct.Context;

import java.util.Collection;
import java.util.List;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */
public interface BasicMapper<E, D> {

  D toDto(E entity, @Context CycleAvoidingMappingContext context);

  E toEntity(D dto, @Context CycleAvoidingMappingContext context);

  List<D> toDto(Collection<E> entityList, @Context CycleAvoidingMappingContext context);

  List<E> toEntity(Collection<D> dtoList, @Context CycleAvoidingMappingContext context);

}
