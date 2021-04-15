package com.example.demo.mapper;

import com.example.demo.model.Rateplans;
import com.example.demo.model.Todo;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-14T21:13:12+0700",
    comments = "version: 1.4.2.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-6.8.3.jar, environment: Java 14.0.2 (Oracle Corporation)"
)
@Component
public class RatePlanMapperImpl implements RatePlanMapper {

    @Override
    public Rateplans toDoToratePlans(Todo todo) {
        if ( todo == null ) {
            return null;
        }

        Rateplans rateplans = new Rateplans();

        rateplans.setId( todo.getId() );
        rateplans.setName( todo.getDescription() );
        rateplans.setDeleted( todo.isCompleted() );
        rateplans.setCreated( todo.getCreated() );
        rateplans.setModified( todo.getModified() );

        return rateplans;
    }

    @Override
    public List<Rateplans> toDoToratePlans(List<Todo> todo) {
        if ( todo == null ) {
            return null;
        }

        List<Rateplans> list = new ArrayList<Rateplans>( todo.size() );
        for ( Todo todo1 : todo ) {
            list.add( toDoToratePlans( todo1 ) );
        }

        return list;
    }

    @Override
    public Todo ratePlansToToDo(Rateplans ratePlans) {
        if ( ratePlans == null ) {
            return null;
        }

        Todo todo = new Todo();

        todo.setId( ratePlans.getId() );
        todo.setDescription( ratePlans.getName() );
        todo.setCompleted( ratePlans.isDeleted() );
        todo.setCreated( ratePlans.getCreated() );
        todo.setModified( ratePlans.getModified() );

        return todo;
    }

    @Override
    public List<Todo> ratePlansToToDo(List<Rateplans> ratePlans) {
        if ( ratePlans == null ) {
            return null;
        }

        List<Todo> list = new ArrayList<Todo>( ratePlans.size() );
        for ( Rateplans rateplans : ratePlans ) {
            list.add( ratePlansToToDo( rateplans ) );
        }

        return list;
    }
}
