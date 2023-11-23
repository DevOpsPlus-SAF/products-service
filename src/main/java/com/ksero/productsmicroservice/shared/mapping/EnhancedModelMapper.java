package com.ksero.productsmicroservice.shared.mapping;

import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public class EnhancedModelMapper extends ModelMapper {
    public EnhancedModelMapper() {
        super();
    }

    public <Source, Target> List<Target> mapList(List<Source> sourceList, Class<Target> targetClass) {
        return sourceList.stream().map((sourceItem) -> map(sourceItem, targetClass)).collect(Collectors.toList());
    }
}
