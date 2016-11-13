package com.example.ddd.infrastruct;

import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.generator.SourceCodeContext;
import ma.glasnost.orika.impl.generator.Specification;
import ma.glasnost.orika.impl.generator.VariableRef;
import ma.glasnost.orika.impl.generator.specification.AbstractSpecification;
import ma.glasnost.orika.metadata.FieldMap;

public class LazyLoadSpecification extends AbstractSpecification {
    private Specification delegate;

    public LazyLoadSpecification(Specification delegate) {

        this.delegate = delegate;

    }

    
    
    @Override
    public boolean appliesTo(FieldMap fieldMap) {
        return delegate.appliesTo(fieldMap);
    }

    @Override
    public String generateMappingCode(FieldMap fieldMap, VariableRef source, VariableRef destination,
            SourceCodeContext code) {
        StringBuilder sb = new StringBuilder();


        sb.append(String.format("if (%s instanceof org.hibernate.collection.internal.AbstractPersistentCollection) {\n", source));
        sb.append(String.format("    if (((org.hibernate.collection.internal.AbstractPersistentCollection)%s).wasInitialized()) {\n", source));
        sb.append(delegate.generateMappingCode(fieldMap, source, destination, code));
        sb.append("    }\n");
        sb.append("} else {\n");
        sb.append(delegate.generateMappingCode(fieldMap, source, destination, code));
        sb.append("}\n");

        System.out.println(sb.toString());

        return sb.toString();
    }

    @Override

    public void setMapperFactory(MapperFactory mapperFactory) {

        super.setMapperFactory(mapperFactory);

        delegate.setMapperFactory(mapperFactory);

    }

}