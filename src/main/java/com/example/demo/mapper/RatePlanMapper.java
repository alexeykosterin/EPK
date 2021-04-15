package com.example.demo.mapper;

import com.example.demo.model.Rateplans;
import com.example.demo.model.Todo;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;


@Mapper(config = IgnoreUnmappedMapperConfig.class, componentModel = "spring")
public interface RatePlanMapper {
    RatePlanMapper MAPPER = Mappers.getMapper( RatePlanMapper.class );
    @Mappings({
            @Mapping(source = "id", target="id"),
            @Mapping(source = "description", target="name"),
            @Mapping(source = "completed", target="deleted")/*,
            @Mapping(target = "created", ignore = true),
            @Mapping(target = "modified", ignore = true)*/
            /*@Mapping(target="employeeStartDt", source = "entity.startDt",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")*/})
    Rateplans toDoToratePlans(Todo todo);
    List<Rateplans> toDoToratePlans(List<Todo> todo);

    @Mappings({
            @Mapping(source = "id", target="id"),
            @Mapping(source = "name", target="description"),
            @Mapping(source = "deleted", target="completed"),
            /*@Mapping(target="employeeStartDt", source = "entity.startDt",
                    dateFormat = "dd-MM-yyyy HH:mm:ss")*/})
    Todo ratePlansToToDo(Rateplans ratePlans);
    List<Todo> ratePlansToToDo(List<Rateplans> ratePlans);
}