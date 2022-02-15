package com.sam.cookingapp.mappers;

import org.mapstruct.Context;

/**
 * @author HesamKarimian
 * @since 20/01/2022
 */
public interface BasicMapper<E, D> {

  D toDto(E entity, @Context CycleAvoidingMappingContext context);

  E toEntity(D dto, @Context CycleAvoidingMappingContext context);

}
