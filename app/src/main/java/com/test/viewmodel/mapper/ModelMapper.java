package com.test.viewmodel.mapper;

/**
 * Generic Model which maps one object to another.
 * @param <S> object which needs to be mapped.
 * @param <D> object in which the source obejct will be mapped.
 */

public interface ModelMapper<S,D> {

    D mapsTo(S source);
}
