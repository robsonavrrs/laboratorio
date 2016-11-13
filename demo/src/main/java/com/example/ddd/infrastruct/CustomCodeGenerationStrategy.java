package com.example.ddd.infrastruct;

import ma.glasnost.orika.impl.DefaultCodeGenerationStrategy;
import ma.glasnost.orika.impl.generator.Specification;
import ma.glasnost.orika.impl.generator.specification.*;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Created by robson on 22/10/16.
 */
public class CustomCodeGenerationStrategy extends DefaultCodeGenerationStrategy {

    public CustomCodeGenerationStrategy() {
        super();
        List<Specification> specifications = new CopyOnWriteArrayList(Arrays.asList(
                new AbstractSpecification[]{new LazyLoadSpecification(new ConvertArrayOrCollectionToArray()),
                        new LazyLoadSpecification(new ConvertArrayOrCollectionToCollection()),
                        new Convert(),
                        new LazyLoadSpecification(new CopyByReference()),
                        new LazyLoadSpecification(new ApplyRegisteredMapper()),
                        new LazyLoadSpecification(new EnumToEnum()),
                        new LazyLoadSpecification(new StringToEnum()),
                        new LazyLoadSpecification(new UnmappableEnum()),
                        new LazyLoadSpecification(new ArrayOrCollectionToArray()),
                        new LazyLoadSpecification(new ArrayOrCollectionToCollection()),
                        new LazyLoadSpecification(new MapToMap()),
                        new LazyLoadSpecification(new MapToArray()),
                        new LazyLoadSpecification(new MapToCollection()),
                        new LazyLoadSpecification(new ArrayOrCollectionToMap()),
                        new LazyLoadSpecification(new StringToStringConvertible()),
                        new LazyLoadSpecification(new AnyTypeToString()),
                        new LazyLoadSpecification(new MultiOccurrenceElementToObject()),
                        new LazyLoadSpecification(new ObjectToMultiOccurrenceElement()),
                        new LazyLoadSpecification(new PrimitiveAndObject()),
                        new LazyLoadSpecification(new ObjectToObject())}));
        this.getSpecifications().clear();
        this.getSpecifications().addAll(specifications);
    }
}
