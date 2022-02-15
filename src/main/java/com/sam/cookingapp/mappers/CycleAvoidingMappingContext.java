package com.sam.cookingapp.mappers;

import java.util.IdentityHashMap;
import java.util.Map;
import org.mapstruct.BeforeMapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.TargetType;

/**
 * @author HesamKarimian
 * @since 15/02/2022
 */
public class CycleAvoidingMappingContext {

  private Map<Object, Object> knownInstances = new IdentityHashMap<>();

  @BeforeMapping
  public <T> T getMappedInstance(Object source, @TargetType Class<T> targetType) {
    return (T) knownInstances.get(source);
  }

  @BeforeMapping
  public void storeMappedInstance(Object source, @MappingTarget Object target) {
    knownInstances.put(source, target);
  }
}
