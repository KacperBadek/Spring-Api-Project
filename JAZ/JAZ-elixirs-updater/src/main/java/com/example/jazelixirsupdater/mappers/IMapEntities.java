package com.example.jazelixirsupdater.mappers;

public interface IMapEntities<TDto, TEntity> {
    TEntity map(TDto dto);

    TEntity map(TDto dto, TEntity entity);
}
